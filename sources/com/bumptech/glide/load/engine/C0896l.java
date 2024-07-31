package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.l */
/* loaded from: classes.dex */
class EngineKey implements Key {

    /* renamed from: b */
    private final Object f949b;

    /* renamed from: c */
    private final int f950c;

    /* renamed from: d */
    private final int f951d;

    /* renamed from: e */
    private final Class<?> f952e;

    /* renamed from: f */
    private final Class<?> f953f;

    /* renamed from: g */
    private final Key f954g;

    /* renamed from: h */
    private final Map<Class<?>, Transformation<?>> f955h;

    /* renamed from: i */
    private final Options f956i;

    /* renamed from: j */
    private int f957j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f949b = Preconditions.m11580a(obj);
        this.f954g = (Key) Preconditions.m11579a(key, "Signature must not be null");
        this.f950c = i;
        this.f951d = i2;
        this.f955h = (Map) Preconditions.m11580a(map);
        this.f952e = (Class) Preconditions.m11579a(cls, "Resource class must not be null");
        this.f953f = (Class) Preconditions.m11579a(cls2, "Transcode class must not be null");
        this.f956i = (Options) Preconditions.m11580a(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof EngineKey) {
            EngineKey engineKey = (EngineKey) obj;
            return this.f949b.equals(engineKey.f949b) && this.f954g.equals(engineKey.f954g) && this.f951d == engineKey.f951d && this.f950c == engineKey.f950c && this.f955h.equals(engineKey.f955h) && this.f952e.equals(engineKey.f952e) && this.f953f.equals(engineKey.f953f) && this.f956i.equals(engineKey.f956i);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f957j == 0) {
            this.f957j = this.f949b.hashCode();
            this.f957j = (this.f957j * 31) + this.f954g.hashCode();
            this.f957j = (this.f957j * 31) + this.f950c;
            this.f957j = (this.f957j * 31) + this.f951d;
            this.f957j = (this.f957j * 31) + this.f955h.hashCode();
            this.f957j = (this.f957j * 31) + this.f952e.hashCode();
            this.f957j = (this.f957j * 31) + this.f953f.hashCode();
            this.f957j = (this.f957j * 31) + this.f956i.hashCode();
        }
        return this.f957j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f949b + ", width=" + this.f950c + ", height=" + this.f951d + ", resourceClass=" + this.f952e + ", transcodeClass=" + this.f953f + ", signature=" + this.f954g + ", hashCode=" + this.f957j + ", transformations=" + this.f955h + ", options=" + this.f956i + '}';
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
