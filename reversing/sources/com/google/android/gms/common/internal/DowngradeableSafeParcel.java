package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: Ce */
    private static final Object f2772Ce = new Object();

    /* renamed from: Cf */
    private static ClassLoader f2773Cf = null;

    /* renamed from: Cg */
    private static Integer f2774Cg = null;

    /* renamed from: Ch */
    private boolean f2775Ch = false;

    protected static ClassLoader zzaup() {
        synchronized (f2772Ce) {
        }
        return null;
    }

    protected static Integer zzauq() {
        synchronized (f2772Ce) {
        }
        return null;
    }

    private static boolean zzd(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    protected static boolean zzhs(String str) {
        ClassLoader zzaup = zzaup();
        if (zzaup == null) {
            return true;
        }
        try {
            return zzd(zzaup.loadClass(str));
        } catch (Exception unused) {
            return false;
        }
    }

    protected boolean zzaur() {
        return false;
    }
}
