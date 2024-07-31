package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/* loaded from: classes.dex */
public final class ShareLinkContent extends ShareContent<ShareLinkContent, Object> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>() { // from class: com.facebook.share.model.ShareLinkContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    };
    @Deprecated

    /* renamed from: a */
    private final String f2450a;
    @Deprecated

    /* renamed from: b */
    private final String f2451b;
    @Deprecated

    /* renamed from: c */
    private final Uri f2452c;

    /* renamed from: d */
    private final String f2453d;

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.f2450a = parcel.readString();
        this.f2451b = parcel.readString();
        this.f2452c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2453d = parcel.readString();
    }

    @Deprecated
    /* renamed from: a */
    public String m9865a() {
        return this.f2450a;
    }

    @Nullable
    @Deprecated
    /* renamed from: b */
    public String m9864b() {
        return this.f2451b;
    }

    @Nullable
    @Deprecated
    /* renamed from: c */
    public Uri m9863c() {
        return this.f2452c;
    }

    @Nullable
    /* renamed from: d */
    public String m9862d() {
        return this.f2453d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2450a);
        parcel.writeString(this.f2451b);
        parcel.writeParcelable(this.f2452c, 0);
        parcel.writeString(this.f2453d);
    }
}
