package com.yayandroid.locationmanager.p082a;

import android.support.annotation.Nullable;
import com.yayandroid.locationmanager.p083b.C2818b;
import com.yayandroid.locationmanager.p086d.p087a.DialogProvider;
import com.yayandroid.locationmanager.p086d.p087a.SimpleMessageDialogProvider;

/* renamed from: com.yayandroid.locationmanager.a.a */
/* loaded from: classes2.dex */
public class DefaultProviderConfiguration {

    /* renamed from: a */
    private final long f9308a;

    /* renamed from: b */
    private final long f9309b;

    /* renamed from: c */
    private final float f9310c;

    /* renamed from: d */
    private final long f9311d;

    /* renamed from: e */
    private final long f9312e;

    /* renamed from: f */
    private final long f9313f;

    /* renamed from: g */
    private final DialogProvider f9314g;

    private DefaultProviderConfiguration(C2810a c2810a) {
        this.f9308a = c2810a.f9315a;
        this.f9309b = c2810a.f9316b;
        this.f9310c = c2810a.f9317c;
        this.f9311d = c2810a.f9318d;
        this.f9312e = c2810a.f9319e;
        this.f9313f = c2810a.f9320f;
        this.f9314g = c2810a.f9321g;
    }

    /* renamed from: a */
    public long m3705a() {
        return this.f9308a;
    }

    /* renamed from: b */
    public long m3697b() {
        return this.f9309b;
    }

    /* renamed from: c */
    public float m3695c() {
        return this.f9310c;
    }

    /* renamed from: d */
    public long m3693d() {
        return this.f9311d;
    }

    /* renamed from: e */
    public boolean m3691e() {
        return this.f9314g != null;
    }

    @Nullable
    /* renamed from: f */
    public DialogProvider m3690f() {
        return this.f9314g;
    }

    /* renamed from: g */
    public long m3689g() {
        return this.f9312e;
    }

    /* renamed from: h */
    public long m3688h() {
        return this.f9313f;
    }

    /* compiled from: DefaultProviderConfiguration.java */
    /* renamed from: com.yayandroid.locationmanager.a.a$a */
    /* loaded from: classes2.dex */
    public static class C2810a {

        /* renamed from: g */
        private DialogProvider f9321g;

        /* renamed from: a */
        private long f9315a = 300000;

        /* renamed from: b */
        private long f9316b = 0;

        /* renamed from: c */
        private float f9317c = 5.0f;

        /* renamed from: d */
        private long f9318d = 300000;

        /* renamed from: e */
        private long f9319e = 20000;

        /* renamed from: f */
        private long f9320f = 20000;

        /* renamed from: h */
        private String f9322h = "";

        /* renamed from: a */
        public DefaultProviderConfiguration m3687a() {
            if (this.f9321g == null && C2818b.m3623a(this.f9322h)) {
                this.f9321g = new SimpleMessageDialogProvider(this.f9322h);
            }
            return new DefaultProviderConfiguration(this);
        }
    }
}
