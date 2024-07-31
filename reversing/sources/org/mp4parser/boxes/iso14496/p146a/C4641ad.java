package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ad */
/* loaded from: classes2.dex */
public class SyncSampleBox extends AbstractFullBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11747b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11748c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11749h;

    /* renamed from: a */
    private long[] f11750a;

    static {
        m685e();
    }

    /* renamed from: e */
    private static /* synthetic */ void m685e() {
        C3105b c3105b = new C3105b("SyncSampleBox.java", SyncSampleBox.class);
        f11747b = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleNumber", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "", "", "", "[J"), 46);
        f11748c = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleNumber", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "[J", "sampleNumber", "", "void"), 50);
        f11749h = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.SyncSampleBox", "", "", "", "java.lang.String"), 81);
    }

    public SyncSampleBox() {
        super("stss");
    }

    /* renamed from: d */
    public long[] m686d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11747b, this, this));
        return this.f11750a;
    }

    /* renamed from: a */
    public void m687a(long[] jArr) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11748c, this, this, jArr));
        this.f11750a = jArr;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f11750a.length * 4) + 8;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        int m743a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        this.f11750a = new long[m743a];
        for (int i = 0; i < m743a; i++) {
            this.f11750a[i] = IsoTypeReader.m738a(byteBuffer);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11750a.length);
        for (long j : this.f11750a) {
            IsoTypeWriter.m720b(byteBuffer, j);
        }
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11749h, this, this));
        return "SyncSampleBox[entryCount=" + this.f11750a.length + "]";
    }
}
