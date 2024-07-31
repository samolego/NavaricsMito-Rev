package okhttp3.internal.p096e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* renamed from: okhttp3.internal.e.e, reason: use source file name */
/* loaded from: classes2.dex */
class OptionalMethod<T> {

    /* renamed from: a */
    private final Class<?> f10336a;

    /* renamed from: b */
    private final String f10337b;

    /* renamed from: c */
    private final Class[] f10338c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f10336a = cls;
        this.f10337b = str;
        this.f10338c = clsArr;
    }

    /* renamed from: a */
    public boolean m10103a(T t) {
        return m10100a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object m10102a(T t, Object... objArr) throws InvocationTargetException {
        Method m10100a = m10100a(t.getClass());
        if (m10100a == null) {
            return null;
        }
        try {
            return m10100a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object m10104b(T t, Object... objArr) {
        try {
            return m10102a(t, objArr);
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
    public Object m10105c(T t, Object... objArr) throws InvocationTargetException {
        Method m10100a = m10100a(t.getClass());
        if (m10100a == null) {
            throw new AssertionError("Method " + this.f10337b + " not supported for object " + t);
        }
        try {
            return m10100a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + m10100a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m10106d(T t, Object... objArr) {
        try {
            return m10105c(t, objArr);
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
    private Method m10100a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f10337b;
        if (str == null) {
            return null;
        }
        Method m10101a = m10101a(cls, str, this.f10338c);
        if (m10101a == null || (cls2 = this.f10336a) == null || cls2.isAssignableFrom(m10101a.getReturnType())) {
            return m10101a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m10101a(Class<?> cls, String str, Class[] clsArr) {
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