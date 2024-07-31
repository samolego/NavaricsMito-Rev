package com.bumptech.glide.load.engine.p023b;

import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.p023b.DiskCache;
import com.bumptech.glide.p014a.DiskLruCache;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.engine.b.e */
/* loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: b */
    private final File f824b;

    /* renamed from: c */
    private final long f825c;

    /* renamed from: e */
    private DiskLruCache f827e;

    /* renamed from: d */
    private final DiskCacheWriteLocker f826d = new DiskCacheWriteLocker();

    /* renamed from: a */
    private final SafeKeyGenerator f823a = new SafeKeyGenerator();

    /* renamed from: a */
    public static DiskCache m12140a(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.f824b = file;
        this.f825c = j;
    }

    /* renamed from: a */
    private synchronized DiskLruCache m12143a() throws IOException {
        if (this.f827e == null) {
            this.f827e = DiskLruCache.m12603a(this.f824b, 1, 1, this.f825c);
        }
        return this.f827e;
    }

    @Override // com.bumptech.glide.load.engine.p023b.DiskCache
    /* renamed from: a */
    public File mo12142a(Key key) {
        String m12122a = this.f823a.m12122a(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + m12122a + " for for Key: " + key);
        }
        try {
            DiskLruCache.C0602d m12601a = m12143a().m12601a(m12122a);
            if (m12601a != null) {
                return m12601a.m12564a(0);
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.p023b.DiskCache
    /* renamed from: a */
    public void mo12141a(Key key, DiskCache.InterfaceC0701b interfaceC0701b) {
        DiskLruCache m12143a;
        String m12122a = this.f823a.m12122a(key);
        this.f826d.m12148a(m12122a);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + m12122a + " for for Key: " + key);
            }
            try {
                m12143a = m12143a();
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            if (m12143a.m12601a(m12122a) != null) {
                return;
            }
            DiskLruCache.C0600b m12597b = m12143a.m12597b(m12122a);
            if (m12597b == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + m12122a);
            }
            try {
                if (interfaceC0701b.mo12108a(m12597b.m12583a(0))) {
                    m12597b.m12584a();
                }
                m12597b.m12579c();
            } catch (Throwable th) {
                m12597b.m12579c();
                throw th;
            }
        } finally {
            this.f826d.m12147b(m12122a);
        }
    }
}
