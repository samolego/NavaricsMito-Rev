package com.yayandroid.locationmanager.p075d.p076a;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yayandroid.locationmanager.p074c.InterfaceC2757a;
import java.lang.ref.WeakReference;

/* compiled from: DialogProvider.java */
/* renamed from: com.yayandroid.locationmanager.d.a.a, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class DialogProvider {

    /* renamed from: a */
    private WeakReference<InterfaceC2757a> f9412a;

    /* renamed from: a */
    public abstract Dialog mo9232a(@NonNull Context context);

    /* renamed from: a */
    public void m9234a(@Nullable InterfaceC2757a interfaceC2757a) {
        this.f9412a = new WeakReference<>(interfaceC2757a);
    }

    @Nullable
    /* renamed from: a */
    public InterfaceC2757a m9233a() {
        return this.f9412a.get();
    }
}