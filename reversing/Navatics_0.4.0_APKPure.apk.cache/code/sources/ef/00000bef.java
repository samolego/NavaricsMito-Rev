package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* renamed from: com.bumptech.glide.util.e */
/* loaded from: classes.dex */
public class C0777e<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f1302a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f1303b;

    /* renamed from: c */
    private long f1304c;

    /* renamed from: d */
    private long f1305d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public int mo844a(@Nullable Y y) {
        return 1;
    }

    /* renamed from: a */
    protected void mo652a(@NonNull T t, @Nullable Y y) {
    }

    public C0777e(long j) {
        this.f1303b = j;
        this.f1304c = j;
    }

    /* renamed from: b */
    public synchronized long m1354b() {
        return this.f1304c;
    }

    @Nullable
    /* renamed from: b */
    public synchronized Y m1355b(@NonNull T t) {
        return this.f1302a.get(t);
    }

    @Nullable
    /* renamed from: b */
    public synchronized Y m1356b(@NonNull T t, @Nullable Y y) {
        long mo844a = mo844a((C0777e<T, Y>) y);
        if (mo844a >= this.f1304c) {
            mo652a(t, y);
            return null;
        }
        if (y != null) {
            this.f1305d += mo844a;
        }
        Y put = this.f1302a.put(t, y);
        if (put != null) {
            this.f1305d -= mo844a((C0777e<T, Y>) put);
            if (!put.equals(y)) {
                mo652a(t, put);
            }
        }
        m1351c();
        return put;
    }

    @Nullable
    /* renamed from: c */
    public synchronized Y m1357c(@NonNull T t) {
        Y remove;
        remove = this.f1302a.remove(t);
        if (remove != null) {
            this.f1305d -= mo844a((C0777e<T, Y>) remove);
        }
        return remove;
    }

    /* renamed from: a */
    public void m1352a() {
        m1353a(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void m1353a(long j) {
        while (this.f1305d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f1302a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f1305d -= mo844a((C0777e<T, Y>) value);
            T key = next.getKey();
            it.remove();
            mo652a(key, value);
        }
    }

    /* renamed from: c */
    private void m1351c() {
        m1353a(this.f1304c);
    }
}