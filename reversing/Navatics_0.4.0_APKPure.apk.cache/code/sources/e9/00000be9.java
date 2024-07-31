package com.bumptech.glide.util.p029a;

import android.support.annotation.NonNull;

/* compiled from: StateVerifier.java */
/* renamed from: com.bumptech.glide.util.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0773c {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo1341a(boolean z);

    /* renamed from: b */
    public abstract void mo1342b();

    @NonNull
    /* renamed from: a */
    public static AbstractC0773c m1340a() {
        return new a();
    }

    private AbstractC0773c() {
    }

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.a.c$a */
    /* loaded from: classes.dex */
    private static class a extends AbstractC0773c {

        /* renamed from: a */
        private volatile boolean f1295a;

        a() {
            super();
        }

        @Override // com.bumptech.glide.util.p029a.AbstractC0773c
        /* renamed from: b */
        public void mo1342b() {
            if (this.f1295a) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.p029a.AbstractC0773c
        /* renamed from: a */
        public void mo1341a(boolean z) {
            this.f1295a = z;
        }
    }
}