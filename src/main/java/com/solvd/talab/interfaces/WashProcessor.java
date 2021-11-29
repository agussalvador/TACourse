package com.solvd.talab.interfaces;

import com.solvd.talab.enums.CarWashType;

@FunctionalInterface
public interface WashProcessor {
    public abstract float wash(float time);
}
