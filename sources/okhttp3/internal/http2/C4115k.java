package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Settings.java */
/* renamed from: okhttp3.internal.http2.k */
/* loaded from: classes2.dex */
public final class C2972k {

    /* renamed from: a */
    private int f10470a;

    /* renamed from: b */
    private final int[] f10471b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2597a() {
        this.f10470a = 0;
        Arrays.fill(this.f10471b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C2972k m2595a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f10471b;
            if (i < iArr.length) {
                this.f10470a = (1 << i) | this.f10470a;
                iArr[i] = i2;
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m2596a(int i) {
        return ((1 << i) & this.f10470a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m2592b(int i) {
        return this.f10471b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m2593b() {
        return Integer.bitCount(this.f10470a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m2591c() {
        if ((this.f10470a & 2) != 0) {
            return this.f10471b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m2590c(int i) {
        return (this.f10470a & 16) != 0 ? this.f10471b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m2588d(int i) {
        return (this.f10470a & 32) != 0 ? this.f10471b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m2589d() {
        if ((this.f10470a & 128) != 0) {
            return this.f10471b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2594a(C2972k c2972k) {
        for (int i = 0; i < 10; i++) {
            if (c2972k.m2596a(i)) {
                m2595a(i, c2972k.m2592b(i));
            }
        }
    }
}
