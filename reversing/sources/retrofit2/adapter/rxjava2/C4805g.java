package retrofit2.adapter.rxjava2;

import io.reactivex.AbstractC2901p;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.C3204l;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/* renamed from: retrofit2.adapter.rxjava2.g */
/* loaded from: classes2.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.AbstractC3170a {
    @Nullable

    /* renamed from: a */
    private final AbstractC2901p f12609a;

    /* renamed from: b */
    private final boolean f12610b;

    /* renamed from: a */
    public static RxJava2CallAdapterFactory m156a() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    private RxJava2CallAdapterFactory(@Nullable AbstractC2901p abstractC2901p, boolean z) {
        this.f12609a = abstractC2901p;
        this.f12610b = z;
    }

    @Override // retrofit2.CallAdapter.AbstractC3170a
    /* renamed from: a */
    public CallAdapter<?, ?> mo148a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> a = m154a(type);
        if (a == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.f12609a, this.f12610b, false, true, false, false, false, true);
        }
        boolean z3 = a == Flowable.class;
        boolean z4 = a == Single.class;
        boolean z5 = a == Maybe.class;
        if (a == Observable.class || z3 || z4 || z5) {
            if (!(type instanceof ParameterizedType)) {
                String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
                throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
            }
            Type a2 = m155a(0, (ParameterizedType) type);
            Class<?> a3 = m154a(a2);
            if (a3 == C3204l.class) {
                if (!(a2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
                type2 = m155a(0, (ParameterizedType) a2);
                z = false;
                z2 = false;
            } else if (a3 != C3167d.class) {
                type2 = a2;
                z = false;
                z2 = true;
            } else if (!(a2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            } else {
                type2 = m155a(0, (ParameterizedType) a2);
                z = true;
                z2 = false;
            }
            return new RxJava2CallAdapter(type2, this.f12609a, this.f12610b, z, z2, z3, z4, z5, false);
        }
        return null;
    }
}
