package org.slf4j.impl;

import java.io.Serializable;
import org.apache.log4j.C3044k;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.ThrowableInformation;
import org.slf4j.Marker;
import org.slf4j.event.LoggingEvent;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.p152a.InterfaceC3152a;

/* loaded from: classes2.dex */
public final class Log4jLoggerAdapter extends MarkerIgnoringBase implements Serializable, InterfaceC3152a {
    static final String FQCN = "org.slf4j.impl.Log4jLoggerAdapter";
    private static final long serialVersionUID = 6182834493563598289L;
    final transient C3044k logger;
    final boolean traceCapable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Log4jLoggerAdapter(C3044k c3044k) {
        this.logger = c3044k;
        this.name = c3044k.m1631e();
        this.traceCapable = m184a();
    }

    /* renamed from: a */
    private boolean m184a() {
        try {
            this.logger.mo1495k();
            return true;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isTraceEnabled() {
        if (this.traceCapable) {
            return this.logger.mo1495k();
        }
        return this.logger.mo1498g();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str) {
        this.logger.mo1502b(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, str, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object obj) {
        if (isTraceEnabled()) {
            FormattingTuple m220a = MessageFormatter.m220a(str, obj);
            this.logger.mo1502b(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, m220a.m223a(), m220a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object obj, Object obj2) {
        if (isTraceEnabled()) {
            FormattingTuple m219a = MessageFormatter.m219a(str, obj, obj2);
            this.logger.mo1502b(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, m219a.m223a(), m219a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object... objArr) {
        if (isTraceEnabled()) {
            FormattingTuple m218a = MessageFormatter.m218a(str, objArr);
            this.logger.mo1502b(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, m218a.m223a(), m218a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Throwable th) {
        this.logger.mo1502b(FQCN, this.traceCapable ? Level.TRACE : Level.DEBUG, str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isDebugEnabled() {
        return this.logger.mo1498g();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str) {
        this.logger.mo1502b(FQCN, Level.DEBUG, str, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object obj) {
        if (this.logger.mo1498g()) {
            FormattingTuple m220a = MessageFormatter.m220a(str, obj);
            this.logger.mo1502b(FQCN, Level.DEBUG, m220a.m223a(), m220a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object obj, Object obj2) {
        if (this.logger.mo1498g()) {
            FormattingTuple m219a = MessageFormatter.m219a(str, obj, obj2);
            this.logger.mo1502b(FQCN, Level.DEBUG, m219a.m223a(), m219a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object... objArr) {
        if (this.logger.mo1498g()) {
            FormattingTuple m218a = MessageFormatter.m218a(str, objArr);
            this.logger.mo1502b(FQCN, Level.DEBUG, m218a.m223a(), m218a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Throwable th) {
        this.logger.mo1502b(FQCN, Level.DEBUG, str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isInfoEnabled() {
        return this.logger.mo1497h();
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str) {
        this.logger.mo1502b(FQCN, Level.INFO, str, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object obj) {
        if (this.logger.mo1497h()) {
            FormattingTuple m220a = MessageFormatter.m220a(str, obj);
            this.logger.mo1502b(FQCN, Level.INFO, m220a.m223a(), m220a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object obj, Object obj2) {
        if (this.logger.mo1497h()) {
            FormattingTuple m219a = MessageFormatter.m219a(str, obj, obj2);
            this.logger.mo1502b(FQCN, Level.INFO, m219a.m223a(), m219a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object... objArr) {
        if (this.logger.mo1497h()) {
            FormattingTuple m218a = MessageFormatter.m218a(str, objArr);
            this.logger.mo1502b(FQCN, Level.INFO, m218a.m223a(), m218a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Throwable th) {
        this.logger.mo1502b(FQCN, Level.INFO, str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isWarnEnabled() {
        return this.logger.mo1507a((Priority) Level.WARN);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str) {
        this.logger.mo1502b(FQCN, Level.WARN, str, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object obj) {
        if (this.logger.mo1507a((Priority) Level.WARN)) {
            FormattingTuple m220a = MessageFormatter.m220a(str, obj);
            this.logger.mo1502b(FQCN, Level.WARN, m220a.m223a(), m220a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object obj, Object obj2) {
        if (this.logger.mo1507a((Priority) Level.WARN)) {
            FormattingTuple m219a = MessageFormatter.m219a(str, obj, obj2);
            this.logger.mo1502b(FQCN, Level.WARN, m219a.m223a(), m219a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object... objArr) {
        if (this.logger.mo1507a((Priority) Level.WARN)) {
            FormattingTuple m218a = MessageFormatter.m218a(str, objArr);
            this.logger.mo1502b(FQCN, Level.WARN, m218a.m223a(), m218a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Throwable th) {
        this.logger.mo1502b(FQCN, Level.WARN, str, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isErrorEnabled() {
        return this.logger.mo1507a((Priority) Level.ERROR);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str) {
        this.logger.mo1502b(FQCN, Level.ERROR, str, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object obj) {
        if (this.logger.mo1507a((Priority) Level.ERROR)) {
            FormattingTuple m220a = MessageFormatter.m220a(str, obj);
            this.logger.mo1502b(FQCN, Level.ERROR, m220a.m223a(), m220a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object obj, Object obj2) {
        if (this.logger.mo1507a((Priority) Level.ERROR)) {
            FormattingTuple m219a = MessageFormatter.m219a(str, obj, obj2);
            this.logger.mo1502b(FQCN, Level.ERROR, m219a.m223a(), m219a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object... objArr) {
        if (this.logger.mo1507a((Priority) Level.ERROR)) {
            FormattingTuple m218a = MessageFormatter.m218a(str, objArr);
            this.logger.mo1502b(FQCN, Level.ERROR, m218a.m223a(), m218a.m222b());
        }
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Throwable th) {
        this.logger.mo1502b(FQCN, Level.ERROR, str, th);
    }

    public void log(Marker marker, String str, int i, String str2, Object[] objArr, Throwable th) {
        this.logger.mo1502b(str, m183a(i), str2, th);
    }

    /* renamed from: a */
    private Level m183a(int i) {
        if (i == 0) {
            return this.traceCapable ? Level.TRACE : Level.DEBUG;
        } else if (i != 10) {
            if (i != 20) {
                if (i != 30) {
                    if (i == 40) {
                        return Level.ERROR;
                    }
                    throw new IllegalStateException("Level number " + i + " is not recognized.");
                }
                return Level.WARN;
            }
            return Level.INFO;
        } else {
            return Level.DEBUG;
        }
    }

    public void log(LoggingEvent loggingEvent) {
        Level m183a = m183a(loggingEvent.mo239a().toInt());
        if (this.logger.mo1507a((Priority) m183a)) {
            this.logger.mo1506a(m182a(loggingEvent, m183a));
        }
    }

    /* renamed from: a */
    private org.apache.log4j.spi.LoggingEvent m182a(LoggingEvent loggingEvent, Level level) {
        FormattingTuple m219a = MessageFormatter.m219a(loggingEvent.mo231b(), (Object) loggingEvent.mo227d(), (Object) loggingEvent.mo225f());
        LocationInfo locationInfo = new LocationInfo("NA/SubstituteLogger", "NA/SubstituteLogger", "NA/SubstituteLogger", "0");
        Throwable m222b = m219a.m222b();
        return new org.apache.log4j.spi.LoggingEvent(FQCN, this.logger, loggingEvent.mo226e(), level, m219a.m223a(), loggingEvent.mo229c(), m222b != null ? new ThrowableInformation(m222b) : null, null, locationInfo, null);
    }
}
