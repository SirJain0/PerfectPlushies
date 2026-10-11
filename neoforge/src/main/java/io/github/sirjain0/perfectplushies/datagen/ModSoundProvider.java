package io.github.sirjain0.perfectplushies.datagen;

import io.github.sirjain0.perfectplushies.Constants;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModSoundProvider extends SoundDefinitionsProvider {
    public ModSoundProvider(PackOutput generator, ExistingFileHelper helper) {
        super(generator, Constants.MODID, helper);
    }

    @Override
    public void registerSounds() {
        // SoundInit.SOUNDS.getEntries().forEach(this::addSound);
    }

    public void addSound(DeferredHolder<SoundEvent, SoundEvent> entry) {
        add(entry, SoundDefinition.definition().with(sound(entry.getId())));
    }
}
