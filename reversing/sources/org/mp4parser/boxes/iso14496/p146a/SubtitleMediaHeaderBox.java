package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ac */
/* loaded from: classes2.dex */
public class SubtitleMediaHeaderBox extends AbstractMediaHeaderBox {

    /* renamed from: a */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11746a;

    static {
        m688d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m688d() {
        C3105b c3105b = new C3105b("SubtitleMediaHeaderBox.java", SubtitleMediaHeaderBox.class);
        f11746a = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.SubtitleMediaHeaderBox", "", "", "", "java.lang.String"), 31);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 4L;
    }

    public SubtitleMediaHeaderBox() {
        super("sthd");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11746a, this, this));
        return "SubtitleMediaHeaderBox";
    }
}
