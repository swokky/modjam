package me.swokky.adventure.init;

import me.swokky.adventure.Adventure;
import me.swokky.adventure.items.BaseItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {

    public static final List<Supplier<Item>> BLOCK_ENTRIES = new ArrayList<>();

    public static final Map<RegistryObject<Item>, Supplier<Item>> ENTRIES = new LinkedHashMap<>();


    @SubscribeEvent
    public void onRegisterItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        BLOCK_ENTRIES.stream().map(Supplier::get).forEach(registry::register);
        ENTRIES.forEach((reg, item) -> {
            registry.register(item.get());
            reg.updateReference(registry);
        });
    }

    private static RegistryObject<Item> register(String name) {
        return register(name, () -> new BaseItem(p -> p.group(Adventure.ITEM_GROUP)));
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        ResourceLocation loc = new ResourceLocation(Adventure.MOD_ID, name);
        RegistryObject<Item> reg = RegistryObject.of(loc, ForgeRegistries.ITEMS);
        ENTRIES.put(reg, () -> item.get().setRegistryName(loc));
        return reg;
    }
}
