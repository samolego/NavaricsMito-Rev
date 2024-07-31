package org.mp4parser.boxes.iso14496.p146a;

import com.senseplay.sdk.config.CacheConfig;
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
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.boxes.iso14496.a.t */
/* loaded from: classes2.dex */
public class MovieHeaderBox extends AbstractFullBox {

    /* renamed from: A */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11977A;

    /* renamed from: B */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11978B;

    /* renamed from: C */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11979C;

    /* renamed from: D */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11980D;

    /* renamed from: E */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11981E;

    /* renamed from: F */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11982F;

    /* renamed from: G */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11983G;

    /* renamed from: H */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11984H;

    /* renamed from: I */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11985I;

    /* renamed from: J */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11986J;

    /* renamed from: K */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11987K;

    /* renamed from: L */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11988L;

    /* renamed from: M */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11989M;

    /* renamed from: N */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11990N;

    /* renamed from: O */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11991O;

    /* renamed from: P */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11992P;

    /* renamed from: Q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11993Q;

    /* renamed from: R */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11994R;

    /* renamed from: S */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11995S;

    /* renamed from: T */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11996T;

    /* renamed from: U */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11997U;

    /* renamed from: V */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11998V;

    /* renamed from: a */
    private static InterfaceC3153b f11999a;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12000t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12001u;

    /* renamed from: v */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12002v;

    /* renamed from: w */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12003w;

    /* renamed from: x */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12004x;

    /* renamed from: y */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12005y;

    /* renamed from: z */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12006z;

    /* renamed from: b */
    private Date f12007b;

    /* renamed from: c */
    private Date f12008c;

    /* renamed from: h */
    private long f12009h;

    /* renamed from: i */
    private long f12010i;

    /* renamed from: j */
    private double f12011j;

    /* renamed from: k */
    private float f12012k;

    /* renamed from: l */
    private Matrix f12013l;

    /* renamed from: m */
    private long f12014m;

    /* renamed from: n */
    private int f12015n;

    /* renamed from: o */
    private int f12016o;

    /* renamed from: p */
    private int f12017p;

    /* renamed from: q */
    private int f12018q;

    /* renamed from: r */
    private int f12019r;

    /* renamed from: s */
    private int f12020s;

    /* renamed from: k */
    private static /* synthetic */ void m561k() {
        C3105b c3105b = new C3105b("MovieHeaderBox.java", MovieHeaderBox.class);
        f12000t = c3105b.m794a("method-execution", c3105b.m795a("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.util.Date"), 65);
        f12001u = c3105b.m794a("method-execution", c3105b.m795a("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 69);
        f11980D = c3105b.m794a("method-execution", c3105b.m795a("1", "getVolume", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "float"), 116);
        f11981E = c3105b.m794a("method-execution", c3105b.m795a("1", "setVolume", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "float", "volume", "", "void"), 120);
        f11982F = c3105b.m794a("method-execution", c3105b.m795a("1", "getMatrix", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "org.mp4parser.support.Matrix"), 124);
        f11983G = c3105b.m794a("method-execution", c3105b.m795a("1", "setMatrix", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "org.mp4parser.support.Matrix", "matrix", "", "void"), 128);
        f11984H = c3105b.m794a("method-execution", c3105b.m795a("1", "getNextTrackId", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 132);
        f11985I = c3105b.m794a("method-execution", c3105b.m795a("1", "setNextTrackId", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "nextTrackId", "", "void"), 136);
        f11986J = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.lang.String"), 190);
        f11987K = c3105b.m794a("method-execution", c3105b.m795a("1", "getPreviewTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE);
        f11988L = c3105b.m794a("method-execution", c3105b.m795a("1", "setPreviewTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "previewTime", "", "void"), 248);
        f11989M = c3105b.m794a("method-execution", c3105b.m795a("1", "getPreviewDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 252);
        f12002v = c3105b.m794a("method-execution", c3105b.m795a("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "java.util.Date"), 77);
        f11990N = c3105b.m794a("method-execution", c3105b.m795a("1", "setPreviewDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "previewDuration", "", "void"), 256);
        f11991O = c3105b.m794a("method-execution", c3105b.m795a("1", "getPosterTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), CacheConfig.Read_Delayed);
        f11992P = c3105b.m794a("method-execution", c3105b.m795a("1", "setPosterTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "posterTime", "", "void"), 264);
        f11993Q = c3105b.m794a("method-execution", c3105b.m795a("1", "getSelectionTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 268);
        f11994R = c3105b.m794a("method-execution", c3105b.m795a("1", "setSelectionTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "selectionTime", "", "void"), 272);
        f11995S = c3105b.m794a("method-execution", c3105b.m795a("1", "getSelectionDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 276);
        f11996T = c3105b.m794a("method-execution", c3105b.m795a("1", "setSelectionDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "selectionDuration", "", "void"), 280);
        f11997U = c3105b.m794a("method-execution", c3105b.m795a("1", "getCurrentTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "int"), 284);
        f11998V = c3105b.m794a("method-execution", c3105b.m795a("1", "setCurrentTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "int", "currentTime", "", "void"), 288);
        f12003w = c3105b.m794a("method-execution", c3105b.m795a("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 81);
        f12004x = c3105b.m794a("method-execution", c3105b.m795a("1", "getTimescale", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 89);
        f12005y = c3105b.m794a("method-execution", c3105b.m795a("1", "setTimescale", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "timescale", "", "void"), 93);
        f12006z = c3105b.m794a("method-execution", c3105b.m795a("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "long"), 97);
        f11977A = c3105b.m794a("method-execution", c3105b.m795a("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "long", "duration", "", "void"), 101);
        f11978B = c3105b.m794a("method-execution", c3105b.m795a("1", "getRate", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "", "", "", "double"), 108);
        f11979C = c3105b.m794a("method-execution", c3105b.m795a("1", "setRate", "org.mp4parser.boxes.iso14496.part12.MovieHeaderBox", "double", "rate", "", "void"), 112);
    }

    static {
        m561k();
        f11999a = C3154c.m262a(MovieHeaderBox.class);
    }

    public MovieHeaderBox() {
        super("mvhd");
        this.f12011j = 1.0d;
        this.f12012k = 1.0f;
        this.f12013l = Matrix.f12385a;
    }

    /* renamed from: d */
    public Date m568d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12000t, this, this));
        return this.f12007b;
    }

    /* renamed from: a */
    public void m572a(Date date) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12001u, this, this, date));
        this.f12007b = date;
        if (DateHelper.m741a(date) >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            m398b(1);
        }
    }

    /* renamed from: e */
    public Date m567e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12002v, this, this));
        return this.f12008c;
    }

    /* renamed from: b */
    public void m570b(Date date) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12003w, this, this, date));
        this.f12008c = date;
        if (DateHelper.m741a(date) >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            m398b(1);
        }
    }

    /* renamed from: f */
    public long m566f() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12004x, this, this));
        return this.f12009h;
    }

    /* renamed from: a */
    public void m573a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12005y, this, this, Conversions.m803a(j)));
        this.f12009h = j;
    }

    /* renamed from: g */
    public long m565g() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12006z, this, this));
        return this.f12010i;
    }

    /* renamed from: b */
    public void m571b(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11977A, this, this, Conversions.m803a(j)));
        this.f12010i = j;
        if (j >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            m398b(1);
        }
    }

    /* renamed from: h */
    public double m564h() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11978B, this, this));
        return this.f12011j;
    }

    /* renamed from: i */
    public float m563i() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11980D, this, this));
        return this.f12012k;
    }

    /* renamed from: j */
    public long m562j() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11984H, this, this));
        return this.f12014m;
    }

    /* renamed from: c */
    public void m569c(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11985I, this, this, Conversions.m803a(j)));
        this.f12014m = j;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (m393p() == 1 ? 32L : 20L) + 80;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        if (m393p() == 1) {
            this.f12007b = DateHelper.m742a(IsoTypeReader.m733e(byteBuffer));
            this.f12008c = DateHelper.m742a(IsoTypeReader.m733e(byteBuffer));
            this.f12009h = IsoTypeReader.m738a(byteBuffer);
            this.f12010i = byteBuffer.getLong();
        } else {
            this.f12007b = DateHelper.m742a(IsoTypeReader.m738a(byteBuffer));
            this.f12008c = DateHelper.m742a(IsoTypeReader.m738a(byteBuffer));
            this.f12009h = IsoTypeReader.m738a(byteBuffer);
            this.f12010i = byteBuffer.getInt();
        }
        if (this.f12010i < -1) {
            f11999a.warn("mvhd duration is not in expected range");
        }
        this.f12011j = IsoTypeReader.m732f(byteBuffer);
        this.f12012k = IsoTypeReader.m730h(byteBuffer);
        IsoTypeReader.m735c(byteBuffer);
        IsoTypeReader.m738a(byteBuffer);
        IsoTypeReader.m738a(byteBuffer);
        this.f12013l = Matrix.m390a(byteBuffer);
        this.f12015n = byteBuffer.getInt();
        this.f12016o = byteBuffer.getInt();
        this.f12017p = byteBuffer.getInt();
        this.f12018q = byteBuffer.getInt();
        this.f12019r = byteBuffer.getInt();
        this.f12020s = byteBuffer.getInt();
        this.f12014m = IsoTypeReader.m738a(byteBuffer);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11986J, this, this));
        return "MovieHeaderBox[creationTime=" + m568d() + ";modificationTime=" + m567e() + ";timescale=" + m566f() + ";duration=" + m565g() + ";rate=" + m564h() + ";volume=" + m563i() + ";matrix=" + this.f12013l + ";nextTrackId=" + m562j() + "]";
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        if (m393p() == 1) {
            IsoTypeWriter.m724a(byteBuffer, DateHelper.m741a(this.f12007b));
            IsoTypeWriter.m724a(byteBuffer, DateHelper.m741a(this.f12008c));
            IsoTypeWriter.m720b(byteBuffer, this.f12009h);
            byteBuffer.putLong(this.f12010i);
        } else {
            IsoTypeWriter.m720b(byteBuffer, DateHelper.m741a(this.f12007b));
            IsoTypeWriter.m720b(byteBuffer, DateHelper.m741a(this.f12008c));
            IsoTypeWriter.m720b(byteBuffer, this.f12009h);
            byteBuffer.putInt((int) this.f12010i);
        }
        IsoTypeWriter.m726a(byteBuffer, this.f12011j);
        IsoTypeWriter.m719c(byteBuffer, this.f12012k);
        IsoTypeWriter.m721b(byteBuffer, 0);
        IsoTypeWriter.m720b(byteBuffer, 0L);
        IsoTypeWriter.m720b(byteBuffer, 0L);
        this.f12013l.m389b(byteBuffer);
        byteBuffer.putInt(this.f12015n);
        byteBuffer.putInt(this.f12016o);
        byteBuffer.putInt(this.f12017p);
        byteBuffer.putInt(this.f12018q);
        byteBuffer.putInt(this.f12019r);
        byteBuffer.putInt(this.f12020s);
        IsoTypeWriter.m720b(byteBuffer, this.f12014m);
    }
}
