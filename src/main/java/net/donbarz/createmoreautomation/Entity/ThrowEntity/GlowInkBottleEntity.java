package net.donbarz.createmoreautomation.Entity.ThrowEntity;

import net.donbarz.createmoreautomation.Entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class GlowInkBottleEntity extends ThrownItemEntity {
    public GlowInkBottleEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GlowInkBottleEntity(World world, LivingEntity owner) {
        super(ModEntities.GLOW_INK_BOTTLE_ENTITY, owner, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return GlowInkBottleItem.GLOWINKBOTTLE; // We will configure this later, once we have created the ProjectileItem.
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        if (!this.getWorld().isClient) { //sends status to server I think
            this.getWorld().sendEntityStatus(this, (byte) 3); // particle?
        }

        //entity hit
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.GLOWING, 20 * 40, 0))); // applies a status effect
            this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }

        //sounds
        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 3F, 1F);
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F);

        this.discard();
        super.onEntityHit(entityHitResult);
    }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) { //sends status to server I think
            this.getWorld().sendEntityStatus(this, (byte) 3); // particle?
        }

        this.getWorld().addParticle(ParticleTypes.GLOW_SQUID_INK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        playSound(SoundEvents.BLOCK_HONEY_BLOCK_BREAK, 2F, 1F);
        playSound(SoundEvents.BLOCK_GLASS_BREAK, 0.2F, 1F);

        this.discard();
        super.onBlockHit(blockHitResult);

    }
}