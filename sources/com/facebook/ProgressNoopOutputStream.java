package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.m */
/* loaded from: classes.dex */
public class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {

    /* renamed from: a */
    private final Map<GraphRequest, RequestProgress> f2218a = new HashMap();

    /* renamed from: b */
    private final Handler f2219b;

    /* renamed from: c */
    private GraphRequest f2220c;

    /* renamed from: d */
    private RequestProgress f2221d;

    /* renamed from: e */
    private int f2222e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressNoopOutputStream(Handler handler) {
        this.f2219b = handler;
    }

    @Override // com.facebook.RequestOutputStream
    /* renamed from: a */
    public void mo10227a(GraphRequest graphRequest) {
        this.f2220c = graphRequest;
        this.f2221d = graphRequest != null ? this.f2218a.get(graphRequest) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m10235a() {
        return this.f2222e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Map<GraphRequest, RequestProgress> m10233b() {
        return this.f2218a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10234a(long j) {
        if (this.f2221d == null) {
            this.f2221d = new RequestProgress(this.f2219b, this.f2220c);
            this.f2218a.put(this.f2220c, this.f2221d);
        }
        this.f2221d.m10224b(j);
        this.f2222e = (int) (this.f2222e + j);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        m10234a(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        m10234a(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        m10234a(1L);
    }
}
