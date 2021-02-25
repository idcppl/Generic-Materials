package com.zook.genericmaterials.unification;

import com.zook.genericmaterials.unification.material.MaterialFlags;

public class Flags {
    public static void init() {
        final long GENERATE_PLATE = MaterialFlags.createDustFlag("GENERATE_PLATE", 1);
        final long GENERATE_ROD = MaterialFlags.createSolidFlag("GENERATE_ROD", 2);
        final long GENERATE_GEAR = MaterialFlags.createSolidFlag("GENERATE_GEAR", 3);
    }
}
