package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import android.support.p008v4.internal.view.SupportMenu;
import android.support.p008v4.view.InputDeviceCompat;
import android.support.p008v4.view.MotionEventCompat;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.bumptech.glide.load.resource.bitmap.j */
/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a */
    static final byte[] f1040a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b */
    private static final int[] f1041b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.j$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0746c {
        /* renamed from: a */
        int mo11960a() throws IOException;

        /* renamed from: a */
        int mo11958a(byte[] bArr, int i) throws IOException;

        /* renamed from: a */
        long mo11959a(long j) throws IOException;

        /* renamed from: b */
        short mo11957b() throws IOException;

        /* renamed from: c */
        int mo11956c() throws IOException;
    }

    /* renamed from: a */
    private static int m11975a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* renamed from: a */
    private static boolean m11976a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo11970a(@NonNull InputStream inputStream) throws IOException {
        return m11973a(new C0747d((InputStream) Preconditions.m11580a(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo11968a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return m11973a(new C0744a((ByteBuffer) Preconditions.m11580a(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public int mo11969a(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return m11972a(new C0747d((InputStream) Preconditions.m11580a(inputStream)), (ArrayPool) Preconditions.m11580a(arrayPool));
    }

    @NonNull
    /* renamed from: a */
    private ImageHeaderParser.ImageType m11973a(InterfaceC0746c interfaceC0746c) throws IOException {
        int mo11960a = interfaceC0746c.mo11960a();
        if (mo11960a == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int mo11960a2 = ((mo11960a << 16) & SupportMenu.CATEGORY_MASK) | (interfaceC0746c.mo11960a() & 65535);
        if (mo11960a2 == -1991225785) {
            interfaceC0746c.mo11959a(21L);
            return interfaceC0746c.mo11956c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((mo11960a2 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (mo11960a2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            interfaceC0746c.mo11959a(4L);
            if ((((interfaceC0746c.mo11960a() << 16) & SupportMenu.CATEGORY_MASK) | (interfaceC0746c.mo11960a() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int mo11960a3 = ((interfaceC0746c.mo11960a() << 16) & SupportMenu.CATEGORY_MASK) | (interfaceC0746c.mo11960a() & 65535);
            if ((mo11960a3 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = mo11960a3 & 255;
            if (i == 88) {
                interfaceC0746c.mo11959a(4L);
                return (interfaceC0746c.mo11956c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i == 76) {
                interfaceC0746c.mo11959a(4L);
                return (interfaceC0746c.mo11956c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    /* renamed from: a */
    private int m11972a(InterfaceC0746c interfaceC0746c, ArrayPool arrayPool) throws IOException {
        int mo11960a = interfaceC0746c.mo11960a();
        if (!m11976a(mo11960a)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + mo11960a);
            }
            return -1;
        }
        int m11966b = m11966b(interfaceC0746c);
        if (m11966b == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) arrayPool.mo12200a(m11966b, byte[].class);
        try {
            return m11971a(interfaceC0746c, bArr, m11966b);
        } finally {
            arrayPool.mo12195a((ArrayPool) bArr);
        }
    }

    /* renamed from: a */
    private int m11971a(InterfaceC0746c interfaceC0746c, byte[] bArr, int i) throws IOException {
        int mo11958a = interfaceC0746c.mo11958a(bArr, i);
        if (mo11958a != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + mo11958a);
            }
            return -1;
        } else if (m11967a(bArr, i)) {
            return m11974a(new C0745b(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    /* renamed from: a */
    private boolean m11967a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f1040a.length;
        if (!z) {
            return z;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f1040a;
            if (i2 >= bArr2.length) {
                return z;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* renamed from: b */
    private int m11966b(InterfaceC0746c interfaceC0746c) throws IOException {
        short mo11957b;
        short mo11957b2;
        int mo11960a;
        long j;
        long mo11959a;
        do {
            if (interfaceC0746c.mo11957b() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) mo11957b));
                }
                return -1;
            }
            mo11957b2 = interfaceC0746c.mo11957b();
            if (mo11957b2 == 218) {
                return -1;
            }
            if (mo11957b2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            mo11960a = interfaceC0746c.mo11960a() - 2;
            if (mo11957b2 == 225) {
                return mo11960a;
            }
            j = mo11960a;
            mo11959a = interfaceC0746c.mo11959a(j);
        } while (mo11959a == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) mo11957b2) + ", wanted to skip: " + mo11960a + ", but actually skipped: " + mo11959a);
        }
        return -1;
    }

    /* renamed from: a */
    private static int m11974a(C0745b c0745b) {
        ByteOrder byteOrder;
        short m11961b = c0745b.m11961b(6);
        if (m11961b == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (m11961b == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) m11961b));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        c0745b.m11962a(byteOrder);
        int m11964a = c0745b.m11964a(10) + 6;
        short m11961b2 = c0745b.m11961b(m11964a);
        for (int i = 0; i < m11961b2; i++) {
            int m11975a = m11975a(m11964a, i);
            short m11961b3 = c0745b.m11961b(m11975a);
            if (m11961b3 == 274) {
                short m11961b4 = c0745b.m11961b(m11975a + 2);
                if (m11961b4 < 1 || m11961b4 > 12) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) m11961b4));
                    }
                } else {
                    int m11964a2 = c0745b.m11964a(m11975a + 4);
                    if (m11964a2 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) m11961b3) + " formatCode=" + ((int) m11961b4) + " componentCount=" + m11964a2);
                        }
                        int i2 = m11964a2 + f1041b[m11961b4];
                        if (i2 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) m11961b4));
                            }
                        } else {
                            int i3 = m11975a + 8;
                            if (i3 < 0 || i3 > c0745b.m11965a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) m11961b3));
                                }
                            } else if (i2 < 0 || i2 + i3 > c0745b.m11965a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) m11961b3));
                                }
                            } else {
                                return c0745b.m11961b(i3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.j$b */
    /* loaded from: classes.dex */
    public static final class C0745b {

        /* renamed from: a */
        private final ByteBuffer f1043a;

        C0745b(byte[] bArr, int i) {
            this.f1043a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* renamed from: a */
        void m11962a(ByteOrder byteOrder) {
            this.f1043a.order(byteOrder);
        }

        /* renamed from: a */
        int m11965a() {
            return this.f1043a.remaining();
        }

        /* renamed from: a */
        int m11964a(int i) {
            if (m11963a(i, 4)) {
                return this.f1043a.getInt(i);
            }
            return -1;
        }

        /* renamed from: b */
        short m11961b(int i) {
            if (m11963a(i, 2)) {
                return this.f1043a.getShort(i);
            }
            return (short) -1;
        }

        /* renamed from: a */
        private boolean m11963a(int i, int i2) {
            return this.f1043a.remaining() - i >= i2;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.j$a */
    /* loaded from: classes.dex */
    private static final class C0744a implements InterfaceC0746c {

        /* renamed from: a */
        private final ByteBuffer f1042a;

        C0744a(ByteBuffer byteBuffer) {
            this.f1042a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: a */
        public int mo11960a() {
            return ((mo11956c() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (mo11956c() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: b */
        public short mo11957b() {
            return (short) (mo11956c() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: a */
        public long mo11959a(long j) {
            int min = (int) Math.min(this.f1042a.remaining(), j);
            ByteBuffer byteBuffer = this.f1042a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: a */
        public int mo11958a(byte[] bArr, int i) {
            int min = Math.min(i, this.f1042a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f1042a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: c */
        public int mo11956c() {
            if (this.f1042a.remaining() < 1) {
                return -1;
            }
            return this.f1042a.get();
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.j$d */
    /* loaded from: classes.dex */
    private static final class C0747d implements InterfaceC0746c {

        /* renamed from: a */
        private final InputStream f1044a;

        C0747d(InputStream inputStream) {
            this.f1044a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: a */
        public int mo11960a() throws IOException {
            return ((this.f1044a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f1044a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: b */
        public short mo11957b() throws IOException {
            return (short) (this.f1044a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: a */
        public long mo11959a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f1044a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f1044a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: a */
        public int mo11958a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f1044a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.InterfaceC0746c
        /* renamed from: c */
        public int mo11956c() throws IOException {
            return this.f1044a.read();
        }
    }
}
