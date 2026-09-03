package blueportal.finsandstails.common.criterion;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
//? if >=26.2 {
/*import net.minecraft.advancements.triggers.PlayerTrigger;
*///?} else {
import net.minecraft.advancements.criterion.PlayerTrigger;
//?}

public class FTCriterion {
    public static final PlayerTrigger THROW_WHERBLING_IN_THE_VOID = register("throw_wherbling_in_the_void");
    public static final PlayerTrigger THROW_WHERBLING = register("throw_wherbling");

    public static void register() {
    }

    private static PlayerTrigger register(String name) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, FinsAndTails.id(name), new PlayerTrigger());
    }
}
