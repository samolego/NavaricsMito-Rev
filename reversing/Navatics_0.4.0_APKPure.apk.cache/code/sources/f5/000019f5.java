package com.navatics.app.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC0612c;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: UserIconSignature.java */
/* renamed from: com.navatics.app.utils.q, reason: use source file name */
/* loaded from: classes.dex */
public class UserIconSignature implements InterfaceC0612c {

    /* renamed from: b */
    private long f5166b;

    public UserIconSignature(long j) {
        this.f5166b = j;
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    /* renamed from: a */
    public void mo439a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(64).putLong(this.f5166b).array());
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    public int hashCode() {
        long j = this.f5166b;
        return (int) (j ^ (j >>> 32));
    }

    @Override // com.bumptech.glide.load.InterfaceC0612c
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof UserIconSignature) && this.f5166b == ((UserIconSignature) obj).f5166b;
    }
}