package sirjain.loot_tables;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import sirjain.blocks.util.PlushieBlockRegistries;

public class PlushiesLootTableModifier {
    public static final ItemConvertible[] PLUSHIES = new ItemConvertible[]{
            PlushieBlockRegistries.FOX_PLUSHIE,
            PlushieBlockRegistries.DOLPHIN_PLUSHIE,
            PlushieBlockRegistries.RABBIT_PLUSHIE,
            PlushieBlockRegistries.FROG_PLUSHIE,
            PlushieBlockRegistries.HIPPO_PLUSHIE,
            PlushieBlockRegistries.DEER_PLUSHIE
    };
    public static final String[] VILLAGE_VARIANTS = new String[]{
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
    public static Identifier VILLAGE_IDENTIFIER;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            for (String village : VILLAGE_VARIANTS) {
                VILLAGE_IDENTIFIER = new Identifier("minecraft", "chests/village/" + village);

                for (ItemConvertible plushie : PLUSHIES) {
                    if (VILLAGE_IDENTIFIER.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.12f)) // one plushie has a 12% chance of spawning
                                .with(ItemEntry.builder(plushie))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                        tableBuilder.pool(poolBuilder.build());
                    }
                }
            }
        });
    }
}
