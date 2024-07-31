package com.google.android.gms.location;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.internal.ClientIdentity;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final Comparator<ActivityTransition> agL = new Comparator<ActivityTransition>() { // from class: com.google.android.gms.location.ActivityTransitionRequest.1
        @Override // java.util.Comparator
        /* renamed from: zza */
        public int compare(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
            int zzbeb = activityTransition.zzbeb();
            int zzbeb2 = activityTransition2.zzbeb();
            if (zzbeb != zzbeb2) {
                return zzbeb < zzbeb2 ? -1 : 1;
            }
            int zzbpc = activityTransition.zzbpc();
            int zzbpc2 = activityTransition2.zzbpc();
            if (zzbpc == zzbpc2) {
                return 0;
            }
            return zzbpc < zzbpc2 ? -1 : 1;
        }
    };
    private final List<ActivityTransition> agM;
    private final List<ClientIdentity> agN;
    @Nullable
    private final String mTag;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityTransitionRequest(int i, List<ActivityTransition> list, @Nullable String str, @Nullable List<ClientIdentity> list2) {
        zzac.zzb(list, "transitions can't be null");
        zzac.zzb(list.size() > 0, "transitions can't be empty.");
        zzab(list);
        this.mVersionCode = i;
        this.agM = Collections.unmodifiableList(list);
        this.mTag = str;
        this.agN = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    private static void zzab(List<ActivityTransition> list) {
        TreeSet treeSet = new TreeSet(agL);
        for (ActivityTransition activityTransition : list) {
            zzac.zzb(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
        return zzab.equal(this.agM, activityTransitionRequest.agM) && zzab.equal(this.mTag, activityTransitionRequest.mTag) && zzab.equal(this.agN, activityTransitionRequest.agN);
    }

    @Nullable
    public String getTag() {
        return this.mTag;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        int hashCode = this.agM.hashCode() * 31;
        String str = this.mTag;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.agN;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String valueOf = String.valueOf(this.agM);
        String str = this.mTag;
        String valueOf2 = String.valueOf(this.agN);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append("'");
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public List<ActivityTransition> zzbpd() {
        return this.agM;
    }

    public List<ClientIdentity> zzbpe() {
        return this.agN;
    }
}
