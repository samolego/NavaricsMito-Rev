package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class TwitterAuthToken extends AuthToken implements Parcelable {
    public static final Parcelable.Creator<TwitterAuthToken> CREATOR = new Parcelable.Creator<TwitterAuthToken>() { // from class: com.twitter.sdk.android.core.TwitterAuthToken.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TwitterAuthToken createFromParcel(Parcel parcel) {
            return new TwitterAuthToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TwitterAuthToken[] newArray(int i) {
            return new TwitterAuthToken[i];
        }
    };
    @SerializedName("token")

    /* renamed from: b */
    public final String f8434b;
    @SerializedName("secret")

    /* renamed from: c */
    public final String f8435c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TwitterAuthToken(String str, String str2) {
        this.f8434b = str;
        this.f8435c = str2;
    }

    private TwitterAuthToken(Parcel parcel) {
        this.f8434b = parcel.readString();
        this.f8435c = parcel.readString();
    }

    public String toString() {
        return "token=" + this.f8434b + ",secret=" + this.f8435c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8434b);
        parcel.writeString(this.f8435c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TwitterAuthToken) {
            TwitterAuthToken twitterAuthToken = (TwitterAuthToken) obj;
            String str = this.f8435c;
            if (str == null ? twitterAuthToken.f8435c == null : str.equals(twitterAuthToken.f8435c)) {
                String str2 = this.f8434b;
                return str2 == null ? twitterAuthToken.f8434b == null : str2.equals(twitterAuthToken.f8434b);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8434b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8435c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
