package com.facebook.share.model;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class ShareMessengerActionButton implements ShareModel {

    /* renamed from: a */
    private final String f2458a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMessengerActionButton(Parcel parcel) {
        this.f2458a = parcel.readString();
    }

    /* renamed from: a */
    public String m9852a() {
        return this.f2458a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2458a);
    }
}
