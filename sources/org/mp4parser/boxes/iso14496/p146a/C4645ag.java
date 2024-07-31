package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ag */
/* loaded from: classes2.dex */
public class TrackExtendsBox extends AbstractFullBox {

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11759j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11760k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11761l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11762m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11763n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11764o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11765p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11766q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11767r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11768s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11769t;

    /* renamed from: a */
    private long f11770a;

    /* renamed from: b */
    private long f11771b;

    /* renamed from: c */
    private long f11772c;

    /* renamed from: h */
    private long f11773h;

    /* renamed from: i */
    private SampleFlags f11774i;

    static {
        m674d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m674d() {
        C3105b c3105b = new C3105b("TrackExtendsBox.java", TrackExtendsBox.class);
        f11759j = c3105b.m794a("method-execution", c3105b.m795a("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 73);
        f11760k = c3105b.m794a("method-execution", c3105b.m795a("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "trackId", "", "void"), 77);
        f11769t = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleFlagsStr", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "java.lang.String"), 114);
        f11761l = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 81);
        f11762m = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "defaultSampleDescriptionIndex", "", "void"), 85);
        f11763n = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 89);
        f11764o = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "defaultSampleDuration", "", "void"), 93);
        f11765p = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "long"), 97);
        f11766q = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "long", "defaultSampleSize", "", "void"), 101);
        f11767r = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "", "", "", "org.mp4parser.boxes.iso14496.part12.SampleFlags"), 105);
        f11768s = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackExtendsBox", "org.mp4parser.boxes.iso14496.part12.SampleFlags", "defaultSampleFlags", "", "void"), 109);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 24L;
    }

    public TrackExtendsBox() {
        super("trex");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11770a);
        IsoTypeWriter.m720b(byteBuffer, this.f11771b);
        IsoTypeWriter.m720b(byteBuffer, this.f11772c);
        IsoTypeWriter.m720b(byteBuffer, this.f11773h);
        this.f11774i.m558a(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11770a = IsoTypeReader.m738a(byteBuffer);
        this.f11771b = IsoTypeReader.m738a(byteBuffer);
        this.f11772c = IsoTypeReader.m738a(byteBuffer);
        this.f11773h = IsoTypeReader.m738a(byteBuffer);
        this.f11774i = new SampleFlags(byteBuffer);
    }

    /* renamed from: a */
    public void m678a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11760k, this, this, Conversions.m803a(j)));
        this.f11770a = j;
    }

    /* renamed from: b */
    public void m676b(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11762m, this, this, Conversions.m803a(j)));
        this.f11771b = j;
    }

    /* renamed from: c */
    public void m675c(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11764o, this, this, Conversions.m803a(j)));
        this.f11772c = j;
    }

    /* renamed from: d */
    public void m673d(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11766q, this, this, Conversions.m803a(j)));
        this.f11773h = j;
    }

    /* renamed from: a */
    public void m677a(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11768s, this, this, sampleFlags));
        this.f11774i = sampleFlags;
    }
}
