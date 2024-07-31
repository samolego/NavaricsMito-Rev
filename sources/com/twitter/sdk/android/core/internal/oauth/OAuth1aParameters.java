package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.p078a.UrlUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.c */
/* loaded from: classes2.dex */
class OAuth1aParameters {

    /* renamed from: a */
    private static final SecureRandom f8556a = new SecureRandom();

    /* renamed from: b */
    private final TwitterAuthConfig f8557b;

    /* renamed from: c */
    private final TwitterAuthToken f8558c;

    /* renamed from: d */
    private final String f8559d;

    /* renamed from: e */
    private final String f8560e;

    /* renamed from: f */
    private final String f8561f;

    /* renamed from: g */
    private final Map<String, String> f8562g;

    public OAuth1aParameters(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        this.f8557b = twitterAuthConfig;
        this.f8558c = twitterAuthToken;
        this.f8559d = str;
        this.f8560e = str2;
        this.f8561f = str3;
        this.f8562g = map;
    }

    /* renamed from: a */
    public String m4394a() {
        String m4388b = m4388b();
        String m4387c = m4387c();
        return m4391a(m4388b, m4387c, m4393a(m4392a(m4388b, m4387c)));
    }

    /* renamed from: b */
    private String m4388b() {
        return String.valueOf(System.nanoTime()) + String.valueOf(Math.abs(f8556a.nextLong()));
    }

    /* renamed from: c */
    private String m4387c() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /* renamed from: a */
    String m4392a(String str, String str2) {
        URI create;
        TreeMap<String, String> m4486a = UrlUtils.m4486a(URI.create(this.f8561f), true);
        Map<String, String> map = this.f8562g;
        if (map != null) {
            m4486a.putAll(map);
        }
        String str3 = this.f8559d;
        if (str3 != null) {
            m4486a.put("oauth_callback", str3);
        }
        m4486a.put("oauth_consumer_key", this.f8557b.m4584a());
        m4486a.put("oauth_nonce", str);
        m4486a.put("oauth_signature_method", "HMAC-SHA1");
        m4486a.put("oauth_timestamp", str2);
        TwitterAuthToken twitterAuthToken = this.f8558c;
        if (twitterAuthToken != null && twitterAuthToken.f8434b != null) {
            m4486a.put("oauth_token", this.f8558c.f8434b);
        }
        m4486a.put("oauth_version", "1.0");
        String str4 = create.getScheme() + "://" + create.getHost() + create.getPath();
        return this.f8560e.toUpperCase(Locale.ENGLISH) + '&' + UrlUtils.m4484c(str4) + '&' + m4389a(m4486a);
    }

    /* renamed from: a */
    private String m4389a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        int size = treeMap.size();
        int i = 0;
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(UrlUtils.m4484c(UrlUtils.m4484c(entry.getKey())));
            sb.append("%3D");
            sb.append(UrlUtils.m4484c(UrlUtils.m4484c(entry.getValue())));
            i++;
            if (i < size) {
                sb.append("%26");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    String m4393a(String str) {
        try {
            String m4386d = m4386d();
            byte[] bytes = str.getBytes("UTF8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(m4386d.getBytes("UTF8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            byte[] doFinal = mac.doFinal(bytes);
            return ByteString.m2329of(doFinal, 0, doFinal.length).base64();
        } catch (UnsupportedEncodingException e) {
            Twitter.m4253h().mo4556c("Twitter", "Failed to calculate signature", e);
            return "";
        } catch (InvalidKeyException e2) {
            Twitter.m4253h().mo4556c("Twitter", "Failed to calculate signature", e2);
            return "";
        } catch (NoSuchAlgorithmException e3) {
            Twitter.m4253h().mo4556c("Twitter", "Failed to calculate signature", e3);
            return "";
        }
    }

    /* renamed from: d */
    private String m4386d() {
        TwitterAuthToken twitterAuthToken = this.f8558c;
        String str = twitterAuthToken != null ? twitterAuthToken.f8435c : null;
        return UrlUtils.m4488a(this.f8557b.m4582b()) + '&' + UrlUtils.m4488a(str);
    }

    /* renamed from: a */
    String m4391a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("OAuth");
        m4390a(sb, "oauth_callback", this.f8559d);
        m4390a(sb, "oauth_consumer_key", this.f8557b.m4584a());
        m4390a(sb, "oauth_nonce", str);
        m4390a(sb, "oauth_signature", str3);
        m4390a(sb, "oauth_signature_method", "HMAC-SHA1");
        m4390a(sb, "oauth_timestamp", str2);
        TwitterAuthToken twitterAuthToken = this.f8558c;
        m4390a(sb, "oauth_token", twitterAuthToken != null ? twitterAuthToken.f8434b : null);
        m4390a(sb, "oauth_version", "1.0");
        return sb.substring(0, sb.length() - 1);
    }

    /* renamed from: a */
    private void m4390a(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(UrlUtils.m4484c(str));
            sb.append("=\"");
            sb.append(UrlUtils.m4484c(str2));
            sb.append("\",");
        }
    }
}
