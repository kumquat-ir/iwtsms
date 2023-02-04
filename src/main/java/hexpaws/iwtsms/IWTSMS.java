package hexpaws.iwtsms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IWTSMS {

    public static final Logger LOG = LogManager.getLogger(Tags.MODID);

    public static void printInfo() {
        if (Config.adventureBackpack || Config.galacticraft || Config.travellersGear) {
            LOG.info("the following mods have lost rendering privileges:");
            if (Config.adventureBackpack) LOG.info("- adventure backpack");
            if (Config.galacticraft) LOG.info("- galacticraft");
            if (Config.travellersGear) LOG.info("- travellers gear");
        }
        else {
            LOG.info("no mods are losing rendering privileges, check the config file");
        }
    }

}
