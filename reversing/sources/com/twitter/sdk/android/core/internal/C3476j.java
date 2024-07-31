package com.twitter.sdk.android.core.internal;

import android.content.Context;
import com.twitter.sdk.android.core.InterfaceC2645h;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.internal.p079b.PreferenceStore;
import com.twitter.sdk.android.core.internal.p079b.PreferenceStoreImpl;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* renamed from: com.twitter.sdk.android.core.internal.j */
/* loaded from: classes2.dex */
public class IdManager {

    /* renamed from: d */
    private static final Pattern f8519d = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: e */
    private static final String f8520e = Pattern.quote("/");

    /* renamed from: a */
    AdvertisingInfoProvider f8521a;

    /* renamed from: b */
    AdvertisingInfo f8522b;

    /* renamed from: c */
    boolean f8523c;

    /* renamed from: f */
    private final ReentrantLock f8524f;

    /* renamed from: g */
    private final boolean f8525g;

    /* renamed from: h */
    private final String f8526h;

    /* renamed from: i */
    private final PreferenceStore f8527i;

    public IdManager(Context context) {
        this(context, new PreferenceStoreImpl(context, "com.twitter.sdk.android.AdvertisingPreferences"));
    }

    IdManager(Context context, PreferenceStore preferenceStore) {
        this(context, preferenceStore, new AdvertisingInfoProvider(context, preferenceStore));
    }

    IdManager(Context context, PreferenceStore preferenceStore, AdvertisingInfoProvider advertisingInfoProvider) {
        this.f8524f = new ReentrantLock();
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        this.f8526h = context.getPackageName();
        this.f8521a = advertisingInfoProvider;
        this.f8527i = preferenceStore;
        this.f8525g = CommonUtils.m4451a(context, "com.twitter.sdk.android.COLLECT_IDENTIFIERS_ENABLED", true);
        if (this.f8525g) {
            return;
        }
        InterfaceC2645h m4253h = Twitter.m4253h();
        m4253h.mo4561a("Twitter", "Device ID collection disabled for " + context.getPackageName());
    }

    /* renamed from: a */
    private String m4438a(String str) {
        if (str == null) {
            return null;
        }
        return f8519d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public String m4439a() {
        if (this.f8525g) {
            String string = this.f8527i.mo4481a().getString("installation_uuid", null);
            return string == null ? m4435d() : string;
        }
        return "";
    }

    /* renamed from: d */
    private String m4435d() {
        this.f8524f.lock();
        try {
            String string = this.f8527i.mo4481a().getString("installation_uuid", null);
            if (string == null) {
                string = m4438a(UUID.randomUUID().toString());
                this.f8527i.mo4480a(this.f8527i.mo4479b().putString("installation_uuid", string));
            }
            return string;
        } finally {
            this.f8524f.unlock();
        }
    }

    /* renamed from: b */
    synchronized AdvertisingInfo m4437b() {
        if (!this.f8523c) {
            this.f8522b = this.f8521a.m4475a();
            this.f8523c = true;
        }
        return this.f8522b;
    }

    /* renamed from: c */
    public String m4436c() {
        AdvertisingInfo m4437b;
        if (!this.f8525g || (m4437b = m4437b()) == null) {
            return null;
        }
        return m4437b.f8493a;
    }
}
