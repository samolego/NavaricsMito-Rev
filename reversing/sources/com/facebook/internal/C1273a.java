package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;

/* renamed from: com.facebook.internal.a */
/* loaded from: classes.dex */
public class AppCall {

    /* renamed from: a */
    private static AppCall f1910a;

    /* renamed from: b */
    private UUID f1911b;

    /* renamed from: c */
    private Intent f1912c;

    /* renamed from: d */
    private int f1913d;

    /* renamed from: a */
    public static AppCall m10792a() {
        return f1910a;
    }

    /* renamed from: a */
    private static synchronized boolean m10790a(AppCall appCall) {
        boolean z;
        synchronized (AppCall.class) {
            AppCall m10792a = m10792a();
            f1910a = appCall;
            z = m10792a != null;
        }
        return z;
    }

    public AppCall(int i) {
        this(i, UUID.randomUUID());
    }

    public AppCall(int i, UUID uuid) {
        this.f1911b = uuid;
        this.f1913d = i;
    }

    /* renamed from: b */
    public Intent m10789b() {
        return this.f1912c;
    }

    /* renamed from: c */
    public UUID m10788c() {
        return this.f1911b;
    }

    /* renamed from: d */
    public int m10787d() {
        return this.f1913d;
    }

    /* renamed from: a */
    public void m10791a(Intent intent) {
        this.f1912c = intent;
    }

    /* renamed from: e */
    public boolean m10786e() {
        return m10790a(this);
    }
}
