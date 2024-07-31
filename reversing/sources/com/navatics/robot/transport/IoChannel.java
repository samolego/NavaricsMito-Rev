package com.navatics.robot.transport;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class IoChannel {

    /* renamed from: a */
    private long f6475a = 0;

    /* renamed from: b */
    private IoMode f6476b;

    /* loaded from: classes.dex */
    public enum IoMode {
        BLOCKING,
        NONBLOCKING
    }

    /* renamed from: c */
    public abstract int mo6210c();

    /* renamed from: a */
    public IoChannel m6350a(IoMode ioMode) {
        this.f6476b = ioMode;
        return this;
    }

    /* renamed from: a */
    public long m6352a() {
        return this.f6475a;
    }

    /* renamed from: a */
    public void m6351a(long j) {
        this.f6475a = j;
    }

    /* renamed from: b */
    public IoMode m6349b() {
        return this.f6476b;
    }

    /* renamed from: a */
    public int mo6215a(IoBuffer ioBuffer) throws IOException {
        throw new UnsupportedOperationException(getClass() + ".readBuffer");
    }
}
