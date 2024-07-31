package org.apache.ftpserver.ipfilter;

/* loaded from: classes2.dex */
public enum IpFilterType {
    ALLOW,
    DENY;

    public static IpFilterType parse(String str) {
        IpFilterType[] values;
        for (IpFilterType ipFilterType : values()) {
            if (ipFilterType.name().equalsIgnoreCase(str)) {
                return ipFilterType;
            }
        }
        throw new IllegalArgumentException("Invalid IpFilterType: " + str);
    }
}
