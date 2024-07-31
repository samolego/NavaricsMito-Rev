package com.p012a.p013a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.p096b.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.b */
/* loaded from: classes.dex */
public class RxPermissions {

    /* renamed from: a */
    static final Object f340a = new Object();

    /* renamed from: b */
    RxPermissionsFragment f341b;

    public RxPermissions(@NonNull Activity activity) {
        this.f341b = m12651a(activity);
    }

    /* renamed from: a */
    private RxPermissionsFragment m12651a(Activity activity) {
        RxPermissionsFragment m12644b = m12644b(activity);
        if (m12644b == null) {
            RxPermissionsFragment rxPermissionsFragment = new RxPermissionsFragment();
            FragmentManager fragmentManager = activity.getFragmentManager();
            fragmentManager.beginTransaction().add(rxPermissionsFragment, "RxPermissions").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return rxPermissionsFragment;
        }
        return m12644b;
    }

    /* renamed from: b */
    private RxPermissionsFragment m12644b(Activity activity) {
        return (RxPermissionsFragment) activity.getFragmentManager().findFragmentByTag("RxPermissions");
    }

    /* renamed from: a */
    public <T> ObservableTransformer<T, Boolean> m12645a(final String... strArr) {
        return new ObservableTransformer<T, Boolean>() { // from class: com.a.a.b.1
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<Boolean> apply(Observable<T> observable) {
                return RxPermissions.this.m12647a((Observable<?>) observable, strArr).m3117a(strArr.length).m3078b(new Function<List<Permission>, ObservableSource<Boolean>>() { // from class: com.a.a.b.1.1
                    @Override // io.reactivex.p096b.Function
                    /* renamed from: a */
                    public ObservableSource<Boolean> apply(List<Permission> list) throws Exception {
                        if (list.isEmpty()) {
                            return Observable.m3082b();
                        }
                        for (Permission permission : list) {
                            if (!permission.f338b) {
                                return Observable.m3088a(false);
                            }
                        }
                        return Observable.m3088a(true);
                    }
                });
            }
        };
    }

    /* renamed from: b */
    public Observable<Boolean> m12642b(String... strArr) {
        return Observable.m3088a(f340a).m3092a(m12645a(strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Observable<Permission> m12647a(Observable<?> observable, final String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
        }
        return m12648a(observable, m12640d(strArr)).m3078b(new Function<Object, Observable<Permission>>() { // from class: com.a.a.b.2
            @Override // io.reactivex.p096b.Function
            /* renamed from: a */
            public Observable<Permission> apply(Object obj) throws Exception {
                return RxPermissions.this.m12639e(strArr);
            }
        });
    }

    /* renamed from: d */
    private Observable<?> m12640d(String... strArr) {
        for (String str : strArr) {
            if (!this.f341b.m12630d(str)) {
                return Observable.m3082b();
            }
        }
        return Observable.m3088a(f340a);
    }

    /* renamed from: a */
    private Observable<?> m12648a(Observable<?> observable, Observable<?> observable2) {
        if (observable == null) {
            return Observable.m3088a(f340a);
        }
        return Observable.m3076b(observable, observable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    /* renamed from: e */
    public Observable<Permission> m12639e(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.f341b.m12629e("Requesting permission " + str);
            if (m12646a(str)) {
                arrayList.add(Observable.m3088a(new Permission(str, true, false)));
            } else if (m12643b(str)) {
                arrayList.add(Observable.m3088a(new Permission(str, false, false)));
            } else {
                PublishSubject<Permission> m12631c = this.f341b.m12631c(str);
                if (m12631c == null) {
                    arrayList2.add(str);
                    m12631c = PublishSubject.m3052f();
                    this.f341b.m12635a(str, m12631c);
                }
                arrayList.add(m12631c);
            }
        }
        if (!arrayList2.isEmpty()) {
            m12641c((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return Observable.m3096a((ObservableSource) Observable.m3089a((Iterable) arrayList));
    }

    @TargetApi(23)
    /* renamed from: c */
    void m12641c(String[] strArr) {
        RxPermissionsFragment rxPermissionsFragment = this.f341b;
        rxPermissionsFragment.m12629e("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.f341b.m12634a(strArr);
    }

    /* renamed from: a */
    public boolean m12646a(String str) {
        return !m12652a() || this.f341b.m12636a(str);
    }

    /* renamed from: b */
    public boolean m12643b(String str) {
        return m12652a() && this.f341b.m12632b(str);
    }

    /* renamed from: a */
    boolean m12652a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
