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
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CameraEffectArguments createFromParcel(Parcel parcel) {
            return new CameraEffectArguments(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    };

    /* renamed from: a */
    private final Bundle f2427a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CameraEffectArguments(C0986a c0986a) {
        this.f2427a = c0986a.f2428a;
    }

    CameraEffectArguments(Parcel parcel) {
        this.f2427a = parcel.readBundle(getClass().getClassLoader());
    }

    @Nullable
    /* renamed from: a */
    public Object m3038a(String str) {
        return this.f2427a.get(str);
    }

    /* renamed from: a */
    public Set<String> m3039a() {
        return this.f2427a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2427a);
    }

    /* renamed from: com.facebook.share.model.CameraEffectArguments$a */
    /* loaded from: classes.dex */
    public static class C0986a {

        /* renamed from: a */
        private Bundle f2428a = new Bundle();

        /* renamed from: a */
        public C0986a m3044a(CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.f2428a.putAll(cameraEffectArguments.f2427a);
            }
            return this;
        }

        /* renamed from: a */
        public C0986a m3043a(Parcel parcel) {
            return m3044a((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }

        /* renamed from: a */
        public CameraEffectArguments m3045a() {
            return new CameraEffectArguments(this);
        }
    }
}