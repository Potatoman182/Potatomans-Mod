package net.potatoman.callofthevoid.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.callofthevoid.Callofthevoid;
import net.potatoman.callofthevoid.blocks.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Callofthevoid.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CALL_OF_THE_VOID_TAB = CREATIVE_MODE_TABS.register("callofthevoid_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.VOID_BREATH_POTION.get()))
                    .title(Component.translatable("creativetab.callofthevoid_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.VOID_BREATH_POTION.get());
                        output.accept(ModItems.RAW_TUNGSTEN.get());
                        output.accept(ModItems.TUNGSTEN_INGOT.get());
                        output.accept(ModItems.TUNGSTEN_NUGGET.get());
                        output.accept(ModItems.TUNGSTEN_ARROW_HEAD.get());
                        output.accept(ModItems.TUNGSTEN_ARROW.get());
                        output.accept(ModItems.BEDROCK_BREAKER.get());
                        output.accept(ModItems.RAW_VOID_HOPPER_LEG.get());
                        output.accept(ModItems.VOID_HOPPER_POISON_BALL.get());

                        output.accept(ModBlocks.CRACKED_BEDROCK.get());
                        output.accept(ModBlocks.TUNGSTEN_BLOCK.get());
                        output.accept(ModBlocks.VOID_STONE.get());
                        output.accept(ModBlocks.TUNGSTEN_ORE.get());
                        output.accept(ModBlocks.RAW_TUNGSTEN_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
    }
}
