package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.aa */
/* loaded from: classes2.dex */
public class SoundMediaHeaderBox extends AbstractMediaHeaderBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11740b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11741c;

    /* renamed from: a */
    private float f11742a;

    static {
        m690e();
    }

    /* renamed from: e */
    private static /* synthetic */ void m690e() {
        C3105b c3105b = new C3105b("SoundMediaHeaderBox.java", SoundMediaHeaderBox.class);
        f11740b = c3105b.m794a("method-execution", c3105b.m795a("1", "getBalance", "org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox", "", "", "", "float"), 37);
        f11741c = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 59);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 8L;
    }

    public SoundMediaHeaderBox() {
        super("smhd");
    }

    /* renamed from: d */
    public float m691d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11740b, this, this));
        return this.f11742a;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11742a = IsoTypeReader.m730h(byteBuffer);
        IsoTypeReader.m735c(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m719c(byteBuffer, this.f11742a);
        IsoTypeWriter.m721b(byteBuffer, 0);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11741c, this, this));
        return "SoundMediaHeaderBox[balance=" + m691d() + "]";
    }
}
