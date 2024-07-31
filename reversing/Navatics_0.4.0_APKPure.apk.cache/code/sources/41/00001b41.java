package com.navatics.robot.math;

/* compiled from: Interpolation.java */
/* renamed from: com.navatics.robot.math.a */
/* loaded from: classes.dex */
public abstract class Interpolation {

    /* renamed from: a */
    public static final Interpolation f6172a = new Interpolation() { // from class: com.navatics.robot.math.a.1
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return f2;
        }
    };

    /* renamed from: b */
    public static final Interpolation f6173b = new Interpolation() { // from class: com.navatics.robot.math.a.7
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return f2 * f2 * (3.0f - (f2 * 2.0f));
        }
    };

    /* renamed from: c */
    public static final Interpolation f6174c = new Interpolation() { // from class: com.navatics.robot.math.a.8
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            float f3 = f2 * f2 * (3.0f - (f2 * 2.0f));
            return f3 * f3 * (3.0f - (f3 * 2.0f));
        }
    };

    /* renamed from: d */
    public static final Interpolation f6175d = new Interpolation() { // from class: com.navatics.robot.math.a.9
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return f2 * f2 * f2 * ((f2 * ((6.0f * f2) - 15.0f)) + 10.0f);
        }
    };

    /* renamed from: e */
    public static final Interpolation f6176e = f6175d;

    /* renamed from: f */
    public static final j f6177f = new j(2);

    /* renamed from: g */
    public static final k f6178g = new k(2);

    /* renamed from: h */
    public static final l f6179h = new l(2);

    /* renamed from: i */
    public static final Interpolation f6180i = new Interpolation() { // from class: com.navatics.robot.math.a.10
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return (float) Math.sqrt(f2);
        }
    };

    /* renamed from: j */
    public static final Interpolation f6181j = new Interpolation() { // from class: com.navatics.robot.math.a.11
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return 1.0f - ((float) Math.sqrt(-(f2 - 1.0f)));
        }
    };

    /* renamed from: k */
    public static final j f6182k = new j(3);

    /* renamed from: l */
    public static final k f6183l = new k(3);

    /* renamed from: m */
    public static final l f6184m = new l(3);

    /* renamed from: n */
    public static final Interpolation f6185n = new Interpolation() { // from class: com.navatics.robot.math.a.12
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return (float) Math.cbrt(f2);
        }
    };

    /* renamed from: o */
    public static final Interpolation f6186o = new Interpolation() { // from class: com.navatics.robot.math.a.13
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return 1.0f - ((float) Math.cbrt(-(f2 - 1.0f)));
        }
    };

    /* renamed from: p */
    public static final j f6187p = new j(4);

    /* renamed from: q */
    public static final k f6188q = new k(4);

    /* renamed from: r */
    public static final l f6189r = new l(4);

    /* renamed from: s */
    public static final j f6190s = new j(5);

    /* renamed from: t */
    public static final k f6191t = new k(5);

    /* renamed from: u */
    public static final l f6192u = new l(5);

    /* renamed from: v */
    public static final Interpolation f6193v = new Interpolation() { // from class: com.navatics.robot.math.a.14
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return (1.0f - MathUtils.m6283b(f2 * 3.1415927f)) / 2.0f;
        }
    };

    /* renamed from: w */
    public static final Interpolation f6194w = new Interpolation() { // from class: com.navatics.robot.math.a.2
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return 1.0f - MathUtils.m6283b((f2 * 3.1415927f) / 2.0f);
        }
    };

    /* renamed from: x */
    public static final Interpolation f6195x = new Interpolation() { // from class: com.navatics.robot.math.a.3
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return MathUtils.m6280a((f2 * 3.1415927f) / 2.0f);
        }
    };

    /* renamed from: y */
    public static final g f6196y = new g(2.0f, 10.0f);

    /* renamed from: z */
    public static final h f6197z = new h(2.0f, 10.0f);

    /* renamed from: A */
    public static final i f6156A = new i(2.0f, 10.0f);

    /* renamed from: B */
    public static final g f6157B = new g(2.0f, 5.0f);

    /* renamed from: C */
    public static final h f6158C = new h(2.0f, 5.0f);

    /* renamed from: D */
    public static final i f6159D = new i(2.0f, 5.0f);

    /* renamed from: E */
    public static final Interpolation f6160E = new Interpolation() { // from class: com.navatics.robot.math.a.4
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            if (f2 <= 0.5f) {
                float f3 = f2 * 2.0f;
                return (1.0f - ((float) Math.sqrt(1.0f - (f3 * f3)))) / 2.0f;
            }
            float f4 = (f2 - 1.0f) * 2.0f;
            return (((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f) / 2.0f;
        }
    };

    /* renamed from: F */
    public static final Interpolation f6161F = new Interpolation() { // from class: com.navatics.robot.math.a.5
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            return 1.0f - ((float) Math.sqrt(1.0f - (f2 * f2)));
        }
    };

    /* renamed from: G */
    public static final Interpolation f6162G = new Interpolation() { // from class: com.navatics.robot.math.a.6
        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f2) {
            float f3 = f2 - 1.0f;
            return (float) Math.sqrt(1.0f - (f3 * f3));
        }
    };

    /* renamed from: H */
    public static final d f6163H = new d(2.0f, 10.0f, 7, 1.0f);

    /* renamed from: I */
    public static final e f6164I = new e(2.0f, 10.0f, 6, 1.0f);

    /* renamed from: J */
    public static final f f6165J = new f(2.0f, 10.0f, 7, 1.0f);

    /* renamed from: K */
    public static final m f6166K = new m(1.5f);

    /* renamed from: L */
    public static final n f6167L = new n(2.0f);

    /* renamed from: M */
    public static final o f6168M = new o(2.0f);

    /* renamed from: N */
    public static final a f6169N = new a(4);

    /* renamed from: O */
    public static final b f6170O = new b(4);

    /* renamed from: P */
    public static final c f6171P = new c(4);

    /* renamed from: a */
    public abstract float mo6276a(float f2);

    /* renamed from: a */
    public float m6277a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * mo6276a(f4));
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$j */
    /* loaded from: classes.dex */
    public static class j extends Interpolation {

        /* renamed from: Q */
        final int f6208Q;

        public j(int i) {
            this.f6208Q = i;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f <= 0.5f) {
                return ((float) Math.pow(f * 2.0f, this.f6208Q)) / 2.0f;
            }
            return (((float) Math.pow((f - 1.0f) * 2.0f, this.f6208Q)) / (this.f6208Q % 2 == 0 ? -2 : 2)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$k */
    /* loaded from: classes.dex */
    public static class k extends j {
        public k(int i) {
            super(i);
        }

        @Override // com.navatics.robot.math.Interpolation.j, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            return (float) Math.pow(f, this.f6208Q);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$l */
    /* loaded from: classes.dex */
    public static class l extends j {
        public l(int i) {
            super(i);
        }

        @Override // com.navatics.robot.math.Interpolation.j, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            return (((float) Math.pow(f - 1.0f, this.f6208Q)) * (this.f6208Q % 2 == 0 ? -1 : 1)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$g */
    /* loaded from: classes.dex */
    public static class g extends Interpolation {

        /* renamed from: Q */
        final float f6204Q;

        /* renamed from: R */
        final float f6205R;

        /* renamed from: S */
        final float f6206S;

        /* renamed from: T */
        final float f6207T;

        public g(float f, float f2) {
            this.f6204Q = f;
            this.f6205R = f2;
            this.f6206S = (float) Math.pow(f, -f2);
            this.f6207T = 1.0f / (1.0f - this.f6206S);
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f <= 0.5f) {
                return ((((float) Math.pow(this.f6204Q, this.f6205R * ((f * 2.0f) - 1.0f))) - this.f6206S) * this.f6207T) / 2.0f;
            }
            return (2.0f - ((((float) Math.pow(this.f6204Q, (-this.f6205R) * ((f * 2.0f) - 1.0f))) - this.f6206S) * this.f6207T)) / 2.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$h */
    /* loaded from: classes.dex */
    public static class h extends g {
        public h(float f, float f2) {
            super(f, f2);
        }

        @Override // com.navatics.robot.math.Interpolation.g, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            return (((float) Math.pow(this.f6204Q, this.f6205R * (f - 1.0f))) - this.f6206S) * this.f6207T;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$i */
    /* loaded from: classes.dex */
    public static class i extends g {
        public i(float f, float f2) {
            super(f, f2);
        }

        @Override // com.navatics.robot.math.Interpolation.g, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            return 1.0f - ((((float) Math.pow(this.f6204Q, (-this.f6205R) * f)) - this.f6206S) * this.f6207T);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$d */
    /* loaded from: classes.dex */
    public static class d extends Interpolation {

        /* renamed from: Q */
        final float f6200Q;

        /* renamed from: R */
        final float f6201R;

        /* renamed from: S */
        final float f6202S;

        /* renamed from: T */
        final float f6203T;

        public d(float f, float f2, int i, float f3) {
            this.f6200Q = f;
            this.f6201R = f2;
            this.f6202S = f3;
            this.f6203T = i * 3.1415927f * (i % 2 == 0 ? 1 : -1);
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f <= 0.5f) {
                return ((((float) Math.pow(this.f6200Q, this.f6201R * (r7 - 1.0f))) * MathUtils.m6280a((f * 2.0f) * this.f6203T)) * this.f6202S) / 2.0f;
            }
            return 1.0f - (((((float) Math.pow(this.f6200Q, this.f6201R * (r7 - 1.0f))) * MathUtils.m6280a(((1.0f - f) * 2.0f) * this.f6203T)) * this.f6202S) / 2.0f);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$e */
    /* loaded from: classes.dex */
    public static class e extends d {
        public e(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.navatics.robot.math.Interpolation.d, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f >= 0.99d) {
                return 1.0f;
            }
            return ((float) Math.pow(this.f6200Q, this.f6201R * (f - 1.0f))) * MathUtils.m6280a(f * this.f6203T) * this.f6202S;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$f */
    /* loaded from: classes.dex */
    public static class f extends d {
        public f(float f, float f2, int i, float f3) {
            super(f, f2, i, f3);
        }

        @Override // com.navatics.robot.math.Interpolation.d, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return 1.0f - ((((float) Math.pow(this.f6200Q, this.f6201R * (r6 - 1.0f))) * MathUtils.m6280a((1.0f - f) * this.f6203T)) * this.f6202S);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$a */
    /* loaded from: classes.dex */
    public static class a extends c {
        public a(int i) {
            super(i);
        }

        /* renamed from: b */
        private float m6278b(float f) {
            float f2 = (this.f6198Q[0] / 2.0f) + f;
            return f2 < this.f6198Q[0] ? (f2 / (this.f6198Q[0] / 2.0f)) - 1.0f : super.mo6276a(f);
        }

        @Override // com.navatics.robot.math.Interpolation.c, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f <= 0.5f) {
                return (1.0f - m6278b(1.0f - (f * 2.0f))) / 2.0f;
            }
            return (m6278b((f * 2.0f) - 1.0f) / 2.0f) + 0.5f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$c */
    /* loaded from: classes.dex */
    public static class c extends Interpolation {

        /* renamed from: Q */
        final float[] f6198Q;

        /* renamed from: R */
        final float[] f6199R;

        public c(int i) {
            if (i < 2 || i > 5) {
                throw new IllegalArgumentException("bounces cannot be < 2 or > 5: " + i);
            }
            this.f6198Q = new float[i];
            this.f6199R = new float[i];
            float[] fArr = this.f6199R;
            fArr[0] = 1.0f;
            switch (i) {
                case 2:
                    float[] fArr2 = this.f6198Q;
                    fArr2[0] = 0.6f;
                    fArr2[1] = 0.4f;
                    fArr[1] = 0.33f;
                    break;
                case 3:
                    float[] fArr3 = this.f6198Q;
                    fArr3[0] = 0.4f;
                    fArr3[1] = 0.4f;
                    fArr3[2] = 0.2f;
                    fArr[1] = 0.33f;
                    fArr[2] = 0.1f;
                    break;
                case 4:
                    float[] fArr4 = this.f6198Q;
                    fArr4[0] = 0.34f;
                    fArr4[1] = 0.34f;
                    fArr4[2] = 0.2f;
                    fArr4[3] = 0.15f;
                    fArr[1] = 0.26f;
                    fArr[2] = 0.11f;
                    fArr[3] = 0.03f;
                    break;
                case 5:
                    float[] fArr5 = this.f6198Q;
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
            float[] fArr6 = this.f6198Q;
            fArr6[0] = fArr6[0] * 2.0f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.f6198Q;
            int i = 0;
            float f2 = f + (fArr[0] / 2.0f);
            int length = fArr.length;
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (true) {
                if (i >= length) {
                    break;
                }
                f4 = this.f6198Q[i];
                if (f2 <= f4) {
                    f3 = this.f6199R[i];
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
    public static class b extends c {
        public b(int i) {
            super(i);
        }

        @Override // com.navatics.robot.math.Interpolation.c, com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            return 1.0f - super.mo6276a(1.0f - f);
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$m */
    /* loaded from: classes.dex */
    public static class m extends Interpolation {

        /* renamed from: Q */
        private final float f6209Q;

        public m(float f) {
            this.f6209Q = f * 2.0f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            if (f <= 0.5f) {
                float f2 = f * 2.0f;
                float f3 = this.f6209Q;
                return ((f2 * f2) * (((1.0f + f3) * f2) - f3)) / 2.0f;
            }
            float f4 = (f - 1.0f) * 2.0f;
            float f5 = this.f6209Q;
            return (((f4 * f4) * (((f5 + 1.0f) * f4) + f5)) / 2.0f) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$o */
    /* loaded from: classes.dex */
    public static class o extends Interpolation {

        /* renamed from: Q */
        private final float f6211Q;

        public o(float f) {
            this.f6211Q = f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            float f2 = f - 1.0f;
            float f3 = this.f6211Q;
            return (f2 * f2 * (((f3 + 1.0f) * f2) + f3)) + 1.0f;
        }
    }

    /* compiled from: Interpolation.java */
    /* renamed from: com.navatics.robot.math.a$n */
    /* loaded from: classes.dex */
    public static class n extends Interpolation {

        /* renamed from: Q */
        private final float f6210Q;

        public n(float f) {
            this.f6210Q = f;
        }

        @Override // com.navatics.robot.math.Interpolation
        /* renamed from: a */
        public float mo6276a(float f) {
            float f2 = this.f6210Q;
            return f * f * (((1.0f + f2) * f) - f2);
        }
    }
}