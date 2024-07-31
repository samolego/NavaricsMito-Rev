package com.twitter.sdk.android.core.internal;

import android.content.Context;
import com.twitter.sdk.android.core.Twitter;

/* renamed from: com.twitter.sdk.android.core.internal.d */
/* loaded from: classes2.dex */
class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {

    /* renamed from: a */
    private final Context f8504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvertisingInfoReflectionStrategy(Context context) {
        this.f8504a = context.getApplicationContext();
    }

    /* renamed from: a */
    boolean m4465a(Context context) {
        try {
            return ((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context)).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.twitter.sdk.android.core.internal.AdvertisingInfoStrategy
    /* renamed from: a */
    public AdvertisingInfo mo4457a() {
        if (m4465a(this.f8504a)) {
            return new AdvertisingInfo(m4464b(), m4463c());
        }
        return null;
    }

    /* renamed from: b */
    private String m4464b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m4462d(), new Object[0]);
        } catch (Exception unused) {
            Twitter.m4253h().mo4559b("Twitter", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* renamed from: c */
    private boolean m4463c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m4462d(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            Twitter.m4253h().mo4559b("Twitter", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* renamed from: d */
    private Object m4462d() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, this.f8504a);
        } catch (Exception unused) {
            Twitter.m4253h().mo4559b("Twitter", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }
}
