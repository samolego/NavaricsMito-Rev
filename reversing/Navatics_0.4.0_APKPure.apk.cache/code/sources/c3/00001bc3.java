package com.navatics.robot.transport;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class NvChannel {

    /* renamed from: a */
    protected State f6506a = State.PREPARING;

    /* renamed from: b */
    private int f6507b;

    /* renamed from: c */
    private int f6508c;

    /* renamed from: d */
    private int f6509d;

    /* renamed from: e */
    private int f6510e;

    /* renamed from: f */
    private NvEventHandler f6511f;

    /* loaded from: classes.dex */
    public enum State {
        PREPARING,
        RUNNING,
        PAUSED,
        CLOSED
    }

    /* renamed from: a */
    public static String m6511a(State state) {
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
    public String m6513a() {
        return m6511a(this.f6506a);
    }

    public NvChannel(int i, int i2, int i3, int i4) {
        this.f6507b = i;
        this.f6508c = i2;
        this.f6509d = i3;
        this.f6510e = i4;
    }

    /* renamed from: b */
    public NvEventHandler m6515b() {
        return this.f6511f;
    }

    /* renamed from: a */
    public void m6514a(NvEventHandler nvEventHandler) {
        this.f6511f = nvEventHandler;
    }

    /* renamed from: a */
    public int mo6512a(byte[] bArr) throws IOException {
        throw new UnsupportedOperationException("write is not supported by this Channel - " + getClass().getName());
    }

    /* renamed from: c */
    public void mo6516c() {
        this.f6506a = State.PAUSED;
    }

    /* renamed from: d */
    public void mo6517d() {
        this.f6506a = State.RUNNING;
    }

    /* renamed from: e */
    public void mo6518e() {
        this.f6506a = State.CLOSED;
    }

    /* renamed from: f */
    public boolean m6519f() {
        return this.f6506a == State.CLOSED;
    }

    /* renamed from: g */
    public boolean m6520g() {
        return this.f6506a == State.RUNNING;
    }

    /* renamed from: h */
    public boolean m6521h() {
        return this.f6506a == State.PAUSED;
    }
}