package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* compiled from: PropertyConfigurator.java */
/* renamed from: org.apache.log4j.t */
/* loaded from: classes2.dex */
class C3251t implements Enumeration {

    /* renamed from: a */
    private Enumeration f11328a;

    public C3251t(Hashtable hashtable) {
        Enumeration keys = hashtable.keys();
        Vector vector = new Vector(hashtable.size());
        int i = 0;
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            int i2 = 0;
            while (i2 < i && str.compareTo((String) vector.get(i2)) > 0) {
                i2++;
            }
            vector.add(i2, str);
            i++;
        }
        this.f11328a = vector.elements();
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f11328a.hasMoreElements();
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return this.f11328a.nextElement();
    }
}