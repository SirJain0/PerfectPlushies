package io.github.sirjain0.perfectplushies.api;

import javax.annotation.Nullable;
import java.util.UUID;

public interface PlushieTraderLevelData {
    int getWanderingPlushieTraderSpawnDelay();

    void setWanderingPlushieTraderSpawnDelay(int $$0);

    int getWanderingPlushieTraderSpawnChance();

    void setWanderingPlushieTraderSpawnChance(int $$0);

    @Nullable
    UUID getWanderingPlushieTraderId();

    void setWanderingPlushieTraderId(UUID $$0);
}
