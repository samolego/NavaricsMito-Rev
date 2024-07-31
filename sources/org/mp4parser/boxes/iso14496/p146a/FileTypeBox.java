package org.mp4parser.boxes.iso14496.p146a;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.IsoFile;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.support.AbstractBox;
import org.mp4parser.support.DoNotParseDetail;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.g */
/* loaded from: classes2.dex */
public class FileTypeBox extends AbstractBox {

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11918h;

    /* renamed from: i */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11919i;

    /* renamed from: j */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11920j;

    /* renamed from: k */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11921k;

    /* renamed from: l */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11922l;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11923m;

    /* renamed from: a */
    private String f11924a;

    /* renamed from: b */
    private long f11925b;

    /* renamed from: c */
    private List<String> f11926c;

    static {
        m597f();
    }

    /* renamed from: f */
    private static /* synthetic */ void m597f() {
        C3105b c3105b = new C3105b("FileTypeBox.java", FileTypeBox.class);
        f11918h = c3105b.m794a("method-execution", c3105b.m795a("1", "getMajorBrand", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "", "", "", "java.lang.String"), 86);
        f11919i = c3105b.m794a("method-execution", c3105b.m795a("1", "setMajorBrand", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "java.lang.String", "majorBrand", "", "void"), 95);
        f11920j = c3105b.m794a("method-execution", c3105b.m795a("1", "getMinorVersion", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "", "", "", "long"), 105);
        f11921k = c3105b.m794a("method-execution", c3105b.m795a("1", "setMinorVersion", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "long", "minorVersion", "", "void"), 114);
        f11922l = c3105b.m794a("method-execution", c3105b.m795a("1", "getCompatibleBrands", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "", "", "", "java.util.List"), 123);
        f11923m = c3105b.m794a("method-execution", c3105b.m795a("1", "setCompatibleBrands", "org.mp4parser.boxes.iso14496.part12.FileTypeBox", "java.util.List", "compatibleBrands", "", "void"), 127);
    }

    public FileTypeBox() {
        super("ftyp");
        this.f11926c = Collections.emptyList();
    }

    public FileTypeBox(String str, long j, List<String> list) {
        super("ftyp");
        this.f11926c = Collections.emptyList();
        this.f11924a = str;
        this.f11925b = j;
        this.f11926c = list;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        return (this.f11926c.size() * 4) + 8;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        this.f11924a = IsoTypeReader.m728j(byteBuffer);
        this.f11925b = IsoTypeReader.m738a(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.f11926c = new LinkedList();
        for (int i = 0; i < remaining; i++) {
            this.f11926c.add(IsoTypeReader.m728j(byteBuffer));
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.m524a(this.f11924a));
        IsoTypeWriter.m720b(byteBuffer, this.f11925b);
        for (String str : this.f11926c) {
            byteBuffer.put(IsoFile.m524a(str));
        }
    }

    /* renamed from: d */
    public String m599d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11918h, this, this));
        return this.f11924a;
    }

    /* renamed from: e */
    public long m598e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11920j, this, this));
        return this.f11925b;
    }

    @DoNotParseDetail
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileTypeBox[");
        sb.append("majorBrand=");
        sb.append(m599d());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(m598e());
        for (String str : this.f11926c) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }
}
