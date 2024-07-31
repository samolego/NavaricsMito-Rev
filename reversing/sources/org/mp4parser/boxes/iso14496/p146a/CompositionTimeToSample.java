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

/* renamed from: org.mp4parser.boxes.iso14496.a.c */
/* loaded from: classes2.dex */
public class CompositionTimeToSample extends AbstractFullBox {

    /* renamed from: b */
    static final /* synthetic */ boolean f11909b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11910c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11911h;

    /* renamed from: a */
    List<C3122a> f11912a;

    /* renamed from: e */
    private static /* synthetic */ void m603e() {
        C3105b c3105b = new C3105b("CompositionTimeToSample.java", CompositionTimeToSample.class);
        f11910c = c3105b.m794a("method-execution", c3105b.m795a("1", "getEntries", "org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample", "", "", "", "java.util.List"), 83);
        f11911h = c3105b.m794a("method-execution", c3105b.m795a("1", "setEntries", "org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 87);
    }

    static {
        m603e();
        f11909b = !CompositionTimeToSample.class.desiredAssertionStatus();
    }

    public CompositionTimeToSample() {
        super("ctts");
        this.f11912a = Collections.emptyList();
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f11912a.size() * 8) + 8;
    }

    /* renamed from: d */
    public List<C3122a> m604d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11910c, this, this));
        return this.f11912a;
    }

    /* renamed from: a */
    public void m605a(List<C3122a> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11911h, this, this, list));
        this.f11912a = list;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        int m743a = CastUtils.m743a(IsoTypeReader.m738a(byteBuffer));
        this.f11912a = new ArrayList(m743a);
        for (int i = 0; i < m743a; i++) {
            this.f11912a.add(new C3122a(CastUtils.m743a(IsoTypeReader.m738a(byteBuffer)), byteBuffer.getInt()));
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11912a.size());
        for (C3122a c3122a : this.f11912a) {
            IsoTypeWriter.m720b(byteBuffer, c3122a.m602a());
            byteBuffer.putInt(c3122a.m601b());
        }
    }

    /* compiled from: CompositionTimeToSample.java */
    /* renamed from: org.mp4parser.boxes.iso14496.a.c$a */
    /* loaded from: classes2.dex */
    public static class C3122a {

        /* renamed from: a */
        int f11913a;

        /* renamed from: b */
        int f11914b;

        public C3122a(int i, int i2) {
            this.f11913a = i;
            this.f11914b = i2;
        }

        /* renamed from: a */
        public int m602a() {
            return this.f11913a;
        }

        /* renamed from: b */
        public int m601b() {
            return this.f11914b;
        }

        public String toString() {
            return "Entry{count=" + this.f11913a + ", offset=" + this.f11914b + '}';
        }
    }
}
