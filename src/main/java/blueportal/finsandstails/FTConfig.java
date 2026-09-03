package blueportal.finsandstails;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import dev.yumi.mc.core.api.YumiMods;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FTConfig {
    private static final Path CONFIG_PATH = YumiMods.get().getConfigDirectory().resolve("finsandtails.json");
    public static FTConfig instance = new FTConfig();

    @SerializedName("fins_fishing_loot")
    public boolean finsFishingLoot = true;

    public static void load() {
        try {
            if (Files.exists(CONFIG_PATH)) {
                var gson = new GsonBuilder().disableHtmlEscaping().create();
                var config = gson.fromJson(Files.readString(CONFIG_PATH), FTConfig.class);
                if (config != null) {
                    instance = config;
                }
            }
            save();
        } catch (Throwable e) {
            FinsAndTails.LOGGER.warn("Failed to load Fins and Tails config!", e);
        }
    }

    public static void save() {
        try {
            var gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
            Files.writeString(CONFIG_PATH, gson.toJson(instance), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Throwable e) {
            FinsAndTails.LOGGER.warn("Failed to save Fins and Tails config!", e);
        }
    }
}
