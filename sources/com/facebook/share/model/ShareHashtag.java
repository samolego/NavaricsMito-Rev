package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>() { // from class: com.facebook.share.model.ShareHashtag.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareHashtag[] newArray(int i) {
            return new ShareHashtag[i];
        }
    };

    /* renamed from: a */
    private final String f2448a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ShareHashtag(C1104a c1104a) {
        this.f2448a = c1104a.f2449a;
    }

    ShareHashtag(Parcel parcel) {
        this.f2448a = parcel.readString();
    }

    /* renamed from: a */
    public String m9873a() {
        return this.f2448a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2448a);
    }

    /* renamed from: com.facebook.share.model.ShareHashtag$a */
    /* loaded from: classes.dex */
    public static class C1104a {

        /* renamed from: a */
        private String f2449a;

        /* renamed from: a */
        public C1104a m9866a(String str) {
            this.f2449a = str;
            return this;
        }

        /* renamed from: a */
        public C1104a m9867a(ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : m9866a(shareHashtag.m9873a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public C1104a m9869a(Parcel parcel) {
            return m9867a((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }

        /* renamed from: a */
        public ShareHashtag m9870a() {
            return new ShareHashtag(this);
        }
    }
}
