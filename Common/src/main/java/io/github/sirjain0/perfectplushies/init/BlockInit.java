package io.github.sirjain0.perfectplushies.init;

import com.nyfaria.perfectplushieapi.block.PlushieBlock;
import com.nyfaria.perfectplushieapi.item.ColoredPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.GeoPlushieBlockItem;
import com.nyfaria.perfectplushieapi.item.PlayerGeoPlushieBlockItem;
import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.block.DumboBlobPlushieBlock;
import io.github.sirjain0.perfectplushies.block.PPPlayerPlushieBlock;
import io.github.sirjain0.perfectplushies.block.RubberDuckPlushieBlock;
import io.github.sirjain0.perfectplushies.block.entity.PPDualColorBlockEntity;
import io.github.sirjain0.perfectplushies.block.entity.PPPlayerPlushieBE;
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
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit <T extends Block>  {
    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MODID);
    public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, Constants.MODID);
    public static List<RegistryObject<Block>> playerBlocks = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksCommon = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksRare = new ArrayList<>();
    public static List<RegistryObject<Block>> playerBlocksEpic = new ArrayList<>();
    public static List<RegistryObject<? extends Block>> plushieBlocks = new ArrayList<>();

    // == PLAYER PLUSHIES ==
    public static final RegistryObject<Block> NYF_PLUSHIE = registerCommonPlayerPlushie("nyf_plushie");
    public static final RegistryObject<Block> SIRJAIN_PLUSHIE = registerCommonPlayerPlushie("sirjain_plushie");
    public static final RegistryObject<Block> SIZABLESHRIMP_PLUSHIE = registerCommonPlayerPlushie("sizableshrimp_plushie");
    public static final RegistryObject<Block> TSLAT_PLUSHIE = registerCommonPlayerPlushie("tslat_plushie");
    public static final RegistryObject<Block> SILK_PLUSHIE = registerCommonPlayerPlushie("silk_plushie");
    public static final RegistryObject<Block> JUNE_PLUSHIE = registerCommonPlayerPlushie("june_plushie");
    public static final RegistryObject<Block> DANIEL_PLUSHIE = registerCommonPlayerPlushie("daniel_plushie");
    public static final RegistryObject<Block> GAMERPOTION_PLUSHIE = registerCommonPlayerPlushie("gamerpotion_plushie");
    public static final RegistryObject<Block> JOOSH_PLUSHIE = registerCommonPlayerPlushie("joosh_plushie");
    public static final RegistryObject<Block> ROCRIS_PLUSHIE = registerCommonPlayerPlushie("rocris_plushie");
    public static final RegistryObject<Block> GEODE_PLUSHIE = registerCommonPlayerPlushie("geode_plushie");
    public static final RegistryObject<Block> GAMERPOTION_PLUSHIE_RARE = registerRarePlayerPlushie("gamerpotion_plushie_rare");
    public static final RegistryObject<Block> SIRJAIN_PLUSHIE_RARE = registerRarePlayerPlushie("sirjain_plushie_rare");

    // == ANIMAL PLUSHIES ==
    public static final RegistryObject<Block> RED_FOX_PLUSHIE = registerCommonBasicPlushie("red_fox_plushie");
    public static final RegistryObject<Block> SNOW_FOX_PLUSHIE = registerCommonBasicPlushie("snow_fox_plushie");
    public static final RegistryObject<Block> RACCOON_PLUSHIE = registerCommonBasicPlushie("raccoon_plushie");
    public static final RegistryObject<Block> RED_PANDA_PLUSHIE = registerCommonBasicPlushie("red_panda_plushie");
    public static final RegistryObject<Block> RED_RUFFED_LEMUR_PLUSHIE = registerCommonBasicPlushie("red_ruffed_lemur_plushie");
    public static final RegistryObject<Block> CAPYBARA_PLUSHIE = registerCommonBasicPlushie("capybara_plushie");
    public static final RegistryObject<Block> DOG_PLUSHIE = registerCommonBasicPlushie("dog_plushie");
    public static final RegistryObject<Block> CAT_PLUSHIE = registerCommonBasicPlushie("cat_plushie");
    public static final RegistryObject<Block> DOLPHIN_PLUSHIE = registerCommonBasicPlushie("dolphin_plushie");
    public static final RegistryObject<Block> RABBIT_PLUSHIE = registerCommonBasicPlushie("rabbit_plushie");
    public static final RegistryObject<Block> FROG_PLUSHIE = registerCommonBasicPlushie("frog_plushie");
    public static final RegistryObject<Block> GOOSE_PLUSHIE = registerCommonBasicPlushie("goose_plushie");
    public static final RegistryObject<Block> DUCK_PLUSHIE = registerCommonBasicPlushie("duck_plushie");
    public static final RegistryObject<Block> RUBBER_DUCK_PLUSHIE = registerCustomPlushie("rubber_duck_plushie", RubberDuckPlushieBlock::new);
    public static final RegistryObject<Block> ROBIN_PLUSHIE = registerCommonBasicPlushie("robin_plushie");
    public static final RegistryObject<Block> HUMMINGBIRD_PLUSHIE = registerCommonBasicPlushie("hummingbird_plushie");
    public static final RegistryObject<Block> HIPPO_PLUSHIE = registerCommonBasicPlushie("hippo_plushie");
    public static final RegistryObject<Block> MOUSE_PLUSHIE = registerCommonBasicPlushie("mouse_plushie");
    public static final RegistryObject<Block> TURTLE_PLUSHIE = registerCommonBasicPlushie("turtle_plushie");
    public static final RegistryObject<Block> DOE_PLUSHIE = registerCommonBasicPlushie("doe_plushie");
    public static final RegistryObject<Block> REINDEER_PLUSHIE = registerCommonBasicPlushie("reindeer_plushie");
    public static final RegistryObject<Block> BEAR_PLUSHIE = registerCommonBasicPlushie("bear_plushie");
    public static final RegistryObject<Block> PANDA_PLUSHIE = registerCommonBasicPlushie("panda_plushie");
    public static final RegistryObject<Block> LION_CUB_PLUSHIE = registerCommonBasicPlushie("lion_cub_plushie");
    public static final RegistryObject<Block> ELEPHANT_PLUSHIE = registerCommonBasicPlushie("elephant_plushie");
    public static final RegistryObject<Block> MONKEY_PLUSHIE = registerCommonBasicPlushie("monkey_plushie");
    public static final RegistryObject<Block> SEAL_PLUSHIE = registerCommonBasicPlushie("seal_plushie");
    public static final RegistryObject<Block> DUMBO_BLOB_PLUSHIE = registerCustomItemPlushie("dumbo_blob_plushie", DumboBlobPlushieBlock::new, block -> ()->new ColoredPlushieBlockItem(block.get(), Rarity.RARE));

    public static RegistryObject<Block> registerCommonPlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.COMMON);
    }

    public static final RegistryObject<BlockEntityType<PPPlayerPlushieBE>> PLAYER_PLUSHIE_BLOCK_ENTITY = BLOCK_ENTITIES.register("player_plushie_block_entity", () -> BlockEntityType.Builder.of(PPPlayerPlushieBE::new, playerBlocks.stream().map(Supplier::get).toArray(Block[]::new)).build(null));
    public static final RegistryObject<BlockEntityType<PPDualColorBlockEntity>> PP_COLOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("dumbo_blob_plushie", () -> BlockEntityType.Builder.of(PPDualColorBlockEntity::new, DUMBO_BLOB_PLUSHIE.get()).build(null));

    public static RegistryObject<Block> registerRarePlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.RARE);
    }

    public static RegistryObject<Block> registerEpicPlayerPlushie(String name) {
        return registerPlayerPlushie(name, Rarity.EPIC);
    }

    public static RegistryObject<Block> registerPlayerPlushie(String name, Rarity rarity) {
        RegistryObject<Block> block = BLOCKS.register(name, PPPlayerPlushieBlock::new);
        ItemInit.ITEMS.register(name, () -> new PlayerGeoPlushieBlockItem(block.get(), rarity));
        addToList(block, rarity);
        return block;
    }

    public static void addToList(RegistryObject<Block> block, Rarity rarity) {
        switch (rarity) {
            case COMMON -> playerBlocksCommon.add(block);
            case RARE -> playerBlocksRare.add(block);
            case EPIC -> playerBlocksEpic.add(block);
        }
        playerBlocks.add(block);
    }

    public static RegistryObject<Block> registerCommonBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.COMMON);
    }

    public static RegistryObject<Block> registerRareBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.RARE);
    }

    public static RegistryObject<Block> registerEpicBasicPlushie(String name) {
        return registerBasicPlushie(name, Rarity.EPIC);
    }

    public static RegistryObject<Block> registerBasicPlushie(String name, Rarity rarity) {
        RegistryObject<Block> block = BLOCKS.register(name, PlushieBlock::new);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(rarity)));
        plushieBlocks.add(block);

        return block;
    }

    public static RegistryObject<Block> registerCustomPlushie(String name, Supplier<? extends Block> customPlushieBlock) {
        RegistryObject<Block> block = BLOCKS.register(name, customPlushieBlock);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.COMMON)));
        plushieBlocks.add(block);

        return block;
    }

    public static <T extends Block>  RegistryObject<T> registerCustomItemPlushie(String name, Supplier<T> customPlushieBlock,  Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
        var block = BLOCKS.register(name, customPlushieBlock);
        ItemInit.ITEMS.register(name, () -> item.apply(block).get());
//        plushieBlocks.add(block);

        return block;
    }

    public static void loadClass() {
    }
}
