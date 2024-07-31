package com.tencent.wxop.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.j */
/* loaded from: classes2.dex */
public class C2593j extends DefaultConnectionKeepAliveStrategy {

    /* renamed from: a */
    final /* synthetic */ C2592i f8148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2593j(C2592i c2592i) {
        this.f8148a = c2592i;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        if (keepAliveDuration == -1) {
            return 30000L;
        }
        return keepAliveDuration;
    }
}
