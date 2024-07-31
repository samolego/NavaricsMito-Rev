package org.mp4parser.boxes.iso14496.p146a;

import android.support.p011v7.widget.helper.ItemTouchHelper;
import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.DateHelper;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.Matrix;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.mp4parser.boxes.iso14496.a.al */
/* loaded from: classes2.dex */
public class TrackHeaderBox extends AbstractFullBox {

    /* renamed from: A */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11833A;

    /* renamed from: B */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11834B;

    /* renamed from: C */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11835C;

    /* renamed from: D */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11836D;

    /* renamed from: E */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11837E;

    /* renamed from: F */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11838F;

    /* renamed from: G */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11839G;

    /* renamed from: H */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11840H;

    /* renamed from: I */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11841I;

    /* renamed from: J */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11842J;

    /* renamed from: K */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11843K;

    /* renamed from: L */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11844L;

    /* renamed from: M */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11845M;

    /* renamed from: N */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11846N;

    /* renamed from: O */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11847O;

    /* renamed from: P */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11848P;

    /* renamed from: Q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11849Q;

    /* renamed from: R */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11850R;

    /* renamed from: S */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11851S;

    /* renamed from: a */
    private static InterfaceC3153b f11852a;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11853p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11854q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11855r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11856s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11857t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11858u;

    /* renamed from: v */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11859v;

    /* renamed from: w */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11860w;

    /* renamed from: x */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11861x;

    /* renamed from: y */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11862y;

    /* renamed from: z */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11863z;

    /* renamed from: b */
    private Date f11864b;

    /* renamed from: c */
    private Date f11865c;

    /* renamed from: h */
    private long f11866h;

    /* renamed from: i */
    private long f11867i;

    /* renamed from: j */
    private int f11868j;

    /* renamed from: k */
    private int f11869k;

    /* renamed from: l */
    private float f11870l;

    /* renamed from: m */
    private Matrix f11871m;

    /* renamed from: n */
    private double f11872n;

    /* renamed from: o */
    private double f11873o;

    /* renamed from: r */
    private static /* synthetic */ void m636r() {
        C3105b c3105b = new C3105b("TrackHeaderBox.java", TrackHeaderBox.class);
        f11853p = c3105b.m794a("method-execution", c3105b.m795a("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.util.Date"), 63);
        f11854q = c3105b.m794a("method-execution", c3105b.m795a("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 67);
        f11863z = c3105b.m794a("method-execution", c3105b.m795a("1", "getAlternateGroup", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "int"), 113);
        f11833A = c3105b.m794a("method-execution", c3105b.m795a("1", "setAlternateGroup", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "int", "alternateGroup", "", "void"), 117);
        f11834B = c3105b.m794a("method-execution", c3105b.m795a("1", "getVolume", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "float"), 121);
        f11835C = c3105b.m794a("method-execution", c3105b.m795a("1", "setVolume", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "float", "volume", "", "void"), 125);
        f11836D = c3105b.m794a("method-execution", c3105b.m795a("1", "getMatrix", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "org.mp4parser.support.Matrix"), 129);
        f11837E = c3105b.m794a("method-execution", c3105b.m795a("1", "setMatrix", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "org.mp4parser.support.Matrix", "matrix", "", "void"), 133);
        f11838F = c3105b.m794a("method-execution", c3105b.m795a("1", "getWidth", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "double"), 137);
        f11839G = c3105b.m794a("method-execution", c3105b.m795a("1", "setWidth", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "double", "width", "", "void"), 141);
        f11840H = c3105b.m794a("method-execution", c3105b.m795a("1", "getHeight", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "double"), 145);
        f11841I = c3105b.m794a("method-execution", c3105b.m795a("1", "setHeight", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "double", "height", "", "void"), 149);
        f11855r = c3105b.m794a("method-execution", c3105b.m795a("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.util.Date"), 74);
        f11842J = c3105b.m794a("method-execution", c3105b.m795a("1", "getContent", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 196);
        f11843K = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "java.lang.String"), 224);
        f11844L = c3105b.m794a("method-execution", c3105b.m795a("1", "isEnabled", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        f11845M = c3105b.m794a("method-execution", c3105b.m795a("1", "setEnabled", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "enabled", "", "void"), 254);
        f11846N = c3105b.m794a("method-execution", c3105b.m795a("1", "isInMovie", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 262);
        f11847O = c3105b.m794a("method-execution", c3105b.m795a("1", "setInMovie", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inMovie", "", "void"), 266);
        f11848P = c3105b.m794a("method-execution", c3105b.m795a("1", "isInPreview", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 274);
        f11849Q = c3105b.m794a("method-execution", c3105b.m795a("1", "setInPreview", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inPreview", "", "void"), 278);
        f11850R = c3105b.m794a("method-execution", c3105b.m795a("1", "isInPoster", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "boolean"), 286);
        f11851S = c3105b.m794a("method-execution", c3105b.m795a("1", "setInPoster", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "boolean", "inPoster", "", "void"), 290);
        f11856s = c3105b.m794a("method-execution", c3105b.m795a("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 78);
        f11857t = c3105b.m794a("method-execution", c3105b.m795a("1", "getTrackId", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "long"), 86);
        f11858u = c3105b.m794a("method-execution", c3105b.m795a("1", "setTrackId", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "long", "trackId", "", "void"), 90);
        f11859v = c3105b.m794a("method-execution", c3105b.m795a("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "long"), 94);
        f11860w = c3105b.m794a("method-execution", c3105b.m795a("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "long", "duration", "", "void"), 98);
        f11861x = c3105b.m794a("method-execution", c3105b.m795a("1", "getLayer", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "", "", "", "int"), 105);
        f11862y = c3105b.m794a("method-execution", c3105b.m795a("1", "setLayer", "org.mp4parser.boxes.iso14496.part12.TrackHeaderBox", "int", "layer", "", "void"), 109);
    }

    static {
        m636r();
        f11852a = C3154c.m262a(TrackHeaderBox.class);
    }

    public TrackHeaderBox() {
        super("tkhd");
        this.f11864b = new Date(0L);
        this.f11865c = new Date(0L);
        this.f11871m = Matrix.f12385a;
    }

    /* renamed from: d */
    public Date m645d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11853p, this, this));
        return this.f11864b;
    }

    /* renamed from: e */
    public Date m644e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11855r, this, this));
        return this.f11865c;
    }

    /* renamed from: f */
    public long m643f() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11857t, this, this));
        return this.f11866h;
    }

    /* renamed from: a */
    public void m647a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11858u, this, this, Conversions.m803a(j)));
        this.f11866h = j;
    }

    /* renamed from: g */
    public long m642g() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11859v, this, this));
        return this.f11867i;
    }

    /* renamed from: h */
    public int m641h() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11861x, this, this));
        return this.f11868j;
    }

    /* renamed from: i */
    public int m640i() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11863z, this, this));
        return this.f11869k;
    }

    /* renamed from: j */
    public float m639j() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11834B, this, this));
        return this.f11870l;
    }

    /* renamed from: k */
    public double m638k() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11838F, this, this));
        return this.f11872n;
    }

    /* renamed from: a */
    public void m648a(double d) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11839G, this, this, Conversions.m805a(d)));
        this.f11872n = d;
    }

    /* renamed from: l */
    public double m637l() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11840H, this, this));
        return this.f11873o;
    }

    /* renamed from: b */
    public void m646b(double d) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11841I, this, this, Conversions.m805a(d)));
        this.f11873o = d;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (m393p() == 1 ? 36L : 24L) + 60;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        if (m393p() == 1) {
            this.f11864b = DateHelper.m742a(IsoTypeReader.m733e(byteBuffer));
            this.f11865c = DateHelper.m742a(IsoTypeReader.m733e(byteBuffer));
            this.f11866h = IsoTypeReader.m738a(byteBuffer);
            IsoTypeReader.m738a(byteBuffer);
            this.f11867i = byteBuffer.getLong();
        } else {
            this.f11864b = DateHelper.m742a(IsoTypeReader.m738a(byteBuffer));
            this.f11865c = DateHelper.m742a(IsoTypeReader.m738a(byteBuffer));
            this.f11866h = IsoTypeReader.m738a(byteBuffer);
            IsoTypeReader.m738a(byteBuffer);
            this.f11867i = byteBuffer.getInt();
        }
        if (this.f11867i < -1) {
            f11852a.warn("tkhd duration is not in expected range");
        }
        IsoTypeReader.m738a(byteBuffer);
        IsoTypeReader.m738a(byteBuffer);
        this.f11868j = IsoTypeReader.m735c(byteBuffer);
        this.f11869k = IsoTypeReader.m735c(byteBuffer);
        this.f11870l = IsoTypeReader.m730h(byteBuffer);
        IsoTypeReader.m735c(byteBuffer);
        this.f11871m = Matrix.m390a(byteBuffer);
        this.f11872n = IsoTypeReader.m732f(byteBuffer);
        this.f11873o = IsoTypeReader.m732f(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    public void mo410b(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11842J, this, this, byteBuffer));
        m394d(byteBuffer);
        if (m393p() == 1) {
            IsoTypeWriter.m724a(byteBuffer, DateHelper.m741a(this.f11864b));
            IsoTypeWriter.m724a(byteBuffer, DateHelper.m741a(this.f11865c));
            IsoTypeWriter.m720b(byteBuffer, this.f11866h);
            IsoTypeWriter.m720b(byteBuffer, 0L);
            byteBuffer.putLong(this.f11867i);
        } else {
            IsoTypeWriter.m720b(byteBuffer, DateHelper.m741a(this.f11864b));
            IsoTypeWriter.m720b(byteBuffer, DateHelper.m741a(this.f11865c));
            IsoTypeWriter.m720b(byteBuffer, this.f11866h);
            IsoTypeWriter.m720b(byteBuffer, 0L);
            byteBuffer.putInt((int) this.f11867i);
        }
        IsoTypeWriter.m720b(byteBuffer, 0L);
        IsoTypeWriter.m720b(byteBuffer, 0L);
        IsoTypeWriter.m721b(byteBuffer, this.f11868j);
        IsoTypeWriter.m721b(byteBuffer, this.f11869k);
        IsoTypeWriter.m719c(byteBuffer, this.f11870l);
        IsoTypeWriter.m721b(byteBuffer, 0);
        this.f11871m.m389b(byteBuffer);
        IsoTypeWriter.m726a(byteBuffer, this.f11872n);
        IsoTypeWriter.m726a(byteBuffer, this.f11873o);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11843K, this, this));
        return "TrackHeaderBox[creationTime=" + m645d() + ";modificationTime=" + m644e() + ";trackId=" + m643f() + ";duration=" + m642g() + ";layer=" + m641h() + ";alternateGroup=" + m640i() + ";volume=" + m639j() + ";matrix=" + this.f11871m + ";width=" + m638k() + ";height=" + m637l() + "]";
    }
}
