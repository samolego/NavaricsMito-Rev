package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.log4j.spi.InterfaceC3249o;

/* compiled from: DefaultThrowableRenderer.java */
/* renamed from: org.apache.log4j.f, reason: use source file name */
/* loaded from: classes2.dex */
public final class DefaultThrowableRenderer implements InterfaceC3249o {
    @Override // org.apache.log4j.spi.InterfaceC3249o
    /* renamed from: a */
    public String[] mo11274a(Throwable th) {
        return m11273b(th);
    }

    /* renamed from: b */
    public static String[] m11273b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (RuntimeException unused) {
        }
        printWriter.flush();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(stringWriter.toString()));
        ArrayList arrayList = new ArrayList();
        try {
            for (String readLine = lineNumberReader.readLine(); readLine != null; readLine = lineNumberReader.readLine()) {
                arrayList.add(readLine);
            }
        } catch (IOException e) {
            if (e instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            arrayList.add(e.toString());
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}