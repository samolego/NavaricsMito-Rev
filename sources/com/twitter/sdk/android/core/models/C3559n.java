package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.models.n */
/* loaded from: classes2.dex */
public class Tweet implements Identifiable {
    @SerializedName(alternate = {"full_text"}, value = "text")

    /* renamed from: A */
    public final String f8723A;
    @SerializedName("display_text_range")

    /* renamed from: B */
    public final List<Integer> f8724B;
    @SerializedName("truncated")

    /* renamed from: C */
    public final boolean f8725C;
    @SerializedName("user")

    /* renamed from: D */
    public final User f8726D;
    @SerializedName("withheld_copyright")

    /* renamed from: E */
    public final boolean f8727E;
    @SerializedName("withheld_in_countries")

    /* renamed from: F */
    public final List<String> f8728F;
    @SerializedName("withheld_scope")

    /* renamed from: G */
    public final String f8729G;
    @SerializedName("card")

    /* renamed from: H */
    public final Card f8730H;
    @SerializedName("coordinates")

    /* renamed from: a */
    public final Coordinates f8731a;
    @SerializedName("created_at")

    /* renamed from: b */
    public final String f8732b;
    @SerializedName("current_user_retweet")

    /* renamed from: c */
    public final Object f8733c;
    @SerializedName("entities")

    /* renamed from: d */
    public final TweetEntities f8734d;
    @SerializedName("extended_entities")

    /* renamed from: e */
    public final TweetEntities f8735e;
    @SerializedName("favorite_count")

    /* renamed from: f */
    public final Integer f8736f;
    @SerializedName("favorited")

    /* renamed from: g */
    public final boolean f8737g;
    @SerializedName("filter_level")

    /* renamed from: h */
    public final String f8738h;
    @SerializedName("id")

    /* renamed from: i */
    public final long f8739i;
    @SerializedName("id_str")

    /* renamed from: j */
    public final String f8740j;
    @SerializedName("in_reply_to_screen_name")

    /* renamed from: k */
    public final String f8741k;
    @SerializedName("in_reply_to_status_id")

    /* renamed from: l */
    public final long f8742l;
    @SerializedName("in_reply_to_status_id_str")

    /* renamed from: m */
    public final String f8743m;
    @SerializedName("in_reply_to_user_id")

    /* renamed from: n */
    public final long f8744n;
    @SerializedName("in_reply_to_user_id_str")

    /* renamed from: o */
    public final String f8745o;
    @SerializedName("lang")

    /* renamed from: p */
    public final String f8746p;
    @SerializedName("place")

    /* renamed from: q */
    public final Place f8747q;
    @SerializedName("possibly_sensitive")

    /* renamed from: r */
    public final boolean f8748r;
    @SerializedName("scopes")

    /* renamed from: s */
    public final Object f8749s;
    @SerializedName("quoted_status_id")

    /* renamed from: t */
    public final long f8750t;
    @SerializedName("quoted_status_id_str")

    /* renamed from: u */
    public final String f8751u;
    @SerializedName("quoted_status")

    /* renamed from: v */
    public final Tweet f8752v;
    @SerializedName("retweet_count")

    /* renamed from: w */
    public final int f8753w;
    @SerializedName("retweeted")

    /* renamed from: x */
    public final boolean f8754x;
    @SerializedName("retweeted_status")

    /* renamed from: y */
    public final Tweet f8755y;
    @SerializedName("source")

    /* renamed from: z */
    public final String f8756z;

    private Tweet() {
        this(null, null, null, TweetEntities.f8791a, TweetEntities.f8791a, 0, false, null, 0L, "0", null, 0L, "0", 0L, "0", null, null, false, null, 0L, "0", null, 0, false, null, null, null, null, false, null, false, null, null, null);
    }

    public Tweet(Coordinates coordinates, String str, Object obj, TweetEntities tweetEntities, TweetEntities tweetEntities2, Integer num, boolean z, String str2, long j, String str3, String str4, long j2, String str5, long j3, String str6, String str7, Place place, boolean z2, Object obj2, long j4, String str8, Tweet tweet, int i, boolean z3, Tweet tweet2, String str9, String str10, List<Integer> list, boolean z4, User user, boolean z5, List<String> list2, String str11, Card card) {
        this.f8731a = coordinates;
        this.f8732b = str;
        this.f8733c = obj;
        this.f8734d = tweetEntities == null ? TweetEntities.f8791a : tweetEntities;
        this.f8735e = tweetEntities2 == null ? TweetEntities.f8791a : tweetEntities2;
        this.f8736f = num;
        this.f8737g = z;
        this.f8738h = str2;
        this.f8739i = j;
        this.f8740j = str3;
        this.f8741k = str4;
        this.f8742l = j2;
        this.f8743m = str5;
        this.f8744n = j3;
        this.f8745o = str6;
        this.f8746p = str7;
        this.f8747q = place;
        this.f8748r = z2;
        this.f8749s = obj2;
        this.f8750t = j4;
        this.f8751u = str8;
        this.f8752v = tweet;
        this.f8753w = i;
        this.f8754x = z3;
        this.f8755y = tweet2;
        this.f8756z = str9;
        this.f8723A = str10;
        this.f8724B = ModelUtils.m4248a(list);
        this.f8725C = z4;
        this.f8726D = user;
        this.f8727E = z5;
        this.f8728F = ModelUtils.m4248a(list2);
        this.f8729G = str11;
        this.f8730H = card;
    }

    /* renamed from: a */
    public long m4247a() {
        return this.f8739i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Tweet) && this.f8739i == ((Tweet) obj).f8739i;
    }

    public int hashCode() {
        return (int) this.f8739i;
    }
}
