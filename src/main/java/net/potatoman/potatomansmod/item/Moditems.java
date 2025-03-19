package net.potatoman.potatomansmod.item;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.potatoman.potatomansmod.Potatomansmod;
import net.potatoman.potatomansmod.item.custom.BedrockBreakerItem;

public class Moditems {
    public static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Potatomansmod.MOD_ID);

    public static final RegistryObject<Item> VOID_BREATH_POTION = ITEMS.register("void_breath_potion",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_ARROW_HEAD = ITEMS.register("tungsten_arrow_head",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_ARROW = ITEMS.register("tungsten_arrow",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_BREAKER = ITEMS.register("bedrock_breaker",
            () -> new BedrockBreakerItem(new Item.Properties().durability(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
