package com.tencent.p075mm.opensdk.diffdev;

/* renamed from: com.tencent.mm.opensdk.diffdev.OAuthListener */
/* loaded from: classes2.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}
