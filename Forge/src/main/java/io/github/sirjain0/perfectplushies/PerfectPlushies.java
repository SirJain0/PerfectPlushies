package io.github.sirjain0.perfectplushies;

import io.github.sirjain0.perfectplushies.config.CommonConfig;
import io.github.sirjain0.perfectplushies.datagen.ModBlockStateProvider;
import io.github.sirjain0.perfectplushies.datagen.ModItemModelProvider;
import io.github.sirjain0.perfectplushies.datagen.ModLangProvider;
import io.github.sirjain0.perfectplushies.datagen.ModLootTableProvider;
import io.github.sirjain0.perfectplushies.datagen.ModRecipeProvider;
import io.github.sirjain0.perfectplushies.datagen.ModSoundProvider;
import io.github.sirjain0.perfectplushies.datagen.ModTagProvider;
import io.github.sirjain0.perfectplushies.init.LootModifierInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PerfectPlushies {

    public PerfectPlushies() {
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC);

    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        PackOutput packOutput = event.getGenerator().getPackOutput();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();
        generator.addProvider(includeServer, new ModRecipeProvider(packOutput));
        generator.addProvider(includeServer, new ModLootTableProvider(packOutput));
        generator.addProvider(includeServer, new ModSoundProvider(packOutput, existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Blocks(packOutput, event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeServer, new ModTagProvider.Items(packOutput, event.getLookupProvider(), existingFileHelper));
        generator.addProvider(includeClient, new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new ModLangProvider(packOutput));
    }
}