package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Object> {
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() { // from class: com.facebook.share.model.ShareStoryContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareStoryContent createFromParcel(Parcel parcel) {
            return new ShareStoryContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareStoryContent[] newArray(int i) {
            return new ShareStoryContent[i];
        }
    };

    /* renamed from: a */
    private final ShareMedia f2495a;

    /* renamed from: b */
    private final SharePhoto f2496b;
    @Nullable

    /* renamed from: c */
    private final List<String> f2497c;

    /* renamed from: d */
    private final String f2498d;

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    ShareStoryContent(Parcel parcel) {
        super(parcel);
        this.f2495a = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.f2496b = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.f2497c = m9770a(parcel);
        this.f2498d = parcel.readString();
    }

    /* renamed from: a */
    public ShareMedia m9771a() {
        return this.f2495a;
    }

    /* renamed from: b */
    public SharePhoto m9769b() {
        return this.f2496b;
    }

    @Nullable
    /* renamed from: c */
    public List<String> m9768c() {
        List<String> list = this.f2497c;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    /* renamed from: d */
    public String m9767d() {
        return this.f2498d;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f2495a, 0);
        parcel.writeParcelable(this.f2496b, 0);
        parcel.writeStringList(this.f2497c);
        parcel.writeString(this.f2498d);
    }

    @Nullable
    /* renamed from: a */
    private List<String> m9770a(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }
}
