package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.biz.C2415b;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.proguard.C2482n;
import com.tencent.bugly.proguard.C2486p;
import com.tencent.bugly.proguard.C2492u;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2500y;
import com.tencent.bugly.proguard.C2503z;
import com.tencent.bugly.proguard.InterfaceC2485o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.b */
/* loaded from: classes2.dex */
public final class C2404b {

    /* renamed from: a */
    public static boolean f7144a = true;

    /* renamed from: b */
    public static List<AbstractC2403a> f7145b = new ArrayList();

    /* renamed from: c */
    public static boolean f7146c;

    /* renamed from: d */
    private static C2486p f7147d;

    /* renamed from: e */
    private static boolean f7148e;

    /* renamed from: a */
    private static boolean m5548a(C2419a c2419a) {
        List<String> list = c2419a.f7269o;
        c2419a.getClass();
        return list != null && list.contains("bugly");
    }

    /* renamed from: a */
    public static synchronized void m5552a(Context context) {
        synchronized (C2404b.class) {
            m5551a(context, null);
        }
    }

    /* renamed from: a */
    public static synchronized void m5551a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C2404b.class) {
            if (f7148e) {
                C2499x.m5084d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C2499x.f7763a, "[init] context of init() is null, check it.");
            } else {
                C2419a m5474a = C2419a.m5474a(context);
                if (m5548a(m5474a)) {
                    f7144a = false;
                    return;
                }
                String m5458f = m5474a.m5458f();
                if (m5458f == null) {
                    Log.e(C2499x.f7763a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    m5550a(context, m5458f, m5474a.f7275u, buglyStrategy);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m5550a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (C2404b.class) {
            if (f7148e) {
                C2499x.m5084d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(C2499x.f7763a, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(C2499x.f7763a, "init arg 'crashReportAppID' should not be null!");
            } else {
                f7148e = true;
                if (z) {
                    f7146c = true;
                    C2499x.f7764b = true;
                    C2499x.m5084d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    C2499x.m5083e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C2499x.m5084d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    C2499x.m5084d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    C2499x.m5084d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    C2499x.m5084d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    C2499x.m5083e("--------------------------------------------------------------------------------------------", new Object[0]);
                    C2499x.m5087b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                C2499x.m5090a("[init] Bugly version: v%s", "2.8.6");
                C2499x.m5090a(" crash report start initializing...", new Object[0]);
                C2499x.m5087b("[init] Bugly start initializing...", new Object[0]);
                C2499x.m5090a("[init] Bugly complete version: v%s", "2.8.6");
                Context m5057a = C2503z.m5057a(context);
                C2419a m5474a = C2419a.m5474a(m5057a);
                m5474a.m5442t();
                C2500y.m5080a(m5057a);
                f7147d = C2486p.m5167a(m5057a, f7145b);
                C2492u.m5127a(m5057a);
                C2422a m5397a = C2422a.m5397a(m5057a, f7145b);
                C2482n m5187a = C2482n.m5187a(m5057a);
                if (m5548a(m5474a)) {
                    f7144a = false;
                    return;
                }
                m5474a.m5473a(str);
                C2499x.m5090a("[param] Set APP ID:%s", str);
                if (buglyStrategy != null) {
                    String appVersion = buglyStrategy.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            C2499x.m5084d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        m5474a.f7264j = appVersion;
                        C2499x.m5090a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                    }
                    try {
                        if (buglyStrategy.isReplaceOldChannel()) {
                            String appChannel = buglyStrategy.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    C2499x.m5084d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                f7147d.m5168a(556, "app_channel", appChannel.getBytes(), (InterfaceC2485o) null, false);
                                m5474a.f7266l = appChannel;
                            }
                        } else {
                            Map<String, byte[]> m5172a = f7147d.m5172a(556, (InterfaceC2485o) null, true);
                            if (m5172a != null && (bArr = m5172a.get("app_channel")) != null) {
                                m5474a.f7266l = new String(bArr);
                            }
                        }
                        C2499x.m5090a("[param] Set App channel: %s", m5474a.f7266l);
                    } catch (Exception e) {
                        if (f7146c) {
                            e.printStackTrace();
                        }
                    }
                    String appPackageName = buglyStrategy.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            C2499x.m5084d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        m5474a.f7257c = appPackageName;
                        C2499x.m5090a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                    }
                    String deviceID = buglyStrategy.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            C2499x.m5084d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        m5474a.m5464c(deviceID);
                        C2499x.m5090a("[param] Set device ID: %s", deviceID);
                    }
                    m5474a.f7259e = buglyStrategy.isUploadProcess();
                    C2500y.f7766a = buglyStrategy.isBuglyLogUpload();
                }
                C2415b.m5527a(m5057a, buglyStrategy);
                for (int i = 0; i < f7145b.size(); i++) {
                    if (m5187a.m5190a(f7145b.get(i).f7143id)) {
                        f7145b.get(i).init(m5057a, z, buglyStrategy);
                    }
                }
                m5397a.m5398a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                C2499x.m5087b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m5549a(AbstractC2403a abstractC2403a) {
        synchronized (C2404b.class) {
            if (!f7145b.contains(abstractC2403a)) {
                f7145b.add(abstractC2403a);
            }
        }
    }
}
