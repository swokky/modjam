package me.swokky.adventure.world.biomes;

import me.swokky.adventure.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.PlainsBiome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;

public class CorruptedLandBiome extends Biome {

    public CorruptedLandBiome() {
        super(new Builder()
        .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.CORRUPTED_GRASS.get().getDefaultState(), ModBlocks.CORRUPTED_DIRT.get().getDefaultState(), Blocks.GRAVEL.getDefaultState()))
        .precipitation(RainType.RAIN)
        .category(Category.PLAINS)
        .downfall(0.3f)
        .depth(0.125f)
        .temperature(0.5f)
        .scale(0.5f)
        .waterColor(0x66afba)
        .waterFogColor(0x66afba)
        .parent(null));


        this.setRegistryName("corrupted_land");
    }

}
