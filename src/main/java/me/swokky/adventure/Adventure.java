package me.swokky.adventure;

import me.swokky.adventure.init.ModBlocks;
import me.swokky.adventure.init.ModItems;
import me.swokky.adventure.utils.AdventureGroup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Adventure.MOD_ID)
public class Adventure
{

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "adventure";
    public static final ItemGroup ITEM_GROUP = new AdventureGroup();

    public Adventure()
    {

        IEventBus bus =  FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);
        bus.register(new ModBlocks());
        bus.register(new ModItems());

    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
