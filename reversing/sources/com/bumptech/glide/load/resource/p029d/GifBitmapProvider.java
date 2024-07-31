package com.bumptech.glide.load.resource.p029d;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p022a.BitmapPool;

/* renamed from: com.bumptech.glide.load.resource.d.b */
/* loaded from: classes.dex */
public final class GifBitmapProvider implements GifDecoder.InterfaceC0607a {

    /* renamed from: a */
    private final BitmapPool f1098a;
    @Nullable

    /* renamed from: b */
    private final ArrayPool f1099b;

    public GifBitmapProvider(BitmapPool bitmapPool, @Nullable ArrayPool arrayPool) {
        this.f1098a = bitmapPool;
        this.f1099b = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC0607a
    @NonNull
    /* renamed from: a */
    public Bitmap mo11875a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f1098a.mo12177b(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC0607a
    /* renamed from: a */
    public void mo11874a(@NonNull Bitmap bitmap) {
        this.f1098a.mo11931a(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC0607a
    @NonNull
    /* renamed from: a */
    public byte[] mo11876a(int i) {
        ArrayPool arrayPool = this.f1099b;
        if (arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool.mo12200a(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC0607a
    /* renamed from: a */
    public void mo11873a(@NonNull byte[] bArr) {
        ArrayPool arrayPool = this.f1099b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.mo12195a((ArrayPool) bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC0607a
    @NonNull
    /* renamed from: b */
    public int[] mo11871b(int i) {
        ArrayPool arrayPool = this.f1099b;
        if (arrayPool == null) {
            return new int[i];
        }
        return (int[]) arrayPool.mo12200a(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC0607a
    /* renamed from: a */
    public void mo11872a(@NonNull int[] iArr) {
        ArrayPool arrayPool = this.f1099b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.mo12195a((ArrayPool) iArr);
    }
}
