package com.tencent.wxop.stat;

/* renamed from: com.tencent.wxop.stat.ag */
/* loaded from: classes2.dex */
/* synthetic */ class C2404ag {

    /* renamed from: a */
    static final /* synthetic */ int[] f7974a = new int[StatReportStrategy.values().length];

    static {
        try {
            f7974a[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7974a[StatReportStrategy.PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7974a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7974a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7974a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7974a[StatReportStrategy.ONLY_WIFI.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7974a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}