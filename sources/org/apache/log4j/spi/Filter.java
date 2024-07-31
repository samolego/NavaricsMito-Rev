package org.apache.log4j.spi;

/* renamed from: org.apache.log4j.spi.e */
/* loaded from: classes2.dex */
public abstract class Filter implements OptionHandler {

    /* renamed from: a */
    public Filter f11286a;

    /* renamed from: a */
    public abstract int m1517a(LoggingEvent loggingEvent);

    @Override // org.apache.log4j.spi.OptionHandler
    /* renamed from: e */
    public void mo1470e() {
    }

    /* renamed from: a */
    public void m1516a(Filter filter) {
        this.f11286a = filter;
    }

    /* renamed from: a */
    public Filter m1518a() {
        return this.f11286a;
    }
}
