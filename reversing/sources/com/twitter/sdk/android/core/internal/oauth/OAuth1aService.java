package com.twitter.sdk.android.core.internal.oauth;

import android.net.Uri;
import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.p078a.UrlUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import okhttp3.ResponseBody;
import retrofit2.InterfaceC3169b;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public class OAuth1aService extends OAuthService {

    /* renamed from: a */
    OAuthApi f8542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OAuthApi {
        @POST(m113a = "/oauth/access_token")
        InterfaceC3169b<ResponseBody> getAccessToken(@Header(m117a = "Authorization") String str, @Query(m106a = "oauth_verifier") String str2);

        @POST(m113a = "/oauth/request_token")
        InterfaceC3169b<ResponseBody> getTempToken(@Header(m117a = "Authorization") String str);
    }

    public OAuth1aService(TwitterCore twitterCore, TwitterApi twitterApi) {
        super(twitterCore, twitterApi);
        this.f8542a = (OAuthApi) m4382f().m64a(OAuthApi.class);
    }

    /* renamed from: a */
    public void m4413a(AbstractC2641c<OAuthResponse> abstractC2641c) {
        TwitterAuthConfig m4227c = m4385c().m4227c();
        this.f8542a.getTempToken(new OAuth1aHeaders().m4396a(m4227c, null, m4415a(m4227c), "POST", m4416a(), null)).mo140a(m4409b(abstractC2641c));
    }

    /* renamed from: a */
    String m4416a() {
        return m4384d().m4426a() + "/oauth/request_token";
    }

    /* renamed from: a */
    public String m4415a(TwitterAuthConfig twitterAuthConfig) {
        return Uri.parse("twittersdk://callback").buildUpon().appendQueryParameter("version", m4385c().m4228b()).appendQueryParameter("app", twitterAuthConfig.m4584a()).build().toString();
    }

    /* renamed from: a */
    public void m4412a(AbstractC2641c<OAuthResponse> abstractC2641c, TwitterAuthToken twitterAuthToken, String str) {
        this.f8542a.getAccessToken(new OAuth1aHeaders().m4396a(m4385c().m4227c(), twitterAuthToken, null, "POST", m4410b(), null), str).mo140a(m4409b(abstractC2641c));
    }

    /* renamed from: b */
    String m4410b() {
        return m4384d().m4426a() + "/oauth/access_token";
    }

    /* renamed from: a */
    public String m4414a(TwitterAuthToken twitterAuthToken) {
        return m4384d().m4423a("oauth", "authorize").appendQueryParameter("oauth_token", twitterAuthToken.f8434b).build().toString();
    }

    /* renamed from: a */
    public static OAuthResponse m4411a(String str) {
        TreeMap<String, String> m4487a = UrlUtils.m4487a(str, false);
        String str2 = m4487a.get("oauth_token");
        String str3 = m4487a.get("oauth_token_secret");
        String str4 = m4487a.get("screen_name");
        long parseLong = m4487a.containsKey("user_id") ? Long.parseLong(m4487a.get("user_id")) : 0L;
        if (str2 == null || str3 == null) {
            return null;
        }
        return new OAuthResponse(new TwitterAuthToken(str2, str3), str4, parseLong);
    }

    /* renamed from: b */
    AbstractC2641c<ResponseBody> m4409b(final AbstractC2641c<OAuthResponse> abstractC2641c) {
        return new AbstractC2641c<ResponseBody>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth1aService.1
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<ResponseBody> result) {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(result.f8688a.m3002c()));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                        String sb2 = sb.toString();
                        OAuthResponse m4411a = OAuth1aService.m4411a(sb2);
                        if (m4411a == null) {
                            AbstractC2641c abstractC2641c2 = abstractC2641c;
                            abstractC2641c2.mo3868a(new TwitterAuthException("Failed to parse auth response: " + sb2));
                            return;
                        }
                        abstractC2641c.mo3867a(new Result(m4411a, null));
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e) {
                    abstractC2641c.mo3868a(new TwitterAuthException(e.getMessage(), e));
                }
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                abstractC2641c.mo3868a(twitterException);
            }
        };
    }
}
