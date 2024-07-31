package com.github.mikephil.charting.buffer;

/* loaded from: classes.dex */
public abstract class AbstractBuffer<T> {
    public final float[] buffer;
    protected int index;
    protected float phaseX = 1.0f;
    protected float phaseY = 1.0f;
    protected int mFrom = 0;
    protected int mTo = 0;

    public abstract void feed(T t);

    public AbstractBuffer(int i) {
        this.index = 0;
        this.index = 0;
        this.buffer = new float[i];
    }

    public void limitFrom(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mFrom = i;
    }

    public void limitTo(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mTo = i;
    }

    public void reset() {
        this.index = 0;
    }

    public int size() {
        return this.buffer.length;
    }

    public void setPhases(float f, float f2) {
        this.phaseX = f;
        this.phaseY = f2;
    }
}