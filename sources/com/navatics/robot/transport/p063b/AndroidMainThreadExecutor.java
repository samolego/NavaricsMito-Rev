package com.navatics.robot.transport.p063b;

import android.os.Handler;
import android.os.Looper;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.transport.p063b.NvObserverExecutor;

/* renamed from: com.navatics.robot.transport.b.a */
/* loaded from: classes.dex */
public class AndroidMainThreadExecutor extends NvObserverExecutor {

    /* renamed from: a */
    private Handler f6509a = new Handler(Looper.getMainLooper());

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public <T> void mo6305a(final NvObserver<T> nvObserver, final T t, final NvObserverExecutor.InterfaceC2117a interfaceC2117a) {
        this.f6509a.post(new Runnable() { // from class: com.navatics.robot.transport.b.-$$Lambda$a$wj592VGeo4TkcgO9OYGYEe5PCrw
            @Override // java.lang.Runnable
            public final void run() {
                AndroidMainThreadExecutor.m6327b(NvObserver.this, t, interfaceC2117a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6327b(NvObserver nvObserver, Object obj, NvObserverExecutor.InterfaceC2117a interfaceC2117a) {
        try {
            nvObserver.onNext(obj);
            interfaceC2117a.mo6301a();
        } catch (Exception e) {
            interfaceC2117a.mo6300a(e);
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6307a(final NvAction nvAction, final NvExceptionHandler nvExceptionHandler, final NvObserverExecutor.InterfaceC2118b interfaceC2118b) {
        this.f6509a.post(new Runnable() { // from class: com.navatics.robot.transport.b.-$$Lambda$a$PaUFrqwYl_rgyGAlH5cuqVqSLtc
            @Override // java.lang.Runnable
            public final void run() {
                AndroidMainThreadExecutor.m6329a(NvAction.this, interfaceC2118b, nvExceptionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6329a(NvAction nvAction, NvObserverExecutor.InterfaceC2118b interfaceC2118b, NvExceptionHandler nvExceptionHandler) {
        try {
            nvAction.run();
            if (interfaceC2118b != null) {
                interfaceC2118b.mo6299a();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (nvExceptionHandler != null) {
                nvExceptionHandler.onError(e);
            }
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6306a(final NvExceptionHandler nvExceptionHandler, final Throwable th, final NvObserverExecutor.InterfaceC2119c interfaceC2119c) {
        this.f6509a.post(new Runnable() { // from class: com.navatics.robot.transport.b.-$$Lambda$a$VQ8_Q5FqwQ3vJhBduL_7zzr3buE
            @Override // java.lang.Runnable
            public final void run() {
                AndroidMainThreadExecutor.m6328b(NvExceptionHandler.this, th, interfaceC2119c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6328b(NvExceptionHandler nvExceptionHandler, Throwable th, NvObserverExecutor.InterfaceC2119c interfaceC2119c) {
        try {
            nvExceptionHandler.onError(th);
        } finally {
            interfaceC2119c.onFinish();
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6304a(Runnable runnable) {
        NvEventLoop.m6231b().mo6286a(runnable);
    }
}
