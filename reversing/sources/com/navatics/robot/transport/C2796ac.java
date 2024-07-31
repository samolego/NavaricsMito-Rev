package com.navatics.robot.transport;

/* renamed from: com.navatics.robot.transport.ac */
/* loaded from: classes.dex */
public class WhiteBalance {

    /* renamed from: a */
    int f6503a;

    /* renamed from: b */
    int f6504b;

    public WhiteBalance(int i, int i2) {
        this.f6503a = i;
        this.f6504b = i2;
    }

    /* renamed from: a */
    public int m6331a() {
        return this.f6503a;
    }

    /* renamed from: b */
    public int m6330b() {
        return this.f6504b;
    }

    public String toString() {
        return "WhiteBalance{redChannel=" + this.f6503a + ", blueChannel=" + this.f6504b + '}';
    }
}
