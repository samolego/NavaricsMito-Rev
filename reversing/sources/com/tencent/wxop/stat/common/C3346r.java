package com.tencent.wxop.stat.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.common.r */
/* loaded from: classes2.dex */
public class C2575r {

    /* renamed from: a */
    private static String f8095a = "";

    /* renamed from: a */
    public static String m4791a(Context context) {
        try {
            if (m4789a(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            } else {
                Log.e(StatConstants.LOG_TAG, "Could not get permission of android.permission.READ_PHONE_STATE");
            }
            return null;
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "get device id error", th);
            return null;
        }
    }

    /* renamed from: a */
    public static String m4788a(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C2563f.m4861b(C2565h.m4856a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "decode error", th);
            return str;
        }
    }

    /* renamed from: a */
    public static JSONArray m4790a(Context context, int i) {
        return null;
    }

    /* renamed from: a */
    public static void m4787a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e(StatConstants.LOG_TAG, "jsonPut error", th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m4789a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "checkPermission error", th);
            return false;
        }
    }

    /* renamed from: b */
    public static String m4786b(Context context) {
        if (!m4789a(context, "android.permission.ACCESS_WIFI_STATE")) {
            Log.e(StatConstants.LOG_TAG, "Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            Log.e(StatConstants.LOG_TAG, "get wifi address error", e);
            return "";
        }
    }

    /* renamed from: b */
    public static String m4785b(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C2565h.m4854b(C2563f.m4863a(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "encode error", th);
            return str;
        }
    }

    /* renamed from: c */
    public static WifiInfo m4784c(Context context) {
        WifiManager wifiManager;
        if (!m4789a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    /* renamed from: d */
    public static String m4783d(Context context) {
        try {
            WifiInfo m4784c = m4784c(context);
            if (m4784c != null) {
                return m4784c.getBSSID();
            }
            return null;
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "encode error", th);
            return null;
        }
    }

    /* renamed from: e */
    public static String m4782e(Context context) {
        try {
            WifiInfo m4784c = m4784c(context);
            if (m4784c != null) {
                return m4784c.getSSID();
            }
            return null;
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "encode error", th);
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m4781f(Context context) {
        try {
            if (m4789a(context, "android.permission.INTERNET") && m4789a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                        Log.w(StatConstants.LOG_TAG, "Network error");
                        return false;
                    }
                    return true;
                }
            } else {
                Log.e(StatConstants.LOG_TAG, "can not get the permisson of android.permission.INTERNET");
            }
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "isNetworkAvailable error", th);
        }
        return false;
    }
}
