package com.navatics.app.framework;

import com.navatics.app.framework.p055g.MiddleIntValueFilter;
import com.navatics.app.framework.p055g.ValueFilter;

/* renamed from: com.navatics.app.framework.af */
/* loaded from: classes.dex */
public class SensorStatus {

    /* renamed from: a */
    private ValueFilter<Integer> f4243a = new MiddleIntValueFilter();

    /* renamed from: b */
    private ValueFilter<Integer> f4244b = new MiddleIntValueFilter();

    /* renamed from: c */
    private ValueFilter<Integer> f4245c = new MiddleIntValueFilter();

    /* renamed from: d */
    private ValueFilter<Integer> f4246d = new MiddleIntValueFilter();

    /* renamed from: a */
    public void m8625a(int i) {
        this.f4243a.mo8070a(Integer.valueOf(i));
    }

    /* renamed from: b */
    public void m8623b(int i) {
        this.f4244b.mo8070a(Integer.valueOf(i));
    }

    /* renamed from: c */
    public void m8621c(int i) {
        this.f4245c.mo8070a(Integer.valueOf(i));
    }

    /* renamed from: d */
    public void m8619d(int i) {
        this.f4246d.mo8070a(Integer.valueOf(i));
    }

    /* renamed from: a */
    public int m8626a() {
        return this.f4243a.mo8069b().intValue();
    }

    /* renamed from: b */
    public int m8624b() {
        return this.f4244b.mo8069b().intValue();
    }

    /* renamed from: c */
    public int m8622c() {
        return this.f4245c.mo8069b().intValue();
    }

    /* renamed from: d */
    public int m8620d() {
        return this.f4246d.mo8069b().intValue();
    }
}
