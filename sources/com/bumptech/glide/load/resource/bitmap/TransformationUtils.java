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
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.bumptech.glide.load.resource.bitmap.t */
/* loaded from: classes.dex */
public final class TransformationUtils {

    /* renamed from: c */
    private static final Paint f1078c;

    /* renamed from: e */
    private static final Lock f1080e;

    /* renamed from: a */
    private static final Paint f1076a = new Paint(6);

    /* renamed from: b */
    private static final Paint f1077b = new Paint(7);

    /* renamed from: d */
    private static final Set<String> f1079d = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));

    /* renamed from: a */
    public static int m11916a(int i) {
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
    public static boolean m11907b(int i) {
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
        f1080e = f1079d.contains(Build.MODEL) ? new ReentrantLock() : new locksLockC0752a();
        f1078c = new Paint(7);
        f1078c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    /* renamed from: a */
    public static Lock m11917a() {
        return f1080e;
    }

    /* renamed from: a */
    public static Bitmap m11908a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
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
        Bitmap mo12181a = bitmapPool.mo12181a(i, i2, m11906b(bitmap));
        m11913a(bitmap, mo12181a);
        m11912a(bitmap, mo12181a, matrix);
        return mo12181a;
    }

    /* renamed from: b */
    public static Bitmap m11904b(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
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
        Bitmap mo12181a = bitmapPool.mo12181a((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), m11906b(bitmap));
        m11913a(bitmap, mo12181a);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + mo12181a.getWidth() + "x" + mo12181a.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        m11912a(bitmap, mo12181a, matrix);
        return mo12181a;
    }

    /* renamed from: c */
    public static Bitmap m11903c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return m11904b(bitmapPool, bitmap, i, i2);
    }

    /* renamed from: a */
    public static void m11913a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    /* renamed from: a */
    public static Bitmap m11909a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        if (m11907b(i)) {
            Matrix matrix = new Matrix();
            m11915a(i, matrix);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            Bitmap mo12181a = bitmapPool.mo12181a(Math.round(rectF.width()), Math.round(rectF.height()), m11906b(bitmap));
            matrix.postTranslate(-rectF.left, -rectF.top);
            m11912a(bitmap, mo12181a, matrix);
            return mo12181a;
        }
        return bitmap;
    }

    /* renamed from: d */
    public static Bitmap m11902d(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
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
        Bitmap m11910a = m11910a(bitmapPool, bitmap);
        Bitmap mo12181a = bitmapPool.mo12181a(min, min, m11914a(bitmap));
        mo12181a.setHasAlpha(true);
        f1080e.lock();
        try {
            Canvas canvas = new Canvas(mo12181a);
            canvas.drawCircle(f2, f2, f2, f1077b);
            canvas.drawBitmap(m11910a, (Rect) null, rectF, f1078c);
            m11911a(canvas);
            f1080e.unlock();
            if (!m11910a.equals(bitmap)) {
                bitmapPool.mo11931a(m11910a);
            }
            return mo12181a;
        } catch (Throwable th) {
            f1080e.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static Bitmap m11910a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        Bitmap.Config m11914a = m11914a(bitmap);
        if (m11914a.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap mo12181a = bitmapPool.mo12181a(bitmap.getWidth(), bitmap.getHeight(), m11914a);
        new Canvas(mo12181a).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return mo12181a;
    }

    @NonNull
    /* renamed from: a */
    private static Bitmap.Config m11914a(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    /* renamed from: b */
    public static Bitmap m11905b(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i) {
        Preconditions.m11576a(i > 0, "roundingRadius must be greater than 0.");
        Bitmap.Config m11914a = m11914a(bitmap);
        Bitmap m11910a = m11910a(bitmapPool, bitmap);
        Bitmap mo12181a = bitmapPool.mo12181a(m11910a.getWidth(), m11910a.getHeight(), m11914a);
        mo12181a.setHasAlpha(true);
        BitmapShader bitmapShader = new BitmapShader(m11910a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, mo12181a.getWidth(), mo12181a.getHeight());
        f1080e.lock();
        try {
            Canvas canvas = new Canvas(mo12181a);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f = i;
            canvas.drawRoundRect(rectF, f, f, paint);
            m11911a(canvas);
            f1080e.unlock();
            if (!m11910a.equals(bitmap)) {
                bitmapPool.mo11931a(m11910a);
            }
            return mo12181a;
        } catch (Throwable th) {
            f1080e.unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m11911a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    @NonNull
    /* renamed from: b */
    private static Bitmap.Config m11906b(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    /* renamed from: a */
    private static void m11912a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        f1080e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f1076a);
            m11911a(canvas);
        } finally {
            f1080e.unlock();
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m11915a(int i, Matrix matrix) {
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
    /* renamed from: com.bumptech.glide.load.resource.bitmap.t$a  reason: invalid class name */
    /* loaded from: classes.dex */
    private static final class locksLockC0752a implements Lock {
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

        locksLockC0752a() {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }
}
