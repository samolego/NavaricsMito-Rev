package org.apache.commons.pool2;

import java.io.Closeable;
import java.util.NoSuchElementException;

/* renamed from: org.apache.commons.pool2.d */
/* loaded from: classes2.dex */
public interface KeyedObjectPool<K, V> extends Closeable {
    /* renamed from: a */
    V mo2070a(K k) throws Exception, NoSuchElementException, IllegalStateException;

    /* renamed from: a */
    void mo2068a(K k, V v) throws Exception;
}
