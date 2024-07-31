package io.reactivex.p093a.p094a;

import io.reactivex.AbstractC2901p;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.p096b.Function;
import java.util.concurrent.Callable;

/* renamed from: io.reactivex.a.a.a */
/* loaded from: classes2.dex */
public final class RxAndroidPlugins {

    /* renamed from: a */
    private static volatile Function<Callable<AbstractC2901p>, AbstractC2901p> f9602a;

    /* renamed from: b */
    private static volatile Function<AbstractC2901p, AbstractC2901p> f9603b;

    /* renamed from: a */
    public static AbstractC2901p m3252a(Callable<AbstractC2901p> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function<Callable<AbstractC2901p>, AbstractC2901p> function = f9602a;
        if (function == null) {
            return m3251b(callable);
        }
        return m3254a(function, callable);
    }

    /* renamed from: a */
    public static AbstractC2901p m3253a(AbstractC2901p abstractC2901p) {
        if (abstractC2901p == null) {
            throw new NullPointerException("scheduler == null");
        }
        Function<AbstractC2901p, AbstractC2901p> function = f9603b;
        return function == null ? abstractC2901p : (AbstractC2901p) m3255a(function, abstractC2901p);
    }

    /* renamed from: b */
    static AbstractC2901p m3251b(Callable<AbstractC2901p> callable) {
        try {
            AbstractC2901p call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.m3208a(th);
        }
    }

    /* renamed from: a */
    static AbstractC2901p m3254a(Function<Callable<AbstractC2901p>, AbstractC2901p> function, Callable<AbstractC2901p> callable) {
        AbstractC2901p abstractC2901p = (AbstractC2901p) m3255a((Function<Callable<AbstractC2901p>, Object>) function, callable);
        if (abstractC2901p != null) {
            return abstractC2901p;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: a */
    static <T, R> R m3255a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.m3208a(th);
        }
    }
}
