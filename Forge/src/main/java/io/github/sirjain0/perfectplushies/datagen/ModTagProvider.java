package io.github.sirjain0.perfectplushies.datagen;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import io.github.sirjain0.perfectplushies.init.TagInit;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModTagProvider {

    public static class Items extends TagsProvider<Item> {

        public Items(PackOutput p_256596_, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(p_256596_, Registries.ITEM, p_256513_, Constants.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            populateTag(TagInit.VILLAGE_PLUSHIES_ITEMS,
                    BlockInit.plushieBlocks.toArray(new RegistryObject[0])
            );
            populateTag(TagInit.TREASURE_PLUSHIES_ITEMS,
                    BlockInit.playerBlocksCommon.toArray(new RegistryObject[0])
            );
            populateTag(TagInit.RARE_TREASURE_PLUSHIES_ITEMS,
                    BlockInit.playerBlocksRare.toArray(new RegistryObject[0])
            );
            populateTag(TagInit.EPIC_TREASURE_PLUSHIES_ITEMS,
                    BlockInit.playerBlocksEpic.toArray(new RegistryObject[0])
            );

            tag(ItemTags.WOOL).addTags(
                    TagInit.VILLAGE_PLUSHIES_ITEMS,
                    TagInit.TREASURE_PLUSHIES_ITEMS,
                    TagInit.RARE_TREASURE_PLUSHIES_ITEMS
            );
        }

        public void populateTag(TagKey<Item> tag, Supplier<ItemLike>... items) {
            for (Supplier<ItemLike> item : items) {
                tag(tag).add(ForgeRegistries.ITEMS.getResourceKey(item.get().asItem()).get());
            }
        }
    }

    public static class Blocks extends TagsProvider<Block> {

        public Blocks(PackOutput pGenerator, CompletableFuture<HolderLookup.Provider> p_256513_, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, Registries.BLOCK, p_256513_, Constants.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {
            populateTag(TagInit.VILLAGE_PLUSHIES_BLOCKS,
                    BlockInit.plushieBlocks.toArray(new RegistryObject[0])
            );
            populateTag(TagInit.TREASURE_PLUSHIES_BLOCKS, BlockInit.playerBlocks.toArray(new RegistryObject[0]));
            tag(BlockTags.WOOL).addTags(
                    TagInit.VILLAGE_PLUSHIES_BLOCKS,
                    TagInit.TREASURE_PLUSHIES_BLOCKS
            );
        }

        public <T extends Block> void populateTag(TagKey<Block> tag, Supplier<?>... items) {
            for (Supplier<?> item : items) {
                tag(tag).add(ForgeRegistries.BLOCKS.getResourceKey((Block) item.get()).get());
            }
        }
    }
}
