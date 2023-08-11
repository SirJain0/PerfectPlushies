package io.github.sirjain0.perfectplushies;

import io.github.sirjain0.perfectplushies.init.TagInit;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class PlushiesLootTableModifier {
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

    public static String[] BURIED_VARIANTS = new String[] {
            "buried_treasure",
            "shipwreck_treasure",
            "simple_dungeon",
            "underwater_ruin_big",
            "underwater_ruin_small"
    };

    public static ResourceLocation VILLAGE_IDENTIFIER;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            // Regular plushies
            for (String village : VILLAGE_VARIANTS) {
                VILLAGE_IDENTIFIER = new ResourceLocation("minecraft", "chests/village/" + village);

                for (Holder<Item> plushie : BuiltInRegistries.ITEM.getTagOrEmpty(TagInit.VILLAGE_PLUSHIES)) {
                    if (VILLAGE_IDENTIFIER.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .when(LootItemRandomChanceCondition.randomChance(0.1f)) // 10% chance of spawning
                                .add(LootItem.lootTableItem(plushie.value()))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build());
                        tableBuilder.pool(poolBuilder.build());
                    }
                }
            }

            // Player plushies
            for (String buried_treasure : BURIED_VARIANTS) {
                VILLAGE_IDENTIFIER = new ResourceLocation("minecraft", "chests/" + buried_treasure);

                for (Holder<Item> plushie : BuiltInRegistries.ITEM.getTagOrEmpty(TagInit.TREASURE_PLUSHIES)) {
                    if (VILLAGE_IDENTIFIER.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)) // 15% chance of spawning
                                .add(LootItem.lootTableItem(plushie.value()))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build());
                        tableBuilder.pool(poolBuilder.build());
                    }
                }
            }
        });
    }
}