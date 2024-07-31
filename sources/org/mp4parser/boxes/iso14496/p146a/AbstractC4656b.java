package org.mp4parser.boxes.iso14496.p146a;

import org.aspectj.lang.JoinPoint;
import org.aspectj.p139a.p141b.C3105b;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;

/* renamed from: org.mp4parser.boxes.iso14496.a.b */
/* loaded from: classes2.dex */
public abstract class ChunkOffsetBox extends AbstractFullBox {

    /* renamed from: a */
    private static /* synthetic */ JoinPoint.InterfaceC3109a f11908a;

    static {
        m606d();
    }

    /* renamed from: d */
    private static /* synthetic */ void m606d() {
        C3105b c3105b = new C3105b("ChunkOffsetBox.java", ChunkOffsetBox.class);
        f11908a = c3105b.m794a("method-execution", c3105b.m795a("1", "toString", "org.mp4parser.boxes.iso14496.part12.ChunkOffsetBox", "", "", "", "java.lang.String"), 19);
    }

    /* renamed from: a */
    public abstract void mo608a(long[] jArr);

    /* renamed from: c */
    public abstract long[] mo607c();

    public ChunkOffsetBox(String str) {
        super(str);
    }

    public String toString() {
        RequiresParseDetailAspect.m388a().m387a(C3105b.m793a(f11908a, this, this));
        return getClass().getSimpleName() + "[entryCount=" + mo607c().length + "]";
    }
}
