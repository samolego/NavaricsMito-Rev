package com.twitter.sdk.android.core.internal.oauth;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class GuestAuthToken extends OAuth2Token {
    @SerializedName("guest_token")

    /* renamed from: b */
    private final String f8541b;

    public GuestAuthToken(String str, String str2, String str3) {
        super(str, str2);
        this.f8541b = str3;
    }

    /* renamed from: a */
    public String m4417a() {
        return this.f8541b;
    }

    @Override // com.twitter.sdk.android.core.internal.oauth.OAuth2Token
    /* renamed from: b */
    public boolean mo4403b() {
        return System.currentTimeMillis() >= this.f8436a + 10800000;
    }

    @Override // com.twitter.sdk.android.core.internal.oauth.OAuth2Token
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            GuestAuthToken guestAuthToken = (GuestAuthToken) obj;
            String str = this.f8541b;
            return str == null ? guestAuthToken.f8541b == null : str.equals(guestAuthToken.f8541b);
        }
        return false;
    }

    @Override // com.twitter.sdk.android.core.internal.oauth.OAuth2Token
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f8541b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
