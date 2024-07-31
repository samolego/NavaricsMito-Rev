package com.navatics.app.framework.p055g;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p099e.Schedulers;

/* renamed from: com.navatics.app.framework.g.d */
/* loaded from: classes.dex */
public class RxUtils {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ ObservableSource m8071a(Observable observable) {
        return observable.m3075b(Schedulers.m3217b()).m3091a(AndroidSchedulers.m3250a());
    }

    /* renamed from: a */
    public static <T> ObservableTransformer<T, T> m8072a() {
        return new ObservableTransformer() { // from class: com.navatics.app.framework.g.-$$Lambda$d$MSwXeqmee8UOafQ8CxMqxUTJ-Zs
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                ObservableSource m8071a;
                m8071a = RxUtils.m8071a(observable);
                return m8071a;
            }
        };
    }
}
