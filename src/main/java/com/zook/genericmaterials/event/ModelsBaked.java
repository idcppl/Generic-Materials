package com.zook.genericmaterials.event;

import com.zook.genericmaterials.GenericMaterials;
import com.zook.genericmaterials.unification.MaterialIconSets;
import com.zook.genericmaterials.unification.material.Material;
import com.zook.genericmaterials.unification.part.Part;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.IUnbakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.SimpleModelTransform;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModelsBaked {
    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {
        for (Part part : GenericMaterials.PART_REGISTRY.values()) {
            for (Material material : Material.MATERIAL_REGISTRY.values()) {
                if (part.doGenerateItem(material)) {
                    ModelLoader.addSpecialModel(new ResourceLocation("genericmaterials:items/material_sets/" + material.getMaterialIconSet() + "/" + part.getName()));

                }
            }
        }
    }

    @SubscribeEvent
    public static void onModelBakeEvent(ModelBakeEvent event) {
        for (Part part : GenericMaterials.PART_REGISTRY.values()) {
            for (Material material : Material.MATERIAL_REGISTRY.values()) {
                if (part.doGenerateItem(material)) {
                    registerModel(event, "genericmaterials:" + material.getName() + "_" + part.getName(), "genericmaterials:items/material_sets/" + material.getMaterialIconSet() + "/" + part.getName());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        for (Part part : GenericMaterials.PART_REGISTRY.values()) {
            for (Material material : Material.MATERIAL_REGISTRY.values()) {
                if (part.doGenerateItem(material)) {
                    event.addSprite(new ResourceLocation("genericmaterials:items/material_sets/" + material.getMaterialIconSet() + "/" + part.getName()));
                }
            }
        }
    }

    private static void registerModel(ModelBakeEvent event, String itemName, String jason) {
        IUnbakedModel model = ModelLoader.instance().getModelOrLogError(new ResourceLocation(jason), "REEEEEEEEE");
        IBakedModel bakedModel = model.bakeModel(event.getModelLoader(), ModelLoader.defaultTextureGetter(), SimpleModelTransform.IDENTITY, new ResourceLocation(jason));
        event.getModelRegistry().put(new ModelResourceLocation(itemName), bakedModel);
    }
}
