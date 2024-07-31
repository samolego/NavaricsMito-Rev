package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.q */
/* loaded from: classes2.dex */
public class MovieFragmentHeaderBox extends AbstractFullBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11970b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11971c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11972h;

    /* renamed from: a */
    private long f11973a;

    static {
        m576d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m576d() {
        C3105b c3105b = new C3105b("MovieFragmentHeaderBox.java", MovieFragmentHeaderBox.class);
        f11970b = c3105b.m794a("method-execution", c3105b.m795a("1", "getSequenceNumber", "org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox", "", "", "", "long"), 60);
        f11971c = c3105b.m794a("method-execution", c3105b.m795a("1", "setSequenceNumber", "org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox", "long", "sequenceNumber", "", "void"), 64);
        f11972h = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.MovieFragmentHeaderBox", "", "", "", "java.lang.String"), 69);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 8L;
    }

    public MovieFragmentHeaderBox() {
        super("mfhd");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11973a);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11973a = IsoTypeReader.m738a(byteBuffer);
    }

    /* renamed from: a */
    public void m577a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11971c, this, this, Conversions.m803a(j)));
        this.f11973a = j;
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11972h, this, this));
        return "MovieFragmentHeaderBox{sequenceNumber=" + this.f11973a + '}';
    }
}
