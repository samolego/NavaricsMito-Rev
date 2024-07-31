package com.navatics.miya.util;

/* compiled from: Util.java */
/* renamed from: com.navatics.miya.b.j */
/* loaded from: classes.dex */
public class Util {

    /* renamed from: a */
    public static final boolean f6070a = "Dalvik".equals(System.getProperty("java.vm.name"));

    /* renamed from: a */
    public static Class m6200a(Class cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Boolean.TYPE ? Boolean.class : cls == Byte.TYPE ? Byte.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Double.TYPE ? Double.class : cls == Short.TYPE ? Short.class : Void.class;
    }

    /* renamed from: b */
    public static String m6202b(Class cls) {
        if (cls == null) {
            return "null";
        }
        if (cls.isArray()) {
            Class m6204d = m6204d(cls);
            StringBuilder sb = new StringBuilder(16);
            int m6203c = m6203c(cls);
            for (int i = 0; i < m6203c; i++) {
                sb.append("[]");
            }
            return m6202b(m6204d) + ((Object) sb);
        }
        if (cls.isPrimitive() || cls == Object.class || cls == Boolean.class || cls == Byte.class || cls == Character.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class) {
            return cls.getSimpleName();
        }
        return cls.getName();
    }

    /* renamed from: c */
    public static int m6203c(Class cls) {
        int i = 0;
        for (Class<?> componentType = cls.getComponentType(); componentType != null; componentType = componentType.getComponentType()) {
            i++;
        }
        return i;
    }

    /* renamed from: d */
    public static Class m6204d(Class cls) {
        while (cls.getComponentType() != null) {
            cls = cls.getComponentType();
        }
        return cls;
    }

    /* renamed from: a */
    public static boolean m6201a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }
}