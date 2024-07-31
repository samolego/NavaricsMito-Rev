package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.CountingQuietWriter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.s */
/* loaded from: classes2.dex */
public class RollingFileAppender extends FileAppender {

    /* renamed from: l */
    protected long f11269l;

    /* renamed from: m */
    protected int f11270m;

    /* renamed from: q */
    private long f11271q;

    public RollingFileAppender() {
        this.f11269l = 10485760L;
        this.f11270m = 1;
        this.f11271q = 0L;
    }

    public RollingFileAppender(Layout layout, String str) throws IOException {
        super(layout, str);
        this.f11269l = 10485760L;
        this.f11270m = 1;
        this.f11271q = 0L;
    }

    /* renamed from: h */
    public void m1527h() {
        boolean z;
        if (this.f11290p != null) {
            long m1608a = ((CountingQuietWriter) this.f11290p).m1608a();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("rolling over count=");
            stringBuffer.append(m1608a);
            LogLog.m1600a(stringBuffer.toString());
            this.f11271q = m1608a + this.f11269l;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("maxBackupIndex=");
        stringBuffer2.append(this.f11270m);
        LogLog.m1600a(stringBuffer2.toString());
        if (this.f11270m > 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(this.f11175i);
            stringBuffer3.append('.');
            stringBuffer3.append(this.f11270m);
            File file = new File(stringBuffer3.toString());
            z = file.exists() ? file.delete() : true;
            for (int i = this.f11270m - 1; i >= 1 && z; i--) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.f11175i);
                stringBuffer4.append(".");
                stringBuffer4.append(i);
                File file2 = new File(stringBuffer4.toString());
                if (file2.exists()) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(this.f11175i);
                    stringBuffer5.append('.');
                    stringBuffer5.append(i + 1);
                    File file3 = new File(stringBuffer5.toString());
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Renaming file ");
                    stringBuffer6.append(file2);
                    stringBuffer6.append(" to ");
                    stringBuffer6.append(file3);
                    LogLog.m1600a(stringBuffer6.toString());
                    z = file2.renameTo(file3);
                }
            }
            if (z) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(this.f11175i);
                stringBuffer7.append(".");
                stringBuffer7.append(1);
                File file4 = new File(stringBuffer7.toString());
                m1618c();
                File file5 = new File(this.f11175i);
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append("Renaming file ");
                stringBuffer8.append(file5);
                stringBuffer8.append(" to ");
                stringBuffer8.append(file4);
                LogLog.m1600a(stringBuffer8.toString());
                z = file5.renameTo(file4);
                if (!z) {
                    try {
                        mo1528a(this.f11175i, true, this.f11176j, this.f11177k);
                    } catch (IOException e) {
                        if (e instanceof InterruptedIOException) {
                            Thread.currentThread().interrupt();
                        }
                        StringBuffer stringBuffer9 = new StringBuffer();
                        stringBuffer9.append("setFile(");
                        stringBuffer9.append(this.f11175i);
                        stringBuffer9.append(", true) call failed.");
                        LogLog.m1596b(stringBuffer9.toString(), e);
                    }
                }
            }
        } else {
            z = true;
        }
        if (z) {
            try {
                mo1528a(this.f11175i, false, this.f11176j, this.f11177k);
                this.f11271q = 0L;
            } catch (IOException e2) {
                if (e2 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer10 = new StringBuffer();
                stringBuffer10.append("setFile(");
                stringBuffer10.append(this.f11175i);
                stringBuffer10.append(", false) call failed.");
                LogLog.m1596b(stringBuffer10.toString(), e2);
            }
        }
    }

    @Override // org.apache.log4j.FileAppender
    /* renamed from: a */
    public synchronized void mo1528a(String str, boolean z, boolean z2, int i) throws IOException {
        super.mo1528a(str, z, this.f11176j, this.f11177k);
        if (z) {
            ((CountingQuietWriter) this.f11290p).m1607a(new File(str).length());
        }
    }

    /* renamed from: a */
    public void m1531a(int i) {
        this.f11270m = i;
    }

    /* renamed from: a */
    public void m1530a(long j) {
        this.f11269l = j;
    }

    @Override // org.apache.log4j.FileAppender
    /* renamed from: a */
    protected void mo1529a(Writer writer) {
        this.f11290p = new CountingQuietWriter(writer, this.f11152e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.log4j.WriterAppender
    /* renamed from: c */
    public void mo1472c(LoggingEvent loggingEvent) {
        super.mo1472c(loggingEvent);
        if (this.f11175i == null || this.f11290p == null) {
            return;
        }
        long m1608a = ((CountingQuietWriter) this.f11290p).m1608a();
        if (m1608a < this.f11269l || m1608a < this.f11271q) {
            return;
        }
        m1527h();
    }
}
