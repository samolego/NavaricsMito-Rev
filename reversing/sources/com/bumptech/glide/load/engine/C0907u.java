package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LruCache;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.u */
/* loaded from: classes.dex */
final class ResourceCacheKey implements Key {

    /* renamed from: b */
    private static final LruCache<Class<?>, byte[]> f986b = new LruCache<>(50);

    /* renamed from: c */
    private final ArrayPool f987c;

    /* renamed from: d */
    private final Key f988d;

    /* renamed from: e */
    private final Key f989e;

    /* renamed from: f */
    private final int f990f;

    /* renamed from: g */
    private final int f991g;

    /* renamed from: h */
    private final Class<?> f992h;

    /* renamed from: i */
    private final Options f993i;

    /* renamed from: j */
    private final Transformation<?> f994j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f987c = arrayPool;
        this.f988d = key;
        this.f989e = key2;
        this.f990f = i;
        this.f991g = i2;
        this.f994j = transformation;
        this.f992h = cls;
        this.f993i = options;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ResourceCacheKey) {
            ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
            return this.f991g == resourceCacheKey.f991g && this.f990f == resourceCacheKey.f990f && C0791i.m11566a(this.f994j, resourceCacheKey.f994j) && this.f992h.equals(resourceCacheKey.f992h) && this.f988d.equals(resourceCacheKey.f988d) && this.f989e.equals(resourceCacheKey.f989e) && this.f993i.equals(resourceCacheKey.f993i);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = (((((this.f988d.hashCode() * 31) + this.f989e.hashCode()) * 31) + this.f990f) * 31) + this.f991g;
        Transformation<?> transformation = this.f994j;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f992h.hashCode()) * 31) + this.f993i.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f987c.mo12192b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f990f).putInt(this.f991g).array();
        this.f989e.mo7353a(messageDigest);
        this.f988d.mo7353a(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f994j;
        if (transformation != null) {
            transformation.mo7353a(messageDigest);
        }
        this.f993i.mo7353a(messageDigest);
        messageDigest.update(m12025a());
        this.f987c.mo12195a((ArrayPool) bArr);
    }

    /* renamed from: a */
    private byte[] m12025a() {
        byte[] m11588b = f986b.m11588b(this.f992h);
        if (m11588b == null) {
            byte[] bytes = this.f992h.getName().getBytes(f695a);
            f986b.m11587b(this.f992h, bytes);
            return bytes;
        }
        return m11588b;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f988d + ", signature=" + this.f989e + ", width=" + this.f990f + ", height=" + this.f991g + ", decodedResourceClass=" + this.f992h + ", transformation='" + this.f994j + "', options=" + this.f993i + '}';
    }
}
