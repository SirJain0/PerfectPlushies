package io.github.sirjain0.perfectplushies.init;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.block.PlayerPlushieBlock;
import io.github.sirjain0.perfectplushies.block.PlushieBlock;
import io.github.sirjain0.perfectplushies.block.entity.PlayerPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.item.PlayerPlushieBlockItem;
import io.github.sirjain0.perfectplushies.registration.RegistrationProvider;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockInit {
    public static List<RegistryObject<Block>> playerBlocks = new ArrayList<>();
    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MODID);
    public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, Constants.MODID);

    public static final RegistryObject<Block> FOX_PLUSHIE = registerBasicPlushie("fox_plushie");
    public static final RegistryObject<Block> DOLPHIN_PLUSHIE = registerBasicPlushie("dolphin_plushie");
    public static final RegistryObject<Block> RABBIT_PLUSHIE = registerBasicPlushie("rabbit_plushie");
    public static final RegistryObject<Block> FROG_PLUSHIE = registerBasicPlushie("frog_plushie");
    public static final RegistryObject<Block> HIPPO_PLUSHIE = registerBasicPlushie("hippo_plushie");
    public static final RegistryObject<Block> DEER_PLUSHIE = registerBasicPlushie("deer_plushie");
    public static final RegistryObject<Block> BEAR_PLUSHIE = registerBasicPlushie("bear_plushie");
    public static final RegistryObject<Block> DOG_PLUSHIE = registerBasicPlushie("dog_plushie");
    public static final RegistryObject<Block> ELEPHANT_PLUSHIE = registerBasicPlushie("elephant_plushie");
    public static final RegistryObject<Block> NYF_PLUSHIE = registerPlayerPlushie("nyf_plushie");
    public static final RegistryObject<Block> SIZABLESHRIMP_PLUSHIE = registerPlayerPlushie("sizableshrimp_plushie");
    public static final RegistryObject<Block> TSLAT_PLUSHIE = registerPlayerPlushie("tslat_plushie");



    public static final RegistryObject<BlockEntityType<PlayerPlushieBlockEntity>> PLAYER_PLUSHIE_BLOCK_ENTITY = BLOCK_ENTITIES.register("player_plushie_block_entity", ()-> BlockEntityType.Builder.of(PlayerPlushieBlockEntity::new, playerBlocks.stream().map(Supplier::get).toArray(Block[]::new)).build(null));


    public static RegistryObject<Block> registerPlayerPlushie(String name){
        RegistryObject<Block> block = BLOCKS.register(name, PlayerPlushieBlock::new);
        ItemInit.ITEMS.register(name, ()-> new PlayerPlushieBlockItem(block.get()));
        playerBlocks.add(block);
        return block;
    }
    public static RegistryObject<Block> registerBasicPlushie(String name){
        RegistryObject<Block> block = BLOCKS.register(name, PlushieBlock::new);
        ItemInit.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()));
        return block;
    }

    public static void loadClass() {
    }
}
