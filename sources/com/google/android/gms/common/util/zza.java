package com.google.android.gms.common.util;

import android.support.p008v4.util.ArrayMap;
import android.support.p008v4.util.SimpleArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zza<E> extends AbstractSet<E> {

    /* renamed from: EJ */
    private final ArrayMap<E, E> f2995EJ;

    public zza() {
        this.f2995EJ = new ArrayMap<>();
    }

    public zza(int i) {
        this.f2995EJ = new ArrayMap<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zza(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        if (this.f2995EJ.containsKey(e)) {
            return false;
        }
        this.f2995EJ.put(e, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f2995EJ.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f2995EJ.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f2995EJ.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (this.f2995EJ.containsKey(obj)) {
            this.f2995EJ.remove(obj);
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f2995EJ.size();
    }

    public boolean zza(zza<? extends E> zzaVar) {
        int size = size();
        this.f2995EJ.putAll((SimpleArrayMap<? extends E, ? extends E>) zzaVar.f2995EJ);
        return size() > size;
    }
}
