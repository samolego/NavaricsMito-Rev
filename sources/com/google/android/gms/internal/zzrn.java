package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p008v4.app.Fragment;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzrn extends Fragment implements zzrb {

    /* renamed from: yZ */
    private static WeakHashMap<FragmentActivity, WeakReference<zzrn>> f3298yZ = new WeakHashMap<>();

    /* renamed from: zb */
    private Bundle f3300zb;

    /* renamed from: za */
    private Map<String, zzra> f3299za = new ArrayMap();
    private int zzbqm = 0;

    public static zzrn zza(FragmentActivity fragmentActivity) {
        zzrn zzrnVar;
        WeakReference<zzrn> weakReference = f3298yZ.get(fragmentActivity);
        if (weakReference == null || (zzrnVar = weakReference.get()) == null) {
            try {
                zzrn zzrnVar2 = (zzrn) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzrnVar2 == null || zzrnVar2.isRemoving()) {
                    zzrnVar2 = new zzrn();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzrnVar2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f3298yZ.put(fragmentActivity, new WeakReference<>(zzrnVar2));
                return zzrnVar2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzrnVar;
    }

    private void zzb(final String str, @NonNull final zzra zzraVar) {
        if (this.zzbqm > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.internal.zzrn.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zzrn.this.zzbqm >= 1) {
                        zzraVar.onCreate(zzrn.this.f3300zb != null ? zzrn.this.f3300zb.getBundle(str) : null);
                    }
                    if (zzrn.this.zzbqm >= 2) {
                        zzraVar.onStart();
                    }
                    if (zzrn.this.zzbqm >= 3) {
                        zzraVar.onStop();
                    }
                    if (zzrn.this.zzbqm >= 4) {
                        zzraVar.onDestroy();
                    }
                }
            });
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzra zzraVar : this.f3299za.values()) {
            zzraVar.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzra zzraVar : this.f3299za.values()) {
            zzraVar.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbqm = 1;
        this.f3300zb = bundle;
        for (Map.Entry<String, zzra> entry : this.f3299za.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onDestroy() {
        super.onStop();
        this.zzbqm = 4;
        for (zzra zzraVar : this.f3299za.values()) {
            zzraVar.onDestroy();
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, zzra> entry : this.f3299za.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onStart() {
        super.onStop();
        this.zzbqm = 2;
        for (zzra zzraVar : this.f3299za.values()) {
            zzraVar.onStart();
        }
    }

    @Override // android.support.p008v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.zzbqm = 3;
        for (zzra zzraVar : this.f3299za.values()) {
            zzraVar.onStop();
        }
    }

    @Override // com.google.android.gms.internal.zzrb
    public <T extends zzra> T zza(String str, Class<T> cls) {
        return cls.cast(this.f3299za.get(str));
    }

    @Override // com.google.android.gms.internal.zzrb
    public void zza(String str, @NonNull zzra zzraVar) {
        if (!this.f3299za.containsKey(str)) {
            this.f3299za.put(str, zzraVar);
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
    /* renamed from: zzass */
    public FragmentActivity zzasq() {
        return getActivity();
    }
}
