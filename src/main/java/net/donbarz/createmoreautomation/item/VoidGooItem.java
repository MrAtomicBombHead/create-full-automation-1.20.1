package net.donbarz.createmoreautomation.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class VoidGooItem extends Item {
    public VoidGooItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        BlockState blockState = context.getWorld().getBlockState(pos);
        if (blockState.isIn(BlockTags.SCULK_REPLACEABLE)) {
            context.getWorld().setBlockState(pos, Blocks.SCULK.getDefaultState());
            context.getStack().decrement(1);
            context.getPlayer().playSound(SoundEvents.BLOCK_SCULK_PLACE, 1.0F, 1.0F);
            context.getWorld().playSound(null, pos, SoundEvents.BLOCK_SCULK_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return super.useOnBlock(context);
    }
}
