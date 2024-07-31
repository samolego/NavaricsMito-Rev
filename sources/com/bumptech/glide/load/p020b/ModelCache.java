package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LruCache;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.b.m */
/* loaded from: classes.dex */
public class ModelCache<A, B> {

    /* renamed from: a */
    private final LruCache<C0655a<A>, B> f647a;

    public ModelCache() {
        this(250L);
    }

    public ModelCache(long j) {
        this.f647a = new LruCache<C0655a<A>, B>(j) { // from class: com.bumptech.glide.load.b.m.1
            @Override // com.bumptech.glide.util.LruCache
            /* renamed from: a */
            protected /* bridge */ /* synthetic */ void mo11590a(@NonNull Object obj, @Nullable Object obj2) {
                m12325a((C0655a) ((C0655a) obj), (C0655a<A>) obj2);
            }

            /* renamed from: a */
            protected void m12325a(@NonNull C0655a<A> c0655a, @Nullable B b) {
                c0655a.m12324a();
            }
        };
    }

    @Nullable
    /* renamed from: a */
    public B m12327a(A a, int i, int i2) {
        C0655a<A> m12323a = C0655a.m12323a(a, i, i2);
        B m11588b = this.f647a.m11588b(m12323a);
        m12323a.m12324a();
        return m11588b;
    }

    /* renamed from: a */
    public void m12326a(A a, int i, int i2, B b) {
        this.f647a.m11587b(C0655a.m12323a(a, i, i2), b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.b.m$a */
    /* loaded from: classes.dex */
    public static final class C0655a<A> {

        /* renamed from: a */
        private static final Queue<C0655a<?>> f649a = C0791i.m11572a(0);

        /* renamed from: b */
        private int f650b;

        /* renamed from: c */
        private int f651c;

        /* renamed from: d */
        private A f652d;

        /* renamed from: a */
        static <A> C0655a<A> m12323a(A a, int i, int i2) {
            C0655a<A> c0655a;
            synchronized (f649a) {
                c0655a = (C0655a<A>) f649a.poll();
            }
            if (c0655a == null) {
                c0655a = new C0655a<>();
            }
            c0655a.m12322b(a, i, i2);
            return c0655a;
        }

        private C0655a() {
        }

        /* renamed from: b */
        private void m12322b(A a, int i, int i2) {
            this.f652d = a;
            this.f651c = i;
            this.f650b = i2;
        }

        /* renamed from: a */
        public void m12324a() {
            synchronized (f649a) {
                f649a.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0655a) {
                C0655a c0655a = (C0655a) obj;
                return this.f651c == c0655a.f651c && this.f650b == c0655a.f650b && this.f652d.equals(c0655a.f652d);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f650b * 31) + this.f651c) * 31) + this.f652d.hashCode();
        }
    }
}
