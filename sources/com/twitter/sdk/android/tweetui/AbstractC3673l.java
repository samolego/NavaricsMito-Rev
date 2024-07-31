package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.InterfaceC2645h;
import com.twitter.sdk.android.core.TwitterException;

/* renamed from: com.twitter.sdk.android.tweetui.l */
/* loaded from: classes2.dex */
abstract class LoggingCallback<T> extends AbstractC2641c<T> {

    /* renamed from: a */
    private final AbstractC2641c f9099a;

    /* renamed from: b */
    private final InterfaceC2645h f9100b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoggingCallback(AbstractC2641c abstractC2641c, InterfaceC2645h interfaceC2645h) {
        this.f9099a = abstractC2641c;
        this.f9100b = interfaceC2645h;
    }

    @Override // com.twitter.sdk.android.core.AbstractC2641c
    /* renamed from: a */
    public void mo3868a(TwitterException twitterException) {
        this.f9100b.mo4556c("TweetUi", twitterException.getMessage(), twitterException);
        AbstractC2641c abstractC2641c = this.f9099a;
        if (abstractC2641c != null) {
            abstractC2641c.mo3868a(twitterException);
        }
    }
}
