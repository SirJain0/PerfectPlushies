package io.github.sirjain0.perfectplushies;

import com.mojang.datafixers.util.Either;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import io.github.sirjain0.perfectplushies.init.TagInit;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.Function;

public class PlushiesLootTableModifier {
    public static final ItemLike[] PLUSHIES = new ItemLike[]{
            BlockInit.FOX_PLUSHIE.get(),
            BlockInit.DOLPHIN_PLUSHIE.get(),
            BlockInit.RABBIT_PLUSHIE.get(),
            BlockInit.FROG_PLUSHIE.get(),
            BlockInit.HIPPO_PLUSHIE.get(),
            BlockInit.DEER_PLUSHIE.get()
    };
    public static final String[] VILLAGE_VARIANTS = new String[]{
            "village_armorer",
            "village_butcher",
            "village_cartographer",
            "village_desert_house",
            "village_fisher",
            "village_fletcher",
            "village_mason",
            "village_plains_house",
            "village_savanna_house",
            "village_shepherd",
            "village_snowy_house",
            "village_taiga_house",
            "village_tannery",
            "village_temple",
            "village_toolsmith",
            "village_weaponsmith",
    };
    public static ResourceLocation VILLAGE_IDENTIFIER;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            for (String village : VILLAGE_VARIANTS) {
                VILLAGE_IDENTIFIER = new ResourceLocation("minecraft", "chests/village/" + village);

                for (Holder<Item> plushie : BuiltInRegistries.ITEM.getTagOrEmpty(TagInit.VILLAGE_PLUSHIES)) {
                    if (VILLAGE_IDENTIFIER.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .when(LootItemRandomChanceCondition.randomChance(0.12f)) // one plushie has a 12% chance of spawning
                                .add(LootItem.lootTableItem(plushie.value()))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build());
                        tableBuilder.pool(poolBuilder.build());
                    }
                }
            }
        });
    }
}