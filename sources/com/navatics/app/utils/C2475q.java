package com.navatics.app.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.navatics.app.utils.q */
/* loaded from: classes.dex */
public class UserIconSignature implements Key {

    /* renamed from: b */
    private long f5144b;

    public UserIconSignature(long j) {
        this.f5144b = j;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(64).putLong(this.f5144b).array());
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        long j = this.f5144b;
        return (int) (j ^ (j >>> 32));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof UserIconSignature) && this.f5144b == ((UserIconSignature) obj).f5144b;
    }
}
