package org.mp4parser.boxes.iso14496.p147b;

import java.nio.ByteBuffer;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.support.AbstractBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.b.a */
/* loaded from: classes2.dex */
public final class AvcConfigurationBox extends AbstractBox {

    /* renamed from: A */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12049A;

    /* renamed from: B */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12050B;

    /* renamed from: C */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12051C;

    /* renamed from: D */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12052D;

    /* renamed from: E */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12053E;

    /* renamed from: F */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12054F;

    /* renamed from: G */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12055G;

    /* renamed from: b */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12056b;

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12057c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12058h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12059i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12060j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12061k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12062l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12063m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12064n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12065o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12066p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12067q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12068r;

    /* renamed from: s */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12069s;

    /* renamed from: t */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12070t;

    /* renamed from: u */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12071u;

    /* renamed from: v */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12072v;

    /* renamed from: w */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12073w;

    /* renamed from: x */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12074x;

    /* renamed from: y */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12075y;

    /* renamed from: z */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12076z;

    /* renamed from: a */
    public AvcDecoderConfigurationRecord f12077a;

    static {
        m536d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m536d() {
        C3105b c3105b = new C3105b("AvcConfigurationBox.java", AvcConfigurationBox.class);
        f12056b = c3105b.m794a("method-execution", c3105b.m795a("1", "getConfigurationVersion", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 45);
        f12057c = c3105b.m794a("method-execution", c3105b.m795a("1", "setConfigurationVersion", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 49);
        f12066p = c3105b.m794a("method-execution", c3105b.m795a("1", "getSequenceParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 85);
        f12067q = c3105b.m794a("method-execution", c3105b.m795a("1", "setSequenceParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 89);
        f12068r = c3105b.m794a("method-execution", c3105b.m795a("1", "getPictureParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 93);
        f12069s = c3105b.m794a("method-execution", c3105b.m795a("1", "setPictureParameterSets", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 97);
        f12070t = c3105b.m794a("method-execution", c3105b.m795a("1", "getChromaFormat", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 101);
        f12071u = c3105b.m794a("method-execution", c3105b.m795a("1", "setChromaFormat", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 105);
        f12072v = c3105b.m794a("method-execution", c3105b.m795a("1", "getBitDepthLumaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 109);
        f12073w = c3105b.m794a("method-execution", c3105b.m795a("1", "setBitDepthLumaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 113);
        f12074x = c3105b.m794a("method-execution", c3105b.m795a("1", "getBitDepthChromaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 117);
        f12075y = c3105b.m794a("method-execution", c3105b.m795a("1", "setBitDepthChromaMinus8", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 121);
        f12058h = c3105b.m794a("method-execution", c3105b.m795a("1", "getAvcProfileIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 53);
        f12076z = c3105b.m794a("method-execution", c3105b.m795a("1", "getSequenceParameterSetExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 125);
        f12049A = c3105b.m794a("method-execution", c3105b.m795a("1", "setSequenceParameterSetExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 129);
        f12050B = c3105b.m794a("method-execution", c3105b.m795a("1", "hasExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 133);
        f12051C = c3105b.m794a("method-execution", c3105b.m795a("1", "setHasExts", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 137);
        f12052D = c3105b.m794a("method-execution", c3105b.m795a("1", "getContentSize", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 148);
        f12053E = c3105b.m794a("method-execution", c3105b.m795a("1", "getContent", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 154);
        f12054F = c3105b.m794a("method-execution", c3105b.m795a("1", "getavcDecoderConfigurationRecord", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "org.mp4parser.boxes.iso14496.part15.AvcDecoderConfigurationRecord"), 159);
        f12055G = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 164);
        f12059i = c3105b.m794a("method-execution", c3105b.m795a("1", "setAvcProfileIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 57);
        f12060j = c3105b.m794a("method-execution", c3105b.m795a("1", "getProfileCompatibility", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 61);
        f12061k = c3105b.m794a("method-execution", c3105b.m795a("1", "setProfileCompatibility", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 65);
        f12062l = c3105b.m794a("method-execution", c3105b.m795a("1", "getAvcLevelIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 69);
        f12063m = c3105b.m794a("method-execution", c3105b.m795a("1", "setAvcLevelIndication", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 73);
        f12064n = c3105b.m794a("method-execution", c3105b.m795a("1", "getLengthSizeMinusOne", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 77);
        f12065o = c3105b.m794a("method-execution", c3105b.m795a("1", "setLengthSizeMinusOne", "org.mp4parser.boxes.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 81);
    }

    public AvcConfigurationBox() {
        super("avcC");
        this.f12077a = new AvcDecoderConfigurationRecord();
    }

    /* renamed from: a */
    public void m541a(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12057c, this, this, Conversions.m804a(i)));
        this.f12077a.f12078a = i;
    }

    /* renamed from: b */
    public void m539b(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12059i, this, this, Conversions.m804a(i)));
        this.f12077a.f12079b = i;
    }

    /* renamed from: c */
    public void m537c(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12061k, this, this, Conversions.m804a(i)));
        this.f12077a.f12080c = i;
    }

    /* renamed from: d */
    public void m535d(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12063m, this, this, Conversions.m804a(i)));
        this.f12077a.f12081d = i;
    }

    /* renamed from: e */
    public void m534e(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12065o, this, this, Conversions.m804a(i)));
        this.f12077a.f12082e = i;
    }

    /* renamed from: a */
    public void m540a(List<ByteBuffer> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12067q, this, this, list));
        this.f12077a.f12083f = list;
    }

    /* renamed from: b */
    public void m538b(List<ByteBuffer> list) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12069s, this, this, list));
        this.f12077a.f12084g = list;
    }

    /* renamed from: f */
    public void m533f(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12071u, this, this, Conversions.m804a(i)));
        this.f12077a.f12086i = i;
    }

    /* renamed from: g */
    public void m532g(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12073w, this, this, Conversions.m804a(i)));
        this.f12077a.f12087j = i;
    }

    /* renamed from: h */
    public void m531h(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12075y, this, this, Conversions.m804a(i)));
        this.f12077a.f12088k = i;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        this.f12077a = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    public long mo406l_() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12052D, this, this));
        return this.f12077a.m530a();
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    public void mo410b(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12053E, this, this, byteBuffer));
        this.f12077a.m529a(byteBuffer);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f12055G, this, this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.f12077a + '}';
    }
}
