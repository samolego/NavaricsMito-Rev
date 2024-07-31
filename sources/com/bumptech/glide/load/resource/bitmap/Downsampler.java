package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.resource.bitmap.k */
/* loaded from: classes.dex */
public final class Downsampler {

    /* renamed from: a */
    public static final Option<DecodeFormat> f1045a = Option.m12279a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated

    /* renamed from: b */
    public static final Option<DownsampleStrategy> f1046b = DownsampleStrategy.f1019h;

    /* renamed from: c */
    public static final Option<Boolean> f1047c = Option.m12279a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: d */
    public static final Option<Boolean> f1048d = Option.m12280a("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");

    /* renamed from: e */
    private static final Set<String> f1049e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));

    /* renamed from: f */
    private static final InterfaceC0749a f1050f = new InterfaceC0749a() { // from class: com.bumptech.glide.load.resource.bitmap.k.1
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC0749a
        /* renamed from: a */
        public void mo11919a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC0749a
        /* renamed from: a */
        public void mo11918a(BitmapPool bitmapPool, Bitmap bitmap) {
        }
    };

    /* renamed from: g */
    private static final Set<ImageHeaderParser.ImageType> f1051g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: h */
    private static final Queue<BitmapFactory.Options> f1052h = C0791i.m11572a(0);

    /* renamed from: i */
    private final BitmapPool f1053i;

    /* renamed from: j */
    private final DisplayMetrics f1054j;

    /* renamed from: k */
    private final ArrayPool f1055k;

    /* renamed from: l */
    private final List<ImageHeaderParser> f1056l;

    /* renamed from: m */
    private final HardwareConfigState f1057m = HardwareConfigState.m11928a();

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0749a {
        /* renamed from: a */
        void mo11919a();

        /* renamed from: a */
        void mo11918a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;
    }

    /* renamed from: c */
    private static int m11936c(double d) {
        return (int) (d + 0.5d);
    }

    /* renamed from: a */
    public boolean m11947a(InputStream inputStream) {
        return true;
    }

    /* renamed from: a */
    public boolean m11940a(ByteBuffer byteBuffer) {
        return true;
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f1056l = list;
        this.f1054j = (DisplayMetrics) Preconditions.m11580a(displayMetrics);
        this.f1053i = (BitmapPool) Preconditions.m11580a(bitmapPool);
        this.f1055k = (ArrayPool) Preconditions.m11580a(arrayPool);
    }

    /* renamed from: a */
    public Resource<Bitmap> m11946a(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return m11945a(inputStream, i, i2, options, f1050f);
    }

    /* renamed from: a */
    public Resource<Bitmap> m11945a(InputStream inputStream, int i, int i2, Options options, InterfaceC0749a interfaceC0749a) throws IOException {
        Preconditions.m11576a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f1055k.mo12200a(65536, byte[].class);
        BitmapFactory.Options m11955a = m11955a();
        m11955a.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.m12014a(f1045a);
        try {
            return BitmapResource.m11980a(m11944a(inputStream, m11955a, (DownsampleStrategy) options.m12014a(DownsampleStrategy.f1019h), decodeFormat, decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : options.m12014a(f1048d) != null && ((Boolean) options.m12014a(f1048d)).booleanValue(), i, i2, ((Boolean) options.m12014a(f1047c)).booleanValue(), interfaceC0749a), this.f1053i);
        } finally {
            m11935c(m11955a);
            this.f1055k.mo12195a((ArrayPool) bArr);
        }
    }

    /* renamed from: a */
    private Bitmap m11944a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, InterfaceC0749a interfaceC0749a) throws IOException {
        int i3;
        int i4;
        Downsampler downsampler;
        int round;
        int round2;
        int i5;
        long m11595a = LogTime.m11595a();
        int[] m11943a = m11943a(inputStream, options, interfaceC0749a, this.f1053i);
        int i6 = m11943a[0];
        int i7 = m11943a[1];
        String str = options.outMimeType;
        boolean z3 = (i6 == -1 || i7 == -1) ? false : z;
        int m12381b = ImageHeaderParserUtils.m12381b(this.f1056l, inputStream, this.f1055k);
        int m11916a = TransformationUtils.m11916a(m12381b);
        boolean m11907b = TransformationUtils.m11907b(m12381b);
        if (i == Integer.MIN_VALUE) {
            i3 = i2;
            i4 = i6;
        } else {
            i3 = i2;
            i4 = i;
        }
        int i8 = i3 == Integer.MIN_VALUE ? i7 : i3;
        ImageHeaderParser.ImageType m12383a = ImageHeaderParserUtils.m12383a(this.f1056l, inputStream, this.f1055k);
        m11948a(m12383a, inputStream, interfaceC0749a, this.f1053i, downsampleStrategy, m11916a, i6, i7, i4, i8, options);
        m11942a(inputStream, decodeFormat, z3, m11907b, options, i4, i8);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            downsampler = this;
            if (downsampler.m11949a(m12383a)) {
                if (i6 < 0 || i7 < 0 || !z2 || !z4) {
                    float f = m11951a(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i9 = options.inSampleSize;
                    float f2 = i9;
                    round = Math.round(((int) Math.ceil(i6 / f2)) * f);
                    round2 = Math.round(((int) Math.ceil(i7 / f2)) * f);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i6 + "x" + i7 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                    }
                } else {
                    round = i4;
                    round2 = i8;
                }
                if (round > 0 && round2 > 0) {
                    m11950a(options, downsampler.f1053i, round, round2);
                }
            }
        } else {
            downsampler = this;
        }
        Bitmap m11937b = m11937b(inputStream, options, interfaceC0749a, downsampler.f1053i);
        interfaceC0749a.mo11918a(downsampler.f1053i, m11937b);
        if (Log.isLoggable("Downsampler", 2)) {
            i5 = m12381b;
            m11953a(i6, i7, str, options, m11937b, i, i2, m11595a);
        } else {
            i5 = m12381b;
        }
        Bitmap bitmap = null;
        if (m11937b != null) {
            m11937b.setDensity(downsampler.f1054j.densityDpi);
            bitmap = TransformationUtils.m11909a(downsampler.f1053i, m11937b, i5);
            if (!m11937b.equals(bitmap)) {
                downsampler.f1053i.mo11931a(m11937b);
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private static void m11948a(ImageHeaderParser.ImageType imageType, InputStream inputStream, InterfaceC0749a interfaceC0749a, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float mo11989a;
        int min;
        int i6;
        int floor;
        int floor2;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + "]");
                return;
            }
            return;
        }
        if (i == 90 || i == 270) {
            mo11989a = downsampleStrategy.mo11989a(i3, i2, i4, i5);
        } else {
            mo11989a = downsampleStrategy.mo11989a(i2, i3, i4, i5);
        }
        if (mo11989a <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + mo11989a + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        DownsampleStrategy.SampleSizeRounding mo11988b = downsampleStrategy.mo11988b(i2, i3, i4, i5);
        if (mo11988b == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i2;
        float f2 = i3;
        int m11936c = i2 / m11936c(mo11989a * f);
        int m11936c2 = i3 / m11936c(mo11989a * f2);
        if (mo11988b == DownsampleStrategy.SampleSizeRounding.MEMORY) {
            min = Math.max(m11936c, m11936c2);
        } else {
            min = Math.min(m11936c, m11936c2);
        }
        if (Build.VERSION.SDK_INT > 23 || !f1049e.contains(options.outMimeType)) {
            int max = Math.max(1, Integer.highestOneBit(min));
            i6 = (mo11988b != DownsampleStrategy.SampleSizeRounding.MEMORY || ((float) max) >= 1.0f / mo11989a) ? max : max << 1;
        } else {
            i6 = 1;
        }
        options.inSampleSize = i6;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min2 = Math.min(i6, 8);
            floor = (int) Math.ceil(f / min2);
            floor2 = (int) Math.ceil(f2 / min2);
            int i7 = i6 / 8;
            if (i7 > 0) {
                floor /= i7;
                floor2 /= i7;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f3 = i6;
            floor = (int) Math.floor(f / f3);
            floor2 = (int) Math.floor(f2 / f3);
        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
            if (Build.VERSION.SDK_INT >= 24) {
                float f4 = i6;
                floor = Math.round(f / f4);
                floor2 = Math.round(f2 / f4);
            } else {
                float f5 = i6;
                floor = (int) Math.floor(f / f5);
                floor2 = (int) Math.floor(f2 / f5);
            }
        } else if (i2 % i6 != 0 || i3 % i6 != 0) {
            int[] m11943a = m11943a(inputStream, options, interfaceC0749a, bitmapPool);
            floor = m11943a[0];
            floor2 = m11943a[1];
        } else {
            floor = i2 / i6;
            floor2 = i3 / i6;
        }
        double mo11989a2 = downsampleStrategy.mo11989a(floor, floor2, i4, i5);
        if (Build.VERSION.SDK_INT >= 19) {
            options.inTargetDensity = m11954a(mo11989a2);
            options.inDensity = m11939b(mo11989a2);
        }
        if (m11951a(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + floor2 + "], exact scale factor: " + mo11989a + ", power of 2 sample size: " + i6 + ", adjusted scale factor: " + mo11989a2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    /* renamed from: a */
    private static int m11954a(double d) {
        int m11939b = m11939b(d);
        int m11936c = m11936c(m11939b * d);
        return m11936c((d / (m11936c / m11939b)) * m11936c);
    }

    /* renamed from: b */
    private static int m11939b(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    /* renamed from: a */
    private boolean m11949a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f1051g.contains(imageType);
    }

    /* renamed from: a */
    private void m11942a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.f1057m.m11927a(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || Build.VERSION.SDK_INT == 16) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean z3 = false;
        try {
            z3 = ImageHeaderParserUtils.m12383a(this.f1056l, inputStream, this.f1055k).hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
        }
        options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    /* renamed from: a */
    private static int[] m11943a(InputStream inputStream, BitmapFactory.Options options, InterfaceC0749a interfaceC0749a, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        m11937b(inputStream, options, interfaceC0749a, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: b */
    private static Bitmap m11937b(InputStream inputStream, BitmapFactory.Options options, InterfaceC0749a interfaceC0749a, BitmapPool bitmapPool) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            interfaceC0749a.mo11919a();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.m11917a().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                TransformationUtils.m11917a().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e) {
                IOException m11941a = m11941a(e, i, i2, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", m11941a);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        bitmapPool.mo11931a(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap m11937b = m11937b(inputStream, options, interfaceC0749a, bitmapPool);
                        TransformationUtils.m11917a().unlock();
                        return m11937b;
                    } catch (IOException unused) {
                        throw m11941a;
                    }
                }
                throw m11941a;
            }
        } catch (Throwable th) {
            TransformationUtils.m11917a().unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static boolean m11951a(BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    /* renamed from: a */
    private static void m11953a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("Downsampler", "Decoded " + m11952a(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + m11938b(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.m11594a(j));
    }

    /* renamed from: b */
    private static String m11938b(BitmapFactory.Options options) {
        return m11952a(options.inBitmap);
    }

    @TargetApi(19)
    @Nullable
    /* renamed from: a */
    private static String m11952a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    /* renamed from: a */
    private static IOException m11941a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + m11938b(options), illegalArgumentException);
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m11950a(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.mo12177b(i, i2, config);
    }

    /* renamed from: a */
    private static synchronized BitmapFactory.Options m11955a() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            synchronized (f1052h) {
                poll = f1052h.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                m11934d(poll);
            }
        }
        return poll;
    }

    /* renamed from: c */
    private static void m11935c(BitmapFactory.Options options) {
        m11934d(options);
        synchronized (f1052h) {
            f1052h.offer(options);
        }
    }

    /* renamed from: d */
    private static void m11934d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
