package com.tencent.p075mm.opensdk.diffdev.p077a;

import com.tencent.p075mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
/* loaded from: classes2.dex */
final class RunnableC2509c implements Runnable {

    /* renamed from: ac */
    final /* synthetic */ C2508b f7794ac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2509c(C2508b c2508b) {
        this.f7794ac = c2508b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList<OAuthListener> arrayList = new ArrayList();
        list = this.f7794ac.f7793ab.f7790Y;
        arrayList.addAll(list);
        for (OAuthListener oAuthListener : arrayList) {
            oAuthListener.onQrcodeScanned();
        }
    }
}
