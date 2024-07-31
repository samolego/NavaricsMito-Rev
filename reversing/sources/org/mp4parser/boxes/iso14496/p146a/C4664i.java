package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.i */
/* loaded from: classes2.dex */
public class HintMediaHeaderBox extends AbstractMediaHeaderBox {

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11941i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11942j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11943k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11944l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11945m;

    /* renamed from: a */
    private int f11946a;

    /* renamed from: b */
    private int f11947b;

    /* renamed from: c */
    private long f11948c;

    /* renamed from: h */
    private long f11949h;

    static {
        m592d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m592d() {
        C3105b c3105b = new C3105b("HintMediaHeaderBox.java", HintMediaHeaderBox.class);
        f11941i = c3105b.m794a("method-execution", c3105b.m795a("1", "getMaxPduSize", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "int"), 43);
        f11942j = c3105b.m794a("method-execution", c3105b.m795a("1", "getAvgPduSize", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "int"), 47);
        f11943k = c3105b.m794a("method-execution", c3105b.m795a("1", "getMaxBitrate", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "long"), 51);
        f11944l = c3105b.m794a("method-execution", c3105b.m795a("1", "getAvgBitrate", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "long"), 55);
        f11945m = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.HintMediaHeaderBox", "", "", "", "java.lang.String"), 85);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 20L;
    }

    public HintMediaHeaderBox() {
        super("hmhd");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11946a = IsoTypeReader.m735c(byteBuffer);
        this.f11947b = IsoTypeReader.m735c(byteBuffer);
        this.f11948c = IsoTypeReader.m738a(byteBuffer);
        this.f11949h = IsoTypeReader.m738a(byteBuffer);
        IsoTypeReader.m738a(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m721b(byteBuffer, this.f11946a);
        IsoTypeWriter.m721b(byteBuffer, this.f11947b);
        IsoTypeWriter.m720b(byteBuffer, this.f11948c);
        IsoTypeWriter.m720b(byteBuffer, this.f11949h);
        IsoTypeWriter.m720b(byteBuffer, 0L);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11945m, this, this));
        return "HintMediaHeaderBox{maxPduSize=" + this.f11946a + ", avgPduSize=" + this.f11947b + ", maxBitrate=" + this.f11948c + ", avgBitrate=" + this.f11949h + '}';
    }
}
