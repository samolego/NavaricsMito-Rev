package android.arch.p005a.p007b;

import android.arch.p005a.p007b.SafeIterableMap;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: android.arch.a.b.a */
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: a */
    private HashMap<K, SafeIterableMap.C0005c<K, V>> f20a = new HashMap<>();

    @Override // android.arch.p005a.p007b.SafeIterableMap
    /* renamed from: a */
    protected SafeIterableMap.C0005c<K, V> mo12921a(K k) {
        return this.f20a.get(k);
    }

    @Override // android.arch.p005a.p007b.SafeIterableMap
    /* renamed from: a */
    public V mo12920a(@NonNull K k, @NonNull V v) {
        SafeIterableMap.C0005c<K, V> mo12921a = mo12921a((FastSafeIterableMap<K, V>) k);
        if (mo12921a != null) {
            return mo12921a.f26b;
        }
        this.f20a.put(k, m12917b(k, v));
        return null;
    }

    @Override // android.arch.p005a.p007b.SafeIterableMap
    /* renamed from: b */
    public V mo12918b(@NonNull K k) {
        V v = (V) super.mo12918b(k);
        this.f20a.remove(k);
        return v;
    }

    /* renamed from: c */
    public boolean m12925c(K k) {
        return this.f20a.containsKey(k);
    }

    /* renamed from: d */
    public Map.Entry<K, V> m12924d(K k) {
        if (m12925c(k)) {
            return this.f20a.get(k).f28d;
        }
        return null;
    }
}
