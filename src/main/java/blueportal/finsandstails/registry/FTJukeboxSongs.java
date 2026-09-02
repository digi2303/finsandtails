package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class FTJukeboxSongs {
    public static final ResourceKey<JukeboxSong> CRASHING_TIDES = createKey("crashing_tides");
    public static final ResourceKey<JukeboxSong> WARBLE = createKey("warble");

    public static void register(BootstrapContext<JukeboxSong> context) {
        context.register(CRASHING_TIDES, new JukeboxSong(FTSounds.CRASHING_TIDES, Component.translatable("jukebox_song.finsandtails.crashing_tides"), 200.0f, 1));
        context.register(WARBLE, new JukeboxSong(FTSounds.WARBLE, Component.translatable("jukebox_song.finsandtails.warble"), 174.0f, 13));
    }

    private static ResourceKey<JukeboxSong> createKey(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, FinsAndTails.id(name));
    }
}
