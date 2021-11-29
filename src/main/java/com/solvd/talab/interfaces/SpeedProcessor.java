package com.solvd.talab.interfaces;

import java.util.List;

@FunctionalInterface
public interface SpeedProcessor {
    public abstract float avgSpeed(float speed, float kilometers);
}
