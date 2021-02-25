package com.zook.genericmaterials.unification.material;

import net.minecraft.client.resources.I18n;

import java.util.HashMap;
import java.util.Map;

public abstract class Material {
    private final int color;
    private final String materialIconSet;
    private final String name;
    protected long generationFlag;
    public static Map<String, Material> MATERIAL_REGISTRY = new HashMap<>();

    public Material(String name, int color, String materialIconSet, long generationFlag) {
        this.name = name;
        this.color = color;
        this.materialIconSet = materialIconSet;
        this.generationFlag = generationFlag;
        MATERIAL_REGISTRY.put(name, this);
    }

    public String getUnlocalizedName() {
        return "material." + name;
    }

    public String getLocalizedName() { return I18n.format(getUnlocalizedName()); }

    public int getColor() {
        return color;
    }

    public String getMaterialIconSet() {
        return materialIconSet;
    }

    public long getGenerationFlag() {
        return generationFlag;
    }

    public boolean hasFlag(long flag) {
        return (generationFlag & flag) >= flag;
    }

    public boolean hasFlag(String flagName) {
        long materialFlagID = MaterialFlags.resolveFlag(flagName, getClass());
        return hasFlag(materialFlagID);
    }

    public String getName() {
        return name;
    }
}
