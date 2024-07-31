package com.tencent.p075mm.opensdk.diffdev.p077a;

import android.os.Handler;
import com.tencent.p075mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p075mm.opensdk.diffdev.OAuthListener;
import com.tencent.p075mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
/* loaded from: classes2.dex */
public final class C2508b implements OAuthListener {

    /* renamed from: ab */
    final /* synthetic */ C2507a f7793ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2508b(C2507a c2507a) {
        this.f7793ab = c2507a;
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.OAuthListener
    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        List list;
        Log.m5001d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
        C2507a.m5011c(this.f7793ab);
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f7793ab.f7790Y;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthFinish(oAuthErrCode, str);
        }
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.OAuthListener
    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List list;
        Log.m5001d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f7793ab.f7790Y;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onAuthGotQrcode(str, bArr);
        }
    }

    @Override // com.tencent.p075mm.opensdk.diffdev.OAuthListener
    public final void onQrcodeScanned() {
        Handler handler;
        Handler handler2;
        Log.m5001d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        handler = this.f7793ab.handler;
        if (handler != null) {
            handler2 = this.f7793ab.handler;
            handler2.post(new RunnableC2509c(this));
        }
    }
}
