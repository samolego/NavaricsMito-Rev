package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;

/* compiled from: AppCall.java */
/* renamed from: com.facebook.internal.a */
/* loaded from: classes.dex */
public class C0894a {

    /* renamed from: a */
    private static C0894a f1917a;

    /* renamed from: b */
    private UUID f1918b;

    /* renamed from: c */
    private Intent f1919c;

    /* renamed from: d */
    private int f1920d;

    /* renamed from: a */
    public static C0894a m2176a() {
        return f1917a;
    }

    /* renamed from: a */
    private static synchronized boolean m2177a(C0894a c0894a) {
        boolean z;
        synchronized (C0894a.class) {
            C0894a m2176a = m2176a();
            f1917a = c0894a;
            z = m2176a != null;
        }
        return z;
    }

    public C0894a(int i) {
        this(i, UUID.randomUUID());
    }

    public C0894a(int i, UUID uuid) {
        this.f1918b = uuid;
        this.f1920d = i;
    }

    /* renamed from: b */
    public Intent m2179b() {
        return this.f1919c;
    }

    /* renamed from: c */
    public UUID m2180c() {
        return this.f1918b;
    }

    /* renamed from: d */
    public int m2181d() {
        return this.f1920d;
    }

    /* renamed from: a */
    public void m2178a(Intent intent) {
        this.f1919c = intent;
    }

    /* renamed from: e */
    public boolean m2182e() {
        return m2177a(this);
    }
}