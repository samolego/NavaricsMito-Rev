package org.apache.log4j;

import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.a */
/* loaded from: classes2.dex */
public interface Appender {
    /* renamed from: a */
    void mo1478a();

    /* renamed from: a */
    void mo1645a(String str);

    /* renamed from: a */
    void mo1644a(Layout layout);

    /* renamed from: a */
    void mo1475a(ErrorHandler errorHandler);

    /* renamed from: a */
    void mo1642a(Filter filter);

    /* renamed from: b */
    void mo1641b(LoggingEvent loggingEvent);

    /* renamed from: b */
    boolean mo1473b();

    /* renamed from: d */
    String mo1640d();
}
