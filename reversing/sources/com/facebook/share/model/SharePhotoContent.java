package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SharePhotoContent extends ShareContent<SharePhotoContent, C1121a> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator<SharePhotoContent>() { // from class: com.facebook.share.model.SharePhotoContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SharePhotoContent createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SharePhotoContent[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    };

    /* renamed from: a */
    private final List<SharePhoto> f2493a;

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private SharePhotoContent(C1121a c1121a) {
        super(c1121a);
        this.f2493a = Collections.unmodifiableList(c1121a.f2494a);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.f2493a = Collections.unmodifiableList(SharePhoto.C1119a.m9784c(parcel));
    }

    @Nullable
    /* renamed from: a */
    public List<SharePhoto> m9781a() {
        return this.f2493a;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        SharePhoto.C1119a.m9793a(parcel, i, this.f2493a);
    }

    /* renamed from: com.facebook.share.model.SharePhotoContent$a */
    /* loaded from: classes.dex */
    public static class C1121a extends ShareContent.AbstractC1102a<SharePhotoContent, C1121a> {

        /* renamed from: a */
        private final List<SharePhoto> f2494a = new ArrayList();

        /* renamed from: a */
        public C1121a m9776a(@Nullable SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.f2494a.add(new SharePhoto.C1119a().mo9758a(sharePhoto).m9785c());
            }
            return this;
        }

        /* renamed from: b */
        public C1121a m9773b(@Nullable List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto sharePhoto : list) {
                    m9776a(sharePhoto);
                }
            }
            return this;
        }

        /* renamed from: a */
        public SharePhotoContent m9778a() {
            return new SharePhotoContent(this);
        }

        @Override // com.facebook.share.model.ShareContent.AbstractC1102a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public C1121a mo9777a(SharePhotoContent sharePhotoContent) {
            return sharePhotoContent == null ? this : ((C1121a) super.mo9777a((C1121a) sharePhotoContent)).m9773b(sharePhotoContent.m9781a());
        }

        /* renamed from: c */
        public C1121a m9772c(@Nullable List<SharePhoto> list) {
            this.f2494a.clear();
            m9773b(list);
            return this;
        }
    }
}
