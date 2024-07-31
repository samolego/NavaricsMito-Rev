package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.aj */
/* loaded from: classes2.dex */
public class TrackFragmentHeaderBox extends AbstractFullBox {

    /* renamed from: A */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11779A;

    /* renamed from: B */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11780B;

    /* renamed from: C */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11781C;

    /* renamed from: D */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11782D;

    /* renamed from: E */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11783E;

    /* renamed from: F */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11784F;

    /* renamed from: G */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11785G;

    /* renamed from: H */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11786H;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11787m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11788n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11789o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11790p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11791q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11792r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11793s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11794t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11795u;

    /* renamed from: v */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11796v;

    /* renamed from: w */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11797w;

    /* renamed from: x */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11798x;

    /* renamed from: y */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11799y;

    /* renamed from: z */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11800z;

    /* renamed from: a */
    private long f11801a;

    /* renamed from: b */
    private long f11802b;

    /* renamed from: c */
    private long f11803c;

    /* renamed from: h */
    private long f11804h;

    /* renamed from: i */
    private long f11805i;

    /* renamed from: j */
    private SampleFlags f11806j;

    /* renamed from: k */
    private boolean f11807k;

    /* renamed from: l */
    private boolean f11808l;

    static {
        m662h();
    }

    /* renamed from: h */
    private static /* synthetic */ void m662h() {
        C3105b c3105b = new C3105b("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        f11787m = c3105b.m794a("method-execution", c3105b.m795a("1", "hasBaseDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 127);
        f11788n = c3105b.m794a("method-execution", c3105b.m795a("1", "hasSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 131);
        f11797w = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 172);
        f11798x = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 181);
        f11799y = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), 185);
        f11800z = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 190);
        f11779A = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), 194);
        f11780B = c3105b.m794a("method-execution", c3105b.m795a("1", "getDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "org.mp4parser.boxes.iso14496.part12.SampleFlags"), 199);
        f11781C = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "org.mp4parser.boxes.iso14496.part12.SampleFlags", "defaultSampleFlags", "", "void"), 203);
        f11782D = c3105b.m794a("method-execution", c3105b.m795a("1", "isDurationIsEmpty", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 208);
        f11783E = c3105b.m794a("method-execution", c3105b.m795a("1", "setDurationIsEmpty", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), 212);
        f11784F = c3105b.m794a("method-execution", c3105b.m795a("1", "isDefaultBaseIsMoof", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 217);
        f11789o = c3105b.m794a("method-execution", c3105b.m795a("1", "hasDefaultSampleDuration", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 135);
        f11785G = c3105b.m794a("method-execution", c3105b.m795a("1", "setDefaultBaseIsMoof", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), 221);
        f11786H = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 227);
        f11790p = c3105b.m794a("method-execution", c3105b.m795a("1", "hasDefaultSampleSize", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 139);
        f11791q = c3105b.m794a("method-execution", c3105b.m795a("1", "hasDefaultSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "boolean"), 143);
        f11792r = c3105b.m794a("method-execution", c3105b.m795a("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 147);
        f11793s = c3105b.m794a("method-execution", c3105b.m795a("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "trackId", "", "void"), 151);
        f11794t = c3105b.m794a("method-execution", c3105b.m795a("1", "getBaseDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 155);
        f11795u = c3105b.m794a("method-execution", c3105b.m795a("1", "setBaseDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 159);
        f11796v = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleDescriptionIndex", "org.mp4parser.boxes.iso14496.part12.TrackFragmentHeaderBox", "", "", "", "long"), 168);
    }

    public TrackFragmentHeaderBox() {
        super("tfhd");
        this.f11802b = -1L;
        this.f11804h = -1L;
        this.f11805i = -1L;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        int q = m392q();
        long j = (q & 1) == 1 ? 16L : 8L;
        if ((q & 2) == 2) {
            j += 4;
        }
        if ((q & 8) == 8) {
            j += 4;
        }
        if ((q & 16) == 16) {
            j += 4;
        }
        return (q & 32) == 32 ? j + 4 : j;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11801a);
        if ((m392q() & 1) == 1) {
            IsoTypeWriter.m724a(byteBuffer, m666d());
        }
        if ((m392q() & 2) == 2) {
            IsoTypeWriter.m720b(byteBuffer, m665e());
        }
        if ((m392q() & 8) == 8) {
            IsoTypeWriter.m720b(byteBuffer, m664f());
        }
        if ((m392q() & 16) == 16) {
            IsoTypeWriter.m720b(byteBuffer, m663g());
        }
        if ((m392q() & 32) == 32) {
            this.f11806j.m558a(byteBuffer);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11801a = IsoTypeReader.m738a(byteBuffer);
        if ((m392q() & 1) == 1) {
            this.f11802b = IsoTypeReader.m733e(byteBuffer);
        }
        if ((m392q() & 2) == 2) {
            this.f11803c = IsoTypeReader.m738a(byteBuffer);
        }
        if ((m392q() & 8) == 8) {
            this.f11804h = IsoTypeReader.m738a(byteBuffer);
        }
        if ((m392q() & 16) == 16) {
            this.f11805i = IsoTypeReader.m738a(byteBuffer);
        }
        if ((m392q() & 32) == 32) {
            this.f11806j = new SampleFlags(byteBuffer);
        }
        if ((m392q() & 65536) == 65536) {
            this.f11807k = true;
        }
        if ((m392q() & 131072) == 131072) {
            this.f11808l = true;
        }
    }

    /* renamed from: a */
    public void m670a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11793s, this, this, Conversions.m803a(j)));
        this.f11801a = j;
    }

    /* renamed from: d */
    public long m666d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11794t, this, this));
        return this.f11802b;
    }

    /* renamed from: b */
    public void m667b(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11795u, this, this, Conversions.m803a(j)));
        if (j == -1) {
            m397c(m392q() & 2147483646);
        } else {
            m397c(m392q() | 1);
        }
        this.f11802b = j;
    }

    /* renamed from: e */
    public long m665e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11796v, this, this));
        return this.f11803c;
    }

    /* renamed from: f */
    public long m664f() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11798x, this, this));
        return this.f11804h;
    }

    /* renamed from: g */
    public long m663g() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11800z, this, this));
        return this.f11805i;
    }

    /* renamed from: a */
    public void m669a(SampleFlags sampleFlags) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11781C, this, this, sampleFlags));
        m397c(m392q() | 32);
        this.f11806j = sampleFlags;
    }

    /* renamed from: a */
    public void m668a(boolean z) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11785G, this, this, Conversions.m802a(z)));
        m397c(m392q() | 131072);
        this.f11808l = z;
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11786H, this, this));
        return "TrackFragmentHeaderBox{trackId=" + this.f11801a + ", baseDataOffset=" + this.f11802b + ", sampleDescriptionIndex=" + this.f11803c + ", defaultSampleDuration=" + this.f11804h + ", defaultSampleSize=" + this.f11805i + ", defaultSampleFlags=" + this.f11806j + ", durationIsEmpty=" + this.f11807k + ", defaultBaseIsMoof=" + this.f11808l + '}';
    }
}
