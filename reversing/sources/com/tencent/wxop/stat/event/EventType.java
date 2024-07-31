package com.tencent.wxop.stat.event;

import com.navatics.app.framework.user.Result;

/* loaded from: classes2.dex */
public enum EventType {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(Result.ERROR_CODE_KEY_1005);
    

    /* renamed from: a */
    private int f8101a;

    EventType(int i) {
        this.f8101a = i;
    }

    /* renamed from: a */
    public final int m4776a() {
        return this.f8101a;
    }
}
