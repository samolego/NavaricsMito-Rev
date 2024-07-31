package com.yayandroid.locationmanager.p086d.p089c;

import android.app.Activity;
import android.support.p008v4.app.ActivityCompat;
import android.support.p008v4.app.Fragment;

/* renamed from: com.yayandroid.locationmanager.d.c.b */
/* loaded from: classes2.dex */
class PermissionCompatSource {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3513a(Fragment fragment, String str) {
        return fragment.shouldShowRequestPermissionRationale(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3512a(Fragment fragment, String[] strArr, int i) {
        fragment.requestPermissions(strArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3515a(Activity activity, String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3514a(Activity activity, String[] strArr, int i) {
        ActivityCompat.requestPermissions(activity, strArr, i);
    }
}
