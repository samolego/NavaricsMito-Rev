package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2559b;
import com.tencent.wxop.stat.common.C2562e;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2574q;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2578a;
import com.tencent.wxop.stat.event.C2580c;
import com.tencent.wxop.stat.event.C2585h;
import com.tencent.wxop.stat.event.C2588k;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class StatServiceImpl {

    /* renamed from: d */
    private static C2562e f7892d;

    /* renamed from: e */
    private static volatile Map<C2580c, Long> f7893e = new ConcurrentHashMap();

    /* renamed from: f */
    private static volatile Map<String, Properties> f7894f = new ConcurrentHashMap();

    /* renamed from: g */
    private static volatile Map<Integer, Integer> f7895g = new ConcurrentHashMap(10);

    /* renamed from: h */
    private static volatile long f7896h = 0;

    /* renamed from: i */
    private static volatile long f7897i = 0;

    /* renamed from: j */
    private static volatile long f7898j = 0;

    /* renamed from: k */
    private static String f7899k = "";

    /* renamed from: l */
    private static volatile int f7900l = 0;

    /* renamed from: m */
    private static volatile String f7901m = "";

    /* renamed from: n */
    private static volatile String f7902n = "";

    /* renamed from: o */
    private static Map<String, Long> f7903o = new ConcurrentHashMap();

    /* renamed from: p */
    private static Map<String, Long> f7904p = new ConcurrentHashMap();

    /* renamed from: q */
    private static StatLogger f7905q = C2569l.m4837b();

    /* renamed from: r */
    private static Thread.UncaughtExceptionHandler f7906r = null;

    /* renamed from: s */
    private static volatile boolean f7907s = true;

    /* renamed from: a */
    static volatile int f7889a = 0;

    /* renamed from: b */
    static volatile long f7890b = 0;

    /* renamed from: t */
    private static Context f7908t = null;

    /* renamed from: c */
    static volatile long f7891c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m4967a(Context context, boolean z, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = z && currentTimeMillis - f7897i >= ((long) StatConfig.getSessionTimoutMillis());
        f7897i = currentTimeMillis;
        if (f7898j == 0) {
            f7898j = C2569l.m4834c();
        }
        if (currentTimeMillis >= f7898j) {
            f7898j = C2569l.m4834c();
            if (C2546au.m4916a(context).m4898b(context).m4870d() != 1) {
                C2546au.m4916a(context).m4898b(context).m4873a(1);
            }
            StatConfig.m4978b(0);
            f7889a = 0;
            f7899k = C2569l.m4847a(0);
            z2 = true;
        }
        String str = f7899k;
        if (C2569l.m4841a(statSpecifyReportedInfo)) {
            str = statSpecifyReportedInfo.getAppKey() + f7899k;
        }
        if (!f7904p.containsKey(str)) {
            z2 = true;
        }
        if (z2) {
            if (C2569l.m4841a(statSpecifyReportedInfo)) {
                m4969a(context, statSpecifyReportedInfo);
            } else if (StatConfig.m4975c() < StatConfig.getMaxDaySessionNumbers()) {
                C2569l.m4808v(context);
                m4969a(context, (StatSpecifyReportedInfo) null);
            } else {
                f7905q.m4879e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            f7904p.put(str, 1L);
        }
        if (f7907s) {
            testSpeed(context);
            f7907s = false;
        }
        return f7900l;
    }

    /* renamed from: a */
    static synchronized void m4971a(Context context) {
        synchronized (StatServiceImpl.class) {
            if (context == null) {
                return;
            }
            if (f7892d == null) {
                if (!m4963b(context)) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                f7908t = applicationContext;
                f7892d = new C2562e();
                f7899k = C2569l.m4847a(0);
                f7896h = System.currentTimeMillis() + StatConfig.f7866i;
                f7892d.m4865a(new RunnableC2595l(applicationContext));
            }
        }
    }

    /* renamed from: a */
    static void m4969a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (m4959c(context) != null) {
            if (StatConfig.isDebugEnable()) {
                f7905q.m4880d("start new session.");
            }
            if (statSpecifyReportedInfo == null || f7900l == 0) {
                f7900l = C2569l.m4848a();
            }
            StatConfig.m4988a(0);
            StatConfig.m4979b();
            new C2542aq(new C2588k(context, f7900l, m4964b(), statSpecifyReportedInfo)).m4927a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4968a(Context context, Throwable th) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2600q(context2, th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m4973a() {
        if (f7889a >= 2) {
            f7890b = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m4966a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    static JSONObject m4964b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.f7859b.f8140d != 0) {
                jSONObject2.put("v", StatConfig.f7859b.f8140d);
            }
            jSONObject.put(Integer.toString(StatConfig.f7859b.f8137a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (StatConfig.f7858a.f8140d != 0) {
                jSONObject3.put("v", StatConfig.f7858a.f8140d);
            }
            jSONObject.put(Integer.toString(StatConfig.f7858a.f8137a), jSONObject3);
        } catch (JSONException e) {
            f7905q.m4878e((Throwable) e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m4962b(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            new C2542aq(new C2578a(context, m4967a(context, false, statSpecifyReportedInfo), statAccount, statSpecifyReportedInfo)).m4927a();
        } catch (Throwable th) {
            f7905q.m4878e(th);
            m4968a(context, th);
        }
    }

    /* renamed from: b */
    static boolean m4963b(Context context) {
        boolean z;
        long m4796a = C2574q.m4796a(context, StatConfig.f7860c, 0L);
        long m4835b = C2569l.m4835b(StatConstants.VERSION);
        boolean z2 = false;
        if (m4835b <= m4796a) {
            StatLogger statLogger = f7905q;
            statLogger.error("MTA is disable for current version:" + m4835b + ",wakeup version:" + m4796a);
            z = false;
        } else {
            z = true;
        }
        long m4796a2 = C2574q.m4796a(context, StatConfig.f7861d, 0L);
        if (m4796a2 > System.currentTimeMillis()) {
            StatLogger statLogger2 = f7905q;
            statLogger2.error("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + m4796a2);
        } else {
            z2 = z;
        }
        StatConfig.setEnableStatService(z2);
        return z2;
    }

    /* renamed from: c */
    static C2562e m4959c(Context context) {
        if (f7892d == null) {
            synchronized (StatServiceImpl.class) {
                if (f7892d == null) {
                    m4971a(context);
                }
            }
        }
        return f7892d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m4960c() {
        f7889a = 0;
        f7890b = 0L;
    }

    public static void commitEvents(Context context, int i) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger2 = f7905q;
                statLogger2.m4877i("commitEvents, maxNumber=" + i);
            }
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = f7905q;
                str = "The Context of StatService.commitEvents() can not be null!";
            } else if (i >= -1 && i != 0) {
                if (C2525a.m4944a(f7908t).m4936f() && m4959c(context2) != null) {
                    f7892d.m4865a(new RunnableC2529ad(context2, i));
                    return;
                }
                return;
            } else {
                statLogger = f7905q;
                str = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            }
            statLogger.error(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static void m4957d() {
        f7889a++;
        f7890b = System.currentTimeMillis();
        flushDataToDB(f7908t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static void m4956d(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                C2592i.m4751b(context2).m4754a(new C2585h(context2), new C2603t());
            } catch (Throwable th) {
                f7905q.m4878e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static void m4954e(Context context) {
        f7891c = System.currentTimeMillis() + (StatConfig.getSendPeriodMinutes() * 60000);
        C2574q.m4793b(context, "last_period_ts", f7891c);
        commitEvents(context, -1);
    }

    public static void flushDataToDB(Context context) {
        if (StatConfig.isEnableStatService() && StatConfig.f7870m > 0) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.testSpeed() can not be null!");
            } else {
                C2546au.m4916a(context2).m4893c();
            }
        }
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return f7894f.get(str);
    }

    public static Context getContext(Context context) {
        return context != null ? context : f7908t;
    }

    public static void onLowMemory(Context context) {
        if (StatConfig.isEnableStatService() && m4959c(getContext(context)) != null) {
            f7892d.m4865a(new RunnableC2598o(context));
        }
    }

    public static void onPause(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService() && m4959c(context) != null) {
            f7892d.m4865a(new RunnableC2596m(context, statSpecifyReportedInfo));
        }
    }

    public static void onResume(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService() && m4959c(context) != null) {
            f7892d.m4865a(new RunnableC2535aj(context, statSpecifyReportedInfo));
        }
    }

    public static void onStop(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2597n(context2));
            }
        }
    }

    public static void reportAccount(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.m4879e("context is null in reportAccount.");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2537al(statAccount, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = f7905q;
                str = "The Context of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor == null) {
                statLogger = f7905q;
                str = "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor.getInterfaceName() != null) {
                StatAppMonitor m13137clone = statAppMonitor.m13137clone();
                if (m4959c(context2) != null) {
                    f7892d.m4865a(new RunnableC2526aa(context2, statSpecifyReportedInfo, m13137clone));
                    return;
                }
                return;
            } else {
                statLogger = f7905q;
                str = "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!";
            }
            statLogger.error(str);
        }
    }

    public static void reportError(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.reportError() can not be null!");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2599p(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportException(Context context, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.reportException() can not be null!");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2601r(th, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.reportGameUser() can not be null!");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2538am(statGameUser, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportQQ(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("context is null in reportQQ()");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2536ak(str, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        if (!C2569l.m4832c(str)) {
            f7905q.m4879e("event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f7894f.remove(str);
        } else {
            f7894f.put(str, (Properties) properties.clone());
        }
    }

    public static void setContext(Context context) {
        if (context != null) {
            f7908t = context.getApplicationContext();
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            f7905q.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            C2559b.m4868a(context, map);
        } catch (JSONException e) {
            f7905q.m4878e((Throwable) e);
        }
    }

    public static void startNewSession(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.startNewSession() can not be null!");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2534ai(context2, statSpecifyReportedInfo));
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            if (!StatConfig.isEnableStatService()) {
                f7905q.error("MTA StatService is disable.");
                return false;
            }
            if (StatConfig.isDebugEnable()) {
                f7905q.m4880d("MTA SDK version, current: " + StatConstants.VERSION + " ,required: " + str2);
            }
            if (context != null && str2 != null) {
                if (C2569l.m4835b(StatConstants.VERSION) >= C2569l.m4835b(str2)) {
                    String installChannel = StatConfig.getInstallChannel(context);
                    if (installChannel == null || installChannel.length() == 0) {
                        StatConfig.setInstallChannel("-");
                    }
                    if (str != null) {
                        StatConfig.setAppKey(context, str);
                    }
                    if (m4959c(context) != null) {
                        f7892d.m4865a(new RunnableC2539an(context, statSpecifyReportedInfo));
                        return true;
                    }
                    return true;
                }
                f7905q.error(("MTA SDK version conflicted, current: " + StatConstants.VERSION + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                StatConfig.setEnableStatService(false);
                return false;
            }
            f7905q.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            return false;
        } catch (Throwable th) {
            f7905q.m4878e(th);
            return false;
        }
    }

    public static void stopSession() {
        f7897i = 0L;
    }

    public static void testSpeed(Context context) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.testSpeed() can not be null!");
            } else if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2530ae(context2));
            }
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = f7905q;
                str = "The Context of StatService.testSpeed() can not be null!";
            } else if (map != null && map.size() != 0) {
                HashMap hashMap = new HashMap(map);
                if (m4959c(context2) != null) {
                    f7892d.m4865a(new RunnableC2531af(context2, hashMap, statSpecifyReportedInfo));
                    return;
                }
                return;
            } else {
                statLogger = f7905q;
                str = "The domainMap of StatService.testSpeed() can not be null or empty!";
            }
            statLogger.error(str);
        }
    }

    public static void trackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f7905q.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2606w(str2, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C2580c c2580c = new C2580c(str, strArr, null);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2605v(str, c2580c, context2));
            }
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            C2580c c2580c = new C2580c(str, null, properties);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2608y(str, c2580c, context2));
            }
        }
    }

    public static void trackCustomEndEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C2580c c2580c = new C2580c(str, strArr, null);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2607x(str, c2580c, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f7905q.error("The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            C2580c c2580c = new C2580c(str, null, properties);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2609z(str, c2580c, context2, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = f7905q;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (!m4966a(str)) {
                C2580c c2580c = new C2580c(str, strArr, null);
                if (m4959c(context2) != null) {
                    f7892d.m4865a(new RunnableC2602s(context2, statSpecifyReportedInfo, c2580c));
                    return;
                }
                return;
            } else {
                statLogger = f7905q;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = f7905q;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (!m4966a(str)) {
                C2580c c2580c = new C2580c(str, null, properties);
                if (m4959c(context2) != null) {
                    f7892d.m4865a(new RunnableC2604u(context2, statSpecifyReportedInfo, c2580c));
                    return;
                }
                return;
            } else {
                statLogger = f7905q;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVTimeIntervalEvent(Context context, String str, Properties properties, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                statLogger = f7905q;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (!m4966a(str)) {
                C2580c c2580c = new C2580c(str, null, properties);
                if (m4959c(context2) != null) {
                    f7892d.m4865a(new RunnableC2528ac(context2, statSpecifyReportedInfo, c2580c, i));
                    return;
                }
                return;
            } else {
                statLogger = f7905q;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomTimeIntervalEvent(Context context, int i, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (i <= 0) {
                statLogger = f7905q;
                str2 = "The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!";
            } else {
                Context context2 = getContext(context);
                if (context2 != null) {
                    if (m4959c(context2) != null) {
                        f7892d.m4865a(new RunnableC2527ab());
                        return;
                    }
                    return;
                }
                statLogger = f7905q;
                str2 = "The Context of StatService.trackCustomTimeIntervalEvent() can not be null!";
            }
            statLogger.error(str2);
        }
    }

    public static void trackEndPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            Context context2 = getContext(context);
            if (context2 == null || str == null || str.length() == 0) {
                f7905q.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (m4959c(context2) != null) {
                f7892d.m4865a(new RunnableC2533ah(context2, str2, statSpecifyReportedInfo));
            }
        }
    }
}
