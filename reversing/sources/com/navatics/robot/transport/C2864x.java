package com.navatics.robot.transport;

import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.robot.transport.x */
/* loaded from: classes.dex */
public class NvValue {

    /* renamed from: e */
    private NvUnit f6708e;

    /* renamed from: f */
    private double f6709f;

    /* renamed from: g */
    private C2146a f6710g = f6704a;

    /* renamed from: b */
    private static final C3044k f6705b = C3044k.m1564a(NvValue.class);

    /* renamed from: c */
    private static DecimalFormat f6706c = new DecimalFormat("0.00");

    /* renamed from: d */
    private static DecimalFormat f6707d = new DecimalFormat("0.0");

    /* renamed from: a */
    public static final C2146a f6704a = new C2146a(2, true, -1, -1, -1, -1);

    private NvValue() {
    }

    /* renamed from: a */
    public static NvValue m5977a(NvUnit nvUnit, InputStream inputStream) {
        return m5976a(nvUnit, inputStream, ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    public static NvValue m5976a(NvUnit nvUnit, InputStream inputStream, ByteOrder byteOrder) {
        NvValue nvValue = new NvValue();
        nvValue.f6708e = nvUnit;
        try {
            nvValue.f6709f = m5973a(inputStream, byteOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nvValue;
    }

    /* renamed from: a */
    private static long m5973a(InputStream inputStream, ByteOrder byteOrder) throws IOException {
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < bArr.length) {
            i += inputStream.read(bArr, i, bArr.length - i);
        }
        return ByteBuffer.wrap(bArr).order(byteOrder).getLong();
    }

    /* renamed from: a */
    public static NvValue m5978a(NvUnit nvUnit, double d) {
        if (nvUnit == null) {
            throw new RuntimeException("create NvValue but unit is null");
        }
        NvValue nvValue = new NvValue();
        nvValue.f6708e = nvUnit;
        nvValue.f6709f = d;
        return nvValue;
    }

    /* renamed from: a */
    public void m5975a(C2146a c2146a) {
        if (c2146a == null) {
            throw new RuntimeException("config can not be null");
        }
        this.f6710g = c2146a;
    }

    /* renamed from: a */
    public void m5980a(int i) {
        this.f6710g.f6711a = i;
    }

    /* renamed from: b */
    private String m5969b(int i) {
        if (i == 0) {
            return m5966c(this.f6709f);
        }
        if (i == 1) {
            return m5971b(this.f6709f);
        }
        return m5983a(this.f6709f);
    }

    /* renamed from: a */
    public CharSequence m5984a() {
        SpannableString spannableString;
        C2146a c2146a = this.f6710g;
        if (c2146a.f6715e == -1 || c2146a.f6713c == -1) {
            String m5969b = m5969b(c2146a.f6711a);
            if (c2146a.f6712b) {
                return m5969b + this.f6708e.m6005b();
            }
            return m5969b;
        }
        String m5969b2 = m5969b(c2146a.f6711a);
        if (c2146a.f6712b) {
            spannableString = new SpannableString(m5969b2 + this.f6708e.m6005b());
            spannableString.setSpan(new AbsoluteSizeSpan(c2146a.f6713c), 0, m5969b2.length(), 17);
            if (c2146a.f6714d != -1) {
                spannableString.setSpan(new StyleSpan(c2146a.f6714d), 0, m5969b2.length(), 17);
            }
            spannableString.setSpan(new AbsoluteSizeSpan(c2146a.f6715e), m5969b2.length(), m5969b2.length() + this.f6708e.m6005b().length(), 17);
            if (c2146a.f6716f != -1) {
                spannableString.setSpan(new StyleSpan(c2146a.f6716f), m5969b2.length(), m5969b2.length() + this.f6708e.m6005b().length(), 17);
            }
        } else {
            spannableString = new SpannableString(m5969b2);
            spannableString.setSpan(new AbsoluteSizeSpan(c2146a.f6713c), 0, m5969b2.length(), 17);
            if (c2146a.f6714d != -1) {
                spannableString.setSpan(new StyleSpan(c2146a.f6714d), 0, m5969b2.length(), 17);
            }
        }
        return spannableString;
    }

    /* renamed from: a */
    public void m5982a(double d, NvUnit nvUnit) {
        NvUnit nvUnit2 = this.f6708e;
        if (nvUnit2 == nvUnit) {
            this.f6709f = d;
        } else {
            this.f6709f = m5981a(d, nvUnit, nvUnit2);
        }
    }

    /* renamed from: b */
    public NvUnit m5972b() {
        return this.f6708e;
    }

    /* renamed from: c */
    public double m5967c() {
        return this.f6709f;
    }

    /* renamed from: d */
    public double m5964d() {
        return m5968b(NvUnit.f6686d);
    }

    /* renamed from: e */
    public double m5962e() {
        return m5968b(NvUnit.f6685c);
    }

    /* renamed from: f */
    public NvValue m5961f() {
        return m5978a(NvUnit.f6686d, m5964d());
    }

    /* renamed from: g */
    public NvValue m5960g() {
        return m5978a(NvUnit.f6685c, m5962e());
    }

    /* renamed from: a */
    public NvValue m5979a(NvUnit nvUnit) {
        return this.f6708e == nvUnit ? this : m5978a(nvUnit, m5968b(nvUnit));
    }

    /* renamed from: b */
    private double m5968b(NvUnit nvUnit) {
        return m5981a(this.f6709f, this.f6708e, nvUnit);
    }

    /* renamed from: a */
    public static double m5981a(double d, NvUnit nvUnit, NvUnit nvUnit2) {
        if (nvUnit.m6004c() != nvUnit2.m6004c()) {
            throw new InvalidParameterException("Unit can't change from " + nvUnit.m6004c() + " to " + nvUnit2.m6004c());
        }
        switch (nvUnit.m6004c()) {
            case 1:
                return m5970b(d, nvUnit, nvUnit2);
            case 2:
                return m5963d(d, nvUnit, nvUnit2);
            case 3:
                return m5965c(d, nvUnit, nvUnit2);
            default:
                throw new RuntimeException("can not convert from unit " + nvUnit.m6006a());
        }
    }

    /* renamed from: b */
    private static double m5970b(double d, NvUnit nvUnit, NvUnit nvUnit2) {
        if (nvUnit.m6006a() == 2) {
            switch (nvUnit2.m6006a()) {
                case 1:
                    return d * 1024.0d;
                case 2:
                    return d;
                case 3:
                    return d / 1024.0d;
                case 4:
                    return (d / 1024.0d) / 1024.0d;
            }
        }
        throw new RuntimeException("Can't convert from " + nvUnit + " to " + nvUnit2);
    }

    /* renamed from: c */
    private static double m5965c(double d, NvUnit nvUnit, NvUnit nvUnit2) {
        switch (nvUnit.m6006a()) {
            case 8:
                if (nvUnit2.m6006a() == 9) {
                    return (d * 1.8d) + 32.0d;
                }
                break;
            case 9:
                if (nvUnit2.m6006a() == 8) {
                    return (d - 32.0d) / 1.8d;
                }
                break;
        }
        throw new RuntimeException("Can't convert from " + nvUnit + " to " + nvUnit2);
    }

    /* renamed from: d */
    private static double m5963d(double d, NvUnit nvUnit, NvUnit nvUnit2) {
        if (d < Utils.DOUBLE_EPSILON) {
            throw new InvalidParameterException("meter can't be negative");
        }
        int m6006a = nvUnit.m6006a();
        if (m6006a == 5) {
            if (nvUnit2.m6006a() == 7) {
                return d * 3.2808399d;
            }
        } else if (m6006a == 7 && nvUnit2.m6006a() == 5) {
            return d * 0.3048d;
        }
        throw new RuntimeException("Can't convert from " + nvUnit + " to " + nvUnit2);
    }

    /* renamed from: a */
    public static String m5983a(double d) {
        return f6706c.format(d);
    }

    /* renamed from: b */
    public static String m5971b(double d) {
        return f6707d.format(d);
    }

    /* renamed from: a */
    public static String m5974a(NvValue nvValue) {
        return m5983a(nvValue.m5967c());
    }

    /* renamed from: c */
    public static String m5966c(double d) {
        return String.valueOf((int) d);
    }

    @NonNull
    public String toString() {
        return "NvValue{value=" + this.f6709f + '}';
    }

    /* compiled from: NvValue.java */
    /* renamed from: com.navatics.robot.transport.x$a */
    /* loaded from: classes.dex */
    public static class C2146a {

        /* renamed from: a */
        int f6711a;

        /* renamed from: b */
        boolean f6712b;

        /* renamed from: c */
        int f6713c;

        /* renamed from: d */
        int f6714d;

        /* renamed from: e */
        int f6715e;

        /* renamed from: f */
        int f6716f;

        public C2146a(int i, boolean z, int i2, int i3, int i4, int i5) {
            this.f6711a = i;
            this.f6712b = z;
            this.f6713c = i2;
            this.f6714d = i3;
            this.f6715e = i4;
            this.f6716f = i5;
        }

        public String toString() {
            return "FormatConfig{decimals=" + this.f6711a + ", withSym=" + this.f6712b + ", valueFrontSizeInPx=" + this.f6713c + ", valueTypeface=" + this.f6714d + ", symFrontSizeInPx=" + this.f6715e + ", symTypeface=" + this.f6716f + '}';
        }
    }

    /* compiled from: NvValue.java */
    /* renamed from: com.navatics.robot.transport.x$b */
    /* loaded from: classes.dex */
    public static class C2147b {

        /* renamed from: c */
        int f6719c;

        /* renamed from: e */
        int f6721e;

        /* renamed from: a */
        int f6717a = 2;

        /* renamed from: b */
        boolean f6718b = true;

        /* renamed from: d */
        int f6720d = -1;

        /* renamed from: f */
        int f6722f = -1;

        /* renamed from: a */
        public C2147b m5958a(int i) {
            this.f6719c = i;
            return this;
        }

        /* renamed from: b */
        public C2147b m5957b(int i) {
            this.f6720d = i;
            return this;
        }

        /* renamed from: c */
        public C2147b m5956c(int i) {
            this.f6721e = i;
            return this;
        }

        /* renamed from: d */
        public C2147b m5955d(int i) {
            this.f6722f = i;
            return this;
        }

        /* renamed from: a */
        public C2146a m5959a() {
            return new C2146a(this.f6717a, this.f6718b, this.f6719c, this.f6720d, this.f6721e, this.f6722f);
        }
    }
}
