package net.mcreator.auger.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.auger.AugerMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AugerModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		AugerMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		AugerMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.player_surgery_brain = original.player_surgery_brain;
			clone.player_surgery_torso5 = original.player_surgery_torso5;
			clone.player_surgery_torso1 = original.player_surgery_torso1;
			clone.player_surgery_skin = original.player_surgery_skin;
			clone.player_surgery_eye = original.player_surgery_eye;
			clone.player_surgery_head = original.player_surgery_head;
			clone.player_surgery_arm1 = original.player_surgery_arm1;
			clone.player_surgery_arm2 = original.player_surgery_arm2;
			clone.player_surgery_leg1 = original.player_surgery_leg1;
			clone.player_surgery_leg2 = original.player_surgery_leg2;
			clone.player_surgery_torso2 = original.player_surgery_torso2;
			clone.player_surgery_torso3 = original.player_surgery_torso3;
			clone.player_surgery_torso4 = original.player_surgery_torso4;
			clone.player_surgery_torso6 = original.player_surgery_torso6;
			clone.player_hasjoined = original.player_hasjoined;
			clone.player_bandwidth_consumed = original.player_bandwidth_consumed;
			if (!event.isWasDeath()) {
				clone.player_ability_cooldown = original.player_ability_cooldown;
				clone.player_isanesthetized = original.player_isanesthetized;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					AugerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					AugerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					AugerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "auger_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				AugerMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "auger_mapvars";
		public double lag_timer = 0.0;
		public boolean engine_active = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			lag_timer = nbt.getDouble("lag_timer");
			engine_active = nbt.getBoolean("engine_active");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("lag_timer", lag_timer);
			nbt.putBoolean("engine_active", engine_active);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				AugerMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("auger", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public ItemStack player_surgery_brain = ItemStack.EMPTY;
		public ItemStack player_surgery_torso5 = ItemStack.EMPTY;
		public ItemStack player_surgery_torso1 = ItemStack.EMPTY;
		public ItemStack player_surgery_skin = ItemStack.EMPTY;
		public ItemStack player_surgery_eye = ItemStack.EMPTY;
		public ItemStack player_surgery_head = ItemStack.EMPTY;
		public ItemStack player_surgery_arm1 = ItemStack.EMPTY;
		public ItemStack player_surgery_arm2 = ItemStack.EMPTY;
		public ItemStack player_surgery_leg1 = ItemStack.EMPTY;
		public ItemStack player_surgery_leg2 = ItemStack.EMPTY;
		public ItemStack player_surgery_torso2 = ItemStack.EMPTY;
		public ItemStack player_surgery_torso3 = ItemStack.EMPTY;
		public ItemStack player_surgery_torso4 = ItemStack.EMPTY;
		public ItemStack player_surgery_torso6 = ItemStack.EMPTY;
		public boolean player_hasjoined = false;
		public double player_ability_cooldown = 0.0;
		public boolean player_isanesthetized = false;
		public double player_bandwidth_consumed = 0.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				AugerMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.put("player_surgery_brain", player_surgery_brain.save(new CompoundTag()));
			nbt.put("player_surgery_torso5", player_surgery_torso5.save(new CompoundTag()));
			nbt.put("player_surgery_torso1", player_surgery_torso1.save(new CompoundTag()));
			nbt.put("player_surgery_skin", player_surgery_skin.save(new CompoundTag()));
			nbt.put("player_surgery_eye", player_surgery_eye.save(new CompoundTag()));
			nbt.put("player_surgery_head", player_surgery_head.save(new CompoundTag()));
			nbt.put("player_surgery_arm1", player_surgery_arm1.save(new CompoundTag()));
			nbt.put("player_surgery_arm2", player_surgery_arm2.save(new CompoundTag()));
			nbt.put("player_surgery_leg1", player_surgery_leg1.save(new CompoundTag()));
			nbt.put("player_surgery_leg2", player_surgery_leg2.save(new CompoundTag()));
			nbt.put("player_surgery_torso2", player_surgery_torso2.save(new CompoundTag()));
			nbt.put("player_surgery_torso3", player_surgery_torso3.save(new CompoundTag()));
			nbt.put("player_surgery_torso4", player_surgery_torso4.save(new CompoundTag()));
			nbt.put("player_surgery_torso6", player_surgery_torso6.save(new CompoundTag()));
			nbt.putBoolean("player_hasjoined", player_hasjoined);
			nbt.putDouble("player_ability_cooldown", player_ability_cooldown);
			nbt.putBoolean("player_isanesthetized", player_isanesthetized);
			nbt.putDouble("player_bandwidth_consumed", player_bandwidth_consumed);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			player_surgery_brain = ItemStack.of(nbt.getCompound("player_surgery_brain"));
			player_surgery_torso5 = ItemStack.of(nbt.getCompound("player_surgery_torso5"));
			player_surgery_torso1 = ItemStack.of(nbt.getCompound("player_surgery_torso1"));
			player_surgery_skin = ItemStack.of(nbt.getCompound("player_surgery_skin"));
			player_surgery_eye = ItemStack.of(nbt.getCompound("player_surgery_eye"));
			player_surgery_head = ItemStack.of(nbt.getCompound("player_surgery_head"));
			player_surgery_arm1 = ItemStack.of(nbt.getCompound("player_surgery_arm1"));
			player_surgery_arm2 = ItemStack.of(nbt.getCompound("player_surgery_arm2"));
			player_surgery_leg1 = ItemStack.of(nbt.getCompound("player_surgery_leg1"));
			player_surgery_leg2 = ItemStack.of(nbt.getCompound("player_surgery_leg2"));
			player_surgery_torso2 = ItemStack.of(nbt.getCompound("player_surgery_torso2"));
			player_surgery_torso3 = ItemStack.of(nbt.getCompound("player_surgery_torso3"));
			player_surgery_torso4 = ItemStack.of(nbt.getCompound("player_surgery_torso4"));
			player_surgery_torso6 = ItemStack.of(nbt.getCompound("player_surgery_torso6"));
			player_hasjoined = nbt.getBoolean("player_hasjoined");
			player_ability_cooldown = nbt.getDouble("player_ability_cooldown");
			player_isanesthetized = nbt.getBoolean("player_isanesthetized");
			player_bandwidth_consumed = nbt.getDouble("player_bandwidth_consumed");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.player_surgery_brain = message.data.player_surgery_brain;
					variables.player_surgery_torso5 = message.data.player_surgery_torso5;
					variables.player_surgery_torso1 = message.data.player_surgery_torso1;
					variables.player_surgery_skin = message.data.player_surgery_skin;
					variables.player_surgery_eye = message.data.player_surgery_eye;
					variables.player_surgery_head = message.data.player_surgery_head;
					variables.player_surgery_arm1 = message.data.player_surgery_arm1;
					variables.player_surgery_arm2 = message.data.player_surgery_arm2;
					variables.player_surgery_leg1 = message.data.player_surgery_leg1;
					variables.player_surgery_leg2 = message.data.player_surgery_leg2;
					variables.player_surgery_torso2 = message.data.player_surgery_torso2;
					variables.player_surgery_torso3 = message.data.player_surgery_torso3;
					variables.player_surgery_torso4 = message.data.player_surgery_torso4;
					variables.player_surgery_torso6 = message.data.player_surgery_torso6;
					variables.player_hasjoined = message.data.player_hasjoined;
					variables.player_ability_cooldown = message.data.player_ability_cooldown;
					variables.player_isanesthetized = message.data.player_isanesthetized;
					variables.player_bandwidth_consumed = message.data.player_bandwidth_consumed;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
