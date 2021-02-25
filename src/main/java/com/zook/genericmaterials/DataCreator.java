package com.zook.genericmaterials;

import com.zook.genericmaterials.item.MaterialItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCreator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        if(event.includeClient()) {
            gen.addProvider(new Language(gen));
            gen.addProvider(new ItemModels(gen, helper));
        }
        GenericMaterials.LOGGER.info("I tried");
    }

    private static class Language extends LanguageProvider {
        public Language(DataGenerator gen) {
            super(gen, GenericMaterials.MODID, "en_us");
        }
        @Override
        protected void addTranslations() {
            for(Item registryItem : ForgeRegistries.ITEMS.getValues()) {
                if(registryItem instanceof MaterialItem) {
                    MaterialItem item = (MaterialItem) registryItem;
                    String localizedName = item.getPart().getLocalizedName().replace("%s", item.getMaterial().getLocalizedName());
                    add(item, localizedName);
                }
            }
        }
    }

    private static class ItemModels extends ItemModelProvider {
        public ItemModels(DataGenerator gen, ExistingFileHelper helper) {
            super(gen, GenericMaterials.MODID, helper);
        }

        @Override
        protected void registerModels() {
            for(Item registryItem : ForgeRegistries.ITEMS.getValues()) {
                if(registryItem instanceof MaterialItem) {
                    MaterialItem item = (MaterialItem) registryItem;
                    getBuilder(item.getMaterial().getUnlocalizedName() + "_" + item.getPart().getUnlocalizedName()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + item.getPart().getUnlocalizedName()));
                }
            }
        }

        @Override
        public String getName() {
            return "Item Models";
        }
    }
}
