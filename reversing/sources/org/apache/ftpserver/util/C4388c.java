package org.apache.ftpserver.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Random;

/* renamed from: org.apache.ftpserver.util.c */
/* loaded from: classes2.dex */
public class IoUtils {

    /* renamed from: a */
    private static final Random f11144a = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static final BufferedInputStream m1665a(InputStream inputStream) {
        if (inputStream instanceof BufferedInputStream) {
            return (BufferedInputStream) inputStream;
        }
        return new BufferedInputStream(inputStream);
    }

    /* renamed from: a */
    public static final BufferedOutputStream m1664a(OutputStream outputStream) {
        if (outputStream instanceof BufferedOutputStream) {
            return (BufferedOutputStream) outputStream;
        }
        return new BufferedOutputStream(outputStream);
    }

    /* renamed from: b */
    public static final void m1662b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public static final void m1661b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static final void m1663a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }
}
