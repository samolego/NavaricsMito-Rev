package com.senseplay.sdk.config;

/* loaded from: classes2.dex */
public class SPConfig {
    public static final int WEB_SCREEN_LANDSCAPE = 2;
    public static final int WEB_SCREEN_PORTRAIT = 1;
    public static final int WEB_SCREEN_SENSOR_LANDSCAPE = 4;
    public static final int WEB_SCREEN_SENSOR_PORTRAIT = 3;
    private static boolean isDebug = SPVersion.isDebug();
    private static int WEB_SCREEN = 0;

    public static void setDebug(boolean z) {
        isDebug = z;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static int getWebScreen() {
        return WEB_SCREEN;
    }

    public static void setWebScreen(int i) {
        WEB_SCREEN = i;
    }
}