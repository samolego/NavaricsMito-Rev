package com.senseplay.sdk.operate;

import com.senseplay.sdk.tool.SPSysTool;

/* loaded from: classes2.dex */
public class SPHdmi {
    private static final String hdmi = "/sys/devices/virtual/display/HDMI/connect";

    public static boolean isOpen() {
        return "1".equals(SPSysTool.readFile(hdmi));
    }
}
