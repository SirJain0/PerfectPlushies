package io.github.sirjain0.perfectplushies.datagen;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.init.TagInit;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public class ModChestTables implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        LootTable.Builder tableBuilder = LootTable.lootTable();
        LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(TagEntry.expandTag(TagInit.TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.15f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))))
                .add(TagEntry.expandTag(TagInit.RARE_TREASURE_PLUSHIES_ITEMS).when(LootItemRandomChanceCondition.randomChance(0.01f)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f))));
        tableBuilder.withPool(poolBuilder);
        consumer.accept(new ResourceLocation(Constants.MODID, "chests/pretend"), tableBuilder);
    }
}
