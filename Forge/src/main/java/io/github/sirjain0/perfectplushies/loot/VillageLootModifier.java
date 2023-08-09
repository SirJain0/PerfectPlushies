package io.github.sirjain0.perfectplushies.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.sirjain0.perfectplushies.init.TagInit;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VillageLootModifier extends LootModifier {
    public static final Codec<VillageLootModifier> CODEC = RecordCodecBuilder.create(builder -> codecStart(builder)
            .and(TagEntry.CODEC.listOf().fieldOf("plushies").forGetter(VillageLootModifier::plushies))
            .and(Codec.FLOAT.fieldOf("chance").forGetter(VillageLootModifier::chance))
            .apply(builder, VillageLootModifier::new));

    public final List<TagEntry> plushies;
    private final float chance;

    protected VillageLootModifier(LootItemCondition[] conditionsIn, List<TagEntry> plushies, float chance) {
        super(conditionsIn);
        this.plushies = plushies;
        this.chance = chance;

    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < chance) {
            TagEntry tagthing  =plushies.get(context.getRandom().nextInt(plushies.size()));
            Item item;
            if(tagthing.isTag()){
                TagKey<Item> itemTag = TagKey.create(Registries.ITEM,tagthing.getId());
                item = ForgeRegistries.ITEMS.tags().getTag(itemTag).getRandomElement(context.getRandom()).get();
            } else {
                item = ForgeRegistries.ITEMS.getValue(tagthing.getId());
            }
            generatedLoot.add(new ItemStack(item));
        }
        return generatedLoot;
    }

    public List<TagEntry> plushies() {
        return plushies;
    }

    public float chance() {
        return chance;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
