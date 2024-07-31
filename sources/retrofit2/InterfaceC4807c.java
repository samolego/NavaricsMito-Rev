package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* renamed from: retrofit2.c */
/* loaded from: classes2.dex */
public interface CallAdapter<R, T> {
    /* renamed from: a */
    T mo146a(InterfaceC3169b<R> interfaceC3169b);

    /* renamed from: a */
    Type mo147a();

    /* compiled from: CallAdapter.java */
    /* renamed from: retrofit2.c$a */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC3170a {
        @Nullable
        /* renamed from: a */
        public abstract CallAdapter<?, ?> mo148a(Type type, Annotation[] annotationArr, Retrofit retrofit);

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public static Type m155a(int i, ParameterizedType parameterizedType) {
            return C3208o.m27a(i, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public static Class<?> m154a(Type type) {
            return C3208o.m23a(type);
        }
    }
}
