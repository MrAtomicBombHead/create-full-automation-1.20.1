package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.entity.custom.InkBottleEntity;
import net.donbarz.createmoreautomation.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
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

	public static final EntityType<InkBottleEntity> INK_BOTTLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "packed_snowball"),
			FabricEntityTypeBuilder.<InkBottleEntity>create(SpawnGroup.MISC, InkBottleEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build()
	);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}