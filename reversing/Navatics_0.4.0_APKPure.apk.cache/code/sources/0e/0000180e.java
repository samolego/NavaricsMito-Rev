package com.navatics.app.framework;

/* compiled from: RobotVersionInfo.java */
/* renamed from: com.navatics.app.framework.ae, reason: use source file name */
/* loaded from: classes.dex */
public class RobotVersionInfo {

    /* renamed from: a */
    int f4261a;

    /* renamed from: b */
    int f4262b;

    /* renamed from: c */
    int f4263c;

    /* renamed from: d */
    int f4264d;

    public RobotVersionInfo() {
    }

    public RobotVersionInfo(int i, int i2, int i3, int i4) {
        this.f4261a = i;
        this.f4262b = i2;
        this.f4263c = i3;
        this.f4264d = i4;
    }

    /* renamed from: a */
    public int m4381a() {
        return this.f4261a;
    }

    public String toString() {
        return "v" + this.f4262b + "." + this.f4263c + "." + this.f4264d;
    }
}