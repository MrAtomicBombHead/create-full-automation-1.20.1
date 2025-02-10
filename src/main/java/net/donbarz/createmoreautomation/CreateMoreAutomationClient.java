package net.donbarz.createmoreautomation;

import net.donbarz.createmoreautomation.Entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class CreateMoreAutomationClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.INK_BOTTLE_ENTITY, (context) ->
                new FlyingItemEntityRenderer(context));

        EntityRendererRegistry.register(ModEntities.GLOW_INK_BOTTLE_ENTITY, (context) ->
                new FlyingItemEntityRenderer(context));
    }
}