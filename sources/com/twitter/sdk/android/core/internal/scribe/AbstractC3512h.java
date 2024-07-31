package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.h */
/* loaded from: classes2.dex */
public abstract class EventsHandler<T> implements EventsStorageListener {

    /* renamed from: a */
    protected final Context f8623a;

    /* renamed from: b */
    protected final ScheduledExecutorService f8624b;

    /* renamed from: c */
    protected EventsStrategy<T> f8625c;

    public EventsHandler(Context context, EventsStrategy<T> eventsStrategy, EventsFilesManager eventsFilesManager, ScheduledExecutorService scheduledExecutorService) {
        this.f8623a = context.getApplicationContext();
        this.f8624b = scheduledExecutorService;
        this.f8625c = eventsStrategy;
        eventsFilesManager.m4339a((EventsStorageListener) this);
    }

    /* renamed from: a */
    public void m4329a(final T t, final boolean z) {
        m4328a(new Runnable() { // from class: com.twitter.sdk.android.core.internal.scribe.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.f8625c.mo4326a(t);
                    if (z) {
                        EventsHandler.this.f8625c.mo4322c();
                    }
                } catch (Exception e) {
                    CommonUtils.m4452a(EventsHandler.this.f8623a, "Failed to record event.", e);
                }
            }
        });
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorageListener
    /* renamed from: a */
    public void mo4325a(String str) {
        m4328a(new Runnable() { // from class: com.twitter.sdk.android.core.internal.scribe.h.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    EventsHandler.this.f8625c.mo4327a();
                } catch (Exception e) {
                    CommonUtils.m4452a(EventsHandler.this.f8623a, "Failed to send events files.", e);
                }
            }
        });
    }

    /* renamed from: a */
    protected void m4328a(Runnable runnable) {
        try {
            this.f8624b.submit(runnable);
        } catch (Exception e) {
            CommonUtils.m4452a(this.f8623a, "Failed to submit events task", e);
        }
    }
}
