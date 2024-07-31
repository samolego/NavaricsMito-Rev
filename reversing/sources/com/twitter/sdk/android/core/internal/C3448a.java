package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.twitter.sdk.android.core.internal.a */
/* loaded from: classes2.dex */
public class ActivityLifecycleManager {

    /* renamed from: a */
    private final C2655a f8484a;

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: com.twitter.sdk.android.core.internal.a$b */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC2657b {
        /* renamed from: a */
        public void mo4431a(Activity activity) {
        }

        /* renamed from: a */
        public void m4506a(Activity activity, Bundle bundle) {
        }

        /* renamed from: b */
        public void m4505b(Activity activity) {
        }

        /* renamed from: b */
        public void m4504b(Activity activity, Bundle bundle) {
        }

        /* renamed from: c */
        public void m4503c(Activity activity) {
        }

        /* renamed from: d */
        public void m4502d(Activity activity) {
        }

        /* renamed from: e */
        public void m4501e(Activity activity) {
        }
    }

    public ActivityLifecycleManager(Context context) {
        this.f8484a = new C2655a((Application) context.getApplicationContext());
    }

    /* renamed from: a */
    public boolean m4510a(AbstractC2657b abstractC2657b) {
        C2655a c2655a = this.f8484a;
        return c2655a != null && c2655a.m4508a(abstractC2657b);
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: com.twitter.sdk.android.core.internal.a$a */
    /* loaded from: classes2.dex */
    private static class C2655a {

        /* renamed from: a */
        private final Set<Application.ActivityLifecycleCallbacks> f8485a = new HashSet();

        /* renamed from: b */
        private final Application f8486b;

        C2655a(Application application) {
            this.f8486b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m4508a(final AbstractC2657b abstractC2657b) {
            if (this.f8486b != null) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.twitter.sdk.android.core.internal.a.a.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        abstractC2657b.m4506a(activity, bundle);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                        abstractC2657b.mo4431a(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                        abstractC2657b.m4505b(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        abstractC2657b.m4503c(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                        abstractC2657b.m4502d(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        abstractC2657b.m4504b(activity, bundle);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                        abstractC2657b.m4501e(activity);
                    }
                };
                this.f8486b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                this.f8485a.add(activityLifecycleCallbacks);
                return true;
            }
            return false;
        }
    }
}
