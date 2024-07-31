package com.navatics.app.framework;

import com.navatics.app.framework.p055g.MiddleFloatValueFilter;
import com.navatics.app.framework.p055g.MiddleIntValueFilter;
import com.navatics.app.framework.p055g.ValueFilter;
import com.navatics.robot.math.Quaternion;
import com.navatics.robot.math.Vector3;

/* renamed from: com.navatics.app.framework.ad */
/* loaded from: classes.dex */
public class RobotStatus {

    /* renamed from: A */
    private float f4200A;

    /* renamed from: B */
    private float f4201B;

    /* renamed from: C */
    private float f4202C;

    /* renamed from: D */
    private float f4203D;

    /* renamed from: a */
    public int f4213a;

    /* renamed from: b */
    private boolean f4214b;

    /* renamed from: c */
    private long f4215c;

    /* renamed from: d */
    private short f4216d;

    /* renamed from: e */
    private short f4217e;

    /* renamed from: f */
    private short f4218f;

    /* renamed from: g */
    private short f4219g;

    /* renamed from: h */
    private short f4220h;

    /* renamed from: i */
    private short f4221i;

    /* renamed from: j */
    private short f4222j;

    /* renamed from: k */
    private short f4223k;

    /* renamed from: l */
    private int f4224l;

    /* renamed from: m */
    private int f4225m;

    /* renamed from: n */
    private short f4226n;

    /* renamed from: o */
    private short f4227o;

    /* renamed from: p */
    private short f4228p;

    /* renamed from: q */
    private short f4229q;

    /* renamed from: r */
    private int f4230r;

    /* renamed from: s */
    private int f4231s;

    /* renamed from: t */
    private int f4232t;

    /* renamed from: u */
    private int f4233u;

    /* renamed from: v */
    private MotorStatus f4234v = new MotorStatus();

    /* renamed from: w */
    private SensorStatus f4235w = new SensorStatus();

    /* renamed from: x */
    private Quaternion f4236x = new Quaternion();

    /* renamed from: y */
    private Quaternion f4237y = new Quaternion();

    /* renamed from: z */
    private float[] f4238z = new float[16];

    /* renamed from: E */
    private boolean f4204E = false;

    /* renamed from: F */
    private boolean f4205F = false;

    /* renamed from: G */
    private MiddleIntValueFilter f4206G = new MiddleIntValueFilter();

    /* renamed from: H */
    private ValueFilter<Float> f4207H = new MiddleFloatValueFilter(5);

    /* renamed from: I */
    private ValueFilter<Float> f4208I = new MiddleFloatValueFilter(5);

    /* renamed from: J */
    private ValueFilter<Float> f4209J = new MiddleFloatValueFilter(5);

    /* renamed from: K */
    private ValueFilter<Float> f4210K = new MiddleFloatValueFilter(5);

    /* renamed from: L */
    private ValueFilter<Integer> f4211L = new MiddleIntValueFilter();

    /* renamed from: M */
    private ValueFilter<Integer> f4212M = new MiddleIntValueFilter();

    /* renamed from: a */
    public static float m8668a(int i) {
        return ((i * 1.0f) / 65535.0f) * 100.0f;
    }

    /* renamed from: a */
    public boolean m8669a() {
        return this.f4214b;
    }

    /* renamed from: a */
    public void m8663a(boolean z) {
        this.f4214b = z;
    }

    /* renamed from: a */
    public void m8666a(long j) {
        this.f4215c = j;
    }

    /* renamed from: b */
    public short m8661b() {
        return this.f4216d;
    }

    /* renamed from: c */
    public short m8658c() {
        return this.f4217e;
    }

    /* renamed from: d */
    public short m8655d() {
        return this.f4218f;
    }

    /* renamed from: e */
    public short m8653e() {
        return this.f4219g;
    }

    /* renamed from: a */
    public void m8664a(short s, short s2, short s3, short s4) {
        this.f4216d = s;
        this.f4217e = s2;
        this.f4218f = s3;
        this.f4219g = s4;
        Quaternion quaternion = this.f4236x;
        quaternion.set((s2 * 1.0f) / 32767.0f, (s3 * 1.0f) / 32767.0f, (s4 * 1.0f) / 32767.0f, (s * 1.0f) / 32767.0f);
        this.f4236x.nor();
        m8665a(this.f4236x, this.f4207H, this.f4208I);
        this.f4201B = this.f4207H.mo8069b().floatValue();
        this.f4200A = this.f4208I.mo8069b().floatValue();
    }

    /* renamed from: f */
    public Quaternion m8651f() {
        return this.f4236x;
    }

    /* renamed from: g */
    public short m8649g() {
        return this.f4220h;
    }

    /* renamed from: h */
    public short m8647h() {
        return this.f4221i;
    }

    /* renamed from: i */
    public short m8645i() {
        return this.f4222j;
    }

    /* renamed from: j */
    public short m8644j() {
        return this.f4223k;
    }

    /* renamed from: b */
    public void m8659b(short s, short s2, short s3, short s4) {
        this.f4220h = s;
        this.f4221i = s2;
        this.f4222j = s3;
        this.f4223k = s4;
        Quaternion quaternion = this.f4237y;
        quaternion.set((s2 * 1.0f) / 32767.0f, (s3 * 1.0f) / 32767.0f, (s4 * 1.0f) / 32767.0f, (s * 1.0f) / 32767.0f);
        this.f4237y.nor();
        m8665a(this.f4237y, this.f4209J, this.f4210K);
        this.f4203D = this.f4209J.mo8069b().floatValue();
        this.f4202C = this.f4210K.mo8069b().floatValue();
    }

    /* renamed from: k */
    public boolean m8643k() {
        return this.f4204E;
    }

    /* renamed from: l */
    public boolean m8642l() {
        return this.f4205F;
    }

    /* renamed from: m */
    public int m8641m() {
        return this.f4224l;
    }

    /* renamed from: n */
    public float m8640n() {
        return ((this.f4224l * 1.0f) / 65535.0f) * 100.0f;
    }

    /* renamed from: b */
    public void m8660b(int i) {
        this.f4224l = this.f4212M.mo8068b(Integer.valueOf(i)).intValue();
    }

    /* renamed from: o */
    public int m8639o() {
        return this.f4225m;
    }

    /* renamed from: p */
    public float m8638p() {
        return ((this.f4225m * 1.0f) / 65535.0f) * 100.0f;
    }

    /* renamed from: c */
    public void m8657c(int i) {
        this.f4225m = i;
    }

    /* renamed from: q */
    public short m8637q() {
        return this.f4226n;
    }

    /* renamed from: r */
    public short m8636r() {
        return this.f4227o;
    }

    /* renamed from: s */
    public short m8635s() {
        return this.f4228p;
    }

    /* renamed from: t */
    public short m8634t() {
        return this.f4229q;
    }

    /* renamed from: c */
    public void m8656c(short s, short s2, short s3, short s4) {
        this.f4226n = s;
        this.f4227o = s2;
        this.f4228p = s3;
        this.f4229q = s4;
    }

    /* renamed from: u */
    public int m8633u() {
        return this.f4230r;
    }

    /* renamed from: d */
    public void m8654d(int i) {
        this.f4230r = i;
    }

    /* renamed from: v */
    public int m8632v() {
        return this.f4206G.mo8069b().intValue();
    }

    /* renamed from: e */
    public void m8652e(int i) {
        this.f4231s = i;
        this.f4206G.mo8070a(Integer.valueOf(i));
    }

    /* renamed from: w */
    public int m8631w() {
        return this.f4232t;
    }

    /* renamed from: f */
    public void m8650f(int i) {
        this.f4211L.mo8070a(Integer.valueOf(i));
        this.f4232t = this.f4211L.mo8069b().intValue();
    }

    /* renamed from: g */
    public void m8648g(int i) {
        this.f4213a = i;
    }

    /* renamed from: x */
    public int m8630x() {
        return this.f4233u;
    }

    /* renamed from: h */
    public void m8646h(int i) {
        this.f4233u = i;
        if ((i & 1) == 1) {
            this.f4204E = true;
        } else {
            this.f4204E = false;
        }
        if (((i >> 3) & 1) == 1) {
            this.f4205F = true;
        } else {
            this.f4205F = false;
        }
    }

    /* renamed from: y */
    public MotorStatus m8629y() {
        return this.f4234v;
    }

    /* renamed from: a */
    public void m8662a(boolean z, int i, int i2, int i3, int i4) {
        MotorStatus motorStatus = this.f4234v;
        motorStatus.f4712a = z;
        motorStatus.f4716e = i;
        motorStatus.f4714c = i2;
        motorStatus.f4715d = i3;
        motorStatus.f4713b = i4;
    }

    /* renamed from: z */
    public SensorStatus m8628z() {
        return this.f4235w;
    }

    /* renamed from: a */
    public void m8667a(int i, int i2, int i3, int i4) {
        this.f4235w.m8625a(i);
        this.f4235w.m8623b(i2);
        this.f4235w.m8621c(i3);
        this.f4235w.m8619d(i4);
    }

    /* renamed from: A */
    public float m8672A() {
        return this.f4201B;
    }

    /* renamed from: B */
    public float m8671B() {
        return this.f4200A;
    }

    /* renamed from: C */
    public float m8670C() {
        return this.f4202C;
    }

    /* renamed from: a */
    private void m8665a(Quaternion quaternion, ValueFilter<Float> valueFilter, ValueFilter<Float> valueFilter2) {
        double d;
        quaternion.toMatrix(this.f4238z);
        float[] fArr = this.f4238z;
        Vector3 vector3 = new Vector3(fArr[0], fArr[1], 0.0f);
        vector3.m13114nor();
        Vector3 vector32 = new Vector3((float) Math.sqrt(Math.pow(this.f4238z[0], 2.0d) + Math.pow(this.f4238z[2], 2.0d)), this.f4238z[2], 0.0f);
        vector32.m13114nor();
        double d2 = 3.141592653589793d;
        if (vector3.f6126x > -1.0001d && vector3.f6126x < -0.9999d) {
            d = 3.141592653589793d;
        } else if (vector3.f6127y >= 0.0f) {
            d = Math.acos(vector3.f6126x);
        } else {
            d = -Math.acos(vector3.f6126x);
        }
        valueFilter.mo8070a(Float.valueOf((float) d));
        if (vector32.f6126x <= -1.0001d || vector32.f6126x >= -0.9999d) {
            if (vector32.f6127y >= 0.0f) {
                d2 = Math.acos(vector32.f6126x);
            } else {
                d2 = -Math.acos(vector32.f6126x);
            }
        }
        valueFilter2.mo8070a(Float.valueOf((float) d2));
    }
}
