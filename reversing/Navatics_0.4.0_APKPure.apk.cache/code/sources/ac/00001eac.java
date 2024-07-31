package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public interface Downloader {
    /* renamed from: a */
    C2250a mo7044a(Uri uri, int i) throws IOException;

    /* loaded from: classes2.dex */
    public static class ResponseException extends IOException {
        final boolean localCacheOnly;
        final int responseCode;

        public ResponseException(String str, int i, int i2) {
            super(str);
            this.localCacheOnly = NetworkPolicy.isOfflineOnly(i);
            this.responseCode = i2;
        }
    }

    /* renamed from: com.squareup.picasso.Downloader$a */
    /* loaded from: classes2.dex */
    public static class C2250a {

        /* renamed from: a */
        final InputStream f6870a;

        /* renamed from: b */
        final Bitmap f6871b;

        /* renamed from: c */
        final boolean f6872c;

        /* renamed from: d */
        final long f6873d;

        public C2250a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f6870a = inputStream;
            this.f6871b = null;
            this.f6872c = z;
            this.f6873d = j;
        }

        /* renamed from: a */
        public InputStream m7045a() {
            return this.f6870a;
        }

        @Deprecated
        /* renamed from: b */
        public Bitmap m7046b() {
            return this.f6871b;
        }

        /* renamed from: c */
        public long m7047c() {
            return this.f6873d;
        }
    }
}