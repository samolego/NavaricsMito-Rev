package org.opencv.core;

/* renamed from: org.opencv.core.a */
/* loaded from: classes2.dex */
public final class CvType {

    /* renamed from: a */
    public static final int f12502a = m279a(1);

    /* renamed from: b */
    public static final int f12503b = m279a(2);

    /* renamed from: c */
    public static final int f12504c = m279a(3);

    /* renamed from: d */
    public static final int f12505d = m279a(4);

    /* renamed from: e */
    public static final int f12506e = m277b(1);

    /* renamed from: f */
    public static final int f12507f = m277b(2);

    /* renamed from: g */
    public static final int f12508g = m277b(3);

    /* renamed from: h */
    public static final int f12509h = m277b(4);

    /* renamed from: i */
    public static final int f12510i = m276c(1);

    /* renamed from: j */
    public static final int f12511j = m276c(2);

    /* renamed from: k */
    public static final int f12512k = m276c(3);

    /* renamed from: l */
    public static final int f12513l = m276c(4);

    /* renamed from: m */
    public static final int f12514m = m275d(1);

    /* renamed from: n */
    public static final int f12515n = m275d(2);

    /* renamed from: o */
    public static final int f12516o = m275d(3);

    /* renamed from: p */
    public static final int f12517p = m275d(4);

    /* renamed from: q */
    public static final int f12518q = m274e(1);

    /* renamed from: r */
    public static final int f12519r = m274e(2);

    /* renamed from: s */
    public static final int f12520s = m274e(3);

    /* renamed from: t */
    public static final int f12521t = m274e(4);

    /* renamed from: u */
    public static final int f12522u = m273f(1);

    /* renamed from: v */
    public static final int f12523v = m273f(2);

    /* renamed from: w */
    public static final int f12524w = m273f(3);

    /* renamed from: x */
    public static final int f12525x = m273f(4);

    /* renamed from: y */
    public static final int f12526y = m272g(1);

    /* renamed from: z */
    public static final int f12527z = m272g(2);

    /* renamed from: A */
    public static final int f12500A = m272g(3);

    /* renamed from: B */
    public static final int f12501B = m272g(4);

    /* renamed from: h */
    public static final int m271h(int i) {
        return (i >> 3) + 1;
    }

    /* renamed from: i */
    public static final int m270i(int i) {
        return i & 7;
    }

    /* renamed from: a */
    public static final int m278a(int i, int i2) {
        if (i2 <= 0 || i2 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        }
        if (i < 0 || i >= 8) {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
        return (i & 7) + ((i2 - 1) << 3);
    }

    /* renamed from: a */
    public static final int m279a(int i) {
        return m278a(0, i);
    }

    /* renamed from: b */
    public static final int m277b(int i) {
        return m278a(1, i);
    }

    /* renamed from: c */
    public static final int m276c(int i) {
        return m278a(2, i);
    }

    /* renamed from: d */
    public static final int m275d(int i) {
        return m278a(3, i);
    }

    /* renamed from: e */
    public static final int m274e(int i) {
        return m278a(4, i);
    }

    /* renamed from: f */
    public static final int m273f(int i) {
        return m278a(5, i);
    }

    /* renamed from: g */
    public static final int m272g(int i) {
        return m278a(6, i);
    }

    /* renamed from: j */
    public static final String m269j(int i) {
        String str;
        switch (m270i(i)) {
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
        int m271h = m271h(i);
        if (m271h <= 4) {
            return str + "C" + m271h;
        }
        return str + "C(" + m271h + ")";
    }
}
