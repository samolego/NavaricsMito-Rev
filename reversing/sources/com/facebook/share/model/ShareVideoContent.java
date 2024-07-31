package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;

/* loaded from: classes.dex */
public final class ShareVideoContent extends ShareContent<ShareVideoContent, Object> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() { // from class: com.facebook.share.model.ShareVideoContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    };

    /* renamed from: a */
    private final String f2501a;

    /* renamed from: b */
    private final String f2502b;

    /* renamed from: c */
    private final SharePhoto f2503c;

    /* renamed from: d */
    private final ShareVideo f2504d;

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.f2501a = parcel.readString();
        this.f2502b = parcel.readString();
        SharePhoto.C1119a m9787b = new SharePhoto.C1119a().m9787b(parcel);
        if (m9787b.m9796a() != null || m9787b.m9788b() != null) {
            this.f2503c = m9787b.m9785c();
        } else {
            this.f2503c = null;
        }
        this.f2504d = new ShareVideo.C1124a().m9755b(parcel).m9760a();
    }

    @Nullable
    /* renamed from: a */
    public String m9754a() {
        return this.f2501a;
    }

    @Nullable
    /* renamed from: b */
    public String m9753b() {
        return this.f2502b;
    }

    @Nullable
    /* renamed from: c */
    public SharePhoto m9752c() {
        return this.f2503c;
    }

    @Nullable
    /* renamed from: d */
    public ShareVideo m9751d() {
        return this.f2504d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2501a);
        parcel.writeString(this.f2502b);
        parcel.writeParcelable(this.f2503c, 0);
        parcel.writeParcelable(this.f2504d, 0);
    }
}
