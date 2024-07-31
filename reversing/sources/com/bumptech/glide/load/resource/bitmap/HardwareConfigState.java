package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* renamed from: com.bumptech.glide.load.resource.bitmap.o */
/* loaded from: classes.dex */
final class HardwareConfigState {

    /* renamed from: a */
    private static final File f1062a = new File("/proc/self/fd");

    /* renamed from: d */
    private static volatile HardwareConfigState f1063d;

    /* renamed from: b */
    private volatile int f1064b;

    /* renamed from: c */
    private volatile boolean f1065c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static HardwareConfigState m11928a() {
        if (f1063d == null) {
            synchronized (HardwareConfigState.class) {
                if (f1063d == null) {
                    f1063d = new HardwareConfigState();
                }
            }
        }
        return f1063d;
    }

    private HardwareConfigState() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    /* renamed from: a */
    public boolean m11927a(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && m11926b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    /* renamed from: b */
    private synchronized boolean m11926b() {
        int i = this.f1064b + 1;
        this.f1064b = i;
        if (i >= 50) {
            this.f1064b = 0;
            int length = f1062a.list().length;
            this.f1065c = length < 700;
            if (!this.f1065c && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f1065c;
    }
}
