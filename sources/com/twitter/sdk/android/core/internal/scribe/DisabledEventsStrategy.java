package com.twitter.sdk.android.core.internal.scribe;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.b */
/* loaded from: classes2.dex */
public class DisabledEventsStrategy<T> implements EventsStrategy<T> {
    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    /* renamed from: a */
    public void mo4327a() {
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsManager
    /* renamed from: a */
    public void mo4326a(T t) {
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    /* renamed from: b */
    public void mo4323b() {
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FileRollOverManager
    /* renamed from: c */
    public boolean mo4322c() {
        return false;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStrategy
    /* renamed from: d */
    public FilesSender mo4324d() {
        return null;
    }
}
