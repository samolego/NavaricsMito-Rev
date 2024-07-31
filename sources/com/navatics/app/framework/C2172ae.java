package com.navatics.app.framework;

/* renamed from: com.navatics.app.framework.ae */
/* loaded from: classes.dex */
public class RobotVersionInfo {

    /* renamed from: a */
    int f4239a;

    /* renamed from: b */
    int f4240b;

    /* renamed from: c */
    int f4241c;

    /* renamed from: d */
    int f4242d;

    public RobotVersionInfo() {
    }

    public RobotVersionInfo(int i, int i2, int i3, int i4) {
        this.f4239a = i;
        this.f4240b = i2;
        this.f4241c = i3;
        this.f4242d = i4;
    }

    /* renamed from: a */
    public int m8627a() {
        return this.f4239a;
    }

    public String toString() {
        return "v" + this.f4240b + "." + this.f4241c + "." + this.f4242d;
    }
}
