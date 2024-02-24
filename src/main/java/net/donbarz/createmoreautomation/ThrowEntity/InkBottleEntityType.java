package net.donbarz.createmoreautomation.ThrowEntity;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class InkBottleEntityType implements ModInitializer {

    /*
    public static final EntityType<InkBottleEntity> INK_BOTTLE_ENTITY_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(CreateMoreAutomation.MOD_ID, "ink_bottle"),
            FabricEntityTypeBuilder.<InkBottleEntity>create(SpawnGroup.MISC, InkBottleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT
    );
    */

    @Override
    public void onInitialize() {

    }
}