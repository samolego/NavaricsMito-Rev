package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CurrentTimeProvider;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.u */
/* loaded from: classes2.dex */
class ScribeFilesManager extends EventsFilesManager<ScribeEvent> {
    public ScribeFilesManager(Context context, EventTransform<ScribeEvent> eventTransform, CurrentTimeProvider currentTimeProvider, QueueFileEventStorage queueFileEventStorage, int i) throws IOException {
        super(context, eventTransform, currentTimeProvider, queueFileEventStorage, i);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsFilesManager
    /* renamed from: b */
    protected String mo4274b() {
        UUID randomUUID = UUID.randomUUID();
        return "se_" + randomUUID.toString() + "_" + this.f8615c.mo4427a() + ".tap";
    }
}
