package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform.java */
/* renamed from: retrofit2.j */
/* loaded from: classes2.dex */
public class C3198j {

    /* renamed from: a */
    private static final C3198j f12664a = m92c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo89a(Method method) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public Executor mo90b() {
        return null;
    }

    C3198j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C3198j m93a() {
        return f12664a;
    }

    /* renamed from: c */
    private static C3198j m92c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new C3199a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new C3201b();
        } catch (ClassNotFoundException unused2) {
            return new C3198j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public CallAdapter.AbstractC3170a mo91a(@Nullable Executor executor) {
        if (executor != null) {
            return new ExecutorCallAdapterFactory(executor);
        }
        return DefaultCallAdapterFactory.f12611a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public Object mo88a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    @IgnoreJRERequirement
    /* renamed from: retrofit2.j$b */
    /* loaded from: classes2.dex */
    public static class C3201b extends C3198j {
        C3201b() {
        }

        @Override // retrofit2.C3198j
        /* renamed from: a */
        boolean mo89a(Method method) {
            return method.isDefault();
        }

        @Override // retrofit2.C3198j
        /* renamed from: a */
        Object mo88a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* renamed from: retrofit2.j$a */
    /* loaded from: classes2.dex */
    public static class C3199a extends C3198j {
        C3199a() {
        }

        @Override // retrofit2.C3198j
        /* renamed from: b */
        public Executor mo90b() {
            return new ExecutorC3200a();
        }

        @Override // retrofit2.C3198j
        /* renamed from: a */
        CallAdapter.AbstractC3170a mo91a(@Nullable Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            return new ExecutorCallAdapterFactory(executor);
        }

        /* compiled from: Platform.java */
        /* renamed from: retrofit2.j$a$a */
        /* loaded from: classes2.dex */
        static class ExecutorC3200a implements Executor {

            /* renamed from: a */
            private final Handler f12665a = new Handler(Looper.getMainLooper());

            ExecutorC3200a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f12665a.post(runnable);
            }
        }
    }
}
