package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class TwitterAuthConfig implements Parcelable {
    public static final Parcelable.Creator<TwitterAuthConfig> CREATOR = new Parcelable.Creator<TwitterAuthConfig>() { // from class: com.twitter.sdk.android.core.TwitterAuthConfig.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TwitterAuthConfig createFromParcel(Parcel parcel) {
            return new TwitterAuthConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TwitterAuthConfig[] newArray(int i) {
            return new TwitterAuthConfig[i];
        }
    };

    /* renamed from: a */
    private final String f8432a;

    /* renamed from: b */
    private final String f8433b;

    /* renamed from: c */
    public int m4581c() {
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
        this.f8432a = m4583a(str);
        this.f8433b = m4583a(str2);
    }

    private TwitterAuthConfig(Parcel parcel) {
        this.f8432a = parcel.readString();
        this.f8433b = parcel.readString();
    }

    /* renamed from: a */
    public String m4584a() {
        return this.f8432a;
    }

    /* renamed from: b */
    public String m4582b() {
        return this.f8433b;
    }

    /* renamed from: a */
    static String m4583a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8432a);
        parcel.writeString(this.f8433b);
    }
}
