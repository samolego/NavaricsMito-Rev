package com.tencent.p075mm.opensdk.openapi;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.p075mm.opensdk.channel.p076a.C2504a;
import com.tencent.p075mm.opensdk.constants.ConstantsAPI;
import com.tencent.wxop.stat.MtaSDkException;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatReportStrategy;
import com.tencent.wxop.stat.StatService;
import com.tencent.wxop.stat.common.StatConstants;

/* renamed from: com.tencent.mm.opensdk.openapi.WXApiImplV10 */
/* loaded from: classes2.dex */
final class WXApiImplV10 extends BaseWXApiImplV10 {
    private static ActivityLifecycleCb activityCb;

    /* renamed from: com.tencent.mm.opensdk.openapi.WXApiImplV10$ActivityLifecycleCb */
    /* loaded from: classes2.dex */
    private static final class ActivityLifecycleCb implements Application.ActivityLifecycleCallbacks {
        private static final int DELAYED = 800;
        private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
        private Context context;
        private Handler handler;
        private boolean isForeground;
        private Runnable onPausedRunnable;
        private Runnable onResumedRunnable;

        private ActivityLifecycleCb(Context context) {
            this.isForeground = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.onPausedRunnable = new Runnable() { // from class: com.tencent.mm.opensdk.openapi.WXApiImplV10.ActivityLifecycleCb.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WXApiImplV10.activityCb == null || !ActivityLifecycleCb.this.isForeground) {
                        return;
                    }
                    Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onBackground");
                    StatService.trackCustomKVEvent(ActivityLifecycleCb.this.context, "onBackground_WX", null);
                    ActivityLifecycleCb.this.isForeground = false;
                }
            };
            this.onResumedRunnable = new Runnable() { // from class: com.tencent.mm.opensdk.openapi.WXApiImplV10.ActivityLifecycleCb.2
                @Override // java.lang.Runnable
                public void run() {
                    if (WXApiImplV10.activityCb == null || ActivityLifecycleCb.this.isForeground) {
                        return;
                    }
                    Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onForeground");
                    StatService.trackCustomKVEvent(ActivityLifecycleCb.this.context, "onForeground_WX", null);
                    ActivityLifecycleCb.this.isForeground = true;
                }
            };
            this.context = context;
        }

        public final void detach() {
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.context = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityPaused");
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.postDelayed(this.onPausedRunnable, 800L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityResumed");
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.handler.postDelayed(this.onResumedRunnable, 800L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WXApiImplV10(Context context, String str, boolean z) {
        super(context, str, z);
    }

    private void initMta(Context context, String str) {
        String str2 = "AWXOP" + str;
        StatConfig.setAppKey(context.getApplicationContext(), str2);
        StatConfig.setEnableSmartReporting(true);
        StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
        StatConfig.setSendPeriodMinutes(60);
        StatConfig.setInstallChannel(context.getApplicationContext(), "Wechat_Sdk");
        try {
            StatService.startStatService(context.getApplicationContext(), str2, StatConstants.VERSION);
        } catch (MtaSDkException e) {
            com.tencent.p075mm.opensdk.utils.Log.m5000e("MicroMsg.SDK.WXApiImplV10", "initMta exception:" + e.getMessage());
        }
    }

    @Override // com.tencent.p075mm.opensdk.openapi.BaseWXApiImplV10, com.tencent.p075mm.opensdk.openapi.IWXAPI
    public final void detach() {
        Application application;
        if (activityCb != null && Build.VERSION.SDK_INT >= 14) {
            if (this.context instanceof Activity) {
                application = ((Activity) this.context).getApplication();
            } else {
                if (this.context instanceof Service) {
                    application = ((Service) this.context).getApplication();
                }
                activityCb.detach();
            }
            application.unregisterActivityLifecycleCallbacks(activityCb);
            activityCb.detach();
        }
        super.detach();
    }

    @Override // com.tencent.p075mm.opensdk.openapi.BaseWXApiImplV10, com.tencent.p075mm.opensdk.openapi.IWXAPI
    public final boolean registerApp(String str, long j) {
        Application application;
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            com.tencent.p075mm.opensdk.utils.Log.m5000e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        com.tencent.p075mm.opensdk.utils.Log.m5001d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        if (activityCb == null && Build.VERSION.SDK_INT >= 14) {
            if (this.context instanceof Activity) {
                initMta(this.context, str);
                activityCb = new ActivityLifecycleCb(this.context);
                application = ((Activity) this.context).getApplication();
            } else if (this.context instanceof Service) {
                initMta(this.context, str);
                activityCb = new ActivityLifecycleCb(this.context);
                application = ((Service) this.context).getApplication();
            } else {
                com.tencent.p075mm.opensdk.utils.Log.m4997w("MicroMsg.SDK.WXApiImplV10", "context is not instanceof Activity or Service, disable WXStat");
            }
            application.registerActivityLifecycleCallbacks(activityCb);
        }
        com.tencent.p075mm.opensdk.utils.Log.m5001d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        com.tencent.p075mm.opensdk.utils.Log.m5001d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
        C2504a.C2505a c2505a = new C2504a.C2505a();
        c2505a.f7788W = "com.tencent.mm";
        c2505a.action = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
        c2505a.content = "weixin://registerapp?appid=" + this.appId;
        c2505a.f7789X = j;
        return C2504a.m5015a(this.context, c2505a);
    }
}
