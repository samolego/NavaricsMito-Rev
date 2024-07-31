package org.apache.commons.pool2;

/* compiled from: KeyedPooledObjectFactory.java */
/* renamed from: org.apache.commons.pool2.e, reason: use source file name */
/* loaded from: classes2.dex */
public interface KeyedPooledObjectFactory<K, V> {
    /* renamed from: a */
    void mo6356a(K k, InterfaceC3016h<V> interfaceC3016h) throws Exception;

    /* renamed from: b */
    void mo10641b(K k, InterfaceC3016h<V> interfaceC3016h) throws Exception;

    /* renamed from: c */
    InterfaceC3016h<V> mo10642c(K k) throws Exception;

    /* renamed from: c */
    boolean mo10643c(K k, InterfaceC3016h<V> interfaceC3016h);

    /* renamed from: d */
    void mo10644d(K k, InterfaceC3016h<V> interfaceC3016h) throws Exception;
}