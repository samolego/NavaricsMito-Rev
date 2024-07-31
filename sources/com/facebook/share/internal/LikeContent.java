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
        /* renamed from: a */
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LikeContent[] newArray(int i) {
            return new LikeContent[i];
        }
    };

    /* renamed from: a */
    private final String f2281a;

    /* renamed from: b */
    private final String f2282b;

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    private LikeContent(C1038a c1038a) {
        this.f2281a = c1038a.f2283a;
        this.f2282b = c1038a.f2284b;
    }

    @Deprecated
    LikeContent(Parcel parcel) {
        this.f2281a = parcel.readString();
        this.f2282b = parcel.readString();
    }

    @Deprecated
    /* renamed from: a */
    public String m10178a() {
        return this.f2281a;
    }

    @Deprecated
    /* renamed from: b */
    public String m10177b() {
        return this.f2282b;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2281a);
        parcel.writeString(this.f2282b);
    }

    @Deprecated
    /* renamed from: com.facebook.share.internal.LikeContent$a */
    /* loaded from: classes.dex */
    public static class C1038a {

        /* renamed from: a */
        private String f2283a;

        /* renamed from: b */
        private String f2284b;

        @Deprecated
        /* renamed from: a */
        public C1038a m10172a(String str) {
            this.f2283a = str;
            return this;
        }

        @Deprecated
        /* renamed from: b */
        public C1038a m10170b(String str) {
            this.f2284b = str;
            return this;
        }

        @Deprecated
        /* renamed from: a */
        public LikeContent m10174a() {
            return new LikeContent(this);
        }
    }
}
