package org.apache.log4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.ThreadLocalMap;

/* renamed from: org.apache.log4j.l */
/* loaded from: classes2.dex */
public class MDC {

    /* renamed from: a */
    static final MDC f11245a = new MDC();

    /* renamed from: d */
    static Class f11246d;

    /* renamed from: b */
    boolean f11247b = Loader.m1605a();

    /* renamed from: c */
    Object f11248c;

    /* renamed from: e */
    private Method f11249e;

    private MDC() {
        Class cls;
        if (!this.f11247b) {
            this.f11248c = new ThreadLocalMap();
        }
        try {
            if (f11246d == null) {
                cls = m1553c("java.lang.ThreadLocal");
                f11246d = cls;
            } else {
                cls = f11246d;
            }
            this.f11249e = cls.getMethod("remove", null);
        } catch (NoSuchMethodException unused) {
        }
    }

    /* renamed from: c */
    static Class m1553c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: a */
    public static void m1558a(String str, Object obj) {
        MDC mdc = f11245a;
        if (mdc != null) {
            mdc.m1555b(str, obj);
        }
    }

    /* renamed from: a */
    public static Object m1559a(String str) {
        MDC mdc = f11245a;
        if (mdc != null) {
            return mdc.m1552d(str);
        }
        return null;
    }

    /* renamed from: b */
    public static void m1556b(String str) {
        MDC mdc = f11245a;
        if (mdc != null) {
            mdc.m1551e(str);
        }
    }

    /* renamed from: a */
    public static Hashtable m1560a() {
        MDC mdc = f11245a;
        if (mdc != null) {
            return mdc.m1557b();
        }
        return null;
    }

    /* renamed from: b */
    private void m1555b(String str, Object obj) {
        Object obj2;
        if (this.f11247b || (obj2 = this.f11248c) == null) {
            return;
        }
        Hashtable hashtable = (Hashtable) ((ThreadLocalMap) obj2).get();
        if (hashtable == null) {
            hashtable = new Hashtable(7);
            ((ThreadLocalMap) this.f11248c).set(hashtable);
        }
        hashtable.put(str, obj);
    }

    /* renamed from: d */
    private Object m1552d(String str) {
        Object obj;
        Hashtable hashtable;
        if (this.f11247b || (obj = this.f11248c) == null || (hashtable = (Hashtable) ((ThreadLocalMap) obj).get()) == null || str == null) {
            return null;
        }
        return hashtable.get(str);
    }

    /* renamed from: e */
    private void m1551e(String str) {
        Object obj;
        Hashtable hashtable;
        if (this.f11247b || (obj = this.f11248c) == null || (hashtable = (Hashtable) ((ThreadLocalMap) obj).get()) == null) {
            return;
        }
        hashtable.remove(str);
        if (hashtable.isEmpty()) {
            m1554c();
        }
    }

    /* renamed from: b */
    private Hashtable m1557b() {
        Object obj;
        if (this.f11247b || (obj = this.f11248c) == null) {
            return null;
        }
        return (Hashtable) ((ThreadLocalMap) obj).get();
    }

    /* renamed from: c */
    private void m1554c() {
        Object obj;
        if (this.f11247b || (obj = this.f11248c) == null) {
            return;
        }
        Hashtable hashtable = (Hashtable) ((ThreadLocalMap) obj).get();
        if (hashtable != null) {
            hashtable.clear();
        }
        Method method = this.f11249e;
        if (method != null) {
            try {
                method.invoke(this.f11248c, null);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
