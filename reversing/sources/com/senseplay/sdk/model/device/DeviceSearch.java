package com.senseplay.sdk.model.device;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceSearch {
    private List<DeviceInfo> deviceList;
    private boolean isFinish;

    public boolean isFinish() {
        return this.isFinish;
    }

    public void setFinish(boolean z) {
        this.isFinish = z;
    }

    public List<DeviceInfo> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<DeviceInfo> list) {
        this.deviceList = list;
    }
}
