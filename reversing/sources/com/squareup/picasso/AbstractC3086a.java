package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.a */
/* loaded from: classes2.dex */
abstract class Action<T> {

    /* renamed from: a */
    final Picasso f6882a;

    /* renamed from: b */
    final C2365q f6883b;

    /* renamed from: c */
    final WeakReference<T> f6884c;

    /* renamed from: d */
    final boolean f6885d;

    /* renamed from: e */
    final int f6886e;

    /* renamed from: f */
    final int f6887f;

    /* renamed from: g */
    final int f6888g;

    /* renamed from: h */
    final Drawable f6889h;

    /* renamed from: i */
    final String f6890i;

    /* renamed from: j */
    final Object f6891j;

    /* renamed from: k */
    boolean f6892k;

    /* renamed from: l */
    boolean f6893l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo5619a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo5618a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    /* compiled from: Action.java */
    /* renamed from: com.squareup.picasso.a$a */
    /* loaded from: classes2.dex */
    static class C2343a<M> extends WeakReference<M> {

        /* renamed from: a */
        final Action f6894a;

        public C2343a(Action action, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f6894a = action;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Action(Picasso picasso, T t, C2365q c2365q, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f6882a = picasso;
        this.f6883b = c2365q;
        this.f6884c = t == null ? null : new C2343a(this, t, picasso.f6856i);
        this.f6886e = i;
        this.f6887f = i2;
        this.f6885d = z;
        this.f6888g = i3;
        this.f6889h = drawable;
        this.f6890i = str;
        this.f6891j = obj == null ? this : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5688b() {
        this.f6893l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public C2365q m5780c() {
        return this.f6883b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public T m5779d() {
        WeakReference<T> weakReference = this.f6884c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public String m5778e() {
        return this.f6890i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean m5777f() {
        return this.f6893l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m5776g() {
        return this.f6892k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public int m5775h() {
        return this.f6886e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public int m5774i() {
        return this.f6887f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public Picasso m5773j() {
        return this.f6882a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public Picasso.Priority m5772k() {
        return this.f6883b.f6994r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public Object m5771l() {
        return this.f6891j;
    }
}
