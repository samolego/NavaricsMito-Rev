package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraEffectTextures implements ShareModel {
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new Parcelable.Creator<CameraEffectTextures>() { // from class: com.facebook.share.model.CameraEffectTextures.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            return new CameraEffectTextures(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    };

    /* renamed from: a */
    private final Bundle f2429a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CameraEffectTextures(C0988a c0988a) {
        this.f2429a = c0988a.f2430a;
    }

    CameraEffectTextures(Parcel parcel) {
        this.f2429a = parcel.readBundle(getClass().getClassLoader());
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m3047a(String str) {
        Object obj = this.f2429a.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    @Nullable
    /* renamed from: b */
    public Uri m3049b(String str) {
        Object obj = this.f2429a.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    /* renamed from: a */
    public Set<String> m3048a() {
        return this.f2429a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2429a);
    }

    /* renamed from: com.facebook.share.model.CameraEffectTextures$a */
    /* loaded from: classes.dex */
    public static class C0988a {

        /* renamed from: a */
        private Bundle f2430a = new Bundle();

        /* renamed from: a */
        public C0988a m3054a(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.f2430a.putAll(cameraEffectTextures.f2429a);
            }
            return this;
        }

        /* renamed from: a */
        public C0988a m3053a(Parcel parcel) {
            return m3054a((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }

        /* renamed from: a */
        public CameraEffectTextures m3055a() {
            return new CameraEffectTextures(this);
        }
    }
}