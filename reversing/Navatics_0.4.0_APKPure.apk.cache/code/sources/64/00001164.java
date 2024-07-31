package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class zzapj {
    /* renamed from: bl */
    public static zzapj m3284bl() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new zzapj() { // from class: com.google.android.gms.internal.zzapj.1
                @Override // com.google.android.gms.internal.zzapj
                public <T> T zzf(Class<T> cls2) throws Exception {
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new zzapj() { // from class: com.google.android.gms.internal.zzapj.2
                        @Override // com.google.android.gms.internal.zzapj
                        public <T> T zzf(Class<T> cls2) throws Exception {
                            return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
                        }
                    };
                } catch (Exception unused2) {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new zzapj() { // from class: com.google.android.gms.internal.zzapj.3
                        @Override // com.google.android.gms.internal.zzapj
                        public <T> T zzf(Class<T> cls2) throws Exception {
                            return (T) declaredMethod3.invoke(null, cls2, Object.class);
                        }
                    };
                }
            } catch (Exception unused3) {
                return new zzapj() { // from class: com.google.android.gms.internal.zzapj.4
                    @Override // com.google.android.gms.internal.zzapj
                    public <T> T zzf(Class<T> cls2) {
                        String valueOf = String.valueOf(cls2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
                        sb.append("Cannot allocate ");
                        sb.append(valueOf);
                        throw new UnsupportedOperationException(sb.toString());
                    }
                };
            }
        }
    }

    public abstract <T> T zzf(Class<T> cls) throws Exception;
}