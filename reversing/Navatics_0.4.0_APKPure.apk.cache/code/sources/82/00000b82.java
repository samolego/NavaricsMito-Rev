package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.engine.p018a.InterfaceC0627e;
import com.bumptech.glide.util.C0780h;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TransformationUtils.java */
/* renamed from: com.bumptech.glide.load.resource.bitmap.t, reason: use source file name */
/* loaded from: classes.dex */
public final class TransformationUtils {

    /* renamed from: c */
    private static final Paint f1082c;

    /* renamed from: e */
    private static final Lock f1084e;

    /* renamed from: a */
    private static final Paint f1080a = new Paint(6);

    /* renamed from: b */
    private static final Paint f1081b = new Paint(7);

    /* renamed from: d */
    private static final Set<String> f1083d = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));

    /* renamed from: a */
    public static int m1042a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static boolean m1055b(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    static {
        f1084e = f1083d.contains(Build.MODEL) ? new ReentrantLock() : new a();
        f1082c = new Paint(7);
        f1082c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    /* renamed from: a */
    public static Lock m1047a() {
        return f1084e;
    }

    /* renamed from: a */
    public static Bitmap m1046a(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap, int i, int i2) {
        float width;
        float f;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f2 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = i / bitmap.getWidth();
            f2 = (i2 - (bitmap.getHeight() * width)) * 0.5f;
            f = 0.0f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (f2 + 0.5f));
        Bitmap mo777a = interfaceC0627e.mo777a(i, i2, m1052b(bitmap));
        m1049a(bitmap, mo777a);
        m1050a(bitmap, mo777a, matrix);
        return mo777a;
    }

    /* renamed from: b */
    public static Bitmap m1054b(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap mo777a = interfaceC0627e.mo777a((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), m1052b(bitmap));
        m1049a(bitmap, mo777a);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + mo777a.getWidth() + "x" + mo777a.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        m1050a(bitmap, mo777a, matrix);
        return mo777a;
    }

    /* renamed from: c */
    public static Bitmap m1056c(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return m1054b(interfaceC0627e, bitmap, i, i2);
    }

    /* renamed from: a */
    public static void m1049a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    /* renamed from: a */
    public static Bitmap m1045a(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap, int i) {
        if (!m1055b(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        m1048a(i, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap mo777a = interfaceC0627e.mo777a(Math.round(rectF.width()), Math.round(rectF.height()), m1052b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        m1050a(bitmap, mo777a, matrix);
        return mo777a;
    }

    /* renamed from: d */
    public static Bitmap m1057d(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f = min;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap m1044a = m1044a(interfaceC0627e, bitmap);
        Bitmap mo777a = interfaceC0627e.mo777a(min, min, m1043a(bitmap));
        mo777a.setHasAlpha(true);
        f1084e.lock();
        try {
            Canvas canvas = new Canvas(mo777a);
            canvas.drawCircle(f2, f2, f2, f1081b);
            canvas.drawBitmap(m1044a, (Rect) null, rectF, f1082c);
            m1051a(canvas);
            f1084e.unlock();
            if (!m1044a.equals(bitmap)) {
                interfaceC0627e.mo780a(m1044a);
            }
            return mo777a;
        } catch (Throwable th) {
            f1084e.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static Bitmap m1044a(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap) {
        Bitmap.Config m1043a = m1043a(bitmap);
        if (m1043a.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap mo777a = interfaceC0627e.mo777a(bitmap.getWidth(), bitmap.getHeight(), m1043a);
        new Canvas(mo777a).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return mo777a;
    }

    @NonNull
    /* renamed from: a */
    private static Bitmap.Config m1043a(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    /* renamed from: b */
    public static Bitmap m1053b(@NonNull InterfaceC0627e interfaceC0627e, @NonNull Bitmap bitmap, int i) {
        C0780h.m1366a(i > 0, "roundingRadius must be greater than 0.");
        Bitmap.Config m1043a = m1043a(bitmap);
        Bitmap m1044a = m1044a(interfaceC0627e, bitmap);
        Bitmap mo777a = interfaceC0627e.mo777a(m1044a.getWidth(), m1044a.getHeight(), m1043a);
        mo777a.setHasAlpha(true);
        BitmapShader bitmapShader = new BitmapShader(m1044a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, mo777a.getWidth(), mo777a.getHeight());
        f1084e.lock();
        try {
            Canvas canvas = new Canvas(mo777a);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i;
            canvas.drawRoundRect(rectF, f, f, paint);
            m1051a(canvas);
            f1084e.unlock();
            if (!m1044a.equals(bitmap)) {
                interfaceC0627e.mo780a(m1044a);
            }
            return mo777a;
        } catch (Throwable th) {
            f1084e.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m1051a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    @NonNull
    /* renamed from: b */
    private static Bitmap.Config m1052b(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    /* renamed from: a */
    private static void m1050a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        f1084e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f1080a);
            m1051a(canvas);
        } finally {
            f1084e.unlock();
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m1048a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    /* compiled from: TransformationUtils.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.t$a */
    /* loaded from: classes.dex */
    private static final class a implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }

        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }
}