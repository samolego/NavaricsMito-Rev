package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import com.twitter.sdk.android.core.Twitter;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.twitter.sdk.android.core.identity.b */
/* loaded from: classes2.dex */
public class AuthState {

    /* renamed from: a */
    final AtomicReference<AuthHandler> f8464a = new AtomicReference<>(null);

    /* renamed from: a */
    public boolean m4542a(Activity activity, AuthHandler authHandler) {
        if (m4543a()) {
            Twitter.m4253h().mo4559b("Twitter", "Authorize already in progress");
        } else if (authHandler.mo4524a(activity)) {
            boolean compareAndSet = this.f8464a.compareAndSet(null, authHandler);
            if (compareAndSet) {
                return compareAndSet;
            }
            Twitter.m4253h().mo4559b("Twitter", "Failed to update authHandler, authorize already in progress.");
            return compareAndSet;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m4543a() {
        return this.f8464a.get() != null;
    }
}
