package com.navatics.app.framework.p051c;

import com.navatics.p057cv.GLES3JNIView;
import com.navatics.p057cv.NavaticsFilter;
import org.apache.log4j.C3044k;
import org.opencv.core.Mat;

/* renamed from: com.navatics.app.framework.c.a */
/* loaded from: classes.dex */
public class OpenGLFilter extends NavaticsFilter {

    /* renamed from: a */
    private static final C3044k f4301a = C3044k.m1564a(OpenGLFilter.class);

    /* renamed from: b */
    private GLES3JNIView f4302b;

    /* renamed from: a */
    public void m8555a(GLES3JNIView gLES3JNIView) {
        this.f4302b = gLES3JNIView;
    }

    @Override // com.navatics.p057cv.NavaticsFilter
    public Mat process(Mat mat) {
        try {
            if (this.f4302b == null) {
                f4301a.mo1504b((Object) "OpenGLFilter has no gl view attach to it. ");
                return null;
            }
            return this.f4302b.m6866a(mat, 10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
