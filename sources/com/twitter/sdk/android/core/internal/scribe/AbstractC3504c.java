package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.c */
/* loaded from: classes2.dex */
public abstract class EnabledEventsStrategy<T> implements EventsStrategy<T> {

    /* renamed from: a */
    protected final Context f8595a;

    /* renamed from: b */
    protected final EventsFilesManager<T> f8596b;

    /* renamed from: c */
    final ScheduledExecutorService f8597c;

    /* renamed from: e */
    volatile int f8599e = -1;

    /* renamed from: d */
    final AtomicReference<ScheduledFuture<?>> f8598d = new AtomicReference<>();

    public EnabledEventsStrategy(Context context, ScheduledExecutorService scheduledExecutorService, EventsFilesManager<T> eventsFilesManager) {
        this.f8595a = context;
        this.f8597c = scheduledExecutorService;
        this.f8596b = eventsFilesManager;
    }

    /* renamed from: e */
    public void m4350e() {
        if (this.f8599e != -1) {
            m4351a(this.f8599e, this.f8599e);
        }
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    /* renamed from: a */
    public void mo4327a() {
        m4349f();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    /* renamed from: b */
    public void mo4323b() {
        if (this.f8598d.get() != null) {
            CommonUtils.m4454a(this.f8595a, "Cancelling time-based rollover because no events are currently being generated.");
            this.f8598d.get().cancel(false);
            this.f8598d.set(null);
        }
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    /* renamed from: a */
    public void mo4326a(T t) {
        CommonUtils.m4454a(this.f8595a, t.toString());
        try {
            this.f8596b.m4338a((EventsFilesManager<T>) t);
        } catch (IOException e) {
            CommonUtils.m4452a(this.f8595a, "Failed to write event.", e);
        }
        m4350e();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    /* renamed from: c */
    public boolean mo4322c() {
        try {
            return this.f8596b.m4341a();
        } catch (IOException e) {
            CommonUtils.m4452a(this.f8595a, "Failed to roll file over.", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m4352a(int i) {
        this.f8599e = i;
        m4351a(0L, this.f8599e);
    }

    /* renamed from: a */
    void m4351a(long j, long j2) {
        if (this.f8598d.get() == null) {
            TimeBasedFileRollOverRunnable timeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(this.f8595a, this);
            Context context = this.f8595a;
            CommonUtils.m4454a(context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f8598d.set(this.f8597c.scheduleAtFixedRate(timeBasedFileRollOverRunnable, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                CommonUtils.m4452a(this.f8595a, "Failed to schedule time based file roll over", e);
            }
        }
    }

    /* renamed from: f */
    void m4349f() {
        FilesSender d = mo4324d();
        if (d == null) {
            CommonUtils.m4454a(this.f8595a, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.m4454a(this.f8595a, "Sending all files");
        List<File> m4332e = this.f8596b.m4332e();
        int i = 0;
        while (m4332e.size() > 0) {
            try {
                CommonUtils.m4454a(this.f8595a, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(m4332e.size())));
                boolean mo4321a = d.mo4321a(m4332e);
                if (mo4321a) {
                    i += m4332e.size();
                    this.f8596b.m4336a(m4332e);
                }
                if (!mo4321a) {
                    break;
                }
                m4332e = this.f8596b.m4332e();
            } catch (Exception e) {
                Context context = this.f8595a;
                CommonUtils.m4452a(context, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (i == 0) {
            this.f8596b.m4331f();
        }
    }
}
