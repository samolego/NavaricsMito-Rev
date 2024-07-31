package com.bumptech.glide.load.engine.p019b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator.java */
/* renamed from: com.bumptech.glide.load.engine.b.i, reason: use source file name */
/* loaded from: classes.dex */
public final class MemorySizeCalculator {

    /* renamed from: a */
    private final int f835a;

    /* renamed from: b */
    private final int f836b;

    /* renamed from: c */
    private final Context f837c;

    /* renamed from: d */
    private final int f838d;

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.i$c */
    /* loaded from: classes.dex */
    interface c {
        /* renamed from: a */
        int mo858a();

        /* renamed from: b */
        int mo859b();
    }

    MemorySizeCalculator(a aVar) {
        int i;
        this.f837c = aVar.f840b;
        if (m853a(aVar.f841c)) {
            i = aVar.f847i / 2;
        } else {
            i = aVar.f847i;
        }
        this.f838d = i;
        int m851a = m851a(aVar.f841c, aVar.f845g, aVar.f846h);
        float mo858a = aVar.f842d.mo858a() * aVar.f842d.mo859b() * 4;
        int round = Math.round(aVar.f844f * mo858a);
        int round2 = Math.round(mo858a * aVar.f843e);
        int i2 = m851a - this.f838d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f836b = round2;
            this.f835a = round;
        } else {
            float f = i2 / (aVar.f844f + aVar.f843e);
            this.f836b = Math.round(aVar.f843e * f);
            this.f835a = Math.round(f * aVar.f844f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m852a(this.f836b));
            sb.append(", pool size: ");
            sb.append(m852a(this.f835a));
            sb.append(", byte array size: ");
            sb.append(m852a(this.f838d));
            sb.append(", memory class limited? ");
            sb.append(i3 > m851a);
            sb.append(", max size: ");
            sb.append(m852a(m851a));
            sb.append(", memoryClass: ");
            sb.append(aVar.f841c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m853a(aVar.f841c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    /* renamed from: a */
    public int m854a() {
        return this.f836b;
    }

    /* renamed from: b */
    public int m855b() {
        return this.f835a;
    }

    /* renamed from: c */
    public int m856c() {
        return this.f838d;
    }

    /* renamed from: a */
    private static int m851a(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (m853a(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    /* renamed from: a */
    private String m852a(int i) {
        return Formatter.formatFileSize(this.f837c, i);
    }

    @TargetApi(19)
    /* renamed from: a */
    static boolean m853a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.i$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        static final int f839a;

        /* renamed from: b */
        final Context f840b;

        /* renamed from: c */
        ActivityManager f841c;

        /* renamed from: d */
        c f842d;

        /* renamed from: f */
        float f844f;

        /* renamed from: e */
        float f843e = 2.0f;

        /* renamed from: g */
        float f845g = 0.4f;

        /* renamed from: h */
        float f846h = 0.33f;

        /* renamed from: i */
        int f847i = 4194304;

        static {
            f839a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f844f = f839a;
            this.f840b = context;
            this.f841c = (ActivityManager) context.getSystemService("activity");
            this.f842d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.m853a(this.f841c)) {
                return;
            }
            this.f844f = 0.0f;
        }

        /* renamed from: a */
        public MemorySizeCalculator m857a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.i$b */
    /* loaded from: classes.dex */
    private static final class b implements c {

        /* renamed from: a */
        private final DisplayMetrics f848a;

        b(DisplayMetrics displayMetrics) {
            this.f848a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.p019b.MemorySizeCalculator.c
        /* renamed from: a */
        public int mo858a() {
            return this.f848a.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.p019b.MemorySizeCalculator.c
        /* renamed from: b */
        public int mo859b() {
            return this.f848a.heightPixels;
        }
    }
}