package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeReaderVariable;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.p144a.IsoTypeWriterVariable;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ak */
/* loaded from: classes2.dex */
public class TrackFragmentRandomAccessBox extends AbstractFullBox {

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11809k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11810l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11811m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11812n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11813o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11814p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11815q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11816r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11817s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11818t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11819u;

    /* renamed from: v */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11820v;

    /* renamed from: w */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11821w;

    /* renamed from: a */
    private long f11822a;

    /* renamed from: b */
    private int f11823b;

    /* renamed from: c */
    private int f11824c;

    /* renamed from: h */
    private int f11825h;

    /* renamed from: i */
    private int f11826i;

    /* renamed from: j */
    private List<C3120a> f11827j;

    static {
        m659d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m659d() {
        C3105b c3105b = new C3105b("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        f11809k = c3105b.m794a("method-execution", c3105b.m795a("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "long"), 127);
        f11810l = c3105b.m794a("method-execution", c3105b.m795a("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 131);
        f11819u = c3105b.m794a("method-execution", c3105b.m795a("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 167);
        f11820v = c3105b.m794a("method-execution", c3105b.m795a("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 171);
        f11821w = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 176);
        f11811m = c3105b.m794a("method-execution", c3105b.m795a("1", "getReserved", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 135);
        f11812n = c3105b.m794a("method-execution", c3105b.m795a("1", "getLengthSizeOfTrafNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 139);
        f11813o = c3105b.m794a("method-execution", c3105b.m795a("1", "setLengthSizeOfTrafNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 143);
        f11814p = c3105b.m794a("method-execution", c3105b.m795a("1", "getLengthSizeOfTrunNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 147);
        f11815q = c3105b.m794a("method-execution", c3105b.m795a("1", "setLengthSizeOfTrunNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 151);
        f11816r = c3105b.m794a("method-execution", c3105b.m795a("1", "getLengthSizeOfSampleNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "int"), 155);
        f11817s = c3105b.m794a("method-execution", c3105b.m795a("1", "setLengthSizeOfSampleNum", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 159);
        f11818t = c3105b.m794a("method-execution", c3105b.m795a("1", "getNumberOfEntries", "org.mp4parser.boxes.iso14496.part12.TrackFragmentRandomAccessBox", "", "", "", "long"), 163);
    }

    public TrackFragmentRandomAccessBox() {
        super("tfra");
        this.f11824c = 2;
        this.f11825h = 2;
        this.f11826i = 2;
        this.f11827j = Collections.emptyList();
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        long size;
        if (m393p() == 1) {
            size = 16 + (this.f11827j.size() * 16);
        } else {
            size = 16 + (this.f11827j.size() * 8);
        }
        return size + (this.f11824c * this.f11827j.size()) + (this.f11825h * this.f11827j.size()) + (this.f11826i * this.f11827j.size());
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11822a = IsoTypeReader.m738a(byteBuffer);
        long m738a = IsoTypeReader.m738a(byteBuffer);
        this.f11823b = (int) (m738a >> 6);
        this.f11824c = (((int) (63 & m738a)) >> 4) + 1;
        this.f11825h = (((int) (12 & m738a)) >> 2) + 1;
        this.f11826i = ((int) (m738a & 3)) + 1;
        long m738a2 = IsoTypeReader.m738a(byteBuffer);
        this.f11827j = new ArrayList();
        for (int i = 0; i < m738a2; i++) {
            C3120a c3120a = new C3120a();
            if (m393p() == 1) {
                c3120a.f11828a = IsoTypeReader.m733e(byteBuffer);
                c3120a.f11829b = IsoTypeReader.m733e(byteBuffer);
            } else {
                c3120a.f11828a = IsoTypeReader.m738a(byteBuffer);
                c3120a.f11829b = IsoTypeReader.m738a(byteBuffer);
            }
            c3120a.f11830c = IsoTypeReaderVariable.m727a(byteBuffer, this.f11824c);
            c3120a.f11831d = IsoTypeReaderVariable.m727a(byteBuffer, this.f11825h);
            c3120a.f11832e = IsoTypeReaderVariable.m727a(byteBuffer, this.f11826i);
            this.f11827j.add(c3120a);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11822a);
        IsoTypeWriter.m720b(byteBuffer, (this.f11823b << 6) | (((this.f11824c - 1) & 3) << 4) | (((this.f11825h - 1) & 3) << 2) | ((this.f11826i - 1) & 3));
        IsoTypeWriter.m720b(byteBuffer, this.f11827j.size());
        for (C3120a c3120a : this.f11827j) {
            if (m393p() == 1) {
                IsoTypeWriter.m724a(byteBuffer, c3120a.f11828a);
                IsoTypeWriter.m724a(byteBuffer, c3120a.f11829b);
            } else {
                IsoTypeWriter.m720b(byteBuffer, c3120a.f11828a);
                IsoTypeWriter.m720b(byteBuffer, c3120a.f11829b);
            }
            IsoTypeWriterVariable.m717a(c3120a.f11830c, byteBuffer, this.f11824c);
            IsoTypeWriterVariable.m717a(c3120a.f11831d, byteBuffer, this.f11825h);
            IsoTypeWriterVariable.m717a(c3120a.f11832e, byteBuffer, this.f11826i);
        }
    }

    /* renamed from: a */
    public void m661a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11810l, this, this, Conversions.m803a(j)));
        this.f11822a = j;
    }

    /* renamed from: a */
    public void m660a(List<C3120a> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11820v, this, this, list));
        this.f11827j = list;
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11821w, this, this));
        return "TrackFragmentRandomAccessBox{trackId=" + this.f11822a + ", entries=" + this.f11827j + '}';
    }

    /* compiled from: TrackFragmentRandomAccessBox.java */
    /* renamed from: org.mp4parser.boxes.iso14496.a.ak$a */
    /* loaded from: classes2.dex */
    public static class C3120a {

        /* renamed from: a */
        private long f11828a;

        /* renamed from: b */
        private long f11829b;

        /* renamed from: c */
        private long f11830c;

        /* renamed from: d */
        private long f11831d;

        /* renamed from: e */
        private long f11832e;

        public C3120a() {
        }

        public C3120a(long j, long j2, long j3, long j4, long j5) {
            this.f11829b = j2;
            this.f11832e = j5;
            this.f11828a = j;
            this.f11830c = j3;
            this.f11831d = j4;
        }

        public String toString() {
            return "Entry{time=" + this.f11828a + ", moofOffset=" + this.f11829b + ", trafNumber=" + this.f11830c + ", trunNumber=" + this.f11831d + ", sampleNumber=" + this.f11832e + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C3120a c3120a = (C3120a) obj;
            return this.f11829b == c3120a.f11829b && this.f11832e == c3120a.f11832e && this.f11828a == c3120a.f11828a && this.f11830c == c3120a.f11830c && this.f11831d == c3120a.f11831d;
        }

        public int hashCode() {
            long j = this.f11828a;
            long j2 = this.f11829b;
            long j3 = this.f11830c;
            long j4 = this.f11831d;
            long j5 = this.f11832e;
            return (((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }
    }
}
