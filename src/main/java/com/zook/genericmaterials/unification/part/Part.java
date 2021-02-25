package com.zook.genericmaterials.unification.part;

import com.zook.genericmaterials.GenericMaterials;
import com.zook.genericmaterials.unification.material.Material;
import net.minecraft.client.resources.I18n;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class Part {
    private final @Nullable
    Predicate<Material> condition;
    private final String name;

    public Part(String name, Predicate<Material> condition) {
        this.name = name;
        this.condition = condition;
        GenericMaterials.PART_REGISTRY.put(name, this);
    }

    public String getUnlocalizedName() {
        return "part." + name;
    }

    public String getLocalizedName() {
        return I18n.format(getUnlocalizedName());
    }

    public boolean doGenerateItem(Material material) {
        return condition != null && condition.test(material);
    }

    public String getName() { return name; }
}
