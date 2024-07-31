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
        /* renamed from: a */
        public SharePhoto createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SharePhoto[] newArray(int i) {
            return new SharePhoto[i];
        }
    };

    /* renamed from: a */
    private final Bitmap f2485a;

    /* renamed from: b */
    private final Uri f2486b;

    /* renamed from: c */
    private final boolean f2487c;

    /* renamed from: d */
    private final String f2488d;

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private SharePhoto(C1119a c1119a) {
        super(c1119a);
        this.f2485a = c1119a.f2489a;
        this.f2486b = c1119a.f2490b;
        this.f2487c = c1119a.f2491c;
        this.f2488d = c1119a.f2492d;
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.f2485a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f2486b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2487c = parcel.readByte() != 0;
        this.f2488d = parcel.readString();
    }

    @Nullable
    /* renamed from: c */
    public Bitmap m9802c() {
        return this.f2485a;
    }

    @Nullable
    /* renamed from: d */
    public Uri m9801d() {
        return this.f2486b;
    }

    /* renamed from: e */
    public boolean m9800e() {
        return this.f2487c;
    }

    /* renamed from: f */
    public String m9799f() {
        return this.f2488d;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f2485a, 0);
        parcel.writeParcelable(this.f2486b, 0);
        parcel.writeByte(this.f2487c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f2488d);
    }

    @Override // com.facebook.share.model.ShareMedia
    /* renamed from: b */
    public ShareMedia.Type mo9764b() {
        return ShareMedia.Type.PHOTO;
    }

    /* renamed from: com.facebook.share.model.SharePhoto$a */
    /* loaded from: classes.dex */
    public static final class C1119a extends ShareMedia.AbstractC1106a<SharePhoto, C1119a> {

        /* renamed from: a */
        private Bitmap f2489a;

        /* renamed from: b */
        private Uri f2490b;

        /* renamed from: c */
        private boolean f2491c;

        /* renamed from: d */
        private String f2492d;

        /* renamed from: a */
        public C1119a m9795a(@Nullable Bitmap bitmap) {
            this.f2489a = bitmap;
            return this;
        }

        /* renamed from: a */
        public C1119a m9794a(@Nullable Uri uri) {
            this.f2490b = uri;
            return this;
        }

        /* renamed from: a */
        public C1119a m9789a(boolean z) {
            this.f2491c = z;
            return this;
        }

        /* renamed from: a */
        public C1119a m9790a(@Nullable String str) {
            this.f2492d = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public Uri m9796a() {
            return this.f2490b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Bitmap m9788b() {
            return this.f2489a;
        }

        /* renamed from: c */
        public SharePhoto m9785c() {
            return new SharePhoto(this);
        }

        @Override // com.facebook.share.model.ShareMedia.AbstractC1106a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public C1119a mo9758a(SharePhoto sharePhoto) {
            return sharePhoto == null ? this : ((C1119a) super.mo9758a((C1119a) sharePhoto)).m9795a(sharePhoto.m9802c()).m9794a(sharePhoto.m9801d()).m9789a(sharePhoto.m9800e()).m9790a(sharePhoto.m9799f());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public C1119a m9787b(Parcel parcel) {
            return mo9758a((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static void m9793a(Parcel parcel, int i, List<SharePhoto> list) {
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                shareMediaArr[i2] = list.get(i2);
            }
            parcel.writeParcelableArray(shareMediaArr, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public static List<SharePhoto> m9784c(Parcel parcel) {
            List<ShareMedia> a = m9857a(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : a) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            return arrayList;
        }
    }
}
