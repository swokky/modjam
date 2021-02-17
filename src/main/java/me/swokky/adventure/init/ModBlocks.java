package me.swokky.adventure.init;

import me.swokky.adventure.Adventure;
import me.swokky.adventure.blocks.BaseBlock;
import me.swokky.adventure.blocks.BaseBlockItem;
import me.swokky.adventure.blocks.CorruptedGrassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks
{

    public static final Map<RegistryObject<Block>, Supplier<Block>> ENTRIES = new LinkedHashMap<>();

    public static final RegistryObject<Block> CORRUPTED_DIRT = register("corrupted_dirt", () -> new BaseBlock(Material.ORGANIC, properties -> properties.sound(SoundType.GROUND)));
    public static final RegistryObject<Block> CORRUPTED_GRASS = register("corrupted_grass",CorruptedGrassBlock::new);


    @SubscribeEvent
    public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();

        ENTRIES.forEach((reg, block) -> {
            registry.register(block.get());
            reg.updateReference(registry);
        });
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        return register(name, block, b -> () -> new BaseBlockItem(b.get(), p -> p.group(Adventure.ITEM_GROUP)));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Function<RegistryObject<Block>, Supplier<? extends BlockItem>> item) {
        ResourceLocation loc = new ResourceLocation(Adventure.MOD_ID, name);
        RegistryObject<Block> reg = RegistryObject.of(loc, ForgeRegistries.BLOCKS);
        ENTRIES.put(reg, () -> block.get().setRegistryName(loc));
        ModItems.BLOCK_ENTRIES.add(() -> item.apply(reg).get().setRegistryName(loc));
        return reg;
    }
}
