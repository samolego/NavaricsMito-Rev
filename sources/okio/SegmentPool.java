package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okio.o */
/* loaded from: classes2.dex */
public final class SegmentPool {
    @Nullable

    /* renamed from: a */
    static Segment f10710a;

    /* renamed from: b */
    static long f10711b;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Segment m2218a() {
        synchronized (SegmentPool.class) {
            if (f10710a != null) {
                Segment segment = f10710a;
                f10710a = segment.f10708f;
                segment.f10708f = null;
                f10711b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m2217a(Segment segment) {
        if (segment.f10708f != null || segment.f10709g != null) {
            throw new IllegalArgumentException();
        }
        if (segment.f10706d) {
            return;
        }
        synchronized (SegmentPool.class) {
            if (f10711b + 8192 > 65536) {
                return;
            }
            f10711b += 8192;
            segment.f10708f = f10710a;
            segment.f10705c = 0;
            segment.f10704b = 0;
            f10710a = segment;
        }
    }
}
