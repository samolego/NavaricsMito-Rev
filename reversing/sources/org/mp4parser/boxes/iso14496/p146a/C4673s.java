package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.s */
/* loaded from: classes2.dex */
public class MovieFragmentRandomAccessOffsetBox extends AbstractFullBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11974b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11975c;

    /* renamed from: a */
    private long f11976a;

    static {
        m574d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m574d() {
        C3105b c3105b = new C3105b("MovieFragmentRandomAccessOffsetBox.java", MovieFragmentRandomAccessOffsetBox.class);
        f11974b = c3105b.m794a("method-execution", c3105b.m795a("1", "getMfraSize", "org.mp4parser.boxes.iso14496.part12.MovieFragmentRandomAccessOffsetBox", "", "", "", "long"), 57);
        f11975c = c3105b.m794a("method-execution", c3105b.m795a("1", "setMfraSize", "org.mp4parser.boxes.iso14496.part12.MovieFragmentRandomAccessOffsetBox", "long", "mfraSize", "", "void"), 61);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 8L;
    }

    public MovieFragmentRandomAccessOffsetBox() {
        super("mfro");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11976a = IsoTypeReader.m738a(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11976a);
    }

    /* renamed from: a */
    public void m575a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11975c, this, this, Conversions.m803a(j)));
        this.f11976a = j;
    }
}
