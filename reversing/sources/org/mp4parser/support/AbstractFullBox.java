package org.mp4parser.support;

import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p140a.Conversions;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.InterfaceC3124d;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;

/* renamed from: org.mp4parser.support.c */
/* loaded from: classes2.dex */
public abstract class AbstractFullBox extends AbstractBox implements InterfaceC3124d {

    /* renamed from: c */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12381c;

    /* renamed from: h */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f12382h;

    /* renamed from: a */
    private int f12383a;

    /* renamed from: b */
    private int f12384b;

    static {
        m395d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m395d() {
        C3105b c3105b = new C3105b("AbstractFullBox.java", AbstractFullBox.class);
        f12381c = c3105b.m794a("method-execution", c3105b.m795a("1", "setVersion", "org.mp4parser.support.AbstractFullBox", "int", "version", "", "void"), 51);
        f12382h = c3105b.m794a("method-execution", c3105b.m795a("1", "setFlags", "org.mp4parser.support.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractFullBox(String str) {
        super(str);
    }

    @DoNotParseDetail
    /* renamed from: p */
    public int m393p() {
        if (!this.f12378f) {
            m405m();
        }
        return this.f12383a;
    }

    /* renamed from: b */
    public void m398b(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12381c, this, this, Conversions.m804a(i)));
        this.f12383a = i;
    }

    @DoNotParseDetail
    /* renamed from: q */
    public int m392q() {
        if (!this.f12378f) {
            m405m();
        }
        return this.f12384b;
    }

    /* renamed from: c */
    public void m397c(int i) {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m792a(f12382h, this, this, Conversions.m804a(i)));
        this.f12384b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final long m396c(ByteBuffer byteBuffer) {
        this.f12383a = IsoTypeReader.m734d(byteBuffer);
        this.f12384b = IsoTypeReader.m736b(byteBuffer);
        return 4L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final void m394d(ByteBuffer byteBuffer) {
        IsoTypeWriter.m718c(byteBuffer, this.f12383a);
        IsoTypeWriter.m725a(byteBuffer, this.f12384b);
    }
}
