package hexpaws.iwtsms.mixins.galacticraft;

import micdoodle8.mods.galacticraft.core.client.render.entities.RenderPlayerBaseGC;
import micdoodle8.mods.galacticraft.core.wrappers.PlayerGearData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = RenderPlayerBaseGC.class, remap = false)
public class MixinRenderPlayerBaseGC {
    @ModifyVariable(method = "renderModel", at = @At("STORE"))
    private PlayerGearData iwtsms$injectRenderModelS(PlayerGearData gearData) {
        return null;
    }
}
