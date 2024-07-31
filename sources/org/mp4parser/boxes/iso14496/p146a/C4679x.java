package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.x */
/* loaded from: classes2.dex */
public class SampleSizeBox extends AbstractFullBox {

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12031h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12032i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12033j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12034k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12035l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12036m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12037n;

    /* renamed from: a */
    int f12038a;

    /* renamed from: b */
    private long f12039b;

    /* renamed from: c */
    private long[] f12040c;

    static {
        m548g();
    }

    /* renamed from: g */
    private static /* synthetic */ void m548g() {
        C3105b c3105b = new C3105b("SampleSizeBox.java", SampleSizeBox.class);
        f12031h = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleSize", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "long"), 50);
        f12032i = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleSize", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        f12033j = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleSizeAtIndex", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "int", "index", "", "long"), 59);
        f12034k = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "long"), 67);
        f12035l = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleSizes", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "[J"), 76);
        f12036m = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleSizes", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        f12037n = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    public SampleSizeBox() {
        super("stsz");
        this.f12040c = new long[0];
    }

    /* renamed from: d */
    public long m551d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12031h, this, this));
        return this.f12039b;
    }

    /* renamed from: e */
    public long m550e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12034k, this, this));
        if (this.f12039b > 0) {
            return this.f12038a;
        }
        return this.f12040c.length;
    }

    /* renamed from: f */
    public long[] m549f() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12035l, this, this));
        return this.f12040c;
    }

    /* renamed from: a */
    public void m552a(long[] jArr) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12036m, this, this, jArr));
        this.f12040c = jArr;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f12039b == 0 ? this.f12040c.length * 4 : 0) + 12;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f12039b = IsoTypeReader.m738a(byteBuffer);
        this.f12038a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        if (this.f12039b == 0) {
            this.f12040c = new long[this.f12038a];
            for (int i = 0; i < this.f12038a; i++) {
                this.f12040c[i] = IsoTypeReader.m738a(byteBuffer);
            }
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f12039b);
        if (this.f12039b == 0) {
            IsoTypeWriter.m720b(byteBuffer, this.f12040c.length);
            for (long j : this.f12040c) {
                IsoTypeWriter.m720b(byteBuffer, j);
            }
            return;
        }
        IsoTypeWriter.m720b(byteBuffer, this.f12038a);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12037n, this, this));
        return "SampleSizeBox[sampleSize=" + m551d() + ";sampleCount=" + m550e() + "]";
    }
}
