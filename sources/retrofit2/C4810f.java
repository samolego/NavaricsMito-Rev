package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: retrofit2.f */
/* loaded from: classes2.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.AbstractC3170a {

    /* renamed from: a */
    static final CallAdapter.AbstractC3170a f12611a = new DefaultCallAdapterFactory();

    DefaultCallAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.AbstractC3170a
    /* renamed from: a */
    public CallAdapter<?, ?> mo148a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (m154a(type) != InterfaceC3169b.class) {
            return null;
        }
        final Type m10e = C3208o.m10e(type);
        return new CallAdapter<Object, InterfaceC3169b<?>>() { // from class: retrofit2.f.1
            @Override // retrofit2.CallAdapter
            /* renamed from: b */
            public InterfaceC3169b<Object> mo146a(InterfaceC3169b<Object> interfaceC3169b) {
                return interfaceC3169b;
            }

            @Override // retrofit2.CallAdapter
            /* renamed from: a */
            public Type mo147a() {
                return m10e;
            }
        };
    }
}
