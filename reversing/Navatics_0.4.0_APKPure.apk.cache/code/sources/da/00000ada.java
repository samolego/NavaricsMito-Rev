package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key.java */
/* renamed from: com.bumptech.glide.load.c */
/* loaded from: classes.dex */
public interface InterfaceC0612c {

    /* renamed from: a */
    public static final Charset f699a = Charset.forName("UTF-8");

    /* renamed from: a */
    void mo439a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}