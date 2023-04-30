package sirjain.loot_tables;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import sirjain.blocks.util.PlushieBlockRegistries;

public class PlushiesLootTableModifier {
	public static Identifier VILLAGE_IDENTIFIER;
	public static final Item[] plushies = new Item[] {
		PlushieBlockRegistries.FOX_PLUSHIE_BLOCK_ITEM,
		PlushieBlockRegistries.DOLPHIN_PLUSHIE_BLOCK_ITEM,
		PlushieBlockRegistries.RABBIT_PLUSHIE_BLOCK_ITEM
	};

	public static final String[] villageVariants = new String[] {
		"village_armorer",
		"village_butcher",
		"village_cartographer",
		"village_desert_house",
		"village_fisher",
		"village_fletcher",
		"village_mason",
		"village_plains_house",
		"village_savanna_house",
		"village_shepherd",
		"village_snowy_house",
		"village_taiga_house",
		"village_tannery",
		"village_temple",
		"village_toolsmith",
		"village_weaponsmith",
	};

	public static void modifyLootTables() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			VILLAGE_IDENTIFIER = null;

			for (String village : villageVariants) {
				VILLAGE_IDENTIFIER = new Identifier("minecraft", "chests/village/" + village);

				for (Item plushie : plushies) {
					if (VILLAGE_IDENTIFIER.equals(id)) {
						LootPool.Builder poolBuilder = LootPool.builder()
							.rolls(ConstantLootNumberProvider.create(1))
							.conditionally(RandomChanceLootCondition.builder(0.5f)) // Drops 50% of the time - will be changed later
							.with(ItemEntry.builder(plushie))
							.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
						tableBuilder.pool(poolBuilder.build());
					}
				}
			}
		});
	}
}
