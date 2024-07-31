package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;

/* loaded from: classes.dex */
public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Object> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() { // from class: com.facebook.share.model.ShareCameraEffectContent.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareCameraEffectContent createFromParcel(Parcel parcel) {
            return new ShareCameraEffectContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareCameraEffectContent[] newArray(int i) {
            return new ShareCameraEffectContent[i];
        }
    };

    /* renamed from: a */
    private String f2433a;

    /* renamed from: b */
    private CameraEffectArguments f2434b;

    /* renamed from: c */
    private CameraEffectTextures f2435c;

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        this.f2433a = parcel.readString();
        this.f2434b = new CameraEffectArguments.C1097a().m9912a(parcel).m9913a();
        this.f2435c = new CameraEffectTextures.C1099a().m9902a(parcel).m9903a();
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2433a);
        parcel.writeParcelable(this.f2434b, 0);
        parcel.writeParcelable(this.f2435c, 0);
    }

    /* renamed from: a */
    public String m9897a() {
        return this.f2433a;
    }

    /* renamed from: b */
    public CameraEffectArguments m9896b() {
        return this.f2434b;
    }

    /* renamed from: c */
    public CameraEffectTextures m9895c() {
        return this.f2435c;
    }
}
