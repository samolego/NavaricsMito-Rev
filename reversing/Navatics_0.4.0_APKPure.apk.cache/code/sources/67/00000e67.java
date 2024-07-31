package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* loaded from: classes.dex */
public final class AppInviteContent implements ShareModel {

    @Deprecated
    public static final Parcelable.Creator<AppInviteContent> CREATOR = new Parcelable.Creator<AppInviteContent>() { // from class: com.facebook.share.model.AppInviteContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInviteContent[] newArray(int i) {
            return new AppInviteContent[i];
        }
    };

    /* renamed from: a */
    private final String f2421a;

    /* renamed from: b */
    private final String f2422b;

    /* renamed from: c */
    private final String f2423c;

    /* renamed from: d */
    private final String f2424d;

    /* renamed from: e */
    private final Builder.Destination f2425e;

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    AppInviteContent(Parcel parcel) {
        this.f2421a = parcel.readString();
        this.f2422b = parcel.readString();
        this.f2424d = parcel.readString();
        this.f2423c = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.f2425e = Builder.Destination.valueOf(readString);
        } else {
            this.f2425e = Builder.Destination.FACEBOOK;
        }
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2421a);
        parcel.writeString(this.f2422b);
        parcel.writeString(this.f2424d);
        parcel.writeString(this.f2423c);
        parcel.writeString(this.f2425e.toString());
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class Builder {

        @Deprecated
        /* loaded from: classes.dex */
        public enum Destination {
            FACEBOOK("facebook"),
            MESSENGER("messenger");

            private final String name;

            Destination(String str) {
                this.name = str;
            }

            public boolean equalsName(String str) {
                if (str == null) {
                    return false;
                }
                return this.name.equals(str);
            }

            @Override // java.lang.Enum
            public String toString() {
                return this.name;
            }
        }
    }
}