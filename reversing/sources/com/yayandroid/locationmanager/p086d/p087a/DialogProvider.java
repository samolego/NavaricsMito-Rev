package com.yayandroid.locationmanager.p086d.p087a;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yayandroid.locationmanager.p085c.DialogListener;
import java.lang.ref.WeakReference;

/* renamed from: com.yayandroid.locationmanager.d.a.a */
/* loaded from: classes2.dex */
public abstract class DialogProvider {

    /* renamed from: a */
    private WeakReference<DialogListener> f9371a;

    /* renamed from: a */
    public abstract Dialog mo3605a(@NonNull Context context);

    /* renamed from: a */
    public void m3606a(@Nullable DialogListener dialogListener) {
        this.f9371a = new WeakReference<>(dialogListener);
    }

    @Nullable
    /* renamed from: a */
    public DialogListener m3607a() {
        return this.f9371a.get();
    }
}
