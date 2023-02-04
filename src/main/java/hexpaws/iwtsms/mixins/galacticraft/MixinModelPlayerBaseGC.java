package hexpaws.iwtsms.mixins.galacticraft;

import hexpaws.iwtsms.UtilGC;
import micdoodle8.mods.galacticraft.core.client.model.ModelPlayerBaseGC;
import micdoodle8.mods.galacticraft.core.wrappers.PlayerGearData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ModelPlayerBaseGC.class, remap = false)
public abstract class MixinModelPlayerBaseGC {
    @ModifyVariable(method = "afterRender", at = @At("STORE"))
    private PlayerGearData iwtsms$injectAfterRender(PlayerGearData gearData){
        if (gearData == null) {
            return null;
        }
        UtilGC.dummyGear.setParachute(gearData.getParachute());
        return UtilGC.dummyGear;
    }
}
