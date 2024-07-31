package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a */
    public static final DownsampleStrategy f1012a = new C0742e();

    /* renamed from: b */
    public static final DownsampleStrategy f1013b = new C0741d();

    /* renamed from: c */
    public static final DownsampleStrategy f1014c = new C0738a();

    /* renamed from: d */
    public static final DownsampleStrategy f1015d = new C0739b();

    /* renamed from: e */
    public static final DownsampleStrategy f1016e = new C0740c();

    /* renamed from: f */
    public static final DownsampleStrategy f1017f = new C0743f();

    /* renamed from: g */
    public static final DownsampleStrategy f1018g = f1013b;

    /* renamed from: h */
    public static final Option<DownsampleStrategy> f1019h = Option.m12279a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f1018g);

    /* loaded from: classes.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* renamed from: a */
    public abstract float mo11989a(int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract SampleSizeRounding mo11988b(int i, int i2, int i3, int i4);

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$e */
    /* loaded from: classes.dex */
    private static class C0742e extends DownsampleStrategy {
        C0742e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public float mo11989a(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public SampleSizeRounding mo11988b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$d */
    /* loaded from: classes.dex */
    private static class C0741d extends DownsampleStrategy {
        C0741d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public float mo11989a(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public SampleSizeRounding mo11988b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$a */
    /* loaded from: classes.dex */
    private static class C0738a extends DownsampleStrategy {
        C0738a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public float mo11989a(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public SampleSizeRounding mo11988b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$b */
    /* loaded from: classes.dex */
    private static class C0739b extends DownsampleStrategy {
        C0739b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public float mo11989a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public SampleSizeRounding mo11988b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$f */
    /* loaded from: classes.dex */
    private static class C0743f extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public float mo11989a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        C0743f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public SampleSizeRounding mo11988b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$c */
    /* loaded from: classes.dex */
    private static class C0740c extends DownsampleStrategy {
        C0740c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public float mo11989a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, f1012a.mo11989a(i, i2, i3, i4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public SampleSizeRounding mo11988b(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }
}
