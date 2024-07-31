package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.p016b.InterfaceC0599l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* renamed from: com.bumptech.glide.util.i */
/* loaded from: classes.dex */
public final class C0781i {

    /* renamed from: a */
    private static final char[] f1310a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    private static final char[] f1311b = new char[64];

    /* renamed from: b */
    public static int m1382b(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* renamed from: c */
    private static boolean m1386c(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    @NonNull
    /* renamed from: a */
    public static String m1374a(@NonNull byte[] bArr) {
        String m1375a;
        synchronized (f1311b) {
            m1375a = m1375a(bArr, f1311b);
        }
        return m1375a;
    }

    @NonNull
    /* renamed from: a */
    private static String m1375a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f1310a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    /* renamed from: a */
    public static int m1371a(@NonNull Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    /* renamed from: a */
    public static int m1369a(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * m1370a(config);
    }

    /* renamed from: a */
    private static int m1370a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (AnonymousClass1.f1312a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            case 4:
                return 8;
            default:
                return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Util.java */
    /* renamed from: com.bumptech.glide.util.i$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1312a = new int[Bitmap.Config.values().length];

        static {
            try {
                f1312a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1312a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1312a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1312a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1312a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m1379a(int i, int i2) {
        return m1386c(i) && m1386c(i2);
    }

    /* renamed from: a */
    public static void m1378a() {
        if (!m1385c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: b */
    public static void m1383b() {
        if (!m1387d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    /* renamed from: c */
    public static boolean m1385c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: d */
    public static boolean m1387d() {
        return !m1385c();
    }

    @NonNull
    /* renamed from: a */
    public static <T> Queue<T> m1377a(int i) {
        return new ArrayDeque(i);
    }

    @NonNull
    /* renamed from: a */
    public static <T> List<T> m1376a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m1380a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static boolean m1384b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof InterfaceC0599l) {
            return ((InterfaceC0599l) obj).m648a(obj2);
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static int m1381b(int i) {
        return m1382b(i, 17);
    }

    /* renamed from: a */
    public static int m1367a(float f) {
        return m1368a(f, 17);
    }

    /* renamed from: a */
    public static int m1368a(float f, int i) {
        return m1382b(Float.floatToIntBits(f), i);
    }

    /* renamed from: a */
    public static int m1372a(@Nullable Object obj, int i) {
        return m1382b(obj == null ? 0 : obj.hashCode(), i);
    }

    /* renamed from: a */
    public static int m1373a(boolean z, int i) {
        return m1382b(z ? 1 : 0, i);
    }
}