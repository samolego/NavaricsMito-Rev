package org.apache.log4j.p125a;

import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.RendererSupport;

/* renamed from: org.apache.log4j.a.c */
/* loaded from: classes2.dex */
public class RendererMap {

    /* renamed from: b */
    static ObjectRenderer f11146b = new DefaultRenderer();

    /* renamed from: c */
    static Class f11147c;

    /* renamed from: a */
    Hashtable f11148a = new Hashtable();

    /* renamed from: a */
    public static void m1647a(RendererSupport rendererSupport, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Rendering class: [");
        stringBuffer.append(str2);
        stringBuffer.append("], Rendered class: [");
        stringBuffer.append(str);
        stringBuffer.append("].");
        LogLog.m1600a(stringBuffer.toString());
        Class cls = f11147c;
        if (cls == null) {
            cls = m1648a("org.apache.log4j.a.b");
            f11147c = cls;
        }
        ObjectRenderer objectRenderer = (ObjectRenderer) OptionConverter.m1590a(str2, cls, (Object) null);
        if (objectRenderer == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not instantiate renderer [");
            stringBuffer2.append(str2);
            stringBuffer2.append("].");
            LogLog.m1597b(stringBuffer2.toString());
            return;
        }
        try {
            rendererSupport.mo1485a(Loader.m1602b(str), objectRenderer);
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not find class [");
            stringBuffer3.append(str);
            stringBuffer3.append("].");
            LogLog.m1596b(stringBuffer3.toString(), e);
        }
    }

    /* renamed from: a */
    static Class m1648a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: a */
    public String m1649a(Object obj) {
        if (obj == null) {
            return null;
        }
        return m1651a((Class) obj.getClass()).mo1653a(obj);
    }

    /* renamed from: a */
    public ObjectRenderer m1651a(Class cls) {
        while (cls != null) {
            ObjectRenderer objectRenderer = (ObjectRenderer) this.f11148a.get(cls);
            if (objectRenderer != null) {
                return objectRenderer;
            }
            ObjectRenderer m1646b = m1646b(cls);
            if (m1646b != null) {
                return m1646b;
            }
            cls = cls.getSuperclass();
        }
        return f11146b;
    }

    /* renamed from: b */
    ObjectRenderer m1646b(Class cls) {
        ObjectRenderer objectRenderer = (ObjectRenderer) this.f11148a.get(cls);
        if (objectRenderer != null) {
            return objectRenderer;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            ObjectRenderer m1646b = m1646b(cls2);
            if (m1646b != null) {
                return m1646b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m1652a() {
        this.f11148a.clear();
    }

    /* renamed from: a */
    public void m1650a(Class cls, ObjectRenderer objectRenderer) {
        this.f11148a.put(cls, objectRenderer);
    }
}
