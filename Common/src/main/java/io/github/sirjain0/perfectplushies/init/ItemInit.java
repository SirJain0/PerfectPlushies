package io.github.sirjain0.perfectplushies.init;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.registration.RegistrationProvider;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);

    public static final RegistrationProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MODID);
    public static final RegistryObject<CreativeModeTab> PERFECT_PLUSHIES_TAB = CREATIVE_MODE_TABS.register("perfectplushies", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP,0)
            .icon(()-> new ItemStack(BlockInit.FOX_PLUSHIE.get()))
            .displayItems(
                    (itemDisplayParameters,output)-> {
                        ITEMS.getEntries().forEach((registryObject)-> output.accept(new ItemStack(registryObject.get()))
                        );
                    }).title(Component.translatable("itemGroup.perfectplushies.tab"))
            .build());
    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }

    public static void loadClass() {
    }
}
