package com.zook.genericmaterials.unification;

import com.zook.genericmaterials.unification.material.IngotMaterial;

public class Materials {
    public static void init() {
        new IngotMaterial("red_metal", 0xFF0000, "shiny", 0);
        new IngotMaterial("yellow_metal", 0xFFFF00, "shiny", 0);
        new IngotMaterial("blue_metal", 0x0000FF, "shiny", 0);
    }
}
