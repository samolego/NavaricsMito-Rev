package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/* loaded from: classes.dex */
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new Parcelable.Creator<ShareMessengerURLActionButton>() { // from class: com.facebook.share.model.ShareMessengerURLActionButton.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareMessengerURLActionButton[] newArray(int i) {
            return new ShareMessengerURLActionButton[i];
        }
    };

    /* renamed from: a */
    private final Uri f2483a;

    /* renamed from: b */
    private final Uri f2484b;

    /* renamed from: c */
    private final boolean f2485c;

    /* renamed from: d */
    private final boolean f2486d;

    /* renamed from: e */
    private final WebviewHeightRatio f2487e;

    /* loaded from: classes.dex */
    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        this.f2483a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2485c = parcel.readByte() != 0;
        this.f2484b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f2487e = (WebviewHeightRatio) parcel.readSerializable();
        this.f2486d = parcel.readByte() != 0;
    }

    /* renamed from: b */
    public Uri m3129b() {
        return this.f2483a;
    }

    /* renamed from: c */
    public boolean m3130c() {
        return this.f2485c;
    }

    @Nullable
    /* renamed from: d */
    public Uri m3131d() {
        return this.f2484b;
    }

    @Nullable
    /* renamed from: e */
    public WebviewHeightRatio m3132e() {
        return this.f2487e;
    }

    /* renamed from: f */
    public boolean m3133f() {
        return this.f2486d;
    }
}