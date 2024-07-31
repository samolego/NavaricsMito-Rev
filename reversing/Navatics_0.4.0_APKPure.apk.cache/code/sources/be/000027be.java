package org.mp4parser.streaming.input.h264.spspps;

/* compiled from: ChromaFormat.java */
/* renamed from: org.mp4parser.streaming.input.h264.spspps.c, reason: use source file name */
/* loaded from: classes2.dex */
public class ChromaFormat {

    /* renamed from: a */
    public static ChromaFormat f12292a = new ChromaFormat(0, 0, 0);

    /* renamed from: b */
    public static ChromaFormat f12293b = new ChromaFormat(1, 2, 2);

    /* renamed from: c */
    public static ChromaFormat f12294c = new ChromaFormat(2, 2, 1);

    /* renamed from: d */
    public static ChromaFormat f12295d = new ChromaFormat(3, 1, 1);

    /* renamed from: e */
    private int f12296e;

    /* renamed from: f */
    private int f12297f;

    /* renamed from: g */
    private int f12298g;

    public ChromaFormat(int i, int i2, int i3) {
        this.f12296e = i;
        this.f12297f = i2;
        this.f12298g = i3;
    }

    /* renamed from: a */
    public static ChromaFormat m12396a(int i) {
        ChromaFormat chromaFormat = f12292a;
        if (i == chromaFormat.f12296e) {
            return chromaFormat;
        }
        ChromaFormat chromaFormat2 = f12293b;
        if (i == chromaFormat2.f12296e) {
            return chromaFormat2;
        }
        ChromaFormat chromaFormat3 = f12294c;
        if (i == chromaFormat3.f12296e) {
            return chromaFormat3;
        }
        ChromaFormat chromaFormat4 = f12295d;
        if (i == chromaFormat4.f12296e) {
            return chromaFormat4;
        }
        return null;
    }

    /* renamed from: a */
    public int m12397a() {
        return this.f12296e;
    }

    /* renamed from: b */
    public int m12398b() {
        return this.f12297f;
    }

    /* renamed from: c */
    public int m12399c() {
        return this.f12298g;
    }

    public String toString() {
        return "ChromaFormat{\nid=" + this.f12296e + ",\n subWidth=" + this.f12297f + ",\n subHeight=" + this.f12298g + '}';
    }
}