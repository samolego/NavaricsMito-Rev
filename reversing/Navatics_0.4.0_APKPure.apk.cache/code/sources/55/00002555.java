package org.apache.commons.pool2;

import java.io.Closeable;
import java.util.NoSuchElementException;

/* compiled from: KeyedObjectPool.java */
/* renamed from: org.apache.commons.pool2.d */
/* loaded from: classes2.dex */
public interface KeyedObjectPool<K, V> extends Closeable {
    /* renamed from: a */
    V mo10650a(K k) throws Exception, NoSuchElementException, IllegalStateException;

    /* renamed from: a */
    void mo10651a(K k, V v) throws Exception;
}