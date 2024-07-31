package okio;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* renamed from: okio.o, reason: use source file name */
/* loaded from: classes2.dex */
public final class SegmentPool {

    /* renamed from: a */
    @Nullable
    static Segment f10751a;

    /* renamed from: b */
    static long f10752b;

    private SegmentPool() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Segment m10628a() {
        synchronized (SegmentPool.class) {
            if (f10751a != null) {
                Segment segment = f10751a;
                f10751a = segment.f10749f;
                segment.f10749f = null;
                f10752b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m10629a(Segment segment) {
        if (segment.f10749f != null || segment.f10750g != null) {
            throw new IllegalArgumentException();
        }
        if (segment.f10747d) {
            return;
        }
        synchronized (SegmentPool.class) {
            if (f10752b + 8192 > 65536) {
                return;
            }
            f10752b += 8192;
            segment.f10749f = f10751a;
            segment.f10746c = 0;
            segment.f10745b = 0;
            f10751a = segment;
        }
    }
}