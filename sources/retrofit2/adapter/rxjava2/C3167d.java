package retrofit2.adapter.rxjava2;

import javax.annotation.Nullable;
import retrofit2.C3204l;

/* compiled from: Result.java */
/* renamed from: retrofit2.adapter.rxjava2.d */
/* loaded from: classes2.dex */
public final class C3167d<T> {
    @Nullable

    /* renamed from: a */
    private final C3204l<T> f12596a;
    @Nullable

    /* renamed from: b */
    private final Throwable f12597b;

    /* renamed from: a */
    public static <T> C3167d<T> m160a(Throwable th) {
        if (th == null) {
            throw new NullPointerException("error == null");
        }
        return new C3167d<>(null, th);
    }

    /* renamed from: a */
    public static <T> C3167d<T> m159a(C3204l<T> c3204l) {
        if (c3204l == null) {
            throw new NullPointerException("response == null");
        }
        return new C3167d<>(c3204l, null);
    }

    private C3167d(@Nullable C3204l<T> c3204l, @Nullable Throwable th) {
        this.f12596a = c3204l;
        this.f12597b = th;
    }
}
