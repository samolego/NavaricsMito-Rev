package io.reactivex.p093a.p095b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.AbstractC2901p;
import io.reactivex.p093a.p094a.RxAndroidPlugins;
import java.util.concurrent.Callable;

/* renamed from: io.reactivex.a.b.a */
/* loaded from: classes2.dex */
public final class AndroidSchedulers {

    /* renamed from: a */
    private static final AbstractC2901p f9604a = RxAndroidPlugins.m3252a(new Callable<AbstractC2901p>() { // from class: io.reactivex.a.b.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AbstractC2901p call() throws Exception {
            return C2845a.f9605a;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* renamed from: io.reactivex.a.b.a$a */
    /* loaded from: classes2.dex */
    public static final class C2845a {

        /* renamed from: a */
        static final AbstractC2901p f9605a = new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: a */
    public static AbstractC2901p m3250a() {
        return RxAndroidPlugins.m3253a(f9604a);
    }
}
