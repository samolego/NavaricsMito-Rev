package com.twitter.sdk.android.tweetcomposer;

import java.util.Collections;

/* renamed from: com.twitter.sdk.android.tweetcomposer.c */
/* loaded from: classes2.dex */
class ComposerScribeClientImpl implements ComposerScribeClient {

    /* renamed from: a */
    private final InterfaceC2713e f8863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposerScribeClientImpl(InterfaceC2713e interfaceC2713e) {
        if (interfaceC2713e == null) {
            throw new NullPointerException("scribeClient must not be null");
        }
        this.f8863a = interfaceC2713e;
    }

    @Override // com.twitter.sdk.android.tweetcomposer.ComposerScribeClient
    /* renamed from: a */
    public void mo4187a() {
        this.f8863a.mo4178a(ScribeConstants.f8865a.m4344d("").m4343e("").m4342f("impression").m4348a(), Collections.EMPTY_LIST);
    }

    @Override // com.twitter.sdk.android.tweetcomposer.ComposerScribeClient
    /* renamed from: a */
    public void mo4186a(String str) {
        this.f8863a.mo4178a(ScribeConstants.f8865a.m4344d("").m4343e(str).m4342f("click").m4348a(), Collections.EMPTY_LIST);
    }
}
