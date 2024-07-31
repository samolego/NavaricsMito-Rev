package com.google.android.gms.internal;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzaok extends zzaoh {
    private final zzapf<String, zzaoh> ble = new zzapf<>();

    private zzaoh zzcm(Object obj) {
        return obj == null ? zzaoj.bld : new zzaon(obj);
    }

    public Set<Map.Entry<String, zzaoh>> entrySet() {
        return this.ble.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzaok) && ((zzaok) obj).ble.equals(this.ble));
    }

    public boolean has(String str) {
        return this.ble.containsKey(str);
    }

    public int hashCode() {
        return this.ble.hashCode();
    }

    public void zza(String str, zzaoh zzaohVar) {
        if (zzaohVar == null) {
            zzaohVar = zzaoj.bld;
        }
        this.ble.put(str, zzaohVar);
    }

    public void zzb(String str, Boolean bool) {
        zza(str, zzcm(bool));
    }

    public void zzcb(String str, String str2) {
        zza(str, zzcm(str2));
    }

    public zzaoh zzuo(String str) {
        return this.ble.get(str);
    }

    public zzaoe zzup(String str) {
        return (zzaoe) this.ble.get(str);
    }
}
