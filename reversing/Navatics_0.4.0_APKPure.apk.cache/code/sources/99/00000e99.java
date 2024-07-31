package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.AbstractC1006a;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends AbstractC1006a> implements ShareModel {

    /* renamed from: a */
    private final Bundle f2491a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareOpenGraphValueContainer(AbstractC1006a<P, E> abstractC1006a) {
        this.f2491a = (Bundle) ((AbstractC1006a) abstractC1006a).f2492a.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareOpenGraphValueContainer(Parcel parcel) {
        this.f2491a = parcel.readBundle(AbstractC1006a.class.getClassLoader());
    }

    @Nullable
    /* renamed from: a */
    public Object m3149a(String str) {
        return this.f2491a.get(str);
    }

    @Nullable
    /* renamed from: b */
    public String m3151b(String str) {
        return this.f2491a.getString(str);
    }

    /* renamed from: b */
    public Bundle m3150b() {
        return (Bundle) this.f2491a.clone();
    }

    /* renamed from: c */
    public Set<String> m3152c() {
        return this.f2491a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2491a);
    }

    /* renamed from: com.facebook.share.model.ShareOpenGraphValueContainer$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1006a<P extends ShareOpenGraphValueContainer, E extends AbstractC1006a> {

        /* renamed from: a */
        private Bundle f2492a = new Bundle();

        /* renamed from: a */
        public E m3154a(String str, @Nullable String str2) {
            this.f2492a.putString(str, str2);
            return this;
        }

        /* renamed from: a */
        public E mo3142a(P p) {
            if (p != null) {
                this.f2492a.putAll(p.m3150b());
            }
            return this;
        }
    }
}