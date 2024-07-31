package org.mp4parser.streaming.p148a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mp4parser.streaming.SampleExtension;

/* renamed from: org.mp4parser.streaming.a.b */
/* loaded from: classes2.dex */
public class CompositionTimeSampleExtension implements SampleExtension {

    /* renamed from: a */
    public static Map<Long, CompositionTimeSampleExtension> f12108a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private long f12109b;

    /* renamed from: a */
    public static CompositionTimeSampleExtension m518a(long j) {
        CompositionTimeSampleExtension compositionTimeSampleExtension = f12108a.get(Long.valueOf(j));
        if (compositionTimeSampleExtension == null) {
            CompositionTimeSampleExtension compositionTimeSampleExtension2 = new CompositionTimeSampleExtension();
            compositionTimeSampleExtension2.f12109b = j;
            f12108a.put(Long.valueOf(j), compositionTimeSampleExtension2);
            return compositionTimeSampleExtension2;
        }
        return compositionTimeSampleExtension;
    }

    /* renamed from: a */
    public long m519a() {
        return this.f12109b;
    }

    public String toString() {
        return "ctts=" + this.f12109b;
    }
}
