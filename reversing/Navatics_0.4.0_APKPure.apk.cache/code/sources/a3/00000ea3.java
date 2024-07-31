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
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    };

    /* renamed from: a */
    private final Uri f2507a;

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ShareVideo(C1013a c1013a) {
        super(c1013a);
        this.f2507a = c1013a.f2508a;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.f2507a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    @Nullable
    /* renamed from: c */
    public Uri m3190c() {
        return this.f2507a;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f2507a, 0);
    }

    @Override // com.facebook.share.model.ShareMedia
    /* renamed from: b */
    public ShareMedia.Type mo3098b() {
        return ShareMedia.Type.VIDEO;
    }

    /* renamed from: com.facebook.share.model.ShareVideo$a */
    /* loaded from: classes.dex */
    public static final class C1013a extends ShareMedia.AbstractC0995a<ShareVideo, C1013a> {

        /* renamed from: a */
        private Uri f2508a;

        /* renamed from: a */
        public C1013a m3194a(@Nullable Uri uri) {
            this.f2508a = uri;
            return this;
        }

        /* renamed from: a */
        public ShareVideo m3195a() {
            return new ShareVideo(this);
        }

        @Override // com.facebook.share.model.ShareMedia.AbstractC0995a
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C1013a mo3102a(ShareVideo shareVideo) {
            return shareVideo == null ? this : ((C1013a) super.mo3102a((C1013a) shareVideo)).m3194a(shareVideo.m3190c());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public C1013a m3196b(Parcel parcel) {
            return mo3102a((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }
}