package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.models.ApiError;
import com.twitter.sdk.android.core.models.ApiErrors;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import retrofit2.C3204l;

/* loaded from: classes2.dex */
public class TwitterApiException extends TwitterException {
    public static final int DEFAULT_ERROR_CODE = 0;
    private final ApiError apiError;
    private final int code;
    private final C3204l response;
    private final TwitterRateLimit twitterRateLimit;

    public TwitterApiException(C3204l c3204l) {
        this(c3204l, readApiError(c3204l), readApiRateLimit(c3204l), c3204l.m73a());
    }

    TwitterApiException(C3204l c3204l, ApiError apiError, TwitterRateLimit twitterRateLimit, int i) {
        super(createExceptionMessage(i));
        this.apiError = apiError;
        this.twitterRateLimit = twitterRateLimit;
        this.code = i;
        this.response = c3204l;
    }

    public int getStatusCode() {
        return this.code;
    }

    public int getErrorCode() {
        ApiError apiError = this.apiError;
        if (apiError == null) {
            return 0;
        }
        return apiError.f8707b;
    }

    public String getErrorMessage() {
        ApiError apiError = this.apiError;
        if (apiError == null) {
            return null;
        }
        return apiError.f8706a;
    }

    public TwitterRateLimit getTwitterRateLimit() {
        return this.twitterRateLimit;
    }

    public C3204l getResponse() {
        return this.response;
    }

    public static TwitterRateLimit readApiRateLimit(C3204l c3204l) {
        return new TwitterRateLimit(c3204l.m69c());
    }

    public static ApiError readApiError(C3204l c3204l) {
        try {
            String m2285p = c3204l.m66f().mo127d().mo2238c().clone().m2285p();
            if (TextUtils.isEmpty(m2285p)) {
                return null;
            }
            return parseApiError(m2285p);
        } catch (Exception e) {
            Twitter.m4253h().mo4556c("Twitter", "Unexpected response", e);
            return null;
        }
    }

    static ApiError parseApiError(String str) {
        try {
            ApiErrors apiErrors = (ApiErrors) new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).create().fromJson(str, (Class<Object>) ApiErrors.class);
            if (apiErrors.f8708a.isEmpty()) {
                return null;
            }
            return apiErrors.f8708a.get(0);
        } catch (JsonSyntaxException e) {
            InterfaceC2645h m4253h = Twitter.m4253h();
            m4253h.mo4556c("Twitter", "Invalid json: " + str, e);
            return null;
        }
    }

    static String createExceptionMessage(int i) {
        return "HTTP request failed, Status: " + i;
    }
}
