package com.gardenexpansion.block.states;

import net.minecraft.util.StringIdentifiable;

public enum CrossFenceFlowerType implements StringIdentifiable{
    NONE("none"),
    ROSE("rose"), // rose bush and poppy
    LILAC("lilac"),
    AZALEA("azalea"),
    CHERRY("cherry"); // cherry sapling

    private final String name;

    private CrossFenceFlowerType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
