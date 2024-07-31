package com.tencent.p075mm.opensdk.modelbase;

import android.os.Bundle;
import com.tencent.p075mm.opensdk.utils.C2519a;

/* renamed from: com.tencent.mm.opensdk.modelbase.BaseReq */
/* loaded from: classes2.dex */
public abstract class BaseReq {
    public String openId;
    public String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.transaction = C2519a.m4995b(bundle, "_wxapi_basereq_transaction");
        this.openId = C2519a.m4995b(bundle, "_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
