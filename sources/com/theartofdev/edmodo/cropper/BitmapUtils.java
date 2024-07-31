package com.theartofdev.edmodo.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.support.media.ExifInterface;
import android.util.Log;
import android.util.Pair;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.theartofdev.edmodo.cropper.c */
/* loaded from: classes2.dex */
public final class BitmapUtils {

    /* renamed from: a */
    static final Rect f8368a = new Rect();

    /* renamed from: b */
    static final RectF f8369b = new RectF();

    /* renamed from: c */
    static final RectF f8370c = new RectF();

    /* renamed from: d */
    static final float[] f8371d = new float[6];

    /* renamed from: e */
    static final float[] f8372e = new float[6];

    /* renamed from: f */
    static Pair<String, WeakReference<Bitmap>> f8373f;

    /* renamed from: g */
    private static int f8374g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C2632b m4624a(Bitmap bitmap, Context context, Uri uri) {
        ExifInterface exifInterface;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                exifInterface = new ExifInterface(openInputStream);
                try {
                    openInputStream.close();
                } catch (Exception unused) {
                }
            } else {
                exifInterface = null;
            }
        } catch (Exception unused2) {
            exifInterface = null;
        }
        return exifInterface != null ? m4623a(bitmap, exifInterface) : new C2632b(bitmap, 0);
    }

    /* renamed from: a */
    static C2632b m4623a(Bitmap bitmap, ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        return new C2632b(bitmap, attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C2631a m4631a(Context context, Uri uri, int i, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options m4635a = m4635a(contentResolver, uri);
            m4635a.inSampleSize = Math.max(m4636a(m4635a.outWidth, m4635a.outHeight, i, i2), m4637a(m4635a.outWidth, m4635a.outHeight));
            return new C2631a(m4634a(contentResolver, uri, m4635a), m4635a.inSampleSize);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C2631a m4621a(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        int i4 = 1;
        do {
            try {
                return new C2631a(m4622a(bitmap, fArr, i, z, i2, i3, 1.0f / i4, z2, z3), i4);
            } catch (OutOfMemoryError e) {
                i4 *= 2;
                if (i4 > 8) {
                    throw e;
                }
            }
        } while (i4 > 8);
        throw e;
    }

    /* renamed from: a */
    private static Bitmap m4622a(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f, boolean z2, boolean z3) {
        float f2 = f;
        Rect m4616a = m4616a(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        float f3 = z2 ? -f2 : f2;
        if (z3) {
            f2 = -f2;
        }
        matrix.postScale(f3, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, m4616a.left, m4616a.top, m4616a.width(), m4616a.height(), matrix, true);
        if (createBitmap == bitmap) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i % 90 != 0 ? m4620a(createBitmap, fArr, m4616a, i, z, i2, i3) : createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C2631a m4629a(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        int i8 = 1;
        do {
            try {
                return m4628a(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i8);
            } catch (OutOfMemoryError e) {
                i8 *= 2;
                if (i8 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e.getMessage(), e);
                }
            }
        } while (i8 > 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e.getMessage(), e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static float m4617a(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static float m4615b(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static float m4614c(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static float m4613d(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static float m4612e(float[] fArr) {
        return m4614c(fArr) - m4617a(fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static float m4611f(float[] fArr) {
        return m4613d(fArr) - m4615b(fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static float m4610g(float[] fArr) {
        return (m4614c(fArr) + m4617a(fArr)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static float m4609h(float[] fArr) {
        return (m4613d(fArr) + m4615b(fArr)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Rect m4616a(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, m4617a(fArr))), Math.round(Math.max(0.0f, m4615b(fArr))), Math.round(Math.min(i, m4614c(fArr))), Math.round(Math.min(i2, m4613d(fArr))));
        if (z) {
            m4619a(rect, i3, i4);
        }
        return rect;
    }

    /* renamed from: a */
    private static void m4619a(Rect rect, int i, int i2) {
        if (i != i2 || rect.width() == rect.height()) {
            return;
        }
        if (rect.height() > rect.width()) {
            rect.bottom -= rect.height() - rect.width();
        } else {
            rect.right -= rect.width() - rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Uri m4633a(Context context, Bitmap bitmap, Uri uri) {
        boolean z = true;
        try {
            if (uri == null) {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } else if (new File(uri.getPath()).exists()) {
                z = false;
            }
            if (z) {
                m4632a(context, bitmap, uri, Bitmap.CompressFormat.JPEG, 95);
            }
            return uri;
        } catch (Exception e) {
            Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4632a(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i) throws FileNotFoundException {
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i, outputStream);
        } finally {
            m4618a(outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Bitmap m4626a(Bitmap bitmap, int i, int i2, CropImageView.RequestSizeOptions requestSizeOptions) {
        if (i > 0 && i2 > 0) {
            try {
                if (requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_FIT || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_INSIDE || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                    Bitmap bitmap2 = null;
                    if (requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                    } else {
                        float width = bitmap.getWidth();
                        float height = bitmap.getHeight();
                        float max = Math.max(width / i, height / i2);
                        if (max > 1.0f || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_FIT) {
                            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width / max), (int) (height / max), false);
                        }
                    }
                    if (bitmap2 != null) {
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmap2;
                    }
                }
            } catch (Exception e) {
                Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", e);
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private static C2631a m4628a(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, int i8) {
        Bitmap bitmap;
        Bitmap m4625a;
        Rect m4616a = m4616a(fArr, i2, i3, z, i4, i5);
        int width = i6 > 0 ? i6 : m4616a.width();
        int height = i7 > 0 ? i7 : m4616a.height();
        Bitmap bitmap2 = null;
        int i9 = 1;
        try {
            C2631a m4630a = m4630a(context, uri, m4616a, width, height, i8);
            bitmap2 = m4630a.f8375a;
            i9 = m4630a.f8376b;
        } catch (Exception unused) {
        }
        if (bitmap2 != null) {
            try {
                m4625a = m4625a(bitmap2, i, z2, z3);
            } catch (OutOfMemoryError e) {
                e = e;
                bitmap = bitmap2;
            }
            try {
                if (i % 90 != 0) {
                    m4625a = m4620a(m4625a, fArr, m4616a, i, z, i4, i5);
                }
                return new C2631a(m4625a, i9);
            } catch (OutOfMemoryError e2) {
                e = e2;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw e;
            }
        }
        return m4627a(context, uri, fArr, i, z, i4, i5, i8, m4616a, width, height, z2, z3);
    }

    /* renamed from: a */
    private static C2631a m4627a(Context context, Uri uri, float[] fArr, int i, boolean z, int i2, int i3, int i4, Rect rect, int i5, int i6, boolean z2, boolean z3) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int m4636a = m4636a(rect.width(), rect.height(), i5, i6) * i4;
            options.inSampleSize = m4636a;
            Bitmap m4634a = m4634a(context.getContentResolver(), uri, options);
            if (m4634a != null) {
                try {
                    float[] fArr2 = new float[fArr.length];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    for (int i7 = 0; i7 < fArr2.length; i7++) {
                        fArr2[i7] = fArr2[i7] / options.inSampleSize;
                    }
                    bitmap = m4622a(m4634a, fArr2, i, z, i2, i3, 1.0f, z2, z3);
                    if (bitmap != m4634a) {
                        m4634a.recycle();
                    }
                } catch (Throwable th) {
                    if (m4634a != null) {
                        m4634a.recycle();
                    }
                    throw th;
                }
            }
            return new C2631a(bitmap, m4636a);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e.getMessage(), e);
        } catch (OutOfMemoryError e2) {
            if (0 != 0) {
                bitmap.recycle();
            }
            throw e2;
        }
    }

    /* renamed from: a */
    private static BitmapFactory.Options m4635a(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        InputStream inputStream;
        try {
            inputStream = contentResolver.openInputStream(uri);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, f8368a, options);
            options.inJustDecodeBounds = false;
            m4618a(inputStream);
            return options;
        } catch (Throwable th2) {
            th = th2;
            m4618a(inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private static Bitmap m4634a(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        do {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = contentResolver.openInputStream(uri);
                    return BitmapFactory.decodeStream(inputStream, f8368a, options);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    m4618a(inputStream);
                    if (options.inSampleSize > 512) {
                        throw new RuntimeException("Failed to decode image: " + uri);
                    }
                }
            } finally {
                m4618a(inputStream);
            }
        } while (options.inSampleSize > 512);
        throw new RuntimeException("Failed to decode image: " + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.theartofdev.edmodo.cropper.BitmapUtils.C2631a m4630a(android.content.Context r4, android.net.Uri r5, android.graphics.Rect r6, int r7, int r8, int r9) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            r1.<init>()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            int r2 = r6.width()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            int r3 = r6.height()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            int r7 = m4636a(r2, r3, r7, r8)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            int r9 = r9 * r7
            r1.inSampleSize = r9     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            r7 = 0
            android.graphics.BitmapRegionDecoder r7 = android.graphics.BitmapRegionDecoder.newInstance(r4, r7)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L5a
        L23:
            com.theartofdev.edmodo.cropper.c$a r8 = new com.theartofdev.edmodo.cropper.c$a     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.OutOfMemoryError -> L3b
            android.graphics.Bitmap r9 = r7.decodeRegion(r6, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.OutOfMemoryError -> L3b
            int r2 = r1.inSampleSize     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.OutOfMemoryError -> L3b
            r8.<init>(r9, r2)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39 java.lang.OutOfMemoryError -> L3b
            m4618a(r4)
            if (r7 == 0) goto L36
            r7.recycle()
        L36:
            return r8
        L37:
            r5 = move-exception
            goto L58
        L39:
            r6 = move-exception
            goto L5c
        L3b:
            int r8 = r1.inSampleSize     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            int r8 = r8 * 2
            r1.inSampleSize = r8     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            int r8 = r1.inSampleSize     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r9 = 512(0x200, float:7.17E-43)
            if (r8 <= r9) goto L23
            m4618a(r4)
            if (r7 == 0) goto L4f
            r7.recycle()
        L4f:
            com.theartofdev.edmodo.cropper.c$a r4 = new com.theartofdev.edmodo.cropper.c$a
            r5 = 1
            r4.<init>(r0, r5)
            return r4
        L56:
            r5 = move-exception
            r7 = r0
        L58:
            r0 = r4
            goto L87
        L5a:
            r6 = move-exception
            r7 = r0
        L5c:
            r0 = r4
            goto L63
        L5e:
            r5 = move-exception
            r7 = r0
            goto L87
        L61:
            r6 = move-exception
            r7 = r0
        L63:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r8.<init>()     // Catch: java.lang.Throwable -> L86
            java.lang.String r9 = "Failed to load sampled bitmap: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L86
            r8.append(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = "\r\n"
            r8.append(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = r6.getMessage()     // Catch: java.lang.Throwable -> L86
            r8.append(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = r8.toString()     // Catch: java.lang.Throwable -> L86
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L86
            throw r4     // Catch: java.lang.Throwable -> L86
        L86:
            r5 = move-exception
        L87:
            m4618a(r0)
            if (r7 == 0) goto L8f
            r7.recycle()
        L8f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.BitmapUtils.m4630a(android.content.Context, android.net.Uri, android.graphics.Rect, int, int, int):com.theartofdev.edmodo.cropper.c$a");
    }

    /* renamed from: a */
    private static Bitmap m4620a(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i % 90 != 0) {
            double radians = Math.toRadians(i);
            int i7 = (i < 90 || (i > 180 && i < 270)) ? rect.left : rect.right;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= fArr.length) {
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    break;
                } else if (fArr[i9] >= i7 - 1 && fArr[i9] <= i7 + 1) {
                    int i10 = i9 + 1;
                    i8 = (int) Math.abs(Math.sin(radians) * (rect.bottom - fArr[i10]));
                    i5 = (int) Math.abs(Math.cos(radians) * (fArr[i10] - rect.top));
                    i6 = (int) Math.abs((fArr[i10] - rect.top) / Math.sin(radians));
                    i4 = (int) Math.abs((rect.bottom - fArr[i10]) / Math.cos(radians));
                    break;
                } else {
                    i9 += 2;
                }
            }
            rect.set(i8, i5, i6 + i8, i4 + i5);
            if (z) {
                m4619a(rect, i2, i3);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    /* renamed from: a */
    private static int m4636a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* renamed from: a */
    private static int m4637a(int i, int i2) {
        if (f8374g == 0) {
            f8374g = m4638a();
        }
        int i3 = 1;
        if (f8374g > 0) {
            while (true) {
                int i4 = i2 / i3;
                int i5 = f8374g;
                if (i4 <= i5 && i / i3 <= i5) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    /* renamed from: a */
    private static Bitmap m4625a(Bitmap bitmap, int i, boolean z, boolean z2) {
        if (i > 0 || z || z2) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i);
            matrix.postScale(z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    /* renamed from: a */
    private static int m4638a() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
            int[] iArr2 = new int[1];
            int i = 0;
            for (int i2 = 0; i2 < iArr[0]; i2++) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i2], 12332, iArr2);
                if (i < iArr2[0]) {
                    i = iArr2[0];
                }
            }
            egl10.eglTerminate(eglGetDisplay);
            return Math.max(i, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    /* renamed from: a */
    private static void m4618a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapUtils.java */
    /* renamed from: com.theartofdev.edmodo.cropper.c$a */
    /* loaded from: classes2.dex */
    public static final class C2631a {

        /* renamed from: a */
        public final Bitmap f8375a;

        /* renamed from: b */
        final int f8376b;

        C2631a(Bitmap bitmap, int i) {
            this.f8375a = bitmap;
            this.f8376b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapUtils.java */
    /* renamed from: com.theartofdev.edmodo.cropper.c$b */
    /* loaded from: classes2.dex */
    public static final class C2632b {

        /* renamed from: a */
        public final Bitmap f8377a;

        /* renamed from: b */
        final int f8378b;

        C2632b(Bitmap bitmap, int i) {
            this.f8377a = bitmap;
            this.f8378b = i;
        }
    }
}
