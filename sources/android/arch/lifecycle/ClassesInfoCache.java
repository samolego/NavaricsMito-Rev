package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.arch.lifecycle.a */
/* loaded from: classes.dex */
class ClassesInfoCache {

    /* renamed from: a */
    static ClassesInfoCache f49a = new ClassesInfoCache();

    /* renamed from: b */
    private final Map<Class, C0013a> f50b = new HashMap();

    /* renamed from: c */
    private final Map<Class, Boolean> f51c = new HashMap();

    ClassesInfoCache() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m12895a(Class cls) {
        if (this.f51c.containsKey(cls)) {
            return this.f51c.get(cls).booleanValue();
        }
        Method[] m12891c = m12891c(cls);
        for (Method method : m12891c) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                m12894a(cls, m12891c);
                return true;
            }
        }
        this.f51c.put(cls, false);
        return false;
    }

    /* renamed from: c */
    private Method[] m12891c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public C0013a m12892b(Class cls) {
        C0013a c0013a = this.f50b.get(cls);
        return c0013a != null ? c0013a : m12894a(cls, null);
    }

    /* renamed from: a */
    private void m12893a(Map<C0014b, Lifecycle.Event> map, C0014b c0014b, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(c0014b);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(c0014b, event);
                return;
            }
            return;
        }
        Method method = c0014b.f55b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    /* renamed from: a */
    private C0013a m12894a(Class cls, @Nullable Method[] methodArr) {
        int i;
        C0013a m12892b;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (m12892b = m12892b(superclass)) != null) {
            hashMap.putAll(m12892b.f53b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0014b, Lifecycle.Event> entry : m12892b(cls2).f53b.entrySet()) {
                m12893a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m12891c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                Lifecycle.Event m12897a = onLifecycleEvent.m12897a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (m12897a != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m12893a(hashMap, new C0014b(i, method), m12897a, cls);
                z = true;
            }
        }
        C0013a c0013a = new C0013a(hashMap);
        this.f50b.put(cls, c0013a);
        this.f51c.put(cls, Boolean.valueOf(z));
        return c0013a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* renamed from: android.arch.lifecycle.a$a */
    /* loaded from: classes.dex */
    public static class C0013a {

        /* renamed from: a */
        final Map<Lifecycle.Event, List<C0014b>> f52a = new HashMap();

        /* renamed from: b */
        final Map<C0014b, Lifecycle.Event> f53b;

        C0013a(Map<C0014b, Lifecycle.Event> map) {
            this.f53b = map;
            for (Map.Entry<C0014b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<C0014b> list = this.f52a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f52a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m12890a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            m12889a(this.f52a.get(event), lifecycleOwner, event, obj);
            m12889a(this.f52a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }

        /* renamed from: a */
        private static void m12889a(List<C0014b> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m12888a(lifecycleOwner, event, obj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    /* renamed from: android.arch.lifecycle.a$b */
    /* loaded from: classes.dex */
    public static class C0014b {

        /* renamed from: a */
        final int f54a;

        /* renamed from: b */
        final Method f55b;

        C0014b(int i, Method method) {
            this.f54a = i;
            this.f55b = method;
            this.f55b.setAccessible(true);
        }

        /* renamed from: a */
        void m12888a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                switch (this.f54a) {
                    case 0:
                        this.f55b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f55b.invoke(obj, lifecycleOwner);
                        return;
                    case 2:
                        this.f55b.invoke(obj, lifecycleOwner, event);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0014b c0014b = (C0014b) obj;
            return this.f54a == c0014b.f54a && this.f55b.getName().equals(c0014b.f55b.getName());
        }

        public int hashCode() {
            return (this.f54a * 31) + this.f55b.getName().hashCode();
        }
    }
}
