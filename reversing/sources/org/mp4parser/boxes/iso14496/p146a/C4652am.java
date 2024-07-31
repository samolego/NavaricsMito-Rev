package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.am */
/* loaded from: classes2.dex */
public class TrackRunBox extends AbstractFullBox {

    /* renamed from: A */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11874A;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11875h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11876i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11877j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11878k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11879l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11880m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11881n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11882o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11883p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11884q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11885r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11886s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11887t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11888u;

    /* renamed from: v */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11889v;

    /* renamed from: w */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11890w;

    /* renamed from: x */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11891x;

    /* renamed from: y */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11892y;

    /* renamed from: z */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11893z;

    /* renamed from: a */
    private int f11894a;

    /* renamed from: b */
    private SampleFlags f11895b;

    /* renamed from: c */
    private List<C3121a> f11896c;

    static {
        m624i();
    }

    /* renamed from: i */
    private static /* synthetic */ void m624i() {
        C3105b c3105b = new C3105b("TrackRunBox.java", TrackRunBox.class);
        f11875h = c3105b.m794a("method-execution", c3105b.m795a("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "java.util.List"), 61);
        f11876i = c3105b.m794a("method-execution", c3105b.m795a("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "java.util.List", "entries", "", "void"), 65);
        f11885r = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleDurationPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 212);
        f11886s = c3105b.m794a("method-execution", c3105b.m795a("1", "isSampleFlagsPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 220);
        f11887t = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleFlagsPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 224);
        f11888u = c3105b.m794a("method-execution", c3105b.m795a("1", "isSampleCompositionTimeOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 232);
        f11889v = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleCompositionTimeOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 236);
        f11890w = c3105b.m794a("method-execution", c3105b.m795a("1", "getDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "int"), 245);
        f11891x = c3105b.m794a("method-execution", c3105b.m795a("1", "setDataOffset", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "int", "dataOffset", "", "void"), 249);
        f11892y = c3105b.m794a("method-execution", c3105b.m795a("1", "getFirstSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "org.mp4parser.boxes.iso14496.part12.SampleFlags"), 258);
        f11893z = c3105b.m794a("method-execution", c3105b.m795a("1", "setFirstSampleFlags", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "org.mp4parser.boxes.iso14496.part12.SampleFlags", "firstSampleFlags", "", "void"), 262);
        f11874A = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "java.lang.String"), 272);
        f11877j = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleCompositionTimeOffsets", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "[J"), 69);
        f11878k = c3105b.m794a("method-execution", c3105b.m795a("1", "getSampleCount", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "long"), 174);
        f11879l = c3105b.m794a("method-execution", c3105b.m795a("1", "isDataOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 178);
        f11880m = c3105b.m794a("method-execution", c3105b.m795a("1", "setDataOffsetPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 182);
        f11881n = c3105b.m794a("method-execution", c3105b.m795a("1", "isFirstSampleFlagsPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 190);
        f11882o = c3105b.m794a("method-execution", c3105b.m795a("1", "isSampleSizePresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 195);
        f11883p = c3105b.m794a("method-execution", c3105b.m795a("1", "setSampleSizePresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "boolean", "v", "", "void"), 199);
        f11884q = c3105b.m794a("method-execution", c3105b.m795a("1", "isSampleDurationPresent", "org.mp4parser.boxes.iso14496.part12.TrackRunBox", "", "", "", "boolean"), 207);
    }

    public TrackRunBox() {
        super("trun");
        this.f11896c = new ArrayList();
    }

    /* renamed from: a */
    public void m634a(List<C3121a> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11876i, this, this, list));
        this.f11896c = list;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        int q = m392q();
        long j = (q & 1) == 1 ? 12L : 8L;
        if ((q & 4) == 4) {
            j += 4;
        }
        long j2 = (q & 256) == 256 ? 4L : 0L;
        if ((q & 512) == 512) {
            j2 += 4;
        }
        if ((q & 1024) == 1024) {
            j2 += 4;
        }
        if ((q & 2048) == 2048) {
            j2 += 4;
        }
        return j + (j2 * this.f11896c.size());
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11896c.size());
        int q = m392q();
        if ((q & 1) == 1) {
            IsoTypeWriter.m720b(byteBuffer, this.f11894a);
        }
        if ((q & 4) == 4) {
            this.f11895b.m558a(byteBuffer);
        }
        for (C3121a c3121a : this.f11896c) {
            if ((q & 256) == 256) {
                IsoTypeWriter.m720b(byteBuffer, c3121a.f11897a);
            }
            if ((q & 512) == 512) {
                IsoTypeWriter.m720b(byteBuffer, c3121a.f11898b);
            }
            if ((q & 1024) == 1024) {
                c3121a.f11899c.m558a(byteBuffer);
            }
            if ((q & 2048) == 2048) {
                if (m393p() == 0) {
                    IsoTypeWriter.m720b(byteBuffer, c3121a.f11900d);
                } else {
                    byteBuffer.putInt((int) c3121a.f11900d);
                }
            }
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        long m738a = IsoTypeReader.m738a(byteBuffer);
        if ((m392q() & 1) == 1) {
            this.f11894a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        } else {
            this.f11894a = -1;
        }
        if ((m392q() & 4) == 4) {
            this.f11895b = new SampleFlags(byteBuffer);
        }
        for (int i = 0; i < m738a; i++) {
            C3121a c3121a = new C3121a();
            if ((m392q() & 256) == 256) {
                c3121a.f11897a = IsoTypeReader.m738a(byteBuffer);
            }
            if ((m392q() & 512) == 512) {
                c3121a.f11898b = IsoTypeReader.m738a(byteBuffer);
            }
            if ((m392q() & 1024) == 1024) {
                c3121a.f11899c = new SampleFlags(byteBuffer);
            }
            if ((m392q() & 2048) == 2048) {
                c3121a.f11900d = byteBuffer.getInt();
            }
            this.f11896c.add(c3121a);
        }
    }

    /* renamed from: d */
    public boolean m630d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11879l, this, this));
        return (m392q() & 1) == 1;
    }

    /* renamed from: e */
    public boolean m628e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11882o, this, this));
        return (m392q() & 512) == 512;
    }

    /* renamed from: a */
    public void m633a(boolean z) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11883p, this, this, Conversions.m802a(z)));
        if (z) {
            m397c(m392q() | 512);
        } else {
            m397c(m392q() & 16776703);
        }
    }

    /* renamed from: f */
    public boolean m627f() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11884q, this, this));
        return (m392q() & 256) == 256;
    }

    /* renamed from: b */
    public void m632b(boolean z) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11885r, this, this, Conversions.m802a(z)));
        if (z) {
            m397c(m392q() | 256);
        } else {
            m397c(m392q() & 16776959);
        }
    }

    /* renamed from: g */
    public boolean m626g() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11886s, this, this));
        return (m392q() & 1024) == 1024;
    }

    /* renamed from: c */
    public void m631c(boolean z) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11887t, this, this, Conversions.m802a(z)));
        if (z) {
            m397c(m392q() | 1024);
        } else {
            m397c(m392q() & 16776191);
        }
    }

    /* renamed from: h */
    public boolean m625h() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11888u, this, this));
        return (m392q() & 2048) == 2048;
    }

    /* renamed from: d */
    public void m629d(boolean z) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11889v, this, this, Conversions.m802a(z)));
        if (z) {
            m397c(m392q() | 2048);
        } else {
            m397c(m392q() & 16775167);
        }
    }

    /* renamed from: a */
    public void m635a(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11891x, this, this, Conversions.m804a(i)));
        if (i == -1) {
            m397c(m392q() & 16777214);
        } else {
            m397c(m392q() | 1);
        }
        this.f11894a = i;
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11874A, this, this));
        return "TrackRunBox{sampleCount=" + this.f11896c.size() + ", dataOffset=" + this.f11894a + ", dataOffsetPresent=" + m630d() + ", sampleSizePresent=" + m628e() + ", sampleDurationPresent=" + m627f() + ", sampleFlagsPresentPresent=" + m626g() + ", sampleCompositionTimeOffsetPresent=" + m625h() + ", firstSampleFlags=" + this.f11895b + '}';
    }

    /* compiled from: TrackRunBox.java */
    /* renamed from: org.mp4parser.boxes.iso14496.a.am$a */
    /* loaded from: classes2.dex */
    public static class C3121a {

        /* renamed from: a */
        private long f11897a;

        /* renamed from: b */
        private long f11898b;

        /* renamed from: c */
        private SampleFlags f11899c;

        /* renamed from: d */
        private long f11900d;

        /* renamed from: a */
        public void m622a(long j) {
            this.f11897a = j;
        }

        /* renamed from: b */
        public void m617b(long j) {
            this.f11898b = j;
        }

        /* renamed from: a */
        public void m618a(SampleFlags sampleFlags) {
            this.f11899c = sampleFlags;
        }

        /* renamed from: a */
        public void m623a(int i) {
            this.f11900d = i;
        }

        public String toString() {
            return "Entry{duration=" + this.f11897a + ", size=" + this.f11898b + ", dlags=" + this.f11899c + ", compTimeOffset=" + this.f11900d + '}';
        }
    }
}
