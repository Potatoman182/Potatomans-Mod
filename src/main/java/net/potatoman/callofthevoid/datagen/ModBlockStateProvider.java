package net.potatoman.callofthevoid.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.callofthevoid.Callofthevoid;
import net.potatoman.callofthevoid.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Callofthevoid.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TUNGSTEN_BLOCK);
        blockWithItem(ModBlocks.RAW_TUNGSTEN_BLOCK);
        blockWithItem(ModBlocks.CRACKED_BEDROCK);
        blockWithItem(ModBlocks.VOID_STONE);

        blockWithItem(ModBlocks.TUNGSTEN_ORE);

        logBlock(((RotatedPillarBlock) ModBlocks.GENERIC_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.GENERIC_WOOD.get()), blockTexture(ModBlocks.GENERIC_LOG.get()), blockTexture(ModBlocks.GENERIC_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GENERIC_LOG.get()), blockTexture(ModBlocks.STRIPPED_GENERIC_LOG.get()),
                new ResourceLocation(Callofthevoid.MOD_ID, "block/stripped_generic_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GENERIC_WOOD.get()), blockTexture(ModBlocks.STRIPPED_GENERIC_LOG.get()), blockTexture(ModBlocks.STRIPPED_GENERIC_LOG.get()));

        blockItem(ModBlocks.GENERIC_LOG);
        blockItem(ModBlocks.GENERIC_WOOD);
        blockItem(ModBlocks.STRIPPED_GENERIC_LOG);
        blockItem(ModBlocks.STRIPPED_GENERIC_WOOD);

        blockWithItem(ModBlocks.GENERIC_PLANKS);

        leavesBlock(ModBlocks.GENERIC_LEAVES);
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Callofthevoid.MOD_ID + ":block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
}
