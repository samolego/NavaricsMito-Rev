package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ShareMedia implements ShareModel {

    /* renamed from: a */
    private final Bundle f2462a;

    /* loaded from: classes.dex */
    public enum Type {
        PHOTO,
        VIDEO
    }

    /* renamed from: b */
    public abstract Type mo3098b();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareMedia(AbstractC0995a abstractC0995a) {
        this.f2462a = new Bundle(abstractC0995a.f2464a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareMedia(Parcel parcel) {
        this.f2462a = parcel.readBundle();
    }

    @Deprecated
    /* renamed from: a */
    public Bundle m3097a() {
        return new Bundle(this.f2462a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2462a);
    }

    /* renamed from: com.facebook.share.model.ShareMedia$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0995a<M extends ShareMedia, B extends AbstractC0995a> {

        /* renamed from: a */
        private Bundle f2464a = new Bundle();

        @Deprecated
        /* renamed from: a */
        public B m3101a(Bundle bundle) {
            this.f2464a.putAll(bundle);
            return this;
        }

        /* renamed from: a */
        public B mo3102a(M m) {
            return m == null ? this : m3101a(m.m3097a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static List<ShareMedia> m3100a(Parcel parcel) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(readParcelableArray.length);
            for (Parcelable parcelable : readParcelableArray) {
                arrayList.add((ShareMedia) parcelable);
            }
            return arrayList;
        }
    }
}