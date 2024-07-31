package org.apache.log4j;

/* renamed from: org.apache.log4j.d */
/* loaded from: classes2.dex */
class CategoryKey {

    /* renamed from: c */
    static Class f11171c;

    /* renamed from: a */
    String f11172a;

    /* renamed from: b */
    int f11173b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CategoryKey(String str) {
        this.f11172a = str;
        this.f11173b = str.hashCode();
    }

    public final int hashCode() {
        return this.f11173b;
    }

    /* renamed from: a */
    static Class m1620a(String str) {
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
        if (obj != null) {
            Class<?> cls = f11171c;
            if (cls == null) {
                cls = m1620a("org.apache.log4j.d");
                f11171c = cls;
            }
            if (cls == obj.getClass()) {
                return this.f11172a.equals(((CategoryKey) obj).f11172a);
            }
            return false;
        }
        return false;
    }
}
