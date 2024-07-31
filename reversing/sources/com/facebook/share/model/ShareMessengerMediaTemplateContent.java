package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerMediaTemplateContent>() { // from class: com.facebook.share.model.ShareMessengerMediaTemplateContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerMediaTemplateContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerMediaTemplateContent[] newArray(int i) {
            return new ShareMessengerMediaTemplateContent[i];
        }
    };

    /* renamed from: a */
    private final MediaType f2468a;

    /* renamed from: b */
    private final String f2469b;

    /* renamed from: c */
    private final Uri f2470c;

    /* renamed from: d */
    private final ShareMessengerActionButton f2471d;

    /* loaded from: classes.dex */
    public enum MediaType {
        IMAGE,
        VIDEO
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        this.f2468a = (MediaType) parcel.readSerializable();
        this.f2469b = parcel.readString();
        this.f2470c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2471d = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
    }

    /* renamed from: a */
    public MediaType m9839a() {
        return this.f2468a;
    }

    /* renamed from: b */
    public String m9838b() {
        return this.f2469b;
    }

    /* renamed from: c */
    public Uri m9837c() {
        return this.f2470c;
    }

    /* renamed from: d */
    public ShareMessengerActionButton m9836d() {
        return this.f2471d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f2468a);
        parcel.writeString(this.f2469b);
        parcel.writeParcelable(this.f2470c, i);
        parcel.writeParcelable(this.f2471d, i);
    }
}
