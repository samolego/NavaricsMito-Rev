package com.github.mikephil.charting.highlight;

/* loaded from: classes.dex */
public final class Range {
    public float from;

    /* renamed from: to */
    public float f2589to;

    public Range(float f, float f2) {
        this.from = f;
        this.f2589to = f2;
    }

    public boolean contains(float f) {
        return f > this.from && f <= this.f2589to;
    }

    public boolean isLarger(float f) {
        return f > this.f2589to;
    }

    public boolean isSmaller(float f) {
        return f < this.from;
    }
}
