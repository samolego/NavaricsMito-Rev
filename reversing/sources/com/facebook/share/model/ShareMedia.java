package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ShareMedia implements ShareModel {

    /* renamed from: a */
    private final Bundle f2454a;

    /* loaded from: classes.dex */
    public enum Type {
        PHOTO,
        VIDEO
    }

    /* renamed from: b */
    public abstract Type mo9764b();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareMedia(AbstractC1106a abstractC1106a) {
        this.f2454a = new Bundle(abstractC1106a.f2456a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMedia(Parcel parcel) {
        this.f2454a = parcel.readBundle();
    }

    @Deprecated
    /* renamed from: a */
    public Bundle m9859a() {
        return new Bundle(this.f2454a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2454a);
    }

    /* renamed from: com.facebook.share.model.ShareMedia$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1106a<M extends ShareMedia, B extends AbstractC1106a> {

        /* renamed from: a */
        private Bundle f2456a = new Bundle();

        @Deprecated
        /* renamed from: a */
        public B m9858a(Bundle bundle) {
            this.f2456a.putAll(bundle);
            return this;
        }

        /* renamed from: a */
        public B mo9758a(M m) {
            return m == null ? this : m9858a(m.m9859a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static List<ShareMedia> m9857a(Parcel parcel) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(readParcelableArray.length);
            for (Parcelable parcelable : readParcelableArray) {
                arrayList.add((ShareMedia) parcelable);
            }
            return arrayList;
        }
    }
}
