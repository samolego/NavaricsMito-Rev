package org.greenrobot.essentials.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: org.greenrobot.essentials.collections.a */
/* loaded from: classes2.dex */
public abstract class AbstractMultimap<K, V, C extends Collection<V>> implements Map<K, C> {

    /* renamed from: a */
    protected Map<K, C> f11718a;

    /* renamed from: a */
    protected abstract C mo756a();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m753a((AbstractMultimap<K, V, C>) obj, (Object) ((Collection) obj2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMultimap(Map<K, C> map) {
        this.f11718a = map;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends C> map) {
        this.f11718a.putAll(map);
    }

    @Override // java.util.Map
    public synchronized int size() {
        return this.f11718a.size();
    }

    @Override // java.util.Map
    public synchronized boolean isEmpty() {
        return this.f11718a.isEmpty();
    }

    @Override // java.util.Map
    public synchronized boolean containsKey(Object obj) {
        return this.f11718a.containsKey(obj);
    }

    @Override // java.util.Map
    public synchronized boolean containsValue(Object obj) {
        return this.f11718a.containsValue(obj);
    }

    @Override // java.util.Map
    /* renamed from: a */
    public synchronized C get(Object obj) {
        return this.f11718a.get(obj);
    }

    @Override // java.util.Map
    /* renamed from: b */
    public synchronized C remove(Object obj) {
        return this.f11718a.remove(obj);
    }

    @Override // java.util.Map
    public synchronized void clear() {
        this.f11718a.clear();
    }

    @Override // java.util.Map
    public synchronized Set<K> keySet() {
        return this.f11718a.keySet();
    }

    @Override // java.util.Map
    public synchronized Collection<C> values() {
        return this.f11718a.values();
    }

    @Override // java.util.Map
    public synchronized boolean equals(Object obj) {
        return this.f11718a.equals(obj);
    }

    @Override // java.util.Map
    public synchronized int hashCode() {
        return this.f11718a.hashCode();
    }

    /* renamed from: a */
    public synchronized int m754a(K k, V v) {
        C c;
        c = this.f11718a.get(k);
        if (c == null) {
            c = mo756a();
            this.f11718a.put(k, c);
        }
        c.add(v);
        return c.size();
    }

    /* renamed from: a */
    public synchronized C m753a(K k, C c) {
        return this.f11718a.put(k, c);
    }

    @Override // java.util.Map
    public synchronized Set<Map.Entry<K, C>> entrySet() {
        return this.f11718a.entrySet();
    }
}
