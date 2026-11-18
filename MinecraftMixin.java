package com.example.noplayerglow.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    /** Players never count as glowing, so no outline is drawn or post-processed. */
    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    private void noplayerglow$hide(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player) {
            cir.setReturnValue(false);
        }
    }
}
