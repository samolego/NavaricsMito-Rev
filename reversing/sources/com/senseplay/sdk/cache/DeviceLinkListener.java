package com.senseplay.sdk.cache;

import com.senseplay.sdk.model.device.DeviceInfo;

/* loaded from: classes2.dex */
public interface DeviceLinkListener {
    void finish();

    void search(DeviceInfo deviceInfo);
}
