package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.AbstractC2641c;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.p078a.UrlUtils;
import okio.ByteString;
import retrofit2.InterfaceC3169b;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* loaded from: classes2.dex */
public class OAuth2Service extends OAuthService {

    /* renamed from: a */
    OAuth2Api f8545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface OAuth2Api {
        @FormUrlEncoded
        @Headers(m116a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @POST(m113a = "/oauth2/token")
        InterfaceC3169b<OAuth2Token> getAppAuthToken(@Header(m117a = "Authorization") String str, @Field(m125a = "grant_type") String str2);

        @POST(m113a = "/1.1/guest/activate.json")
        InterfaceC3169b<GuestTokenResponse> getGuestToken(@Header(m117a = "Authorization") String str);
    }

    public OAuth2Service(TwitterCore twitterCore, TwitterApi twitterApi) {
        super(twitterCore, twitterApi);
        this.f8545a = (OAuth2Api) m4382f().m64a(OAuth2Api.class);
    }

    /* renamed from: a */
    public void m4407a(final AbstractC2641c<GuestAuthToken> abstractC2641c) {
        m4404b(new AbstractC2641c<OAuth2Token>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth2Service.1
            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3867a(Result<OAuth2Token> result) {
                final OAuth2Token oAuth2Token = result.f8688a;
                OAuth2Service.this.m4406a(new AbstractC2641c<GuestTokenResponse>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth2Service.1.1
                    @Override // com.twitter.sdk.android.core.AbstractC2641c
                    /* renamed from: a */
                    public void mo3867a(Result<GuestTokenResponse> result2) {
                        abstractC2641c.mo3867a(new Result(new GuestAuthToken(oAuth2Token.m4402c(), oAuth2Token.m4401d(), result2.f8688a.f8555a), null));
                    }

                    @Override // com.twitter.sdk.android.core.AbstractC2641c
                    /* renamed from: a */
                    public void mo3868a(TwitterException twitterException) {
                        Twitter.m4253h().mo4556c("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterException);
                        abstractC2641c.mo3868a(twitterException);
                    }
                }, oAuth2Token);
            }

            @Override // com.twitter.sdk.android.core.AbstractC2641c
            /* renamed from: a */
            public void mo3868a(TwitterException twitterException) {
                Twitter.m4253h().mo4556c("Twitter", "Failed to get app auth token", twitterException);
                AbstractC2641c abstractC2641c2 = abstractC2641c;
                if (abstractC2641c2 != null) {
                    abstractC2641c2.mo3868a(twitterException);
                }
            }
        });
    }

    /* renamed from: b */
    void m4404b(AbstractC2641c<OAuth2Token> abstractC2641c) {
        this.f8545a.getAppAuthToken(m4408a(), "client_credentials").mo140a(abstractC2641c);
    }

    /* renamed from: a */
    void m4406a(AbstractC2641c<GuestTokenResponse> abstractC2641c, OAuth2Token oAuth2Token) {
        this.f8545a.getGuestToken(m4405a(oAuth2Token)).mo140a(abstractC2641c);
    }

    /* renamed from: a */
    private String m4405a(OAuth2Token oAuth2Token) {
        return "Bearer " + oAuth2Token.m4401d();
    }

    /* renamed from: a */
    private String m4408a() {
        TwitterAuthConfig m4227c = m4385c().m4227c();
        ByteString encodeUtf8 = ByteString.encodeUtf8(UrlUtils.m4484c(m4227c.m4584a()) + ":" + UrlUtils.m4484c(m4227c.m4582b()));
        return "Basic " + encodeUtf8.base64();
    }
}
