package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new Parcelable.Creator<AppGroupCreationContent>() { // from class: com.facebook.share.model.AppGroupCreationContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppGroupCreationContent createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    };

    /* renamed from: a */
    private final String f2409a;

    /* renamed from: b */
    private final String f2410b;

    /* renamed from: c */
    private AppGroupPrivacy f2411c;

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
        this.f2409a = parcel.readString();
        this.f2410b = parcel.readString();
        this.f2411c = (AppGroupPrivacy) parcel.readSerializable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2409a);
        parcel.writeString(this.f2410b);
        parcel.writeSerializable(this.f2411c);
    }
}
