package com.twitter.sdk.android.core;

import okhttp3.C2984s;

/* renamed from: com.twitter.sdk.android.core.s */
/* loaded from: classes2.dex */
public class TwitterRateLimit {

    /* renamed from: a */
    private int f8821a;

    /* renamed from: b */
    private int f8822b;

    /* renamed from: c */
    private long f8823c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TwitterRateLimit(C2984s c2984s) {
        if (c2984s == null) {
            throw new IllegalArgumentException("headers must not be null");
        }
        for (int i = 0; i < c2984s.m2502a(); i++) {
            if ("x-rate-limit-limit".equals(c2984s.m2501a(i))) {
                this.f8821a = Integer.valueOf(c2984s.m2496b(i)).intValue();
            } else if ("x-rate-limit-remaining".equals(c2984s.m2501a(i))) {
                this.f8822b = Integer.valueOf(c2984s.m2496b(i)).intValue();
            } else if ("x-rate-limit-reset".equals(c2984s.m2501a(i))) {
                this.f8823c = Long.valueOf(c2984s.m2496b(i)).longValue();
            }
        }
    }
}
