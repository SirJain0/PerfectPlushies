package io.github.sirjain0.perfectplushies.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootDataId;
import net.minecraft.world.level.storage.loot.LootDataType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput generator) {
        super(generator, Set.of(), List.of(
                new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ModEntityLootTables::new, LootContextParamSets.ENTITY)
        ));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
        map.forEach((id, table) ->
                table.validate(validationContext.setParams(table.getParamSet()).enterElement("{" + id + "}", new LootDataId<>(LootDataType.TABLE, id))));
    }
}
