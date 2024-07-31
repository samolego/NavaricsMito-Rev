package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p008v4.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

/* renamed from: com.facebook.c */
/* loaded from: classes.dex */
public abstract class AccessTokenTracker {

    /* renamed from: a */
    private static final String f1835a = "c";

    /* renamed from: b */
    private final BroadcastReceiver f1836b;

    /* renamed from: c */
    private final LocalBroadcastManager f1837c;

    /* renamed from: d */
    private boolean f1838d = false;

    /* renamed from: a */
    protected abstract void mo10083a(AccessToken accessToken, AccessToken accessToken2);

    public AccessTokenTracker() {
        Validate.m10472a();
        this.f1836b = new C0905a();
        this.f1837c = LocalBroadcastManager.getInstance(FacebookSdk.m10869h());
        m10889a();
    }

    /* renamed from: a */
    public void m10889a() {
        if (this.f1838d) {
            return;
        }
        m10887c();
        this.f1838d = true;
    }

    /* compiled from: AccessTokenTracker.java */
    /* renamed from: com.facebook.c$a */
    /* loaded from: classes.dex */
    private class C0905a extends BroadcastReceiver {
        private C0905a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
                Utility.m10505b(AccessTokenTracker.f1835a, "AccessTokenChanged");
                AccessTokenTracker.this.mo10083a((AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
            }
        }
    }

    /* renamed from: c */
    private void m10887c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.f1837c.registerReceiver(this.f1836b, intentFilter);
    }
}
