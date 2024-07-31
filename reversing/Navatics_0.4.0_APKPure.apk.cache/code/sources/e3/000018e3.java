package com.navatics.app.framework.p049g;

import java.util.Arrays;

/* compiled from: MiddleIntValueFilter.java */
/* renamed from: com.navatics.app.framework.g.b, reason: use source file name */
/* loaded from: classes.dex */
public class MiddleIntValueFilter extends ValueFilter<Integer> {

    /* renamed from: a */
    private volatile int f4698a;

    /* renamed from: b */
    private int f4699b;

    /* renamed from: c */
    private int[] f4700c;

    /* renamed from: d */
    private int[] f4701d;

    /* renamed from: e */
    private volatile int f4702e;

    @Override // com.navatics.app.framework.p049g.ValueFilter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Integer mo4898b(Integer num) {
        mo4896a(num);
        return mo4897b();
    }

    public MiddleIntValueFilter(int i) {
        this.f4698a = 0;
        this.f4699b = 11;
        int i2 = this.f4699b;
        this.f4700c = new int[i2];
        this.f4701d = new int[i2];
        this.f4702e = 0;
        this.f4699b = i;
        int i3 = this.f4699b;
        this.f4700c = new int[i3];
        this.f4701d = new int[i3];
    }

    public MiddleIntValueFilter() {
        this.f4698a = 0;
        this.f4699b = 11;
        int i = this.f4699b;
        this.f4700c = new int[i];
        this.f4701d = new int[i];
        this.f4702e = 0;
    }

    @Override // com.navatics.app.framework.p049g.ValueFilter
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo4896a(Integer num) {
        int[] iArr = this.f4700c;
        int i = this.f4698a;
        this.f4698a = i + 1;
        iArr[i % this.f4699b] = num.intValue();
        int i2 = this.f4698a;
        int i3 = this.f4699b;
        if (i2 < i3) {
            i3 = this.f4698a;
        }
        this.f4702e = i3;
        System.arraycopy(this.f4700c, 0, this.f4701d, 0, this.f4702e);
        Arrays.sort(this.f4701d, 0, this.f4702e);
    }

    @Override // com.navatics.app.framework.p049g.ValueFilter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer mo4897b() {
        return Integer.valueOf(this.f4701d[this.f4702e / 2]);
    }
}