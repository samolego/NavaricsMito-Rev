package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Settings.java */
/* renamed from: okhttp3.internal.http2.k */
/* loaded from: classes2.dex */
public final class C2969k {

    /* renamed from: a */
    private int f10511a;

    /* renamed from: b */
    private final int[] f10512b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10267a() {
        this.f10511a = 0;
        Arrays.fill(this.f10512b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C2969k m10266a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f10512b;
            if (i < iArr.length) {
                this.f10511a = (1 << i) | this.f10511a;
                iArr[i] = i2;
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m10269a(int i) {
        return ((1 << i) & this.f10511a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m10271b(int i) {
        return this.f10512b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m10270b() {
        return Integer.bitCount(this.f10511a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m10272c() {
        if ((this.f10511a & 2) != 0) {
            return this.f10512b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m10273c(int i) {
        return (this.f10511a & 16) != 0 ? this.f10512b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m10275d(int i) {
        return (this.f10511a & 32) != 0 ? this.f10512b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m10274d() {
        if ((this.f10511a & 128) != 0) {
            return this.f10512b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10268a(C2969k c2969k) {
        for (int i = 0; i < 10; i++) {
            if (c2969k.m10269a(i)) {
                m10266a(i, c2969k.m10271b(i));
            }
        }
    }
}