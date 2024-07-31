package com.navatics.app.framework.p055g;

import java.util.Arrays;

/* renamed from: com.navatics.app.framework.g.a */
/* loaded from: classes.dex */
public class MiddleFloatValueFilter extends ValueFilter<Float> {

    /* renamed from: a */
    private int f4671a;

    /* renamed from: b */
    private int f4672b;

    /* renamed from: c */
    private int f4673c;

    /* renamed from: d */
    private float[] f4674d;

    /* renamed from: e */
    private float[] f4675e;

    public MiddleFloatValueFilter(int i) {
        this.f4671a = 0;
        this.f4673c = 11;
        if (i % 2 == 0) {
            throw new RuntimeException("valueCount must be odd");
        }
        this.f4673c = i;
        m8081c();
    }

    public MiddleFloatValueFilter() {
        this.f4671a = 0;
        this.f4673c = 11;
        m8081c();
    }

    /* renamed from: c */
    private void m8081c() {
        int i = this.f4673c;
        this.f4674d = new float[i];
        this.f4675e = new float[i];
        this.f4672b = i / 2;
    }

    @Override // com.navatics.app.framework.p055g.ValueFilter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Float mo8068b(Float f) {
        float[] fArr = this.f4674d;
        int i = this.f4671a;
        this.f4671a = i + 1;
        fArr[i % this.f4673c] = f.floatValue();
        float[] fArr2 = this.f4674d;
        System.arraycopy(fArr2, 0, this.f4675e, 0, fArr2.length);
        Arrays.sort(this.f4675e);
        return Float.valueOf(this.f4675e[this.f4672b]);
    }

    @Override // com.navatics.app.framework.p055g.ValueFilter
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo8070a(Float f) {
        float[] fArr = this.f4674d;
        int i = this.f4671a;
        this.f4671a = i + 1;
        fArr[i % this.f4673c] = f.floatValue();
        float[] fArr2 = this.f4674d;
        System.arraycopy(fArr2, 0, this.f4675e, 0, fArr2.length);
        Arrays.sort(this.f4675e);
    }

    @Override // com.navatics.app.framework.p055g.ValueFilter
    /* renamed from: a */
    public Float mo8069b() {
        return Float.valueOf(this.f4675e[this.f4672b]);
    }
}
