package com.twitter.sdk.android.tweetui;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.twitter.sdk.android.tweetui.u */
/* loaded from: classes2.dex */
class TimelineStateHolder {

    /* renamed from: a */
    TimelineCursor f9132a;

    /* renamed from: b */
    TimelineCursor f9133b;

    /* renamed from: c */
    public final AtomicBoolean f9134c;

    /* renamed from: a */
    public Long m3890a() {
        TimelineCursor timelineCursor = this.f9133b;
        if (timelineCursor == null) {
            return null;
        }
        return timelineCursor.f9121a;
    }

    /* renamed from: a */
    public void m3889a(TimelineCursor timelineCursor) {
        this.f9133b = timelineCursor;
        m3887b(timelineCursor);
    }

    /* renamed from: b */
    public void m3887b(TimelineCursor timelineCursor) {
        if (this.f9132a == null) {
            this.f9132a = timelineCursor;
        }
        if (this.f9133b == null) {
            this.f9133b = timelineCursor;
        }
    }

    /* renamed from: b */
    public boolean m3888b() {
        return this.f9134c.compareAndSet(false, true);
    }

    /* renamed from: c */
    public void m3886c() {
        this.f9134c.set(false);
    }
}
