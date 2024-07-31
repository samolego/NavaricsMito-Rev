package org.apache.mina.filter.codec.p126a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/* compiled from: LineDelimiter.java */
/* renamed from: org.apache.mina.filter.codec.a.a, reason: use source file name */
/* loaded from: classes2.dex */
public class LineDelimiter {

    /* renamed from: a */
    public static final LineDelimiter f11656a;

    /* renamed from: b */
    public static final LineDelimiter f11657b;

    /* renamed from: c */
    public static final LineDelimiter f11658c;

    /* renamed from: d */
    public static final LineDelimiter f11659d;

    /* renamed from: e */
    public static final LineDelimiter f11660e;

    /* renamed from: f */
    public static final LineDelimiter f11661f;

    /* renamed from: g */
    public static final LineDelimiter f11662g;

    /* renamed from: h */
    private final String f11663h;

    static {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new PrintWriter((OutputStream) byteArrayOutputStream, true).println();
        f11656a = new LineDelimiter(new String(byteArrayOutputStream.toByteArray()));
        f11657b = new LineDelimiter("");
        f11658c = new LineDelimiter("\r\n");
        f11659d = new LineDelimiter("\n");
        f11660e = f11658c;
        f11661f = new LineDelimiter("\r");
        f11662g = new LineDelimiter("\u0000");
    }

    public LineDelimiter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("delimiter");
        }
        this.f11663h = str;
    }

    /* renamed from: a */
    public String m11964a() {
        return this.f11663h;
    }

    public int hashCode() {
        return this.f11663h.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LineDelimiter) {
            return this.f11663h.equals(((LineDelimiter) obj).f11663h);
        }
        return false;
    }

    public String toString() {
        if (this.f11663h.length() == 0) {
            return "delimiter: auto";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("delimiter:");
        for (int i = 0; i < this.f11663h.length(); i++) {
            sb.append(" 0x");
            sb.append(Integer.toHexString(this.f11663h.charAt(i)));
        }
        return sb.toString();
    }
}