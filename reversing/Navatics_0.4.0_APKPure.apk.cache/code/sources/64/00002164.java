package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.TwitterAuthToken;

/* loaded from: classes2.dex */
public class OAuthResponse implements Parcelable {
    public static final Parcelable.Creator<OAuthResponse> CREATOR = new Parcelable.Creator<OAuthResponse>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuthResponse.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OAuthResponse createFromParcel(Parcel parcel) {
            return new OAuthResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OAuthResponse[] newArray(int i) {
            return new OAuthResponse[i];
        }
    };

    /* renamed from: a */
    public final TwitterAuthToken f8592a;

    /* renamed from: b */
    public final String f8593b;

    /* renamed from: c */
    public final long f8594c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OAuthResponse(TwitterAuthToken twitterAuthToken, String str, long j) {
        this.f8592a = twitterAuthToken;
        this.f8593b = str;
        this.f8594c = j;
    }

    private OAuthResponse(Parcel parcel) {
        this.f8592a = (TwitterAuthToken) parcel.readParcelable(TwitterAuthToken.class.getClassLoader());
        this.f8593b = parcel.readString();
        this.f8594c = parcel.readLong();
    }

    public String toString() {
        return "authToken=" + this.f8592a + ",userName=" + this.f8593b + ",userId=" + this.f8594c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8592a, i);
        parcel.writeString(this.f8593b);
        parcel.writeLong(this.f8594c);
    }
}