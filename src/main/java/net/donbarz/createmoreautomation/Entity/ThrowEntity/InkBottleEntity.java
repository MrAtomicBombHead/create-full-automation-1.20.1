package net.donbarz.createmoreautomation.Entity.ThrowEntity;

import net.donbarz.createmoreautomation.Entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.List;

public class InkBottleEntity extends ThrownItemEntity {
    public InkBottleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    private InkBottleEntity(World world, LivingEntity owner) {
        super(ModEntities.INK_BOTTLE_ENTITY, owner, world);
    }

    private InkBottleEntity(World world, double x, double y, double z) {
        super(ModEntities.INK_BOTTLE_ENTITY, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return InkBottleItem.INKBOTTLE;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        applyEffects();
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            applyEffects();
            this.getWorld().sendEntityStatus(this, (byte) 3);
        }
        spawnParticles();
        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 2F, 1F);
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F);
        this.kill();
    }

    private void applyEffects() {
        List<Entity> entities = this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(1.0D));
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 10, 0));
            }
        }
    }

    private void spawnParticles() {
        if (this.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(
                    ParticleTypes.SQUID_INK,
                    this.getX(), this.getY(), this.getZ(), // Position
                    3, // Count
                    0.1, 0.1, 0.1, // Spread
                    0 // Speed
            );
        }
    }
}