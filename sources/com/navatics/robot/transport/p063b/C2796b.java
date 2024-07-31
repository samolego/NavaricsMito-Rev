package com.navatics.robot.transport.p063b;

import com.navatics.robot.transport.p063b.NvObserverExecutor;

/* renamed from: com.navatics.robot.transport.b.b */
/* loaded from: classes.dex */
public class DefaultObserverExecutor extends NvObserverExecutor {
    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public <T> void mo6305a(NvObserver<T> nvObserver, T t, NvObserverExecutor.InterfaceC2117a interfaceC2117a) throws Exception {
        nvObserver.onNext(t);
        interfaceC2117a.mo6301a();
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6307a(NvAction nvAction, NvExceptionHandler nvExceptionHandler, NvObserverExecutor.InterfaceC2118b interfaceC2118b) {
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
    public void mo6306a(NvExceptionHandler nvExceptionHandler, Throwable th, NvObserverExecutor.InterfaceC2119c interfaceC2119c) {
        try {
            nvExceptionHandler.onError(th);
        } finally {
            interfaceC2119c.onFinish();
        }
    }

    @Override // com.navatics.robot.transport.p063b.NvObserverExecutor
    /* renamed from: a */
    public void mo6304a(Runnable runnable) {
        runnable.run();
    }
}
