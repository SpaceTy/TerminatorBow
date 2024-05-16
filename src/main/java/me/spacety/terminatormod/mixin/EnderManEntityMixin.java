package me.spacety.terminatormod.mixin;

import me.spacety.terminatormod.util.CustomArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.monster.EndermanEntity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public abstract class EnderManEntityMixin {

    @Inject(method = "attackEntityFrom", at = @At("HEAD"), cancellable = true)
    private void onAttackEntityFrom(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source instanceof IndirectEntityDamageSource && ((IndirectEntityDamageSource)source).getImmediateSource() instanceof CustomArrowEntity) {
            cir.setReturnValue(false);
        }
    }

}
