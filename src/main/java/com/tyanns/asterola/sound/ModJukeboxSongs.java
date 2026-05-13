package com.tyanns.asterola.sound;

import com.tyanns.asterola.Asterola;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;

public interface ModJukeboxSongs {
    ResourceKey<JukeboxSong> YOU_ARE_BEAUTIFUL_VOMIT_VERSION = create("you_are_beautiful_vomit_version");

    private static ResourceKey<JukeboxSong> create(final String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, id));
    }

    private static void register(final BootstrapContext<JukeboxSong> context, final ResourceKey<JukeboxSong> registryKey, final Holder.Reference<SoundEvent> soundEvent, final int lengthInSeconds, final int comparatorOutput) {
        context.register(registryKey, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", registryKey.identifier())), (float) lengthInSeconds, comparatorOutput));
    }

    static void bootstrap(final BootstrapContext<JukeboxSong> context) {
        register(context, YOU_ARE_BEAUTIFUL_VOMIT_VERSION, ModSoundEvents.MUSIC_DISC_YOU_ARE_BEAUTIFUL_VOMIT_VERSION, 51, 7);
    }
}
