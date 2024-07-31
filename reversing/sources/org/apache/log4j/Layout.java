package org.apache.log4j;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

/* renamed from: org.apache.log4j.i */
/* loaded from: classes2.dex */
public abstract class Layout implements OptionHandler {

    /* renamed from: a */
    public static final String f11239a = System.getProperty("line.separator");

    /* renamed from: b */
    public static final int f11240b = f11239a.length();

    /* renamed from: a */
    public String m1570a() {
        return null;
    }

    /* renamed from: a */
    public abstract String mo1545a(LoggingEvent loggingEvent);

    /* renamed from: b */
    public String m1569b() {
        return null;
    }

    /* renamed from: c */
    public abstract boolean mo1544c();
}
