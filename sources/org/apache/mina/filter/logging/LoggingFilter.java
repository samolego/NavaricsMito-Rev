package org.apache.mina.filter.logging;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.filter.logging.a */
/* loaded from: classes2.dex */
public class LoggingFilter extends IoFilterAdapter {

    /* renamed from: a */
    private final String f11653a;

    /* renamed from: b */
    private final InterfaceC3153b f11654b;

    /* renamed from: c */
    private LogLevel f11655c;

    /* renamed from: d */
    private LogLevel f11656d;

    /* renamed from: e */
    private LogLevel f11657e;

    /* renamed from: f */
    private LogLevel f11658f;

    /* renamed from: g */
    private LogLevel f11659g;

    /* renamed from: h */
    private LogLevel f11660h;

    /* renamed from: i */
    private LogLevel f11661i;

    public LoggingFilter() {
        this(LoggingFilter.class.getName());
    }

    public LoggingFilter(String str) {
        this.f11655c = LogLevel.WARN;
        this.f11656d = LogLevel.INFO;
        this.f11657e = LogLevel.INFO;
        this.f11658f = LogLevel.INFO;
        this.f11659g = LogLevel.INFO;
        this.f11660h = LogLevel.INFO;
        this.f11661i = LogLevel.INFO;
        if (str == null) {
            this.f11653a = LoggingFilter.class.getName();
        } else {
            this.f11653a = str;
        }
        this.f11654b = C3154c.m260a(this.f11653a);
    }

    /* renamed from: a */
    private void m812a(LogLevel logLevel, String str, Throwable th) {
        switch (logLevel) {
            case TRACE:
                this.f11654b.trace(str, th);
                return;
            case DEBUG:
                this.f11654b.debug(str, th);
                return;
            case INFO:
                this.f11654b.info(str, th);
                return;
            case WARN:
                this.f11654b.warn(str, th);
                return;
            case ERROR:
                this.f11654b.error(str, th);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m813a(LogLevel logLevel, String str, Object obj) {
        switch (logLevel) {
            case TRACE:
                this.f11654b.trace(str, obj);
                return;
            case DEBUG:
                this.f11654b.debug(str, obj);
                return;
            case INFO:
                this.f11654b.info(str, obj);
                return;
            case WARN:
                this.f11654b.warn(str, obj);
                return;
            case ERROR:
                this.f11654b.error(str, obj);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m814a(LogLevel logLevel, String str) {
        switch (logLevel) {
            case TRACE:
                this.f11654b.trace(str);
                return;
            case DEBUG:
                this.f11654b.debug(str);
                return;
            case INFO:
                this.f11654b.info(str);
                return;
            case WARN:
                this.f11654b.warn(str);
                return;
            case ERROR:
                this.f11654b.error(str);
                return;
            default:
                return;
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo816a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) throws Exception {
        m812a(this.f11655c, "EXCEPTION :", th);
        interfaceC3073a.mo1113a(ioSession, th);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception {
        m813a(this.f11657e, "RECEIVED: {}", obj);
        interfaceC3073a.mo1114a(ioSession, obj);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        m813a(this.f11656d, "SENT: {}", interfaceC3088b.mo954c().mo836b());
        interfaceC3073a.mo1111a(ioSession, interfaceC3088b);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo818a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        m814a(this.f11658f, "CREATED");
        interfaceC3073a.mo1115a(ioSession);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: c */
    public void mo810c(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        m814a(this.f11659g, "OPENED");
        interfaceC3073a.mo1110b(ioSession);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo815a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, IdleStatus idleStatus) throws Exception {
        m814a(this.f11660h, "IDLE");
        interfaceC3073a.mo1112a(ioSession, idleStatus);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        m814a(this.f11661i, "CLOSED");
        interfaceC3073a.mo1108c(ioSession);
    }
}
