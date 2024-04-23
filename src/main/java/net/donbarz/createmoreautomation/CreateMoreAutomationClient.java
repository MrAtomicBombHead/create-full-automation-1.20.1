package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.Entity.ModEntities;
import net.donbarz.createmoreautomation.Entity.ThrowEntity.GlowInkBottleEntityType;
import net.donbarz.createmoreautomation.Entity.ThrowEntity.InkBottleEntityType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CreateMoreAutomationClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //EntityRendererRegistry.register(InkBottleEntityType.INK_BOTTLE_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(InkBottleEntityType.INK_BOTTLE_ENTITY_TYPE, (context) ->
                new FlyingItemEntityRenderer(context));

        EntityRendererRegistry.register(ModEntities.GLOW_INK_BOTTLE_ENTITY, (context) ->
                new FlyingItemEntityRenderer(context));
    }
}