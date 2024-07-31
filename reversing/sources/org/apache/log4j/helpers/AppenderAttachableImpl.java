package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.helpers.a */
/* loaded from: classes2.dex */
public class AppenderAttachableImpl implements AppenderAttachable {

    /* renamed from: a */
    protected Vector f11192a;

    /* renamed from: a */
    public void m1611a(Appender appender) {
        if (appender == null) {
            return;
        }
        if (this.f11192a == null) {
            this.f11192a = new Vector(1);
        }
        if (this.f11192a.contains(appender)) {
            return;
        }
        this.f11192a.addElement(appender);
    }

    /* renamed from: a */
    public int m1610a(LoggingEvent loggingEvent) {
        Vector vector = this.f11192a;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((Appender) this.f11192a.elementAt(i)).mo1641b(loggingEvent);
            }
            return size;
        }
        return 0;
    }

    /* renamed from: a */
    public Enumeration m1612a() {
        Vector vector = this.f11192a;
        if (vector == null) {
            return null;
        }
        return vector.elements();
    }

    /* renamed from: b */
    public void m1609b() {
        Vector vector = this.f11192a;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((Appender) this.f11192a.elementAt(i)).mo1478a();
            }
            this.f11192a.removeAllElements();
            this.f11192a = null;
        }
    }
}
