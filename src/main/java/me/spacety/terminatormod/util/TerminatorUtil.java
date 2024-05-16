package me.spacety.terminatormod.util;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class TerminatorUtil {

    public static void launchArrows(LivingEntity entity) {
        World world = entity.getEntityWorld();
        float yaw = entity.rotationYaw;
        float pitch = entity.rotationPitch;
        Vector3d eyePosition = entity.getEyePosition(1.0F);

        Vector3d direction1 = yawPitchToVector3d(yaw + 3, pitch);
        Vector3d direction2 = yawPitchToVector3d(yaw - 3, pitch);
        Vector3d direction3 = yawPitchToVector3d(yaw, pitch);

        shootArrow(world, eyePosition, direction1, entity);
        shootArrow(world, eyePosition, direction2, entity);
        shootArrow(world, eyePosition, direction3, entity);
    }

    private static Vector3d yawPitchToVector3d(float yaw, float pitch) {
        double radiansYaw = Math.toRadians(yaw);
        double radiansPitch = Math.toRadians(pitch);
        double x = -Math.sin(radiansYaw) * Math.cos(radiansPitch);
        double y = -Math.sin(radiansPitch);
        double z = Math.cos(radiansYaw) * Math.cos(radiansPitch);
        return new Vector3d(x, y, z);
    }

    private static void shootArrow(World world, Vector3d position, Vector3d direction, LivingEntity shooter) {
        CustomArrowEntity arrow = new CustomArrowEntity(EntityType.ARROW, world);
        arrow.setPosition(position.x, position.y, position.z);
        arrow.setShooter(shooter);
        arrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
        arrow.shoot(direction.x, direction.y, direction.z, 3.6F, 0.0F);
        world.addEntity(arrow);
    }
}
