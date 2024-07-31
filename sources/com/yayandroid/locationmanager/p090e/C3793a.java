package com.yayandroid.locationmanager.p090e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import java.lang.ref.WeakReference;

/* renamed from: com.yayandroid.locationmanager.e.a */
/* loaded from: classes2.dex */
public class ContextProcessor {

    /* renamed from: a */
    private Context f9401a;

    /* renamed from: b */
    private WeakReference<Activity> f9402b;

    /* renamed from: c */
    private WeakReference<Fragment> f9403c;

    public ContextProcessor(Context context) {
        if (!(context instanceof Application)) {
            throw new IllegalArgumentException("ContextProcessor can only be initialized with Application!");
        }
        this.f9401a = context;
        this.f9402b = new WeakReference<>(null);
        this.f9403c = new WeakReference<>(null);
    }

    /* renamed from: a */
    public ContextProcessor m3498a(Activity activity) {
        this.f9402b = new WeakReference<>(activity);
        this.f9403c = new WeakReference<>(null);
        return this;
    }

    /* renamed from: a */
    public ContextProcessor m3497a(Fragment fragment) {
        this.f9402b = new WeakReference<>(null);
        this.f9403c = new WeakReference<>(fragment);
        return this;
    }

    @Nullable
    /* renamed from: a */
    public Fragment m3499a() {
        return this.f9403c.get();
    }

    @Nullable
    /* renamed from: b */
    public Activity m3496b() {
        if (this.f9402b.get() != null) {
            return this.f9402b.get();
        }
        if (this.f9403c.get() == null || this.f9403c.get().getActivity() == null) {
            return null;
        }
        return this.f9403c.get().getActivity();
    }

    /* renamed from: c */
    public Context m3495c() {
        return this.f9401a;
    }
}
