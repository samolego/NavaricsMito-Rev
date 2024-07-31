package butterknife;

import android.app.Activity;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ButterKnife {
    @VisibleForTesting

    /* renamed from: a */
    static final Map<Class<?>, Constructor<? extends Unbinder>> f132a = new LinkedHashMap();

    /* renamed from: b */
    private static boolean f133b = false;

    /* loaded from: classes.dex */
    public interface Action<T extends View> {
    }

    /* loaded from: classes.dex */
    public interface Setter<T extends View, V> {
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    @UiThread
    @NonNull
    /* renamed from: a */
    public static Unbinder m12805a(@NonNull Activity activity) {
        return m12802b(activity, activity.getWindow().getDecorView());
    }

    @UiThread
    @NonNull
    /* renamed from: a */
    public static Unbinder m12803a(@NonNull Object obj, @NonNull View view) {
        return m12802b(obj, view);
    }

    /* renamed from: b */
    private static Unbinder m12802b(@NonNull Object obj, @NonNull View view) {
        Class<?> cls = obj.getClass();
        if (f133b) {
            Log.d("ButterKnife", "Looking up binding for " + cls.getName());
        }
        Constructor<? extends Unbinder> m12804a = m12804a(cls);
        if (m12804a == null) {
            return Unbinder.f137a;
        }
        try {
            return m12804a.newInstance(obj, view);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + m12804a, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + m12804a, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unable to create binding instance.", cause);
        }
    }

    @UiThread
    @CheckResult
    @Nullable
    /* renamed from: a */
    private static Constructor<? extends Unbinder> m12804a(Class<?> cls) {
        Constructor<? extends Unbinder> m12804a;
        Constructor<? extends Unbinder> constructor = f132a.get(cls);
        if (constructor != null) {
            if (f133b) {
                Log.d("ButterKnife", "HIT: Cached in binding map.");
            }
            return constructor;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.")) {
            if (f133b) {
                Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
                return null;
            }
            return null;
        }
        try {
            ClassLoader classLoader = cls.getClassLoader();
            m12804a = classLoader.loadClass(name + "_ViewBinding").getConstructor(cls, View.class);
            if (f133b) {
                Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
            }
        } catch (ClassNotFoundException unused) {
            if (f133b) {
                Log.d("ButterKnife", "Not found. Trying superclass " + cls.getSuperclass().getName());
            }
            m12804a = m12804a(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to find binding constructor for " + name, e);
        }
        f132a.put(cls, m12804a);
        return m12804a;
    }
}
