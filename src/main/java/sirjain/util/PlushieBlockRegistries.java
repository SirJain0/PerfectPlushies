package sirjain.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.PerfectPlushiesMain;
import sirjain.plushie_variants.SwiftPlushieBlock;

public class PlushieBlockRegistries {
	// Block variables
	public static Block FOX_PLUSHIE;

	// Item variables
	public static Item FOX_PLUSHIE_BLOCK_ITEM;

	public static void registerPlushieBlocks() {
		FOX_PLUSHIE = Registry.register(
			Registries.BLOCK,
			new Identifier(PerfectPlushiesMain.MOD_ID, "fox_plushie"),
			new SwiftPlushieBlock()
		);
	}

	public static void registerPlushieBlockItems() {
		FOX_PLUSHIE_BLOCK_ITEM = Registry.register(
			Registries.ITEM,
			new Identifier(PerfectPlushiesMain.MOD_ID, "fox_plushie"),
			new BlockItem(FOX_PLUSHIE, new Item.Settings())
		);
	}

	public static void addItemsToTabs() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.add(FOX_PLUSHIE_BLOCK_ITEM);
		});
	}
}