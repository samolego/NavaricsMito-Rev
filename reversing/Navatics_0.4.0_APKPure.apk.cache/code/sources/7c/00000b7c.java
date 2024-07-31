package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* renamed from: com.bumptech.glide.load.resource.bitmap.o, reason: use source file name */
/* loaded from: classes.dex */
final class HardwareConfigState {

    /* renamed from: a */
    private static final File f1066a = new File("/proc/self/fd");

    /* renamed from: d */
    private static volatile HardwareConfigState f1067d;

    /* renamed from: b */
    private volatile int f1068b;

    /* renamed from: c */
    private volatile boolean f1069c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static HardwareConfigState m1037a() {
        if (f1067d == null) {
            synchronized (HardwareConfigState.class) {
                if (f1067d == null) {
                    f1067d = new HardwareConfigState();
                }
            }
        }
        return f1067d;
    }

    private HardwareConfigState() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    /* renamed from: a */
    public boolean m1039a(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && m1038b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    /* renamed from: b */
    private synchronized boolean m1038b() {
        int i = this.f1068b + 1;
        this.f1068b = i;
        if (i >= 50) {
            this.f1068b = 0;
            int length = f1066a.list().length;
            this.f1069c = length < 700;
            if (!this.f1069c && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f1069c;
    }
}