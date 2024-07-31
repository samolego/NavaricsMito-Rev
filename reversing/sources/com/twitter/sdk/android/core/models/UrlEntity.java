package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UrlEntity extends Entity {
    @SerializedName("display_url")
    public final String displayUrl;
    @SerializedName("expanded_url")
    public final String expandedUrl;
    @SerializedName("url")
    public final String url;

    @Override // com.twitter.sdk.android.core.models.Entity
    public /* bridge */ /* synthetic */ int getEnd() {
        return super.getEnd();
    }

    @Override // com.twitter.sdk.android.core.models.Entity
    public /* bridge */ /* synthetic */ int getStart() {
        return super.getStart();
    }

    public UrlEntity(String str, String str2, String str3, int i, int i2) {
        super(i, i2);
        this.url = str;
        this.expandedUrl = str2;
        this.displayUrl = str3;
    }
}
