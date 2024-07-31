package org.greenrobot.essentials.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: AbstractMultimap.java */
/* renamed from: org.greenrobot.essentials.collections.a, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class AbstractMultimap<K, V, C extends Collection<V>> implements Map<K, C> {

    /* renamed from: a */
    protected Map<K, C> f11759a;

    /* renamed from: a */
    protected abstract C mo12054a();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m12058a((AbstractMultimap<K, V, C>) obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMultimap(Map<K, C> map) {
        this.f11759a = map;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends C> map) {
        this.f11759a.putAll(map);
    }

    @Override // java.util.Map
    public synchronized int size() {
        return this.f11759a.size();
    }

    @Override // java.util.Map
    public synchronized boolean isEmpty() {
        return this.f11759a.isEmpty();
    }

    @Override // java.util.Map
    public synchronized boolean containsKey(Object obj) {
        return this.f11759a.containsKey(obj);
    }

    @Override // java.util.Map
    public synchronized boolean containsValue(Object obj) {
        return this.f11759a.containsValue(obj);
    }

    @Override // java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized C get(Object obj) {
        return this.f11759a.get(obj);
    }

    @Override // java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized C remove(Object obj) {
        return this.f11759a.remove(obj);
    }

    @Override // java.util.Map
    public synchronized void clear() {
        this.f11759a.clear();
    }

    @Override // java.util.Map
    public synchronized Set<K> keySet() {
        return this.f11759a.keySet();
    }

    @Override // java.util.Map
    public synchronized Collection<C> values() {
        return this.f11759a.values();
    }

    @Override // java.util.Map
    public synchronized boolean equals(Object obj) {
        return this.f11759a.equals(obj);
    }

    @Override // java.util.Map
    public synchronized int hashCode() {
        return this.f11759a.hashCode();
    }

    /* renamed from: a */
    public synchronized int m12056a(K k, V v) {
        C c;
        c = this.f11759a.get(k);
        if (c == null) {
            c = mo12054a();
            this.f11759a.put(k, c);
        }
        c.add(v);
        return c.size();
    }

    /* renamed from: a */
    public synchronized C m12058a(K k, C c) {
        return this.f11759a.put(k, c);
    }

    @Override // java.util.Map
    public synchronized Set<Map.Entry<K, C>> entrySet() {
        return this.f11759a.entrySet();
    }
}