package com.log;

import android.util.Log;

/* loaded from: classes.dex */
public class log {
    public static boolean CMD_DG = false;
    public static boolean READ_CMD_HEX_DG = false;
    public static boolean SEND_CMD_HEX_DG = false;
    public static boolean UDP_LOG = true;
    public static boolean USB_HDR_DG = false;
    public static boolean USB_READ_DG = false;

    public static void send(String str, String str2) {
        if (UDP_LOG) {
            Log.v(str, str2);
        }
    }
}