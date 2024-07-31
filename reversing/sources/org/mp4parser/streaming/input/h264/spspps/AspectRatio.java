package org.mp4parser.streaming.input.h264.spspps;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.a */
/* loaded from: classes2.dex */
public class AspectRatio {

    /* renamed from: a */
    public static final AspectRatio f12245a = new AspectRatio(255);

    /* renamed from: b */
    private int f12246b;

    private AspectRatio(int i) {
        this.f12246b = i;
    }

    /* renamed from: a */
    public static AspectRatio m430a(int i) {
        AspectRatio aspectRatio = f12245a;
        return i == aspectRatio.f12246b ? aspectRatio : new AspectRatio(i);
    }

    public String toString() {
        return "AspectRatio{value=" + this.f12246b + '}';
    }
}
