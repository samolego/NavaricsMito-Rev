package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;

@Deprecated
/* loaded from: classes.dex */
public class LikeContent implements ShareModel {

    @Deprecated
    public static final Parcelable.Creator<LikeContent> CREATOR = new Parcelable.Creator<LikeContent>() { // from class: com.facebook.share.internal.LikeContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LikeContent[] newArray(int i) {
            return new LikeContent[i];
        }
    };

    /* renamed from: a */
    private final String f2289a;

    /* renamed from: b */
    private final String f2290b;

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    private LikeContent(C0969a c0969a) {
        this.f2289a = c0969a.f2291a;
        this.f2290b = c0969a.f2292b;
    }

    @Deprecated
    LikeContent(Parcel parcel) {
        this.f2289a = parcel.readString();
        this.f2290b = parcel.readString();
    }

    @Deprecated
    /* renamed from: a */
    public String m2795a() {
        return this.f2289a;
    }

    @Deprecated
    /* renamed from: b */
    public String m2796b() {
        return this.f2290b;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2289a);
        parcel.writeString(this.f2290b);
    }

    @Deprecated
    /* renamed from: com.facebook.share.internal.LikeContent$a */
    /* loaded from: classes.dex */
    public static class C0969a {

        /* renamed from: a */
        private String f2291a;

        /* renamed from: b */
        private String f2292b;

        @Deprecated
        /* renamed from: a */
        public C0969a m2801a(String str) {
            this.f2291a = str;
            return this;
        }

        @Deprecated
        /* renamed from: b */
        public C0969a m2803b(String str) {
            this.f2292b = str;
            return this;
        }

        @Deprecated
        /* renamed from: a */
        public LikeContent m2802a() {
            return new LikeContent(this);
        }
    }
}