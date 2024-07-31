package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.u */
/* loaded from: classes2.dex */
public class WriterAppender extends AppenderSkeleton {

    /* renamed from: n */
    protected boolean f11288n = true;

    /* renamed from: o */
    protected String f11289o;

    /* renamed from: p */
    protected QuietWriter f11290p;

    @Override // org.apache.log4j.Appender
    /* renamed from: b */
    public boolean mo1473b() {
        return true;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    /* renamed from: e */
    public void mo1470e() {
    }

    /* renamed from: a */
    public void m1474a(boolean z) {
        this.f11288n = z;
    }

    @Override // org.apache.log4j.AppenderSkeleton
    /* renamed from: a */
    public void mo1476a(LoggingEvent loggingEvent) {
        if (m1468i()) {
            mo1472c(loggingEvent);
        }
    }

    /* renamed from: i */
    protected boolean m1468i() {
        if (this.f11155h) {
            LogLog.m1595c("Not allowed to write to a closed appender.");
            return false;
        } else if (this.f11290p == null) {
            ErrorHandler errorHandler = this.f11152e;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No output stream or file set for the appender named [");
            stringBuffer.append(this.f11150c);
            stringBuffer.append("].");
            errorHandler.mo1522a(stringBuffer.toString());
            return false;
        } else if (this.f11149b == null) {
            ErrorHandler errorHandler2 = this.f11152e;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No layout set for the appender named [");
            stringBuffer2.append(this.f11150c);
            stringBuffer2.append("].");
            errorHandler2.mo1522a(stringBuffer2.toString());
            return false;
        } else {
            return true;
        }
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: a */
    public synchronized void mo1478a() {
        if (this.f11155h) {
            return;
        }
        this.f11155h = true;
        m1465l();
        mo1469g();
    }

    /* renamed from: j */
    protected void m1467j() {
        QuietWriter quietWriter = this.f11290p;
        if (quietWriter != null) {
            try {
                quietWriter.close();
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.OutputStreamWriter m1477a(java.io.OutputStream r3) {
        /*
            r2 = this;
            java.lang.String r0 = r2.m1466k()
            if (r0 == 0) goto L22
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch: java.io.IOException -> Lc
            r1.<init>(r3, r0)     // Catch: java.io.IOException -> Lc
            goto L23
        Lc:
            r0 = move-exception
            boolean r0 = r0 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L18
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L18:
            java.lang.String r0 = "Error initializing output writer."
            org.apache.log4j.helpers.LogLog.m1595c(r0)
            java.lang.String r0 = "Unsupported encoding?"
            org.apache.log4j.helpers.LogLog.m1595c(r0)
        L22:
            r1 = 0
        L23:
            if (r1 != 0) goto L2a
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
            r1.<init>(r3)
        L2a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.WriterAppender.m1477a(java.io.OutputStream):java.io.OutputStreamWriter");
    }

    /* renamed from: k */
    public String m1466k() {
        return this.f11289o;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.Appender
    /* renamed from: a */
    public synchronized void mo1475a(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            LogLog.m1595c("You have tried to set a null error-handler.");
        } else {
            this.f11152e = errorHandler;
            if (this.f11290p != null) {
                this.f11290p.m1571a(errorHandler);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo1472c(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        this.f11290p.write(this.f11149b.mo1545a(loggingEvent));
        if (this.f11149b.mo1544c() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
            for (String str : throwableStrRep) {
                this.f11290p.write(str);
                this.f11290p.write(Layout.f11239a);
            }
        }
        if (m1471d(loggingEvent)) {
            this.f11290p.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void mo1469g() {
        m1467j();
        this.f11290p = null;
    }

    /* renamed from: l */
    protected void m1465l() {
        String m1569b;
        QuietWriter quietWriter;
        if (this.f11149b == null || (m1569b = this.f11149b.m1569b()) == null || (quietWriter = this.f11290p) == null) {
            return;
        }
        quietWriter.write(m1569b);
        this.f11290p.flush();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public void m1464m() {
        String m1570a;
        QuietWriter quietWriter;
        if (this.f11149b == null || (m1570a = this.f11149b.m1570a()) == null || (quietWriter = this.f11290p) == null) {
            return;
        }
        quietWriter.write(m1570a);
    }

    /* renamed from: d */
    protected boolean m1471d(LoggingEvent loggingEvent) {
        return this.f11288n;
    }
}
