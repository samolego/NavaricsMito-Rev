package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C1188R;

/* loaded from: classes.dex */
public class zzaj {

    /* renamed from: Dc */
    private final Resources f2805Dc;

    /* renamed from: Dd */
    private final String f2806Dd;

    public zzaj(Context context) {
        zzac.zzy(context);
        this.f2805Dc = context.getResources();
        this.f2806Dd = this.f2805Dc.getResourcePackageName(C1188R.string.common_google_play_services_unknown_issue);
    }

    public String getString(String str) {
        int identifier = this.f2805Dc.getIdentifier(str, "string", this.f2806Dd);
        if (identifier == 0) {
            return null;
        }
        return this.f2805Dc.getString(identifier);
    }
}
