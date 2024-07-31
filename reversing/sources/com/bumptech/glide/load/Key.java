package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.c */
/* loaded from: classes.dex */
public interface Key {

    /* renamed from: a */
    public static final Charset f695a = Charset.forName("UTF-8");

    /* renamed from: a */
    void mo7353a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
