package org.mp4parser.boxes.iso14496.p146a;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.CastUtils;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ae */
/* loaded from: classes2.dex */
public class TimeToSampleBox extends AbstractFullBox {

    /* renamed from: a */
    static Map<List<C3119a>, SoftReference<long[]>> f11751a;

    /* renamed from: c */
    static final /* synthetic */ boolean f11752c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11753h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11754i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11755j;

    /* renamed from: b */
    List<C3119a> f11756b;

    /* renamed from: e */
    private static /* synthetic */ void m682e() {
        C3105b c3105b = new C3105b("TimeToSampleBox.java", TimeToSampleBox.class);
        f11753h = c3105b.m794a("method-execution", c3105b.m795a("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "", "", "", "java.util.List"), 112);
        f11754i = c3105b.m794a("method-execution", c3105b.m795a("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "java.util.List", "entries", "", "void"), 116);
        f11755j = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.TimeToSampleBox", "", "", "", "java.lang.String"), 120);
    }

    static {
        m682e();
        f11752c = !TimeToSampleBox.class.desiredAssertionStatus();
        f11751a = new WeakHashMap();
    }

    public TimeToSampleBox() {
        super("stts");
        this.f11756b = Collections.emptyList();
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f11756b.size() * 8) + 8;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        int m743a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        this.f11756b = new ArrayList(m743a);
        for (int i = 0; i < m743a; i++) {
            this.f11756b.add(new C3119a(IsoTypeReader.m738a(byteBuffer), IsoTypeReader.m738a(byteBuffer)));
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11756b.size());
        for (C3119a c3119a : this.f11756b) {
            IsoTypeWriter.m720b(byteBuffer, c3119a.m681a());
            IsoTypeWriter.m720b(byteBuffer, c3119a.m679b());
        }
    }

    /* renamed from: d */
    public List<C3119a> m683d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11753h, this, this));
        return this.f11756b;
    }

    /* renamed from: a */
    public void m684a(List<C3119a> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11754i, this, this, list));
        this.f11756b = list;
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11755j, this, this));
        return "TimeToSampleBox[entryCount=" + this.f11756b.size() + "]";
    }

    /* compiled from: TimeToSampleBox.java */
    /* renamed from: org.mp4parser.boxes.iso14496.a.ae$a */
    /* loaded from: classes2.dex */
    public static class C3119a {

        /* renamed from: a */
        long f11757a;

        /* renamed from: b */
        long f11758b;

        public C3119a(long j, long j2) {
            this.f11757a = j;
            this.f11758b = j2;
        }

        /* renamed from: a */
        public long m681a() {
            return this.f11757a;
        }

        /* renamed from: a */
        public void m680a(long j) {
            this.f11757a = j;
        }

        /* renamed from: b */
        public long m679b() {
            return this.f11758b;
        }

        public String toString() {
            return "Entry{count=" + this.f11757a + ", delta=" + this.f11758b + '}';
        }
    }
}
