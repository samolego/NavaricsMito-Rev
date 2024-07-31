package org.apache.log4j;

import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OnlyOnceErrorHandler;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

/* renamed from: org.apache.log4j.b */
/* loaded from: classes2.dex */
public abstract class AppenderSkeleton implements Appender, OptionHandler {

    /* renamed from: b */
    protected Layout f11149b;

    /* renamed from: c */
    protected String f11150c;

    /* renamed from: d */
    protected Priority f11151d;

    /* renamed from: f */
    protected Filter f11153f;

    /* renamed from: g */
    protected Filter f11154g;

    /* renamed from: e */
    protected ErrorHandler f11152e = new OnlyOnceErrorHandler();

    /* renamed from: h */
    protected boolean f11155h = false;

    /* renamed from: a */
    protected abstract void mo1476a(LoggingEvent loggingEvent);

    @Override // org.apache.log4j.spi.OptionHandler
    /* renamed from: e */
    public void mo1470e() {
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: a */
    public void mo1642a(Filter filter) {
        if (this.f11153f == null) {
            this.f11154g = filter;
            this.f11153f = filter;
            return;
        }
        this.f11154g.m1516a(filter);
        this.f11154g = filter;
    }

    public void finalize() {
        if (this.f11155h) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Finalizing appender named [");
        stringBuffer.append(this.f11150c);
        stringBuffer.append("].");
        LogLog.m1600a(stringBuffer.toString());
        mo1478a();
    }

    /* renamed from: f */
    public Layout m1639f() {
        return this.f11149b;
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: d */
    public final String mo1640d() {
        return this.f11150c;
    }

    /* renamed from: a */
    public boolean m1643a(Priority priority) {
        Priority priority2 = this.f11151d;
        return priority2 == null || priority.isGreaterOrEqual(priority2);
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: b */
    public synchronized void mo1641b(LoggingEvent loggingEvent) {
        if (this.f11155h) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attempted to append to closed appender named [");
            stringBuffer.append(this.f11150c);
            stringBuffer.append("].");
            LogLog.m1597b(stringBuffer.toString());
        } else if (m1643a(loggingEvent.getLevel())) {
            Filter filter = this.f11153f;
            while (filter != null) {
                switch (filter.m1517a(loggingEvent)) {
                    case -1:
                        return;
                    case 0:
                        filter = filter.m1518a();
                        break;
                    case 1:
                        mo1476a(loggingEvent);
                }
            }
            mo1476a(loggingEvent);
        }
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: a */
    public synchronized void mo1475a(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            LogLog.m1595c("You have tried to set a null error-handler.");
        } else {
            this.f11152e = errorHandler;
        }
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: a */
    public void mo1644a(Layout layout) {
        this.f11149b = layout;
    }

    @Override // org.apache.log4j.Appender
    /* renamed from: a */
    public void mo1645a(String str) {
        this.f11150c = str;
    }
}
