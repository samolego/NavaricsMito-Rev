package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager.java */
/* renamed from: com.twitter.sdk.android.core.internal.a, reason: use source file name */
/* loaded from: classes2.dex */
public class ActivityLifecycleManager {

    /* renamed from: a */
    private final a f8524a;

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: com.twitter.sdk.android.core.internal.a$b */
    /* loaded from: classes2.dex */
    public static abstract class b {
        /* renamed from: a */
        public void mo8355a(Activity activity) {
        }

        /* renamed from: a */
        public void m8356a(Activity activity, Bundle bundle) {
        }

        /* renamed from: b */
        public void m8357b(Activity activity) {
        }

        /* renamed from: b */
        public void m8358b(Activity activity, Bundle bundle) {
        }

        /* renamed from: c */
        public void m8359c(Activity activity) {
        }

        /* renamed from: d */
        public void m8360d(Activity activity) {
        }

        /* renamed from: e */
        public void m8361e(Activity activity) {
        }
    }

    public ActivityLifecycleManager(Context context) {
        this.f8524a = new a((Application) context.getApplicationContext());
    }

    /* renamed from: a */
    public boolean m8351a(b bVar) {
        a aVar = this.f8524a;
        return aVar != null && aVar.m8353a(bVar);
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: com.twitter.sdk.android.core.internal.a$a */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a */
        private final Set<Application.ActivityLifecycleCallbacks> f8525a = new HashSet();

        /* renamed from: b */
        private final Application f8526b;

        a(Application application) {
            this.f8526b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m8353a(final b bVar) {
            if (this.f8526b == null) {
                return false;
            }
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.twitter.sdk.android.core.internal.a.a.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.m8356a(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    bVar.mo8355a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    bVar.m8357b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    bVar.m8359c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    bVar.m8360d(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.m8358b(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    bVar.m8361e(activity);
                }
            };
            this.f8526b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f8525a.add(activityLifecycleCallbacks);
            return true;
        }
    }
}