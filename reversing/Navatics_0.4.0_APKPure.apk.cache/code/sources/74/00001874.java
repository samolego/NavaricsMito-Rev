package com.navatics.app.framework.divelog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class StartTimes implements Serializable {
    List<String> startTimes;

    public List<String> getStartTimes() {
        return this.startTimes;
    }

    public void setStartTimes(List<String> list) {
        this.startTimes = list;
    }

    public void addStartTime(String str) {
        if (this.startTimes == null) {
            this.startTimes = new ArrayList();
        }
        this.startTimes.add(str);
    }
}