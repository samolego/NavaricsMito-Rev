package com.bumptech.glide.gifdecoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.view.ViewCompat;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.bumptech.glide.gifdecoder.c */
/* loaded from: classes.dex */
public class GifHeaderParser {

    /* renamed from: b */
    private ByteBuffer f485b;

    /* renamed from: c */
    private GifHeader f486c;

    /* renamed from: a */
    private final byte[] f484a = new byte[256];

    /* renamed from: d */
    private int f487d = 0;

    /* renamed from: a */
    public GifHeaderParser m12487a(@NonNull ByteBuffer byteBuffer) {
        m12484c();
        this.f485b = byteBuffer.asReadOnlyBuffer();
        this.f485b.position(0);
        this.f485b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: a */
    public void m12489a() {
        this.f485b = null;
        this.f486c = null;
    }

    /* renamed from: c */
    private void m12484c() {
        this.f485b = null;
        Arrays.fill(this.f484a, (byte) 0);
        this.f486c = new GifHeader();
        this.f487d = 0;
    }

    @NonNull
    /* renamed from: b */
    public GifHeader m12486b() {
        if (this.f485b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (m12472o()) {
            return this.f486c;
        }
        m12479h();
        if (!m12472o()) {
            m12483d();
            if (this.f486c.f473c < 0) {
                this.f486c.f472b = 1;
            }
        }
        return this.f486c;
    }

    /* renamed from: d */
    private void m12483d() {
        m12488a(Integer.MAX_VALUE);
    }

    /* renamed from: a */
    private void m12488a(int i) {
        boolean z = false;
        while (!z && !m12472o() && this.f486c.f473c <= i) {
            int m12474m = m12474m();
            if (m12474m == 33) {
                int m12474m2 = m12474m();
                if (m12474m2 == 1) {
                    m12476k();
                } else if (m12474m2 == 249) {
                    this.f486c.f474d = new GifFrame();
                    m12482e();
                } else {
                    switch (m12474m2) {
                        case 254:
                            m12476k();
                            continue;
                        case 255:
                            m12475l();
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < 11; i2++) {
                                sb.append((char) this.f484a[i2]);
                            }
                            if (sb.toString().equals("NETSCAPE2.0")) {
                                m12480g();
                                break;
                            } else {
                                m12476k();
                                continue;
                            }
                        default:
                            m12476k();
                            continue;
                    }
                }
            } else if (m12474m == 44) {
                if (this.f486c.f474d == null) {
                    this.f486c.f474d = new GifFrame();
                }
                m12481f();
            } else if (m12474m != 59) {
                this.f486c.f472b = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: e */
    private void m12482e() {
        m12474m();
        int m12474m = m12474m();
        this.f486c.f474d.f466g = (m12474m & 28) >> 2;
        if (this.f486c.f474d.f466g == 0) {
            this.f486c.f474d.f466g = 1;
        }
        this.f486c.f474d.f465f = (m12474m & 1) != 0;
        int m12473n = m12473n();
        if (m12473n < 2) {
            m12473n = 10;
        }
        this.f486c.f474d.f468i = m12473n * 10;
        this.f486c.f474d.f467h = m12474m();
        m12474m();
    }

    /* renamed from: f */
    private void m12481f() {
        this.f486c.f474d.f460a = m12473n();
        this.f486c.f474d.f461b = m12473n();
        this.f486c.f474d.f462c = m12473n();
        this.f486c.f474d.f463d = m12473n();
        int m12474m = m12474m();
        boolean z = (m12474m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m12474m & 7) + 1);
        this.f486c.f474d.f464e = (m12474m & 64) != 0;
        if (z) {
            this.f486c.f474d.f470k = m12485b(pow);
        } else {
            this.f486c.f474d.f470k = null;
        }
        this.f486c.f474d.f469j = this.f485b.position();
        m12477j();
        if (m12472o()) {
            return;
        }
        this.f486c.f473c++;
        this.f486c.f475e.add(this.f486c.f474d);
    }

    /* renamed from: g */
    private void m12480g() {
        do {
            m12475l();
            byte[] bArr = this.f484a;
            if (bArr[0] == 1) {
                this.f486c.f483m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f487d <= 0) {
                return;
            }
        } while (!m12472o());
    }

    /* renamed from: h */
    private void m12479h() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m12474m());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f486c.f472b = 1;
            return;
        }
        m12478i();
        if (!this.f486c.f478h || m12472o()) {
            return;
        }
        GifHeader gifHeader = this.f486c;
        gifHeader.f471a = m12485b(gifHeader.f479i);
        GifHeader gifHeader2 = this.f486c;
        gifHeader2.f482l = gifHeader2.f471a[this.f486c.f480j];
    }

    /* renamed from: i */
    private void m12478i() {
        this.f486c.f476f = m12473n();
        this.f486c.f477g = m12473n();
        int m12474m = m12474m();
        this.f486c.f478h = (m12474m & 128) != 0;
        this.f486c.f479i = (int) Math.pow(2.0d, (m12474m & 7) + 1);
        this.f486c.f480j = m12474m();
        this.f486c.f481k = m12474m();
    }

    @Nullable
    /* renamed from: b */
    private int[] m12485b(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f485b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f486c.f472b = 1;
        }
        return iArr;
    }

    /* renamed from: j */
    private void m12477j() {
        m12474m();
        m12476k();
    }

    /* renamed from: k */
    private void m12476k() {
        int m12474m;
        do {
            m12474m = m12474m();
            this.f485b.position(Math.min(this.f485b.position() + m12474m, this.f485b.limit()));
        } while (m12474m > 0);
    }

    /* renamed from: l */
    private void m12475l() {
        this.f487d = m12474m();
        if (this.f487d > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f487d) {
                try {
                    i2 = this.f487d - i;
                    this.f485b.get(this.f484a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f487d, e);
                    }
                    this.f486c.f472b = 1;
                    return;
                }
            }
        }
    }

    /* renamed from: m */
    private int m12474m() {
        try {
            return this.f485b.get() & 255;
        } catch (Exception unused) {
            this.f486c.f472b = 1;
            return 0;
        }
    }

    /* renamed from: n */
    private int m12473n() {
        return this.f485b.getShort();
    }

    /* renamed from: o */
    private boolean m12472o() {
        return this.f486c.f472b != 0;
    }
}
