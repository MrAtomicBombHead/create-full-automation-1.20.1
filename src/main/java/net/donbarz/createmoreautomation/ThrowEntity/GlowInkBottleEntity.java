package net.donbarz.createmoreautomation.ThrowEntity;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

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
        //int i = entity instanceof BlazeEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity

        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.GLOWING, 20 * 120, 0))); // applies a status effect
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 25, 0))); // applies a status effect
            livingEntity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 2F, 1F); // plays a sound for the entity hit only
            ItemUsageContext spawnParticle;
            //spawnParticle = getWorld().addParticle(new ParticleEffect(ParticleTypes.SQUID_INK,livingEntity.getX(),livingEntity.getY() + 1,livingEntity.getZ(), 0 , 0 , 0 ));
            playSound(SoundEvents.BLOCK_GLASS_BREAK, 2F, 1F); // plays a sound for the entity hit only
        }
        this.kill();
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) { // checks if the world is client
            this.getWorld().sendEntityStatus(this, (byte)3); // particle?
            playSound(SoundEvents.BLOCK_GLASS_BREAK, 2F, 1F); // plays a sound for the entity hit only
            this.kill(); // kills the projectile
        }

    }
}