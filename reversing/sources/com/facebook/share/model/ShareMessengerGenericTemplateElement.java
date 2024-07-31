package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR = new Parcelable.Creator<ShareMessengerGenericTemplateElement>() { // from class: com.facebook.share.model.ShareMessengerGenericTemplateElement.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerGenericTemplateElement[] newArray(int i) {
            return new ShareMessengerGenericTemplateElement[i];
        }
    };

    /* renamed from: a */
    private final String f2463a;

    /* renamed from: b */
    private final String f2464b;

    /* renamed from: c */
    private final Uri f2465c;

    /* renamed from: d */
    private final ShareMessengerActionButton f2466d;

    /* renamed from: e */
    private final ShareMessengerActionButton f2467e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareMessengerGenericTemplateElement(Parcel parcel) {
        this.f2463a = parcel.readString();
        this.f2464b = parcel.readString();
        this.f2465c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2466d = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        this.f2467e = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    /* renamed from: a */
    public String m9846a() {
        return this.f2463a;
    }

    /* renamed from: b */
    public String m9845b() {
        return this.f2464b;
    }

    /* renamed from: c */
    public Uri m9844c() {
        return this.f2465c;
    }

    /* renamed from: d */
    public ShareMessengerActionButton m9843d() {
        return this.f2466d;
    }

    /* renamed from: e */
    public ShareMessengerActionButton m9842e() {
        return this.f2467e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2463a);
        parcel.writeString(this.f2464b);
        parcel.writeParcelable(this.f2465c, i);
        parcel.writeParcelable(this.f2466d, i);
        parcel.writeParcelable(this.f2467e, i);
    }
}
