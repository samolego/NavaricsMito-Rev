package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.User;
import retrofit2.InterfaceC3169b;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface AccountService {
    @GET(m122a = "/1.1/account/verify_credentials.json")
    InterfaceC3169b<User> verifyCredentials(@Query(m106a = "include_entities") Boolean bool, @Query(m106a = "skip_status") Boolean bool2, @Query(m106a = "include_email") Boolean bool3);
}
