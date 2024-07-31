package com.p012a.p013a;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.a.a.c */
/* loaded from: classes.dex */
public class RxPermissionsFragment extends Fragment {

    /* renamed from: a */
    private Map<String, PublishSubject<Permission>> f347a = new HashMap();

    /* renamed from: b */
    private boolean f348b;

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    /* renamed from: a */
    public void m12634a(@NonNull String[] strArr) {
        requestPermissions(strArr, 42);
    }

    @Override // android.app.Fragment
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 42) {
            return;
        }
        boolean[] zArr = new boolean[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
        }
        m12633a(strArr, iArr, zArr);
    }

    /* renamed from: a */
    void m12633a(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            m12629e("onRequestPermissionsResult  " + strArr[i]);
            PublishSubject<Permission> publishSubject = this.f347a.get(strArr[i]);
            if (publishSubject == null) {
                Log.e("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.f347a.remove(strArr[i]);
            publishSubject.onNext(new Permission(strArr[i], iArr[i] == 0, zArr[i]));
            publishSubject.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    /* renamed from: a */
    public boolean m12636a(String str) {
        return getActivity().checkSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(23)
    /* renamed from: b */
    public boolean m12632b(String str) {
        return getActivity().getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
    }

    /* renamed from: c */
    public PublishSubject<Permission> m12631c(@NonNull String str) {
        return this.f347a.get(str);
    }

    /* renamed from: d */
    public boolean m12630d(@NonNull String str) {
        return this.f347a.containsKey(str);
    }

    /* renamed from: a */
    public PublishSubject<Permission> m12635a(@NonNull String str, @NonNull PublishSubject<Permission> publishSubject) {
        return this.f347a.put(str, publishSubject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m12629e(String str) {
        if (this.f348b) {
            Log.d("RxPermissions", str);
        }
    }
}
