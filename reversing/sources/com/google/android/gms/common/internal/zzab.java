package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class zzab {

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: CU */
        private final List<String> f2802CU;
        private final Object zzctc;

        private zza(Object obj) {
            this.zzctc = zzac.zzy(obj);
            this.f2802CU = new ArrayList();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzctc.getClass().getSimpleName());
            sb.append('{');
            int size = this.f2802CU.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.f2802CU.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public zza zzg(String str, Object obj) {
            List<String> list = this.f2802CU;
            String str2 = (String) zzac.zzy(str);
            String valueOf = String.valueOf(String.valueOf(obj));
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzx(Object obj) {
        return new zza(obj);
    }
}
