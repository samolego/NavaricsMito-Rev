package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.AbstractC1117a;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends AbstractC1117a> implements ShareModel {

    /* renamed from: a */
    private final Bundle f2483a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareOpenGraphValueContainer(AbstractC1117a<P, E> abstractC1117a) {
        this.f2483a = (Bundle) ((AbstractC1117a) abstractC1117a).f2484a.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareOpenGraphValueContainer(Parcel parcel) {
        this.f2483a = parcel.readBundle(AbstractC1117a.class.getClassLoader());
    }

    @Nullable
    /* renamed from: a */
    public Object m9809a(String str) {
        return this.f2483a.get(str);
    }

    @Nullable
    /* renamed from: b */
    public String m9807b(String str) {
        return this.f2483a.getString(str);
    }

    /* renamed from: b */
    public Bundle m9808b() {
        return (Bundle) this.f2483a.clone();
    }

    /* renamed from: c */
    public Set<String> m9806c() {
        return this.f2483a.keySet();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f2483a);
    }

    /* renamed from: com.facebook.share.model.ShareOpenGraphValueContainer$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1117a<P extends ShareOpenGraphValueContainer, E extends AbstractC1117a> {

        /* renamed from: a */
        private Bundle f2484a = new Bundle();

        /* renamed from: a */
        public E m9803a(String str, @Nullable String str2) {
            this.f2484a.putString(str, str2);
            return this;
        }

        /* renamed from: a */
        public E mo9804a(P p) {
            if (p != null) {
                this.f2484a.putAll(p.m9808b());
            }
            return this;
        }
    }
}
