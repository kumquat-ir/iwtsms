package hexpaws.iwtsms.mixins.adventurebackpack;

import com.darkona.adventurebackpack.client.render.RendererWearableEquipped;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RendererWearableEquipped.class, remap = false)
public abstract class MixinRenderWearableEquipped {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void iwtsms$injectRender(Entity entity, double x, double y, double z, float rotX, float rotY, float rotZ, float yaw,
                                     float pitch, CallbackInfo ci) {
        ci.cancel();
    }
}
