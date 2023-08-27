package io.github.sirjain0.perfectplushies.mixin;


import io.github.sirjain0.perfectplushies.entity.spawning.WanderingPlushieTraderSpawner;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.RandomSequences;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {

    @Mutable
    @Shadow @Final public List<CustomSpawner> customSpawners;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void addPlushieMerchant(MinecraftServer server, Executor executor, LevelStorageSource.LevelStorageAccess levelStorageAccess, ServerLevelData serverLevelData, ResourceKey resourceKey, LevelStem levelStem, ChunkProgressListener chunkProgressListener, boolean isdDebug, long biomezoomseed, List customspawners, boolean tickTime, RandomSequences randomSequences, CallbackInfo ci){
        List<CustomSpawner> spawnList = new ArrayList<>();
        spawnList.addAll(this.customSpawners);
        spawnList.add(new WanderingPlushieTraderSpawner(server.getWorldData().overworldData()));
        this.customSpawners =  spawnList;
    }
}
