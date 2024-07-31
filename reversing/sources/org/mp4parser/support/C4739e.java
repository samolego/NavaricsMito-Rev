package org.mp4parser.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
/* renamed from: org.mp4parser.support.e */
/* loaded from: classes2.dex */
public class RequiresParseDetailAspect {

    /* renamed from: a */
    public static /* synthetic */ RequiresParseDetailAspect f12398a;

    /* renamed from: b */
    private static /* synthetic */ Throwable f12399b;

    static {
        try {
            m386b();
        } catch (Throwable th) {
            f12399b = th;
        }
    }

    /* renamed from: a */
    public static RequiresParseDetailAspect m388a() {
        RequiresParseDetailAspect requiresParseDetailAspect = f12398a;
        if (requiresParseDetailAspect != null) {
            return requiresParseDetailAspect;
        }
        throw new NoAspectBoundException("org.mp4parser.support.RequiresParseDetailAspect", f12399b);
    }

    /* renamed from: b */
    private static /* synthetic */ void m386b() {
        f12398a = new RequiresParseDetailAspect();
    }

    @Before
    /* renamed from: a */
    public void m387a(JoinPoint joinPoint) {
        if (joinPoint.mo761a() instanceof AbstractBox) {
            if (((AbstractBox) joinPoint.mo761a()).m403o()) {
                return;
            }
            ((AbstractBox) joinPoint.mo761a()).m405m();
            return;
        }
        throw new RuntimeException("Only methods in subclasses of " + AbstractBox.class.getName() + " can  be annotated with ParseDetail");
    }
}
