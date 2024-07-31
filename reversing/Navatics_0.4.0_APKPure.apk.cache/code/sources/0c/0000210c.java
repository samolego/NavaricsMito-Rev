package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class TwitterAuthConfig implements Parcelable {
    public static final Parcelable.Creator<TwitterAuthConfig> CREATOR = new Parcelable.Creator<TwitterAuthConfig>() { // from class: com.twitter.sdk.android.core.TwitterAuthConfig.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TwitterAuthConfig createFromParcel(Parcel parcel) {
            return new TwitterAuthConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TwitterAuthConfig[] newArray(int i) {
            return new TwitterAuthConfig[i];
        }
    };

    /* renamed from: a */
    private final String f8472a;

    /* renamed from: b */
    private final String f8473b;

    /* renamed from: c */
    public int m8272c() {
        return 140;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TwitterAuthConfig(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
        }
        this.f8472a = m8269a(str);
        this.f8473b = m8269a(str2);
    }

    private TwitterAuthConfig(Parcel parcel) {
        this.f8472a = parcel.readString();
        this.f8473b = parcel.readString();
    }

    /* renamed from: a */
    public String m8270a() {
        return this.f8472a;
    }

    /* renamed from: b */
    public String m8271b() {
        return this.f8473b;
    }

    /* renamed from: a */
    static String m8269a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8472a);
        parcel.writeString(this.f8473b);
    }
}