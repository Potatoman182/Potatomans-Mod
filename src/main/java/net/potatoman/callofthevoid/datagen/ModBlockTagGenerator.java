package net.potatoman.callofthevoid.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.potatoman.callofthevoid.Callofthevoid;
import net.potatoman.callofthevoid.blocks.ModBlocks;
import net.potatoman.callofthevoid.tags.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,@Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Callofthevoid.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(ModTags.Blocks.)
                //.add(ModBlocks. .get())

        //this.tag(BlockTags.NEEDS_IRON_TOOL)
                //.add(ModBlocks..get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.CRACKED_BEDROCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TUNGSTEN_BLOCK.get(),
                    ModBlocks.RAW_TUNGSTEN_BLOCK.get(),
                    ModBlocks.TUNGSTEN_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.VOID_STONE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VOID_STONE.get(),
                    ModBlocks.TUNGSTEN_BLOCK.get(),
                    ModBlocks.RAW_TUNGSTEN_BLOCK.get(),
                    ModBlocks.TUNGSTEN_ORE.get(),
                    ModBlocks.CRACKED_BEDROCK.get());
    }
}
