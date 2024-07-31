package com.navatics.app.framework.p049g;

import java.util.Arrays;

/* compiled from: MiddleFloatValueFilter.java */
/* renamed from: com.navatics.app.framework.g.a, reason: use source file name */
/* loaded from: classes.dex */
public class MiddleFloatValueFilter extends ValueFilter<Float> {

    /* renamed from: a */
    private int f4693a;

    /* renamed from: b */
    private int f4694b;

    /* renamed from: c */
    private int f4695c;

    /* renamed from: d */
    private float[] f4696d;

    /* renamed from: e */
    private float[] f4697e;

    public MiddleFloatValueFilter(int i) {
        this.f4693a = 0;
        this.f4695c = 11;
        if (i % 2 == 0) {
            throw new RuntimeException("valueCount must be odd");
        }
        this.f4695c = i;
        m4894c();
    }

    public MiddleFloatValueFilter() {
        this.f4693a = 0;
        this.f4695c = 11;
        m4894c();
    }

    /* renamed from: c */
    private void m4894c() {
        int i = this.f4695c;
        this.f4696d = new float[i];
        this.f4697e = new float[i];
        this.f4694b = i / 2;
    }

    @Override // com.navatics.app.framework.p049g.ValueFilter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Float mo4898b(Float f) {
        float[] fArr = this.f4696d;
        int i = this.f4693a;
        this.f4693a = i + 1;
        fArr[i % this.f4695c] = f.floatValue();
        float[] fArr2 = this.f4696d;
        System.arraycopy(fArr2, 0, this.f4697e, 0, fArr2.length);
        Arrays.sort(this.f4697e);
        return Float.valueOf(this.f4697e[this.f4694b]);
    }

    @Override // com.navatics.app.framework.p049g.ValueFilter
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo4896a(Float f) {
        float[] fArr = this.f4696d;
        int i = this.f4693a;
        this.f4693a = i + 1;
        fArr[i % this.f4695c] = f.floatValue();
        float[] fArr2 = this.f4696d;
        System.arraycopy(fArr2, 0, this.f4697e, 0, fArr2.length);
        Arrays.sort(this.f4697e);
    }

    @Override // com.navatics.app.framework.p049g.ValueFilter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float mo4897b() {
        return Float.valueOf(this.f4697e[this.f4694b]);
    }
}