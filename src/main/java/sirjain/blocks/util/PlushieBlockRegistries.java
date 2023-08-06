package sirjain.blocks.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sirjain.PerfectPlushiesMain;

public class PlushieBlockRegistries {

    // Block variables
    public static Block FOX_PLUSHIE = registerBasicPlushie("fox_plushie");
    public static Block DOLPHIN_PLUSHIE = registerBasicPlushie("dolphin_plushie");
    public static Block RABBIT_PLUSHIE = registerBasicPlushie("rabbit_plushie");
    public static Block FROG_PLUSHIE = registerBasicPlushie("frog_plushie");
    public static Block HIPPO_PLUSHIE = registerBasicPlushie("hippo_plushie");
    public static Block DEER_PLUSHIE = registerBasicPlushie("deer_plushie");
    public static Block BEAR_PLUSHIE = registerBasicPlushie("bear_plushie");
    public static Block DOG_PLUSHIE = registerBasicPlushie("dog_plushie");
    public static Block ELEPHANT_PLUSHIE = registerBasicPlushie("elephant_plushie");

    public static void registerPlushieBlocks() {

    }

    public static ItemStack getIcon() {
        return FOX_PLUSHIE.asItem().getDefaultStack();
    }


    public static Block registerBasicPlushie(String name) {
        Identifier id = new Identifier(PerfectPlushiesMain.MOD_ID, name);
        Block block = Registry.register(Registries.BLOCK, id, new PlushieBlock());
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(PerfectPlushiesMain.ITEM_GROUP).get()).register(entries -> {
            entries.add(block);
        });
        return block;
    }

//    public static void addItemsToTabs() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
//            entries.add(FOX_PLUSHIE);
//            entries.add(DOLPHIN_PLUSHIE);
//            entries.add(RABBIT_PLUSHIE);
//            entries.add(FROG_PLUSHIE);
//            entries.add(HIPPO_PLUSHIE);
//            entries.add(DEER_PLUSHIE);
//            entries.add(BEAR_PLUSHIE);
//            entries.add(DOG_PLUSHIE);
//            entries.add(ELEPHANT_PLUSHIE);
//        });
//    }
}