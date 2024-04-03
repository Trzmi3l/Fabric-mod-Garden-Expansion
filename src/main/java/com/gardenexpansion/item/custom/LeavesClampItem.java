package com.gardenexpansion.item.custom;

import com.gardenexpansion.Gardenexpansion;
import com.gardenexpansion.block.RegisterBlocks;
import com.gardenexpansion.block.custom.CrossFence;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class LeavesClampItem extends Item {

    static OwoItemSettings itemSettings = new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP).maxCount(64);

    public LeavesClampItem(){
        super(itemSettings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos bp = context.getBlockPos();
            BlockState bstate = context.getWorld().getBlockState(bp);

            if(bstate.isOf(RegisterBlocks.CROSS_FENCE)) {
                if(!bstate.get(CrossFence.FLOWERED)) {
                    bstate.with(CrossFence.FLOWERED, true);

                    context.getStack().decrement(1);

                    return ActionResult.SUCCESS;

                }
            }
        }
        return ActionResult.FAIL;
    }
}
