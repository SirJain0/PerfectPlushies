package sirjain;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sirjain.blocks.util.PlushieBlockRegistries;
import sirjain.loot_tables.PlushiesLootTableModifier;

public class PerfectPlushiesMain implements ModInitializer {
    public static final String MOD_ID = "perfectplushies";
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(PlushieBlockRegistries::getIcon)
            .displayName(Text.translatable("itemGroup." + MOD_ID + ".tab"))
            .build();

    @Override
    public void onInitialize() {
        System.out.println("Initializing Perfect Plushies!");
        Registry.register(Registries.ITEM_GROUP, new Identifier(PerfectPlushiesMain.MOD_ID, "tab"), ITEM_GROUP);
        PlushieBlockRegistries.registerPlushieBlocks();
        PlushiesLootTableModifier.modifyLootTables();
    }
}