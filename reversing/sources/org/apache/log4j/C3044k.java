package org.apache.log4j;

/* compiled from: Logger.java */
/* renamed from: org.apache.log4j.k */
/* loaded from: classes2.dex */
public class C3044k extends Category {

    /* renamed from: i */
    static Class f11243i;

    /* renamed from: j */
    private static final String f11244j;

    static {
        Class cls = f11243i;
        if (cls == null) {
            cls = m1562c("org.apache.log4j.k");
            f11243i = cls;
        }
        f11244j = cls.getName();
    }

    /* renamed from: c */
    static Class m1562c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C3044k(String str) {
        super(str);
    }

    /* renamed from: b */
    public static C3044k m1563b(String str) {
        return LogManager.m1566a(str);
    }

    /* renamed from: a */
    public static C3044k m1564a(Class cls) {
        return LogManager.m1566a(cls.getName());
    }

    /* renamed from: j */
    public static C3044k m1561j() {
        return LogManager.m1565b();
    }

    /* renamed from: k */
    public boolean mo1495k() {
        if (this.f11162e.mo1493a(5000)) {
            return false;
        }
        return Level.TRACE.isGreaterOrEqual(mo1501c());
    }
}
