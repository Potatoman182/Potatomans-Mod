package net.potatoman.callofthevoid.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Block;
import net.potatoman.callofthevoid.blocks.ModBlocks;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class BedrockBreakerItem extends Item {
    public BedrockBreakerItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        Player player1 = pContext.getPlayer();

        BlockPos pos = pContext.getClickedPos();
        BlockState blockState = world.getBlockState(pos);

        if (blockState.getBlock() == Blocks.BEDROCK) {
            if (!world.isClientSide) {
                world.setBlockAndUpdate(pos, ModBlocks.CRACKED_BEDROCK.get().defaultBlockState());

                spawnBlockBreakingParticles(world, pos, blockState);

                pContext.getItemInHand().hurtAndBreak(1, player1,
                        player -> player.broadcastBreakEvent(player.getUsedItemHand()));
            }
            return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.potatomansmod.bedrock_breaker.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
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

