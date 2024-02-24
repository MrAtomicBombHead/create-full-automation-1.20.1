package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.ThrowEntity.GlowInkBottleItem;
import net.donbarz.createmoreautomation.ThrowEntity.GlowInkBottleEntity;
import net.donbarz.createmoreautomation.ThrowEntity.InkBottleEntity;
import net.donbarz.createmoreautomation.ThrowEntity.InkBottleItem;
import net.donbarz.createmoreautomation.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateMoreAutomation implements ModInitializer {

	public static final String MOD_ID = "createmoreautomation";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<InkBottleEntity> INK_BOTTLE_ENTITY_TYPE = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(CreateMoreAutomation.MOD_ID, "ink_bottle"),
			FabricEntityTypeBuilder.<InkBottleEntity>create(SpawnGroup.MISC, InkBottleEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT
	);
	public static final EntityType<GlowInkBottleEntity> GLOW_INK_BOTTLE_ENTITY_TYPE = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(CreateMoreAutomation.MOD_ID, "glow_ink_bottle"),
			FabricEntityTypeBuilder.<GlowInkBottleEntity>create(SpawnGroup.MISC, GlowInkBottleEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT
	);


	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		InkBottleItem.registerThrowItem();
		GlowInkBottleItem.registerThrowItem();
	}
}