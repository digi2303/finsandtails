package blueportal.finsandstails.impl.platform.neo;

import blueportal.finsandstails.FinsAndTails;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FinsAndTails.MOD_ID)
public class FinsAndTailsNeoMod {
    public FinsAndTailsNeoMod(IEventBus modBus) {
        NeoCommonAbstraction.EVENT_BUS = modBus;
        for (var action : NeoCommonAbstraction.INSTANCE.lateActions()) {
            action.accept(modBus);
        }
        NeoCommonAbstraction.INSTANCE.lateActions().clear();
    }
}
