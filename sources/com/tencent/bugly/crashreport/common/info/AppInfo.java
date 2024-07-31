package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class AppInfo {

    /* renamed from: a */
    private static ActivityManager f7199a;

    static {
        "@buglyAllChannel@".split(",");
        "@buglyAllChannelPriority@".split(",");
    }

    /* renamed from: a */
    public static String m5508a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    /* renamed from: b */
    public static PackageInfo m5504b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m5508a(context), 0);
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m5507a(Context context, String str) {
        if (context == null || str == null || str.trim().length() <= 0) {
            return false;
        }
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m5509a(int i) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/" + i + "/cmdline");
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i2 = 0;
            while (i2 < cArr.length && cArr[i2] != 0) {
                i2++;
            }
            String substring = new String(cArr).substring(0, i2);
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return substring;
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            try {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                String valueOf = String.valueOf(i);
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Throwable unused2) {
                    }
                }
                return valueOf;
            } catch (Throwable th3) {
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    /* renamed from: c */
    public static String m5503c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: d */
    public static Map<String, String> m5502d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                HashMap hashMap = new HashMap();
                Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
                if (obj != null) {
                    hashMap.put("BUGLY_DISABLE", obj.toString());
                }
                Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
                if (obj2 != null) {
                    hashMap.put("BUGLY_APPID", obj2.toString());
                }
                Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
                if (obj3 != null) {
                    hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
                }
                Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
                if (obj4 != null) {
                    hashMap.put("BUGLY_APP_VERSION", obj4.toString());
                }
                Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
                if (obj5 != null) {
                    hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
                }
                Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
                if (obj6 != null) {
                    hashMap.put("com.tencent.rdm.uuid", obj6.toString());
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static List<String> m5506a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] split = str.split(",");
                for (int i = 0; i < split.length; i++) {
                    split[i] = split[i].trim();
                }
                return Arrays.asList(split);
            }
            return null;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static String m5505a(byte[] bArr) {
        X509Certificate x509Certificate;
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                if (certificateFactory == null || (x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SHA1|");
                String m5037a = C2503z.m5037a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (m5037a != null && m5037a.length() > 0) {
                    sb.append(m5037a.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("MD5|");
                String m5037a2 = C2503z.m5037a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (m5037a2 != null && m5037a2.length() > 0) {
                    sb.append(m5037a2.toString());
                } else {
                    sb.append("unknown");
                }
            } catch (CertificateException e) {
                if (!C2499x.m5089a(e)) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return sb.length() == 0 ? "unknown" : sb.toString();
    }

    /* renamed from: e */
    public static String m5501e(Context context) {
        Signature[] signatureArr;
        String m5508a = m5508a(context);
        if (m5508a == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m5508a, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
                return null;
            }
            return m5505a(packageInfo.signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m5500f(Context context) {
        if (context == null) {
            return false;
        }
        if (f7199a == null) {
            f7199a = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f7199a.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                C2499x.m5085c("Memory is low.", new Object[0]);
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: h */
    private static String m5498h(Context context) {
        String str = "";
        InputStream inputStream = null;
        try {
            try {
                try {
                    String string = C2503z.m5042a("DENGTA_META", context).getString("key_channelpath", "");
                    if (C2503z.m5043a(string)) {
                        string = "channel.ini";
                    }
                    C2499x.m5090a("[AppInfo] Beacon channel file path: " + string, new Object[0]);
                    if (!string.equals("")) {
                        inputStream = context.getAssets().open(string);
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        str = properties.getProperty("CHANNEL", "");
                        C2499x.m5090a("[AppInfo] Beacon channel read from assert: " + str, new Object[0]);
                        if (!C2503z.m5043a(str)) {
                            return str;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            C2499x.m5089a(e);
                        }
                    }
                }
            } catch (Exception unused) {
                C2499x.m5084d("[AppInfo] Failed to get get beacon channel", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException e2) {
            C2499x.m5089a(e2);
        }
        return str;
    }

    /* renamed from: i */
    private static String m5497i(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            return obj != null ? obj.toString() : "";
        } catch (Throwable th) {
            C2499x.m5084d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
            C2499x.m5089a(th);
            return "";
        }
    }

    /* renamed from: g */
    public static String m5499g(Context context) {
        if (context == null) {
            return "";
        }
        String m5498h = m5498h(context);
        return !C2503z.m5043a(m5498h) ? m5498h : m5497i(context);
    }
}
