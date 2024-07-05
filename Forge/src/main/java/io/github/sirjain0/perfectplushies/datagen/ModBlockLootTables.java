package io.github.sirjain0.perfectplushies.datagen;

import com.nyfaria.perfectplushieapi.block.entity.ColoredPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.getBlockStream().filter(this::shouldDropSelf).forEach(this::dropSelf);
        this.add(BlockInit.DUMBO_BLOB_PLUSHIE.get(), this.createColorPlushieDrop(BlockInit.DUMBO_BLOB_PLUSHIE.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.getBlockStream().filter(this::shouldGenerateLoot).toList();
    }

    protected Stream<Block> getBlockStream() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get);
    }

    protected boolean shouldDropSelf(Block block) {
        return shouldGenerateLoot(block);
    }

    protected boolean shouldGenerateLoot(Block block) {
        return block.asItem() != Items.AIR && !(block instanceof DropExperienceBlock);
    }
    protected LootTable.Builder createColorPlushieDrop(Block pBlock) {
        return LootTable.lootTable().withPool(
                this.applyExplosionCondition(pBlock, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pBlock).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
                                .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
                                        .copy("colors", "colors")))));
    }
}
