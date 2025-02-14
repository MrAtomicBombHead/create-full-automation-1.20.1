package net.donbarz.createmoreautomation.item;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //public static final Item exampleItem = registerItem("example", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item SALPETRE = registerItem("salpetre", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item COSMICSOOT = registerItem("cosmic_soot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item SULFUR = registerItem("sulfur", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    //public static final Item VOIDGOO = registerItem("void_goo", new Item(new FabricItemSettings()));

    public static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(CreateMoreAutomation.MOD_ID, name), item);
    }
    public static void registerModItems(){
        CreateMoreAutomation.LOGGER.info("Registering Items for " + CreateMoreAutomation.MOD_ID);
    }
}

