package org.apache.log4j;

/* compiled from: CategoryKey.java */
/* renamed from: org.apache.log4j.d, reason: use source file name */
/* loaded from: classes2.dex */
class CategoryKey {

    /* renamed from: c */
    static Class f11212c;

    /* renamed from: a */
    String f11213a;

    /* renamed from: b */
    int f11214b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CategoryKey(String str) {
        this.f11213a = str;
        this.f11214b = str.hashCode();
    }

    public final int hashCode() {
        return this.f11214b;
    }

    /* renamed from: a */
    static Class m11271a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Class<?> cls = f11212c;
        if (cls == null) {
            cls = m11271a("org.apache.log4j.d");
            f11212c = cls;
        }
        if (cls == obj.getClass()) {
            return this.f11213a.equals(((CategoryKey) obj).f11213a);
        }
        return false;
    }
}