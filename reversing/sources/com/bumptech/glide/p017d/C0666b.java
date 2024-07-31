package com.bumptech.glide.p017d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.d.b */
/* loaded from: classes.dex */
public final class EmptySignature implements Key {

    /* renamed from: b */
    private static final EmptySignature f421b = new EmptySignature();

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }

    @NonNull
    /* renamed from: a */
    public static EmptySignature m12526a() {
        return f421b;
    }

    private EmptySignature() {
    }
}
