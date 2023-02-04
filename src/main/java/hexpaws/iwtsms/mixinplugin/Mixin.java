package hexpaws.iwtsms.mixinplugin;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import hexpaws.iwtsms.Config;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public enum Mixin {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    // Replace with your own mixins:
    MixinRenderWearableEquipped("adventurebackpack.MixinRenderWearableEquipped", Side.CLIENT, () -> Config.adventureBackpack, TargetedMod.ADVENTUREBACKPACK),
    MixinModelPlayerBaseGC("galacticraft.MixinModelPlayerBaseGC", Side.CLIENT, () -> Config.galacticraft, TargetedMod.GALACTICRAFT),
    MixinModelPlayerGC("galacticraft.MixinModelPlayerGC", Side.CLIENT, () -> Config.galacticraft, TargetedMod.GALACTICRAFT),
    MixinRenderPlayerBaseGC("galacticraft.MixinRenderPlayerBaseGC", Side.CLIENT, () -> Config.galacticraft, TargetedMod.GALACTICRAFT),
    MixinRenderPlayerGC("galacticraft.MixinRenderPlayerGC", Side.CLIENT, () -> Config.galacticraft, TargetedMod.GALACTICRAFT),
    MixinClientProxy("travellersgear.MixinClientProxy", Side.CLIENT, () -> Config.travellersGear, TargetedMod.TRAVELLERSGEAR);

    public final String mixinClass;
    public final List<TargetedMod> targetedMods;
    private final Side side;
    private final Supplier<Boolean> condition;

    Mixin(String mixinClass, Side side, Supplier<Boolean> condition, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = side;
        this.condition = condition;
    }

    Mixin(String mixinClass, Supplier<Boolean> condition, TargetedMod... targetedMods) {
        this.mixinClass = mixinClass;
        this.condition = condition;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = Side.BOTH;
    }

    public boolean shouldLoad(List<TargetedMod> loadedMods) {
        return (side == Side.BOTH
            || side == Side.SERVER && FMLLaunchHandler.side().isServer()
            || side == Side.CLIENT && FMLLaunchHandler.side().isClient())
            && loadedMods.containsAll(targetedMods)
            && condition.get();
    }
}

enum Side {
    BOTH,
    CLIENT,
    SERVER;
}
