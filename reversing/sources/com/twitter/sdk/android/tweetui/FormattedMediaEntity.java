package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.MediaEntity;

/* renamed from: com.twitter.sdk.android.tweetui.d */
/* loaded from: classes2.dex */
class FormattedMediaEntity extends FormattedUrlEntity {

    /* renamed from: a */
    final String f8953a;

    /* renamed from: b */
    final String f8954b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormattedMediaEntity(MediaEntity mediaEntity) {
        super(mediaEntity.getStart(), mediaEntity.getEnd(), mediaEntity.displayUrl, mediaEntity.url, mediaEntity.expandedUrl);
        this.f8953a = mediaEntity.type;
        this.f8954b = mediaEntity.mediaUrlHttps;
    }
}
