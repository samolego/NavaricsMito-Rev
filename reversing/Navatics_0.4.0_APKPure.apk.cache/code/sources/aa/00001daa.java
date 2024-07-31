package com.senseplay.sdk.config;

/* loaded from: classes2.dex */
public class CacheConfig {
    private static final int CACHE_TASK_READ_TIME = 100;
    private static final int CACHE_TASK_TIME = 100;
    public static final int Post_Delayed = 150;
    public static final int Read_Delayed = 260;
    public static final int Write_Delayed = 580;
    private static int readTime = 100;
    private static int taskTime = 100;

    public static int getReadTime() {
        int i = readTime;
        if (i <= 20) {
            return 100;
        }
        return i;
    }

    public static void setReadTime(int i) {
        readTime = i;
    }

    public static int getTaskTime() {
        int i = taskTime;
        if (i <= 20) {
            return 100;
        }
        return i;
    }

    public static void setTaskTime(int i) {
        taskTime = i;
    }
}