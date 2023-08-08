package io.github.sirjain0.perfectplushies.init;

import io.github.sirjain0.perfectplushies.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagInit {

    public static final TagKey<Item> VILLAGE_PLUSHIES = TagKey.create(Registries.ITEM,new ResourceLocation(Constants.MODID, "village_plushies"));
    public static final TagKey<Item> TREASURE_PLUSHIES = TagKey.create(Registries.ITEM,new ResourceLocation(Constants.MODID, "treasure_plushies"));

    public static void loadClass() {
    }
}
