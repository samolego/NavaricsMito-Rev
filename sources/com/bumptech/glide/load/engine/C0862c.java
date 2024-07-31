package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.c */
/* loaded from: classes.dex */
final class DataCacheKey implements Key {

    /* renamed from: b */
    private final Key f850b;

    /* renamed from: c */
    private final Key f851c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.f850b = key;
        this.f851c = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            return this.f850b.equals(dataCacheKey.f850b) && this.f851c.equals(dataCacheKey.f851c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f850b.hashCode() * 31) + this.f851c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f850b + ", signature=" + this.f851c + '}';
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        this.f850b.mo7353a(messageDigest);
        this.f851c.mo7353a(messageDigest);
    }
}
