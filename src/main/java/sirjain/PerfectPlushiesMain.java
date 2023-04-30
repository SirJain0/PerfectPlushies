package sirjain;

import net.fabricmc.api.ModInitializer;
import sirjain.blocks.util.PlushieBlockRegistries;
import sirjain.loot_tables.PlushiesLootTableModifier;

public class PerfectPlushiesMain implements ModInitializer {
	public static final String MOD_ID = "perfectplushies";

	@Override
	public void onInitialize() {
		System.out.println("Initializing Perfect Plushies!");
		PlushieBlockRegistries.registerPlushieBlocks();
		PlushieBlockRegistries.registerPlushieBlockItems();
		PlushieBlockRegistries.addItemsToTabs();
		PlushiesLootTableModifier.modifyLootTables();
	}
}