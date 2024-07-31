package com.twitter.sdk.android.core.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.internal.p079b.PreferenceStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.twitter.sdk.android.core.internal.c */
/* loaded from: classes2.dex */
public class AdvertisingInfoProvider {

    /* renamed from: a */
    private final Context f8500a;

    /* renamed from: b */
    private final PreferenceStore f8501b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvertisingInfoProvider(Context context, PreferenceStore preferenceStore) {
        this.f8500a = context.getApplicationContext();
        this.f8501b = preferenceStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public AdvertisingInfo m4475a() {
        AdvertisingInfo m4471b = m4471b();
        if (m4468c(m4471b)) {
            Twitter.m4253h().mo4561a("Twitter", "Using AdvertisingInfo from Preference Store");
            m4474a(m4471b);
            return m4471b;
        }
        AdvertisingInfo m4466e = m4466e();
        m4470b(m4466e);
        return m4466e;
    }

    /* renamed from: a */
    private void m4474a(final AdvertisingInfo advertisingInfo) {
        new Thread(new Runnable() { // from class: com.twitter.sdk.android.core.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                AdvertisingInfo m4466e = AdvertisingInfoProvider.this.m4466e();
                if (advertisingInfo.equals(m4466e)) {
                    return;
                }
                Twitter.m4253h().mo4561a("Twitter", "Asychronously getting Advertising Info and storing it to preferences");
                AdvertisingInfoProvider.this.m4470b(m4466e);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void m4470b(AdvertisingInfo advertisingInfo) {
        if (m4468c(advertisingInfo)) {
            PreferenceStore preferenceStore = this.f8501b;
            preferenceStore.mo4480a(preferenceStore.mo4479b().putString("advertising_id", advertisingInfo.f8493a).putBoolean("limit_ad_tracking_enabled", advertisingInfo.f8494b));
            return;
        }
        PreferenceStore preferenceStore2 = this.f8501b;
        preferenceStore2.mo4480a(preferenceStore2.mo4479b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    /* renamed from: b */
    private AdvertisingInfo m4471b() {
        return new AdvertisingInfo(this.f8501b.mo4481a().getString("advertising_id", ""), this.f8501b.mo4481a().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* renamed from: c */
    private AdvertisingInfoStrategy m4469c() {
        return new AdvertisingInfoReflectionStrategy(this.f8500a);
    }

    /* renamed from: d */
    private AdvertisingInfoStrategy m4467d() {
        return new AdvertisingInfoServiceStrategy(this.f8500a);
    }

    /* renamed from: c */
    private boolean m4468c(AdvertisingInfo advertisingInfo) {
        return (advertisingInfo == null || TextUtils.isEmpty(advertisingInfo.f8493a)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public AdvertisingInfo m4466e() {
        AdvertisingInfo mo4457a = m4469c().mo4457a();
        if (!m4468c(mo4457a)) {
            mo4457a = m4467d().mo4457a();
            if (!m4468c(mo4457a)) {
                Twitter.m4253h().mo4561a("Twitter", "AdvertisingInfo not present");
            } else {
                Twitter.m4253h().mo4561a("Twitter", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            Twitter.m4253h().mo4561a("Twitter", "Using AdvertisingInfo from Reflection Provider");
        }
        return mo4457a;
    }
}
