package com.yayandroid.locationmanager.p086d.p088b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.yayandroid.locationmanager.p083b.p084a.ContinuousTask;
import com.yayandroid.locationmanager.p085c.FallbackListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.yayandroid.locationmanager.d.b.d */
/* loaded from: classes2.dex */
public class DispatcherLocationSource {

    /* renamed from: a */
    private ContinuousTask f9383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public DefaultLocationProvider m3569a() {
        return new DefaultLocationProvider();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public GooglePlayServicesLocationProvider m3564a(FallbackListener fallbackListener) {
        return new GooglePlayServicesLocationProvider(fallbackListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3565a(ContinuousTask.InterfaceC2817a interfaceC2817a) {
        this.f9383a = new ContinuousTask("googlePlayServiceSwitchTask", interfaceC2817a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public ContinuousTask m3563b() {
        return this.f9383a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m3566a(Context context) {
        if (context == null) {
            return -1;
        }
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3568a(int i) {
        return GoogleApiAvailability.getInstance().isUserResolvableError(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Dialog m3567a(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (activity == null) {
            return null;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }
}
