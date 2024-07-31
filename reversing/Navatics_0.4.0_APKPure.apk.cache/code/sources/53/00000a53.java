package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface GifDecoder {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface GifDecodeStatus {
    }

    /* renamed from: com.bumptech.glide.gifdecoder.GifDecoder$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0554a {
        @NonNull
        /* renamed from: a */
        Bitmap mo482a(int i, int i2, @NonNull Bitmap.Config config);

        /* renamed from: a */
        void mo483a(@NonNull Bitmap bitmap);

        /* renamed from: a */
        void mo484a(@NonNull byte[] bArr);

        /* renamed from: a */
        void mo485a(@NonNull int[] iArr);

        @NonNull
        /* renamed from: a */
        byte[] mo486a(int i);

        @NonNull
        /* renamed from: b */
        int[] mo487b(int i);
    }

    @NonNull
    /* renamed from: a */
    ByteBuffer mo472a();

    /* renamed from: a */
    void mo473a(@NonNull Bitmap.Config config);

    /* renamed from: b */
    void mo474b();

    /* renamed from: c */
    int mo475c();

    /* renamed from: d */
    int mo476d();

    /* renamed from: e */
    int mo477e();

    /* renamed from: f */
    void mo478f();

    /* renamed from: g */
    int mo479g();

    @Nullable
    /* renamed from: h */
    Bitmap mo480h();

    /* renamed from: i */
    void mo481i();
}