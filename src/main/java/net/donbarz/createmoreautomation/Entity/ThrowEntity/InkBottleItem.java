package net.donbarz.createmoreautomation.Entity.ThrowEntity;

import net.donbarz.createmoreautomation.CreateMoreAutomation;
import net.donbarz.createmoreautomation.Entity.ModEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class InkBottleItem extends Item {

    public static final Item INKBOTTLE = registerItem("ink_bottle",new InkBottleItem(new Item.Settings().maxCount(16).group(ItemGroup.MISC)));

    public static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(CreateMoreAutomation.MOD_ID, name), item);
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
            InkBottleEntity inkBottleEntity = new InkBottleEntity(ModEntities.INK_BOTTLE_ENTITY, world);
            inkBottleEntity.setItem(itemStack);
            inkBottleEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.5F + user.getMovementSpeed(), 0.1F);
            inkBottleEntity.setPos(user.getX(),user.getY() + 1.75f ,user.getZ());

            world.spawnEntity(inkBottleEntity); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    public static void registerThrowItem() {
        CreateMoreAutomation.LOGGER.info("Registering ink_bottle from " + CreateMoreAutomation.MOD_ID);
    }
}