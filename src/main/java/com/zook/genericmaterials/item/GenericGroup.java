package com.zook.genericmaterials.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GenericGroup {
    public static final ItemGroup GENERICGROUP = new ItemGroup("genericmaterials_group")
    {
        @Override
        public ItemStack createIcon()
        {
        return new ItemStack(Items.BEDROCK);
        }
    };
}
