package com.navatics.app.framework.p055g;

import java.util.Arrays;

/* renamed from: com.navatics.app.framework.g.b */
/* loaded from: classes.dex */
public class MiddleIntValueFilter extends ValueFilter<Integer> {

    /* renamed from: a */
    private volatile int f4676a;

    /* renamed from: b */
    private int f4677b;

    /* renamed from: c */
    private int[] f4678c;

    /* renamed from: d */
    private int[] f4679d;

    /* renamed from: e */
    private volatile int f4680e;

    @Override // com.navatics.app.framework.p055g.ValueFilter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Integer mo8068b(Integer num) {
        mo8070a(num);
        return mo8069b();
    }

    public MiddleIntValueFilter(int i) {
        this.f4676a = 0;
        this.f4677b = 11;
        int i2 = this.f4677b;
        this.f4678c = new int[i2];
        this.f4679d = new int[i2];
        this.f4680e = 0;
        this.f4677b = i;
        int i3 = this.f4677b;
        this.f4678c = new int[i3];
        this.f4679d = new int[i3];
    }

    public MiddleIntValueFilter() {
        this.f4676a = 0;
        this.f4677b = 11;
        int i = this.f4677b;
        this.f4678c = new int[i];
        this.f4679d = new int[i];
        this.f4680e = 0;
    }

    @Override // com.navatics.app.framework.p055g.ValueFilter
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo8070a(Integer num) {
        int[] iArr = this.f4678c;
        int i = this.f4676a;
        this.f4676a = i + 1;
        iArr[i % this.f4677b] = num.intValue();
        int i2 = this.f4676a;
        int i3 = this.f4677b;
        if (i2 < i3) {
            i3 = this.f4676a;
        }
        this.f4680e = i3;
        System.arraycopy(this.f4678c, 0, this.f4679d, 0, this.f4680e);
        Arrays.sort(this.f4679d, 0, this.f4680e);
    }

    @Override // com.navatics.app.framework.p055g.ValueFilter
    /* renamed from: a */
    public Integer mo8069b() {
        return Integer.valueOf(this.f4679d[this.f4680e / 2]);
    }
}
