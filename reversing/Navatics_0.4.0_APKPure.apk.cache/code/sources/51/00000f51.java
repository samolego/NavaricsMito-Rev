package com.github.mikephil.charting.highlight;

/* loaded from: classes.dex */
public final class Range {
    public float from;

    /* renamed from: to */
    public float f2597to;

    public Range(float f, float f2) {
        this.from = f;
        this.f2597to = f2;
    }

    public boolean contains(float f) {
        return f > this.from && f <= this.f2597to;
    }

    public boolean isLarger(float f) {
        return f > this.f2597to;
    }

    public boolean isSmaller(float f) {
        return f < this.from;
    }
}