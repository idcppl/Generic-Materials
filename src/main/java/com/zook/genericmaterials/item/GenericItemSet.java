package com.zook.genericmaterials.item;

import com.zook.genericmaterials.GenericMaterials;
import com.zook.genericmaterials.unification.material.Material;
import com.zook.genericmaterials.unification.part.Part;
import net.minecraft.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GenericItemSet {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GenericMaterials.MODID);

    public static void init() {
        final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GenericMaterials.MODID);
        for (Part part : GenericMaterials.PART_REGISTRY.values()) {
            for (Material material : Material.MATERIAL_REGISTRY.values()) {
                if(part.doGenerateItem(material)) {
                    ITEMS.register(material.getName() + "_" + part.getName(), () -> new MaterialItem(new Item.Properties().group(GenericGroup.GENERICGROUP), material, part));
                }
            }
        }
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
