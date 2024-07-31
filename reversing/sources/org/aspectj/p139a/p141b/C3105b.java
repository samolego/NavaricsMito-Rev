package org.aspectj.p139a.p141b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.p142a.MethodSignature;
import org.aspectj.lang.p142a.SourceLocation;
import org.aspectj.p139a.p141b.JoinPointImpl;
import org.slf4j.Marker;

/* compiled from: Factory.java */
/* renamed from: org.aspectj.a.b.b */
/* loaded from: classes2.dex */
public final class C3105b {

    /* renamed from: f */
    static Class f11672f;

    /* renamed from: i */
    private static Object[] f11675i;

    /* renamed from: a */
    Class f11676a;

    /* renamed from: b */
    ClassLoader f11677b;

    /* renamed from: c */
    String f11678c;

    /* renamed from: d */
    int f11679d = 0;

    /* renamed from: g */
    private static final Class[] f11673g = new Class[0];

    /* renamed from: h */
    private static final String[] f11674h = new String[0];

    /* renamed from: e */
    static Hashtable f11671e = new Hashtable();

    static {
        f11671e.put("void", Void.TYPE);
        f11671e.put("boolean", Boolean.TYPE);
        f11671e.put("byte", Byte.TYPE);
        f11671e.put("char", Character.TYPE);
        f11671e.put("short", Short.TYPE);
        f11671e.put("int", Integer.TYPE);
        f11671e.put("long", Long.TYPE);
        f11671e.put("float", Float.TYPE);
        f11671e.put("double", Double.TYPE);
        f11675i = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Class m797a(String str, ClassLoader classLoader) {
        if (str.equals(Marker.ANY_MARKER)) {
            return null;
        }
        Class cls = (Class) f11671e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f11672f;
            if (cls2 == null) {
                Class m798a = m798a("java.lang.ClassNotFoundException");
                f11672f = m798a;
                return m798a;
            }
            return cls2;
        }
    }

    /* renamed from: a */
    static Class m798a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public C3105b(String str, Class cls) {
        this.f11678c = str;
        this.f11676a = cls;
        this.f11677b = cls.getClassLoader();
    }

    /* renamed from: a */
    public JoinPoint.InterfaceC3109a m794a(String str, Signature signature, int i) {
        int i2 = this.f11679d;
        this.f11679d = i2 + 1;
        return new JoinPointImpl.C3106a(i2, str, signature, m799a(i, -1));
    }

    /* renamed from: a */
    public static JoinPoint m793a(JoinPoint.InterfaceC3109a interfaceC3109a, Object obj, Object obj2) {
        return new JoinPointImpl(interfaceC3109a, obj, obj2, f11675i);
    }

    /* renamed from: a */
    public static JoinPoint m792a(JoinPoint.InterfaceC3109a interfaceC3109a, Object obj, Object obj2, Object obj3) {
        return new JoinPointImpl(interfaceC3109a, obj, obj2, new Object[]{obj3});
    }

    /* renamed from: a */
    public MethodSignature m795a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return m796a(str, str2, m797a(str3, this.f11677b), str4, str5, str6, str7);
    }

    /* renamed from: a */
    public MethodSignature m796a(String str, String str2, Class cls, String str3, String str4, String str5, String str6) {
        int parseInt = Integer.parseInt(str, 16);
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = m797a(stringTokenizer.nextToken(), this.f11677b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str4, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str5, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = m797a(stringTokenizer3.nextToken(), this.f11677b);
        }
        return new MethodSignatureImpl(parseInt, str2, cls, clsArr, strArr, clsArr2, m797a(str6, this.f11677b));
    }

    /* renamed from: a */
    public SourceLocation m799a(int i, int i2) {
        return new SourceLocationImpl(this.f11676a, this.f11678c, i);
    }
}
