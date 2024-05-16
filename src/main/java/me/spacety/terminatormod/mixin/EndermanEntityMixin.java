package me.spacety.terminatormod.mixin;

import me.spacety.terminatormod.util.CustomArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.monster.EndermanEntity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin {

    private static final Logger LOGGER = LoggerFactory.getLogger(EndermanEntityMixin.class);

    @Inject(method = "attackEntityFrom", at = @At("HEAD"), cancellable = true)
    private void onAttackEntityFrom(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LOGGER.info("Mixin applied: onAttackEntityFrom called");
        if (source instanceof IndirectEntityDamageSource && ((IndirectEntityDamageSource)source).getImmediateSource() instanceof CustomArrowEntity) {
            LOGGER.info("CustomArrowEntity detected, cancelling damage");
            cir.setReturnValue(false);
        }
    }
}
