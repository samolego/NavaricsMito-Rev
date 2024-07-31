package org.apache.mina.filter.codec.p137a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/* renamed from: org.apache.mina.filter.codec.a.a */
/* loaded from: classes2.dex */
public class LineDelimiter {

    /* renamed from: a */
    public static final LineDelimiter f11615a;

    /* renamed from: b */
    public static final LineDelimiter f11616b;

    /* renamed from: c */
    public static final LineDelimiter f11617c;

    /* renamed from: d */
    public static final LineDelimiter f11618d;

    /* renamed from: e */
    public static final LineDelimiter f11619e;

    /* renamed from: f */
    public static final LineDelimiter f11620f;

    /* renamed from: g */
    public static final LineDelimiter f11621g;

    /* renamed from: h */
    private final String f11622h;

    static {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new PrintWriter((OutputStream) byteArrayOutputStream, true).println();
        f11615a = new LineDelimiter(new String(byteArrayOutputStream.toByteArray()));
        f11616b = new LineDelimiter("");
        f11617c = new LineDelimiter("\r\n");
        f11618d = new LineDelimiter("\n");
        f11619e = f11617c;
        f11620f = new LineDelimiter("\r");
        f11621g = new LineDelimiter("\u0000");
    }

    public LineDelimiter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("delimiter");
        }
        this.f11622h = str;
    }

    /* renamed from: a */
    public String m864a() {
        return this.f11622h;
    }

    public int hashCode() {
        return this.f11622h.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LineDelimiter) {
            return this.f11622h.equals(((LineDelimiter) obj).f11622h);
        }
        return false;
    }

    public String toString() {
        if (this.f11622h.length() == 0) {
            return "delimiter: auto";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("delimiter:");
        for (int i = 0; i < this.f11622h.length(); i++) {
            sb.append(" 0x");
            sb.append(Integer.toHexString(this.f11622h.charAt(i)));
        }
        return sb.toString();
    }
}
