package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.services.params.Geocode;
import retrofit2.InterfaceC3169b;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface SearchService {
    @GET(m122a = "/1.1/search/tweets.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Object> tweets(@Query(m106a = "q") String str, @Query(m106a = "geocode", m105b = true) Geocode geocode, @Query(m106a = "lang") String str2, @Query(m106a = "locale") String str3, @Query(m106a = "result_type") String str4, @Query(m106a = "count") Integer num, @Query(m106a = "until") String str5, @Query(m106a = "since_id") Long l, @Query(m106a = "max_id") Long l2, @Query(m106a = "include_entities") Boolean bool);
}
