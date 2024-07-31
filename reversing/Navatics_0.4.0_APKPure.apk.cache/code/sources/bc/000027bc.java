package org.mp4parser.streaming.input.h264.spspps;

/* compiled from: AspectRatio.java */
/* renamed from: org.mp4parser.streaming.input.h264.spspps.a, reason: use source file name */
/* loaded from: classes2.dex */
public class AspectRatio {

    /* renamed from: a */
    public static final AspectRatio f12286a = new AspectRatio(255);

    /* renamed from: b */
    private int f12287b;

    private AspectRatio(int i) {
        this.f12287b = i;
    }

    /* renamed from: a */
    public static AspectRatio m12387a(int i) {
        AspectRatio aspectRatio = f12286a;
        return i == aspectRatio.f12287b ? aspectRatio : new AspectRatio(i);
    }

    public String toString() {
        return "AspectRatio{value=" + this.f12287b + '}';
    }
}