package com.navatics.robot.math;

/* renamed from: com.navatics.robot.math.a */
/* loaded from: classes.dex */
public abstract class Interpolation {

    /* renamed from: a */
    public static final Interpolation f6145a = new Interpolation() { // from class: com.navatics.robot.math.a.1
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return f;
        }
    };

    /* renamed from: b */
    public static final Interpolation f6146b = new Interpolation() { // from class: com.navatics.robot.math.a.7
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return f * f * (3.0f - (f * 2.0f));
        }
    };

    /* renamed from: c */
    public static final Interpolation f6147c = new Interpolation() { // from class: com.navatics.robot.math.a.8
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            float f2 = f * f * (3.0f - (f * 2.0f));
            return f2 * f2 * (3.0f - (f2 * 2.0f));
        }
    };

    /* renamed from: d */
    public static final Interpolation f6148d = new Interpolation() { // from class: com.navatics.robot.math.a.9
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return f * f * f * ((f * ((6.0f * f) - 15.0f)) + 10.0f);
        }
    };

    /* renamed from: e */
    public static final Interpolation f6149e = f6148d;

    /* renamed from: f */
    public static final C2084j f6150f = new C2084j(2);

    /* renamed from: g */
    public static final C2085k f6151g = new C2085k(2);

    /* renamed from: h */
    public static final C2086l f6152h = new C2086l(2);

    /* renamed from: i */
    public static final Interpolation f6153i = new Interpolation() { // from class: com.navatics.robot.math.a.10
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return (float) Math.sqrt(f);
        }
    };

    /* renamed from: j */
    public static final Interpolation f6154j = new Interpolation() { // from class: com.navatics.robot.math.a.11
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return 1.0f - ((float) Math.sqrt(-(f - 1.0f)));
        }
    };

    /* renamed from: k */
    public static final C2084j f6155k = new C2084j(3);

    /* renamed from: l */
    public static final C2085k f6156l = new C2085k(3);

    /* renamed from: m */
    public static final C2086l f6157m = new C2086l(3);

    /* renamed from: n */
    public static final Interpolation f6158n = new Interpolation() { // from class: com.navatics.robot.math.a.12
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return (float) Math.cbrt(f);
        }
    };

    /* renamed from: o */
    public static final Interpolation f6159o = new Interpolation() { // from class: com.navatics.robot.math.a.13
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return 1.0f - ((float) Math.cbrt(-(f - 1.0f)));
        }
    };

    /* renamed from: p */
    public static final C2084j f6160p = new C2084j(4);

    /* renamed from: q */
    public static final C2085k f6161q = new C2085k(4);

    /* renamed from: r */
    public static final C2086l f6162r = new C2086l(4);

    /* renamed from: s */
    public static final C2084j f6163s = new C2084j(5);

    /* renamed from: t */
    public static final C2085k f6164t = new C2085k(5);

    /* renamed from: u */
    public static final C2086l f6165u = new C2086l(5);

    /* renamed from: v */
    public static final Interpolation f6166v = new Interpolation() { // from class: com.navatics.robot.math.a.14
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return (1.0f - C2090b.m6576b(f * 3.1415927f)) / 2.0f;
        }
    };

    /* renamed from: w */
    public static final Interpolation f6167w = new Interpolation() { // from class: com.navatics.robot.math.a.2
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return 1.0f - C2090b.m6576b((f * 3.1415927f) / 2.0f);
        }
    };

    /* renamed from: x */
    public static final Interpolation f6168x = new Interpolation() { // from class: com.navatics.robot.math.a.3
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return C2090b.m6579a((f * 3.1415927f) / 2.0f);
        }
    };

    /* renamed from: y */
    public static final C2081g f6169y = new C2081g(2.0f, 10.0f);

    /* renamed from: z */
    public static final C2082h f6170z = new C2082h(2.0f, 10.0f);

    /* renamed from: A */
    public static final C2083i f6129A = new C2083i(2.0f, 10.0f);

    /* renamed from: B */
    public static final C2081g f6130B = new C2081g(2.0f, 5.0f);

    /* renamed from: C */
    public static final C2082h f6131C = new C2082h(2.0f, 5.0f);

    /* renamed from: D */
    public static final C2083i f6132D = new C2083i(2.0f, 5.0f);

    /* renamed from: E */
    public static final Interpolation f6133E = new Interpolation() { // from class: com.navatics.robot.math.a.4
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                return (1.0f - ((float) Math.sqrt(1.0f - (f2 * f2)))) / 2.0f;
            }
            float f3 = (f - 1.0f) * 2.0f;
            return (((float) Math.sqrt(1.0f - (f3 * f3))) + 1.0f) / 2.0f;
        }
    };

    /* renamed from: F */
    public static final Interpolation f6134F = new Interpolation() { // from class: com.navatics.robot.math.a.5
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return 1.0f - ((float) Math.sqrt(1.0f - (f * f)));
        }
    };

    /* renamed from: G */
    public static final Interpolation f6135G = new Interpolation() { // from class: com.navatics.robot.math.a.6
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            float f2 = f - 1.0f;
            return (float) Math.sqrt(1.0f - (f2 * f2));
        }
    };

    /* renamed from: H */
    public static final C2078d f6136H = new C2078d(2.0f, 10.0f, 7, 1.0f);

    /* renamed from: I */
    public static final C2079e f6137I = new C2079e(2.0f, 10.0f, 6, 1.0f);

    /* renamed from: J */
    public static final C2080f f6138J = new C2080f(2.0f, 10.0f, 7, 1.0f);

    /* renamed from: K */
    public static final C2087m f6139K = new C2087m(1.5f);

    /* renamed from: L */
    public static final C2088n f6140L = new C2088n(2.0f);

    /* renamed from: M */
    public static final C2089o f6141M = new C2089o(2.0f);

    /* renamed from: N */
    public static final C2075a f6142N = new C2075a(4);

    /* renamed from: O */
    public static final C2076b f6143O = new C2076b(4);

    /* renamed from: P */
    public static final C2077c f6144P = new C2077c(4);

    /* renamed from: a */
    public abstract float mo6581a(float f);

    /* renamed from: a */
    public float m6583a(float f, float f2, float f3) {
        return f + ((f2 - f) * mo6581a(f3));
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$j */
    /* loaded from: classes.dex */
    public static class C2084j extends Interpolation {

        /* renamed from: Q */
        final int f6181Q;

        public C2084j(int i) {
            this.f6181Q = i;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f <= 0.5f) {
                return ((float) Math.pow(f * 2.0f, this.f6181Q)) / 2.0f;
            }
            return (((float) Math.pow((f - 1.0f) * 2.0f, this.f6181Q)) / (this.f6181Q % 2 == 0 ? -2 : 2)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$k */
    /* loaded from: classes.dex */
    public static class C2085k extends C2084j {
        public C2085k(int i) {
            super(i);
        }

        @Override // com.navatics.robot.math.Interpolation.C2084j, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return (float) Math.pow(f, this.f6181Q);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$l */
    /* loaded from: classes.dex */
    public static class C2086l extends C2084j {
        public C2086l(int i) {
            super(i);
        }

        @Override // com.navatics.robot.math.Interpolation.C2084j, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return (((float) Math.pow(f - 1.0f, this.f6181Q)) * (this.f6181Q % 2 == 0 ? -1 : 1)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$g */
    /* loaded from: classes.dex */
    public static class C2081g extends Interpolation {

        /* renamed from: Q */
        final float f6177Q;

        /* renamed from: R */
        final float f6178R;

        /* renamed from: S */
        final float f6179S;

        /* renamed from: T */
        final float f6180T;

        public C2081g(float f, float f2) {
            this.f6177Q = f;
            this.f6178R = f2;
            this.f6179S = (float) Math.pow(f, -f2);
            this.f6180T = 1.0f / (1.0f - this.f6179S);
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f <= 0.5f) {
                return ((((float) Math.pow(this.f6177Q, this.f6178R * ((f * 2.0f) - 1.0f))) - this.f6179S) * this.f6180T) / 2.0f;
            }
            return (2.0f - ((((float) Math.pow(this.f6177Q, (-this.f6178R) * ((f * 2.0f) - 1.0f))) - this.f6179S) * this.f6180T)) / 2.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$h */
    /* loaded from: classes.dex */
    public static class C2082h extends C2081g {
        public C2082h(float f, float f2) {
            super(f, f2);
        }

        @Override // com.navatics.robot.math.Interpolation.C2081g, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return (((float) Math.pow(this.f6177Q, this.f6178R * (f - 1.0f))) - this.f6179S) * this.f6180T;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$i */
    /* loaded from: classes.dex */
    public static class C2083i extends C2081g {
        public C2083i(float f, float f2) {
            super(f, f2);
        }

        @Override // com.navatics.robot.math.Interpolation.C2081g, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return 1.0f - ((((float) Math.pow(this.f6177Q, (-this.f6178R) * f)) - this.f6179S) * this.f6180T);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$d */
    /* loaded from: classes.dex */
    public static class C2078d extends Interpolation {

        /* renamed from: Q */
        final float f6173Q;

        /* renamed from: R */
        final float f6174R;

        /* renamed from: S */
        final float f6175S;

        /* renamed from: T */
        final float f6176T;

        public C2078d(float f, float f2, int i, float f3) {
            this.f6173Q = f;
            this.f6174R = f2;
            this.f6175S = f3;
            this.f6176T = i * 3.1415927f * (i % 2 == 0 ? 1 : -1);
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                return ((((float) Math.pow(this.f6173Q, this.f6174R * (f2 - 1.0f))) * C2090b.m6579a(f2 * this.f6176T)) * this.f6175S) / 2.0f;
            }
            float f3 = (1.0f - f) * 2.0f;
            return 1.0f - (((((float) Math.pow(this.f6173Q, this.f6174R * (f3 - 1.0f))) * C2090b.m6579a(f3 * this.f6176T)) * this.f6175S) / 2.0f);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$e */
    /* loaded from: classes.dex */
    public static class C2079e extends C2078d {
        public C2079e(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.navatics.robot.math.Interpolation.C2078d, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f >= 0.99d) {
                return 1.0f;
            }
            return ((float) Math.pow(this.f6173Q, this.f6174R * (f - 1.0f))) * C2090b.m6579a(f * this.f6176T) * this.f6175S;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$f */
    /* loaded from: classes.dex */
    public static class C2080f extends C2078d {
        public C2080f(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.navatics.robot.math.Interpolation.C2078d, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            float f2 = 1.0f - f;
            return 1.0f - ((((float) Math.pow(this.f6173Q, this.f6174R * (f2 - 1.0f))) * C2090b.m6579a(f2 * this.f6176T)) * this.f6175S);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$a */
    /* loaded from: classes.dex */
    public static class C2075a extends C2077c {
        public C2075a(int i) {
            super(i);
        }

        /* renamed from: b */
        private float m6582b(float f) {
            float f2 = (this.f6171Q[0] / 2.0f) + f;
            return f2 < this.f6171Q[0] ? (f2 / (this.f6171Q[0] / 2.0f)) - 1.0f : super.mo6581a(f);
        }

        @Override // com.navatics.robot.math.Interpolation.C2077c, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f <= 0.5f) {
                return (1.0f - m6582b(1.0f - (f * 2.0f))) / 2.0f;
            }
            return (m6582b((f * 2.0f) - 1.0f) / 2.0f) + 0.5f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$c */
    /* loaded from: classes.dex */
    public static class C2077c extends Interpolation {

        /* renamed from: Q */
        final float[] f6171Q;

        /* renamed from: R */
        final float[] f6172R;

        public C2077c(int i) {
            if (i < 2 || i > 5) {
                throw new IllegalArgumentException("bounces cannot be < 2 or > 5: " + i);
            }
            this.f6171Q = new float[i];
            this.f6172R = new float[i];
            float[] fArr = this.f6172R;
            fArr[0] = 1.0f;
            switch (i) {
                case 2:
                    float[] fArr2 = this.f6171Q;
                    fArr2[0] = 0.6f;
                    fArr2[1] = 0.4f;
                    fArr[1] = 0.33f;
                    break;
                case 3:
                    float[] fArr3 = this.f6171Q;
                    fArr3[0] = 0.4f;
                    fArr3[1] = 0.4f;
                    fArr3[2] = 0.2f;
                    fArr[1] = 0.33f;
                    fArr[2] = 0.1f;
                    break;
                case 4:
                    float[] fArr4 = this.f6171Q;
                    fArr4[0] = 0.34f;
                    fArr4[1] = 0.34f;
                    fArr4[2] = 0.2f;
                    fArr4[3] = 0.15f;
                    fArr[1] = 0.26f;
                    fArr[2] = 0.11f;
                    fArr[3] = 0.03f;
                    break;
                case 5:
                    float[] fArr5 = this.f6171Q;
                    fArr5[0] = 0.3f;
                    fArr5[1] = 0.3f;
                    fArr5[2] = 0.2f;
                    fArr5[3] = 0.1f;
                    fArr5[4] = 0.1f;
                    fArr[1] = 0.45f;
                    fArr[2] = 0.3f;
                    fArr[3] = 0.15f;
                    fArr[4] = 0.06f;
                    break;
            }
            float[] fArr6 = this.f6171Q;
            fArr6[0] = fArr6[0] * 2.0f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.f6171Q;
            int i = 0;
            float f2 = f + (fArr[0] / 2.0f);
            int length = fArr.length;
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (true) {
                if (i >= length) {
                    break;
                }
                f4 = this.f6171Q[i];
                if (f2 <= f4) {
                    f3 = this.f6172R[i];
                    break;
                }
                f2 -= f4;
                i++;
            }
            float f5 = f2 / f4;
            float f6 = (4.0f / f4) * f3 * f5;
            return 1.0f - ((f6 - (f5 * f6)) * f4);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$b */
    /* loaded from: classes.dex */
    public static class C2076b extends C2077c {
        public C2076b(int i) {
            super(i);
        }

        @Override // com.navatics.robot.math.Interpolation.C2077c, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            return 1.0f - super.mo6581a(1.0f - f);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$m */
    /* loaded from: classes.dex */
    public static class C2087m extends Interpolation {

        /* renamed from: Q */
        private final float f6182Q;

        public C2087m(float f) {
            this.f6182Q = f * 2.0f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                float f3 = this.f6182Q;
                return ((f2 * f2) * (((1.0f + f3) * f2) - f3)) / 2.0f;
            }
            float f4 = (f - 1.0f) * 2.0f;
            float f5 = this.f6182Q;
            return (((f4 * f4) * (((f5 + 1.0f) * f4) + f5)) / 2.0f) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$o */
    /* loaded from: classes.dex */
    public static class C2089o extends Interpolation {

        /* renamed from: Q */
        private final float f6184Q;

        public C2089o(float f) {
            this.f6184Q = f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            float f2 = f - 1.0f;
            float f3 = this.f6184Q;
            return (f2 * f2 * (((f3 + 1.0f) * f2) + f3)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$n */
    /* loaded from: classes.dex */
    public static class C2088n extends Interpolation {

        /* renamed from: Q */
        private final float f6183Q;

        public C2088n(float f) {
            this.f6183Q = f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6581a(float f) {
            float f2 = this.f6183Q;
            return f * f * (((1.0f + f2) * f) - f2);
        }
    }
}
