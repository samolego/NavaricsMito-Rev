package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class TwitterAuthToken extends AbstractC2507a implements Parcelable {
    public static final Parcelable.Creator<TwitterAuthToken> CREATOR = new Parcelable.Creator<TwitterAuthToken>() { // from class: com.twitter.sdk.android.core.TwitterAuthToken.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TwitterAuthToken createFromParcel(Parcel parcel) {
            return new TwitterAuthToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TwitterAuthToken[] newArray(int i) {
            return new TwitterAuthToken[i];
        }
    };

    /* renamed from: b */
    @SerializedName("token")
    public final String f8474b;

    /* renamed from: c */
    @SerializedName("secret")
    public final String f8475c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TwitterAuthToken(String str, String str2) {
        this.f8474b = str;
        this.f8475c = str2;
    }

    private TwitterAuthToken(Parcel parcel) {
        this.f8474b = parcel.readString();
        this.f8475c = parcel.readString();
    }

    public String toString() {
        return "token=" + this.f8474b + ",secret=" + this.f8475c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8474b);
        parcel.writeString(this.f8475c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterAuthToken)) {
            return false;
        }
        TwitterAuthToken twitterAuthToken = (TwitterAuthToken) obj;
        String str = this.f8475c;
        if (str == null ? twitterAuthToken.f8475c != null : !str.equals(twitterAuthToken.f8475c)) {
            return false;
        }
        String str2 = this.f8474b;
        return str2 == null ? twitterAuthToken.f8474b == null : str2.equals(twitterAuthToken.f8474b);
    }

    public int hashCode() {
        String str = this.f8474b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8475c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}