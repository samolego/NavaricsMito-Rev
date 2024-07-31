package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: retrofit2.g */
/* loaded from: classes2.dex */
public final class ExecutorCallAdapterFactory extends CallAdapter.AbstractC3170a {

    /* renamed from: a */
    final Executor f12614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorCallAdapterFactory(Executor executor) {
        this.f12614a = executor;
    }

    @Override // retrofit2.CallAdapter.AbstractC3170a
    /* renamed from: a */
    public CallAdapter<?, ?> mo148a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (m154a(type) != InterfaceC3169b.class) {
            return null;
        }
        final Type m10e = C3208o.m10e(type);
        return new CallAdapter<Object, InterfaceC3169b<?>>() { // from class: retrofit2.g.1
            @Override // retrofit2.CallAdapter
            /* renamed from: a */
            public Type mo147a() {
                return m10e;
            }

            @Override // retrofit2.CallAdapter
            /* renamed from: b */
            public InterfaceC3169b<Object> mo146a(InterfaceC3169b<Object> interfaceC3169b) {
                return new C3175a(ExecutorCallAdapterFactory.this.f12614a, interfaceC3169b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExecutorCallAdapterFactory.java */
    /* renamed from: retrofit2.g$a */
    /* loaded from: classes2.dex */
    public static final class C3175a<T> implements InterfaceC3169b<T> {

        /* renamed from: a */
        final Executor f12617a;

        /* renamed from: b */
        final InterfaceC3169b<T> f12618b;

        C3175a(Executor executor, InterfaceC3169b<T> interfaceC3169b) {
            this.f12617a = executor;
            this.f12618b = interfaceC3169b;
        }

        @Override // retrofit2.InterfaceC3169b
        /* renamed from: a */
        public void mo140a(final InterfaceC3171d<T> interfaceC3171d) {
            C3208o.m25a(interfaceC3171d, "callback == null");
            this.f12618b.mo140a(new InterfaceC3171d<T>() { // from class: retrofit2.g.a.1
                @Override // retrofit2.InterfaceC3171d
                /* renamed from: a */
                public void mo143a(InterfaceC3169b<T> interfaceC3169b, final C3204l<T> c3204l) {
                    C3175a.this.f12617a.execute(new Runnable() { // from class: retrofit2.g.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (C3175a.this.f12618b.mo138c()) {
                                interfaceC3171d.mo144a(C3175a.this, new IOException("Canceled"));
                            } else {
                                interfaceC3171d.mo143a(C3175a.this, c3204l);
                            }
                        }
                    });
                }

                @Override // retrofit2.InterfaceC3171d
                /* renamed from: a */
                public void mo144a(InterfaceC3169b<T> interfaceC3169b, final Throwable th) {
                    C3175a.this.f12617a.execute(new Runnable() { // from class: retrofit2.g.a.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            interfaceC3171d.mo144a(C3175a.this, th);
                        }
                    });
                }
            });
        }

        @Override // retrofit2.InterfaceC3169b
        /* renamed from: a */
        public C3204l<T> mo142a() throws IOException {
            return this.f12618b.mo142a();
        }

        @Override // retrofit2.InterfaceC3169b
        /* renamed from: b */
        public void mo139b() {
            this.f12618b.mo139b();
        }

        @Override // retrofit2.InterfaceC3169b
        /* renamed from: c */
        public boolean mo138c() {
            return this.f12618b.mo138c();
        }

        @Override // retrofit2.InterfaceC3169b
        /* renamed from: d */
        public InterfaceC3169b<T> clone() {
            return new C3175a(this.f12617a, this.f12618b.mo137d());
        }
    }
}
