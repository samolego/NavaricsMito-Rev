package org.apache.log4j;

import java.util.Hashtable;
import java.util.Stack;

/* renamed from: org.apache.log4j.n */
/* loaded from: classes2.dex */
public class NDC {

    /* renamed from: a */
    static Hashtable f11250a = new Hashtable();

    /* renamed from: b */
    static int f11251b = 0;

    /* compiled from: NDC.java */
    /* renamed from: org.apache.log4j.n$a */
    /* loaded from: classes2.dex */
    private static class C3045a {

        /* renamed from: a */
        String f11252a;
    }

    /* renamed from: b */
    private static Stack m1547b() {
        Hashtable hashtable = f11250a;
        if (hashtable != null) {
            return (Stack) hashtable.get(Thread.currentThread());
        }
        return null;
    }

    /* renamed from: a */
    public static String m1548a() {
        Stack m1547b = m1547b();
        if (m1547b == null || m1547b.isEmpty()) {
            return null;
        }
        return ((C3045a) m1547b.peek()).f11252a;
    }
}
