package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ScribeItem implements Serializable {
    public static final int TYPE_MESSAGE = 6;
    public static final int TYPE_TWEET = 0;
    public static final int TYPE_USER = 3;
    @SerializedName("card_event")
    public final CardEvent cardEvent;
    @SerializedName("description")
    public final String description;
    @SerializedName("id")

    /* renamed from: id */
    public final Long f8585id;
    @SerializedName("item_type")
    public final Integer itemType;
    @SerializedName("media_details")
    public final MediaDetails mediaDetails;

    private ScribeItem(Integer num, Long l, String str, CardEvent cardEvent, MediaDetails mediaDetails) {
        this.itemType = num;
        this.f8585id = l;
        this.description = str;
        this.cardEvent = cardEvent;
        this.mediaDetails = mediaDetails;
    }

    public static ScribeItem fromTweet(Tweet tweet) {
        return new C2677a().m4368a(0).m4367a(tweet.f8739i).m4369a();
    }

    public static ScribeItem fromUser(User user) {
        return new C2677a().m4368a(3).m4367a(user.f8705id).m4369a();
    }

    public static ScribeItem fromMessage(String str) {
        return new C2677a().m4368a(6).m4365a(str).m4369a();
    }

    public static ScribeItem fromTweetCard(long j, Card card) {
        return new C2677a().m4368a(0).m4367a(j).m4366a(createCardDetails(j, card)).m4369a();
    }

    public static ScribeItem fromMediaEntity(long j, MediaEntity mediaEntity) {
        return new C2677a().m4368a(0).m4367a(j).m4366a(createMediaDetails(j, mediaEntity)).m4369a();
    }

    static MediaDetails createMediaDetails(long j, MediaEntity mediaEntity) {
        return new MediaDetails(j, getMediaType(mediaEntity), mediaEntity.f8701id);
    }

    static MediaDetails createCardDetails(long j, Card card) {
        return new MediaDetails(j, 4, Long.valueOf(VineCardUtils.m4380b(card)).longValue());
    }

    static int getMediaType(MediaEntity mediaEntity) {
        return MediaDetails.GIF_TYPE.equals(mediaEntity.type) ? 3 : 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScribeItem scribeItem = (ScribeItem) obj;
        Integer num = this.itemType;
        if (num == null ? scribeItem.itemType == null : num.equals(scribeItem.itemType)) {
            Long l = this.f8585id;
            if (l == null ? scribeItem.f8585id == null : l.equals(scribeItem.f8585id)) {
                String str = this.description;
                if (str == null ? scribeItem.description == null : str.equals(scribeItem.description)) {
                    CardEvent cardEvent = this.cardEvent;
                    if (cardEvent == null ? scribeItem.cardEvent == null : cardEvent.equals(scribeItem.cardEvent)) {
                        MediaDetails mediaDetails = this.mediaDetails;
                        if (mediaDetails != null) {
                            if (mediaDetails.equals(scribeItem.mediaDetails)) {
                                return true;
                            }
                        } else if (scribeItem.mediaDetails == null) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.itemType;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Long l = this.f8585id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.description;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        CardEvent cardEvent = this.cardEvent;
        int hashCode4 = (hashCode3 + (cardEvent != null ? cardEvent.hashCode() : 0)) * 31;
        MediaDetails mediaDetails = this.mediaDetails;
        return hashCode4 + (mediaDetails != null ? mediaDetails.hashCode() : 0);
    }

    /* loaded from: classes2.dex */
    public static class CardEvent implements Serializable {
        @SerializedName("promotion_card_type")
        final int promotionCardType;

        public CardEvent(int i) {
            this.promotionCardType = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.promotionCardType == ((CardEvent) obj).promotionCardType;
        }

        public int hashCode() {
            return this.promotionCardType;
        }
    }

    /* loaded from: classes2.dex */
    public static class MediaDetails implements Serializable {
        public static final String GIF_TYPE = "animated_gif";
        public static final int TYPE_AMPLIFY = 2;
        public static final int TYPE_ANIMATED_GIF = 3;
        public static final int TYPE_CONSUMER = 1;
        public static final int TYPE_VINE = 4;
        @SerializedName("content_id")
        public final long contentId;
        @SerializedName("media_type")
        public final int mediaType;
        @SerializedName("publisher_id")
        public final long publisherId;

        public MediaDetails(long j, int i, long j2) {
            this.contentId = j;
            this.mediaType = i;
            this.publisherId = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MediaDetails mediaDetails = (MediaDetails) obj;
            return this.contentId == mediaDetails.contentId && this.mediaType == mediaDetails.mediaType && this.publisherId == mediaDetails.publisherId;
        }

        public int hashCode() {
            long j = this.contentId;
            long j2 = this.publisherId;
            return (((((int) (j ^ (j >>> 32))) * 31) + this.mediaType) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.ScribeItem$a */
    /* loaded from: classes2.dex */
    public static class C2677a {

        /* renamed from: a */
        private Integer f8586a;

        /* renamed from: b */
        private Long f8587b;

        /* renamed from: c */
        private String f8588c;

        /* renamed from: d */
        private CardEvent f8589d;

        /* renamed from: e */
        private MediaDetails f8590e;

        /* renamed from: a */
        public C2677a m4368a(int i) {
            this.f8586a = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public C2677a m4367a(long j) {
            this.f8587b = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C2677a m4365a(String str) {
            this.f8588c = str;
            return this;
        }

        /* renamed from: a */
        public C2677a m4366a(MediaDetails mediaDetails) {
            this.f8590e = mediaDetails;
            return this;
        }

        /* renamed from: a */
        public ScribeItem m4369a() {
            return new ScribeItem(this.f8586a, this.f8587b, this.f8588c, this.f8589d, this.f8590e);
        }
    }
}
