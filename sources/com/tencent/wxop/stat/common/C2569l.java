package com.tencent.wxop.stat.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.l */
/* loaded from: classes2.dex */
public class C2569l {

    /* renamed from: a */
    private static String f8069a = null;

    /* renamed from: b */
    private static String f8070b = null;

    /* renamed from: c */
    private static String f8071c = null;

    /* renamed from: d */
    private static String f8072d = null;

    /* renamed from: e */
    private static Random f8073e = null;

    /* renamed from: f */
    private static DisplayMetrics f8074f = null;

    /* renamed from: g */
    private static String f8075g = null;

    /* renamed from: h */
    private static String f8076h = "";

    /* renamed from: i */
    private static String f8077i = "";

    /* renamed from: j */
    private static int f8078j = -1;

    /* renamed from: k */
    private static StatLogger f8079k = null;

    /* renamed from: l */
    private static String f8080l = null;

    /* renamed from: m */
    private static String f8081m = null;

    /* renamed from: n */
    private static volatile int f8082n = -1;

    /* renamed from: o */
    private static String f8083o = null;

    /* renamed from: p */
    private static String f8084p = null;

    /* renamed from: q */
    private static long f8085q = -1;

    /* renamed from: r */
    private static String f8086r = "";

    /* renamed from: s */
    private static C2572o f8087s = null;

    /* renamed from: t */
    private static String f8088t = "__MTA_FIRST_ACTIVATE__";

    /* renamed from: u */
    private static int f8089u = -1;

    /* renamed from: v */
    private static long f8090v = -1;

    /* renamed from: w */
    private static int f8091w = 0;

    /* renamed from: x */
    private static String f8092x = "";

    /* renamed from: A */
    public static String m4850A(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) {
            return null;
        }
        return resolveActivity.activityInfo.packageName;
    }

    /* renamed from: B */
    private static long m4849B(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: a */
    public static int m4848a() {
        return m4825g().nextInt(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    public static int m4842a(Context context, boolean z) {
        if (z) {
            f8091w = m4805y(context);
        }
        return f8091w;
    }

    /* renamed from: a */
    public static Long m4839a(String str, String str2, int i, int i2, Long l) {
        if (str != null && str2 != null) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
                str2 = "\\" + str2;
            }
            String[] split = str.split(str2);
            if (split.length == i2) {
                try {
                    Long l2 = 0L;
                    for (String str3 : split) {
                        l2 = Long.valueOf(i * (l2.longValue() + Long.valueOf(str3).longValue()));
                    }
                    return l2;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l;
    }

    /* renamed from: a */
    public static String m4847a(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
    }

    /* renamed from: a */
    public static String m4846a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    /* renamed from: a */
    public static String m4843a(Context context, String str) {
        if (StatConfig.isEnableConcurrentProcess()) {
            if (f8081m == null) {
                f8081m = m4815o(context);
            }
            if (f8081m != null) {
                return str + "_" + f8081m;
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m4840a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    /* renamed from: a */
    public static HttpHost m4845a(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            if ((activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    if (defaultHost != null && defaultHost.trim().length() > 0) {
                        return new HttpHost(defaultHost, Proxy.getDefaultPort());
                    }
                    return null;
                }
                return new HttpHost("10.0.0.172", 80);
            }
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public static void m4844a(Context context, int i) {
        f8091w = i;
        C2574q.m4794b(context, "mta.qq.com.difftime", i);
    }

    /* renamed from: a */
    public static boolean m4841a(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (statSpecifyReportedInfo == null) {
            return false;
        }
        return m4832c(statSpecifyReportedInfo.getAppKey());
    }

    /* renamed from: a */
    public static byte[] m4838a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    /* renamed from: b */
    public static long m4835b(String str) {
        return m4839a(str, ".", 100, 3, 0L).longValue();
    }

    /* renamed from: b */
    public static synchronized StatLogger m4837b() {
        StatLogger statLogger;
        synchronized (C2569l.class) {
            if (f8079k == null) {
                StatLogger statLogger2 = new StatLogger(StatConstants.LOG_TAG);
                f8079k = statLogger2;
                statLogger2.setDebugEnable(false);
            }
            statLogger = f8079k;
        }
        return statLogger;
    }

    /* renamed from: b */
    public static synchronized String m4836b(Context context) {
        synchronized (C2569l.class) {
            if (f8069a != null && f8069a.trim().length() != 0) {
                return f8069a;
            }
            String m4791a = C2575r.m4791a(context);
            f8069a = m4791a;
            if (m4791a == null || f8069a.trim().length() == 0) {
                f8069a = Integer.toString(m4825g().nextInt(Integer.MAX_VALUE));
            }
            return f8069a;
        }
    }

    /* renamed from: c */
    public static long m4834c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f8079k.m4878e(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    /* renamed from: c */
    public static synchronized String m4833c(Context context) {
        String str;
        synchronized (C2569l.class) {
            if (f8071c == null || f8071c.trim().length() == 0) {
                f8071c = C2575r.m4786b(context);
            }
            str = f8071c;
        }
        return str;
    }

    /* renamed from: c */
    public static boolean m4832c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    /* renamed from: d */
    public static DisplayMetrics m4830d(Context context) {
        if (f8074f == null) {
            f8074f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f8074f);
        }
        return f8074f;
    }

    /* renamed from: d */
    public static String m4831d() {
        if (m4832c(f8084p)) {
            return f8084p;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1000000) + "/" + String.valueOf(m4829e() / 1000000);
        f8084p = str;
        return str;
    }

    /* renamed from: e */
    public static long m4829e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    /* renamed from: e */
    public static boolean m4828e(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        if (!C2575r.m4789a(context, "android.permission.ACCESS_WIFI_STATE")) {
            f8079k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public static String m4826f(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    /* renamed from: g */
    public static String m4824g(Context context) {
        TelephonyManager telephonyManager;
        String str = f8075g;
        if (str != null) {
            return str;
        }
        try {
            if (!C2575r.m4789a(context, "android.permission.READ_PHONE_STATE")) {
                f8079k.m4879e("Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (m4821i(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                f8075g = telephonyManager.getSimOperator();
            }
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        return f8075g;
    }

    /* renamed from: g */
    private static synchronized Random m4825g() {
        Random random;
        synchronized (C2569l.class) {
            if (f8073e == null) {
                f8073e = new Random();
            }
            random = f8073e;
        }
        return random;
    }

    /* renamed from: h */
    private static long m4823h() {
        long j = f8085q;
        if (j > 0) {
            return j;
        }
        long j2 = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j2 = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
        } catch (Exception unused) {
        }
        f8085q = j2;
        return j2;
    }

    /* renamed from: h */
    public static String m4822h(Context context) {
        if (m4832c(f8076h)) {
            return f8076h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f8076h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        return f8076h;
    }

    /* renamed from: i */
    public static boolean m4821i(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    /* renamed from: j */
    public static String m4820j(Context context) {
        String str = "";
        try {
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        if (C2575r.m4789a(context, "android.permission.INTERNET") && C2575r.m4789a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (!typeName.equalsIgnoreCase("WIFI")) {
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            str = extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo == null) {
                                str = typeName;
                            }
                        }
                        f8079k.m4878e(th);
                        return str;
                    }
                    str = "WIFI";
                }
            }
        } else {
            f8079k.m4879e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        }
        return str;
    }

    /* renamed from: k */
    public static Integer m4819k(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: l */
    public static String m4818l(Context context) {
        String str;
        if (m4832c(f8077i)) {
            return f8077i;
        }
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f8077i = str;
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        if (str != null) {
            if (f8077i.length() == 0) {
                return "unknown";
            }
            return f8077i;
        }
        return "unknown";
    }

    /* renamed from: m */
    public static int m4817m(Context context) {
        int i = f8078j;
        if (i != -1) {
            return i;
        }
        try {
            if (C2573p.m4799a()) {
                f8078j = 1;
            }
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        f8078j = 0;
        return 0;
    }

    /* renamed from: n */
    public static String m4816n(Context context) {
        String path;
        if (m4832c(f8080l)) {
            return f8080l;
        }
        try {
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        if (!C2575r.m4789a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            f8079k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            String str = String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000) + "/" + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
            f8080l = str;
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static String m4815o(Context context) {
        if (f8081m != null) {
            return f8081m;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                f8081m = next.processName;
                break;
            }
        }
        return f8081m;
    }

    /* renamed from: p */
    public static String m4814p(Context context) {
        return m4843a(context, StatConstants.DATABASE_NAME);
    }

    /* renamed from: q */
    public static synchronized Integer m4813q(Context context) {
        Integer valueOf;
        synchronized (C2569l.class) {
            if (f8082n <= 0) {
                f8082n = C2574q.m4797a(context, "MTA_EVENT_INDEX", 0);
                C2574q.m4794b(context, "MTA_EVENT_INDEX", f8082n + 1000);
            } else if (f8082n % 1000 == 0) {
                int i = f8082n + 1000;
                if (f8082n >= 2147383647) {
                    i = 0;
                }
                C2574q.m4794b(context, "MTA_EVENT_INDEX", i);
            }
            int i2 = f8082n + 1;
            f8082n = i2;
            valueOf = Integer.valueOf(i2);
        }
        return valueOf;
    }

    /* renamed from: r */
    public static String m4812r(Context context) {
        try {
            return String.valueOf(m4849B(context) / 1000000) + "/" + String.valueOf(m4823h() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: s */
    public static JSONObject m4811s(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", C2570m.m4803a());
            String m4800d = C2570m.m4800d();
            if (m4800d != null && m4800d.length() > 0) {
                jSONObject.put("na", m4800d);
            }
            int m4802b = C2570m.m4802b();
            if (m4802b > 0) {
                jSONObject.put("fx", m4802b / 1000000);
            }
            int m4801c = C2570m.m4801c();
            if (m4801c > 0) {
                jSONObject.put("fn", m4801c / 1000000);
            }
        } catch (Throwable th) {
            Log.w(StatConstants.LOG_TAG, "get cpu error", th);
        }
        return jSONObject;
    }

    /* renamed from: t */
    public static String m4810t(Context context) {
        List<Sensor> sensorList;
        if (m4832c(f8086r)) {
            return f8086r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                StringBuilder sb = new StringBuilder(sensorList.size() * 10);
                for (int i = 0; i < sensorList.size(); i++) {
                    sb.append(sensorList.get(i).getType());
                    if (i != sensorList.size() - 1) {
                        sb.append(",");
                    }
                }
                f8086r = sb.toString();
            }
        } catch (Throwable th) {
            f8079k.m4878e(th);
        }
        return f8086r;
    }

    /* renamed from: u */
    public static synchronized int m4809u(Context context) {
        synchronized (C2569l.class) {
            if (f8089u != -1) {
                return f8089u;
            }
            m4808v(context);
            return f8089u;
        }
    }

    /* renamed from: v */
    public static void m4808v(Context context) {
        int m4797a = C2574q.m4797a(context, f8088t, 1);
        f8089u = m4797a;
        if (m4797a == 1) {
            C2574q.m4794b(context, f8088t, 0);
        }
    }

    /* renamed from: w */
    public static boolean m4807w(Context context) {
        if (f8090v < 0) {
            f8090v = C2574q.m4796a(context, "mta.qq.com.checktime", 0L);
        }
        return Math.abs(System.currentTimeMillis() - f8090v) > 86400000;
    }

    /* renamed from: x */
    public static void m4806x(Context context) {
        f8090v = System.currentTimeMillis();
        C2574q.m4793b(context, "mta.qq.com.checktime", f8090v);
    }

    /* renamed from: y */
    public static int m4805y(Context context) {
        return C2574q.m4797a(context, "mta.qq.com.difftime", 0);
    }

    /* renamed from: z */
    public static boolean m4804z(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.startsWith(packageName)) {
                if (next.importance == 400) {
                    return true;
                }
            }
        }
        return false;
    }
}
