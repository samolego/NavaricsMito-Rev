package com.navatics.robot.transport;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class IoChannel {

    /* renamed from: a */
    private long f6503a = 0;

    /* renamed from: b */
    private IoMode f6504b;

    /* loaded from: classes.dex */
    public enum IoMode {
        BLOCKING,
        NONBLOCKING
    }

    /* renamed from: c */
    public abstract int mo6510c();

    /* renamed from: a */
    public IoChannel m6507a(IoMode ioMode) {
        this.f6504b = ioMode;
        return this;
    }

    /* renamed from: a */
    public long m6506a() {
        return this.f6503a;
    }

    /* renamed from: a */
    public void m6508a(long j) {
        this.f6503a = j;
    }

    /* renamed from: b */
    public IoMode m6509b() {
        return this.f6504b;
    }

    /* renamed from: a */
    public int mo6505a(IoBuffer ioBuffer) throws IOException {
        throw new UnsupportedOperationException(getClass() + ".readBuffer");
    }
}