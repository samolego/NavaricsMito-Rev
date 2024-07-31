package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public interface Downloader {
    /* renamed from: a */
    C2335a mo5613a(Uri uri, int i) throws IOException;

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
    public static class C2335a {

        /* renamed from: a */
        final InputStream f6838a;

        /* renamed from: b */
        final Bitmap f6839b;

        /* renamed from: c */
        final boolean f6840c;

        /* renamed from: d */
        final long f6841d;

        public C2335a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f6838a = inputStream;
            this.f6839b = null;
            this.f6840c = z;
            this.f6841d = j;
        }

        /* renamed from: a */
        public InputStream m5804a() {
            return this.f6838a;
        }

        @Deprecated
        /* renamed from: b */
        public Bitmap m5803b() {
            return this.f6839b;
        }

        /* renamed from: c */
        public long m5802c() {
            return this.f6841d;
        }
    }
}
