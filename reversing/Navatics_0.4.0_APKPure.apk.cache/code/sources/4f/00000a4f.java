package com.bumptech.glide.p013d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC0612c;
import com.bumptech.glide.util.C0780h;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* renamed from: com.bumptech.glide.d.c, reason: use source file name */
/* loaded from: classes.dex */
public final class ObjectKey implements InterfaceC0612c {

    /* renamed from: b */
    private final Object f426b;

    public ObjectKey(@NonNull Object obj) {
        this.f426b = C0780h.m1362a(obj);
    }

    public String toString() {
        return "ObjectKey{object=" + this.f426b + '}';
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f426b.equals(((ObjectKey) obj).f426b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    public int hashCode() {
        return this.f426b.hashCode();
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    /* renamed from: a */
    public void mo439a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f426b.toString().getBytes(f699a));
    }
}