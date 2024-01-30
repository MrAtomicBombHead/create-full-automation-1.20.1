package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.ThrowEntity.ModProjectiles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CreateMoreAutomationClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModProjectiles.INK_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
    }
}
