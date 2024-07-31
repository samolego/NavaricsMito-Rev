package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C2404b;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.biz.C2415b;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.C2437c;
import com.tencent.bugly.crashreport.crash.C2440d;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.p074h5.C2445b;
import com.tencent.bugly.crashreport.crash.p074h5.H5JavaScriptInterface;
import com.tencent.bugly.proguard.C2488q;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashReport {

    /* renamed from: a */
    private static Context f7149a;

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public static class CrashHandleCallback extends BuglyStrategy.C2402a {
    }

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    public static void enableBugly(boolean z) {
        C2404b.f7144a = z;
    }

    public static void initCrashReport(Context context) {
        f7149a = context;
        C2404b.m5549a(CrashModule.getInstance());
        C2404b.m5552a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        f7149a = context;
        C2404b.m5549a(CrashModule.getInstance());
        C2404b.m5551a(context, userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        if (context != null) {
            f7149a = context;
            C2404b.m5549a(CrashModule.getInstance());
            C2404b.m5550a(context, str, z, null);
        }
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        f7149a = context;
        C2404b.m5549a(CrashModule.getInstance());
        C2404b.m5550a(context, str, z, userStrategy);
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            C2499x.m5084d("Please call with context.", new Object[0]);
            return "unknown";
        }
        C2419a.m5474a(context);
        return C2419a.m5465c();
    }

    public static void testJavaCrash() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2419a m5470b = C2419a.m5470b();
            if (m5470b != null) {
                m5470b.m5469b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2499x.m5090a("start to create a native crash for test!", new Object[0]);
            C2437c.m5343a().m5336a(z, z2, z3);
        }
    }

    public static void testANRCrash() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2499x.m5090a("start to create a anr crash for test!", new Object[0]);
            C2437c.m5343a().m5326j();
        }
    }

    public static void postException(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2440d.m5318a(thread, i, str, str2, str3, map);
        }
    }

    public static void postException(int i, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i, str, str2, str3, map);
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            C2499x.m5084d("throwable is null, just return", new Object[0]);
        } else {
            C2437c.m5343a().m5337a(thread == null ? Thread.currentThread() : thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void closeNativeReport() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2437c.m5343a().m5330f();
        }
    }

    public static void startCrashReport() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2437c.m5343a().m5333c();
        }
    }

    public static void closeCrashReport() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            C2437c.m5343a().m5332d();
        }
    }

    public static void closeBugly() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (f7149a == null) {
        } else {
            BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
            if (buglyBroadcastReceiver != null) {
                buglyBroadcastReceiver.unregister(f7149a);
            }
            closeCrashReport();
            C2415b.m5528a(f7149a);
            C2497w m5098a = C2497w.m5098a();
            if (m5098a != null) {
                m5098a.m5095b();
            }
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(C2499x.f7763a, "setTag args context should not be null");
        } else {
            if (i <= 0) {
                C2499x.m5084d("setTag args tagId should > 0", new Object[0]);
            }
            C2419a.m5474a(context).m5475a(i);
            C2499x.m5087b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(C2499x.f7763a, "getUserSceneTagId args context should not be null");
            return -1;
        } else {
            return C2419a.m5474a(context).m5489H();
        }
    }

    public static String getUserData(Context context, String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(C2499x.f7763a, "getUserDataValue args context should not be null");
            return "unknown";
        } else if (C2503z.m5043a(str)) {
            return null;
        } else {
            return C2419a.m5474a(context).m5455g(str);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(C2499x.f7763a, "putUserData args context should not be null");
        } else if (str == null) {
            String str3 = str;
            C2499x.m5084d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            String str4 = str2;
            C2499x.m5084d("putUserData args value should not be null", new Object[0]);
        } else if (!str.matches("[a-zA-Z[0-9]]+")) {
            C2499x.m5084d("putUserData args key should match [a-zA-Z[0-9]]+  {" + str + "}", new Object[0]);
        } else {
            if (str2.length() > 200) {
                C2499x.m5084d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            C2419a m5474a = C2419a.m5474a(context);
            if (m5474a.m5492E().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                C2419a.m5474a(context).m5467b(str, str2);
                C2499x.m5085c("replace KV %s %s", str, str2);
            } else if (m5474a.m5493D() >= 10) {
                C2499x.m5084d("user data size is over limit %d, it will be cutted!", 10);
            } else {
                if (str.length() > 50) {
                    C2499x.m5084d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str = str.substring(0, 50);
                }
                NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                if (nativeCrashHandler2 != null) {
                    nativeCrashHandler2.putKeyValueToNative(str, str2);
                }
                C2419a.m5474a(context).m5467b(str, str2);
                C2499x.m5087b("[param] set user data: %s - %s", str, str2);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(C2499x.f7763a, "removeUserData args context should not be null");
            return "unknown";
        } else if (C2503z.m5043a(str)) {
            return null;
        } else {
            C2499x.m5087b("[param] remove user data: %s", str);
            return C2419a.m5474a(context).m5457f(str);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context == null) {
            Log.e(C2499x.f7763a, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        } else {
            return C2419a.m5474a(context).m5492E();
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(C2499x.f7763a, "getUserDatasSize args context should not be null");
            return -1;
        } else {
            return C2419a.m5474a(context).m5493D();
        }
    }

    public static String getAppID() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get App ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C2419a.m5474a(f7149a).m5458f();
        }
    }

    public static void setUserId(String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(f7149a, str);
        }
    }

    public static void setUserId(Context context, String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(C2499x.f7763a, "Context should not be null when bugly has not been initialed!");
        } else if (str == null) {
            C2499x.m5084d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                C2499x.m5084d("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (str.equals(C2419a.m5474a(context).m5456g())) {
                return;
            }
            C2419a.m5474a(context).m5468b(str);
            C2499x.m5087b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                C2415b.m5530a();
            }
        }
    }

    public static String getUserId() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get user ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C2419a.m5474a(f7149a).m5456g();
        }
    }

    public static String getAppVer() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get app version because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C2419a.m5474a(f7149a).f7264j;
        }
    }

    public static String getAppChannel() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get App channel because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return C2419a.m5474a(f7149a).f7266l;
        }
    }

    public static void setContext(Context context) {
        f7149a = context;
    }

    public static boolean isLastSessionCrash() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        } else {
            return C2437c.m5343a().m5335b();
        }
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not put SDK extra data because bugly is disable.");
        } else if (context == null || C2503z.m5043a(str) || C2503z.m5043a(str2)) {
        } else {
            C2419a.m5474a(context).m5472a(str, str2);
        }
    }

    public static Map<String, String> getSdkExtraData() {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(C2499x.f7763a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        } else {
            return C2419a.m5474a(f7149a).f7204A;
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context == null) {
            C2499x.m5084d("Context should not be null.", new Object[0]);
            return null;
        } else {
            return C2419a.m5474a(context).f7204A;
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || C2503z.m5043a(str) || C2503z.m5043a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(C2499x.f7763a, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(C2499x.f7763a, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        C2419a.m5474a(context).m5463c(replace, str2);
        C2499x.m5087b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set 'isAppForeground' because bugly is disable.");
        } else if (context == null) {
            C2499x.m5084d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C2499x.m5085c("App is in foreground.", new Object[0]);
            } else {
                C2499x.m5085c("App is in background.", new Object[0]);
            }
            C2419a.m5474a(context).m5471a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            C2499x.m5084d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                C2499x.m5085c("This is a development device.", new Object[0]);
            } else {
                C2499x.m5085c("This is not a development device.", new Object[0]);
            }
            C2419a.m5474a(context).f7279y = z;
        }
    }

    public static void setSessionIntervalMills(long j) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            C2415b.m5529a(j);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(C2499x.f7763a, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(C2499x.f7763a, "App version is null, will not set");
        } else {
            C2419a.m5474a(context).f7264j = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
            }
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(C2499x.f7763a, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(C2499x.f7763a, "App channel is null, will not set");
        } else {
            C2419a.m5474a(context).f7266l = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(C2499x.f7763a, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(C2499x.f7763a, "App package is null, will not set");
        } else {
            C2419a.m5474a(context).f7257c = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppPackage(str);
            }
        }
    }

    public static void setCrashFilter(String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = C2499x.f7763a;
        Log.i(str2, "Set crash stack filter: " + str);
        C2437c.f7432n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = C2499x.f7763a;
        Log.i(str2, "Set crash stack filter: " + str);
        C2437c.f7433o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App package because bugly is disable.");
            return;
        }
        String str = C2499x.f7763a;
        Log.i(str, "Should handle native crash in Java profile after handled in native profile: " + z);
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setBuglyDbName(String str) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set DB name because bugly is disable.");
            return;
        }
        String str2 = C2499x.f7763a;
        Log.i(str2, "Set Bugly DB name: " + str);
        C2488q.f7697a = str;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set DB name because bugly is disable.");
        } else if (context == null) {
            Log.w(C2499x.f7763a, "enableObtainId args context should not be null");
        } else {
            String str = C2499x.f7763a;
            Log.i(str, "Enable identification obtaining? " + z);
            C2419a.m5474a(context).m5466b(z);
        }
    }

    public static void setAuditEnable(Context context, boolean z) {
        if (!C2404b.f7144a) {
            Log.w(C2499x.f7763a, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(C2499x.f7763a, "setAppPackage args context should not be null");
        } else {
            String str = C2499x.f7763a;
            Log.i(str, "Set audit enable: " + z);
            C2419a.m5474a(context).f7205B = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(C2499x.f7763a, "WebView is null.");
            return false;
        }
        return setJavascriptMonitor(new WebViewInterface() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final String getUrl() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void setJavaScriptEnabled(boolean z3) {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void loadUrl(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
            public final CharSequence getContentDescription() {
                return webView.getContentDescription();
            }
        }, z, z2);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(C2499x.f7763a, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            C2499x.m5083e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            C2499x.m5090a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!C2404b.f7144a) {
                Log.w(C2499x.f7763a, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            C2499x.m5085c("URL of webview is %s", webViewInterface.getUrl());
            if (!z2 && Build.VERSION.SDK_INT < 19) {
                C2499x.m5083e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            C2499x.m5090a("Enable the javascript needed by webview monitor.", new Object[0]);
            webViewInterface.setJavaScriptEnabled(true);
            H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
            if (h5JavaScriptInterface != null) {
                C2499x.m5090a("Add a secure javascript interface to the webview.", new Object[0]);
                webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
            }
            if (z) {
                C2499x.m5090a("Inject bugly.js(v%s) to the webview.", C2445b.m5306b());
                String m5307a = C2445b.m5307a();
                if (m5307a == null) {
                    C2499x.m5083e("Failed to inject Bugly.js.", C2445b.m5306b());
                    return false;
                }
                webViewInterface.loadUrl("javascript:" + m5307a);
            }
            return true;
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public static class UserStrategy extends BuglyStrategy {

        /* renamed from: a */
        private CrashHandleCallback f7151a;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f7151a;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f7151a = crashHandleCallback;
        }
    }
}
