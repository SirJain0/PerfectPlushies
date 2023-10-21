package io.github.sirjain0.perfectplushies.init;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.platform.Services;
import io.github.sirjain0.perfectplushies.registration.RegistrationProvider;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);
    public static final RegistryObject<Item> WANDERING_TRADER_SPAWN_EGG = registerSpawnEgg(
            "wandering_plushie_trader_spawn_egg",
            EntityInit.WANDERING_PLUSHIH_TRADER,
            0x906834, 0xa4471f);

    public static final RegistrationProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MODID);
    public static final RegistryObject<CreativeModeTab> PERFECT_PLUSHIES_TAB = CREATIVE_MODE_TABS.register("perfectplushies", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(BlockInit.RED_FOX_PLUSHIE.get()))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        BlockInit.plushieBlocks.forEach((registryObject) -> output.accept(new ItemStack(registryObject.get())));
                        BlockInit.playerBlocks.forEach((registryObject) -> output.accept(new ItemStack(registryObject.get())));
                        output.accept(WANDERING_TRADER_SPAWN_EGG.get());
                    }).title(Component.translatable("itemGroup.perfectplushies.tab"))
            .build());

    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }

    public static<T extends Mob> RegistryObject<Item> registerSpawnEgg(String id, RegistryObject<EntityType<T>> entity, int primaryColor, int secondaryColor) {
        return ItemInit.ITEMS.register(id, () -> Services.PLATFORM.createSpawnEggItem(entity, primaryColor, secondaryColor));
    }

    public static void loadClass() {
    }
}
