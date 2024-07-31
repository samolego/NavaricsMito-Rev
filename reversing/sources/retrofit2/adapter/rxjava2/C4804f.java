package retrofit2.adapter.rxjava2;

import io.reactivex.AbstractC2901p;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.InterfaceC3169b;

/* renamed from: retrofit2.adapter.rxjava2.f */
/* loaded from: classes2.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {

    /* renamed from: a */
    private final Type f12600a;
    @Nullable

    /* renamed from: b */
    private final AbstractC2901p f12601b;

    /* renamed from: c */
    private final boolean f12602c;

    /* renamed from: d */
    private final boolean f12603d;

    /* renamed from: e */
    private final boolean f12604e;

    /* renamed from: f */
    private final boolean f12605f;

    /* renamed from: g */
    private final boolean f12606g;

    /* renamed from: h */
    private final boolean f12607h;

    /* renamed from: i */
    private final boolean f12608i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJava2CallAdapter(Type type, @Nullable AbstractC2901p abstractC2901p, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f12600a = type;
        this.f12601b = abstractC2901p;
        this.f12602c = z;
        this.f12603d = z2;
        this.f12604e = z3;
        this.f12605f = z4;
        this.f12606g = z5;
        this.f12607h = z6;
        this.f12608i = z7;
    }

    @Override // retrofit2.CallAdapter
    /* renamed from: a */
    public Type mo147a() {
        return this.f12600a;
    }

    @Override // retrofit2.CallAdapter
    /* renamed from: a */
    public Object mo146a(InterfaceC3169b<R> interfaceC3169b) {
        Observable callExecuteObservable;
        Observable bodyObservable;
        if (this.f12602c) {
            callExecuteObservable = new CallEnqueueObservable(interfaceC3169b);
        } else {
            callExecuteObservable = new CallExecuteObservable(interfaceC3169b);
        }
        if (this.f12603d) {
            bodyObservable = new ResultObservable(callExecuteObservable);
        } else {
            bodyObservable = this.f12604e ? new BodyObservable(callExecuteObservable) : callExecuteObservable;
        }
        AbstractC2901p abstractC2901p = this.f12601b;
        if (abstractC2901p != null) {
            bodyObservable = bodyObservable.m3075b(abstractC2901p);
        }
        if (this.f12605f) {
            return bodyObservable.m3109a(BackpressureStrategy.LATEST);
        }
        if (this.f12606g) {
            return bodyObservable.m3065e();
        }
        if (this.f12607h) {
            return bodyObservable.m3068d();
        }
        return this.f12608i ? bodyObservable.m3074c() : bodyObservable;
    }
}
