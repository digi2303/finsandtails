package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

public class FTSounds {
    public static SoundEvent MUDHORSE_DEATH;
    public static SoundEvent MUDHORSE_HURT;
    public static SoundEvent MUDHORSE_AMBIENT;
    public static SoundEvent RUBBER_BELLY_GLIDER_DEATH;
    public static SoundEvent RUBBER_BELLY_GLIDER_HURT;
    public static SoundEvent RUBBER_BELLY_GLIDER_AMBIENT;
    public static SoundEvent PENGLIL_DEATH;
    public static SoundEvent PENGLIL_HURT;
    public static SoundEvent PENGLIL_AMBIENT;
    public static SoundEvent CRAB_DEATH;
    public static SoundEvent CRAB_CRUNCH;
    public static SoundEvent HORATEE_AMBIENT;
    public static SoundEvent HORATEE_HURT;
    public static SoundEvent HORATEE_DEATH;
    public static SoundEvent DIDGERIDOO_PLAY;
    public static SoundEvent CRASHING_TIDES;
    public static SoundEvent WHISTLING_WYVERNS;
    public static SoundEvent WARBLE;
    public static SoundEvent JETPACK_USE;
    public static SoundEvent FLATBACK_SUCKER_CLICK;
    public static SoundEvent WHERBLE_DEATH;
    public static SoundEvent WHERBLE_HURT;
    public static SoundEvent WHERBLE_AMBIENT;
    public static SoundEvent WHERBLE_THROW;
    public static SoundEvent WANDERING_SAILOR_AMBIENT;
    public static SoundEvent WANDERING_SAILOR_HURT;
    public static SoundEvent WANDERING_SAILOR_DEATH;
    public static SoundEvent WANDERING_SAILOR_TRADE;
    public static SoundEvent WANDERING_SAILOR_YES;
    public static SoundEvent WANDERING_SAILOR_NO;

    public static void register() {
        MUDHORSE_DEATH = register("mudhorse.death");
        MUDHORSE_HURT = register("mudhorse.hurt");
        MUDHORSE_AMBIENT = register("mudhorse.ambient");
        RUBBER_BELLY_GLIDER_DEATH = register("rubber_belly_glider.death");
        RUBBER_BELLY_GLIDER_HURT = register("rubber_belly_glider.hurt");
        RUBBER_BELLY_GLIDER_AMBIENT = register("rubber_belly_glider.ambient");
        PENGLIL_DEATH = register("penglil.death");
        PENGLIL_HURT = register("penglil.hurt");
        PENGLIL_AMBIENT = register("penglil.ambient");
        CRAB_DEATH = register("crab.death");
        CRAB_CRUNCH = register("crab.crunch");
        HORATEE_AMBIENT = register("horatee.ambient");
        HORATEE_HURT = register("horatee.hurt");
        HORATEE_DEATH = register("horatee.death");
        DIDGERIDOO_PLAY = register("didgeridoo.play");
        CRASHING_TIDES = register("music_disc.crashing_tides");
        WHISTLING_WYVERNS = register("music_disc.whistling_wyverns");
        WARBLE = register("music_disc.warble");
        JETPACK_USE = register("jetpack.use");
        FLATBACK_SUCKER_CLICK = register("click");
        WHERBLE_DEATH = register("wherble.death");
        WHERBLE_HURT = register("wherble.hurt");
        WHERBLE_AMBIENT = register("wherble.ambient");
        WHERBLE_THROW = register("wherble.throw");
        WANDERING_SAILOR_AMBIENT = register("wandering_sailor.ambient");
        WANDERING_SAILOR_HURT = register("wandering_sailor.hurt");
        WANDERING_SAILOR_DEATH = register("wandering_sailor.death");
        WANDERING_SAILOR_TRADE = register("wandering_sailor.trade");
        WANDERING_SAILOR_YES = register("wandering_sailor.yes");
        WANDERING_SAILOR_NO = register("wandering_sailor.no");
    }

    private static SoundEvent register(String name) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, FinsAndTails.id(name), SoundEvent.createVariableRangeEvent(FinsAndTails.id(name)));
    }
}
