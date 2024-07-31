package com.bumptech.glide.request.p032b;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.p032b.Transition;

/* renamed from: com.bumptech.glide.request.b.a */
/* loaded from: classes.dex */
public class NoTransition<R> implements Transition<R> {

    /* renamed from: a */
    static final NoTransition<?> f1235a = new NoTransition<>();

    /* renamed from: b */
    private static final TransitionFactory<?> f1236b = new C0777a();

    @Override // com.bumptech.glide.request.p032b.Transition
    /* renamed from: a */
    public boolean mo11706a(Object obj, Transition.InterfaceC0778a interfaceC0778a) {
        return false;
    }

    /* compiled from: NoTransition.java */
    /* renamed from: com.bumptech.glide.request.b.a$a */
    /* loaded from: classes.dex */
    public static class C0777a<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.p032b.TransitionFactory
        /* renamed from: a */
        public Transition<R> mo11705a(DataSource dataSource, boolean z) {
            return NoTransition.f1235a;
        }
    }

    /* renamed from: a */
    public static <R> TransitionFactory<R> m11707a() {
        return (TransitionFactory<R>) f1236b;
    }
}
