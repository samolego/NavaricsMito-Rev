package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ab */
/* loaded from: classes2.dex */
public class StaticChunkOffsetBox extends ChunkOffsetBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11743b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11744c;

    /* renamed from: a */
    private long[] f11745a;

    static {
        m689d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m689d() {
        C3105b c3105b = new C3105b("StaticChunkOffsetBox.java", StaticChunkOffsetBox.class);
        f11743b = c3105b.m794a("method-execution", c3105b.m795a("1", "getChunkOffsets", "org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        f11744c = c3105b.m794a("method-execution", c3105b.m795a("1", "setChunkOffsets", "org.mp4parser.boxes.iso14496.part12.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 44);
    }

    public StaticChunkOffsetBox() {
        super("stco");
        this.f11745a = new long[0];
    }

    @Override // org.mp4parser.boxes.iso14496.p146a.ChunkOffsetBox
    /* renamed from: c */
    public long[] mo607c() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11743b, this, this));
        return this.f11745a;
    }

    @Override // org.mp4parser.boxes.iso14496.p146a.ChunkOffsetBox
    /* renamed from: a */
    public void mo608a(long[] jArr) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11744c, this, this, jArr));
        this.f11745a = jArr;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f11745a.length * 4) + 8;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        int m743a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        this.f11745a = new long[m743a];
        for (int i = 0; i < m743a; i++) {
            this.f11745a[i] = IsoTypeReader.m738a(byteBuffer);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11745a.length);
        for (long j : this.f11745a) {
            IsoTypeWriter.m720b(byteBuffer, j);
        }
    }
}
