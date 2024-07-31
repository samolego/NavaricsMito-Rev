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
        /* renamed from: a */
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            return new CameraEffectTextures(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    };

    /* renamed from: a */
    private final Bundle f2421a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CameraEffectTextures(C1099a c1099a) {
        this.f2421a = c1099a.f2422a;
    }

    CameraEffectTextures(Parcel parcel) {
        this.f2421a = parcel.readBundle(getClass().getClassLoader());
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m9907a(String str) {
        Object obj = this.f2421a.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    @Nullable
    /* renamed from: b */
    public Uri m9906b(String str) {
        Object obj = this.f2421a.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    /* renamed from: a */
    public Set<String> m9909a() {
        return this.f2421a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2421a);
    }

    /* renamed from: com.facebook.share.model.CameraEffectTextures$a */
    /* loaded from: classes.dex */
    public static class C1099a {

        /* renamed from: a */
        private Bundle f2422a = new Bundle();

        /* renamed from: a */
        public C1099a m9900a(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.f2422a.putAll(cameraEffectTextures.f2421a);
            }
            return this;
        }

        /* renamed from: a */
        public C1099a m9902a(Parcel parcel) {
            return m9900a((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }

        /* renamed from: a */
        public CameraEffectTextures m9903a() {
            return new CameraEffectTextures(this);
        }
    }
}
