package org.apache.log4j.spi;

import org.apache.log4j.Appender;
import org.apache.log4j.C3044k;
import org.apache.log4j.Category;
import org.apache.log4j.Level;

/* renamed from: org.apache.log4j.spi.j */
/* loaded from: classes2.dex */
public final class NOPLoggerRepository implements LoggerRepository {
    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public void mo1490a(Level level) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public void mo1489a(Category category) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public void mo1488a(Category category, Appender appender) {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public boolean mo1493a(int i) {
        return true;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: e */
    public void mo1486e() {
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public Level mo1494a() {
        return Level.OFF;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public C3044k mo1492a(String str) {
        return new NOPLogger(this, str);
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public C3044k mo1491a(String str, LoggerFactory loggerFactory) {
        return new NOPLogger(this, str);
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: d */
    public C3044k mo1487d() {
        return new NOPLogger(this, "root");
    }
}
