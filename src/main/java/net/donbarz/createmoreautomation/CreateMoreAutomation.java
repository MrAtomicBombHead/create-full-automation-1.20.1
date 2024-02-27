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

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		InkBottleItem.registerThrowItem();
		GlowInkBottleItem.registerThrowItem();
	}
}