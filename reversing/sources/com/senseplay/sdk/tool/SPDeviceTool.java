package com.senseplay.sdk.tool;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.telephony.TelephonyManager;
import java.io.File;

/* loaded from: classes2.dex */
public class SPDeviceTool {
    public static boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDeviceId(Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        return deviceId == null ? "-" : deviceId;
    }

    public static String getPhoneBrand() {
        return Build.BRAND;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static int getBuildLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getBuildVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getAppProcessId() {
        return Process.myPid();
    }

    public static String createAPPFolder(String str, Application application) {
        return createAPPFolder(str, application, null);
    }

    public static String createAPPFolder(String str, Application application, String str2) {
        File file;
        File file2;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (isSDCardAvailable() && externalStorageDirectory != null) {
            file = new File(externalStorageDirectory, str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            File file3 = new File(application.getCacheDir(), str);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            file = file3;
        }
        if (str2 != null) {
            file2 = new File(file, str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } else {
            file2 = file;
        }
        return file2.getAbsolutePath();
    }

    public static File uri2File(Activity activity, Uri uri) {
        File file;
        Cursor query = activity.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query != null) {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            file = new File(query.getString(columnIndexOrThrow));
        } else {
            file = new File(uri.getPath());
        }
        if (query != null) {
            query.close();
        }
        return file;
    }

    public static String getMetaData(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
