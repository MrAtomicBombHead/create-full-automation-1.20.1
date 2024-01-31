package net.donbarz.createmoreautomation.ThrowEntity;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InkBottleItem extends Item {

    public static final Item INKBOTTLE = registerItem("inkbottle",new InkBottleItem(new Item.Settings().maxCount(16)));

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(CreateMoreAutomation.MOD_ID, name), item);
    }
    public InkBottleItem(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		/*
		user.getItemCooldownManager().set(this, 5);
		Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
		*/
        if (!world.isClient) {
            InkBottleEntity inkBottleEntity = new InkBottleEntity(InkBottleEntityType.INK_BOTTLE_ENTITY_TYPE, world);
            inkBottleEntity.setItem(itemStack);
            inkBottleEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.5F, 0F);
            inkBottleEntity.setPos(user.getX(),user.getY() + 1.75f ,user.getZ());

            world.spawnEntity(inkBottleEntity); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    private static void addItemstoIngredientsCreativeTab(FabricItemGroupEntries entries){
        entries.add(INKBOTTLE);
    }

    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(CreateMoreAutomation.MOD_ID, "inkbottle"), new Item(new FabricItemSettings()));
    }
    public static void registerThrowItem() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(InkBottleItem::addItemstoIngredientsCreativeTab);
    }
}