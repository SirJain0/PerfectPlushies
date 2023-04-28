package sirjain;

import net.fabricmc.api.ModInitializer;
import sirjain.util.PlushieBlockRegistries;

public class PerfectPlushiesMain implements ModInitializer {
	public static final String MOD_ID = "perfectplushies";

	@Override
	public void onInitialize() {
		System.out.println("Initializing Perfect Plushies!");
		PlushieBlockRegistries.registerPlushieBlocks();
		PlushieBlockRegistries.registerPlushieBlockItems();
		PlushieBlockRegistries.addItemsToTabs();
	}
}