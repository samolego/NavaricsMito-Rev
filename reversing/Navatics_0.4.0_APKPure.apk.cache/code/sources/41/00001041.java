package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C1072R;

/* loaded from: classes.dex */
public class zzaj {

    /* renamed from: Dc */
    private final Resources f2813Dc;

    /* renamed from: Dd */
    private final String f2814Dd;

    public zzaj(Context context) {
        zzac.zzy(context);
        this.f2813Dc = context.getResources();
        this.f2814Dd = this.f2813Dc.getResourcePackageName(C1072R.string.common_google_play_services_unknown_issue);
    }

    public String getString(String str) {
        int identifier = this.f2813Dc.getIdentifier(str, "string", this.f2814Dd);
        if (identifier == 0) {
            return null;
        }
        return this.f2813Dc.getString(identifier);
    }
}