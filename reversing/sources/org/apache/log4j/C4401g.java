package org.apache.log4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;

/* renamed from: org.apache.log4j.g */
/* loaded from: classes2.dex */
public class FileAppender extends WriterAppender {

    /* renamed from: a */
    protected boolean f11174a;

    /* renamed from: i */
    protected String f11175i;

    /* renamed from: j */
    protected boolean f11176j;

    /* renamed from: k */
    protected int f11177k;

    public FileAppender() {
        this.f11174a = true;
        this.f11175i = null;
        this.f11176j = false;
        this.f11177k = 8192;
    }

    public FileAppender(Layout layout, String str, boolean z) throws IOException {
        this.f11174a = true;
        this.f11175i = null;
        this.f11176j = false;
        this.f11177k = 8192;
        this.f11149b = layout;
        mo1528a(str, z, false, this.f11177k);
    }

    public FileAppender(Layout layout, String str) throws IOException {
        this(layout, str, true);
    }

    @Override // org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    /* renamed from: e */
    public void mo1470e() {
        String str = this.f11175i;
        if (str != null) {
            try {
                mo1528a(str, this.f11174a, this.f11176j, this.f11177k);
                return;
            } catch (IOException e) {
                ErrorHandler errorHandler = this.f11152e;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("setFile(");
                stringBuffer.append(this.f11175i);
                stringBuffer.append(",");
                stringBuffer.append(this.f11174a);
                stringBuffer.append(") call failed.");
                errorHandler.mo1521a(stringBuffer.toString(), e, 4);
                return;
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("File option not set for appender [");
        stringBuffer2.append(this.f11150c);
        stringBuffer2.append("].");
        LogLog.m1595c(stringBuffer2.toString());
        LogLog.m1595c("Are you using FileAppender instead of ConsoleAppender?");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m1618c() {
        if (this.f11290p != null) {
            try {
                this.f11290p.close();
            } catch (IOException e) {
                if (e instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not close ");
                stringBuffer.append(this.f11290p);
                LogLog.m1596b(stringBuffer.toString(), e);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo1528a(String str, boolean z, boolean z2, int i) throws IOException {
        FileOutputStream fileOutputStream;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("setFile called: ");
        stringBuffer.append(str);
        stringBuffer.append(", ");
        stringBuffer.append(z);
        LogLog.m1600a(stringBuffer.toString());
        if (z2) {
            m1474a(false);
        }
        mo1469g();
        try {
            fileOutputStream = new FileOutputStream(str, z);
        } catch (FileNotFoundException e) {
            String parent = new File(str).getParent();
            if (parent != null) {
                File file = new File(parent);
                if (!file.exists() && file.mkdirs()) {
                    fileOutputStream = new FileOutputStream(str, z);
                } else {
                    throw e;
                }
            } else {
                throw e;
            }
        }
        Writer a = m1477a(fileOutputStream);
        if (z2) {
            a = new BufferedWriter(a, i);
        }
        mo1529a(a);
        this.f11175i = str;
        this.f11174a = z;
        this.f11176j = z2;
        this.f11177k = i;
        m1464m();
        LogLog.m1600a("setFile ended");
    }

    /* renamed from: a */
    protected void mo1529a(Writer writer) {
        this.f11290p = new QuietWriter(writer, this.f11152e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.log4j.WriterAppender
    /* renamed from: g */
    public void mo1469g() {
        m1618c();
        this.f11175i = null;
        super.mo1469g();
    }
}
