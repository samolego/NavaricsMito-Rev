package org.slf4j.impl;

import org.apache.log4j.Level;
import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.C3156g;

/* renamed from: org.slf4j.impl.c */
/* loaded from: classes2.dex */
public class StaticLoggerBinder {

    /* renamed from: d */
    private final ILoggerFactory f12570d = new Log4jLoggerFactory();

    /* renamed from: b */
    private static final StaticLoggerBinder f12568b = new StaticLoggerBinder();

    /* renamed from: a */
    public static String f12567a = "1.6.99";

    /* renamed from: c */
    private static final String f12569c = Log4jLoggerFactory.class.getName();

    /* renamed from: a */
    public static final StaticLoggerBinder m178a() {
        return f12568b;
    }

    private StaticLoggerBinder() {
        try {
            Level level = Level.TRACE;
        } catch (NoSuchFieldError unused) {
            C3156g.m185c("This version of SLF4J requires log4j version 1.2.12 or later. See also http://www.slf4j.org/codes.html#log4j_version");
        }
    }

    /* renamed from: b */
    public ILoggerFactory m177b() {
        return this.f12570d;
    }

    /* renamed from: c */
    public String m176c() {
        return f12569c;
    }
}
