package org.slf4j.event;

import java.util.Queue;
import org.slf4j.InterfaceC3153b;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* renamed from: org.slf4j.event.a */
/* loaded from: classes2.dex */
public class EventRecodingLogger implements InterfaceC3153b {

    /* renamed from: a */
    String f12538a;

    /* renamed from: b */
    SubstituteLogger f12539b;

    /* renamed from: c */
    Queue<SubstituteLoggingEvent> f12540c;

    @Override // org.slf4j.InterfaceC3153b
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.InterfaceC3153b
    public boolean isWarnEnabled() {
        return true;
    }

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.f12539b = substituteLogger;
        this.f12538a = substituteLogger.getName();
        this.f12540c = queue;
    }

    @Override // org.slf4j.InterfaceC3153b
    public String getName() {
        return this.f12538a;
    }

    /* renamed from: a */
    private void m241a(Level level, String str, Object[] objArr, Throwable th) {
        m240a(level, null, str, objArr, th);
    }

    /* renamed from: a */
    private void m240a(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.m238a(System.currentTimeMillis());
        substituteLoggingEvent.m234a(level);
        substituteLoggingEvent.m233a(this.f12539b);
        substituteLoggingEvent.m237a(this.f12538a);
        substituteLoggingEvent.m235a(marker);
        substituteLoggingEvent.m230b(str);
        substituteLoggingEvent.m232a(objArr);
        substituteLoggingEvent.m236a(th);
        substituteLoggingEvent.m228c(Thread.currentThread().getName());
        this.f12540c.add(substituteLoggingEvent);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str) {
        m241a(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object obj) {
        m241a(Level.TRACE, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object obj, Object obj2) {
        m241a(Level.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Object... objArr) {
        m241a(Level.TRACE, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void trace(String str, Throwable th) {
        m241a(Level.TRACE, str, null, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str) {
        m241a(Level.TRACE, str, null, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object obj) {
        m241a(Level.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object obj, Object obj2) {
        m241a(Level.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Object... objArr) {
        m241a(Level.DEBUG, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void debug(String str, Throwable th) {
        m241a(Level.DEBUG, str, null, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str) {
        m241a(Level.INFO, str, null, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object obj) {
        m241a(Level.INFO, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object obj, Object obj2) {
        m241a(Level.INFO, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Object... objArr) {
        m241a(Level.INFO, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void info(String str, Throwable th) {
        m241a(Level.INFO, str, null, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str) {
        m241a(Level.WARN, str, null, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object obj) {
        m241a(Level.WARN, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object obj, Object obj2) {
        m241a(Level.WARN, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Object... objArr) {
        m241a(Level.WARN, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void warn(String str, Throwable th) {
        m241a(Level.WARN, str, null, th);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str) {
        m241a(Level.ERROR, str, null, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object obj) {
        m241a(Level.ERROR, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object obj, Object obj2) {
        m241a(Level.ERROR, str, new Object[]{obj, obj2}, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Object... objArr) {
        m241a(Level.ERROR, str, objArr, null);
    }

    @Override // org.slf4j.InterfaceC3153b
    public void error(String str, Throwable th) {
        m241a(Level.ERROR, str, null, th);
    }
}
