package net.potatoman.potatomansmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Block;

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
                world.setBlockAndUpdate(context.getClickedPos(), Blocks.CRYING_OBSIDIAN.defaultBlockState());

                spawnBlockBreakingParticles(world, context.getClickedPos(), blockState);

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
    private void spawnBlockBreakingParticles(Level world, BlockPos pos, BlockState blockState) {

        if (world.isClientSide) {

            BlockParticleOption particleData = new BlockParticleOption(ParticleTypes.BLOCK, blockState);

            world.addParticle(particleData, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.5, 0.5, 0.5);
        } else {

            int blockId = Block.getId(blockState);
            world.levelEvent(2001, pos, blockId);
        }
    }
}
