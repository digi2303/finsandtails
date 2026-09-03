package blueportal.finsandstails.common.criterion;

//? if >=26.2 {
/*import net.minecraft.advancements.triggers.CriteriaTriggers;
*///?} else {
import net.minecraft.advancements.CriteriaTriggers;
//?}
import net.minecraftforge.fml.common.Mod;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.registry.FTCriteriaTriggers;

@Mod.EventBusSubscriber(modid = FinsAndTails.MOD_ID)
public class FTCriterion {

    public static final FTCriteriaTriggers THROW_WHERBLING_IN_THE_VOID = CriteriaTriggers.register(new FTCriteriaTriggers("throw_wherbling_in_the_void"));
    public static final FTCriteriaTriggers THROW_WHERBLING = CriteriaTriggers.register(new FTCriteriaTriggers("throw_wherbling"));

}