package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.ScribeItem;
import java.util.ArrayList;

/* renamed from: com.twitter.sdk.android.tweetui.i */
/* loaded from: classes2.dex */
public class GalleryScribeClientImpl implements GalleryScribeClient {

    /* renamed from: a */
    final TweetUi f8969a;

    public GalleryScribeClientImpl(TweetUi tweetUi) {
        this.f8969a = tweetUi;
    }

    @Override // com.twitter.sdk.android.tweetui.GalleryScribeClient
    /* renamed from: a */
    public void mo4068a() {
        this.f8969a.m4098a(m4063e());
    }

    @Override // com.twitter.sdk.android.tweetui.GalleryScribeClient
    /* renamed from: a */
    public void mo4067a(ScribeItem scribeItem) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(scribeItem);
        this.f8969a.m4099a(m4064d(), arrayList);
    }

    @Override // com.twitter.sdk.android.tweetui.GalleryScribeClient
    /* renamed from: b */
    public void mo4066b() {
        this.f8969a.m4098a(m4062f());
    }

    @Override // com.twitter.sdk.android.tweetui.GalleryScribeClient
    /* renamed from: c */
    public void mo4065c() {
        this.f8969a.m4098a(m4061g());
    }

    /* renamed from: d */
    static EventNamespace m4064d() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("gallery").m4342f("impression").m4348a();
    }

    /* renamed from: e */
    static EventNamespace m4063e() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("gallery").m4342f("show").m4348a();
    }

    /* renamed from: f */
    static EventNamespace m4062f() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("gallery").m4342f("navigate").m4348a();
    }

    /* renamed from: g */
    static EventNamespace m4061g() {
        return new EventNamespace.C2678a().m4347a("tfw").m4346b("android").m4345c("gallery").m4342f("dismiss").m4348a();
    }
}
