package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetcomposer.f */
/* loaded from: classes2.dex */
class ScribeClientImpl implements InterfaceC2713e {

    /* renamed from: a */
    private final DefaultScribeClient f8864a;

    public ScribeClientImpl(DefaultScribeClient defaultScribeClient) {
        this.f8864a = defaultScribeClient;
    }

    @Override // com.twitter.sdk.android.tweetcomposer.InterfaceC2713e
    /* renamed from: a */
    public void mo4178a(EventNamespace eventNamespace, List<ScribeItem> list) {
        DefaultScribeClient defaultScribeClient = this.f8864a;
        if (defaultScribeClient != null) {
            defaultScribeClient.m4363a(eventNamespace, list);
        }
    }
}
