package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.p078a.OkHttpClientHelper;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.p153a.p154a.GsonConverterFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.twitter.sdk.android.core.internal.oauth.d */
/* loaded from: classes2.dex */
public abstract class OAuthService {

    /* renamed from: a */
    private final TwitterCore f8563a;

    /* renamed from: b */
    private final TwitterApi f8564b;

    /* renamed from: c */
    private final String f8565c;

    /* renamed from: d */
    private final Retrofit f8566d = new Retrofit.C3206a().m52a(m4384d().m4426a()).m48a(new OkHttpClient.C2991a().m2366a(new Interceptor() { // from class: com.twitter.sdk.android.core.internal.oauth.d.1
        @Override // okhttp3.Interceptor
        /* renamed from: a */
        public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
            return interfaceC2987a.mo2427a(interfaceC2987a.mo2428a().m2345e().m2340a("User-Agent", OAuthService.this.m4383e()).m2342a());
        }
    }).m2367a(OkHttpClientHelper.m4493a()).m2372a()).m46a(GsonConverterFactory.m169a()).m53a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public OAuthService(TwitterCore twitterCore, TwitterApi twitterApi) {
        this.f8563a = twitterCore;
        this.f8564b = twitterApi;
        this.f8565c = TwitterApi.m4424a("TwitterAndroidSDK", twitterCore.m4228b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public TwitterCore m4385c() {
        return this.f8563a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public TwitterApi m4384d() {
        return this.f8564b;
    }

    /* renamed from: e */
    protected String m4383e() {
        return this.f8565c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public Retrofit m4382f() {
        return this.f8566d;
    }
}
