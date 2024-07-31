package org.opencv.core;

/* compiled from: CvType.java */
/* renamed from: org.opencv.core.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class CvType {

    /* renamed from: a */
    public static final int f12543a = m12532a(1);

    /* renamed from: b */
    public static final int f12544b = m12532a(2);

    /* renamed from: c */
    public static final int f12545c = m12532a(3);

    /* renamed from: d */
    public static final int f12546d = m12532a(4);

    /* renamed from: e */
    public static final int f12547e = m12534b(1);

    /* renamed from: f */
    public static final int f12548f = m12534b(2);

    /* renamed from: g */
    public static final int f12549g = m12534b(3);

    /* renamed from: h */
    public static final int f12550h = m12534b(4);

    /* renamed from: i */
    public static final int f12551i = m12535c(1);

    /* renamed from: j */
    public static final int f12552j = m12535c(2);

    /* renamed from: k */
    public static final int f12553k = m12535c(3);

    /* renamed from: l */
    public static final int f12554l = m12535c(4);

    /* renamed from: m */
    public static final int f12555m = m12536d(1);

    /* renamed from: n */
    public static final int f12556n = m12536d(2);

    /* renamed from: o */
    public static final int f12557o = m12536d(3);

    /* renamed from: p */
    public static final int f12558p = m12536d(4);

    /* renamed from: q */
    public static final int f12559q = m12537e(1);

    /* renamed from: r */
    public static final int f12560r = m12537e(2);

    /* renamed from: s */
    public static final int f12561s = m12537e(3);

    /* renamed from: t */
    public static final int f12562t = m12537e(4);

    /* renamed from: u */
    public static final int f12563u = m12538f(1);

    /* renamed from: v */
    public static final int f12564v = m12538f(2);

    /* renamed from: w */
    public static final int f12565w = m12538f(3);

    /* renamed from: x */
    public static final int f12566x = m12538f(4);

    /* renamed from: y */
    public static final int f12567y = m12539g(1);

    /* renamed from: z */
    public static final int f12568z = m12539g(2);

    /* renamed from: A */
    public static final int f12541A = m12539g(3);

    /* renamed from: B */
    public static final int f12542B = m12539g(4);

    /* renamed from: h */
    public static final int m12540h(int i) {
        return (i >> 3) + 1;
    }

    /* renamed from: i */
    public static final int m12541i(int i) {
        return i & 7;
    }

    /* renamed from: a */
    public static final int m12533a(int i, int i2) {
        if (i2 <= 0 || i2 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        }
        if (i < 0 || i >= 8) {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
        return (i & 7) + ((i2 - 1) << 3);
    }

    /* renamed from: a */
    public static final int m12532a(int i) {
        return m12533a(0, i);
    }

    /* renamed from: b */
    public static final int m12534b(int i) {
        return m12533a(1, i);
    }

    /* renamed from: c */
    public static final int m12535c(int i) {
        return m12533a(2, i);
    }

    /* renamed from: d */
    public static final int m12536d(int i) {
        return m12533a(3, i);
    }

    /* renamed from: e */
    public static final int m12537e(int i) {
        return m12533a(4, i);
    }

    /* renamed from: f */
    public static final int m12538f(int i) {
        return m12533a(5, i);
    }

    /* renamed from: g */
    public static final int m12539g(int i) {
        return m12533a(6, i);
    }

    /* renamed from: j */
    public static final String m12542j(int i) {
        String str;
        switch (m12541i(i)) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_USRTYPE1";
                break;
            default:
                throw new UnsupportedOperationException("Unsupported CvType value: " + i);
        }
        int m12540h = m12540h(i);
        if (m12540h <= 4) {
            return str + "C" + m12540h;
        }
        return str + "C(" + m12540h + ")";
    }
}