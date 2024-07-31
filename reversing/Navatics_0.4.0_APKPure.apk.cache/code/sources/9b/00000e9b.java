package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>() { // from class: com.facebook.share.model.SharePhoto.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    };

    /* renamed from: a */
    private final Bitmap f2493a;

    /* renamed from: b */
    private final Uri f2494b;

    /* renamed from: c */
    private final boolean f2495c;

    /* renamed from: d */
    private final String f2496d;

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private SharePhoto(C1008a c1008a) {
        super(c1008a);
        this.f2493a = c1008a.f2497a;
        this.f2494b = c1008a.f2498b;
        this.f2495c = c1008a.f2499c;
        this.f2496d = c1008a.f2500d;
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.f2493a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f2494b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2495c = parcel.readByte() != 0;
        this.f2496d = parcel.readString();
    }

    @Nullable
    /* renamed from: c */
    public Bitmap m3155c() {
        return this.f2493a;
    }

    @Nullable
    /* renamed from: d */
    public Uri m3156d() {
        return this.f2494b;
    }

    /* renamed from: e */
    public boolean m3157e() {
        return this.f2495c;
    }

    /* renamed from: f */
    public String m3158f() {
        return this.f2496d;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f2493a, 0);
        parcel.writeParcelable(this.f2494b, 0);
        parcel.writeByte(this.f2495c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f2496d);
    }

    @Override // com.facebook.share.model.ShareMedia
    /* renamed from: b */
    public ShareMedia.Type mo3098b() {
        return ShareMedia.Type.PHOTO;
    }

    /* renamed from: com.facebook.share.model.SharePhoto$a */
    /* loaded from: classes.dex */
    public static final class C1008a extends ShareMedia.AbstractC0995a<SharePhoto, C1008a> {

        /* renamed from: a */
        private Bitmap f2497a;

        /* renamed from: b */
        private Uri f2498b;

        /* renamed from: c */
        private boolean f2499c;

        /* renamed from: d */
        private String f2500d;

        /* renamed from: a */
        public C1008a m3168a(@Nullable Bitmap bitmap) {
            this.f2497a = bitmap;
            return this;
        }

        /* renamed from: a */
        public C1008a m3169a(@Nullable Uri uri) {
            this.f2498b = uri;
            return this;
        }

        /* renamed from: a */
        public C1008a m3171a(boolean z) {
            this.f2499c = z;
            return this;
        }

        /* renamed from: a */
        public C1008a m3170a(@Nullable String str) {
            this.f2500d = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public Uri m3167a() {
            return this.f2498b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Bitmap m3172b() {
            return this.f2497a;
        }

        /* renamed from: c */
        public SharePhoto m3174c() {
            return new SharePhoto(this);
        }

        @Override // com.facebook.share.model.ShareMedia.AbstractC0995a
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C1008a mo3102a(SharePhoto sharePhoto) {
            return sharePhoto == null ? this : ((C1008a) super.mo3102a((C1008a) sharePhoto)).m3168a(sharePhoto.m3155c()).m3169a(sharePhoto.m3156d()).m3171a(sharePhoto.m3157e()).m3170a(sharePhoto.m3158f());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public C1008a m3173b(Parcel parcel) {
            return mo3102a((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static void m3162a(Parcel parcel, int i, List<SharePhoto> list) {
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                shareMediaArr[i2] = list.get(i2);
            }
            parcel.writeParcelableArray(shareMediaArr, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public static List<SharePhoto> m3164c(Parcel parcel) {
            List<ShareMedia> a2 = m3100a(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : a2) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            return arrayList;
        }
    }
}