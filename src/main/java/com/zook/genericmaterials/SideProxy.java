package com.zook.genericmaterials;

import com.zook.genericmaterials.item.MaterialItem;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

public class SideProxy {
    SideProxy() {

    }

    static class Server extends SideProxy {
        Server() {

        }
    }

    static class Client extends SideProxy {
        Client() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::onItemColors);
        }
    }
    public static void onItemColors(ColorHandlerEvent.Item event) {
        ItemColors itemColors = event.getItemColors();
        if (itemColors == null) {
            GenericMaterials.LOGGER.error("ItemColors is brokeded.", new IllegalStateException("call 911"));
        }

        ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item instanceof MaterialItem)
                .map(item -> (MaterialItem) item)
                .forEach(item -> itemColors.register((stack, color) -> color % 2 == 1 ? 0xFFFFFF : item.getMaterial().getColor(), item));
    }


}
