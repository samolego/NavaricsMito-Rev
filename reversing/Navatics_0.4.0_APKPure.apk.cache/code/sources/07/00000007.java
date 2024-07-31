package android.arch.p005a.p007b;

import android.arch.p005a.p007b.SafeIterableMap;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.b.a, reason: use source file name */
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: a */
    private HashMap<K, SafeIterableMap.c<K, V>> f20a = new HashMap<>();

    @Override // android.arch.p005a.p007b.SafeIterableMap
    /* renamed from: a */
    protected SafeIterableMap.c<K, V> mo31a(K k) {
        return this.f20a.get(k);
    }

    @Override // android.arch.p005a.p007b.SafeIterableMap
    /* renamed from: a */
    public V mo32a(@NonNull K k, @NonNull V v) {
        SafeIterableMap.c<K, V> mo31a = mo31a((FastSafeIterableMap<K, V>) k);
        if (mo31a != null) {
            return mo31a.f26b;
        }
        this.f20a.put(k, m38b(k, v));
        return null;
    }

    @Override // android.arch.p005a.p007b.SafeIterableMap
    /* renamed from: b */
    public V mo33b(@NonNull K k) {
        V v = (V) super.mo33b(k);
        this.f20a.remove(k);
        return v;
    }

    /* renamed from: c */
    public boolean m34c(K k) {
        return this.f20a.containsKey(k);
    }

    /* renamed from: d */
    public Map.Entry<K, V> m35d(K k) {
        if (m34c(k)) {
            return this.f20a.get(k).f28d;
        }
        return null;
    }
}