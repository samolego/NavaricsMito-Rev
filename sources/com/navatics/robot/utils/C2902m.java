package com.navatics.robot.utils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.p093a.p095b.AndroidSchedulers;
import io.reactivex.p096b.Consumer;
import java.util.concurrent.TimeUnit;

/* renamed from: com.navatics.robot.utils.m */
/* loaded from: classes2.dex */
public class RxTimer {

    /* renamed from: a */
    private Observable<Long> f6783a;

    /* renamed from: b */
    private long f6784b;

    /* renamed from: c */
    private Disposable f6785c;

    /* renamed from: d */
    private InterfaceC2159a f6786d;

    /* compiled from: RxTimer.java */
    /* renamed from: com.navatics.robot.utils.m$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2159a {
        /* renamed from: a */
        void mo5856a(RxTimer rxTimer);
    }

    public static /* synthetic */ void lambda$c0hg9lcrp1G8TEH7c4jNP7R7dkY(RxTimer rxTimer, Long l) {
        rxTimer.m5858a(l);
    }

    /* renamed from: a */
    public static RxTimer m5859a(InterfaceC2159a interfaceC2159a, long j, boolean z) {
        RxTimer rxTimer = new RxTimer();
        rxTimer.f6786d = interfaceC2159a;
        rxTimer.f6784b = j;
        if (z) {
            rxTimer.f6783a = Observable.m3111a(j, TimeUnit.MILLISECONDS).m3091a(AndroidSchedulers.m3250a());
        } else {
            rxTimer.f6783a = Observable.m3081b(j, TimeUnit.MILLISECONDS).m3091a(AndroidSchedulers.m3250a());
        }
        return rxTimer;
    }

    /* renamed from: a */
    public /* synthetic */ void m5858a(Long l) throws Exception {
        this.f6786d.mo5856a(this);
    }

    /* renamed from: a */
    public void m5860a() {
        this.f6785c = this.f6783a.m3071c(new Consumer() { // from class: com.navatics.robot.utils.-$$Lambda$m$c0hg9lcrp1G8TEH7c4jNP7R7dkY
            @Override // io.reactivex.p096b.Consumer
            public final void accept(Object obj) {
                RxTimer.lambda$c0hg9lcrp1G8TEH7c4jNP7R7dkY(RxTimer.this, (Long) obj);
            }
        });
    }

    /* renamed from: b */
    public void m5857b() {
        Disposable disposable = this.f6785c;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.f6785c.dispose();
    }
}
