package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.p020b.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* renamed from: com.bumptech.glide.util.i */
/* loaded from: classes.dex */
public final class C0791i {

    /* renamed from: a */
    private static final char[] f1306a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    private static final char[] f1307b = new char[64];

    /* renamed from: b */
    public static int m11559b(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* renamed from: c */
    private static boolean m11556c(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    @NonNull
    /* renamed from: a */
    public static String m11563a(@NonNull byte[] bArr) {
        String m11562a;
        synchronized (f1307b) {
            m11562a = m11562a(bArr, f1307b);
        }
        return m11562a;
    }

    @NonNull
    /* renamed from: a */
    private static String m11562a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f1306a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    /* renamed from: a */
    public static int m11568a(@NonNull Bitmap bitmap) {
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
    public static int m11570a(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * m11569a(config);
    }

    /* renamed from: a */
    private static int m11569a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        switch (C07921.f1308a[config.ordinal()]) {
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
    /* renamed from: com.bumptech.glide.util.i$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C07921 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1308a = new int[Bitmap.Config.values().length];

        static {
            try {
                f1308a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1308a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1308a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1308a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1308a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m11571a(int i, int i2) {
        return m11556c(i) && m11556c(i2);
    }

    /* renamed from: a */
    public static void m11575a() {
        if (!m11557c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: b */
    public static void m11561b() {
        if (!m11555d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    /* renamed from: c */
    public static boolean m11557c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: d */
    public static boolean m11555d() {
        return !m11557c();
    }

    @NonNull
    /* renamed from: a */
    public static <T> Queue<T> m11572a(int i) {
        return new ArrayDeque(i);
    }

    @NonNull
    /* renamed from: a */
    public static <T> List<T> m11565a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m11566a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static boolean m11558b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof Model) {
            return ((Model) obj).m12328a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    /* renamed from: b */
    public static int m11560b(int i) {
        return m11559b(i, 17);
    }

    /* renamed from: a */
    public static int m11574a(float f) {
        return m11573a(f, 17);
    }

    /* renamed from: a */
    public static int m11573a(float f, int i) {
        return m11559b(Float.floatToIntBits(f), i);
    }

    /* renamed from: a */
    public static int m11567a(@Nullable Object obj, int i) {
        return m11559b(obj == null ? 0 : obj.hashCode(), i);
    }

    /* renamed from: a */
    public static int m11564a(boolean z, int i) {
        return m11559b(z ? 1 : 0, i);
    }
}
