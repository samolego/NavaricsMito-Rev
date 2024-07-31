package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.ArrayMap;
import android.support.p008v4.util.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.f */
/* loaded from: classes.dex */
public final class Options implements Key {

    /* renamed from: b */
    private final ArrayMap<Option<?>, Object> f1004b = new CachedHashCodeArrayMap();

    /* renamed from: a */
    public void m12011a(@NonNull Options options) {
        this.f1004b.putAll((SimpleArrayMap<? extends Option<?>, ? extends Object>) options.f1004b);
    }

    @NonNull
    /* renamed from: a */
    public <T> Options m12013a(@NonNull Option<T> option, @NonNull T t) {
        this.f1004b.put(option, t);
        return this;
    }

    @Nullable
    /* renamed from: a */
    public <T> T m12014a(@NonNull Option<T> option) {
        return this.f1004b.containsKey(option) ? (T) this.f1004b.get(option) : option.m12282a();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f1004b.equals(((Options) obj).f1004b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f1004b.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f1004b.size(); i++) {
            m12012a(this.f1004b.keyAt(i), this.f1004b.valueAt(i), messageDigest);
        }
    }

    public String toString() {
        return "Options{values=" + this.f1004b + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static <T> void m12012a(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.m12281a((Option<T>) obj, messageDigest);
    }
}
