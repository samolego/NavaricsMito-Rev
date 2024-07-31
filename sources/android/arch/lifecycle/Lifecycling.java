package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.lifecycle.g */
/* loaded from: classes.dex */
public class Lifecycling {

    /* renamed from: a */
    private static Map<Class, Integer> f67a = new HashMap();

    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> f68b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public static GenericLifecycleObserver m12866a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m12863b(cls) == 2) {
            List<Constructor<? extends GeneratedAdapter>> list = f68b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(m12864a(list.get(0), obj));
            }
            GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
            for (int i = 0; i < list.size(); i++) {
                generatedAdapterArr[i] = m12864a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    /* renamed from: a */
    private static GeneratedAdapter m12864a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    /* renamed from: a */
    private static Constructor<? extends GeneratedAdapter> m12867a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String m12865a = m12865a(canonicalName);
            if (!name.isEmpty()) {
                m12865a = name + "." + m12865a;
            }
            Constructor declaredConstructor = Class.forName(m12865a).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private static int m12863b(Class<?> cls) {
        if (f67a.containsKey(cls)) {
            return f67a.get(cls).intValue();
        }
        int m12862c = m12862c(cls);
        f67a.put(cls, Integer.valueOf(m12862c));
        return m12862c;
    }

    /* renamed from: c */
    private static int m12862c(Class<?> cls) {
        Class<?>[] interfaces;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> m12867a = m12867a(cls);
        if (m12867a != null) {
            f68b.put(cls, Collections.singletonList(m12867a));
            return 2;
        } else if (ClassesInfoCache.f49a.m12895a(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (m12861d(superclass)) {
                if (m12863b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f68b.get(superclass));
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (m12861d(cls2)) {
                    if (m12863b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f68b.get(cls2));
                }
            }
            if (arrayList != null) {
                f68b.put(cls, arrayList);
                return 2;
            }
            return 1;
        }
    }

    /* renamed from: d */
    private static boolean m12861d(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    /* renamed from: a */
    public static String m12865a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
