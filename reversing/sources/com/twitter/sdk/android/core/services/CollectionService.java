package com.twitter.sdk.android.core.services;

import retrofit2.InterfaceC3169b;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface CollectionService {
    @GET(m122a = "/1.1/collections/entries.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<Object> collection(@Query(m106a = "id") String str, @Query(m106a = "count") Integer num, @Query(m106a = "max_position") Long l, @Query(m106a = "min_position") Long l2);
}
