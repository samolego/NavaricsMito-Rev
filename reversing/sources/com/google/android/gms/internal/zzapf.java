package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzapf<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> blR = new Comparator<Comparable>() { // from class: com.google.android.gms.internal.zzapf.1
        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> aWP;
    zzd<K, V> blS;
    final zzd<K, V> blT;
    private zza blU;
    private zzb blV;
    int modCount;
    int size;

    /* loaded from: classes.dex */
    class zza extends AbstractSet<Map.Entry<K, V>> {
        zza() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            zzapf.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && zzapf.this.zzc((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new zzc<Map.Entry<K, V>>() { // from class: com.google.android.gms.internal.zzapf.zza.1
                {
                    zzapf zzapfVar = zzapf.this;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return m9649bi();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            zzd<K, V> zzc;
            if ((obj instanceof Map.Entry) && (zzc = zzapf.this.zzc((Map.Entry) obj)) != null) {
                zzapf.this.zza((zzd) zzc, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return zzapf.this.size;
        }
    }

    /* loaded from: classes.dex */
    final class zzb extends AbstractSet<K> {
        zzb() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            zzapf.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return zzapf.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new zzc<K>() { // from class: com.google.android.gms.internal.zzapf.zzb.1
                {
                    zzapf zzapfVar = zzapf.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return m9649bi().aXd;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return zzapf.this.zzcs(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return zzapf.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class zzc<T> implements Iterator<T> {
        zzd<K, V> blZ;
        zzd<K, V> bma;
        int bmb;

        private zzc() {
            this.blZ = zzapf.this.blT.blZ;
            this.bma = null;
            this.bmb = zzapf.this.modCount;
        }

        /* renamed from: bi */
        final zzd<K, V> m9649bi() {
            zzd<K, V> zzdVar = this.blZ;
            if (zzdVar != zzapf.this.blT) {
                if (zzapf.this.modCount == this.bmb) {
                    this.blZ = zzdVar.blZ;
                    this.bma = zzdVar;
                    return zzdVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.blZ != zzapf.this.blT;
        }

        @Override // java.util.Iterator
        public final void remove() {
            zzd<K, V> zzdVar = this.bma;
            if (zzdVar == null) {
                throw new IllegalStateException();
            }
            zzapf.this.zza((zzd) zzdVar, true);
            this.bma = null;
            this.bmb = zzapf.this.modCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzd<K, V> implements Map.Entry<K, V> {
        final K aXd;
        zzd<K, V> blZ;
        zzd<K, V> bmc;
        zzd<K, V> bmd;
        zzd<K, V> bme;
        zzd<K, V> bmf;
        int height;
        V value;

        zzd() {
            this.aXd = null;
            this.bmf = this;
            this.blZ = this;
        }

        zzd(zzd<K, V> zzdVar, K k, zzd<K, V> zzdVar2, zzd<K, V> zzdVar3) {
            this.bmc = zzdVar;
            this.aXd = k;
            this.height = 1;
            this.blZ = zzdVar2;
            this.bmf = zzdVar3;
            zzdVar3.blZ = this;
            zzdVar2.bmf = this;
        }

        /* renamed from: bj */
        public zzd<K, V> m9648bj() {
            zzd<K, V> zzdVar = this;
            for (zzd<K, V> zzdVar2 = this.bmd; zzdVar2 != null; zzdVar2 = zzdVar2.bmd) {
                zzdVar = zzdVar2;
            }
            return zzdVar;
        }

        /* renamed from: bk */
        public zzd<K, V> m9647bk() {
            zzd<K, V> zzdVar = this;
            for (zzd<K, V> zzdVar2 = this.bme; zzdVar2 != null; zzdVar2 = zzdVar2.bme) {
                zzdVar = zzdVar2;
            }
            return zzdVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.aXd;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.value;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.aXd;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.aXd;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.aXd);
            String valueOf2 = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append("=");
            sb.append(valueOf2);
            return sb.toString();
        }
    }

    public zzapf() {
        this(blR);
    }

    public zzapf(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.blT = new zzd<>();
        this.aWP = comparator == null ? blR : comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void zza(zzd<K, V> zzdVar) {
        zzd<K, V> zzdVar2 = zzdVar.bmd;
        zzd<K, V> zzdVar3 = zzdVar.bme;
        zzd<K, V> zzdVar4 = zzdVar3.bmd;
        zzd<K, V> zzdVar5 = zzdVar3.bme;
        zzdVar.bme = zzdVar4;
        if (zzdVar4 != null) {
            zzdVar4.bmc = zzdVar;
        }
        zza(zzdVar, zzdVar3);
        zzdVar3.bmd = zzdVar;
        zzdVar.bmc = zzdVar3;
        zzdVar.height = Math.max(zzdVar2 != null ? zzdVar2.height : 0, zzdVar4 != null ? zzdVar4.height : 0) + 1;
        zzdVar3.height = Math.max(zzdVar.height, zzdVar5 != null ? zzdVar5.height : 0) + 1;
    }

    private void zza(zzd<K, V> zzdVar, zzd<K, V> zzdVar2) {
        zzd<K, V> zzdVar3 = zzdVar.bmc;
        zzdVar.bmc = null;
        if (zzdVar2 != null) {
            zzdVar2.bmc = zzdVar3;
        }
        if (zzdVar3 == null) {
            this.blS = zzdVar2;
        } else if (zzdVar3.bmd == zzdVar) {
            zzdVar3.bmd = zzdVar2;
        } else {
            zzdVar3.bme = zzdVar2;
        }
    }

    private void zzb(zzd<K, V> zzdVar) {
        zzd<K, V> zzdVar2 = zzdVar.bmd;
        zzd<K, V> zzdVar3 = zzdVar.bme;
        zzd<K, V> zzdVar4 = zzdVar2.bmd;
        zzd<K, V> zzdVar5 = zzdVar2.bme;
        zzdVar.bmd = zzdVar5;
        if (zzdVar5 != null) {
            zzdVar5.bmc = zzdVar;
        }
        zza(zzdVar, zzdVar2);
        zzdVar2.bme = zzdVar;
        zzdVar.bmc = zzdVar2;
        zzdVar.height = Math.max(zzdVar3 != null ? zzdVar3.height : 0, zzdVar5 != null ? zzdVar5.height : 0) + 1;
        zzdVar2.height = Math.max(zzdVar.height, zzdVar4 != null ? zzdVar4.height : 0) + 1;
    }

    private void zzb(zzd<K, V> zzdVar, boolean z) {
        while (zzdVar != null) {
            zzd<K, V> zzdVar2 = zzdVar.bmd;
            zzd<K, V> zzdVar3 = zzdVar.bme;
            int i = zzdVar2 != null ? zzdVar2.height : 0;
            int i2 = zzdVar3 != null ? zzdVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                zzd<K, V> zzdVar4 = zzdVar3.bmd;
                zzd<K, V> zzdVar5 = zzdVar3.bme;
                int i4 = (zzdVar4 != null ? zzdVar4.height : 0) - (zzdVar5 != null ? zzdVar5.height : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    zzb(zzdVar3);
                }
                zza(zzdVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                zzd<K, V> zzdVar6 = zzdVar2.bmd;
                zzd<K, V> zzdVar7 = zzdVar2.bme;
                int i5 = (zzdVar6 != null ? zzdVar6.height : 0) - (zzdVar7 != null ? zzdVar7.height : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    zza(zzdVar2);
                }
                zzb(zzdVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                zzdVar.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                zzdVar.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            zzdVar = zzdVar.bmc;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.blS = null;
        this.size = 0;
        this.modCount++;
        zzd<K, V> zzdVar = this.blT;
        zzdVar.bmf = zzdVar;
        zzdVar.blZ = zzdVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return zzcr(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        zza zzaVar = this.blU;
        if (zzaVar != null) {
            return zzaVar;
        }
        zza zzaVar2 = new zza();
        this.blU = zzaVar2;
        return zzaVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        zzd<K, V> zzcr = zzcr(obj);
        if (zzcr != null) {
            return zzcr.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        zzb zzbVar = this.blV;
        if (zzbVar != null) {
            return zzbVar;
        }
        zzb zzbVar2 = new zzb();
        this.blV = zzbVar2;
        return zzbVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            zzd<K, V> zza2 = zza((zzapf<K, V>) k, true);
            V v2 = zza2.value;
            zza2.value = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzd<K, V> zzcs = zzcs(obj);
        if (zzcs != null) {
            return zzcs.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    zzd<K, V> zza(K k, boolean z) {
        int i;
        zzd<K, V> zzdVar;
        Comparator<? super K> comparator = this.aWP;
        zzd<K, V> zzdVar2 = this.blS;
        if (zzdVar2 != null) {
            Comparable comparable = comparator == blR ? (Comparable) k : null;
            while (true) {
                i = comparable != null ? comparable.compareTo(zzdVar2.aXd) : comparator.compare(k, (K) zzdVar2.aXd);
                if (i == 0) {
                    return zzdVar2;
                }
                zzd<K, V> zzdVar3 = i < 0 ? zzdVar2.bmd : zzdVar2.bme;
                if (zzdVar3 == null) {
                    break;
                }
                zzdVar2 = zzdVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            zzd<K, V> zzdVar4 = this.blT;
            if (zzdVar2 != null) {
                zzdVar = new zzd<>(zzdVar2, k, zzdVar4, zzdVar4.bmf);
                if (i < 0) {
                    zzdVar2.bmd = zzdVar;
                } else {
                    zzdVar2.bme = zzdVar;
                }
                zzb(zzdVar2, true);
            } else if (comparator == blR && !(k instanceof Comparable)) {
                throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
            } else {
                zzdVar = new zzd<>(zzdVar2, k, zzdVar4, zzdVar4.bmf);
                this.blS = zzdVar;
            }
            this.size++;
            this.modCount++;
            return zzdVar;
        }
        return null;
    }

    void zza(zzd<K, V> zzdVar, boolean z) {
        int i;
        if (z) {
            zzdVar.bmf.blZ = zzdVar.blZ;
            zzdVar.blZ.bmf = zzdVar.bmf;
        }
        zzd<K, V> zzdVar2 = zzdVar.bmd;
        zzd<K, V> zzdVar3 = zzdVar.bme;
        zzd<K, V> zzdVar4 = zzdVar.bmc;
        int i2 = 0;
        if (zzdVar2 == null || zzdVar3 == null) {
            if (zzdVar2 != null) {
                zza(zzdVar, zzdVar2);
                zzdVar.bmd = null;
            } else if (zzdVar3 != null) {
                zza(zzdVar, zzdVar3);
                zzdVar.bme = null;
            } else {
                zza(zzdVar, (zzd) null);
            }
            zzb(zzdVar4, false);
            this.size--;
            this.modCount++;
            return;
        }
        zzd<K, V> m9647bk = zzdVar2.height > zzdVar3.height ? zzdVar2.m9647bk() : zzdVar3.m9648bj();
        zza((zzd) m9647bk, false);
        zzd<K, V> zzdVar5 = zzdVar.bmd;
        if (zzdVar5 != null) {
            i = zzdVar5.height;
            m9647bk.bmd = zzdVar5;
            zzdVar5.bmc = m9647bk;
            zzdVar.bmd = null;
        } else {
            i = 0;
        }
        zzd<K, V> zzdVar6 = zzdVar.bme;
        if (zzdVar6 != null) {
            i2 = zzdVar6.height;
            m9647bk.bme = zzdVar6;
            zzdVar6.bmc = m9647bk;
            zzdVar.bme = null;
        }
        m9647bk.height = Math.max(i, i2) + 1;
        zza(zzdVar, m9647bk);
    }

    zzd<K, V> zzc(Map.Entry<?, ?> entry) {
        zzd<K, V> zzcr = zzcr(entry.getKey());
        if (zzcr != null && equal(zzcr.value, entry.getValue())) {
            return zzcr;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzd<K, V> zzcr(Object obj) {
        if (obj != 0) {
            try {
                return zza((zzapf<K, V>) obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    zzd<K, V> zzcs(Object obj) {
        zzd<K, V> zzcr = zzcr(obj);
        if (zzcr != null) {
            zza((zzd) zzcr, true);
        }
        return zzcr;
    }
}
