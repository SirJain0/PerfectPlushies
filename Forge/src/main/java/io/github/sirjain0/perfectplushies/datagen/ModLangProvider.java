package io.github.sirjain0.perfectplushies.datagen;

import com.google.common.collect.ImmutableMap;
import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import io.github.sirjain0.perfectplushies.init.EntityInit;
import io.github.sirjain0.perfectplushies.init.ItemInit;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ModLangProvider extends LanguageProvider {
    protected static final String COMMUNITY_PILLAR_STR = "Community Pillar";

    protected static final Map<String, String> REPLACE_LIST = ImmutableMap.of(
            "tnt", "TNT",
            "sus", "",
            "sizableshrimp", "SizableShrimp",
            "gamerpotion", "GamerPotion",
            "sirjain", "SirJain",
            "rocris", "RoCris",
            "rare", "",
            "epic", ""
    );

    public ModLangProvider(PackOutput gen) {
        super(gen, Constants.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ItemInit.ITEMS.getEntries().forEach(this::itemLang);
        EntityInit.ENTITIES.getEntries().forEach(this::entityLang);
        BlockInit.BLOCKS.getEntries().forEach(this::blockLang);

        add("itemGroup.perfectplushies.tab", "Perfect Plushies");
        add("tooltip.perfectplushies.advanced", "Hold %s for more information");
        add("tooltip.perfectplushies.shift", "SHIFT");
        add("plushie.description.tslat_plushie", "Developer of Advent of Ascension\nDeveloper of SmartBrainLib\nMaintainer of Geckolib");
        add("plushie.description.nyf_plushie", "Co-Developer of Perfect Plushies\nDeveloper of Many Mods that Start with \"Nyf's\"");
        add("plushie.description.sizableshrimp_plushie", "NeoForge Developer\nVery Helpful Dev in the Community");
        add("plushie.description.gamerpotion_plushie", "Developer of DarkRPG ModPack!");
        add("plushie.description.gamerpotion_plushie_rare", "Developer of the DarkRPG ModPack!");
        add("plushie.description.silk_plushie", "Pillar of the Modding Community!");
        add("plushie.description.june_plushie", "Developer of Plushables");
        add("plushie.description.daniel_plushie", "Developer of Spray Madness");
        add("plushie.description.sirjain_plushie", "Co-Developer of Perfect Plushies\nCo-Developer of Herespawn\nDeveloper of Throwable Fluids");
        add("plushie.description.sirjain_plushie_rare", "Co-Developer of Perfect Plushies\nCo-Developer of Herespawn\nDeveloper of Throwable Fluids");
        add("plushie.description.joosh_plushie", "Lead Artist of Bonsai Studios");

        add("plushie.description.rocris_plushie", COMMUNITY_PILLAR_STR+"\nDeveloper of Blaster Movement");
        add("plushie.description.geode_plushie", COMMUNITY_PILLAR_STR);
    }

    protected void itemLang(RegistryObject<Item> entry) {
        if (!(entry.get() instanceof BlockItem) || entry.get() instanceof ItemNameBlockItem) {
            addItem(entry, checkReplace(entry));
        }
    }

    protected void blockLang(RegistryObject<Block> entry) {
        addBlock(entry, checkReplace(entry));
    }

    protected void entityLang(RegistryObject<EntityType<?>> entry) {
        addEntityType(entry, checkReplace(entry));
    }

    protected String checkReplace(RegistryObject<?> registryObject) {
        return Arrays.stream(registryObject.getId().getPath().split("_"))
                .map(this::checkReplace)
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining(" "))
                .trim();
    }

    protected String checkReplace(String string) {
        return REPLACE_LIST.containsKey(string) ? REPLACE_LIST.get(string) : StringUtils.capitalize(string);
    }
}
