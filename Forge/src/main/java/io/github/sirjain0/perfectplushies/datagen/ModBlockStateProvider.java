package io.github.sirjain0.perfectplushies.datagen;

import com.nyfaria.perfectplushieapi.api.PlushieStore;
import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        models().getBuilder("")
                .texture("", "")
                .renderType("cutout");

        PlushieStore.plushieBlocks.stream()
                .map(Supplier::get)
                .filter(p-> p != BlockInit.DUMBO_BLOB_PLUSHIE.get())
                .forEach(this::generatePlushieBlockState);
        PlushieStore.playerBlocks.stream()
                .map(Supplier::get)
                .forEach(this::generatePlayerPlushieBlockState);
        generatePlayerPlushieBlockState(BlockInit.DUMBO_BLOB_PLUSHIE.get());
    }

    protected void simpleCubeBottomTopBlockState(Block block) {
        simpleBlock(block, blockCubeTopModel(block));
    }

    protected BlockModelBuilder blockCubeTopModel(Block block) {
        String name = getName(block);
        return models().cubeBottomTop(name, modLoc("block/" + name + "_side"), modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"));
    }

    private void generatePlayerPlushieBlockState(Block block) {
        ResourceLocation textRL = modLoc("block/" + getName(block));
        BlockModelBuilder builder = models().getBuilder(getName(block)).texture("particle", textRL)
                .renderType("cutout");
        getVariantBuilder(block).partialState().setModels(new ConfiguredModel(builder));
    }

    private void generatePlushieBlockState(Block block) {
        getVariantBuilder(block)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(models().getExistingFile(modLoc("block/" + getName(block))))
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                        .build()
                );
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }
}
