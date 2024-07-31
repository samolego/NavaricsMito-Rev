package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

/* loaded from: classes.dex */
public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, C1003a> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator<ShareOpenGraphAction>() { // from class: com.facebook.share.model.ShareOpenGraphAction.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareOpenGraphAction createFromParcel(Parcel parcel) {
            return new ShareOpenGraphAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareOpenGraphAction[] newArray(int i) {
            return new ShareOpenGraphAction[i];
        }
    };

    private ShareOpenGraphAction(C1003a c1003a) {
        super(c1003a);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    @Nullable
    /* renamed from: a */
    public String m3136a() {
        return m3151b("og:type");
    }

    /* renamed from: com.facebook.share.model.ShareOpenGraphAction$a */
    /* loaded from: classes.dex */
    public static final class C1003a extends ShareOpenGraphValueContainer.AbstractC1006a<ShareOpenGraphAction, C1003a> {
        /* renamed from: a */
        public C1003a m3140a(String str) {
            m3154a("og:type", str);
            return this;
        }

        /* renamed from: a */
        public ShareOpenGraphAction m3141a() {
            return new ShareOpenGraphAction(this);
        }

        @Override // com.facebook.share.model.ShareOpenGraphValueContainer.AbstractC1006a
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C1003a mo3142a(ShareOpenGraphAction shareOpenGraphAction) {
            return shareOpenGraphAction == null ? this : ((C1003a) super.mo3142a((C1003a) shareOpenGraphAction)).m3140a(shareOpenGraphAction.m3136a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public C1003a m3139a(Parcel parcel) {
            return mo3142a((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }
}