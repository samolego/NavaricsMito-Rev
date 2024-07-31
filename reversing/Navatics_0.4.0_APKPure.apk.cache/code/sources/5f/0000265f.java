package org.apache.log4j;

import java.util.Hashtable;
import java.util.Stack;

/* compiled from: NDC.java */
/* renamed from: org.apache.log4j.n */
/* loaded from: classes2.dex */
public class C3229n {

    /* renamed from: a */
    static Hashtable f11291a = new Hashtable();

    /* renamed from: b */
    static int f11292b = 0;

    /* compiled from: NDC.java */
    /* renamed from: org.apache.log4j.n$a */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a */
        String f11293a;
    }

    /* renamed from: b */
    private static Stack m11369b() {
        Hashtable hashtable = f11291a;
        if (hashtable != null) {
            return (Stack) hashtable.get(Thread.currentThread());
        }
        return null;
    }

    /* renamed from: a */
    public static String m11368a() {
        Stack m11369b = m11369b();
        if (m11369b == null || m11369b.isEmpty()) {
            return null;
        }
        return ((a) m11369b.peek()).f11293a;
    }
}