package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.p078a.OkHttpClientHelper;
import com.twitter.sdk.android.core.models.BindingValues;
import com.twitter.sdk.android.core.models.BindingValuesAdapter;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.p153a.p154a.GsonConverterFactory;

/* renamed from: com.twitter.sdk.android.core.n */
/* loaded from: classes2.dex */
public class TwitterApiClient {

    /* renamed from: a */
    final ConcurrentHashMap<Class, Object> f8798a;

    /* renamed from: b */
    final Retrofit f8799b;

    public TwitterApiClient() {
        this(OkHttpClientHelper.m4492a(TwitterCore.m4230a().m4223g()), new TwitterApi());
    }

    public TwitterApiClient(TwitterSession twitterSession) {
        this(OkHttpClientHelper.m4491a(twitterSession, TwitterCore.m4230a().m4227c()), new TwitterApi());
    }

    TwitterApiClient(OkHttpClient okHttpClient, TwitterApi twitterApi) {
        this.f8798a = m4235f();
        this.f8799b = m4240a(okHttpClient, twitterApi);
    }

    /* renamed from: a */
    private Retrofit m4240a(OkHttpClient okHttpClient, TwitterApi twitterApi) {
        return new Retrofit.C3206a().m48a(okHttpClient).m52a(twitterApi.m4426a()).m46a(GsonConverterFactory.m168a(m4236e())).m53a();
    }

    /* renamed from: e */
    private Gson m4236e() {
        return new GsonBuilder().registerTypeAdapterFactory(new SafeListAdapter()).registerTypeAdapterFactory(new SafeMapAdapter()).registerTypeAdapter(BindingValues.class, new BindingValuesAdapter()).create();
    }

    /* renamed from: f */
    private ConcurrentHashMap m4235f() {
        return new ConcurrentHashMap();
    }

    /* renamed from: a */
    public AccountService m4242a() {
        return (AccountService) m4241a(AccountService.class);
    }

    /* renamed from: b */
    public FavoriteService m4239b() {
        return (FavoriteService) m4241a(FavoriteService.class);
    }

    /* renamed from: c */
    public StatusesService m4238c() {
        return (StatusesService) m4241a(StatusesService.class);
    }

    /* renamed from: d */
    public MediaService m4237d() {
        return (MediaService) m4241a(MediaService.class);
    }

    /* renamed from: a */
    protected <T> T m4241a(Class<T> cls) {
        if (!this.f8798a.contains(cls)) {
            this.f8798a.putIfAbsent(cls, this.f8799b.m64a(cls));
        }
        return (T) this.f8798a.get(cls);
    }
}
