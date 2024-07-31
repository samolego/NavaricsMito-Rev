package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import retrofit2.InterfaceC3169b;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface StatusesService {
    @FormUrlEncoded
    @POST(m113a = "/1.1/statuses/destroy/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> destroy(@Path(m108a = "id") Long l, @Field(m125a = "trim_user") Boolean bool);

    @GET(m122a = "/1.1/statuses/home_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> homeTimeline(@Query(m106a = "count") Integer num, @Query(m106a = "since_id") Long l, @Query(m106a = "max_id") Long l2, @Query(m106a = "trim_user") Boolean bool, @Query(m106a = "exclude_replies") Boolean bool2, @Query(m106a = "contributor_details") Boolean bool3, @Query(m106a = "include_entities") Boolean bool4);

    @GET(m122a = "/1.1/statuses/lookup.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> lookup(@Query(m106a = "id") String str, @Query(m106a = "include_entities") Boolean bool, @Query(m106a = "trim_user") Boolean bool2, @Query(m106a = "map") Boolean bool3);

    @GET(m122a = "/1.1/statuses/mentions_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> mentionsTimeline(@Query(m106a = "count") Integer num, @Query(m106a = "since_id") Long l, @Query(m106a = "max_id") Long l2, @Query(m106a = "trim_user") Boolean bool, @Query(m106a = "contributor_details") Boolean bool2, @Query(m106a = "include_entities") Boolean bool3);

    @FormUrlEncoded
    @POST(m113a = "/1.1/statuses/retweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> retweet(@Path(m108a = "id") Long l, @Field(m125a = "trim_user") Boolean bool);

    @GET(m122a = "/1.1/statuses/retweets_of_me.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> retweetsOfMe(@Query(m106a = "count") Integer num, @Query(m106a = "since_id") Long l, @Query(m106a = "max_id") Long l2, @Query(m106a = "trim_user") Boolean bool, @Query(m106a = "include_entities") Boolean bool2, @Query(m106a = "include_user_entities") Boolean bool3);

    @GET(m122a = "/1.1/statuses/show.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> show(@Query(m106a = "id") Long l, @Query(m106a = "trim_user") Boolean bool, @Query(m106a = "include_my_retweet") Boolean bool2, @Query(m106a = "include_entities") Boolean bool3);

    @FormUrlEncoded
    @POST(m113a = "/1.1/statuses/unretweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> unretweet(@Path(m108a = "id") Long l, @Field(m125a = "trim_user") Boolean bool);

    @FormUrlEncoded
    @POST(m113a = "/1.1/statuses/update.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> update(@Field(m125a = "status") String str, @Field(m125a = "in_reply_to_status_id") Long l, @Field(m125a = "possibly_sensitive") Boolean bool, @Field(m125a = "lat") Double d, @Field(m125a = "long") Double d2, @Field(m125a = "place_id") String str2, @Field(m125a = "display_coordinates") Boolean bool2, @Field(m125a = "trim_user") Boolean bool3, @Field(m125a = "media_ids") String str3);

    @GET(m122a = "/1.1/statuses/user_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> userTimeline(@Query(m106a = "user_id") Long l, @Query(m106a = "screen_name") String str, @Query(m106a = "count") Integer num, @Query(m106a = "since_id") Long l2, @Query(m106a = "max_id") Long l3, @Query(m106a = "trim_user") Boolean bool, @Query(m106a = "exclude_replies") Boolean bool2, @Query(m106a = "contributor_details") Boolean bool3, @Query(m106a = "include_rts") Boolean bool4);
}
