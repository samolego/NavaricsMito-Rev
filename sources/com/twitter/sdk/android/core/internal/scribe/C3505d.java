package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.twitter.sdk.android.core.internal.scribe.d */
/* loaded from: classes2.dex */
public class EnabledScribeStrategy extends EnabledEventsStrategy<ScribeEvent> {

    /* renamed from: f */
    private final FilesSender f8600f;

    public EnabledScribeStrategy(Context context, ScheduledExecutorService scheduledExecutorService, ScribeFilesManager scribeFilesManager, ScribeConfig scribeConfig, ScribeFilesSender scribeFilesSender) {
        super(context, scheduledExecutorService, scribeFilesManager);
        this.f8600f = scribeFilesSender;
        m4352a(scribeConfig.f8668h);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStrategy
    /* renamed from: d */
    public FilesSender mo4324d() {
        return this.f8600f;
    }
}
