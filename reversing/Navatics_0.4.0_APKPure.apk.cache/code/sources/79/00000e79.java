package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>() { // from class: com.facebook.share.model.ShareHashtag.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    };

    /* renamed from: a */
    private final String f2456a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ShareHashtag(C0993a c0993a) {
        this.f2456a = c0993a.f2457a;
    }

    ShareHashtag(Parcel parcel) {
        this.f2456a = parcel.readString();
    }

    /* renamed from: a */
    public String m3083a() {
        return this.f2456a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2456a);
    }

    /* renamed from: com.facebook.share.model.ShareHashtag$a */
    /* loaded from: classes.dex */
    public static class C0993a {

        /* renamed from: a */
        private String f2457a;

        /* renamed from: a */
        public C0993a m3089a(String str) {
            this.f2457a = str;
            return this;
        }

        /* renamed from: a */
        public C0993a m3088a(ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : m3089a(shareHashtag.m3083a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public C0993a m3087a(Parcel parcel) {
            return m3088a((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        /* renamed from: a */
        public ShareHashtag m3090a() {
            return new ShareHashtag(this);
        }
    }
}