package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.p070a.p071a.p072a.p073a.C2400g;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.C2574q;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class StatConfig {

    /* renamed from: B */
    private static String f7840B;

    /* renamed from: C */
    private static String f7841C;

    /* renamed from: p */
    private static StatLogger f7873p = C2569l.m4837b();

    /* renamed from: a */
    static C2589f f7858a = new C2589f(2);

    /* renamed from: b */
    static C2589f f7859b = new C2589f(1);

    /* renamed from: q */
    private static StatReportStrategy f7874q = StatReportStrategy.APP_LAUNCH;

    /* renamed from: r */
    private static boolean f7875r = false;

    /* renamed from: s */
    private static boolean f7876s = true;

    /* renamed from: t */
    private static int f7877t = 30000;

    /* renamed from: u */
    private static int f7878u = 100000;

    /* renamed from: v */
    private static int f7879v = 30;

    /* renamed from: w */
    private static int f7880w = 10;

    /* renamed from: x */
    private static int f7881x = 100;

    /* renamed from: y */
    private static int f7882y = 30;

    /* renamed from: z */
    private static int f7883z = 1;

    /* renamed from: c */
    static String f7860c = "__HIBERNATE__";

    /* renamed from: d */
    static String f7861d = "__HIBERNATE__TIME";

    /* renamed from: e */
    static String f7862e = "__MTA_KILL__";

    /* renamed from: A */
    private static String f7839A = null;

    /* renamed from: D */
    private static String f7842D = "mta_channel";

    /* renamed from: f */
    static String f7863f = "";

    /* renamed from: E */
    private static int f7843E = 180;

    /* renamed from: g */
    static boolean f7864g = false;

    /* renamed from: h */
    static int f7865h = 100;

    /* renamed from: i */
    static long f7866i = 10000;

    /* renamed from: F */
    private static int f7844F = 1024;

    /* renamed from: j */
    static boolean f7867j = true;

    /* renamed from: G */
    private static long f7845G = 0;

    /* renamed from: H */
    private static long f7846H = 300000;
    public static boolean isAutoExceptionCaught = true;

    /* renamed from: k */
    static volatile String f7868k = StatConstants.MTA_SERVER;

    /* renamed from: I */
    private static volatile String f7847I = StatConstants.MTA_REPORT_FULL_URL;

    /* renamed from: J */
    private static int f7848J = 0;

    /* renamed from: K */
    private static volatile int f7849K = 0;

    /* renamed from: L */
    private static int f7850L = 20;

    /* renamed from: M */
    private static int f7851M = 0;

    /* renamed from: N */
    private static boolean f7852N = false;

    /* renamed from: O */
    private static int f7853O = 4096;

    /* renamed from: P */
    private static boolean f7854P = false;

    /* renamed from: Q */
    private static String f7855Q = null;

    /* renamed from: R */
    private static boolean f7856R = false;

    /* renamed from: S */
    private static InterfaceC2590g f7857S = null;

    /* renamed from: l */
    static boolean f7869l = true;

    /* renamed from: m */
    static int f7870m = 0;

    /* renamed from: n */
    static long f7871n = 10000;

    /* renamed from: o */
    static int f7872o = 512;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m4989a() {
        return f7879v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m4982a(String str, String str2) {
        String string;
        try {
            string = f7859b.f8138b.getString(str);
        } catch (Throwable unused) {
            StatLogger statLogger = f7873p;
            statLogger.m4875w("can't find custom key:" + str);
        }
        return string != null ? string : str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m4988a(int i) {
        synchronized (StatConfig.class) {
            f7849K = i;
        }
    }

    /* renamed from: a */
    static void m4986a(long j) {
        C2574q.m4793b(C2592i.m4756a(), f7860c, j);
        setEnableStatService(false);
        f7873p.warn("MTA is disable for current SDK version");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4985a(Context context, C2589f c2589f) {
        if (c2589f.f8137a != f7859b.f8137a) {
            if (c2589f.f8137a == f7858a.f8137a) {
                f7858a = c2589f;
                return;
            }
            return;
        }
        f7859b = c2589f;
        m4981a(c2589f.f8138b);
        if (f7859b.f8138b.isNull("iplist")) {
            return;
        }
        C2525a.m4944a(context).m4942a(f7859b.f8138b.getString("iplist"));
    }

    /* renamed from: a */
    static void m4984a(Context context, C2589f c2589f, JSONObject jSONObject) {
        boolean z = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(next);
                    if (c2589f.f8140d != i) {
                        z = true;
                    }
                    c2589f.f8140d = i;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        c2589f.f8138b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    c2589f.f8139c = jSONObject.getString("m");
                }
            }
            if (z) {
                C2546au m4916a = C2546au.m4916a(C2592i.m4756a());
                if (m4916a != null) {
                    m4916a.m4907a(c2589f);
                }
                if (c2589f.f8137a == f7859b.f8137a) {
                    m4981a(c2589f.f8138b);
                    m4976b(c2589f.f8138b);
                }
            }
            m4985a(context, c2589f);
        } catch (Throwable th) {
            f7873p.m4878e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4983a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        C2589f c2589f;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(f7859b.f8137a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    c2589f = f7859b;
                } else if (next.equalsIgnoreCase(Integer.toString(f7858a.f8137a))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    c2589f = f7858a;
                } else if (!next.equalsIgnoreCase("rs")) {
                    return;
                } else {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        f7874q = statReportStrategy;
                        if (isDebugEnable()) {
                            StatLogger statLogger = f7873p;
                            statLogger.m4880d("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                }
                m4984a(context, c2589f, jSONObject2);
            }
        } catch (JSONException e) {
            f7873p.m4878e((Throwable) e);
        }
    }

    /* renamed from: a */
    static void m4981a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (isDebugEnable()) {
                f7873p.m4877i("rs not found.");
            }
        }
    }

    /* renamed from: a */
    static boolean m4987a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    /* renamed from: a */
    static boolean m4980a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject.isNull(str)) {
            return false;
        }
        String optString = jSONObject.optString(str);
        return C2569l.m4832c(str2) && C2569l.m4832c(optString) && str2.equalsIgnoreCase(optString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m4979b() {
        f7851M++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m4978b(int i) {
        if (i < 0) {
            return;
        }
        f7851M = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[Catch: Exception -> 0x01b6, TryCatch #0 {Exception -> 0x01b6, blocks: (B:2:0x0000, B:4:0x000c, B:7:0x0018, B:9:0x0021, B:11:0x002b, B:12:0x002d, B:18:0x0040, B:20:0x0046, B:21:0x005e, B:13:0x0032, B:15:0x0036, B:22:0x0077, B:24:0x0082, B:25:0x008a, B:27:0x0094, B:28:0x00aa, B:30:0x00b6, B:31:0x00ce, B:33:0x00e4, B:34:0x00fa, B:36:0x0110, B:37:0x0126, B:39:0x013c, B:40:0x0152, B:42:0x0166, B:43:0x0186, B:45:0x0192, B:47:0x01ac), top: B:52:0x0000 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void m4977b(android.content.Context r6, org.json.JSONObject r7) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatConfig.m4977b(android.content.Context, org.json.JSONObject):void");
    }

    /* renamed from: b */
    static void m4976b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            m4977b(C2592i.m4756a(), jSONObject);
            String string = jSONObject.getString(f7860c);
            if (isDebugEnable()) {
                StatLogger statLogger = f7873p;
                statLogger.m4880d("hibernateVer:" + string + ", current version:2.0.4");
            }
            long m4835b = C2569l.m4835b(string);
            if (C2569l.m4835b(StatConstants.VERSION) <= m4835b) {
                m4986a(m4835b);
            }
        } catch (JSONException unused) {
            f7873p.m4880d("__HIBERNATE__ not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static int m4975c() {
        return f7851M;
    }

    public static synchronized String getAppKey(Context context) {
        String str;
        synchronized (StatConfig.class) {
            str = f7840B;
        }
        return str;
    }

    public static int getCurSessionStatReportCount() {
        return f7849K;
    }

    public static InterfaceC2590g getCustomLogger() {
        return f7857S;
    }

    public static String getCustomProperty(String str) {
        try {
            return f7858a.f8138b.getString(str);
        } catch (Throwable th) {
            f7873p.m4878e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        String string;
        try {
            string = f7858a.f8138b.getString(str);
        } catch (Throwable th) {
            f7873p.m4878e(th);
        }
        return string != null ? string : str2;
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            f7873p.error("Context for getCustomUid is null.");
            return null;
        }
        if (f7855Q == null) {
            f7855Q = C2574q.m4795a(context, "MTA_CUSTOM_UID", "");
        }
        return f7855Q;
    }

    public static long getFlushDBSpaceMS() {
        return f7871n;
    }

    public static synchronized String getInstallChannel(Context context) {
        String str;
        synchronized (StatConfig.class) {
            str = f7841C;
        }
        return str;
    }

    public static String getLocalMidOnly(Context context) {
        return context != null ? C2400g.m5565a(context).m5566a().m5574a() : "0";
    }

    public static int getMaxBatchReportCount() {
        return f7882y;
    }

    public static int getMaxDaySessionNumbers() {
        return f7850L;
    }

    public static int getMaxImportantDataSendRetryCount() {
        return f7881x;
    }

    public static int getMaxParallelTimmingEvents() {
        return f7844F;
    }

    public static int getMaxReportEventLength() {
        return f7853O;
    }

    public static int getMaxSendRetryCount() {
        return f7880w;
    }

    public static int getMaxSessionStatReportCount() {
        return f7848J;
    }

    public static int getMaxStoreEventCount() {
        return f7878u;
    }

    public static String getMid(Context context) {
        return getLocalMidOnly(context);
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return f7866i;
    }

    public static int getNumEventsCachedInMemory() {
        return f7870m;
    }

    public static int getNumEventsCommitPerSec() {
        return f7883z;
    }

    public static int getNumOfMethodsCalledLimit() {
        return f7865h;
    }

    public static String getQQ(Context context) {
        return C2574q.m4795a(context, "mta.acc.qq", f7863f);
    }

    public static int getReportCompressedSize() {
        return f7872o;
    }

    public static int getSendPeriodMinutes() {
        return f7843E;
    }

    public static int getSessionTimoutMillis() {
        return f7877t;
    }

    public static String getStatReportHost() {
        return f7868k;
    }

    public static String getStatReportUrl() {
        return f7847I;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return f7874q;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return f7875r;
    }

    public static boolean isEnableConcurrentProcess() {
        return f7854P;
    }

    public static boolean isEnableSmartReporting() {
        return f7867j;
    }

    public static boolean isEnableStatService() {
        return f7876s;
    }

    public static boolean isReportEventsByOrder() {
        return f7869l;
    }

    public static boolean isXGProMode() {
        return f7856R;
    }

    public static void setAppKey(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (context == null) {
            statLogger = f7873p;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else if (str != null && str.length() <= 256) {
            f7840B = str;
            return;
        } else {
            statLogger = f7873p;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        }
        statLogger.error(str2);
    }

    public static void setAppKey(String str) {
        StatLogger statLogger;
        String str2;
        if (str == null) {
            statLogger = f7873p;
            str2 = "appkey in StatConfig.setAppKey() is null";
        } else if (str.length() <= 256) {
            f7840B = str;
            return;
        } else {
            statLogger = f7873p;
            str2 = "The length of appkey cann't exceed 256 bytes.";
        }
        statLogger.error(str2);
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    public static void setCustomLogger(InterfaceC2590g interfaceC2590g) {
        f7857S = interfaceC2590g;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            f7873p.error("Context for setCustomUid is null.");
            return;
        }
        C2574q.m4792b(context, "MTA_CUSTOM_UID", str);
        f7855Q = str;
    }

    public static void setDebugEnable(boolean z) {
        f7875r = z;
        C2569l.m4837b().setDebugEnable(z);
    }

    public static void setEnableConcurrentProcess(boolean z) {
        f7854P = z;
    }

    public static void setEnableSmartReporting(boolean z) {
        f7867j = z;
    }

    public static void setEnableStatService(boolean z) {
        f7876s = z;
        if (z) {
            return;
        }
        f7873p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    public static void setFlushDBSpaceMS(long j) {
        if (j > 0) {
            f7871n = j;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            f7873p.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            f7841C = str;
        }
    }

    public static void setInstallChannel(String str) {
        f7841C = str;
    }

    public static void setMaxBatchReportCount(int i) {
        if (m4987a(i, 2, 1000)) {
            f7882y = i;
        } else {
            f7873p.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            f7873p.m4879e("maxDaySessionNumbers must be greater than 0.");
        } else {
            f7850L = i;
        }
    }

    public static void setMaxImportantDataSendRetryCount(int i) {
        if (i > 100) {
            f7881x = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (m4987a(i, 1, 4096)) {
            f7844F = i;
        } else {
            f7873p.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            f7873p.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            f7853O = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (m4987a(i, 1, 1000)) {
            f7880w = i;
        } else {
            f7873p.error("setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            f7873p.error("maxSessionStatReportCount cannot be less than 0.");
        } else {
            f7848J = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (m4987a(i, 0, 500000)) {
            f7878u = i;
        } else {
            f7873p.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setNumEventsCachedInMemory(int i) {
        if (i >= 0) {
            f7870m = i;
        }
    }

    public static void setNumEventsCommitPerSec(int i) {
        if (i > 0) {
            f7883z = i;
        }
    }

    public static void setNumOfMethodsCalledLimit(int i, long j) {
        f7865h = i;
        if (j >= 1000) {
            f7866i = j;
        }
    }

    public static void setQQ(Context context, String str) {
        C2574q.m4792b(context, "mta.acc.qq", str);
        f7863f = str;
    }

    public static void setReportCompressedSize(int i) {
        if (i > 0) {
            f7872o = i;
        }
    }

    public static void setReportEventsByOrder(boolean z) {
        f7869l = z;
    }

    public static void setSendPeriodMinutes(int i) {
        if (m4987a(i, 1, 10080)) {
            f7843E = i;
        } else {
            f7873p.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (m4987a(i, 1000, 86400000)) {
            f7877t = i;
        } else {
            f7873p.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            f7873p.error("statReportUrl cannot be null or empty.");
            return;
        }
        f7847I = str;
        try {
            f7868k = new URI(f7847I).getHost();
        } catch (Exception e) {
            f7873p.m4875w(e);
        }
        if (isDebugEnable()) {
            StatLogger statLogger = f7873p;
            statLogger.m4877i("url:" + f7847I + ", domain:" + f7868k);
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        f7874q = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.f7891c = 0L;
        }
        if (isDebugEnable()) {
            StatLogger statLogger = f7873p;
            statLogger.m4880d("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void setXGProMode(boolean z) {
        f7856R = z;
    }
}
