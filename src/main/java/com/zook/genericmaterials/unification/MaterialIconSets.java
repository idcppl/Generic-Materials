package com.zook.genericmaterials.unification;

import java.util.ArrayList;
import java.util.List;

public class MaterialIconSets {
    public static List<String> MATERIAL_ICON_REGISTRY = new ArrayList<>();

    public static String addIconSet(String name) {
        MATERIAL_ICON_REGISTRY.add(name);
        return name;
    }

    public static void init() {
        MaterialIconSets.addIconSet("diamond");
        MaterialIconSets.addIconSet("dull");
        MaterialIconSets.addIconSet("emerald");
        MaterialIconSets.addIconSet("fine");
        MaterialIconSets.addIconSet("flint");
        MaterialIconSets.addIconSet("gem_horizontal");
        MaterialIconSets.addIconSet("gem_vertical");
        MaterialIconSets.addIconSet("glass");
        MaterialIconSets.addIconSet("lapis");
        MaterialIconSets.addIconSet("lignite");
        MaterialIconSets.addIconSet("magnetic");
        MaterialIconSets.addIconSet("metallic");
        MaterialIconSets.addIconSet("netherstar");
        MaterialIconSets.addIconSet("opal");
        MaterialIconSets.addIconSet("paper");
        MaterialIconSets.addIconSet("quartz");
        MaterialIconSets.addIconSet("rough");
        MaterialIconSets.addIconSet("ruby");
        MaterialIconSets.addIconSet("sand");
        MaterialIconSets.addIconSet("shiny");
        MaterialIconSets.addIconSet("smooth");
        MaterialIconSets.addIconSet("wood");
    }
}
