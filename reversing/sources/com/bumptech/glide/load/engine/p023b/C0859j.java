package com.bumptech.glide.load.engine.p023b;

import android.support.annotation.NonNull;
import android.support.p008v4.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.p033a.FactoryPools;
import com.bumptech.glide.util.p033a.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.bumptech.glide.load.engine.b.j */
/* loaded from: classes.dex */
public class SafeKeyGenerator {

    /* renamed from: a */
    private final LruCache<Key, String> f845a = new LruCache<>(1000);

    /* renamed from: b */
    private final Pools.Pool<C0711a> f846b = FactoryPools.m11614b(10, new FactoryPools.InterfaceC0785a<C0711a>() { // from class: com.bumptech.glide.load.engine.b.j.1
        @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0785a
        /* renamed from: a */
        public C0711a mo11611b() {
            try {
                return new C0711a(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    /* renamed from: a */
    public String m12122a(Key key) {
        String m11588b;
        synchronized (this.f845a) {
            m11588b = this.f845a.m11588b(key);
        }
        if (m11588b == null) {
            m11588b = m12121b(key);
        }
        synchronized (this.f845a) {
            this.f845a.m11587b(key, m11588b);
        }
        return m11588b;
    }

    /* renamed from: b */
    private String m12121b(Key key) {
        C0711a c0711a = (C0711a) Preconditions.m11580a(this.f846b.acquire());
        try {
            key.mo7353a(c0711a.f848a);
            return C0791i.m11563a(c0711a.f848a.digest());
        } finally {
            this.f846b.release(c0711a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: com.bumptech.glide.load.engine.b.j$a */
    /* loaded from: classes.dex */
    public static final class C0711a implements FactoryPools.InterfaceC0787c {

        /* renamed from: a */
        final MessageDigest f848a;

        /* renamed from: b */
        private final StateVerifier f849b = StateVerifier.m11604a();

        C0711a(MessageDigest messageDigest) {
            this.f848a = messageDigest;
        }

        @Override // com.bumptech.glide.util.p033a.FactoryPools.InterfaceC0787c
        @NonNull
        /* renamed from: a_ */
        public StateVerifier mo11610a_() {
            return this.f849b;
        }
    }
}
