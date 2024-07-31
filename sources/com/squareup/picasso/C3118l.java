package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

/* compiled from: LruCache.java */
/* renamed from: com.squareup.picasso.l */
/* loaded from: classes2.dex */
public class C2363l implements Cache {

    /* renamed from: b */
    final LinkedHashMap<String, Bitmap> f6954b;

    /* renamed from: c */
    private final int f6955c;

    /* renamed from: d */
    private int f6956d;

    /* renamed from: e */
    private int f6957e;

    /* renamed from: f */
    private int f6958f;

    /* renamed from: g */
    private int f6959g;

    /* renamed from: h */
    private int f6960h;

    public C2363l(Context context) {
        this(C2344aa.m5749c(context));
    }

    public C2363l(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f6955c = i;
        this.f6954b = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: a */
    public Bitmap mo5685a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = this.f6954b.get(str);
            if (bitmap != null) {
                this.f6959g++;
                return bitmap;
            }
            this.f6960h++;
            return null;
        }
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: a */
    public void mo5684a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f6957e++;
            this.f6956d += C2344aa.m5765a(bitmap);
            Bitmap put = this.f6954b.put(str, bitmap);
            if (put != null) {
                this.f6956d -= C2344aa.m5765a(put);
            }
        }
        m5686a(this.f6955c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m5686a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f6956d     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f6954b     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r3.f6956d     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r3.f6956d     // Catch: java.lang.Throwable -> L71
            if (r0 <= r4) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f6954b     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f6954b     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f6954b     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r1 = r3.f6956d     // Catch: java.lang.Throwable -> L71
            int r0 = com.squareup.picasso.C2344aa.m5765a(r0)     // Catch: java.lang.Throwable -> L71
            int r1 = r1 - r0
            r3.f6956d = r1     // Catch: java.lang.Throwable -> L71
            int r0 = r3.f6958f     // Catch: java.lang.Throwable -> L71
            int r0 = r0 + 1
            r3.f6958f = r0     // Catch: java.lang.Throwable -> L71
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            goto L0
        L50:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r4     // Catch: java.lang.Throwable -> L71
        L71:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C2363l.m5686a(int):void");
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: a */
    public final synchronized int mo5687a() {
        return this.f6956d;
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: b */
    public final synchronized int mo5683b() {
        return this.f6955c;
    }
}
