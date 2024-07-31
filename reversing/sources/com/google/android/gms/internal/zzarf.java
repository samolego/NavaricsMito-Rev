package com.google.android.gms.internal;

import com.google.android.gms.internal.zzare;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class zzarf<M extends zzare<M>, T> {
    protected final Class<T> bhd;
    protected final boolean bqw;
    public final int tag;
    protected final int type;

    private zzarf(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.bhd = cls;
        this.tag = i2;
        this.bqw = z;
    }

    public static <M extends zzare<M>, T extends zzark> zzarf<M, T> zza(int i, Class<T> cls, long j) {
        return new zzarf<>(i, cls, (int) j, false);
    }

    private T zzaz(List<zzarm> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzarm zzarmVar = list.get(i);
            if (zzarmVar.avk.length != 0) {
                zza(zzarmVar, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class<T> cls = this.bhd;
        T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzba(List<zzarm> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.bhd.cast(zzck(zzarc.zzbd(list.get(list.size() - 1).avk)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzarf) {
            zzarf zzarfVar = (zzarf) obj;
            return this.type == zzarfVar.type && this.bhd == zzarfVar.bhd && this.tag == zzarfVar.tag && this.bqw == zzarfVar.bqw;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.type + 1147) * 31) + this.bhd.hashCode()) * 31) + this.tag) * 31) + (this.bqw ? 1 : 0);
    }

    protected void zza(zzarm zzarmVar, List<Object> list) {
        list.add(zzck(zzarc.zzbd(zzarmVar.avk)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(Object obj, zzard zzardVar) throws IOException {
        if (this.bqw) {
            zzc(obj, zzardVar);
        } else {
            zzb(obj, zzardVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final T zzay(List<zzarm> list) {
        if (list == null) {
            return null;
        }
        return this.bqw ? zzaz(list) : zzba(list);
    }

    protected void zzb(Object obj, zzard zzardVar) {
        try {
            zzardVar.zzahm(this.tag);
            switch (this.type) {
                case 10:
                    int zzahu = zzarn.zzahu(this.tag);
                    zzardVar.zzb((zzark) obj);
                    zzardVar.zzai(zzahu, 4);
                    return;
                case 11:
                    zzardVar.zzc((zzark) obj);
                    return;
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    protected void zzc(Object obj, zzard zzardVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzardVar);
            }
        }
    }

    protected Object zzck(zzarc zzarcVar) {
        Class componentType = this.bqw ? this.bhd.getComponentType() : this.bhd;
        try {
            switch (this.type) {
                case 10:
                    zzark zzarkVar = (zzark) componentType.newInstance();
                    zzarcVar.zza(zzarkVar, zzarn.zzahu(this.tag));
                    return zzarkVar;
                case 11:
                    zzark zzarkVar2 = (zzark) componentType.newInstance();
                    zzarcVar.zza(zzarkVar2);
                    return zzarkVar2;
                default:
                    int i = this.type;
                    StringBuilder sb = new StringBuilder(24);
                    sb.append("Unknown type ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e2);
        } catch (InstantiationException e3) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzcu(Object obj) {
        return this.bqw ? zzcv(obj) : zzcw(obj);
    }

    protected int zzcv(Object obj) {
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzcw(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzcw(Object obj) {
        int zzahu = zzarn.zzahu(this.tag);
        int i = this.type;
        switch (i) {
            case 10:
                return zzard.zzb(zzahu, (zzark) obj);
            case 11:
                return zzard.zzc(zzahu, (zzark) obj);
            default:
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }
}
