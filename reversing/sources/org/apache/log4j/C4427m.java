package org.apache.log4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.ThreadLocalMap;

/* renamed from: org.apache.log4j.m */
/* loaded from: classes2.dex */
public class MDCFriend {
    /* renamed from: a */
    public static void m1550a() {
        if (MDC.f11245a.f11248c == null) {
            MDC.f11245a.f11248c = new ThreadLocalMap();
            MDC.f11245a.f11247b = false;
            m1549a(MDC.f11245a);
        }
    }

    /* renamed from: a */
    private static void m1549a(MDC mdc) {
        try {
            Method method = ThreadLocal.class.getMethod("remove", new Class[0]);
            Field declaredField = MDC.class.getDeclaredField("e");
            declaredField.setAccessible(true);
            declaredField.set(mdc, method);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException unused) {
        }
    }
}
