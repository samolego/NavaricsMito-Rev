package com.bumptech.glide.util;

import android.support.p008v4.util.ArrayMap;
import android.support.p008v4.util.SimpleArrayMap;

/* loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: a */
    private int f1280a;

    @Override // android.support.p008v4.util.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f1280a = 0;
        super.clear();
    }

    @Override // android.support.p008v4.util.SimpleArrayMap
    public V setValueAt(int i, V v) {
        this.f1280a = 0;
        return (V) super.setValueAt(i, v);
    }

    @Override // android.support.p008v4.util.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.f1280a = 0;
        return (V) super.put(k, v);
    }

    @Override // android.support.p008v4.util.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f1280a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // android.support.p008v4.util.SimpleArrayMap
    public V removeAt(int i) {
        this.f1280a = 0;
        return (V) super.removeAt(i);
    }

    @Override // android.support.p008v4.util.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f1280a == 0) {
            this.f1280a = super.hashCode();
        }
        return this.f1280a;
    }
}
