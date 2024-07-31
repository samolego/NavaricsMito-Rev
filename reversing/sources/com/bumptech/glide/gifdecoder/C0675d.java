package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.FragmentTransaction;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.bumptech.glide.gifdecoder.d */
/* loaded from: classes.dex */
public class StandardGifDecoder implements GifDecoder {

    /* renamed from: a */
    private static final String f488a = "d";
    @ColorInt

    /* renamed from: b */
    private int[] f489b;
    @ColorInt

    /* renamed from: c */
    private final int[] f490c;

    /* renamed from: d */
    private final GifDecoder.InterfaceC0607a f491d;

    /* renamed from: e */
    private ByteBuffer f492e;

    /* renamed from: f */
    private byte[] f493f;

    /* renamed from: g */
    private short[] f494g;

    /* renamed from: h */
    private byte[] f495h;

    /* renamed from: i */
    private byte[] f496i;

    /* renamed from: j */
    private byte[] f497j;
    @ColorInt

    /* renamed from: k */
    private int[] f498k;

    /* renamed from: l */
    private int f499l;

    /* renamed from: m */
    private GifHeader f500m;

    /* renamed from: n */
    private Bitmap f501n;

    /* renamed from: o */
    private boolean f502o;

    /* renamed from: p */
    private int f503p;

    /* renamed from: q */
    private int f504q;

    /* renamed from: r */
    private int f505r;

    /* renamed from: s */
    private int f506s;
    @Nullable

    /* renamed from: t */
    private Boolean f507t;
    @NonNull

    /* renamed from: u */
    private Bitmap.Config f508u;

    public StandardGifDecoder(@NonNull GifDecoder.InterfaceC0607a interfaceC0607a, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(interfaceC0607a);
        m12465a(gifHeader, byteBuffer, i);
    }

    public StandardGifDecoder(@NonNull GifDecoder.InterfaceC0607a interfaceC0607a) {
        this.f490c = new int[256];
        this.f508u = Bitmap.Config.ARGB_8888;
        this.f491d = interfaceC0607a;
        this.f500m = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    /* renamed from: a */
    public ByteBuffer mo12471a() {
        return this.f492e;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: b */
    public void mo12464b() {
        this.f499l = (this.f499l + 1) % this.f500m.f473c;
    }

    /* renamed from: a */
    public int m12470a(int i) {
        if (i < 0 || i >= this.f500m.f473c) {
            return -1;
        }
        return this.f500m.f475e.get(i).f468i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: c */
    public int mo12462c() {
        int i;
        if (this.f500m.f473c <= 0 || (i = this.f499l) < 0) {
            return 0;
        }
        return m12470a(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: d */
    public int mo12460d() {
        return this.f500m.f473c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: e */
    public int mo12459e() {
        return this.f499l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: f */
    public void mo12458f() {
        this.f499l = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: g */
    public int mo12457g() {
        return this.f492e.limit() + this.f497j.length + (this.f498k.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    /* renamed from: h */
    public synchronized Bitmap mo12456h() {
        if (this.f500m.f473c <= 0 || this.f499l < 0) {
            if (Log.isLoggable(f488a, 3)) {
                String str = f488a;
                Log.d(str, "Unable to decode frame, frameCount=" + this.f500m.f473c + ", framePointer=" + this.f499l);
            }
            this.f503p = 1;
        }
        if (this.f503p != 1 && this.f503p != 2) {
            this.f503p = 0;
            if (this.f493f == null) {
                this.f493f = this.f491d.mo11876a(255);
            }
            GifFrame gifFrame = this.f500m.f475e.get(this.f499l);
            int i = this.f499l - 1;
            GifFrame gifFrame2 = i >= 0 ? this.f500m.f475e.get(i) : null;
            this.f489b = gifFrame.f470k != null ? gifFrame.f470k : this.f500m.f471a;
            if (this.f489b == null) {
                if (Log.isLoggable(f488a, 3)) {
                    String str2 = f488a;
                    Log.d(str2, "No valid color table found for frame #" + this.f499l);
                }
                this.f503p = 1;
                return null;
            }
            if (gifFrame.f465f) {
                System.arraycopy(this.f489b, 0, this.f490c, 0, this.f489b.length);
                this.f489b = this.f490c;
                this.f489b[gifFrame.f467h] = 0;
            }
            return m12466a(gifFrame, gifFrame2);
        }
        if (Log.isLoggable(f488a, 3)) {
            String str3 = f488a;
            Log.d(str3, "Unable to decode frame, status=" + this.f503p);
        }
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: i */
    public void mo12455i() {
        this.f500m = null;
        byte[] bArr = this.f497j;
        if (bArr != null) {
            this.f491d.mo11873a(bArr);
        }
        int[] iArr = this.f498k;
        if (iArr != null) {
            this.f491d.mo11872a(iArr);
        }
        Bitmap bitmap = this.f501n;
        if (bitmap != null) {
            this.f491d.mo11874a(bitmap);
        }
        this.f501n = null;
        this.f492e = null;
        this.f507t = null;
        byte[] bArr2 = this.f493f;
        if (bArr2 != null) {
            this.f491d.mo11873a(bArr2);
        }
    }

    /* renamed from: a */
    public synchronized void m12465a(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.f503p = 0;
        this.f500m = gifHeader;
        this.f499l = -1;
        this.f492e = byteBuffer.asReadOnlyBuffer();
        this.f492e.position(0);
        this.f492e.order(ByteOrder.LITTLE_ENDIAN);
        this.f502o = false;
        Iterator<GifFrame> it = gifHeader.f475e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f466g == 3) {
                this.f502o = true;
                break;
            }
        }
        this.f504q = highestOneBit;
        this.f506s = gifHeader.f476f / highestOneBit;
        this.f505r = gifHeader.f477g / highestOneBit;
        this.f497j = this.f491d.mo11876a(gifHeader.f476f * gifHeader.f477g);
        this.f498k = this.f491d.mo11871b(this.f506s * this.f505r);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /* renamed from: a */
    public void mo12468a(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.f508u = config;
    }

    /* renamed from: a */
    private Bitmap m12466a(GifFrame gifFrame, GifFrame gifFrame2) {
        Bitmap bitmap;
        int[] iArr = this.f498k;
        int i = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.f501n;
            if (bitmap2 != null) {
                this.f491d.mo11874a(bitmap2);
            }
            this.f501n = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f466g == 3 && this.f501n == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f466g > 0) {
            if (gifFrame2.f466g == 2) {
                if (!gifFrame.f465f) {
                    int i2 = this.f500m.f482l;
                    if (gifFrame.f470k == null || this.f500m.f480j != gifFrame.f467h) {
                        i = i2;
                    }
                } else if (this.f499l == 0) {
                    this.f507t = true;
                }
                int i3 = gifFrame2.f463d / this.f504q;
                int i4 = gifFrame2.f461b / this.f504q;
                int i5 = gifFrame2.f462c / this.f504q;
                int i6 = gifFrame2.f460a / this.f504q;
                int i7 = this.f506s;
                int i8 = (i4 * i7) + i6;
                int i9 = (i3 * i7) + i8;
                while (i8 < i9) {
                    int i10 = i8 + i5;
                    for (int i11 = i8; i11 < i10; i11++) {
                        iArr[i11] = i;
                    }
                    i8 += this.f506s;
                }
            } else if (gifFrame2.f466g == 3 && (bitmap = this.f501n) != null) {
                int i12 = this.f506s;
                bitmap.getPixels(iArr, 0, i12, 0, 0, i12, this.f505r);
            }
        }
        m12461c(gifFrame);
        if (gifFrame.f464e || this.f504q != 1) {
            m12463b(gifFrame);
        } else {
            m12467a(gifFrame);
        }
        if (this.f502o && (gifFrame.f466g == 0 || gifFrame.f466g == 1)) {
            if (this.f501n == null) {
                this.f501n = m12452l();
            }
            Bitmap bitmap3 = this.f501n;
            int i13 = this.f506s;
            bitmap3.setPixels(iArr, 0, i13, 0, 0, i13, this.f505r);
        }
        Bitmap m12452l = m12452l();
        int i14 = this.f506s;
        m12452l.setPixels(iArr, 0, i14, 0, 0, i14, this.f505r);
        return m12452l;
    }

    /* renamed from: a */
    private void m12467a(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.f498k;
        int i = gifFrame2.f463d;
        int i2 = gifFrame2.f461b;
        int i3 = gifFrame2.f462c;
        int i4 = gifFrame2.f460a;
        boolean z = this.f499l == 0;
        int i5 = this.f506s;
        byte[] bArr = this.f497j;
        int[] iArr2 = this.f489b;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = gifFrame2.f462c * i6;
            for (int i12 = i8; i12 < i9; i12++) {
                byte b2 = bArr[i11];
                int i13 = b2 & 255;
                if (i13 != b) {
                    int i14 = iArr2[i13];
                    if (i14 != 0) {
                        iArr[i12] = i14;
                    } else {
                        b = b2;
                    }
                }
                i11++;
            }
            i6++;
            gifFrame2 = gifFrame;
        }
        this.f507t = Boolean.valueOf(this.f507t == null && z && b != -1);
    }

    /* renamed from: b */
    private void m12463b(GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int[] iArr = this.f498k;
        int i4 = gifFrame.f463d / this.f504q;
        int i5 = gifFrame.f461b / this.f504q;
        int i6 = gifFrame.f462c / this.f504q;
        int i7 = gifFrame.f460a / this.f504q;
        boolean z = this.f499l == 0;
        int i8 = this.f504q;
        int i9 = this.f506s;
        int i10 = this.f505r;
        byte[] bArr = this.f497j;
        int[] iArr2 = this.f489b;
        Boolean bool = this.f507t;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        int i14 = 8;
        while (i12 < i4) {
            if (gifFrame.f464e) {
                if (i11 >= i4) {
                    i13++;
                    switch (i13) {
                        case 2:
                            i11 = 4;
                            break;
                        case 3:
                            i11 = 2;
                            i14 = 4;
                            break;
                        case 4:
                            i11 = 1;
                            i14 = 2;
                            break;
                    }
                }
                i = i11 + i14;
            } else {
                i = i11;
                i11 = i12;
            }
            int i15 = i11 + i5;
            int i16 = i4;
            boolean z2 = i8 == 1;
            if (i15 < i10) {
                int i17 = i15 * i9;
                int i18 = i17 + i7;
                i2 = i5;
                int i19 = i18 + i6;
                int i20 = i17 + i9;
                if (i20 < i19) {
                    i19 = i20;
                }
                i3 = i6;
                int i21 = i12 * i8 * gifFrame.f462c;
                if (z2) {
                    for (int i22 = i18; i22 < i19; i22++) {
                        int i23 = iArr2[bArr[i21] & 255];
                        if (i23 != 0) {
                            iArr[i22] = i23;
                        } else if (z && bool == null) {
                            bool = true;
                        }
                        i21 += i8;
                    }
                } else {
                    int i24 = ((i19 - i18) * i8) + i21;
                    int i25 = i18;
                    while (i25 < i19) {
                        int i26 = i19;
                        int m12469a = m12469a(i21, i24, gifFrame.f462c);
                        if (m12469a != 0) {
                            iArr[i25] = m12469a;
                        } else if (z && bool == null) {
                            bool = true;
                        }
                        i21 += i8;
                        i25++;
                        i19 = i26;
                    }
                }
            } else {
                i2 = i5;
                i3 = i6;
            }
            i12++;
            i11 = i;
            i4 = i16;
            i5 = i2;
            i6 = i3;
        }
        if (this.f507t == null) {
            this.f507t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    @ColorInt
    /* renamed from: a */
    private int m12469a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.f504q + i; i9++) {
            byte[] bArr = this.f497j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f489b[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.f504q + i11; i12++) {
            byte[] bArr2 = this.f497j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f489b[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private void m12461c(GifFrame gifFrame) {
        int i;
        byte b;
        int i2;
        short s;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.f492e.position(gifFrame.f469j);
        }
        int i3 = gifFrame == null ? standardGifDecoder.f500m.f476f * standardGifDecoder.f500m.f477g : gifFrame.f463d * gifFrame.f462c;
        byte[] bArr = standardGifDecoder.f497j;
        if (bArr == null || bArr.length < i3) {
            standardGifDecoder.f497j = standardGifDecoder.f491d.mo11876a(i3);
        }
        byte[] bArr2 = standardGifDecoder.f497j;
        if (standardGifDecoder.f494g == null) {
            standardGifDecoder.f494g = new short[4096];
        }
        short[] sArr = standardGifDecoder.f494g;
        if (standardGifDecoder.f495h == null) {
            standardGifDecoder.f495h = new byte[4096];
        }
        byte[] bArr3 = standardGifDecoder.f495h;
        if (standardGifDecoder.f496i == null) {
            standardGifDecoder.f496i = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = standardGifDecoder.f496i;
        int m12454j = m12454j();
        int i4 = 1 << m12454j;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = m12454j + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = standardGifDecoder.f493f;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i9 >= i3) {
                i = i18;
                b = 0;
                break;
            }
            if (i14 == 0) {
                i14 = m12453k();
                if (i14 <= 0) {
                    standardGifDecoder.f503p = 3;
                    i = i18;
                    b = 0;
                    break;
                }
                i17 = 0;
            }
            i16 += (bArr5[i17] & 255) << i15;
            i17++;
            i14--;
            int i22 = i15 + 8;
            int i23 = i19;
            int i24 = i20;
            int i25 = i12;
            int i26 = i18;
            int i27 = i9;
            int i28 = i11;
            while (true) {
                if (i22 < i28) {
                    i11 = i28;
                    i20 = i24;
                    i9 = i27;
                    i18 = i26;
                    i15 = i22;
                    i12 = i25;
                    i19 = i23;
                    standardGifDecoder = this;
                    break;
                }
                int i29 = i16 & i13;
                i16 >>= i28;
                i22 -= i28;
                if (i29 == i4) {
                    i28 = i7;
                    i25 = i6;
                    i13 = i8;
                    i23 = -1;
                } else if (i29 == i5) {
                    i15 = i22;
                    i11 = i28;
                    i9 = i27;
                    i18 = i26;
                    i12 = i25;
                    i20 = i24;
                    i19 = i23;
                    break;
                } else if (i23 == -1) {
                    bArr2[i26] = bArr3[i29];
                    i26++;
                    i27++;
                    i23 = i29;
                    i24 = i23;
                    standardGifDecoder = this;
                } else {
                    int i30 = i25;
                    if (i29 >= i30) {
                        i2 = i22;
                        bArr4[i21] = (byte) i24;
                        i21++;
                        s = i23;
                    } else {
                        i2 = i22;
                        s = i29;
                    }
                    while (s >= i4) {
                        bArr4[i21] = bArr3[s];
                        i21++;
                        s = sArr[s];
                    }
                    int i31 = bArr3[s] & 255;
                    int i32 = i7;
                    byte b2 = (byte) i31;
                    bArr2[i26] = b2;
                    i26++;
                    i27++;
                    while (i21 > 0) {
                        i21--;
                        bArr2[i26] = bArr4[i21];
                        i26++;
                        i27++;
                    }
                    if (i30 < 4096) {
                        sArr[i30] = (short) i23;
                        bArr3[i30] = b2;
                        i30++;
                        if ((i30 & i13) == 0 && i30 < 4096) {
                            i28++;
                            i13 += i30;
                        }
                    }
                    i23 = i29;
                    i22 = i2;
                    i7 = i32;
                    i24 = i31;
                    i25 = i30;
                    standardGifDecoder = this;
                }
            }
        }
        Arrays.fill(bArr2, i, i3, b);
    }

    /* renamed from: j */
    private int m12454j() {
        return this.f492e.get() & 255;
    }

    /* renamed from: k */
    private int m12453k() {
        int m12454j = m12454j();
        if (m12454j <= 0) {
            return m12454j;
        }
        ByteBuffer byteBuffer = this.f492e;
        byteBuffer.get(this.f493f, 0, Math.min(m12454j, byteBuffer.remaining()));
        return m12454j;
    }

    /* renamed from: l */
    private Bitmap m12452l() {
        Boolean bool = this.f507t;
        Bitmap mo11875a = this.f491d.mo11875a(this.f506s, this.f505r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f508u);
        mo11875a.setHasAlpha(true);
        return mo11875a;
    }
}
