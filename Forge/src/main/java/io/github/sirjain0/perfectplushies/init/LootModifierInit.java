package io.github.sirjain0.perfectplushies.init;

import com.mojang.serialization.Codec;
import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.loot.VillageLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LootModifierInit {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MODID);

    public static final RegistryObject<Codec<VillageLootModifier>> VILLAGE_LOOT_MODIFIER = registerSerializer("add_plushie", VillageLootModifier.CODEC);
    private static <T extends LootModifier> RegistryObject<Codec<T>> registerSerializer(String id, Codec<T> serializer) {
        return LOOT_MODIFIERS.register(id, () -> serializer);
    }
}
