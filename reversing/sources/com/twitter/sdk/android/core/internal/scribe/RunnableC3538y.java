package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.y */
/* loaded from: classes2.dex */
public class TimeBasedFileRollOverRunnable implements Runnable {

    /* renamed from: a */
    private final Context f8685a;

    /* renamed from: b */
    private final FileRollOverManager f8686b;

    public TimeBasedFileRollOverRunnable(Context context, FileRollOverManager fileRollOverManager) {
        this.f8685a = context;
        this.f8686b = fileRollOverManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CommonUtils.m4454a(this.f8685a, "Performing time based file roll over.");
            if (this.f8686b.mo4322c()) {
                return;
            }
            this.f8686b.mo4323b();
        } catch (Exception e) {
            CommonUtils.m4452a(this.f8685a, "Failed to roll over file", e);
        }
    }
}
