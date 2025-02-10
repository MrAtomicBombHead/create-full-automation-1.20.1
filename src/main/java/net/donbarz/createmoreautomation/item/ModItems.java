package net.donbarz.createmoreautomation.item;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //public static final Item exampleItem = registerItem("example", new Item(new FabricItemSettings()));
    public static final Item COSMICSOOT = registerItem("cosmic_soot", new Item(new FabricItemSettings()));
    public static final Item VOIDGOO = registerItem("void_goo", new Item(new FabricItemSettings()));
    private static void addItemstoIngredientsCreativeTab(FabricItemGroupEntries entries){
        //entries.add(exampleItem);
        entries.add(COSMICSOOT);
        entries.add(VOIDGOO);
    }

    public static Item registerItem(String name, Item item){

        return Registry.register(Registries.ITEM, new Identifier(CreateMoreAutomation.MOD_ID, name), item);
    }
    public static void registerModItems(){

        CreateMoreAutomation.LOGGER.info("Registering Items for " + CreateMoreAutomation.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngredientsCreativeTab);

    }
}

