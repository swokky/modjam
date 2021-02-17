package me.swokky.adventure.init;

import me.swokky.adventure.world.biomes.CorruptedLandBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBiomes {

    public static Biome corrupted_land;


    public static void registerBiomes(){
        registerBiome(corrupted_land, BiomeDictionary.Type.PLAINS);
    }

    @SubscribeEvent
    public void onRegisterBiome(final RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.registerAll(
                corrupted_land = new CorruptedLandBiome()
        );

        registerBiomes();
    }
    public static void registerBiome(Biome biome, BiomeDictionary.Type... types)
    {
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(corrupted_land, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
