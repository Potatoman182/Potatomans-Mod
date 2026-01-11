package net.potatoman.callofthevoid.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.callofthevoid.Callofthevoid;
import net.potatoman.callofthevoid.item.ModItems;
import org.openjdk.nashorn.internal.codegen.CompilerConstants;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output,Callofthevoid.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.VOID_BREATH_POTION);
        simpleItem(ModItems.BEDROCK_BREAKER);
        simpleItem(ModItems.RAW_TUNGSTEN);
        simpleItem(ModItems.TUNGSTEN_INGOT);
        simpleItem(ModItems.TUNGSTEN_NUGGET);
        simpleItem(ModItems.TUNGSTEN_ARROW_HEAD);
        simpleItem(ModItems.TUNGSTEN_ARROW);
        simpleItem(ModItems.RAW_VOID_HOPPER_LEG);
        simpleItem(ModItems.VOID_HOPPER_POISON_BALL);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Callofthevoid.MOD_ID,"item/" + item.getId().getPath()));
    }
}
