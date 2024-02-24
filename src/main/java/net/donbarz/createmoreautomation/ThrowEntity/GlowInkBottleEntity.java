package net.donbarz.createmoreautomation.ThrowEntity;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.List;

public class GlowInkBottleEntity extends ThrownItemEntity {
    public GlowInkBottleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    private GlowInkBottleEntity(World world, LivingEntity owner) {
        super(GlowInkBottleEntityType.GLOW_INK_BOTTLE_ENTITY_TYPE, owner, world); // null will be changed later
    }

    private GlowInkBottleEntity(World world, double x, double y, double z) {
        super(GlowInkBottleEntityType.GLOW_INK_BOTTLE_ENTITY_TYPE, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return GlowInkBottleItem.GLOWINKBOTTLE; // We will configure this later, once we have created the ProjectileItem.
    }


    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)

        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.GLOWING, 20 * 40, 0))); // applies a status effect
            this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }

        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 3F, 1F); // plays a sound for the entity hit only
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F); // plays a sound for the entity hit only

        this.kill(); // kills the projectile
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) { // checks if the world is client
            this.getWorld().sendEntityStatus(this, (byte)3); // particle?
        }
        this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 2F, 1F); // plays a sound for the entity hit only
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F); // plays a sound for the entity hit only

        this.kill(); // kills the projectile

    }
}