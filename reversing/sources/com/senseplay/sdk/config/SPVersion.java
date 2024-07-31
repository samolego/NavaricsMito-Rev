package com.senseplay.sdk.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.senseplay.sdk.BuildConfig;
import com.senseplay.sdk.bean.VersionInfo;

/* loaded from: classes2.dex */
public class SPVersion {
    private static final String URL_PRODUCT = "http://";
    private static final String URL_STAGING = "http://staging.";
    private static final String URL_TEST = "http://test.";
    private static boolean isDebug = true;
    private static boolean isTest = false;
    public static int v_staging = 2;
    public static int v_test = 1;
    public static int v_product = 3;
    private static int v_type = v_product;

    public static void setVerType(int i) {
        v_type = i;
    }

    public static String getUrl() {
        int i = v_test;
        int i2 = v_type;
        return i == i2 ? URL_TEST : v_staging == i2 ? URL_STAGING : v_product == i2 ? URL_PRODUCT : URL_TEST;
    }

    public static VersionInfo getVersion(Context context) {
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setName("0.0.23.25.22.20");
        if (isTest) {
            versionInfo.setNetwrok("staging.com");
        } else {
            versionInfo.setNetwrok("staging.cn");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, 0);
            if (packageInfo != null) {
                versionInfo.setCode(packageInfo.versionCode);
                versionInfo.setName(packageInfo.versionName);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionInfo;
    }

    public static boolean isDebug() {
        return isDebug;
    }
}
