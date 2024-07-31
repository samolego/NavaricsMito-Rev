package com.bumptech.glide.util.p033a;

import android.support.annotation.NonNull;

/* renamed from: com.bumptech.glide.util.a.c */
/* loaded from: classes.dex */
public abstract class StateVerifier {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo11603a(boolean z);

    /* renamed from: b */
    public abstract void mo11602b();

    @NonNull
    /* renamed from: a */
    public static StateVerifier m11604a() {
        return new C0790a();
    }

    private StateVerifier() {
    }

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.a.c$a */
    /* loaded from: classes.dex */
    private static class C0790a extends StateVerifier {

        /* renamed from: a */
        private volatile boolean f1291a;

        C0790a() {
            super();
        }

        @Override // com.bumptech.glide.util.p033a.StateVerifier
        /* renamed from: b */
        public void mo11602b() {
            if (this.f1291a) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.p033a.StateVerifier
        /* renamed from: a */
        public void mo11603a(boolean z) {
            this.f1291a = z;
        }
    }
}
