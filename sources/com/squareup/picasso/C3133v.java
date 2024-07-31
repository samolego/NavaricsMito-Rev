package com.squareup.picasso;

import java.io.PrintWriter;

/* renamed from: com.squareup.picasso.v */
/* loaded from: classes2.dex */
public class StatsSnapshot {

    /* renamed from: a */
    public final int f7045a;

    /* renamed from: b */
    public final int f7046b;

    /* renamed from: c */
    public final long f7047c;

    /* renamed from: d */
    public final long f7048d;

    /* renamed from: e */
    public final long f7049e;

    /* renamed from: f */
    public final long f7050f;

    /* renamed from: g */
    public final long f7051g;

    /* renamed from: h */
    public final long f7052h;

    /* renamed from: i */
    public final long f7053i;

    /* renamed from: j */
    public final long f7054j;

    /* renamed from: k */
    public final int f7055k;

    /* renamed from: l */
    public final int f7056l;

    /* renamed from: m */
    public final int f7057m;

    /* renamed from: n */
    public final long f7058n;

    public StatsSnapshot(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f7045a = i;
        this.f7046b = i2;
        this.f7047c = j;
        this.f7048d = j2;
        this.f7049e = j3;
        this.f7050f = j4;
        this.f7051g = j5;
        this.f7052h = j6;
        this.f7053i = j7;
        this.f7054j = j8;
        this.f7055k = i3;
        this.f7056l = i4;
        this.f7057m = i5;
        this.f7058n = j9;
    }

    /* renamed from: a */
    public void m5620a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f7045a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f7046b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f7046b / this.f7045a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f7047c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f7048d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f7055k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f7049e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f7052h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f7056l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f7050f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f7057m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f7051g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f7053i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f7054j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f7045a + ", size=" + this.f7046b + ", cacheHits=" + this.f7047c + ", cacheMisses=" + this.f7048d + ", downloadCount=" + this.f7055k + ", totalDownloadSize=" + this.f7049e + ", averageDownloadSize=" + this.f7052h + ", totalOriginalBitmapSize=" + this.f7050f + ", totalTransformedBitmapSize=" + this.f7051g + ", averageOriginalBitmapSize=" + this.f7053i + ", averageTransformedBitmapSize=" + this.f7054j + ", originalBitmapCount=" + this.f7056l + ", transformedBitmapCount=" + this.f7057m + ", timeStamp=" + this.f7058n + '}';
    }
}
