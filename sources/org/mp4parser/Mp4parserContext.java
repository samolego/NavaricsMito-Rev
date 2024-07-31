package org.mp4parser;

import android.content.Context;
import java.io.InputStream;

/* renamed from: org.mp4parser.f */
/* loaded from: classes2.dex */
public class Mp4parserContext {

    /* renamed from: a */
    private static volatile Mp4parserContext f12104a;

    /* renamed from: b */
    private Context f12105b;

    private Mp4parserContext(Context context) {
        this.f12105b = context;
    }

    /* renamed from: a */
    public static void m521a(Context context) {
        if (f12104a == null) {
            synchronized (Mp4parserContext.class) {
                if (f12104a == null) {
                    f12104a = new Mp4parserContext(context);
                    C3125h.m520a();
                }
            }
        }
    }

    /* renamed from: a */
    public static Mp4parserContext m523a() {
        return f12104a;
    }

    /* renamed from: a */
    public static InputStream m522a(int i) {
        return m523a().f12105b.getResources().openRawResource(i);
    }
}
