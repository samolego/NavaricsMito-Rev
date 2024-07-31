package org.apache.commons.pool2;

import java.io.Closeable;
import java.util.NoSuchElementException;

/* compiled from: ObjectPool.java */
/* renamed from: org.apache.commons.pool2.f */
/* loaded from: classes2.dex */
public interface ObjectPool<T> extends Closeable {
    /* renamed from: a */
    T mo10652a() throws Exception, NoSuchElementException, IllegalStateException;

    /* renamed from: a */
    void mo10653a(T t) throws Exception;
}