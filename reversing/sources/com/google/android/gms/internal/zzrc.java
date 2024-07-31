package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p008v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

@TargetApi(11)
/* loaded from: classes.dex */
public final class zzrc extends Fragment implements zzrb {

    /* renamed from: yZ */
    private static WeakHashMap<Activity, WeakReference<zzrc>> f3282yZ = new WeakHashMap<>();

    /* renamed from: zb */
    private Bundle f3284zb;

    /* renamed from: za */
    private Map<String, zzra> f3283za = new ArrayMap();
    private int zzbqm = 0;

    private void zzb(final String str, @NonNull final zzra zzraVar) {
        if (this.zzbqm > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.zzrc.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzrc.this.zzbqm >= 1) {
                        zzraVar.onCreate(zzrc.this.f3284zb != null ? zzrc.this.f3284zb.getBundle(str) : null);
                    }
                    if (zzrc.this.zzbqm >= 2) {
                        zzraVar.onStart();
                    }
                    if (zzrc.this.zzbqm >= 3) {
                        zzraVar.onStop();
                    }
                    if (zzrc.this.zzbqm >= 4) {
                        zzraVar.onDestroy();
                    }
                }
            });
        }
    }

    public static zzrc zzt(Activity activity) {
        zzrc zzrcVar;
        WeakReference<zzrc> weakReference = f3282yZ.get(activity);
        if (weakReference == null || (zzrcVar = weakReference.get()) == null) {
            try {
                zzrc zzrcVar2 = (zzrc) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzrcVar2 == null || zzrcVar2.isRemoving()) {
                    zzrcVar2 = new zzrc();
                    activity.getFragmentManager().beginTransaction().add(zzrcVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f3282yZ.put(activity, new WeakReference<>(zzrcVar2));
                return zzrcVar2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return zzrcVar;
    }

    @Override // android.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzra zzraVar : this.f3283za.values()) {
            zzraVar.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzra zzraVar : this.f3283za.values()) {
            zzraVar.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbqm = 1;
        this.f3284zb = bundle;
        for (Map.Entry<String, zzra> entry : this.f3283za.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onStop();
        this.zzbqm = 4;
        for (zzra zzraVar : this.f3283za.values()) {
            zzraVar.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, zzra> entry : this.f3283za.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStop();
        this.zzbqm = 2;
        for (zzra zzraVar : this.f3283za.values()) {
            zzraVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzbqm = 3;
        for (zzra zzraVar : this.f3283za.values()) {
            zzraVar.onStop();
        }
    }

    @Override // com.google.android.gms.internal.zzrb
    public <T extends zzra> T zza(String str, Class<T> cls) {
        return cls.cast(this.f3283za.get(str));
    }

    @Override // com.google.android.gms.internal.zzrb
    public void zza(String str, @NonNull zzra zzraVar) {
        if (!this.f3283za.containsKey(str)) {
            this.f3283za.put(str, zzraVar);
            zzb(str, zzraVar);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.internal.zzrb
    public Activity zzasq() {
        return getActivity();
    }
}
