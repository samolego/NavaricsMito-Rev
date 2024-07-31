package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraEffectArguments implements ShareModel {
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new Parcelable.Creator<CameraEffectArguments>() { // from class: com.facebook.share.model.CameraEffectArguments.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CameraEffectArguments createFromParcel(Parcel parcel) {
            return new CameraEffectArguments(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    };

    /* renamed from: a */
    private final Bundle f2419a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CameraEffectArguments(C1097a c1097a) {
        this.f2419a = c1097a.f2420a;
    }

    CameraEffectArguments(Parcel parcel) {
        this.f2419a = parcel.readBundle(getClass().getClassLoader());
    }

    @Nullable
    /* renamed from: a */
    public Object m9916a(String str) {
        return this.f2419a.get(str);
    }

    /* renamed from: a */
    public Set<String> m9918a() {
        return this.f2419a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2419a);
    }

    /* renamed from: com.facebook.share.model.CameraEffectArguments$a */
    /* loaded from: classes.dex */
    public static class C1097a {

        /* renamed from: a */
        private Bundle f2420a = new Bundle();

        /* renamed from: a */
        public C1097a m9910a(CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.f2420a.putAll(cameraEffectArguments.f2419a);
            }
            return this;
        }

        /* renamed from: a */
        public C1097a m9912a(Parcel parcel) {
            return m9910a((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }

        /* renamed from: a */
        public CameraEffectArguments m9913a() {
            return new CameraEffectArguments(this);
        }
    }
}
