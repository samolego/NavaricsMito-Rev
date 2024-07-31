package com.navatics.app.framework;

import android.support.annotation.NonNull;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvSocket;

/* renamed from: com.navatics.app.framework.u */
/* loaded from: classes.dex */
public abstract class NvDevice {

    /* renamed from: a */
    private NvSocket f4795a;

    /* renamed from: b */
    private NvDeviceInfo f4796b;

    /* renamed from: c */
    private int f4797c;

    public NvDevice(@NonNull NvSocket nvSocket, int i) {
        this.f4795a = nvSocket;
        this.f4797c = i;
        this.f4796b = nvSocket.m6030b();
        if (this.f4796b == null) {
            throw new RuntimeException("socket.getDeviceInfo return null");
        }
    }

    /* renamed from: c */
    public int m7857c() {
        return this.f4797c;
    }

    /* renamed from: d */
    public NvDeviceInfo m7856d() {
        return this.f4796b;
    }

    /* renamed from: e */
    public NvSocket m7855e() {
        return this.f4795a;
    }
}
