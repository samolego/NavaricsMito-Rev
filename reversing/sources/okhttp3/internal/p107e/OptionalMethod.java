package okhttp3.internal.p107e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: okhttp3.internal.e.e */
/* loaded from: classes2.dex */
class OptionalMethod<T> {

    /* renamed from: a */
    private final Class<?> f10295a;

    /* renamed from: b */
    private final String f10296b;

    /* renamed from: c */
    private final Class[] f10297c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f10295a = cls;
        this.f10296b = str;
        this.f10297c = clsArr;
    }

    /* renamed from: a */
    public boolean m2782a(T t) {
        return m2784a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object m2781a(T t, Object... objArr) throws InvocationTargetException {
        Method m2784a = m2784a(t.getClass());
        if (m2784a == null) {
            return null;
        }
        try {
            return m2784a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object m2780b(T t, Object... objArr) {
        try {
            return m2781a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object m2779c(T t, Object... objArr) throws InvocationTargetException {
        Method m2784a = m2784a(t.getClass());
        if (m2784a == null) {
            throw new AssertionError("Method " + this.f10296b + " not supported for object " + t);
        }
        try {
            return m2784a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + m2784a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m2778d(T t, Object... objArr) {
        try {
            return m2779c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m2784a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f10296b;
        if (str != null) {
            Method m2783a = m2783a(cls, str, this.f10297c);
            if (m2783a == null || (cls2 = this.f10295a) == null || cls2.isAssignableFrom(m2783a.getReturnType())) {
                return m2783a;
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m2783a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
