package com.navatics.robot.transport;

import com.navatics.robot.transport.p063b.NvAction;
import com.navatics.robot.transport.p063b.NvExceptionHandler;
import com.navatics.robot.transport.p063b.NvObserver;
import com.navatics.robot.transport.p063b.NvObserverExecutor;

/* renamed from: com.navatics.robot.transport.aa */
/* loaded from: classes.dex */
public class SerialExecutor extends NvObserverExecutor {
    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public <T> void mo6305a(final NvObserver<T> nvObserver, final T t, final NvObserverExecutor.InterfaceC2117a interfaceC2117a) throws Exception {
        NvEventLoop.m6230c().mo6286a(new Runnable() { // from class: com.navatics.robot.transport.-$$Lambda$aa$2p0uuBBMidy2JKsMHU2EslKeBDk
            @Override // java.lang.Runnable
            public final void run() {
                SerialExecutor.m6332b(NvObserver.this, t, interfaceC2117a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6332b(NvObserver nvObserver, Object obj, NvObserverExecutor.InterfaceC2117a interfaceC2117a) {
        try {
            nvObserver.onNext(obj);
            interfaceC2117a.mo6301a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6307a(final NvAction nvAction, final NvExceptionHandler nvExceptionHandler, final NvObserverExecutor.InterfaceC2118b interfaceC2118b) {
        NvEventLoop.m6230c().mo6286a(new Runnable() { // from class: com.navatics.robot.transport.-$$Lambda$aa$1h0XLnGK-FbvisQgbiRqaKOqF4E
            @Override // java.lang.Runnable
            public final void run() {
                SerialExecutor.m6334a(NvAction.this, interfaceC2118b, nvExceptionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m6334a(NvAction nvAction, NvObserverExecutor.InterfaceC2118b interfaceC2118b, NvExceptionHandler nvExceptionHandler) {
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
        NvEventLoop.m6230c().mo6286a(new Runnable() { // from class: com.navatics.robot.transport.-$$Lambda$aa$yPBTTTq-J_bnYfELXF3Us98m2GA
            @Override // java.lang.Runnable
            public final void run() {
                SerialExecutor.m6333b(NvExceptionHandler.this, th, interfaceC2119c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m6333b(NvExceptionHandler nvExceptionHandler, Throwable th, NvObserverExecutor.InterfaceC2119c interfaceC2119c) {
        try {
            nvExceptionHandler.onError(th);
        } finally {
            interfaceC2119c.onFinish();
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6304a(Runnable runnable) {
        NvEventLoop.m6230c().mo6286a(runnable);
    }
}
