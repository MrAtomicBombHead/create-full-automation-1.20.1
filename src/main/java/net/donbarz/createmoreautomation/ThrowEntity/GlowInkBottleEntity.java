package net.donbarz.createmoreautomation.ThrowEntity;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.List;

public class GlowInkBottleEntity extends ThrownItemEntity {
    public GlowInkBottleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GlowInkBottleEntity(World world, LivingEntity owner) {
        super(GlowInkBottleEntityType.GLOW_INK_BOTTLE_ENTITY_TYPE, owner, world);
    }

    public GlowInkBottleEntity(World world, double x, double y, double z) {
        super(GlowInkBottleEntityType.GLOW_INK_BOTTLE_ENTITY_TYPE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return GlowInkBottleItem.GLOWINKBOTTLE;
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
        }
        this.discard();
        super.onEntityHit(entityHitResult);

        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)

        if (entity instanceof LivingEntity livingEntity) { // checks if entity is not a boat or minecart
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.GLOWING, 20 * 40, 0))); // applies a status effect
            this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }

        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 3F, 1F); // plays a sound for the entity hit only
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F); // plays a sound for the entity hit only
    }


    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
        }
        this.discard();
        super.onBlockHit(blockHitResult);
        this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 2F, 1F); // plays a sound for the entity hit only
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F); // plays a sound for the entity hit only
    }
}