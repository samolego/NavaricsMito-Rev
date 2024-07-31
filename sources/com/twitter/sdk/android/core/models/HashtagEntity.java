package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class HashtagEntity extends Entity {
    @SerializedName("text")
    public final String text;

    @Override // com.twitter.sdk.android.core.models.Entity
    public /* bridge */ /* synthetic */ int getEnd() {
        return super.getEnd();
    }

    @Override // com.twitter.sdk.android.core.models.Entity
    public /* bridge */ /* synthetic */ int getStart() {
        return super.getStart();
    }

    public HashtagEntity(String str, int i, int i2) {
        super(i, i2);
        this.text = str;
    }
}
