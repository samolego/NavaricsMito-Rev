package com.bumptech.glide.p017d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.d.c */
/* loaded from: classes.dex */
public final class ObjectKey implements Key {

    /* renamed from: b */
    private final Object f422b;

    public ObjectKey(@NonNull Object obj) {
        this.f422b = Preconditions.m11580a(obj);
    }

    public String toString() {
        return "ObjectKey{object=" + this.f422b + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f422b.equals(((ObjectKey) obj).f422b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f422b.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f422b.toString().getBytes(f695a));
    }
}
