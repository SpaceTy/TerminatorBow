package me.spacety.terminatormod.util;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class CustomArrowEntity extends ArrowEntity {
    public CustomArrowEntity(EntityType<? extends ArrowEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);
        if (living instanceof EndermanEntity) {
            EndermanEntity enderman = (EndermanEntity) living;
            enderman.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 1));
        }
    }
}
