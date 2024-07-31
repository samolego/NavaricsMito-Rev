package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

/* loaded from: classes.dex */
public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, C1114a> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator<ShareOpenGraphAction>() { // from class: com.facebook.share.model.ShareOpenGraphAction.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    };

    private ShareOpenGraphAction(C1114a c1114a) {
        super(c1114a);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    @Nullable
    /* renamed from: a */
    public String m9822a() {
        return m9807b("og:type");
    }

    /* renamed from: com.facebook.share.model.ShareOpenGraphAction$a */
    /* loaded from: classes.dex */
    public static final class C1114a extends ShareOpenGraphValueContainer.AbstractC1117a<ShareOpenGraphAction, C1114a> {
        /* renamed from: a */
        public C1114a m9816a(String str) {
            m9803a("og:type", str);
            return this;
        }

        /* renamed from: a */
        public ShareOpenGraphAction m9819a() {
            return new ShareOpenGraphAction(this);
        }

        @Override // com.facebook.share.model.ShareOpenGraphValueContainer.AbstractC1117a
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public C1114a mo9804a(ShareOpenGraphAction shareOpenGraphAction) {
            return shareOpenGraphAction == null ? this : ((C1114a) super.mo9804a((C1114a) shareOpenGraphAction)).m9816a(shareOpenGraphAction.m9822a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public C1114a m9818a(Parcel parcel) {
            return mo9804a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }
}
