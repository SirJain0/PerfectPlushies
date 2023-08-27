package io.github.sirjain0.perfectplushies.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CommonConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final CommonConfig INSTANCE;

    static {
        Pair<CommonConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        CONFIG_SPEC = pair.getRight();
        INSTANCE = pair.getLeft();
    }

    public final ForgeConfigSpec.IntValue TRADER_DEFAULT_TICK_DELAY;
    public final ForgeConfigSpec.IntValue TRADER_DEFAULT_SPAWN_DELAY;
    public final ForgeConfigSpec.IntValue TRADER_DEFAULT_SPAWN_CHANCE;
    public final ForgeConfigSpec.IntValue TRADER_MIN_SPAWN_CHANCE;
    public final ForgeConfigSpec.IntValue TRADER_MAX_SPAWN_CHANCE;
    public final ForgeConfigSpec.IntValue TRADER_SPAWN_CHANCE_INCREASE;
    public final ForgeConfigSpec.IntValue TRADER_SPAWN_ONE_IN_X_CHANCE;
    public final ForgeConfigSpec.IntValue TRADER_NUMBER_OF_SPAWN_ATTEMPTS;

    private CommonConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Perfect Plushies Common Config");
        builder.push("Wandering Plushie Trader Config");
        this.TRADER_DEFAULT_TICK_DELAY = builder.comment("How long to wait to try and spawn after server starts").defineInRange("trader-default-tick-delay", 1200, 0, 10000);
        this.TRADER_DEFAULT_SPAWN_DELAY = builder.comment("Ticks between attempting to spawn").defineInRange("trader-default-spawn-delay", 24000, 0, 1000000);
        this.TRADER_DEFAULT_SPAWN_CHANCE = builder.comment("Starting chance to attempt to spawn").defineInRange("trader-default-spawn-chance", 25, 0, 100);
        this.TRADER_MIN_SPAWN_CHANCE = builder.comment("Minimum Chance to attempt to spawn").defineInRange("trader-min-spawn-chance", 25, 0, 100);
        this.TRADER_MAX_SPAWN_CHANCE = builder.comment("Maximum Chance to attempt to spawn").defineInRange("trader-max-spawn-chance", 75, 0, 100);
        this.TRADER_SPAWN_CHANCE_INCREASE = builder.comment("Amount to change the Attempt Chance on Attempt Failure").defineInRange("trader-spawn-chance-increase", 25, -100, 100);
        this.TRADER_SPAWN_ONE_IN_X_CHANCE = builder.comment("Actual spawn chance when attempt succeeds").defineInRange("trader-spawn-one-in-x-chance", 10, 1, 100);
        this.TRADER_NUMBER_OF_SPAWN_ATTEMPTS = builder.comment("On spawn Failure, how many times to re-attempt spawning(basically if it tries spawning where it can't spawn, try again somewhere else) ").defineInRange("trader-number-of-spawn-attempts", 10, 0, 100);
        builder.pop();
        builder.pop();
    }
}
