package com.navatics.app.framework.p055g;

import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.firmware.FirmwareInfo;
import java.util.ArrayList;

/* renamed from: com.navatics.app.framework.g.f */
/* loaded from: classes.dex */
public class Version implements Comparable<Version> {

    /* renamed from: a */
    private String f4682a;

    /* renamed from: a */
    public static Version m8065a(FirmwareInfo firmwareInfo) {
        return new Version(firmwareInfo.getVersionValue().substring(1));
    }

    /* renamed from: a */
    public static Version m8066a(RobotVersionInfo robotVersionInfo) {
        return new Version(robotVersionInfo.toString().substring(1));
    }

    /* renamed from: a */
    public final String m8067a() {
        return this.f4682a;
    }

    public Version(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Version can not be null");
        }
        if (!str.matches("[0-9]+(\\.[0-9]+)*")) {
            throw new IllegalArgumentException("Invalid version format");
        }
        this.f4682a = str;
    }

    /* renamed from: a */
    public static RobotVersionInfo m8063a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String str2 = str + "。";
        String str3 = "";
        for (int i = 0; i < str2.length(); i++) {
            if ('0' > str2.charAt(i) || str2.charAt(i) > '9') {
                if (!str3.equals("")) {
                    arrayList.add(str3);
                }
                str3 = "";
            } else {
                str3 = str3 + str2.charAt(i);
            }
        }
        if (arrayList.size() < 3) {
            return null;
        }
        try {
            return new RobotVersionInfo(1, Integer.valueOf((String) arrayList.get(0)).intValue(), Integer.valueOf((String) arrayList.get(1)).intValue(), Integer.valueOf((String) arrayList.get(2)).intValue());
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Version version) {
        if (version == null) {
            return 1;
        }
        String[] split = m8067a().split("\\.");
        String[] split2 = version.m8067a().split("\\.");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && compareTo((Version) obj) == 0;
    }
}
