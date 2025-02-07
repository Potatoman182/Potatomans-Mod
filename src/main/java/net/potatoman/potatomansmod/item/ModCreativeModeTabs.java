package net.potatoman.potatomansmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.potatomansmod.Potatomansmod;
import net.potatoman.potatomansmod.blocks.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Potatomansmod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> POTATOMANS_TAB = CREATIVE_MODE_TABS.register("potatomans_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(Moditems.VOID_BREATH_POTION.get()))
                    .title(Component.translatable("creativetab.potatomans_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.VOID_BREATH_POTION.get());
                        output.accept(Moditems.RAW_TUNGSTEN.get());
                        output.accept(Moditems.TUNGSTEN_INGOT.get());

                        output.accept(ModBlocks.CRACKED_BEDROCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
    }
}
