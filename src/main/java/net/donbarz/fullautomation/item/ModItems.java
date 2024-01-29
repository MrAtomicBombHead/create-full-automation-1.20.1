package net.donbarz.fullautomation.item;

import net.donbarz.fullautomation.FullAutomation;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import org.intellij.lang.annotations.Identifier;

public class ModItems {

    public static final Item INKBOTTLE = registerItem("inkbottle", new Item(new FabricItemSettings()));
    public static final Item GLOWINKBOTTLE = registerItem("glowinkbottle", new Item(new FabricItemSettings()));

    private static void addItemstoIngredientsCreativeTab(FabricItemGroupEntries entries){
        entries.add(INKBOTTLE);
        entries.add(GLOWINKBOTTLE);
    }

    private static Item registerItem(String name, Item item){

        return Registry.register(Registries.ITEM, new Identifier(FullAutomation.MOD_ID, name), item);
    }
    public static void registerModItems(){

        FullAutomation.LOGGER.info("Registering Items for " + FullAutomation.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngredientsCreativeTab);

    }
}