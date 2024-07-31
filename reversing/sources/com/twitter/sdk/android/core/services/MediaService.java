package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.models.Media;
import okhttp3.RequestBody;
import retrofit2.InterfaceC3169b;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* loaded from: classes2.dex */
public interface MediaService {
    @POST(m113a = "https://upload.twitter.com/1.1/media/upload.json")
    @Multipart
    InterfaceC3169b<Media> upload(@Part(m111a = "media") RequestBody requestBody, @Part(m111a = "media_data") RequestBody requestBody2, @Part(m111a = "additional_owners") RequestBody requestBody3);
}
