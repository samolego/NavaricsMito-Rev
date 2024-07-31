package org.mp4parser.streaming.p148a;

import org.mp4parser.streaming.TrackExtension;

/* renamed from: org.mp4parser.streaming.a.e */
/* loaded from: classes2.dex */
public class DimensionTrackExtension implements TrackExtension {

    /* renamed from: a */
    int f12118a;

    /* renamed from: b */
    int f12119b;

    public DimensionTrackExtension(int i, int i2) {
        this.f12118a = i;
        this.f12119b = i2;
    }

    /* renamed from: a */
    public int m510a() {
        return this.f12118a;
    }

    /* renamed from: b */
    public int m509b() {
        return this.f12119b;
    }

    public String toString() {
        return "width=" + this.f12118a + ", height=" + this.f12119b;
    }
}
