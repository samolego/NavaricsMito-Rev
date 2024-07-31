package com.bumptech.glide.load.engine.p022a;

import android.graphics.Bitmap;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.util.C0791i;

/* renamed from: com.bumptech.glide.load.engine.a.c */
/* loaded from: classes.dex */
class AttributeStrategy implements LruPoolStrategy {

    /* renamed from: a */
    private final C0691b f762a = new C0691b();

    /* renamed from: b */
    private final GroupedLinkedMap<C0690a, Bitmap> f763b = new GroupedLinkedMap<>();

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: a */
    public void mo12161a(Bitmap bitmap) {
        this.f763b.m12215a(this.f762a.m12223a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: a */
    public Bitmap mo12164a(int i, int i2, Bitmap.Config config) {
        return this.f763b.m12216a((GroupedLinkedMap<C0690a, Bitmap>) this.f762a.m12223a(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: a */
    public Bitmap mo12165a() {
        return this.f763b.m12218a();
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: b */
    public String mo12156b(Bitmap bitmap) {
        return m12226d(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: b */
    public String mo12159b(int i, int i2, Bitmap.Config config) {
        return m12227c(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.p022a.LruPoolStrategy
    /* renamed from: c */
    public int mo12155c(Bitmap bitmap) {
        return C0791i.m11568a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f763b;
    }

    /* renamed from: d */
    private static String m12226d(Bitmap bitmap) {
        return m12227c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    /* renamed from: c */
    static String m12227c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a.c$b */
    /* loaded from: classes.dex */
    static class C0691b extends BaseKeyPool<C0690a> {
        C0691b() {
        }

        /* renamed from: a */
        C0690a m12223a(int i, int i2, Bitmap.Config config) {
            C0690a c = m12221c();
            c.m12225a(i, i2, config);
            return c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.p022a.BaseKeyPool
        /* renamed from: a */
        public C0690a mo12150b() {
            return new C0690a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.a.c$a */
    /* loaded from: classes.dex */
    public static class C0690a implements Poolable {

        /* renamed from: a */
        private final C0691b f764a;

        /* renamed from: b */
        private int f765b;

        /* renamed from: c */
        private int f766c;

        /* renamed from: d */
        private Bitmap.Config f767d;

        public C0690a(C0691b c0691b) {
            this.f764a = c0691b;
        }

        /* renamed from: a */
        public void m12225a(int i, int i2, Bitmap.Config config) {
            this.f765b = i;
            this.f766c = i2;
            this.f767d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0690a) {
                C0690a c0690a = (C0690a) obj;
                return this.f765b == c0690a.f765b && this.f766c == c0690a.f766c && this.f767d == c0690a.f767d;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f765b * 31) + this.f766c) * 31;
            Bitmap.Config config = this.f767d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.m12227c(this.f765b, this.f766c, this.f767d);
        }

        @Override // com.bumptech.glide.load.engine.p022a.Poolable
        /* renamed from: a */
        public void mo12154a() {
            this.f764a.m12222a(this);
        }
    }
}
