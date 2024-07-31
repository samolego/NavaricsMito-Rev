package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.v */
/* loaded from: classes.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: a */
    public static final Option<Long> f1082a = Option.m12278a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.InterfaceC0678a<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.v.1

        /* renamed from: a */
        private final ByteBuffer f1088a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.InterfaceC0678a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo11890a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f1088a) {
                this.f1088a.position(0);
                messageDigest.update(this.f1088a.putLong(l.longValue()).array());
            }
        }
    });

    /* renamed from: b */
    public static final Option<Integer> f1083b = Option.m12278a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.InterfaceC0678a<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.v.2

        /* renamed from: a */
        private final ByteBuffer f1089a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.InterfaceC0678a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo11890a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f1089a) {
                this.f1089a.position(0);
                messageDigest.update(this.f1089a.putInt(num.intValue()).array());
            }
        }
    });

    /* renamed from: c */
    private static final C0757b f1084c = new C0757b();

    /* renamed from: d */
    private final InterfaceC0758c<T> f1085d;

    /* renamed from: e */
    private final BitmapPool f1086e;

    /* renamed from: f */
    private final C0757b f1087f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.bitmap.v$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0758c<T> {
        /* renamed from: a */
        void mo11886a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a */
    public boolean mo11819a(@NonNull T t, @NonNull Options options) {
        return true;
    }

    /* renamed from: a */
    public static ResourceDecoder<AssetFileDescriptor, Bitmap> m11895a(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new C0756a());
    }

    /* renamed from: b */
    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> m11893b(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new C0759d());
    }

    VideoDecoder(BitmapPool bitmapPool, InterfaceC0758c<T> interfaceC0758c) {
        this(bitmapPool, interfaceC0758c, f1084c);
    }

    @VisibleForTesting
    VideoDecoder(BitmapPool bitmapPool, InterfaceC0758c<T> interfaceC0758c, C0757b c0757b) {
        this.f1086e = bitmapPool;
        this.f1085d = interfaceC0758c;
        this.f1087f = c0757b;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a */
    public Resource<Bitmap> mo11820a(@NonNull T t, int i, int i2, @NonNull Options options) throws IOException {
        long longValue = ((Long) options.m12014a(f1082a)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) options.m12014a(f1083b);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.m12014a(DownsampleStrategy.f1019h);
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy == null ? DownsampleStrategy.f1018g : downsampleStrategy;
        MediaMetadataRetriever m11888a = this.f1087f.m11888a();
        try {
            try {
                this.f1085d.mo11886a(m11888a, t);
                Bitmap m11896a = m11896a(m11888a, longValue, num.intValue(), i, i2, downsampleStrategy2);
                m11888a.release();
                return BitmapResource.m11980a(m11896a, this.f1086e);
            } catch (RuntimeException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            m11888a.release();
            throw th;
        }
    }

    @Nullable
    /* renamed from: a */
    private static Bitmap m11896a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap m11894b = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f1017f) ? null : m11894b(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return m11894b == null ? m11897a(mediaMetadataRetriever, j, i) : m11894b;
    }

    @TargetApi(27)
    /* renamed from: b */
    private static Bitmap m11894b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float mo11989a = downsampleStrategy.mo11989a(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * mo11989a), Math.round(mo11989a * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
                return null;
            }
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m11897a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.bitmap.v$b */
    /* loaded from: classes.dex */
    static class C0757b {
        C0757b() {
        }

        /* renamed from: a */
        public MediaMetadataRetriever m11888a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.v$a */
    /* loaded from: classes.dex */
    public static final class C0756a implements InterfaceC0758c<AssetFileDescriptor> {
        private C0756a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.InterfaceC0758c
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo11886a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.v$d */
    /* loaded from: classes.dex */
    public static final class C0759d implements InterfaceC0758c<ParcelFileDescriptor> {
        C0759d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.InterfaceC0758c
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo11886a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }
}
