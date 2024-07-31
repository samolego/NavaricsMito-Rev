package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import retrofit2.InterfaceC3169b;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface FavoriteService {
    @FormUrlEncoded
    @POST(m113a = "/1.1/favorites/create.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> create(@Field(m125a = "id") Long l, @Field(m125a = "include_entities") Boolean bool);

    @FormUrlEncoded
    @POST(m113a = "/1.1/favorites/destroy.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Tweet> destroy(@Field(m125a = "id") Long l, @Field(m125a = "include_entities") Boolean bool);

    @GET(m122a = "/1.1/favorites/list.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> list(@Query(m106a = "user_id") Long l, @Query(m106a = "screen_name") String str, @Query(m106a = "count") Integer num, @Query(m106a = "since_id") String str2, @Query(m106a = "max_id") String str3, @Query(m106a = "include_entities") Boolean bool);
}
