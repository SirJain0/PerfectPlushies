package io.github.sirjain0.perfectplushies.init;

import io.github.sirjain0.perfectplushies.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagInit {

    public static final TagKey<Item> VILLAGE_PLUSHIES_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "village_plushies"));
    public static final TagKey<Item> RARE_VILLAGE_PLUSHIES_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "rare_village_plushies"));
    public static final TagKey<Item> EPIC_VILLAGE_PLUSHIES_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "epic_village_plushies"));
    public static final TagKey<Item> TREASURE_PLUSHIES_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "treasure_plushies"));
    public static final TagKey<Item> RARE_TREASURE_PLUSHIES_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "rare_treasure_plushies"));
    public static final TagKey<Item> EPIC_TREASURE_PLUSHIES_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation(Constants.MODID, "epic_treasure_plushies"));
    public static final TagKey<Block> VILLAGE_PLUSHIES_BLOCKS = TagKey.create(Registries.BLOCK, new ResourceLocation(Constants.MODID, "village_plushies"));
    public static final TagKey<Block> TREASURE_PLUSHIES_BLOCKS = TagKey.create(Registries.BLOCK, new ResourceLocation(Constants.MODID, "treasure_plushies"));

    public static void loadClass() {
    }
}
