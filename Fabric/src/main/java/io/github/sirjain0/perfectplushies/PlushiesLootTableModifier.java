package io.github.sirjain0.perfectplushies;

import io.github.sirjain0.perfectplushies.init.TagInit;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
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

    public static String[] BURIED_VARIANTS = new String[]{
            "buried_treasure",
            "shipwreck_treasure",
            "simple_dungeon",
            "underwater_ruin_big",
            "underwater_ruin_small"
    };

    public static ResourceLocation LOOT_TABLE_RESOURCE_LOCATION;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            // Regular plushies
            for (String village : VILLAGE_VARIANTS) {
                LOOT_TABLE_RESOURCE_LOCATION = new ResourceLocation("minecraft", "chests/village/" + village);
                if (LOOT_TABLE_RESOURCE_LOCATION.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(TagEntry.expandTag(TagInit.VILLAGE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.15f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));
                    tableBuilder.pool(poolBuilder.build());
                }
            }

            // Player plushies
            for (String buried_treasure : BURIED_VARIANTS) {
                LOOT_TABLE_RESOURCE_LOCATION = new ResourceLocation("minecraft", "chests/" + buried_treasure);
                if (LOOT_TABLE_RESOURCE_LOCATION.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1))
                            .add(TagEntry.expandTag(TagInit.TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.15f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                            .add(TagEntry.expandTag(TagInit.RARE_TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.01f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));
                    tableBuilder.pool(poolBuilder.build());
                }
            }
        });
    }
}