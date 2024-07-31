package com.bumptech.glide.load.engine.p022a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.engine.a.k */
/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: a */
    private static final Bitmap.Config f784a = Bitmap.Config.ARGB_8888;

    /* renamed from: b */
    private final LruPoolStrategy f785b;

    /* renamed from: c */
    private final Set<Bitmap.Config> f786c;

    /* renamed from: d */
    private final long f787d;

    /* renamed from: e */
    private final InterfaceC0695a f788e;

    /* renamed from: f */
    private long f789f;

    /* renamed from: g */
    private long f790g;

    /* renamed from: h */
    private int f791h;

    /* renamed from: i */
    private int f792i;

    /* renamed from: j */
    private int f793j;

    /* renamed from: k */
    private int f794k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.engine.a.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0695a {
        /* renamed from: a */
        void mo12167a(Bitmap bitmap);

        /* renamed from: b */
        void mo12166b(Bitmap bitmap);
    }

    LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.f787d = j;
        this.f789f = j;
        this.f785b = lruPoolStrategy;
        this.f786c = set;
        this.f788e = new C0696b();
    }

    public LruBitmapPool(long j) {
        this(j, m12169f(), m12168g());
    }

    /* renamed from: b */
    public long m12178b() {
        return this.f789f;
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    /* renamed from: a */
    public synchronized void mo11931a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f785b.mo12155c(bitmap) <= this.f789f && this.f786c.contains(bitmap.getConfig())) {
                int mo12155c = this.f785b.mo12155c(bitmap);
                this.f785b.mo12161a(bitmap);
                this.f788e.mo12167a(bitmap);
                this.f793j++;
                this.f790g += mo12155c;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f785b.mo12156b(bitmap));
                }
                m12172d();
                m12175c();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f785b.mo12156b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f786c.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: c */
    private void m12175c() {
        m12180a(this.f789f);
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    @NonNull
    /* renamed from: a */
    public Bitmap mo12181a(int i, int i2, Bitmap.Config config) {
        Bitmap m12171d = m12171d(i, i2, config);
        if (m12171d != null) {
            m12171d.eraseColor(0);
            return m12171d;
        }
        return m12174c(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    @NonNull
    /* renamed from: b */
    public Bitmap mo12177b(int i, int i2, Bitmap.Config config) {
        Bitmap m12171d = m12171d(i, i2, config);
        return m12171d == null ? m12174c(i, i2, config) : m12171d;
    }

    @NonNull
    /* renamed from: c */
    private static Bitmap m12174c(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f784a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @TargetApi(26)
    /* renamed from: a */
    private static void m12179a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Nullable
    /* renamed from: d */
    private synchronized Bitmap m12171d(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap mo12164a;
        m12179a(config);
        mo12164a = this.f785b.mo12164a(i, i2, config != null ? config : f784a);
        if (mo12164a == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f785b.mo12159b(i, i2, config));
            }
            this.f792i++;
        } else {
            this.f791h++;
            this.f790g -= this.f785b.mo12155c(mo12164a);
            this.f788e.mo12166b(mo12164a);
            m12176b(mo12164a);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f785b.mo12159b(i, i2, config));
        }
        m12172d();
        return mo12164a;
    }

    /* renamed from: b */
    private static void m12176b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m12173c(bitmap);
    }

    @TargetApi(19)
    /* renamed from: c */
    private static void m12173c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    /* renamed from: a */
    public void mo12183a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m12180a(0L);
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo12182a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            mo12183a();
        } else if (i >= 20 || i == 15) {
            m12180a(m12178b() / 2);
        }
    }

    /* renamed from: a */
    private synchronized void m12180a(long j) {
        while (this.f790g > j) {
            Bitmap mo12165a = this.f785b.mo12165a();
            if (mo12165a == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m12170e();
                }
                this.f790g = 0L;
                return;
            }
            this.f788e.mo12166b(mo12165a);
            this.f790g -= this.f785b.mo12155c(mo12165a);
            this.f794k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f785b.mo12156b(mo12165a));
            }
            m12172d();
            mo12165a.recycle();
        }
    }

    /* renamed from: d */
    private void m12172d() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m12170e();
        }
    }

    /* renamed from: e */
    private void m12170e() {
        Log.v("LruBitmapPool", "Hits=" + this.f791h + ", misses=" + this.f792i + ", puts=" + this.f793j + ", evictions=" + this.f794k + ", currentSize=" + this.f790g + ", maxSize=" + this.f789f + "\nStrategy=" + this.f785b);
    }

    /* renamed from: f */
    private static LruPoolStrategy m12169f() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }

    @TargetApi(26)
    /* renamed from: g */
    private static Set<Bitmap.Config> m12168g() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: com.bumptech.glide.load.engine.a.k$b */
    /* loaded from: classes.dex */
    private static final class C0696b implements InterfaceC0695a {
        @Override // com.bumptech.glide.load.engine.p022a.LruBitmapPool.InterfaceC0695a
        /* renamed from: a */
        public void mo12167a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.p022a.LruBitmapPool.InterfaceC0695a
        /* renamed from: b */
        public void mo12166b(Bitmap bitmap) {
        }

        C0696b() {
        }
    }
}
