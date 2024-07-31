package com.navatics.app.framework;

import com.navatics.robot.transport.p063b.NvAbstractObservable;

/* renamed from: com.navatics.app.framework.w */
/* loaded from: classes.dex */
public abstract class NvDisposableHandler extends NvAbstractObservable<NvDisposableHandler> {
    /* renamed from: a */
    public void m7732a() {
        if (mo6310f()) {
            return;
        }
        m6318b(this);
        m6315i();
    }

    /* renamed from: a */
    public static void m7731a(NvDisposableHandler nvDisposableHandler) {
        if (nvDisposableHandler != null) {
            nvDisposableHandler.m7732a();
        }
    }
}
