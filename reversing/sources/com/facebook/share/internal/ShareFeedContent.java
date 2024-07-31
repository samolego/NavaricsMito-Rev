package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;

/* loaded from: classes.dex */
public class ShareFeedContent extends ShareContent<ShareFeedContent, Object> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() { // from class: com.facebook.share.internal.ShareFeedContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareFeedContent createFromParcel(Parcel parcel) {
            return new ShareFeedContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareFeedContent[] newArray(int i) {
            return new ShareFeedContent[i];
        }
    };

    /* renamed from: a */
    private final String f2289a;

    /* renamed from: b */
    private final String f2290b;

    /* renamed from: c */
    private final String f2291c;

    /* renamed from: d */
    private final String f2292d;

    /* renamed from: e */
    private final String f2293e;

    /* renamed from: f */
    private final String f2294f;

    /* renamed from: g */
    private final String f2295g;

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        this.f2289a = parcel.readString();
        this.f2290b = parcel.readString();
        this.f2291c = parcel.readString();
        this.f2292d = parcel.readString();
        this.f2293e = parcel.readString();
        this.f2294f = parcel.readString();
        this.f2295g = parcel.readString();
    }

    /* renamed from: a */
    public String m10169a() {
        return this.f2289a;
    }

    /* renamed from: b */
    public String m10168b() {
        return this.f2290b;
    }

    /* renamed from: c */
    public String m10167c() {
        return this.f2291c;
    }

    /* renamed from: d */
    public String m10166d() {
        return this.f2292d;
    }

    /* renamed from: e */
    public String m10165e() {
        return this.f2293e;
    }

    /* renamed from: f */
    public String m10164f() {
        return this.f2294f;
    }

    /* renamed from: g */
    public String m10163g() {
        return this.f2295g;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2289a);
        parcel.writeString(this.f2290b);
        parcel.writeString(this.f2291c);
        parcel.writeString(this.f2292d);
        parcel.writeString(this.f2293e);
        parcel.writeString(this.f2294f);
        parcel.writeString(this.f2295g);
    }
}
