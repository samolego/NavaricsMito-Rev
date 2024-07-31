package org.apache.log4j.helpers;

import java.util.Hashtable;

/* compiled from: ThreadLocalMap.java */
/* renamed from: org.apache.log4j.helpers.l, reason: use source file name */
/* loaded from: classes2.dex */
public final class ThreadLocalMap extends InheritableThreadLocal {
    @Override // java.lang.InheritableThreadLocal
    public final Object childValue(Object obj) {
        Hashtable hashtable = (Hashtable) obj;
        if (hashtable != null) {
            return hashtable.clone();
        }
        return null;
    }
}