package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.p144a.DateHelper;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: org.mp4parser.boxes.iso14496.a.k */
/* loaded from: classes2.dex */
public class MediaHeaderBox extends AbstractFullBox {

    /* renamed from: a */
    private static InterfaceC3153b f11950a;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11951k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11952l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11953m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11954n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11955o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11956p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11957q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11958r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11959s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11960t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11961u;

    /* renamed from: b */
    private Date f11962b;

    /* renamed from: c */
    private Date f11963c;

    /* renamed from: h */
    private long f11964h;

    /* renamed from: i */
    private long f11965i;

    /* renamed from: j */
    private String f11966j;

    /* renamed from: i */
    private static /* synthetic */ void m581i() {
        C3105b c3105b = new C3105b("MediaHeaderBox.java", MediaHeaderBox.class);
        f11951k = c3105b.m794a("method-execution", c3105b.m795a("1", "getCreationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.util.Date"), 49);
        f11952l = c3105b.m794a("method-execution", c3105b.m795a("1", "setCreationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 53);
        f11961u = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.lang.String"), 126);
        f11953m = c3105b.m794a("method-execution", c3105b.m795a("1", "getModificationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.util.Date"), 57);
        f11954n = c3105b.m794a("method-execution", c3105b.m795a("1", "setModificationTime", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 61);
        f11955o = c3105b.m794a("method-execution", c3105b.m795a("1", "getTimescale", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "long"), 65);
        f11956p = c3105b.m794a("method-execution", c3105b.m795a("1", "setTimescale", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "long", "timescale", "", "void"), 69);
        f11957q = c3105b.m794a("method-execution", c3105b.m795a("1", "getDuration", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "long"), 73);
        f11958r = c3105b.m794a("method-execution", c3105b.m795a("1", "setDuration", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "long", "duration", "", "void"), 77);
        f11959s = c3105b.m794a("method-execution", c3105b.m795a("1", "getLanguage", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "", "", "", "java.lang.String"), 81);
        f11960t = c3105b.m794a("method-execution", c3105b.m795a("1", "setLanguage", "org.mp4parser.boxes.iso14496.part12.MediaHeaderBox", "java.lang.String", IjkMediaMeta.IJKM_KEY_LANGUAGE, "", "void"), 85);
    }

    static {
        m581i();
        f11950a = C3154c.m262a(MediaHeaderBox.class);
    }

    public MediaHeaderBox() {
        super("mdhd");
        this.f11962b = new Date();
        this.f11963c = new Date();
        this.f11966j = "eng";
    }

    /* renamed from: d */
    public Date m586d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11951k, this, this));
        return this.f11962b;
    }

    /* renamed from: a */
    public void m589a(Date date) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11952l, this, this, date));
        this.f11962b = date;
    }

    /* renamed from: e */
    public Date m585e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11953m, this, this));
        return this.f11963c;
    }

    /* renamed from: b */
    public void m587b(Date date) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11954n, this, this, date));
        this.f11963c = date;
    }

    /* renamed from: f */
    public long m584f() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11955o, this, this));
        return this.f11964h;
    }

    /* renamed from: a */
    public void m591a(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11956p, this, this, Conversions.m803a(j)));
        this.f11964h = j;
    }

    /* renamed from: g */
    public long m583g() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11957q, this, this));
        return this.f11965i;
    }

    /* renamed from: b */
    public void m588b(long j) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11958r, this, this, Conversions.m803a(j)));
        this.f11965i = j;
    }

    /* renamed from: h */
    public String m582h() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11959s, this, this));
        return this.f11966j;
    }

    /* renamed from: a */
    public void m590a(String str) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11960t, this, this, str));
        this.f11966j = str;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (m393p() == 1 ? 32L : 20L) + 2 + 2;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        if (m393p() == 1) {
            this.f11962b = DateHelper.m742a(IsoTypeReader.m733e(byteBuffer));
            this.f11963c = DateHelper.m742a(IsoTypeReader.m733e(byteBuffer));
            this.f11964h = IsoTypeReader.m738a(byteBuffer);
            this.f11965i = byteBuffer.getLong();
        } else {
            this.f11962b = DateHelper.m742a(IsoTypeReader.m738a(byteBuffer));
            this.f11963c = DateHelper.m742a(IsoTypeReader.m738a(byteBuffer));
            this.f11964h = IsoTypeReader.m738a(byteBuffer);
            this.f11965i = byteBuffer.getInt();
        }
        if (this.f11965i < -1) {
            f11950a.warn("mdhd duration is not in expected range");
        }
        this.f11966j = IsoTypeReader.m729i(byteBuffer);
        IsoTypeReader.m735c(byteBuffer);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11961u, this, this));
        return "MediaHeaderBox[creationTime=" + m586d() + ";modificationTime=" + m585e() + ";timescale=" + m584f() + ";duration=" + m583g() + ";language=" + m582h() + "]";
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        if (m393p() == 1) {
            IsoTypeWriter.m724a(byteBuffer, DateHelper.m741a(this.f11962b));
            IsoTypeWriter.m724a(byteBuffer, DateHelper.m741a(this.f11963c));
            IsoTypeWriter.m720b(byteBuffer, this.f11964h);
            byteBuffer.putLong(this.f11965i);
        } else {
            IsoTypeWriter.m720b(byteBuffer, DateHelper.m741a(this.f11962b));
            IsoTypeWriter.m720b(byteBuffer, DateHelper.m741a(this.f11963c));
            IsoTypeWriter.m720b(byteBuffer, this.f11964h);
            byteBuffer.putInt((int) this.f11965i);
        }
        IsoTypeWriter.m723a(byteBuffer, this.f11966j);
        IsoTypeWriter.m721b(byteBuffer, 0);
    }
}
