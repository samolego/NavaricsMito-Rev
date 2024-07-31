package com.navatics.app.framework.p049g;

import com.navatics.app.framework.RobotVersionInfo;
import com.navatics.app.framework.firmware.FirmwareInfo;
import java.util.ArrayList;

/* compiled from: Version.java */
/* renamed from: com.navatics.app.framework.g.f */
/* loaded from: classes.dex */
public class C1711f implements Comparable<C1711f> {

    /* renamed from: a */
    private String f4704a;

    /* renamed from: a */
    public static C1711f m4909a(FirmwareInfo firmwareInfo) {
        return new C1711f(firmwareInfo.getVersionValue().substring(1));
    }

    /* renamed from: a */
    public static C1711f m4908a(RobotVersionInfo robotVersionInfo) {
        return new C1711f(robotVersionInfo.toString().substring(1));
    }

    /* renamed from: a */
    public final String m4911a() {
        return this.f4704a;
    }

    public C1711f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Version can not be null");
        }
        if (!str.matches("[0-9]+(\\.[0-9]+)*")) {
            throw new IllegalArgumentException("Invalid version format");
        }
        this.f4704a = str;
    }

    /* renamed from: a */
    public static RobotVersionInfo m4907a(String str) {
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
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1711f c1711f) {
        if (c1711f == null) {
            return 1;
        }
        String[] split = m4911a().split("\\.");
        String[] split2 = c1711f.m4911a().split("\\.");
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
        return obj != null && getClass() == obj.getClass() && compareTo((C1711f) obj) == 0;
    }
}