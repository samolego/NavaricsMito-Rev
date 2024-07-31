package io.reactivex.internal.util;

/* renamed from: io.reactivex.internal.util.a */
/* loaded from: classes2.dex */
public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a */
    final int f9866a;

    /* renamed from: b */
    final Object[] f9867b;

    /* renamed from: c */
    Object[] f9868c;

    /* renamed from: d */
    int f9869d;

    public AppendOnlyLinkedArrayList(int i) {
        this.f9866a = i;
        this.f9867b = new Object[i + 1];
        this.f9868c = this.f9867b;
    }

    /* renamed from: a */
    public void m3127a(T t) {
        int i = this.f9866a;
        int i2 = this.f9869d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f9868c[i] = objArr;
            this.f9868c = objArr;
            i2 = 0;
        }
        this.f9868c[i2] = t;
        this.f9869d = i2 + 1;
    }

    /* renamed from: b */
    public void m3126b(T t) {
        this.f9867b[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean m3128a(io.reactivex.InterfaceC2900o<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f9867b
            int r1 = r4.f9866a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.m3128a(io.reactivex.o):boolean");
    }
}
