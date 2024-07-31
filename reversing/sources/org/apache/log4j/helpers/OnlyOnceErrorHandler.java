package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import org.apache.log4j.Appender;
import org.apache.log4j.C3044k;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.helpers.g */
/* loaded from: classes2.dex */
public class OnlyOnceErrorHandler implements ErrorHandler {

    /* renamed from: a */
    final String f11204a = "log4j warning: ";

    /* renamed from: b */
    final String f11205b = "log4j error: ";

    /* renamed from: c */
    boolean f11206c = true;

    @Override // org.apache.log4j.spi.ErrorHandler
    /* renamed from: a */
    public void mo1520a(Appender appender) {
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    /* renamed from: a */
    public void mo1519a(C3044k c3044k) {
    }

    @Override // org.apache.log4j.spi.OptionHandler
    /* renamed from: e */
    public void mo1470e() {
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    /* renamed from: a */
    public void mo1521a(String str, Exception exc, int i) {
        m1592a(str, exc, i, null);
    }

    /* renamed from: a */
    public void m1592a(String str, Exception exc, int i, LoggingEvent loggingEvent) {
        if ((exc instanceof InterruptedIOException) || (exc instanceof InterruptedException)) {
            Thread.currentThread().interrupt();
        }
        if (this.f11206c) {
            LogLog.m1596b(str, exc);
            this.f11206c = false;
        }
    }

    @Override // org.apache.log4j.spi.ErrorHandler
    /* renamed from: a */
    public void mo1522a(String str) {
        if (this.f11206c) {
            LogLog.m1597b(str);
            this.f11206c = false;
        }
    }
}
