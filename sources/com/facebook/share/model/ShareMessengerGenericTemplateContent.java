package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Object> {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerGenericTemplateContent>() { // from class: com.facebook.share.model.ShareMessengerGenericTemplateContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    };

    /* renamed from: a */
    private final boolean f2459a;

    /* renamed from: b */
    private final ImageAspectRatio f2460b;

    /* renamed from: c */
    private final ShareMessengerGenericTemplateElement f2461c;

    /* loaded from: classes.dex */
    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        this.f2459a = parcel.readByte() != 0;
        this.f2460b = (ImageAspectRatio) parcel.readSerializable();
        this.f2461c = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }

    /* renamed from: a */
    public boolean m9851a() {
        return this.f2459a;
    }

    /* renamed from: b */
    public ImageAspectRatio m9850b() {
        return this.f2460b;
    }

    /* renamed from: c */
    public ShareMessengerGenericTemplateElement m9849c() {
        return this.f2461c;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f2459a ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.f2460b);
        parcel.writeParcelable(this.f2461c, i);
    }
}
