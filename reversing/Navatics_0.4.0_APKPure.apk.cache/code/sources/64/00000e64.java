package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new Parcelable.Creator<AppGroupCreationContent>() { // from class: com.facebook.share.model.AppGroupCreationContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppGroupCreationContent createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    };

    /* renamed from: a */
    private final String f2417a;

    /* renamed from: b */
    private final String f2418b;

    /* renamed from: c */
    private AppGroupPrivacy f2419c;

    /* loaded from: classes.dex */
    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AppGroupCreationContent(Parcel parcel) {
        this.f2417a = parcel.readString();
        this.f2418b = parcel.readString();
        this.f2419c = (AppGroupPrivacy) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2417a);
        parcel.writeString(this.f2418b);
        parcel.writeSerializable(this.f2419c);
    }
}