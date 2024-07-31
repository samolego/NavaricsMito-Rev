package com.facebook;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.p008v4.content.LocalBroadcastManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

/* renamed from: com.facebook.l */
/* loaded from: classes.dex */
public final class ProfileManager {

    /* renamed from: a */
    private static volatile ProfileManager f2123a;

    /* renamed from: b */
    private final LocalBroadcastManager f2124b;

    /* renamed from: c */
    private final ProfileCache f2125c;

    /* renamed from: d */
    private Profile f2126d;

    ProfileManager(LocalBroadcastManager localBroadcastManager, ProfileCache profileCache) {
        Validate.m10469a(localBroadcastManager, "localBroadcastManager");
        Validate.m10469a(profileCache, "profileCache");
        this.f2124b = localBroadcastManager;
        this.f2125c = profileCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static ProfileManager m10403a() {
        if (f2123a == null) {
            synchronized (ProfileManager.class) {
                if (f2123a == null) {
                    f2123a = new ProfileManager(LocalBroadcastManager.getInstance(FacebookSdk.m10869h()), new ProfileCache());
                }
            }
        }
        return f2123a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Profile m10399b() {
        return this.f2126d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m10398c() {
        Profile m10406a = this.f2125c.m10406a();
        if (m10406a != null) {
            m10400a(m10406a, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10402a(@Nullable Profile profile) {
        m10400a(profile, true);
    }

    /* renamed from: a */
    private void m10400a(@Nullable Profile profile, boolean z) {
        Profile profile2 = this.f2126d;
        this.f2126d = profile;
        if (z) {
            if (profile != null) {
                this.f2125c.m10405a(profile);
            } else {
                this.f2125c.m10404b();
            }
        }
        if (Utility.m10533a(profile2, profile)) {
            return;
        }
        m10401a(profile2, profile);
    }

    /* renamed from: a */
    private void m10401a(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.f2124b.sendBroadcast(intent);
    }
}
