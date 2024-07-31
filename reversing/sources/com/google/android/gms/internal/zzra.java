package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zzra {

    /* renamed from: yY */
    protected final zzrb f3281yY;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzra(zzrb zzrbVar) {
        this.f3281yY = zzrbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzrb zzc(zzqz zzqzVar) {
        return zzqzVar.zzasn() ? zzrn.zza(zzqzVar.zzasp()) : zzrc.zzt(zzqzVar.zzaso());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzrb zzs(Activity activity) {
        return zzc(new zzqz(activity));
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.f3281yY.zzasq();
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onDestroy() {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }
}
