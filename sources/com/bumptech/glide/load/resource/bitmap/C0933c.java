package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.p022a.ArrayPool;

/* renamed from: com.bumptech.glide.load.resource.bitmap.c */
/* loaded from: classes.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {

    /* renamed from: a */
    public static final Option<Integer> f1031a = Option.m12279a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: b */
    public static final Option<Bitmap.CompressFormat> f1032b = Option.m12280a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    @Nullable

    /* renamed from: c */
    private final ArrayPool f1033c;

    public BitmapEncoder(@NonNull ArrayPool arrayPool) {
        this.f1033c = arrayPool;
    }

    @Deprecated
    public BitmapEncoder() {
        this.f1033c = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r5 != null) goto L14;
     */
    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo11855a(@android.support.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r8, @android.support.annotation.NonNull java.io.File r9, @android.support.annotation.NonNull com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.Object r8 = r8.mo11898d()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r0 = r7.m11982a(r8, r10)
            java.lang.String r1 = "encode: [%dx%d] %s"
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.bumptech.glide.util.p033a.GlideTrace.m11605a(r1, r2, r3, r0)
            long r1 = com.bumptech.glide.util.LogTime.m11595a()     // Catch: java.lang.Throwable -> Lc6
            com.bumptech.glide.load.e<java.lang.Integer> r3 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.f1031a     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r3 = r10.m12014a(r3)     // Catch: java.lang.Throwable -> Lc6
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> Lc6
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> Lc6
            r4 = 0
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            com.bumptech.glide.load.engine.a.b r9 = r7.f1033c     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52
            if (r9 == 0) goto L43
            com.bumptech.glide.load.a.c r9 = new com.bumptech.glide.load.a.c     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52
            com.bumptech.glide.load.engine.a.b r5 = r7.f1033c     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52
            r9.<init>(r6, r5)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52
            r5 = r9
            goto L44
        L43:
            r5 = r6
        L44:
            r8.compress(r0, r3, r5)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4 = 1
        L4b:
            r5.close()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> Lc6
            goto L6b
        L4f:
            r8 = move-exception
            r5 = r6
            goto Lc0
        L52:
            r9 = move-exception
            r5 = r6
            goto L58
        L55:
            r8 = move-exception
            goto Lc0
        L57:
            r9 = move-exception
        L58:
            java.lang.String r3 = "BitmapEncoder"
            r6 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r6)     // Catch: java.lang.Throwable -> L55
            if (r3 == 0) goto L68
            java.lang.String r3 = "BitmapEncoder"
            java.lang.String r6 = "Failed to encode Bitmap"
            android.util.Log.d(r3, r6, r9)     // Catch: java.lang.Throwable -> L55
        L68:
            if (r5 == 0) goto L6b
            goto L4b
        L6b:
            java.lang.String r9 = "BitmapEncoder"
            r3 = 2
            boolean r9 = android.util.Log.isLoggable(r9, r3)     // Catch: java.lang.Throwable -> Lc6
            if (r9 == 0) goto Lbc
            java.lang.String r9 = "BitmapEncoder"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc6
            r3.<init>()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r5 = "Compressed with type: "
            r3.append(r5)     // Catch: java.lang.Throwable -> Lc6
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r0 = " of size "
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc6
            int r0 = com.bumptech.glide.util.C0791i.m11568a(r8)     // Catch: java.lang.Throwable -> Lc6
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r0 = " in "
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc6
            double r0 = com.bumptech.glide.util.LogTime.m11594a(r1)     // Catch: java.lang.Throwable -> Lc6
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r0 = ", options format: "
            r3.append(r0)     // Catch: java.lang.Throwable -> Lc6
            com.bumptech.glide.load.e<android.graphics.Bitmap$CompressFormat> r0 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.f1032b     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r10 = r10.m12014a(r0)     // Catch: java.lang.Throwable -> Lc6
            r3.append(r10)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r10 = ", hasAlpha: "
            r3.append(r10)     // Catch: java.lang.Throwable -> Lc6
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> Lc6
            r3.append(r8)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> Lc6
            android.util.Log.v(r9, r8)     // Catch: java.lang.Throwable -> Lc6
        Lbc:
            com.bumptech.glide.util.p033a.GlideTrace.m11608a()
            return r4
        Lc0:
            if (r5 == 0) goto Lc5
            r5.close()     // Catch: java.io.IOException -> Lc5 java.lang.Throwable -> Lc6
        Lc5:
            throw r8     // Catch: java.lang.Throwable -> Lc6
        Lc6:
            r8 = move-exception
            com.bumptech.glide.util.p033a.GlideTrace.m11608a()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.mo11855a(com.bumptech.glide.load.engine.s, java.io.File, com.bumptech.glide.load.f):boolean");
    }

    /* renamed from: a */
    private Bitmap.CompressFormat m11982a(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.m12014a(f1032b);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    /* renamed from: a */
    public EncodeStrategy mo11856a(@NonNull Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
