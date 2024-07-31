package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p008v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

/* loaded from: classes.dex */
public final class zzh extends zzc.zza {

    /* renamed from: Ov */
    private Fragment f3058Ov;

    private zzh(Fragment fragment) {
        this.f3058Ov = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzc
    public Bundle getArguments() {
        return this.f3058Ov.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int getId() {
        return this.f3058Ov.getId();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean getRetainInstance() {
        return this.f3058Ov.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public String getTag() {
        return this.f3058Ov.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int getTargetRequestCode() {
        return this.f3058Ov.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean getUserVisibleHint() {
        return this.f3058Ov.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd getView() {
        return zze.zzac(this.f3058Ov.getView());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isAdded() {
        return this.f3058Ov.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isDetached() {
        return this.f3058Ov.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isHidden() {
        return this.f3058Ov.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isInLayout() {
        return this.f3058Ov.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isRemoving() {
        return this.f3058Ov.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isResumed() {
        return this.f3058Ov.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean isVisible() {
        return this.f3058Ov.isVisible();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setHasOptionsMenu(boolean z) {
        this.f3058Ov.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setMenuVisibility(boolean z) {
        this.f3058Ov.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setRetainInstance(boolean z) {
        this.f3058Ov.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void setUserVisibleHint(boolean z) {
        this.f3058Ov.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void startActivity(Intent intent) {
        this.f3058Ov.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void startActivityForResult(Intent intent, int i) {
        this.f3058Ov.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void zzac(zzd zzdVar) {
        this.f3058Ov.registerForContextMenu((View) zze.zzae(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void zzad(zzd zzdVar) {
        this.f3058Ov.unregisterForContextMenu((View) zze.zzae(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd zzbdu() {
        return zze.zzac(this.f3058Ov.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc zzbdv() {
        return zza(this.f3058Ov.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd zzbdw() {
        return zze.zzac(this.f3058Ov.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc zzbdx() {
        return zza(this.f3058Ov.getTargetFragment());
    }
}
