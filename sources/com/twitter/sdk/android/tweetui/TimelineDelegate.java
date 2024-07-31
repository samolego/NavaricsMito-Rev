package com.twitter.sdk.android.tweetui;

import android.database.DataSetObservable;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Identifiable;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.s */
/* loaded from: classes2.dex */
class TimelineDelegate<T extends Identifiable> {

    /* renamed from: a */
    final Timeline<T> f9122a;

    /* renamed from: b */
    final DataSetObservable f9123b;

    /* renamed from: c */
    final TimelineStateHolder f9124c;

    /* renamed from: d */
    List<T> f9125d;

    /* renamed from: a */
    public void m3897a() {
        m3895a(this.f9124c.m3890a(), new C2768b(this.f9124c));
    }

    /* renamed from: b */
    public int m3894b() {
        return this.f9125d.size();
    }

    /* renamed from: a */
    public T m3896a(int i) {
        if (m3893b(i)) {
            m3897a();
        }
        return this.f9125d.get(i);
    }

    /* renamed from: c */
    boolean m3892c() {
        return ((long) this.f9125d.size()) < 200;
    }

    /* renamed from: b */
    boolean m3893b(int i) {
        return i == this.f9125d.size() - 1;
    }

    /* renamed from: a */
    void m3895a(Long l, AbstractC2641c<TimelineResult<T>> abstractC2641c) {
        if (m3892c()) {
            if (this.f9124c.m3888b()) {
                this.f9122a.m3898a(l, abstractC2641c);
                return;
            } else {
                abstractC2641c.mo3868a(new TwitterException("Request already in flight"));
                return;
            }
        }
        abstractC2641c.mo3868a(new TwitterException("Max capacity reached"));
    }

    /* compiled from: TimelineDelegate.java */
    /* renamed from: com.twitter.sdk.android.tweetui.s$a */
    /* loaded from: classes2.dex */
    class C2767a extends AbstractC2641c<TimelineResult<T>> {

        /* renamed from: a */
        final AbstractC2641c<TimelineResult<T>> f9126a;

        /* renamed from: b */
        final TimelineStateHolder f9127b;

        C2767a(AbstractC2641c<TimelineResult<T>> abstractC2641c, TimelineStateHolder timelineStateHolder) {
            this.f9126a = abstractC2641c;
            this.f9127b = timelineStateHolder;
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3867a(Result<TimelineResult<T>> result) {
            this.f9127b.m3886c();
            AbstractC2641c<TimelineResult<T>> abstractC2641c = this.f9126a;
            if (abstractC2641c != null) {
                abstractC2641c.mo3867a(result);
            }
        }

        @Override // com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3868a(TwitterException twitterException) {
            this.f9127b.m3886c();
            AbstractC2641c<TimelineResult<T>> abstractC2641c = this.f9126a;
            if (abstractC2641c != null) {
                abstractC2641c.mo3868a(twitterException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimelineDelegate.java */
    /* renamed from: com.twitter.sdk.android.tweetui.s$b */
    /* loaded from: classes2.dex */
    public class C2768b extends TimelineDelegate<T>.C2767a {
        C2768b(TimelineStateHolder timelineStateHolder) {
            super(null, timelineStateHolder);
        }

        @Override // com.twitter.sdk.android.tweetui.TimelineDelegate.C2767a, com.twitter.sdk.android.core.AbstractC2641c
        /* renamed from: a */
        public void mo3867a(Result<TimelineResult<T>> result) {
            if (result.f8688a.f9131b.size() > 0) {
                TimelineDelegate.this.f9125d.addAll(result.f8688a.f9131b);
                TimelineDelegate.this.m3891d();
                this.f9127b.m3889a(result.f8688a.f9130a);
            }
            super.mo3867a(result);
        }
    }

    /* renamed from: d */
    public void m3891d() {
        this.f9123b.notifyChanged();
    }
}
