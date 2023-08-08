package io.github.sirjain0.perfectplushies;

import net.fabricmc.api.ModInitializer;

public class PerfectPlushies implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonClass.init();
        PlushiesLootTableModifier.modifyLootTables();
    }
}
