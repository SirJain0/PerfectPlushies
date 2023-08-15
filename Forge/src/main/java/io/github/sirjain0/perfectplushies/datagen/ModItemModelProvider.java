package io.github.sirjain0.perfectplushies.datagen;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Stream.of()
        //         .map(Supplier::get)
        //         .forEach(this::simpleHandHeldModel);

        // Stream.of()
        //         .map(Supplier::get)
        //         .forEach(this::simpleGeneratedModel);

        BlockInit.plushieBlocks.stream()
                .map(Supplier::get)
                .forEach(this::simpleBlockItemModel);
        BlockInit.playerBlocks.stream()
                .map(Supplier::get)
                .forEach(this::playerPlushieItemModel);
        BlockInit.playerBlocksRare.stream()
                .map(Supplier::get)
                .forEach(this::playerPlushieItemModel);
    }

    protected ItemModelBuilder simpleBlockItemModel(Block block) {
        String name = getName(block);
        return withExistingParent(name, modLoc("block/" + name));
    }

    protected ItemModelBuilder playerPlushieItemModel(Block block) {
        String name = getName(block);
        return withExistingParent(name, modLoc("item/player_plushie"));
    }

    protected ItemModelBuilder simpleGeneratedModel(Item item) {
        return simpleModel(item, mcLoc("item/generated"));
    }

    protected ItemModelBuilder simpleHandHeldModel(Item item) {
        return simpleModel(item, mcLoc("item/handheld"));
    }

    protected ItemModelBuilder simpleModel(Item item, ResourceLocation parent) {
        String name = getName(item);
        return singleTexture(name, parent, "layer0", modLoc("item/" + name));
    }

    protected String getName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }
}
