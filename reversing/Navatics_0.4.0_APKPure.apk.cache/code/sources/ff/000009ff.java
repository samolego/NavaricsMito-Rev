package com.p008a.p009a;

/* compiled from: Permission.java */
/* renamed from: com.a.a.a, reason: use source file name */
/* loaded from: classes.dex */
public class Permission {

    /* renamed from: a */
    public final String permissionName;

    /* renamed from: b */
    public final boolean granted;

    /* renamed from: c */
    public final boolean shouldShowRequestPermissionRationale;

    public Permission(String permissionName, boolean granted, boolean shouldShowRequestPermissionRationale) {
        this.permissionName = permissionName;
        this.granted = granted;
        this.shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Permission permission = (Permission) obj;
        if (this.granted == permission.granted && this.shouldShowRequestPermissionRationale == permission.shouldShowRequestPermissionRationale) {
            return this.permissionName.equals(permission.permissionName);
        }
        return false;
    }

    public int hashCode() {
        return (((this.permissionName.hashCode() * 31) + (this.granted ? 1 : 0)) * 31) + (this.shouldShowRequestPermissionRationale ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.permissionName + "', granted=" + this.granted + ", shouldShowRequestPermissionRationale=" + this.shouldShowRequestPermissionRationale + '}';
    }
}