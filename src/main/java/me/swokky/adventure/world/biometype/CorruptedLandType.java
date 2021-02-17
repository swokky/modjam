package me.swokky.adventure.world.biometype;

import me.swokky.adventure.init.ModBiomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class CorruptedLandType extends WorldType {


    public CorruptedLandType() {
        super("cland_type");
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator(World world) {

        OverworldGenSettings genSettings = new OverworldGenSettings();
        SingleBiomeProviderSettings singleSettings = new SingleBiomeProviderSettings(world.getWorldInfo());
        singleSettings.setBiome(ModBiomes.corrupted_land);

        return new OverworldChunkGenerator(world, new SingleBiomeProvider(singleSettings), genSettings);
    }
}
