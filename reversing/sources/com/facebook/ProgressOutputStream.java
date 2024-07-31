package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.n */
/* loaded from: classes.dex */
public class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {

    /* renamed from: a */
    private final Map<GraphRequest, RequestProgress> f2223a;

    /* renamed from: b */
    private final GraphRequestBatch f2224b;

    /* renamed from: c */
    private final long f2225c;

    /* renamed from: d */
    private long f2226d;

    /* renamed from: e */
    private long f2227e;

    /* renamed from: f */
    private long f2228f;

    /* renamed from: g */
    private RequestProgress f2229g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        this.f2224b = graphRequestBatch;
        this.f2223a = map;
        this.f2228f = j;
        this.f2225c = FacebookSdk.m10866k();
    }

    /* renamed from: a */
    private void m10231a(long j) {
        RequestProgress requestProgress = this.f2229g;
        if (requestProgress != null) {
            requestProgress.m10225a(j);
        }
        this.f2226d += j;
        long j2 = this.f2226d;
        if (j2 >= this.f2227e + this.f2225c || j2 >= this.f2228f) {
            m10232a();
        }
    }

    /* renamed from: a */
    private void m10232a() {
        if (this.f2226d > this.f2227e) {
            for (GraphRequestBatch.InterfaceC0919a interfaceC0919a : this.f2224b.m10838e()) {
                if (interfaceC0919a instanceof GraphRequestBatch.InterfaceC0920b) {
                    Handler m10840c = this.f2224b.m10840c();
                    final GraphRequestBatch.InterfaceC0920b interfaceC0920b = (GraphRequestBatch.InterfaceC0920b) interfaceC0919a;
                    if (m10840c == null) {
                        interfaceC0920b.m10832a(this.f2224b, this.f2226d, this.f2228f);
                    } else {
                        m10840c.post(new Runnable() { // from class: com.facebook.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                interfaceC0920b.m10832a(ProgressOutputStream.this.f2224b, ProgressOutputStream.this.f2226d, ProgressOutputStream.this.f2228f);
                            }
                        });
                    }
                }
            }
            this.f2227e = this.f2226d;
        }
    }

    @Override // com.facebook.RequestOutputStream
    /* renamed from: a */
    public void mo10227a(GraphRequest graphRequest) {
        this.f2229g = graphRequest != null ? this.f2223a.get(graphRequest) : null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        m10231a(bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        m10231a(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        m10231a(1L);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        for (RequestProgress requestProgress : this.f2223a.values()) {
            requestProgress.m10226a();
        }
        m10232a();
    }
}
