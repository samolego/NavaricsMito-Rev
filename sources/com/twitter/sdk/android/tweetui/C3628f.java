package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.MentionEntity;
import com.twitter.sdk.android.core.models.SymbolEntity;
import com.twitter.sdk.android.core.models.UrlEntity;

/* renamed from: com.twitter.sdk.android.tweetui.f */
/* loaded from: classes2.dex */
class FormattedUrlEntity {

    /* renamed from: c */
    int f8961c;

    /* renamed from: d */
    int f8962d;

    /* renamed from: e */
    final String f8963e;

    /* renamed from: f */
    final String f8964f;

    /* renamed from: g */
    final String f8965g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormattedUrlEntity(int i, int i2, String str, String str2, String str3) {
        this.f8961c = i;
        this.f8962d = i2;
        this.f8963e = str;
        this.f8964f = str2;
        this.f8965g = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FormattedUrlEntity m4070a(UrlEntity urlEntity) {
        return new FormattedUrlEntity(urlEntity.getStart(), urlEntity.getEnd(), urlEntity.displayUrl, urlEntity.url, urlEntity.expandedUrl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FormattedUrlEntity m4073a(HashtagEntity hashtagEntity) {
        String m4088b = TweetUtils.m4088b(hashtagEntity.text);
        int start = hashtagEntity.getStart();
        int end = hashtagEntity.getEnd();
        return new FormattedUrlEntity(start, end, "#" + hashtagEntity.text, m4088b, m4088b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FormattedUrlEntity m4072a(MentionEntity mentionEntity) {
        String m4091a = TweetUtils.m4091a(mentionEntity.screenName);
        int start = mentionEntity.getStart();
        int end = mentionEntity.getEnd();
        return new FormattedUrlEntity(start, end, "@" + mentionEntity.screenName, m4091a, m4091a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FormattedUrlEntity m4071a(SymbolEntity symbolEntity) {
        String m4086c = TweetUtils.m4086c(symbolEntity.text);
        int start = symbolEntity.getStart();
        int end = symbolEntity.getEnd();
        return new FormattedUrlEntity(start, end, "$" + symbolEntity.text, m4086c, m4086c);
    }
}
