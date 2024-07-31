package com.twitter.sdk.android.tweetui;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TimelineStateHolder.java */
/* renamed from: com.twitter.sdk.android.tweetui.u, reason: use source file name */
/* loaded from: classes2.dex */
class TimelineStateHolder {

    /* renamed from: a */
    TimelineCursor f9172a;

    /* renamed from: b */
    TimelineCursor f9173b;

    /* renamed from: c */
    public final AtomicBoolean f9174c;

    /* renamed from: a */
    public Long m8962a() {
        TimelineCursor timelineCursor = this.f9173b;
        if (timelineCursor == null) {
            return null;
        }
        return timelineCursor.f9161a;
    }

    /* renamed from: a */
    public void m8963a(TimelineCursor timelineCursor) {
        this.f9173b = timelineCursor;
        m8964b(timelineCursor);
    }

    /* renamed from: b */
    public void m8964b(TimelineCursor timelineCursor) {
        if (this.f9172a == null) {
            this.f9172a = timelineCursor;
        }
        if (this.f9173b == null) {
            this.f9173b = timelineCursor;
        }
    }

    /* renamed from: b */
    public boolean m8965b() {
        return this.f9174c.compareAndSet(false, true);
    }

    /* renamed from: c */
    public void m8966c() {
        this.f9174c.set(false);
    }
}