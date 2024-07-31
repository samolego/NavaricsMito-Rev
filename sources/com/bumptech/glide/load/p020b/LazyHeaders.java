package com.bumptech.glide.load.p020b;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.b.j */
/* loaded from: classes.dex */
public final class LazyHeaders implements Headers {

    /* renamed from: c */
    private final Map<String, List<LazyHeaderFactory>> f634c;

    /* renamed from: d */
    private volatile Map<String, String> f635d;

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f634c = Collections.unmodifiableMap(map);
    }

    @Override // com.bumptech.glide.load.p020b.Headers
    /* renamed from: a */
    public Map<String, String> mo12336a() {
        if (this.f635d == null) {
            synchronized (this) {
                if (this.f635d == null) {
                    this.f635d = Collections.unmodifiableMap(m12334b());
                }
            }
        }
        return this.f635d;
    }

    /* renamed from: b */
    private Map<String, String> m12334b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.f634c.entrySet()) {
            String m12335a = m12335a(entry.getValue());
            if (!TextUtils.isEmpty(m12335a)) {
                hashMap.put(entry.getKey(), m12335a);
            }
        }
        return hashMap;
    }

    @NonNull
    /* renamed from: a */
    private String m12335a(@NonNull List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String mo12331a = list.get(i).mo12331a();
            if (!TextUtils.isEmpty(mo12331a)) {
                sb.append(mo12331a);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f634c + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.f634c.equals(((LazyHeaders) obj).f634c);
        }
        return false;
    }

    public int hashCode() {
        return this.f634c.hashCode();
    }

    /* compiled from: LazyHeaders.java */
    /* renamed from: com.bumptech.glide.load.b.j$a */
    /* loaded from: classes.dex */
    public static final class C0650a {

        /* renamed from: a */
        private static final String f636a = m12332b();

        /* renamed from: b */
        private static final Map<String, List<LazyHeaderFactory>> f637b;

        /* renamed from: c */
        private boolean f638c = true;

        /* renamed from: d */
        private Map<String, List<LazyHeaderFactory>> f639d = f637b;

        /* renamed from: e */
        private boolean f640e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f636a)) {
                hashMap.put("User-Agent", Collections.singletonList(new C0651b(f636a)));
            }
            f637b = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: a */
        public LazyHeaders m12333a() {
            this.f638c = true;
            return new LazyHeaders(this.f639d);
        }

        @VisibleForTesting
        /* renamed from: b */
        static String m12332b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    /* compiled from: LazyHeaders.java */
    /* renamed from: com.bumptech.glide.load.b.j$b */
    /* loaded from: classes.dex */
    static final class C0651b implements LazyHeaderFactory {

        /* renamed from: a */
        private final String f641a;

        C0651b(String str) {
            this.f641a = str;
        }

        @Override // com.bumptech.glide.load.p020b.LazyHeaderFactory
        /* renamed from: a */
        public String mo12331a() {
            return this.f641a;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f641a + "'}";
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0651b) {
                return this.f641a.equals(((C0651b) obj).f641a);
            }
            return false;
        }

        public int hashCode() {
            return this.f641a.hashCode();
        }
    }
}
