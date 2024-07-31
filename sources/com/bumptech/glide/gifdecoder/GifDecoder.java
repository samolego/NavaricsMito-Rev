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
    public interface InterfaceC0607a {
        @NonNull
        /* renamed from: a */
        Bitmap mo11875a(int i, int i2, @NonNull Bitmap.Config config);

        /* renamed from: a */
        void mo11874a(@NonNull Bitmap bitmap);

        /* renamed from: a */
        void mo11873a(@NonNull byte[] bArr);

        /* renamed from: a */
        void mo11872a(@NonNull int[] iArr);

        @NonNull
        /* renamed from: a */
        byte[] mo11876a(int i);

        @NonNull
        /* renamed from: b */
        int[] mo11871b(int i);
    }

    @NonNull
    /* renamed from: a */
    ByteBuffer mo12471a();

    /* renamed from: a */
    void mo12468a(@NonNull Bitmap.Config config);

    /* renamed from: b */
    void mo12464b();

    /* renamed from: c */
    int mo12462c();

    /* renamed from: d */
    int mo12460d();

    /* renamed from: e */
    int mo12459e();

    /* renamed from: f */
    void mo12458f();

    /* renamed from: g */
    int mo12457g();

    @Nullable
    /* renamed from: h */
    Bitmap mo12456h();

    /* renamed from: i */
    void mo12455i();
}
