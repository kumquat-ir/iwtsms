package hexpaws.iwtsms.mixins.galacticraft;

import hexpaws.iwtsms.UtilGC;
import micdoodle8.mods.galacticraft.core.client.model.ModelPlayerGC;
import micdoodle8.mods.galacticraft.core.wrappers.PlayerGearData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ModelPlayerGC.class, remap = false)
public class MixinModelPlayerGC {
    @ModifyVariable(method = "render", at = @At("STORE"))
    private PlayerGearData iwtsms$injectRender(PlayerGearData gearData){
        if (gearData == null) {
            return null;
        }
        UtilGC.dummyGear.setParachute(gearData.getParachute());
        return UtilGC.dummyGear;
    }
}
