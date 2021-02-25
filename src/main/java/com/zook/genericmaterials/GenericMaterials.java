package com.zook.genericmaterials;

import com.zook.genericmaterials.item.GenericItemSet;
import com.zook.genericmaterials.unification.Flags;
import com.zook.genericmaterials.unification.MaterialIconSets;
import com.zook.genericmaterials.unification.Materials;
import com.zook.genericmaterials.unification.Parts;
import com.zook.genericmaterials.unification.part.Part;
import net.minecraftforge.fml.DistExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.HashMap;
import java.util.Map;

@Mod("genericmaterials")
public class GenericMaterials {
    public static final String MODID = "genericmaterials";
    public static final Logger LOGGER = LogManager.getLogger();

    public static Map<String, Part> PART_REGISTRY = new HashMap<>();

    public GenericMaterials() {
        Flags.init();
        MaterialIconSets.init();
        Materials.init();
        Parts.init();
        GenericItemSet.init();
        DistExecutor.safeRunForDist(() -> SideProxy.Client::new, () -> SideProxy.Server::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        LOGGER.info("test");
    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void clientSetup(final FMLClientSetupEvent event) {}

    private void serverSetup(final FMLDedicatedServerSetupEvent event) {}
}
