package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareMedia;

/* loaded from: classes.dex */
public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator<ShareVideo>() { // from class: com.facebook.share.model.ShareVideo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    };

    /* renamed from: a */
    private final Uri f2499a;

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ShareVideo(C1124a c1124a) {
        super(c1124a);
        this.f2499a = c1124a.f2500a;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.f2499a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    @Nullable
    /* renamed from: c */
    public Uri m9763c() {
        return this.f2499a;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f2499a, 0);
    }

    @Override // com.facebook.share.model.ShareMedia
    /* renamed from: b */
    public ShareMedia.Type mo9764b() {
        return ShareMedia.Type.VIDEO;
    }

    /* renamed from: com.facebook.share.model.ShareVideo$a */
    /* loaded from: classes.dex */
    public static final class C1124a extends ShareMedia.AbstractC1106a<ShareVideo, C1124a> {

        /* renamed from: a */
        private Uri f2500a;

        /* renamed from: a */
        public C1124a m9759a(@Nullable Uri uri) {
            this.f2500a = uri;
            return this;
        }

        /* renamed from: a */
        public ShareVideo m9760a() {
            return new ShareVideo(this);
        }

        @Override // com.facebook.share.model.ShareMedia.AbstractC1106a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public C1124a mo9758a(ShareVideo shareVideo) {
            return shareVideo == null ? this : ((C1124a) super.mo9758a((C1124a) shareVideo)).m9759a(shareVideo.m9763c());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public C1124a m9755b(Parcel parcel) {
            return mo9758a((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }
}
