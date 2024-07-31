package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* compiled from: NullEnumeration.java */
/* renamed from: org.apache.log4j.helpers.f, reason: use source file name */
/* loaded from: classes2.dex */
public class NullEnumeration implements Enumeration {

    /* renamed from: a */
    private static final NullEnumeration f11244a = new NullEnumeration();

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return false;
    }

    private NullEnumeration() {
    }

    /* renamed from: a */
    public static NullEnumeration m11316a() {
        return f11244a;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        throw new NoSuchElementException();
    }
}