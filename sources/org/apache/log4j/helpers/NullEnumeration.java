package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* renamed from: org.apache.log4j.helpers.f */
/* loaded from: classes2.dex */
public class NullEnumeration implements Enumeration {

    /* renamed from: a */
    private static final NullEnumeration f11203a = new NullEnumeration();

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return false;
    }

    private NullEnumeration() {
    }

    /* renamed from: a */
    public static NullEnumeration m1593a() {
        return f11203a;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        throw new NoSuchElementException();
    }
}
