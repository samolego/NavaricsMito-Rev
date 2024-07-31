package org.apache.mina.core.p130b;

import java.nio.channels.FileChannel;

/* renamed from: org.apache.mina.core.b.a */
/* loaded from: classes2.dex */
public class DefaultFileRegion implements FileRegion {

    /* renamed from: a */
    private final FileChannel f11326a;

    /* renamed from: b */
    private final long f11327b;

    /* renamed from: c */
    private long f11328c;

    /* renamed from: d */
    private long f11329d;

    public DefaultFileRegion(FileChannel fileChannel, long j, long j2) {
        if (fileChannel == null) {
            throw new IllegalArgumentException("channel can not be null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("position may not be less than 0");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("remainingBytes may not be less than 0");
        }
        this.f11326a = fileChannel;
        this.f11327b = j;
        this.f11328c = j;
        this.f11329d = j2;
    }

    @Override // org.apache.mina.core.p130b.FileRegion
    /* renamed from: a */
    public long mo1340a() {
        return this.f11329d;
    }

    @Override // org.apache.mina.core.p130b.FileRegion
    /* renamed from: b */
    public FileChannel mo1338b() {
        return this.f11326a;
    }

    @Override // org.apache.mina.core.p130b.FileRegion
    /* renamed from: c */
    public long mo1337c() {
        return this.f11328c;
    }

    @Override // org.apache.mina.core.p130b.FileRegion
    /* renamed from: a */
    public void mo1339a(long j) {
        this.f11328c += j;
        this.f11329d -= j;
    }
}
