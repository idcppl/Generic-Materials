package com.zook.genericmaterials.unification.material;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MaterialFlags {
    public static Map<String, Entry<Long, Class<? extends Material>>> FLAG_REGISTRY = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public static void register(String name, long value, Class<? extends  Material> type) {
        FLAG_REGISTRY.put(name, new SimpleEntry<>(value, type));
    }

    public static long createMaterialFlag(String name, long value) {
        register(name, 1 << value, Material.class);
        return 1 << value;
    }

    public static long createFluidFlag(String name, long value) {
        register(name, 1 << value, FluidMaterial.class);
        return 1 << value;
    }

    public static long createDustFlag(String name, long value) {
        register(name, 1 << value, DustMaterial.class);
        return 1 << value;
    }

    public static long createSolidFlag(String name, long value) {
        register(name, 1 << value, SolidMaterial.class);
        return 1 << value;
    }

    public static long createIngotFlag(String name, long value) {
        register(name, 1 << value, IngotMaterial.class);
        return 1 << value;
    }

    public static long createGemFlag(String name, long value) {
        register(name, 1 << value, GemMaterial.class);
        return 1 << value;
    }

    public static long resolveFlag(String name, Class<? extends Material> type) {
        Entry<Long, Class<? extends Material>> flagEntry = FLAG_REGISTRY.get(name);
        if(flagEntry == null) {
            throw new IllegalArgumentException("Flag with name " + name + " not registered");
        } else if(!flagEntry.getValue().isAssignableFrom(type)) {
            throw new IllegalArgumentException("Flag " + name + " cannot be applied to material type " +
                    type.getSimpleName() + ", lower bound is " + flagEntry.getValue().getSimpleName());
        }
        return flagEntry.getKey();
    }
}
