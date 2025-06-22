package io.github.sirjain0.perfectplushies.init;

import com.nyfaria.perfectplushieapi.api.PlushieStore;
import com.nyfaria.perfectplushieapi.init.PlushieItemInit;
import com.nyfaria.perfectplushieapi.registration.RegistrationProvider;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import io.github.sirjain0.perfectplushies.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemInit {
    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);

    public static final RegistrationProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MODID);
    public static final RegistryObject<CreativeModeTab> PERFECT_PLUSHIES_TAB = CREATIVE_MODE_TABS.register("perfectplushies", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(BlockInit.RED_FOX_PLUSHIE.get()))
            .displayItems(
                    (itemDisplayParameters, output) -> {
                        PlushieStore.plushieBlocks.stream().filter(b->b.getId().getNamespace().equals(Constants.MODID)).forEach((registryObject) -> output.accept(new ItemStack(registryObject.get())));
                        PlushieStore.playerBlocks.stream().filter(b->b.getId().getNamespace().equals(Constants.MODID)).forEach((registryObject) -> output.accept(new ItemStack(registryObject.get())));
                        output.accept(PlushieItemInit.WANDERING_TRADER_SPAWN_EGG.get());
                    }).title(Component.translatable("itemGroup.perfectplushies.tab"))
            .build());

    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }


    public static void loadClass() {
    }
}
