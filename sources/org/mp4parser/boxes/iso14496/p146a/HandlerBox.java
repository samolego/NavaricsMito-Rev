package org.mp4parser.boxes.iso14496.p146a;

import com.senseplay.sdk.config.CacheConfig;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.IsoFile;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;
import org.mp4parser.p144a.Utf8;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.h */
/* loaded from: classes2.dex */
public class HandlerBox extends AbstractFullBox {

    /* renamed from: a */
    public static final Map<String, String> f11927a;

    /* renamed from: m */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11928m;

    /* renamed from: n */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11929n;

    /* renamed from: o */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11930o;

    /* renamed from: p */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11931p;

    /* renamed from: q */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11932q;

    /* renamed from: r */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11933r;

    /* renamed from: b */
    private String f11934b;

    /* renamed from: c */
    private String f11935c;

    /* renamed from: h */
    private long f11936h;

    /* renamed from: i */
    private long f11937i;

    /* renamed from: j */
    private long f11938j;

    /* renamed from: k */
    private boolean f11939k;

    /* renamed from: l */
    private long f11940l;

    /* renamed from: f */
    private static /* synthetic */ void m593f() {
        C3105b c3105b = new C3105b("HandlerBox.java", HandlerBox.class);
        f11928m = c3105b.m794a("method-execution", c3105b.m795a("1", "getHandlerType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 79);
        f11929n = c3105b.m794a("method-execution", c3105b.m795a("1", "setHandlerType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "java.lang.String", "handlerType", "", "void"), 83);
        f11930o = c3105b.m794a("method-execution", c3105b.m795a("1", "getName", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 87);
        f11931p = c3105b.m794a("method-execution", c3105b.m795a("1", "setName", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "java.lang.String", "name", "", "void"), 96);
        f11932q = c3105b.m794a("method-execution", c3105b.m795a("1", "getHumanReadableTrackType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 100);
        f11933r = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), CacheConfig.Post_Delayed);
    }

    static {
        m593f();
        HashMap hashMap = new HashMap();
        hashMap.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mdir", "Apple Meta Data iTunes Reader");
        hashMap.put("mp7b", "MPEG-7 binary XML");
        hashMap.put("mp7t", "MPEG-7 XML");
        hashMap.put("vide", "Video Track");
        hashMap.put("soun", "Sound Track");
        hashMap.put("hint", "Hint Track");
        hashMap.put("appl", "Apple specific");
        hashMap.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        f11927a = Collections.unmodifiableMap(hashMap);
    }

    public HandlerBox() {
        super("hdlr");
        this.f11935c = null;
        this.f11939k = true;
    }

    /* renamed from: d */
    public String m595d() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11928m, this, this));
        return this.f11934b;
    }

    /* renamed from: a */
    public void m596a(String str) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f11929n, this, this, str));
        this.f11934b = str;
    }

    /* renamed from: e */
    public String m594e() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11930o, this, this));
        return this.f11935c;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: l_ */
    protected long mo406l_() {
        if (this.f11939k) {
            return Utf8.m707b(this.f11935c) + 25;
        }
        return Utf8.m707b(this.f11935c) + 24;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: a */
    public void mo411a(ByteBuffer byteBuffer) {
        m396c(byteBuffer);
        this.f11940l = IsoTypeReader.m738a(byteBuffer);
        this.f11934b = IsoTypeReader.m728j(byteBuffer);
        this.f11936h = IsoTypeReader.m738a(byteBuffer);
        this.f11937i = IsoTypeReader.m738a(byteBuffer);
        this.f11938j = IsoTypeReader.m738a(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.f11935c = IsoTypeReader.m737a(byteBuffer, byteBuffer.remaining());
            if (this.f11935c.endsWith("\u0000")) {
                String str = this.f11935c;
                this.f11935c = str.substring(0, str.length() - 1);
                this.f11939k = true;
                return;
            }
            this.f11939k = false;
            return;
        }
        this.f11939k = false;
    }

    @Override // org.mp4parser.support.AbstractBox
    /* renamed from: b */
    protected void mo410b(ByteBuffer byteBuffer) {
        m394d(byteBuffer);
        IsoTypeWriter.m720b(byteBuffer, this.f11940l);
        byteBuffer.put(IsoFile.m524a(this.f11934b));
        IsoTypeWriter.m720b(byteBuffer, this.f11936h);
        IsoTypeWriter.m720b(byteBuffer, this.f11937i);
        IsoTypeWriter.m720b(byteBuffer, this.f11938j);
        String str = this.f11935c;
        if (str != null) {
            byteBuffer.put(Utf8.m709a(str));
        }
        if (this.f11939k) {
            byteBuffer.put((byte) 0);
        }
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11933r, this, this));
        return "HandlerBox[handlerType=" + m595d() + ";name=" + m594e() + "]";
    }
}
