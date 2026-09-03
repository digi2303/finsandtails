package blueportal.finsandstails.registry;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.criterion.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.criterion.SimpleCriterionTrigger;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import blueportal.finsandstails.FinsAndTails;


public class FTCriteriaTriggers extends SimpleCriterionTrigger<FTCriteriaTriggers.TriggerInstance> {
    private final Identifier ID;

    public FTCriteriaTriggers(String name) {
        ID = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, name);
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, conditions -> true);
    }

    @Override
    protected TriggerInstance createInstance(JsonObject p_66248_, ContextAwarePredicate predicate, DeserializationContext p_66250_) {
        return new FTCriteriaTriggers.TriggerInstance(ID, predicate);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {

        public TriggerInstance(Identifier id, ContextAwarePredicate predicate) {
            super(id, predicate);
        }

    }
}