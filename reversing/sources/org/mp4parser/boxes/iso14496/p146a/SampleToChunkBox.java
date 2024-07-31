package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.z */
/* loaded from: classes2.dex */
public class SampleToChunkBox extends AbstractFullBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12041b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12042c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12043h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12044i;

    /* renamed from: a */
    List<C3123a> f12045a;

    static {
        m545e();
    }

    /* renamed from: e */
    private static /* synthetic */ void m545e() {
        C3105b c3105b = new C3105b("SampleToChunkBox.java", SampleToChunkBox.class);
        f12041b = c3105b.m794a("method-execution", c3105b.m795a("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "", "", "", "java.util.List"), 42);
        f12042c = c3105b.m794a("method-execution", c3105b.m795a("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "java.util.List", "entries", "", "void"), 46);
        f12043h = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "", "", "", "java.lang.String"), 79);
        f12044i = c3105b.m794a("method-execution", c3105b.m795a("1", "blowup", "org.mp4parser.boxes.iso14496.part12.SampleToChunkBox", "int", "chunkCount", "", "[J"), 90);
    }

    public SampleToChunkBox() {
        super("stsc");
        this.f12045a = Collections.emptyList();
    }

    /* renamed from: d */
    public List<C3123a> m546d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12041b, this, this));
        return this.f12045a;
    }

    /* renamed from: a */
    public void m547a(List<C3123a> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12042c, this, this, list));
        this.f12045a = list;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f12045a.size() * 12) + 8;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        int m743a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        this.f12045a = new ArrayList(m743a);
        for (int i = 0; i < m743a; i++) {
            this.f12045a.add(new C3123a(IsoTypeReader.m738a(byteBuffer), IsoTypeReader.m738a(byteBuffer), IsoTypeReader.m738a(byteBuffer)));
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f12045a.size());
        for (C3123a c3123a : this.f12045a) {
            IsoTypeWriter.m720b(byteBuffer, c3123a.m544a());
            IsoTypeWriter.m720b(byteBuffer, c3123a.m543b());
            IsoTypeWriter.m720b(byteBuffer, c3123a.m542c());
        }
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12043h, this, this));
        return "SampleToChunkBox[entryCount=" + this.f12045a.size() + "]";
    }

    /* compiled from: SampleToChunkBox.java */
    /* renamed from: org.mp4parser.boxes.iso14496.a.z$a */
    /* loaded from: classes2.dex */
    public static class C3123a {

        /* renamed from: a */
        long f12046a;

        /* renamed from: b */
        long f12047b;

        /* renamed from: c */
        long f12048c;

        public C3123a(long j, long j2, long j3) {
            this.f12046a = j;
            this.f12047b = j2;
            this.f12048c = j3;
        }

        /* renamed from: a */
        public long m544a() {
            return this.f12046a;
        }

        /* renamed from: b */
        public long m543b() {
            return this.f12047b;
        }

        /* renamed from: c */
        public long m542c() {
            return this.f12048c;
        }

        public String toString() {
            return "Entry{firstChunk=" + this.f12046a + ", samplesPerChunk=" + this.f12047b + ", sampleDescriptionIndex=" + this.f12048c + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C3123a c3123a = (C3123a) obj;
            return this.f12046a == c3123a.f12046a && this.f12048c == c3123a.f12048c && this.f12047b == c3123a.f12047b;
        }

        public int hashCode() {
            long j = this.f12046a;
            long j2 = this.f12047b;
            long j3 = this.f12048c;
            return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }
}
