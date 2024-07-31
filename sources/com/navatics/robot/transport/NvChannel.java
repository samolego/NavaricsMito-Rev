package com.navatics.robot.transport;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class NvChannel {

    /* renamed from: a */
    protected State f6478a = State.PREPARING;

    /* renamed from: b */
    private int f6479b;

    /* renamed from: c */
    private int f6480c;

    /* renamed from: d */
    private int f6481d;

    /* renamed from: e */
    private int f6482e;

    /* renamed from: f */
    private NvEventHandler f6483f;

    /* loaded from: classes.dex */
    public enum State {
        PREPARING,
        RUNNING,
        PAUSED,
        CLOSED
    }

    /* renamed from: a */
    public static String m6347a(State state) {
        switch (state) {
            case PREPARING:
                return "PREPARING";
            case RUNNING:
                return "RUNNING";
            case PAUSED:
                return "PAUSED";
            case CLOSED:
                return "CLOSED";
            default:
                return "unknown_channel_state";
        }
    }

    /* renamed from: a */
    public String m6348a() {
        return m6347a(this.f6478a);
    }

    public NvChannel(int i, int i2, int i3, int i4) {
        this.f6479b = i;
        this.f6480c = i2;
        this.f6481d = i3;
        this.f6482e = i4;
    }

    /* renamed from: b */
    public NvEventHandler m6345b() {
        return this.f6483f;
    }

    /* renamed from: a */
    public void m6346a(NvEventHandler nvEventHandler) {
        this.f6483f = nvEventHandler;
    }

    /* renamed from: a */
    public int mo6073a(byte[] bArr) throws IOException {
        throw new UnsupportedOperationException("write is not supported by this Channel - " + getClass().getName());
    }

    /* renamed from: c */
    public void mo6072c() {
        this.f6478a = State.PAUSED;
    }

    /* renamed from: d */
    public void mo6071d() {
        this.f6478a = State.RUNNING;
    }

    /* renamed from: e */
    public void mo6055e() {
        this.f6478a = State.CLOSED;
    }

    /* renamed from: f */
    public boolean m6344f() {
        return this.f6478a == State.CLOSED;
    }

    /* renamed from: g */
    public boolean m6343g() {
        return this.f6478a == State.RUNNING;
    }

    /* renamed from: h */
    public boolean m6342h() {
        return this.f6478a == State.PAUSED;
    }
}
