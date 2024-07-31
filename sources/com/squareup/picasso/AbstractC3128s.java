package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.squareup.picasso.s */
/* loaded from: classes2.dex */
public abstract class RequestHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5647a() {
        return 0;
    }

    /* renamed from: a */
    public abstract C2368a mo5634a(C2365q c2365q, int i) throws IOException;

    /* renamed from: a */
    public abstract boolean mo5635a(C2365q c2365q);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5643a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5642b() {
        return false;
    }

    /* compiled from: RequestHandler.java */
    /* renamed from: com.squareup.picasso.s$a */
    /* loaded from: classes2.dex */
    public static final class C2368a {

        /* renamed from: a */
        private final Picasso.LoadedFrom f7023a;

        /* renamed from: b */
        private final Bitmap f7024b;

        /* renamed from: c */
        private final InputStream f7025c;

        /* renamed from: d */
        private final int f7026d;

        public C2368a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            this((Bitmap) C2344aa.m5757a(bitmap, "bitmap == null"), null, loadedFrom, 0);
        }

        public C2368a(InputStream inputStream, Picasso.LoadedFrom loadedFrom) {
            this(null, (InputStream) C2344aa.m5757a(inputStream, "stream == null"), loadedFrom, 0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C2368a(Bitmap bitmap, InputStream inputStream, Picasso.LoadedFrom loadedFrom, int i) {
            if (!((inputStream != null) ^ (bitmap != null))) {
                throw new AssertionError();
            }
            this.f7024b = bitmap;
            this.f7025c = inputStream;
            this.f7023a = (Picasso.LoadedFrom) C2344aa.m5757a(loadedFrom, "loadedFrom == null");
            this.f7026d = i;
        }

        /* renamed from: a */
        public Bitmap m5640a() {
            return this.f7024b;
        }

        /* renamed from: b */
        public InputStream m5639b() {
            return this.f7025c;
        }

        /* renamed from: c */
        public Picasso.LoadedFrom m5638c() {
            return this.f7023a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d */
        public int m5637d() {
            return this.f7026d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static BitmapFactory.Options m5641c(C2365q c2365q) {
        boolean m5667d = c2365q.m5667d();
        boolean z = c2365q.f6993q != null;
        BitmapFactory.Options options = null;
        if (m5667d || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = m5667d;
            if (z) {
                options.inPreferredConfig = c2365q.f6993q;
            }
        }
        return options;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m5644a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5645a(int i, int i2, BitmapFactory.Options options, C2365q c2365q) {
        m5646a(i, i2, options.outWidth, options.outHeight, options, c2365q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5646a(int i, int i2, int i3, int i4, BitmapFactory.Options options, C2365q c2365q) {
        int min;
        if (i4 <= i2 && i3 <= i) {
            min = 1;
        } else if (i2 == 0) {
            min = (int) Math.floor(i3 / i);
        } else if (i == 0) {
            min = (int) Math.floor(i4 / i2);
        } else {
            int floor = (int) Math.floor(i4 / i2);
            int floor2 = (int) Math.floor(i3 / i);
            if (c2365q.f6987k) {
                min = Math.max(floor, floor2);
            } else {
                min = Math.min(floor, floor2);
            }
        }
        options.inSampleSize = min;
        options.inJustDecodeBounds = false;
    }
}
