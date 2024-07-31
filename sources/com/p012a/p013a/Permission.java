package com.p012a.p013a;

/* renamed from: com.a.a.a */
/* loaded from: classes.dex */
public class Permission {

    /* renamed from: a */
    public final String f337a;

    /* renamed from: b */
    public final boolean f338b;

    /* renamed from: c */
    public final boolean f339c;

    public Permission(String str, boolean z, boolean z2) {
        this.f337a = str;
        this.f338b = z;
        this.f339c = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Permission permission = (Permission) obj;
        if (this.f338b == permission.f338b && this.f339c == permission.f339c) {
            return this.f337a.equals(permission.f337a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f337a.hashCode() * 31) + (this.f338b ? 1 : 0)) * 31) + (this.f339c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f337a + "', granted=" + this.f338b + ", shouldShowRequestPermissionRationale=" + this.f339c + '}';
    }
}
