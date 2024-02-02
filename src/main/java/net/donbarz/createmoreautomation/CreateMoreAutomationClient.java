package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.ThrowEntity.GlowInkBottleEntityType;
import net.donbarz.createmoreautomation.ThrowEntity.InkBottleEntityType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CreateMoreAutomationClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(InkBottleEntityType.INK_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(GlowInkBottleEntityType.GLOW_INK_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
    }
}
