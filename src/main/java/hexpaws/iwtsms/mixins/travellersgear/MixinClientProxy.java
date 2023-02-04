package hexpaws.iwtsms.mixins.travellersgear;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import travellersgear.client.ClientProxy;

@Mixin(value = ClientProxy.class)
public class MixinClientProxy {

    @Inject(method = "renderTravellersItem", at = @At(value = "INVOKE",
        target = "Lcpw/mods/fml/common/eventhandler/EventBus;post(Lcpw/mods/fml/common/eventhandler/Event;)Z",
        shift = At.Shift.AFTER), cancellable = true, remap = false)
    private static void iwtsms$injectRenderTravellersItem(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
