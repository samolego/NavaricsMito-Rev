package com.navatics.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;
import com.navatics.app.activities.LocationActivity;
import com.navatics.app.framework.Navatics;
import com.navatics.app.framework.location.NvLocationManager;
import com.navatics.robot.utils.p065a.LoggerUtil;
import com.tencent.bugly.crashreport.CrashReport;
import com.yayandroid.locationmanager.LocationManager;

/* loaded from: classes.dex */
public class NavaticsApplication extends Application {

    /* renamed from: a */
    private static NavaticsApplication f3458a;

    /* renamed from: b */
    private LocationActivity f3459b;

    /* renamed from: com.navatics.app.NavaticsApplication$a */
    /* loaded from: classes.dex */
    class C1515a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        C1515a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity instanceof LocationActivity) {
                NavaticsApplication.this.f3459b = (LocationActivity) activity;
                Log.d("NavaticsApplication", activity.getClass().getSimpleName() + " active");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == NavaticsApplication.this.f3459b) {
                NavaticsApplication.this.f3459b = null;
                Log.d("NavaticsApplication", activity.getClass().getSimpleName() + " deactive");
            }
        }
    }

    /* renamed from: a */
    public LocationActivity m9570a() {
        return this.f3459b;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f3458a = this;
        CrashReport.initCrashReport(getApplicationContext(), "6d2f1e8432", false);
        registerActivityLifecycleCallbacks(new C1515a());
        LocationManager.m3712a(false);
        NvLocationManager.m8005a().m8001a(PhoneLocationProvider.m8803a());
        Navatics.m7942c();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
        Navatics.m7957a(context);
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        Navatics.m7938d();
        LoggerUtil.m5930a("app destroy");
    }

    /* renamed from: b */
    public static NavaticsApplication m9567b() {
        return f3458a;
    }
}
