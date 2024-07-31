package com.bumptech.glide.load.engine;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC0612c;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* renamed from: com.bumptech.glide.load.engine.c, reason: use source file name */
/* loaded from: classes.dex */
final class DataCacheKey implements InterfaceC0612c {

    /* renamed from: b */
    private final InterfaceC0612c f854b;

    /* renamed from: c */
    private final InterfaceC0612c f855c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(InterfaceC0612c interfaceC0612c, InterfaceC0612c interfaceC0612c2) {
        this.f854b = interfaceC0612c;
        this.f855c = interfaceC0612c2;
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        return this.f854b.equals(dataCacheKey.f854b) && this.f855c.equals(dataCacheKey.f855c);
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    public int hashCode() {
        return (this.f854b.hashCode() * 31) + this.f855c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f854b + ", signature=" + this.f855c + '}';
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    /* renamed from: a */
    public void mo439a(@NonNull MessageDigest messageDigest) {
        this.f854b.mo439a(messageDigest);
        this.f855c.mo439a(messageDigest);
    }
}