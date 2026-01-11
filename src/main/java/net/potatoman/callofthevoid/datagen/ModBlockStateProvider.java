package net.potatoman.callofthevoid.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.callofthevoid.Callofthevoid;
import net.potatoman.callofthevoid.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Callofthevoid.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockwithitem(ModBlocks.TUNGSTEN_BLOCK);
        blockwithitem(ModBlocks.RAW_TUNGSTEN_BLOCK);
        blockwithitem(ModBlocks.CRACKED_BEDROCK);
        blockwithitem(ModBlocks.VOID_STONE);

        blockwithitem(ModBlocks.TUNGSTEN_ORE);

    }

    private void blockwithitem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
}
