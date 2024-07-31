package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.List;
import retrofit2.InterfaceC3169b;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface ListService {
    @GET(m122a = "/1.1/lists/statuses.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    InterfaceC3169b<List<Tweet>> statuses(@Query(m106a = "list_id") Long l, @Query(m106a = "slug") String str, @Query(m106a = "owner_screen_name") String str2, @Query(m106a = "owner_id") Long l2, @Query(m106a = "since_id") Long l3, @Query(m106a = "max_id") Long l4, @Query(m106a = "count") Integer num, @Query(m106a = "include_entities") Boolean bool, @Query(m106a = "include_rts") Boolean bool2);
}
