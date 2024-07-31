package com.twitter.sdk.android.core.services;

import retrofit2.InterfaceC3169b;
import retrofit2.http.GET;

/* loaded from: classes2.dex */
public interface ConfigurationService {
    @GET(m122a = "/1.1/help/configuration.json")
    InterfaceC3169b<Object> configuration();
}
