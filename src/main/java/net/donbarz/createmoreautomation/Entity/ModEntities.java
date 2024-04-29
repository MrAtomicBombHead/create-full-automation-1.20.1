package net.donbarz.createmoreautomation.Entity;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.donbarz.createmoreautomation.Entity.ThrowEntity.GlowInkBottleEntity;
import net.donbarz.createmoreautomation.Entity.ThrowEntity.InkBottleEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class ModEntities {

    public static final EntityType<GlowInkBottleEntity> GLOW_INK_BOTTLE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CreateMoreAutomation.MOD_ID, "glow_ink_bottle"),
            FabricEntityTypeBuilder.<GlowInkBottleEntity>create(SpawnGroup.MISC, GlowInkBottleEntity::new)
            .dimensions(EntityDimensions.fixed(.25f,.25f)).build());

    public static final EntityType<InkBottleEntity> INK_BOTTLE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(CreateMoreAutomation.MOD_ID, "ink_bottle"),
            FabricEntityTypeBuilder.<InkBottleEntity>create(SpawnGroup.MISC, InkBottleEntity::new)
            .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());

    public static void registerEntities() {
        CreateMoreAutomation.LOGGER.info("Registering entities for " + CreateMoreAutomation.MOD_ID);
    }
}
