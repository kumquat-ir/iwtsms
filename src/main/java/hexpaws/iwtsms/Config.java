package hexpaws.iwtsms;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static File cfgFile = new File(Launch.minecraftHome, "config/iwtsms.cfg");

    public static boolean adventureBackpack = true;
    public static boolean galacticraft = true;
    public static boolean travellersGear = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        adventureBackpack = configuration.getBoolean("adventureBackpack", Configuration.CATEGORY_GENERAL, adventureBackpack, "disable adventure backpack rendering");
        galacticraft = configuration.getBoolean("galacticraft", Configuration.CATEGORY_GENERAL, galacticraft, "disable galacticraft equipment rendering");
        travellersGear = configuration.getBoolean("travellersGear", Configuration.CATEGORY_GENERAL, travellersGear, "disable traveller's gear rendering");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
