package com.yayandroid.locationmanager.p086d.p089c;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.content.ContextCompat;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p085c.PermissionListener;
import com.yayandroid.locationmanager.p086d.p087a.DialogProvider;
import com.yayandroid.locationmanager.p090e.ContextProcessor;
import java.lang.ref.WeakReference;

/* renamed from: com.yayandroid.locationmanager.d.c.c */
/* loaded from: classes2.dex */
public abstract class PermissionProvider {

    /* renamed from: a */
    private WeakReference<ContextProcessor> f9397a;

    /* renamed from: b */
    private WeakReference<PermissionListener> f9398b;

    /* renamed from: c */
    private final String[] f9399c;

    /* renamed from: d */
    private DialogProvider f9400d;

    /* renamed from: a */
    public abstract void mo3501a(int i, @Nullable String[] strArr, @NonNull int[] iArr);

    /* renamed from: c */
    public abstract boolean mo3500c();

    public PermissionProvider(String[] strArr, @Nullable DialogProvider dialogProvider) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("You cannot create PermissionProvider without any permission required.");
        }
        this.f9399c = strArr;
        this.f9400d = dialogProvider;
    }

    /* renamed from: g */
    public String[] m3508g() {
        return this.f9399c;
    }

    @Nullable
    /* renamed from: h */
    public DialogProvider m3507h() {
        return this.f9400d;
    }

    @Nullable
    /* renamed from: i */
    public PermissionListener m3506i() {
        return this.f9398b.get();
    }

    @Nullable
    /* renamed from: j */
    protected Context m3505j() {
        if (this.f9397a.get() == null) {
            return null;
        }
        return this.f9397a.get().m3495c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: k */
    public Activity m3504k() {
        if (this.f9397a.get() == null) {
            return null;
        }
        return this.f9397a.get().m3496b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: l */
    public Fragment m3503l() {
        if (this.f9397a.get() == null) {
            return null;
        }
        return this.f9397a.get().m3499a();
    }

    @CallSuper
    /* renamed from: a */
    public void m3510a(ContextProcessor contextProcessor) {
        this.f9397a = new WeakReference<>(contextProcessor);
    }

    @CallSuper
    /* renamed from: a */
    public void m3511a(PermissionListener permissionListener) {
        this.f9398b = new WeakReference<>(permissionListener);
    }

    /* renamed from: m */
    public boolean m3502m() {
        if (m3505j() == null) {
            LogUtils.m3640a("Couldn't check whether permissions are granted or not because of PermissionProvider doesn't contain any context.");
            return false;
        }
        for (String str : m3508g()) {
            if (m3509b(str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    protected int m3509b(String str) {
        return ContextCompat.checkSelfPermission(m3505j(), str);
    }
}
