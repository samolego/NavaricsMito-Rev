package com.senseplay.mframe.tool;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* loaded from: classes2.dex */
public class MUtilTool {
    public static boolean isNull(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isExtNull(List<?> list) {
        return list == null || list.isEmpty() || list.size() == 0;
    }

    public static boolean isExtNull(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    public static String toString(Object obj) {
        return (obj == null || "".equals(obj)) ? "" : obj.toString();
    }

    public static String toString(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int toInteger(Object obj) {
        if (obj == null || "".equals(obj)) {
            return 0;
        }
        return Integer.parseInt(obj.toString());
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            MDebug.m5821v("getVersionName", "PackageNameNotFoundException");
            return "";
        }
    }

    public static String streamToString(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception e) {
            MDebug.m5825e("streamToString", e.toString());
            return null;
        }
    }

    public static String asciiToString(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr[0] == 0 && bArr[1] == 0) {
                    return "000-00-0000-0-00000-00000-000000";
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return new String(bArr, "ascii");
    }
}
