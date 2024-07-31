package com.navatics.robot.transport;

/* compiled from: WhiteBalance.java */
/* renamed from: com.navatics.robot.transport.ac */
/* loaded from: classes.dex */
public class WhiteBalance {

    /* renamed from: a */
    int redChannel;

    /* renamed from: b */
    int blueChannel;

    public WhiteBalance(int i, int i2) {
        this.redChannel = i;
        this.blueChannel = i2;
    }

    /* renamed from: a */
    public int getRedChannel() {
        return this.redChannel;
    }

    /* renamed from: b */
    public int getBlueChannel() {
        return this.blueChannel;
    }

    public String toString() {
        return "WhiteBalance{redChannel=" + this.redChannel + ", blueChannel=" + this.blueChannel + '}';
    }
}