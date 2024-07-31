package org.apache.log4j.spi;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.C3044k;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;

/* renamed from: org.apache.log4j.spi.i */
/* loaded from: classes2.dex */
public final class NOPLogger extends C3044k {
    /* renamed from: a */
    void m1512a() {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public void mo1511a(Object obj) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public void mo1510a(Object obj, Throwable th) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public void mo1509a(ResourceBundle resourceBundle) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public void mo1482a(Level level) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public void mo1508a(Appender appender) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public void mo1506a(LoggingEvent loggingEvent) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: a */
    public boolean mo1507a(Priority priority) {
        return false;
    }

    @Override // org.apache.log4j.Category
    /* renamed from: b */
    public void mo1504b(Object obj) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: b */
    public void mo1503b(Object obj, Throwable th) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: b */
    public void mo1502b(String str, Priority priority, Object obj, Throwable th) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: c */
    public void mo1500c(Object obj) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: d */
    public void mo1499d(Object obj) {
    }

    @Override // org.apache.log4j.Category
    /* renamed from: g */
    public boolean mo1498g() {
        return false;
    }

    @Override // org.apache.log4j.Category
    /* renamed from: h */
    public boolean mo1497h() {
        return false;
    }

    @Override // org.apache.log4j.Category
    /* renamed from: i */
    public void mo1496i() {
    }

    @Override // org.apache.log4j.C3044k
    /* renamed from: k */
    public boolean mo1495k() {
        return false;
    }

    public NOPLogger(NOPLoggerRepository nOPLoggerRepository, String str) {
        super(str);
        this.f11162e = nOPLoggerRepository;
        this.f11159b = Level.OFF;
        this.f11160c = this;
    }

    @Override // org.apache.log4j.Category
    /* renamed from: b */
    public Enumeration mo1505b() {
        return new Vector().elements();
    }

    @Override // org.apache.log4j.Category
    /* renamed from: c */
    public Level mo1501c() {
        return Level.OFF;
    }
}
