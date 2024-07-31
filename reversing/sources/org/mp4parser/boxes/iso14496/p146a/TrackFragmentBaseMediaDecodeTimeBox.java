package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.ah */
/* loaded from: classes2.dex */
public class TrackFragmentBaseMediaDecodeTimeBox extends AbstractFullBox {

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11775b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11776c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11777h;

    /* renamed from: a */
    private long f11778a;

    static {
        m671d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m671d() {
        C3105b c3105b = new C3105b("TrackFragmentBaseMediaDecodeTimeBox.java", TrackFragmentBaseMediaDecodeTimeBox.class);
        f11775b = c3105b.m794a("method-execution", c3105b.m795a("1", "getBaseMediaDecodeTime", "org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "long"), 66);
        f11776c = c3105b.m794a("method-execution", c3105b.m795a("1", "setBaseMediaDecodeTime", "org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox", "long", "baseMediaDecodeTime", "", "void"), 70);
        f11777h = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "java.lang.String"), 75);
    }

    public TrackFragmentBaseMediaDecodeTimeBox() {
        super("tfdt");
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return m393p() == 0 ? 8L : 12L;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        if (m393p() == 1) {
            IsoTypeWriter.m724a(byteBuffer, this.f11778a);
        } else {
            IsoTypeWriter.m720b(byteBuffer, this.f11778a);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        if (m393p() == 1) {
            this.f11778a = IsoTypeReader.m733e(byteBuffer);
        } else {
            this.f11778a = IsoTypeReader.m738a(byteBuffer);
        }
    }

    /* renamed from: a */
    public void m672a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11776c, this, this, Conversions.m803a(j)));
        this.f11778a = j;
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11777h, this, this));
        return "TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=" + this.f11778a + '}';
    }
}
