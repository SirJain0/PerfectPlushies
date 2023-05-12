package sirjain.blocks.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.PerfectPlushiesMain;

public class PlushieBlockRegistries {
	// Block variables
	public static Block FOX_PLUSHIE;
	public static Block DOLPHIN_PLUSHIE;
	public static Block RABBIT_PLUSHIE;
	public static Block FROG_PLUSHIE;

	// Item variables
	public static Item FOX_PLUSHIE_BLOCK_ITEM;
	public static Item DOLPHIN_PLUSHIE_BLOCK_ITEM;
	public static Item RABBIT_PLUSHIE_BLOCK_ITEM;
	public static Item FROG_PLUSHIE_BLOCK_ITEM;

	public static void registerPlushieBlocks() {
		FOX_PLUSHIE = Registry.register(
			Registries.BLOCK,
			new Identifier(PerfectPlushiesMain.MOD_ID, "fox_plushie"),
			new AbstractPlushieBlock()
		);

		DOLPHIN_PLUSHIE = Registry.register(
			Registries.BLOCK,
			new Identifier(PerfectPlushiesMain.MOD_ID, "dolphin_plushie"),
			new AbstractPlushieBlock()
		);

		RABBIT_PLUSHIE = Registry.register(
			Registries.BLOCK,
			new Identifier(PerfectPlushiesMain.MOD_ID, "rabbit_plushie"),
			new AbstractPlushieBlock()
		);

		FROG_PLUSHIE = Registry.register(
			Registries.BLOCK,
			new Identifier(PerfectPlushiesMain.MOD_ID, "frog_plushie"),
			new AbstractPlushieBlock()
		);
	}

	public static void registerPlushieBlockItems() {
		FOX_PLUSHIE_BLOCK_ITEM = Registry.register(
			Registries.ITEM,
			new Identifier(PerfectPlushiesMain.MOD_ID, "fox_plushie"),
			new BlockItem(FOX_PLUSHIE, new Item.Settings())
		);

		DOLPHIN_PLUSHIE_BLOCK_ITEM = Registry.register(
			Registries.ITEM,
			new Identifier(PerfectPlushiesMain.MOD_ID, "dolphin_plushie"),
			new BlockItem(DOLPHIN_PLUSHIE, new Item.Settings())
		);

		RABBIT_PLUSHIE_BLOCK_ITEM = Registry.register(
			Registries.ITEM,
			new Identifier(PerfectPlushiesMain.MOD_ID, "rabbit_plushie"),
			new BlockItem(RABBIT_PLUSHIE, new Item.Settings())
		);

		FROG_PLUSHIE_BLOCK_ITEM = Registry.register(
			Registries.ITEM,
			new Identifier(PerfectPlushiesMain.MOD_ID, "frog_plushie"),
			new BlockItem(FROG_PLUSHIE, new Item.Settings())
		);
	}

	public static void addItemsToTabs() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.add(FOX_PLUSHIE_BLOCK_ITEM);
			entries.add(DOLPHIN_PLUSHIE_BLOCK_ITEM);
			entries.add(RABBIT_PLUSHIE_BLOCK_ITEM);
			entries.add(FROG_PLUSHIE_BLOCK_ITEM);
		});
	}
}