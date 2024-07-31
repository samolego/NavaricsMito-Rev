package com.navatics.app.framework.firmware;

import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.p055g.Version;
import com.navatics.nvtsshare.C2057d;

/* renamed from: com.navatics.app.framework.firmware.h */
/* loaded from: classes.dex */
public class FirmwareUtil {
    /* renamed from: a */
    public static String m8175a(int i) {
        if (i != 1) {
            return null;
        }
        return "MITO";
    }

    /* renamed from: a */
    public static boolean m8174a(FirmwareInfo firmwareInfo, RobotVersionInfo robotVersionInfo) {
        return robotVersionInfo == null || Version.m8065a(firmwareInfo).compareTo(Version.m8066a(robotVersionInfo)) > 0;
    }

    /* renamed from: a */
    public static String m8173a(String str) {
        if (C2057d.m6585a(str)) {
            return "";
        }
        String str2 = "";
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            int i = indexOf + 3;
            str2 = str.substring(0, i);
            str = str.substring(i);
        }
        int indexOf2 = str.indexOf("/");
        if (indexOf2 != -1) {
            str = str.substring(0, indexOf2 + 1);
        }
        return str2 + str;
    }

    /* renamed from: b */
    public static String m8172b(String str) {
        String str2 = "";
        if (str == null) {
            return "";
        }
        int i = 0;
        for (int length = str.length() - 1; length > 0 && i != 2; length--) {
            if (str.charAt(length - 1) == '.') {
                i++;
            }
            str2 = str.charAt(length) + str2;
        }
        return str2;
    }
}
