package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

@Deprecated
/* renamed from: com.facebook.share.internal.e */
/* loaded from: classes.dex */
final class LikeStatusClient extends PlatformServiceClient {

    /* renamed from: a */
    private String f2388a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LikeStatusClient(Context context, String str, String str2) {
        super(context, 65542, 65543, 20141001, str);
        this.f2388a = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    /* renamed from: a */
    protected void mo10060a(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.f2388a);
    }
}
