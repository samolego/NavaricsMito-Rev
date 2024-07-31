package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import com.twitter.sdk.android.core.models.Tweet;
import java.util.ArrayList;

/* renamed from: com.twitter.sdk.android.tweetui.aa */
/* loaded from: classes2.dex */
class TweetScribeClientImpl implements TweetScribeClient {

    /* renamed from: a */
    final TweetUi f8939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TweetScribeClientImpl(TweetUi tweetUi) {
        this.f8939a = tweetUi;
    }

    @Override // com.twitter.sdk.android.tweetui.TweetScribeClient
    /* renamed from: a */
    public void mo3864a(Tweet tweet, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScribeItem.fromTweet(tweet));
        this.f8939a.m4099a(m4120a(str, z), arrayList);
        this.f8939a.m4099a(m4118b(str), arrayList);
    }

    @Override // com.twitter.sdk.android.tweetui.TweetScribeClient
    /* renamed from: a */
    public void mo3866a(Tweet tweet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScribeItem.fromTweet(tweet));
        this.f8939a.m4099a(m4117c(), arrayList);
    }

    @Override // com.twitter.sdk.android.tweetui.TweetScribeClient
    /* renamed from: b */
    public void mo3863b(Tweet tweet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScribeItem.fromTweet(tweet));
        this.f8939a.m4099a(m4119b(), arrayList);
    }

    @Override // com.twitter.sdk.android.tweetui.TweetScribeClient
    /* renamed from: c */
    public void mo3862c(Tweet tweet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScribeItem.fromTweet(tweet));
        this.f8939a.m4099a(m4122a(), arrayList);
    }

    @Override // com.twitter.sdk.android.tweetui.TweetScribeClient
    /* renamed from: a */
    public void mo3865a(Tweet tweet, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ScribeItem.fromTweet(tweet));
        this.f8939a.m4099a(m4121a(str), arrayList);
    }

    /* renamed from: a */
    static EventNamespace m4120a(String str, boolean z) {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("tweet").m4344d(str).m4343e(z ? "actions" : "").m4342f("impression").m4348a();
    }

    /* renamed from: a */
    static EventNamespace m4122a() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("tweet").m4343e("actions").m4342f("unfavorite").m4348a();
    }

    /* renamed from: b */
    static EventNamespace m4119b() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("tweet").m4343e("actions").m4342f("favorite").m4348a();
    }

    /* renamed from: c */
    static EventNamespace m4117c() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("tweet").m4343e("actions").m4342f("share").m4348a();
    }

    /* renamed from: a */
    static EventNamespace m4121a(String str) {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("tweet").m4344d(str).m4343e("").m4342f("click").m4348a();
    }

    /* renamed from: b */
    static EventNamespace m4118b(String str) {
        return new EventNamespace.C2678a().m4347a("android").m4346b("tweet").m4345c(str).m4344d("").m4343e("").m4342f("impression").m4348a();
    }
}
