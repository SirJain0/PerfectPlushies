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
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockInit {
    public static List<RegistryObject<Block>> playerBlocks = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksCommon = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksRare = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksEpic = new ArrayList<>();
    public static List<RegistryObject<Block>> plushieBlocks = new ArrayList<>();
    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MODID);
    public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, Constants.MODID);

    public static final RegistryObject<Block> FOX_PLUSHIE = registerCommonBasicPlushie("fox_plushie");
    public static final RegistryObject<Block> CAPYBARA_PLUSHIE = registerCommonBasicPlushie("capybara_plushie");
    public static final RegistryObject<Block> DOLPHIN_PLUSHIE = registerCommonBasicPlushie("dolphin_plushie");
    public static final RegistryObject<Block> RABBIT_PLUSHIE = registerCommonBasicPlushie("rabbit_plushie");
    public static final RegistryObject<Block> FROG_PLUSHIE = registerCommonBasicPlushie("frog_plushie");
    public static final RegistryObject<Block> HIPPO_PLUSHIE = registerCommonBasicPlushie("hippo_plushie");
    public static final RegistryObject<Block> DEER_PLUSHIE = registerCommonBasicPlushie("deer_plushie");
    public static final RegistryObject<Block> BEAR_PLUSHIE = registerCommonBasicPlushie("bear_plushie");
    public static final RegistryObject<Block> DOG_PLUSHIE = registerCommonBasicPlushie("dog_plushie");
    public static final RegistryObject<Block> CAT_PLUSHIE = registerCommonBasicPlushie("cat_plushie");
    public static final RegistryObject<Block> ELEPHANT_PLUSHIE = registerCommonBasicPlushie("elephant_plushie");
    public static final RegistryObject<Block> NYF_PLUSHIE = registerCommonPlayerPlushie("nyf_plushie");
    public static final RegistryObject<Block> SIZABLESHRIMP_PLUSHIE = registerCommonPlayerPlushie("sizableshrimp_plushie");
    public static final RegistryObject<Block> TSLAT_PLUSHIE = registerCommonPlayerPlushie("tslat_plushie");
    public static final RegistryObject<Block> SILK_PLUSHIE = registerCommonPlayerPlushie("silk_plushie");
    public static final RegistryObject<Block> JUNE_PLUSHIE = registerCommonPlayerPlushie("june_plushie");
    public static final RegistryObject<Block> DANIEL_PLUSHIE = registerCommonPlayerPlushie("daniel_plushie");
    public static final RegistryObject<Block> GAMERPOTION_PLUSHIE = registerCommonPlayerPlushie("gamerpotion_plushie");
    public static final RegistryObject<Block> GAMERPOTION_PLUSHIE_RARE = registerRarePlayerPlushie("gamerpotion_plushie_rare");



    public static final RegistryObject<BlockEntityType<PlayerPlushieBlockEntity>> PLAYER_PLUSHIE_BLOCK_ENTITY = BLOCK_ENTITIES.register("player_plushie_block_entity", ()-> BlockEntityType.Builder.of(PlayerPlushieBlockEntity::new, playerBlocks.stream().map(Supplier::get).toArray(Block[]::new)).build(null));


    public static RegistryObject<Block> registerCommonPlayerPlushie(String name){
        return registerPlayerPlushie(name, Rarity.COMMON);
    }
    public static RegistryObject<Block> registerRarePlayerPlushie(String name){
        return registerPlayerPlushie(name, Rarity.RARE);
    }
    public static RegistryObject<Block> registerEpicPlayerPlushie(String name){
        return registerPlayerPlushie(name, Rarity.EPIC);
    }
    public static RegistryObject<Block> registerPlayerPlushie(String name, Rarity rarity){
        RegistryObject<Block> block = BLOCKS.register(name, PlayerPlushieBlock::new);
        ItemInit.ITEMS.register(name, ()-> new PlayerPlushieBlockItem(block.get(), rarity));
        addToList(block, rarity);
        return block;
    }

    public static void addToList(RegistryObject<Block> block, Rarity rarity){
        switch (rarity) {
            case COMMON -> playerBlocksCommon.add(block);
            case RARE -> playerBlocksRare.add(block);
            case EPIC -> playerBlocksEpic.add(block);
        }
        playerBlocks.add(block);
    }
    public static RegistryObject<Block> registerCommonBasicPlushie(String name){
        return registerBasicPlushie(name, Rarity.COMMON);
    }
    public static RegistryObject<Block> registerRareBasicPlushie(String name){
        return registerBasicPlushie(name, Rarity.RARE);
    }
    public static RegistryObject<Block> registerEpicBasicPlushie(String name){
        return registerBasicPlushie(name, Rarity.EPIC);
    }
    public static RegistryObject<Block> registerBasicPlushie(String name, Rarity rarity){
        RegistryObject<Block> block = BLOCKS.register(name, PlushieBlock::new);
        ItemInit.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties().rarity(rarity)));
        plushieBlocks.add(block);
        return block;
    }

    public static void loadClass() {
    }
}
