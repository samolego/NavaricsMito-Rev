package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.internal.f */
/* loaded from: classes.dex */
public class InAppPurchaseActivityLifecycleTracker {

    /* renamed from: a */
    private static final String f1741a = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();

    /* renamed from: b */
    private static final AtomicBoolean f1742b = new AtomicBoolean(false);

    /* renamed from: c */
    private static Boolean f1743c = null;

    /* renamed from: d */
    private static Boolean f1744d = null;

    /* renamed from: e */
    private static ServiceConnection f1745e;

    /* renamed from: f */
    private static Application.ActivityLifecycleCallbacks f1746f;

    /* renamed from: g */
    private static Intent f1747g;

    /* renamed from: h */
    private static Object f1748h;

    /* renamed from: a */
    public static void m11004a() {
        m10998d();
        if (f1743c.booleanValue() && AutomaticAnalyticsLogger.m11008b()) {
            m10997e();
        }
    }

    /* renamed from: d */
    private static void m10998d() {
        if (f1743c != null) {
            return;
        }
        try {
            Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
            f1743c = true;
            try {
                Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                f1744d = true;
            } catch (ClassNotFoundException unused) {
                f1744d = false;
            }
            InAppPurchaseEventManager.m10996a();
            f1747g = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
            f1745e = new ServiceConnection() { // from class: com.facebook.appevents.internal.f.1
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Object unused2 = InAppPurchaseActivityLifecycleTracker.f1748h = InAppPurchaseEventManager.m10995a(FacebookSdk.m10869h(), iBinder);
                }
            };
            f1746f = new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.f.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    try {
                        FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.internal.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context m10869h = FacebookSdk.m10869h();
                                InAppPurchaseActivityLifecycleTracker.m11000b(m10869h, InAppPurchaseEventManager.m10994a(m10869h, InAppPurchaseActivityLifecycleTracker.f1748h), false);
                                InAppPurchaseActivityLifecycleTracker.m11000b(m10869h, InAppPurchaseEventManager.m10985b(m10869h, InAppPurchaseActivityLifecycleTracker.f1748h), true);
                            }
                        });
                    } catch (Exception unused2) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        if (InAppPurchaseActivityLifecycleTracker.f1744d.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
                            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.internal.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    Context m10869h = FacebookSdk.m10869h();
                                    ArrayList<String> m10994a = InAppPurchaseEventManager.m10994a(m10869h, InAppPurchaseActivityLifecycleTracker.f1748h);
                                    if (m10994a.isEmpty()) {
                                        m10994a = InAppPurchaseEventManager.m10981c(m10869h, InAppPurchaseActivityLifecycleTracker.f1748h);
                                    }
                                    InAppPurchaseActivityLifecycleTracker.m11000b(m10869h, m10994a, false);
                                }
                            });
                        }
                    } catch (Exception unused2) {
                    }
                }
            };
        } catch (ClassNotFoundException unused2) {
            f1743c = false;
        }
    }

    /* renamed from: e */
    private static void m10997e() {
        if (f1742b.compareAndSet(false, true)) {
            Context m10869h = FacebookSdk.m10869h();
            if (m10869h instanceof Application) {
                ((Application) m10869h).registerActivityLifecycleCallbacks(f1746f);
                m10869h.bindService(f1747g, f1745e, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m11000b(Context context, ArrayList<String> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                String string = new JSONObject(next).getString("productId");
                hashMap.put(string, next);
                arrayList2.add(string);
            } catch (JSONException e) {
                Log.e(f1741a, "Error parsing in-app purchase data.", e);
            }
        }
        for (Map.Entry<String, String> entry : InAppPurchaseEventManager.m10990a(context, arrayList2, f1748h, z).entrySet()) {
            AutomaticAnalyticsLogger.m11009a((String) hashMap.get(entry.getKey()), entry.getValue(), z);
        }
    }
}
