package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.o */
/* loaded from: classes2.dex */
public class MovieExtendsHeaderBox extends AbstractFullBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11967b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11968c;

    /* renamed from: a */
    private long f11969a;

    static {
        m579d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m579d() {
        C3105b c3105b = new C3105b("MovieExtendsHeaderBox.java", MovieExtendsHeaderBox.class);
        f11967b = c3105b.m794a("method-execution", c3105b.m795a("1", "getFragmentDuration", "org.mp4parser.boxes.iso14496.part12.MovieExtendsHeaderBox", "", "", "", "long"), 66);
        f11968c = c3105b.m794a("method-execution", c3105b.m795a("1", "setFragmentDuration", "org.mp4parser.boxes.iso14496.part12.MovieExtendsHeaderBox", "long", "fragmentDuration", "", "void"), 70);
    }

    public MovieExtendsHeaderBox() {
        super("mehd");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return m393p() == 1 ? 12L : 8L;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11969a = m393p() == 1 ? IsoTypeReader.m733e(byteBuffer) : IsoTypeReader.m738a(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        if (m393p() == 1) {
            IsoTypeWriter.m724a(byteBuffer, this.f11969a);
        } else {
            IsoTypeWriter.m720b(byteBuffer, this.f11969a);
        }
    }

    /* renamed from: a */
    public void m580a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11968c, this, this, Conversions.m803a(j)));
        this.f11969a = j;
    }
}
