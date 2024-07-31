package com.tencent.wxop.stat;

/* loaded from: classes2.dex */
public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    

    /* renamed from: a */
    int f7888a;

    StatReportStrategy(int i) {
        this.f7888a = i;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        StatReportStrategy[] values;
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.m4974a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final int m4974a() {
        return this.f7888a;
    }
}
