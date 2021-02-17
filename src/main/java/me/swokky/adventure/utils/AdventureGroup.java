package me.swokky.adventure.utils;

import me.swokky.adventure.Adventure;
import me.swokky.adventure.init.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AdventureGroup extends ItemGroup {

    public AdventureGroup(){
        super(Adventure.MOD_ID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.CORRUPTED_DIRT.get());
    }
}
