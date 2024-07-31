package io.reactivex.internal.util;

import io.reactivex.p085b.InterfaceC2829f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public enum ArrayListSupplier implements InterfaceC2829f<Object, List<Object>>, Callable<List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> InterfaceC2829f<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }

    @Override // io.reactivex.p085b.InterfaceC2829f
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }
}