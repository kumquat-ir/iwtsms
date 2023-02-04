package hexpaws.iwtsms.mixins.galacticraft;

import micdoodle8.mods.galacticraft.core.client.render.entities.RenderPlayerGC;
import micdoodle8.mods.galacticraft.core.wrappers.PlayerGearData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = RenderPlayerGC.class, remap = false)
public class MixinRenderPlayerGC {
    @ModifyVariable(method = "renderModelS", at = @At("STORE"))
    private static PlayerGearData iwtsms$injectRenderModelS(PlayerGearData gearData) {
        return null;
    }
}
