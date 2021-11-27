package com.solvd.talab.interfaces;

import com.solvd.talab.enums.CarWashType;

@FunctionalInterface
public interface WashProcessor<T> {
    public abstract float wash();
}
