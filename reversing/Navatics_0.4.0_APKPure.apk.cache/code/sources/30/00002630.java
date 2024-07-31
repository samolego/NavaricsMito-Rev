package org.apache.ftpserver.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Random;

/* compiled from: IoUtils.java */
/* renamed from: org.apache.ftpserver.util.c */
/* loaded from: classes2.dex */
public class C3196c {

    /* renamed from: a */
    private static final Random f11185a = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static final BufferedInputStream m11207a(InputStream inputStream) {
        if (inputStream instanceof BufferedInputStream) {
            return (BufferedInputStream) inputStream;
        }
        return new BufferedInputStream(inputStream);
    }

    /* renamed from: a */
    public static final BufferedOutputStream m11208a(OutputStream outputStream) {
        if (outputStream instanceof BufferedOutputStream) {
            return (BufferedOutputStream) outputStream;
        }
        return new BufferedOutputStream(outputStream);
    }

    /* renamed from: b */
    public static final void m11210b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public static final void m11211b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static final void m11209a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }
}