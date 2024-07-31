package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.p101b.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: io.reactivex.internal.queue.a */
/* loaded from: classes2.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: a */
    static final int f9782a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f9783j = new Object();

    /* renamed from: c */
    int f9785c;

    /* renamed from: d */
    long f9786d;

    /* renamed from: e */
    final int f9787e;

    /* renamed from: f */
    AtomicReferenceArray<Object> f9788f;

    /* renamed from: g */
    final int f9789g;

    /* renamed from: h */
    AtomicReferenceArray<Object> f9790h;

    /* renamed from: b */
    final AtomicLong f9784b = new AtomicLong();

    /* renamed from: i */
    final AtomicLong f9791i = new AtomicLong();

    /* renamed from: b */
    private static int m3162b(int i) {
        return i;
    }

    public SpscLinkedArrayQueue(int i) {
        int m3119a = Pow2.m3119a(Math.max(8, i));
        int i2 = m3119a - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(m3119a + 1);
        this.f9788f = atomicReferenceArray;
        this.f9787e = i2;
        m3172a(m3119a);
        this.f9790h = atomicReferenceArray;
        this.f9789g = i2;
        this.f9786d = i2 - 1;
        m3171a(0L);
    }

    @Override // io.reactivex.internal.p101b.SimpleQueue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f9788f;
        long m3159c = m3159c();
        int i = this.f9787e;
        int m3170a = m3170a(m3159c, i);
        if (m3159c < this.f9786d) {
            return m3165a(atomicReferenceArray, t, m3159c, m3170a);
        }
        long j = this.f9785c + m3159c;
        if (m3160b(atomicReferenceArray, m3170a(j, i)) == null) {
            this.f9786d = j - 1;
            return m3165a(atomicReferenceArray, t, m3159c, m3170a);
        } else if (m3160b(atomicReferenceArray, m3170a(1 + m3159c, i)) == null) {
            return m3165a(atomicReferenceArray, t, m3159c, m3170a);
        } else {
            m3166a(atomicReferenceArray, m3159c, m3170a, t, i);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m3165a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m3168a(atomicReferenceArray, i, t);
        m3171a(j + 1);
        return true;
    }

    /* renamed from: a */
    private void m3166a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f9788f = atomicReferenceArray2;
        this.f9786d = (j2 + j) - 1;
        m3168a(atomicReferenceArray2, i, t);
        m3164a(atomicReferenceArray, atomicReferenceArray2);
        m3168a(atomicReferenceArray, i, f9783j);
        m3171a(j + 1);
    }

    /* renamed from: a */
    private void m3164a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m3168a(atomicReferenceArray, m3162b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m3169a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int m3162b = m3162b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m3160b(atomicReferenceArray, m3162b);
        m3168a(atomicReferenceArray, m3162b, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.p101b.SimplePlainQueue, io.reactivex.internal.p101b.SimpleQueue
    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f9790h;
        long m3158d = m3158d();
        int i = this.f9789g;
        int m3170a = m3170a(m3158d, i);
        T t = (T) m3160b(atomicReferenceArray, m3170a);
        boolean z = t == f9783j;
        if (t == null || z) {
            if (z) {
                return m3167a(m3169a(atomicReferenceArray, i + 1), m3158d, i);
            }
            return null;
        }
        m3168a(atomicReferenceArray, m3170a, (Object) null);
        m3161b(m3158d + 1);
        return t;
    }

    /* renamed from: a */
    private T m3167a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f9790h = atomicReferenceArray;
        int m3170a = m3170a(j, i);
        T t = (T) m3160b(atomicReferenceArray, m3170a);
        if (t != null) {
            m3168a(atomicReferenceArray, m3170a, (Object) null);
            m3161b(j + 1);
        }
        return t;
    }

    @Override // io.reactivex.internal.p101b.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.p101b.SimpleQueue
    public boolean isEmpty() {
        return m3173a() == m3163b();
    }

    /* renamed from: a */
    private void m3172a(int i) {
        this.f9785c = Math.min(i / 4, f9782a);
    }

    /* renamed from: a */
    private long m3173a() {
        return this.f9784b.get();
    }

    /* renamed from: b */
    private long m3163b() {
        return this.f9791i.get();
    }

    /* renamed from: c */
    private long m3159c() {
        return this.f9784b.get();
    }

    /* renamed from: d */
    private long m3158d() {
        return this.f9791i.get();
    }

    /* renamed from: a */
    private void m3171a(long j) {
        this.f9784b.lazySet(j);
    }

    /* renamed from: b */
    private void m3161b(long j) {
        this.f9791i.lazySet(j);
    }

    /* renamed from: a */
    private static int m3170a(long j, int i) {
        return m3162b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m3168a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: b */
    private static <E> Object m3160b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
