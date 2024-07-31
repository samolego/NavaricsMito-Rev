package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.github.mikephil.charting.utils.Utils;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.appevents.internal.b */
/* loaded from: classes.dex */
public class AppEventUtility {
    /* renamed from: a */
    public static void m11019a() {
    }

    /* renamed from: b */
    public static void m11016b() {
    }

    /* renamed from: a */
    public static double m11018a(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?", 8).matcher(str);
            if (matcher.find()) {
                return NumberFormat.getNumberInstance(Utility.m10500c()).parse(matcher.group(0)).doubleValue();
            }
            return Utils.DOUBLE_EPSILON;
        } catch (ParseException unused) {
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: a */
    public static String m11017a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public static boolean m11015c() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    /* renamed from: d */
    public static String m11014d() {
        Context m10869h = FacebookSdk.m10869h();
        try {
            return m10869h.getPackageManager().getPackageInfo(m10869h.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }
}
