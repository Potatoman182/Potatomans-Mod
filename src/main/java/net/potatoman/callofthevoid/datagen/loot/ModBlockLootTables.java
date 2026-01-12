package net.potatoman.callofthevoid.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.callofthevoid.blocks.ModBlocks;
import net.potatoman.callofthevoid.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TUNGSTEN_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TUNGSTEN_BLOCK.get());
        this.dropSelf(ModBlocks.VOID_STONE.get());
        this.dropSelf(ModBlocks.CRACKED_BEDROCK.get());

        this.dropSelf(ModBlocks.GENERIC_LOG.get());
        this.dropSelf(ModBlocks.GENERIC_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_GENERIC_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_GENERIC_WOOD.get());
        this.dropSelf(ModBlocks.GENERIC_PLANKS.get());

        this.add(ModBlocks.GENERIC_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.TUNGSTEN_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.TUNGSTEN_ORE.get(),
                block -> createSingleOreDrops(ModBlocks.TUNGSTEN_ORE.get(), ModItems.RAW_TUNGSTEN.get()));
    }

    protected LootTable.Builder createSingleOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
