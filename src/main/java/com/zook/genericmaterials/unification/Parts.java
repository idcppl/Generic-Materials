package com.zook.genericmaterials.unification;

import com.zook.genericmaterials.unification.material.DustMaterial;
import com.zook.genericmaterials.unification.material.IngotMaterial;
import com.zook.genericmaterials.unification.material.SolidMaterial;
import com.zook.genericmaterials.unification.part.Part;

public class Parts {
    public static void init() {
        new Part("ingot", (mat) -> mat instanceof IngotMaterial);
        new Part("plate", (mat) -> mat instanceof DustMaterial && mat.hasFlag("GENERATE_PLATE"));
        new Part("dust", (mat) -> mat instanceof DustMaterial);
        new Part("dust_small", (mat) -> mat instanceof DustMaterial);
        new Part("dust_tiny", (mat) -> mat instanceof DustMaterial);
        new Part("dust_impure", (mat) -> mat instanceof DustMaterial);
        new Part("dust_pure", (mat) -> mat instanceof DustMaterial);
        new Part("rod", (mat) -> mat instanceof SolidMaterial && mat.hasFlag("GENERATE_ROD"));
    }
}
