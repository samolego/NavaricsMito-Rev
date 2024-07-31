package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.an */
/* loaded from: classes2.dex */
public class VideoMediaHeaderBox extends AbstractMediaHeaderBox {

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11901c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11902h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11903i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11904j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11905k;

    /* renamed from: a */
    private int f11906a;

    /* renamed from: b */
    private int[] f11907b;

    static {
        m609f();
    }

    /* renamed from: f */
    private static /* synthetic */ void m609f() {
        C3105b c3105b = new C3105b("VideoMediaHeaderBox.java", VideoMediaHeaderBox.class);
        f11901c = c3105b.m794a("method-execution", c3105b.m795a("1", "getGraphicsmode", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "int"), 40);
        f11902h = c3105b.m794a("method-execution", c3105b.m795a("1", "setGraphicsmode", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "int", "graphicsmode", "", "void"), 44);
        f11903i = c3105b.m794a("method-execution", c3105b.m795a("1", "getOpcolor", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "[I"), 48);
        f11904j = c3105b.m794a("method-execution", c3105b.m795a("1", "setOpcolor", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "[I", "opcolor", "", "void"), 52);
        f11905k = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.VideoMediaHeaderBox", "", "", "", "java.lang.String"), 79);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return 12L;
    }

    public VideoMediaHeaderBox() {
        super("vmhd");
        this.f11906a = 0;
        this.f11907b = new int[]{0, 0, 0};
        m397c(1);
    }

    /* renamed from: d */
    public int m611d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11901c, this, this));
        return this.f11906a;
    }

    /* renamed from: e */
    public int[] m610e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11903i, this, this));
        return this.f11907b;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11906a = IsoTypeReader.m735c(byteBuffer);
        this.f11907b = new int[3];
        for (int i = 0; i < 3; i++) {
            this.f11907b[i] = IsoTypeReader.m735c(byteBuffer);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m721b(byteBuffer, this.f11906a);
        for (int i : this.f11907b) {
            IsoTypeWriter.m721b(byteBuffer, i);
        }
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11905k, this, this));
        return "VideoMediaHeaderBox[graphicsmode=" + m611d() + ";opcolor0=" + m610e()[0] + ";opcolor1=" + m610e()[1] + ";opcolor2=" + m610e()[2] + "]";
    }
}
