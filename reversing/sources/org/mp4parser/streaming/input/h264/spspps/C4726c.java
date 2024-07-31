package org.mp4parser.streaming.input.h264.spspps;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.c */
/* loaded from: classes2.dex */
public class ChromaFormat {

    /* renamed from: a */
    public static ChromaFormat f12251a = new ChromaFormat(0, 0, 0);

    /* renamed from: b */
    public static ChromaFormat f12252b = new ChromaFormat(1, 2, 2);

    /* renamed from: c */
    public static ChromaFormat f12253c = new ChromaFormat(2, 2, 1);

    /* renamed from: d */
    public static ChromaFormat f12254d = new ChromaFormat(3, 1, 1);

    /* renamed from: e */
    private int f12255e;

    /* renamed from: f */
    private int f12256f;

    /* renamed from: g */
    private int f12257g;

    public ChromaFormat(int i, int i2, int i3) {
        this.f12255e = i;
        this.f12256f = i2;
        this.f12257g = i3;
    }

    /* renamed from: a */
    public static ChromaFormat m420a(int i) {
        ChromaFormat chromaFormat = f12251a;
        if (i == chromaFormat.f12255e) {
            return chromaFormat;
        }
        ChromaFormat chromaFormat2 = f12252b;
        if (i == chromaFormat2.f12255e) {
            return chromaFormat2;
        }
        ChromaFormat chromaFormat3 = f12253c;
        if (i == chromaFormat3.f12255e) {
            return chromaFormat3;
        }
        ChromaFormat chromaFormat4 = f12254d;
        if (i == chromaFormat4.f12255e) {
            return chromaFormat4;
        }
        return null;
    }

    /* renamed from: a */
    public int m421a() {
        return this.f12255e;
    }

    /* renamed from: b */
    public int m419b() {
        return this.f12256f;
    }

    /* renamed from: c */
    public int m418c() {
        return this.f12257g;
    }

    public String toString() {
        return "ChromaFormat{\nid=" + this.f12255e + ",\n subWidth=" + this.f12256f + ",\n subHeight=" + this.f12257g + '}';
    }
}
