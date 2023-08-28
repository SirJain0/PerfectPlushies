package io.github.sirjain0.perfectplushies.entity.spawning;

import io.github.sirjain0.perfectplushies.api.PlushieTraderLevelData;
import io.github.sirjain0.perfectplushies.config.CommonConfig;
import io.github.sirjain0.perfectplushies.entity.WanderingPlushieTrader;
import io.github.sirjain0.perfectplushies.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.ServerLevelData;

import javax.annotation.Nullable;
import java.util.Optional;

public class WanderingPlushieTraderSpawner implements CustomSpawner {
    private final RandomSource random = RandomSource.create();
    private final ServerLevelData serverLevelData;
    private int tickDelay;
    private int spawnDelay;
    private int spawnChance;

    public WanderingPlushieTraderSpawner(ServerLevelData pServerLevelData) {
        this.serverLevelData = pServerLevelData;
        this.tickDelay = CommonConfig.INSTANCE.TRADER_DEFAULT_TICK_DELAY.get();
        this.spawnDelay = ((PlushieTraderLevelData) pServerLevelData).getWanderingPlushieTraderSpawnDelay();
        this.spawnChance = ((PlushieTraderLevelData) pServerLevelData).getWanderingPlushieTraderSpawnChance();
        if (this.spawnDelay == 0 && this.spawnChance == 0) {
            this.spawnDelay = CommonConfig.INSTANCE.TRADER_DEFAULT_SPAWN_DELAY.get();
            ((PlushieTraderLevelData) pServerLevelData).setWanderingPlushieTraderSpawnDelay(this.spawnDelay);
            this.spawnChance = CommonConfig.INSTANCE.TRADER_MIN_SPAWN_CHANCE.get();
            ((PlushieTraderLevelData) pServerLevelData).setWanderingPlushieTraderSpawnChance(this.spawnChance);
        }

    }

    public int tick(ServerLevel pLevel, boolean pSpawnHostiles, boolean pSpawnPassives) {
        if (!pLevel.getGameRules().getBoolean(GameRules.RULE_DO_TRADER_SPAWNING)) {
            return 0;
        } else if (--this.tickDelay > 0) {
            return 0;
        } else {
            this.tickDelay = CommonConfig.INSTANCE.TRADER_DEFAULT_TICK_DELAY.get();
            this.spawnDelay -= CommonConfig.INSTANCE.TRADER_DEFAULT_TICK_DELAY.get();
            ((PlushieTraderLevelData) this.serverLevelData).setWanderingPlushieTraderSpawnDelay(this.spawnDelay);
            if (this.spawnDelay > 0) {
                return 0;
            } else {
                this.spawnDelay = CommonConfig.INSTANCE.TRADER_DEFAULT_SPAWN_DELAY.get();
                if (!pLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                    return 0;
                } else {
                    int i = this.spawnChance;
                    this.spawnChance = Mth.clamp(this.spawnChance + CommonConfig.INSTANCE.TRADER_SPAWN_CHANCE_INCREASE.get(), CommonConfig.INSTANCE.TRADER_MIN_SPAWN_CHANCE.get(), CommonConfig.INSTANCE.TRADER_MAX_SPAWN_CHANCE.get());
                    ((PlushieTraderLevelData) this.serverLevelData).setWanderingPlushieTraderSpawnChance(this.spawnChance);
                    if (this.random.nextInt(100) > i) {
                        return 0;
                    } else if (this.spawn(pLevel)) {
                        this.spawnChance = CommonConfig.INSTANCE.TRADER_MIN_SPAWN_CHANCE.get();
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    private boolean spawn(ServerLevel pServerLevel) {
        Player player = pServerLevel.getRandomPlayer();
        if (player == null) {
            return true;
        } else if (this.random.nextInt(CommonConfig.INSTANCE.TRADER_SPAWN_ONE_IN_X_CHANCE.get()) != 0) {
            return false;
        } else {
            BlockPos blockpos = player.blockPosition();
            int i = 48;
            PoiManager poimanager = pServerLevel.getPoiManager();
            Optional<BlockPos> optional = poimanager.find((p_219713_) -> p_219713_.is(PoiTypes.MEETING), (p_219711_) -> true, blockpos, 48, PoiManager.Occupancy.ANY);
            BlockPos blockpos1 = optional.orElse(blockpos);
            BlockPos blockpos2 = this.findSpawnPositionNear(pServerLevel, blockpos1, 48);
            if (blockpos2 != null && this.hasEnoughSpace(pServerLevel, blockpos2)) {
                if (pServerLevel.getBiome(blockpos2).is(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS)) {
                    return false;
                }

                WanderingPlushieTrader wanderingtrader = EntityInit.WANDERING_PLUSHIH_TRADER.get().spawn(pServerLevel, blockpos2, MobSpawnType.EVENT);
                if (wanderingtrader != null) {
//               for(int j = 0; j < 2; ++j) {
//                  this.tryToSpawnLlamaFor(pServerLevel, wanderingtrader, 4);
//               }
                    this.serverLevelData.setWanderingTraderId(wanderingtrader.getUUID());
                    wanderingtrader.setDespawnDelay(48000);
                    wanderingtrader.setWanderTarget(blockpos1);
                    wanderingtrader.restrictTo(blockpos1, 16);
                    return true;
                }
            }

            return false;
        }
    }

//   private void tryToSpawnLlamaFor(ServerLevel pServerLevel, WanderingTrader pTrader, int pMaxDistance) {
//      BlockPos blockpos = this.findSpawnPositionNear(pServerLevel, pTrader.blockPosition(), pMaxDistance);
//      if (blockpos != null) {
//         TraderLlama traderllama = EntityType.TRADER_LLAMA.spawn(pServerLevel, blockpos, MobSpawnType.EVENT);
//         if (traderllama != null) {
//            traderllama.setLeashedTo(pTrader, true);
//         }
//      }
//   }

    @Nullable
    private BlockPos findSpawnPositionNear(LevelReader pLevel, BlockPos pPos, int pMaxDistance) {
        BlockPos blockpos = null;

        for (int i = 0; i < CommonConfig.INSTANCE.TRADER_NUMBER_OF_SPAWN_ATTEMPTS.get(); ++i) {
            int j = pPos.getX() + this.random.nextInt(pMaxDistance * 2) - pMaxDistance;
            int k = pPos.getZ() + this.random.nextInt(pMaxDistance * 2) - pMaxDistance;
            int l = pLevel.getHeight(Heightmap.Types.WORLD_SURFACE, j, k);
            BlockPos blockpos1 = new BlockPos(j, l, k);
            if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, pLevel, blockpos1, EntityType.WANDERING_TRADER)) {
                blockpos = blockpos1;
                break;
            }
        }

        return blockpos;
    }

    private boolean hasEnoughSpace(BlockGetter pLevel, BlockPos pPos) {
        for (BlockPos blockpos : BlockPos.betweenClosed(pPos, pPos.offset(1, 2, 1))) {
            if (!pLevel.getBlockState(blockpos).getCollisionShape(pLevel, blockpos).isEmpty()) {
                return false;
            }
        }

        return true;
    }
}