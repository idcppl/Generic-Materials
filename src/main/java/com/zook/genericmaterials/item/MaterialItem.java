package com.zook.genericmaterials.item;

import com.zook.genericmaterials.unification.material.Material;
import com.zook.genericmaterials.unification.part.Part;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MaterialItem extends Item {
    private final Material material;
    private final Part part;

    public MaterialItem(Properties properties, Material material, Part part) {
        super(properties);
        this.material = material;
        this.part = part;
    }

    public Material getMaterial() {
        return material;
    }

    public Part getPart() {
        return part;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public ITextComponent getDisplayName(ItemStack stack) {
        return new StringTextComponent(I18n.format(part.getUnlocalizedName(), material.getLocalizedName()));
    }
}
