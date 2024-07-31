package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

/* loaded from: classes2.dex */
public class OAuth2Token extends AuthToken implements Parcelable {
    public static final Parcelable.Creator<OAuth2Token> CREATOR = new Parcelable.Creator<OAuth2Token>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth2Token.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OAuth2Token createFromParcel(Parcel parcel) {
            return new OAuth2Token(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OAuth2Token[] newArray(int i) {
            return new OAuth2Token[i];
        }
    };
    @SerializedName("token_type")

    /* renamed from: b */
    private final String f8550b;
    @SerializedName("access_token")

    /* renamed from: c */
    private final String f8551c;

    /* renamed from: b */
    public boolean mo4403b() {
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OAuth2Token(String str, String str2) {
        this.f8550b = str;
        this.f8551c = str2;
    }

    private OAuth2Token(Parcel parcel) {
        this.f8550b = parcel.readString();
        this.f8551c = parcel.readString();
    }

    /* renamed from: c */
    public String m4402c() {
        return this.f8550b;
    }

    /* renamed from: d */
    public String m4401d() {
        return this.f8551c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8550b);
        parcel.writeString(this.f8551c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth2Token oAuth2Token = (OAuth2Token) obj;
        String str = this.f8551c;
        if (str == null ? oAuth2Token.f8551c == null : str.equals(oAuth2Token.f8551c)) {
            String str2 = this.f8550b;
            return str2 == null ? oAuth2Token.f8550b == null : str2.equals(oAuth2Token.f8550b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8550b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8551c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
