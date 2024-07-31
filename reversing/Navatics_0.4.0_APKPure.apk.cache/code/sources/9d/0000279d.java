package org.mp4parser.streaming.p137a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mp4parser.streaming.InterfaceC3428a;

/* compiled from: CompositionTimeSampleExtension.java */
/* renamed from: org.mp4parser.streaming.a.b, reason: use source file name */
/* loaded from: classes2.dex */
public class CompositionTimeSampleExtension implements InterfaceC3428a {

    /* renamed from: a */
    public static Map<Long, CompositionTimeSampleExtension> f12149a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private long f12150b;

    /* renamed from: a */
    public static CompositionTimeSampleExtension m12298a(long j) {
        CompositionTimeSampleExtension compositionTimeSampleExtension = f12149a.get(Long.valueOf(j));
        if (compositionTimeSampleExtension != null) {
            return compositionTimeSampleExtension;
        }
        CompositionTimeSampleExtension compositionTimeSampleExtension2 = new CompositionTimeSampleExtension();
        compositionTimeSampleExtension2.f12150b = j;
        f12149a.put(Long.valueOf(j), compositionTimeSampleExtension2);
        return compositionTimeSampleExtension2;
    }

    /* renamed from: a */
    public long m12299a() {
        return this.f12150b;
    }

    public String toString() {
        return "ctts=" + this.f12150b;
    }
}