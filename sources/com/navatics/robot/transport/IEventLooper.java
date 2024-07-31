package com.navatics.robot.transport;

import android.support.annotation.NonNull;

/* renamed from: com.navatics.robot.transport.d */
/* loaded from: classes.dex */
public interface IEventLooper {
    /* renamed from: a */
    void mo6288a() throws InterruptedException;

    /* renamed from: a */
    void mo6286a(Runnable runnable);

    /* renamed from: a */
    void mo6285a(Runnable runnable, long j);

    /* renamed from: a */
    boolean mo6287a(@NonNull NvEvent nvEvent);

    /* renamed from: b */
    void mo6284b(Runnable runnable);

    void start();
}
