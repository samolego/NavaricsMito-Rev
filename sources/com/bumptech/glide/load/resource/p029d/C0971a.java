package com.bumptech.glide.load.resource.p029d;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.resource.d.a */
/* loaded from: classes.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: a */
    private static final C0760a f1090a = new C0760a();

    /* renamed from: b */
    private static final C0761b f1091b = new C0761b();

    /* renamed from: c */
    private final Context f1092c;

    /* renamed from: d */
    private final List<ImageHeaderParser> f1093d;

    /* renamed from: e */
    private final C0761b f1094e;

    /* renamed from: f */
    private final C0760a f1095f;

    /* renamed from: g */
    private final GifBitmapProvider f1096g;

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f1091b, f1090a);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, C0761b c0761b, C0760a c0760a) {
        this.f1092c = context.getApplicationContext();
        this.f1093d = list;
        this.f1095f = c0760a;
        this.f1096g = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f1094e = c0761b;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.m12014a(GifOptions.f1135b)).booleanValue() && ImageHeaderParserUtils.m12382a(this.f1093d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public GifDrawableResource mo11820a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser m11877a = this.f1094e.m11877a(byteBuffer);
        try {
            return m11882a(byteBuffer, i, i2, m11877a, options);
        } finally {
            this.f1094e.m11878a(m11877a);
        }
    }

    @Nullable
    /* renamed from: a */
    private GifDrawableResource m11882a(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        long m11595a = LogTime.m11595a();
        try {
            GifHeader m12486b = gifHeaderParser.m12486b();
            if (m12486b.m12491c() > 0 && m12486b.m12490d() == 0) {
                Bitmap.Config config = options.m12014a(GifOptions.f1134a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                GifDecoder m11879a = this.f1095f.m11879a(this.f1096g, m12486b, byteBuffer, m11883a(m12486b, i, i2));
                m11879a.mo12468a(config);
                m11879a.mo12464b();
                Bitmap mo12456h = m11879a.mo12456h();
                if (mo12456h == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.m11594a(m11595a));
                    }
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f1092c, m11879a, UnitTransformation.m12003a(), i, i2, mo12456h));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.m11594a(m11595a));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.m11594a(m11595a));
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.m11594a(m11595a));
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static int m11883a(GifHeader gifHeader, int i, int i2) {
        int min = Math.min(gifHeader.m12493a() / i2, gifHeader.m12492b() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + gifHeader.m12492b() + "x" + gifHeader.m12493a() + "]");
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.d.a$a */
    /* loaded from: classes.dex */
    public static class C0760a {
        C0760a() {
        }

        /* renamed from: a */
        GifDecoder m11879a(GifDecoder.InterfaceC0607a interfaceC0607a, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(interfaceC0607a, gifHeader, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.d.a$b */
    /* loaded from: classes.dex */
    public static class C0761b {

        /* renamed from: a */
        private final Queue<GifHeaderParser> f1097a = C0791i.m11572a(0);

        C0761b() {
        }

        /* renamed from: a */
        synchronized GifHeaderParser m11877a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f1097a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.m12487a(byteBuffer);
        }

        /* renamed from: a */
        synchronized void m11878a(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.m12489a();
            this.f1097a.offer(gifHeaderParser);
        }
    }
}
