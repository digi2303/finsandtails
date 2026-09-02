package blueportal.finsandstails;

import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FinsAndTails {
    public static final String MOD_ID = "finsandtails";
    public static final Logger LOGGER = LogManager.getLogger();

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }
}
