package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.models.p */
/* loaded from: classes2.dex */
public class TweetEntities {

    /* renamed from: a */
    static final TweetEntities f8791a = new TweetEntities(null, null, null, null, null);
    @SerializedName("urls")

    /* renamed from: b */
    public final List<UrlEntity> f8792b;
    @SerializedName("user_mentions")

    /* renamed from: c */
    public final List<MentionEntity> f8793c;
    @SerializedName("media")

    /* renamed from: d */
    public final List<MediaEntity> f8794d;
    @SerializedName("hashtags")

    /* renamed from: e */
    public final List<HashtagEntity> f8795e;
    @SerializedName("symbols")

    /* renamed from: f */
    public final List<SymbolEntity> f8796f;

    private TweetEntities() {
        this(null, null, null, null, null);
    }

    public TweetEntities(List<UrlEntity> list, List<MentionEntity> list2, List<MediaEntity> list3, List<HashtagEntity> list4, List<SymbolEntity> list5) {
        this.f8792b = ModelUtils.m4248a(list);
        this.f8793c = ModelUtils.m4248a(list2);
        this.f8794d = ModelUtils.m4248a(list3);
        this.f8795e = ModelUtils.m4248a(list4);
        this.f8796f = ModelUtils.m4248a(list5);
    }
}
