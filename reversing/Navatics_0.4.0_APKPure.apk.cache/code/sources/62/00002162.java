package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AbstractC2507a;

/* loaded from: classes2.dex */
public class OAuth2Token extends AbstractC2507a implements Parcelable {
    public static final Parcelable.Creator<OAuth2Token> CREATOR = new Parcelable.Creator<OAuth2Token>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth2Token.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OAuth2Token createFromParcel(Parcel parcel) {
            return new OAuth2Token(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OAuth2Token[] newArray(int i) {
            return new OAuth2Token[i];
        }
    };

    /* renamed from: b */
    @SerializedName("token_type")
    private final String f8590b;

    /* renamed from: c */
    @SerializedName("access_token")
    private final String f8591c;

    /* renamed from: b */
    public boolean mo8445b() {
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OAuth2Token(String str, String str2) {
        this.f8590b = str;
        this.f8591c = str2;
    }

    private OAuth2Token(Parcel parcel) {
        this.f8590b = parcel.readString();
        this.f8591c = parcel.readString();
    }

    /* renamed from: c */
    public String m8459c() {
        return this.f8590b;
    }

    /* renamed from: d */
    public String m8460d() {
        return this.f8591c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8590b);
        parcel.writeString(this.f8591c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuth2Token oAuth2Token = (OAuth2Token) obj;
        String str = this.f8591c;
        if (str == null ? oAuth2Token.f8591c != null : !str.equals(oAuth2Token.f8591c)) {
            return false;
        }
        String str2 = this.f8590b;
        return str2 == null ? oAuth2Token.f8590b == null : str2.equals(oAuth2Token.f8590b);
    }

    public int hashCode() {
        String str = this.f8590b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8591c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}