package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.AbstractServiceConnectionC0919t;

/* compiled from: LikeStatusClient.java */
@Deprecated
/* renamed from: com.facebook.share.internal.e, reason: use source file name */
/* loaded from: classes.dex */
final class LikeStatusClient extends AbstractServiceConnectionC0919t {

    /* renamed from: a */
    private String f2396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LikeStatusClient(Context context, String str, String str2) {
        super(context, 65542, 65543, 20141001, str);
        this.f2396a = str2;
    }

    @Override // com.facebook.internal.AbstractServiceConnectionC0919t
    /* renamed from: a */
    protected void mo2416a(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.f2396a);
    }
}