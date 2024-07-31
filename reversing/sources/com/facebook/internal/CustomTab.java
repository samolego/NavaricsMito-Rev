package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;

/* renamed from: com.facebook.internal.d */
/* loaded from: classes.dex */
public class CustomTab {

    /* renamed from: a */
    private Uri f1939a;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        String m10556a = ServerProtocol.m10556a();
        this.f1939a = Utility.m10526a(m10556a, FacebookSdk.m10868i() + "/dialog/" + str, bundle);
    }

    /* renamed from: a */
    public void m10736a(Activity activity, String str) {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setPackage(str);
        build.intent.addFlags(1073741824);
        build.launchUrl(activity, this.f1939a);
    }
}
