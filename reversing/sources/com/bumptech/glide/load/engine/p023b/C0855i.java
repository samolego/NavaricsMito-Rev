package com.bumptech.glide.load.engine.p023b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* renamed from: com.bumptech.glide.load.engine.b.i */
/* loaded from: classes.dex */
public final class MemorySizeCalculator {

    /* renamed from: a */
    private final int f831a;

    /* renamed from: b */
    private final int f832b;

    /* renamed from: c */
    private final Context f833c;

    /* renamed from: d */
    private final int f834d;

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.i$c */
    /* loaded from: classes.dex */
    interface InterfaceC0709c {
        /* renamed from: a */
        int mo12124a();

        /* renamed from: b */
        int mo12123b();
    }

    MemorySizeCalculator(C0707a c0707a) {
        int i;
        this.f833c = c0707a.f836b;
        if (m12129a(c0707a.f837c)) {
            i = c0707a.f843i / 2;
        } else {
            i = c0707a.f843i;
        }
        this.f834d = i;
        int m12128a = m12128a(c0707a.f837c, c0707a.f841g, c0707a.f842h);
        float mo12124a = c0707a.f838d.mo12124a() * c0707a.f838d.mo12123b() * 4;
        int round = Math.round(c0707a.f840f * mo12124a);
        int round2 = Math.round(mo12124a * c0707a.f839e);
        int i2 = m12128a - this.f834d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f832b = round2;
            this.f831a = round;
        } else {
            float f = i2 / (c0707a.f840f + c0707a.f839e);
            this.f832b = Math.round(c0707a.f839e * f);
            this.f831a = Math.round(f * c0707a.f840f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m12130a(this.f832b));
            sb.append(", pool size: ");
            sb.append(m12130a(this.f831a));
            sb.append(", byte array size: ");
            sb.append(m12130a(this.f834d));
            sb.append(", memory class limited? ");
            sb.append(i3 > m12128a);
            sb.append(", max size: ");
            sb.append(m12130a(m12128a));
            sb.append(", memoryClass: ");
            sb.append(c0707a.f837c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m12129a(c0707a.f837c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    /* renamed from: a */
    public int m12131a() {
        return this.f832b;
    }

    /* renamed from: b */
    public int m12127b() {
        return this.f831a;
    }

    /* renamed from: c */
    public int m12126c() {
        return this.f834d;
    }

    /* renamed from: a */
    private static int m12128a(ActivityManager activityManager, float f, float f2) {
        boolean m12129a = m12129a(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (m12129a) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    /* renamed from: a */
    private String m12130a(int i) {
        return Formatter.formatFileSize(this.f833c, i);
    }

    @TargetApi(19)
    /* renamed from: a */
    static boolean m12129a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.i$a */
    /* loaded from: classes.dex */
    public static final class C0707a {

        /* renamed from: a */
        static final int f835a;

        /* renamed from: b */
        final Context f836b;

        /* renamed from: c */
        ActivityManager f837c;

        /* renamed from: d */
        InterfaceC0709c f838d;

        /* renamed from: f */
        float f840f;

        /* renamed from: e */
        float f839e = 2.0f;

        /* renamed from: g */
        float f841g = 0.4f;

        /* renamed from: h */
        float f842h = 0.33f;

        /* renamed from: i */
        int f843i = 4194304;

        static {
            f835a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public C0707a(Context context) {
            this.f840f = f835a;
            this.f836b = context;
            this.f837c = (ActivityManager) context.getSystemService("activity");
            this.f838d = new C0708b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.m12129a(this.f837c)) {
                return;
            }
            this.f840f = 0.0f;
        }

        /* renamed from: a */
        public MemorySizeCalculator m12125a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.i$b */
    /* loaded from: classes.dex */
    private static final class C0708b implements InterfaceC0709c {

        /* renamed from: a */
        private final DisplayMetrics f844a;

        C0708b(DisplayMetrics displayMetrics) {
            this.f844a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.p023b.MemorySizeCalculator.InterfaceC0709c
        /* renamed from: a */
        public int mo12124a() {
            return this.f844a.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.p023b.MemorySizeCalculator.InterfaceC0709c
        /* renamed from: b */
        public int mo12123b() {
            return this.f844a.heightPixels;
        }
    }
}
