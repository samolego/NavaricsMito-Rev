package org.apache.log4j;

/* compiled from: Logger.java */
/* renamed from: org.apache.log4j.k */
/* loaded from: classes2.dex */
public class Logger extends C4376c {

    /* renamed from: i */
    static Class f11243i;

    /* renamed from: j */
    private static final String f11244j;

    static {
        Class cls = f11243i;
        if (cls == null) {
            cls = m1559c("org.apache.log4j.k");
            f11243i = cls;
        }
        f11244j = cls.getName();
    }

    /* renamed from: c */
    static Class m1559c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Logger(String str) {
        super(str);
    }

    /* renamed from: b */
    public static Logger m1560b(String str) {
        return C4404j.m1563a(str);
    }

    /* renamed from: a */
    public static Logger m1561a(Class cls) {
        return C4404j.m1563a(cls.getName());
    }

    /* renamed from: j */
    public static Logger m1558j() {
        return C4404j.m1562b();
    }

    /* renamed from: k */
    public boolean mo1492k() {
        if (this.f11162e.mo1490a(5000)) {
            return false;
        }
        return Level.TRACE.isGreaterOrEqual(mo1498c());
    }
}
