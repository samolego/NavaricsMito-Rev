package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.p */
/* loaded from: classes.dex */
public class RequestProgress {

    /* renamed from: a */
    private final GraphRequest f2232a;

    /* renamed from: b */
    private final Handler f2233b;

    /* renamed from: c */
    private final long f2234c = FacebookSdk.m10866k();

    /* renamed from: d */
    private long f2235d;

    /* renamed from: e */
    private long f2236e;

    /* renamed from: f */
    private long f2237f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.f2232a = graphRequest;
        this.f2233b = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10225a(long j) {
        this.f2235d += j;
        long j2 = this.f2235d;
        if (j2 >= this.f2236e + this.f2234c || j2 >= this.f2237f) {
            m10226a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10224b(long j) {
        this.f2237f += j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10226a() {
        if (this.f2235d > this.f2236e) {
            GraphRequest.InterfaceC0829b m11352g = this.f2232a.m11352g();
            final long j = this.f2237f;
            if (j <= 0 || !(m11352g instanceof GraphRequest.InterfaceC0832e)) {
                return;
            }
            final long j2 = this.f2235d;
            final GraphRequest.InterfaceC0832e interfaceC0832e = (GraphRequest.InterfaceC0832e) m11352g;
            Handler handler = this.f2233b;
            if (handler == null) {
                interfaceC0832e.m11333a(j2, j);
            } else {
                handler.post(new Runnable() { // from class: com.facebook.p.1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC0832e.m11333a(j2, j);
                    }
                });
            }
            this.f2236e = this.f2235d;
        }
    }
}
