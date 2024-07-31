package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
    public static final Parcelable.Creator<Configuration> CREATOR = new zza();
    public final int axl;
    public final Flag[] axm;
    public final String[] axn;
    public final Map<String, Flag> axo = new TreeMap();
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Configuration(int i, int i2, Flag[] flagArr, String[] strArr) {
        this.mVersionCode = i;
        this.axl = i2;
        this.axm = flagArr;
        for (Flag flag : flagArr) {
            this.axo.put(flag.name, flag);
        }
        this.axn = strArr;
        String[] strArr2 = this.axn;
        if (strArr2 != null) {
            Arrays.sort(strArr2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return this.mVersionCode == configuration.mVersionCode && this.axl == configuration.axl && zzab.equal(this.axo, configuration.axo) && Arrays.equals(this.axn, configuration.axn);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.axl);
        sb.append(", ");
        sb.append("(");
        for (Flag flag : this.axo.values()) {
            sb.append(flag);
            sb.append(", ");
        }
        sb.append(")");
        sb.append(", ");
        sb.append("(");
        String[] strArr = this.axn;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append(")");
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public int compareTo(Configuration configuration) {
        return this.axl - configuration.axl;
    }
}
