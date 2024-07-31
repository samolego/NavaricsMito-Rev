package com.bumptech.glide.p013d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC0612c;
import java.security.MessageDigest;

/* compiled from: EmptySignature.java */
/* renamed from: com.bumptech.glide.d.b, reason: use source file name */
/* loaded from: classes.dex */
public final class EmptySignature implements InterfaceC0612c {

    /* renamed from: b */
    private static final EmptySignature f425b = new EmptySignature();

    @Override // com.bumptech.glide.load.InterfaceC0612c
    /* renamed from: a */
    public void mo439a(@NonNull MessageDigest messageDigest) {
    }

    public String toString() {
        return "EmptySignature";
    }

    @NonNull
    /* renamed from: a */
    public static EmptySignature m438a() {
        return f425b;
    }

    private EmptySignature() {
    }
}