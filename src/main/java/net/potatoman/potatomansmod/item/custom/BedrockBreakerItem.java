package net.potatoman.potatomansmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;

public class BedrockBreakerItem extends Item {

    public BedrockBreakerItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();

        BlockState blockState = world.getBlockState(context.getClickedPos());

        if (blockState.getBlock() == Blocks.BEDROCK) {

            if (!world.isClientSide) {
                world.setBlockAndUpdate(context.getClickedPos(), Blocks.COPPER_BLOCK.defaultBlockState());
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }
}
