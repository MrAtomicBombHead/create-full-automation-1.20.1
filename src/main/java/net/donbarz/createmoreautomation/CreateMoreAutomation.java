package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.ThrowEntity.GlowInkBottleItem;
import net.donbarz.createmoreautomation.ThrowEntity.InkBottleItem;
import net.donbarz.createmoreautomation.ThrowEntity.InkBottleEntityType;
import net.donbarz.createmoreautomation.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateMoreAutomation implements ModInitializer {

	public static final String MOD_ID = "createmoreautomation";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		InkBottleItem.registerThrowItem();
		GlowInkBottleItem.registerThrowItem();
		EntityRendererRegistry.register(InkBottleEntityType.INK_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);

	}
}