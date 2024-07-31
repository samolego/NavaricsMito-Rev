package com.squareup.picasso;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot.java */
/* renamed from: com.squareup.picasso.v, reason: use source file name */
/* loaded from: classes2.dex */
public class StatsSnapshot {

    /* renamed from: a */
    public final int f7077a;

    /* renamed from: b */
    public final int f7078b;

    /* renamed from: c */
    public final long f7079c;

    /* renamed from: d */
    public final long f7080d;

    /* renamed from: e */
    public final long f7081e;

    /* renamed from: f */
    public final long f7082f;

    /* renamed from: g */
    public final long f7083g;

    /* renamed from: h */
    public final long f7084h;

    /* renamed from: i */
    public final long f7085i;

    /* renamed from: j */
    public final long f7086j;

    /* renamed from: k */
    public final int f7087k;

    /* renamed from: l */
    public final int f7088l;

    /* renamed from: m */
    public final int f7089m;

    /* renamed from: n */
    public final long f7090n;

    public StatsSnapshot(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f7077a = i;
        this.f7078b = i2;
        this.f7079c = j;
        this.f7080d = j2;
        this.f7081e = j3;
        this.f7082f = j4;
        this.f7083g = j5;
        this.f7084h = j6;
        this.f7085i = j7;
        this.f7086j = j8;
        this.f7087k = i3;
        this.f7088l = i4;
        this.f7089m = i5;
        this.f7090n = j9;
    }

    /* renamed from: a */
    public void m7233a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f7077a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f7078b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f7078b / this.f7077a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f7079c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f7080d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f7087k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f7081e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f7084h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f7088l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f7082f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f7089m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f7083g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f7085i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f7086j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f7077a + ", size=" + this.f7078b + ", cacheHits=" + this.f7079c + ", cacheMisses=" + this.f7080d + ", downloadCount=" + this.f7087k + ", totalDownloadSize=" + this.f7081e + ", averageDownloadSize=" + this.f7084h + ", totalOriginalBitmapSize=" + this.f7082f + ", totalTransformedBitmapSize=" + this.f7083g + ", averageOriginalBitmapSize=" + this.f7085i + ", averageTransformedBitmapSize=" + this.f7086j + ", originalBitmapCount=" + this.f7088l + ", transformedBitmapCount=" + this.f7089m + ", timeStamp=" + this.f7090n + '}';
    }
}