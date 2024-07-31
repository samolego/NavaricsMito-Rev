package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/* loaded from: classes.dex */
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new Parcelable.Creator<ShareMessengerURLActionButton>() { // from class: com.facebook.share.model.ShareMessengerURLActionButton.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerURLActionButton[] newArray(int i) {
            return new ShareMessengerURLActionButton[i];
        }
    };

    /* renamed from: a */
    private final Uri f2475a;

    /* renamed from: b */
    private final Uri f2476b;

    /* renamed from: c */
    private final boolean f2477c;

    /* renamed from: d */
    private final boolean f2478d;

    /* renamed from: e */
    private final WebviewHeightRatio f2479e;

    /* loaded from: classes.dex */
    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        this.f2475a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2477c = parcel.readByte() != 0;
        this.f2476b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2479e = (WebviewHeightRatio) parcel.readSerializable();
        this.f2478d = parcel.readByte() != 0;
    }

    /* renamed from: b */
    public Uri m9829b() {
        return this.f2475a;
    }

    /* renamed from: c */
    public boolean m9828c() {
        return this.f2477c;
    }

    @Nullable
    /* renamed from: d */
    public Uri m9827d() {
        return this.f2476b;
    }

    @Nullable
    /* renamed from: e */
    public WebviewHeightRatio m9826e() {
        return this.f2479e;
    }

    /* renamed from: f */
    public boolean m9825f() {
        return this.f2478d;
    }
}
