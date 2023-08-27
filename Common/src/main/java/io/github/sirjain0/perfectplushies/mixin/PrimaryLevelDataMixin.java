package io.github.sirjain0.perfectplushies.mixin;

import io.github.sirjain0.perfectplushies.api.PlushieTraderLevelData;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(PrimaryLevelData.class)
public class PrimaryLevelDataMixin implements PlushieTraderLevelData {

    @Unique
    private int perfectPlushies$plushieTraderSpawnDelay;
    @Unique
    private int perfectPlushies$plushieTraderSpawnChance;
    @Unique
    private UUID perfectPlushies$plushieTraderId;

    @Inject(method = "setTagData", at = @At("TAIL"))
    private void setPlushieTraderData(RegistryAccess pRegistry, CompoundTag pNbt, @javax.annotation.Nullable CompoundTag pPlayerNBT, CallbackInfo ci) {
        pNbt.putInt("PlushieTraderSpawnDelay", this.perfectPlushies$plushieTraderSpawnDelay);
        pNbt.putInt("PlushieTraderSpawnChance", this.perfectPlushies$plushieTraderSpawnChance);
        if (this.perfectPlushies$plushieTraderId != null) {
            pNbt.putUUID("PlushieTraderId", this.perfectPlushies$plushieTraderId);
        }
    }

    @Override
    public int getWanderingPlushieTraderSpawnDelay() {
        return this.perfectPlushies$plushieTraderSpawnDelay;
    }

    @Override
    public void setWanderingPlushieTraderSpawnDelay(int $$0) {
        this.perfectPlushies$plushieTraderSpawnDelay = $$0;
    }

    @Override
    public int getWanderingPlushieTraderSpawnChance() {
        return this.perfectPlushies$plushieTraderSpawnChance;
    }

    @Override
    public void setWanderingPlushieTraderSpawnChance(int $$0) {
        this.perfectPlushies$plushieTraderSpawnChance = $$0;
    }

    @Nullable
    @Override
    public UUID getWanderingPlushieTraderId() {
        return this.perfectPlushies$plushieTraderId;
    }

    @Override
    public void setWanderingPlushieTraderId(UUID $$0) {
        this.perfectPlushies$plushieTraderId = $$0;
    }
}
