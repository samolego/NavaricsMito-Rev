package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.util.e */
/* loaded from: classes.dex */
public class LruCache<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f1298a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f1299b;

    /* renamed from: c */
    private long f1300c;

    /* renamed from: d */
    private long f1301d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public int mo11591a(@Nullable Y y) {
        return 1;
    }

    /* renamed from: a */
    protected void mo11590a(@NonNull T t, @Nullable Y y) {
    }

    public LruCache(long j) {
        this.f1299b = j;
        this.f1300c = j;
    }

    /* renamed from: b */
    public synchronized long m11589b() {
        return this.f1300c;
    }

    @Nullable
    /* renamed from: b */
    public synchronized Y m11588b(@NonNull T t) {
        return this.f1298a.get(t);
    }

    @Nullable
    /* renamed from: b */
    public synchronized Y m11587b(@NonNull T t, @Nullable Y y) {
        long mo11591a = mo11591a((LruCache<T, Y>) y);
        if (mo11591a >= this.f1300c) {
            mo11590a(t, y);
            return null;
        }
        if (y != null) {
            this.f1301d += mo11591a;
        }
        Y put = this.f1298a.put(t, y);
        if (put != null) {
            this.f1301d -= mo11591a((LruCache<T, Y>) put);
            if (!put.equals(y)) {
                mo11590a(t, put);
            }
        }
        m11586c();
        return put;
    }

    @Nullable
    /* renamed from: c */
    public synchronized Y m11585c(@NonNull T t) {
        Y remove;
        remove = this.f1298a.remove(t);
        if (remove != null) {
            this.f1301d -= mo11591a((LruCache<T, Y>) remove);
        }
        return remove;
    }

    /* renamed from: a */
    public void m11593a() {
        m11592a(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void m11592a(long j) {
        while (this.f1301d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f1298a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f1301d -= mo11591a((LruCache<T, Y>) value);
            T key = next.getKey();
            it.remove();
            mo11590a(key, value);
        }
    }

    /* renamed from: c */
    private void m11586c() {
        m11592a(this.f1300c);
    }
}
