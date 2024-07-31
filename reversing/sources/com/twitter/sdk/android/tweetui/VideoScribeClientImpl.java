package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import java.util.ArrayList;

/* renamed from: com.twitter.sdk.android.tweetui.ah */
/* loaded from: classes2.dex */
class VideoScribeClientImpl implements VideoScribeClient {

    /* renamed from: a */
    final TweetUi f8951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoScribeClientImpl(TweetUi tweetUi) {
        this.f8951a = tweetUi;
    }

    @Override // com.twitter.sdk.android.tweetui.VideoScribeClient
    /* renamed from: a */
    public void mo4079a(ScribeItem scribeItem) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(scribeItem);
        this.f8951a.m4099a(m4080a(), arrayList);
    }

    @Override // com.twitter.sdk.android.tweetui.VideoScribeClient
    /* renamed from: b */
    public void mo4077b(ScribeItem scribeItem) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(scribeItem);
        this.f8951a.m4099a(m4078b(), arrayList);
    }

    /* renamed from: a */
    static EventNamespace m4080a() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("video").m4342f("impression").m4348a();
    }

    /* renamed from: b */
    static EventNamespace m4078b() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("video").m4342f("play").m4348a();
    }
}
