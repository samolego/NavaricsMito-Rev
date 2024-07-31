package org.apache.mina.core.p119b;

import java.nio.channels.FileChannel;

/* compiled from: DefaultFileRegion.java */
/* renamed from: org.apache.mina.core.b.a, reason: use source file name */
/* loaded from: classes2.dex */
public class DefaultFileRegion implements InterfaceC3269b {

    /* renamed from: a */
    private final FileChannel f11367a;

    /* renamed from: b */
    private final long f11368b;

    /* renamed from: c */
    private long f11369c;

    /* renamed from: d */
    private long f11370d;

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
        this.f11367a = fileChannel;
        this.f11368b = j;
        this.f11369c = j;
        this.f11370d = j2;
    }

    @Override // org.apache.mina.core.p119b.InterfaceC3269b
    /* renamed from: a */
    public long mo11547a() {
        return this.f11370d;
    }

    @Override // org.apache.mina.core.p119b.InterfaceC3269b
    /* renamed from: b */
    public FileChannel mo11549b() {
        return this.f11367a;
    }

    @Override // org.apache.mina.core.p119b.InterfaceC3269b
    /* renamed from: c */
    public long mo11550c() {
        return this.f11369c;
    }

    @Override // org.apache.mina.core.p119b.InterfaceC3269b
    /* renamed from: a */
    public void mo11548a(long j) {
        this.f11369c += j;
        this.f11370d -= j;
    }
}