package net.donbarz.createmoreautomation.Entity.ThrowEntity;

import net.fabricmc.api.ModInitializer;

public class GlowInkBottleEntityType implements ModInitializer {

    /* CLASS NO LONGER USED
    public static final EntityType<GlowInkBottleEntity> GLOW_INK_BOTTLE_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(CreateMoreAutomation.MOD_ID, "glow_ink_bottle"),
            FabricEntityTypeBuilder.<GlowInkBottleEntity>create(SpawnGroup.MISC, GlowInkBottleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT
    );

     */
    @Override
    public void onInitialize() {

    }

}