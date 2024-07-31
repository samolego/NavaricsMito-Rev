package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.resource.bitmap.s */
/* loaded from: classes.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a */
    private final Downsampler f1072a;

    /* renamed from: b */
    private final ArrayPool f1073b;

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f1072a = downsampler;
        this.f1073b = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.f1072a.m11947a(inputStream);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Resource<Bitmap> mo11820a(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f1073b);
            z = true;
        }
        ExceptionCatchingInputStream m11598a = ExceptionCatchingInputStream.m11598a(recyclableBufferedInputStream);
        try {
            return this.f1072a.m11945a(new MarkEnforcingInputStream(m11598a), i, i2, options, new C0751a(recyclableBufferedInputStream, m11598a));
        } finally {
            m11598a.m11597b();
            if (z) {
                recyclableBufferedInputStream.m11985b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.s$a */
    /* loaded from: classes.dex */
    public static class C0751a implements Downsampler.InterfaceC0749a {

        /* renamed from: a */
        private final RecyclableBufferedInputStream f1074a;

        /* renamed from: b */
        private final ExceptionCatchingInputStream f1075b;

        C0751a(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f1074a = recyclableBufferedInputStream;
            this.f1075b = exceptionCatchingInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC0749a
        /* renamed from: a */
        public void mo11919a() {
            this.f1074a.m11987a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC0749a
        /* renamed from: a */
        public void mo11918a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException m11599a = this.f1075b.m11599a();
            if (m11599a != null) {
                if (bitmap != null) {
                    bitmapPool.mo11931a(bitmap);
                }
                throw m11599a;
            }
        }
    }
}
