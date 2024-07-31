package org.mp4parser.streaming.p137a;

import org.mp4parser.streaming.InterfaceC3442d;

/* compiled from: DimensionTrackExtension.java */
/* renamed from: org.mp4parser.streaming.a.e, reason: use source file name */
/* loaded from: classes2.dex */
public class DimensionTrackExtension implements InterfaceC3442d {

    /* renamed from: a */
    int f12159a;

    /* renamed from: b */
    int f12160b;

    public DimensionTrackExtension(int i, int i2) {
        this.f12159a = i;
        this.f12160b = i2;
    }

    /* renamed from: a */
    public int m12307a() {
        return this.f12159a;
    }

    /* renamed from: b */
    public int m12308b() {
        return this.f12160b;
    }

    public String toString() {
        return "width=" + this.f12159a + ", height=" + this.f12160b;
    }
}