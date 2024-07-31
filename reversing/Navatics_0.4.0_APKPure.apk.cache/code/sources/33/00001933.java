package com.navatics.app.framework.user;

import java.io.Serializable;

/* loaded from: classes.dex */
public class DiveLogList implements Serializable {
    int maxversion;
    String startTime;

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public int getMaxversion() {
        return this.maxversion;
    }

    public void setMaxversion(int i) {
        this.maxversion = i;
    }
}