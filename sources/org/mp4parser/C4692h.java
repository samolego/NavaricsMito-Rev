package org.mp4parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* compiled from: Version.java */
/* renamed from: org.mp4parser.h */
/* loaded from: classes2.dex */
public class C3125h {

    /* renamed from: a */
    public static String f12106a;

    /* renamed from: b */
    private static final InterfaceC3153b f12107b = C3154c.m262a(C3125h.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m520a() {
        String str;
        try {
            str = new LineNumberReader(new InputStreamReader(Mp4parserContext.m522a(R.raw.version2))).readLine();
        } catch (IOException e) {
            f12107b.warn(e.getMessage());
            str = "unknown";
        }
        f12106a = str;
    }
}
