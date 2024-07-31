package com.twitter.sdk.android.core.internal.scribe;

import com.senseplay.sdk.tool.IniEditor;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.o */
/* loaded from: classes2.dex */
public class QueueFile implements Closeable {

    /* renamed from: b */
    private static final Logger f8630b = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: a */
    int f8631a;

    /* renamed from: c */
    private final RandomAccessFile f8632c;

    /* renamed from: d */
    private int f8633d;

    /* renamed from: e */
    private C2684a f8634e;

    /* renamed from: f */
    private C2684a f8635f;

    /* renamed from: g */
    private final byte[] f8636g = new byte[16];

    /* compiled from: QueueFile.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$c */
    /* loaded from: classes2.dex */
    public interface InterfaceC2686c {
        /* renamed from: a */
        void mo4295a(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            m4311a(file);
        }
        this.f8632c = m4302b(file);
        m4299c();
    }

    /* renamed from: b */
    private static void m4300b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static void m4306a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            m4300b(bArr, i, i2);
            i += 4;
        }
    }

    /* renamed from: a */
    private static int m4308a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: c */
    private void m4299c() throws IOException {
        this.f8632c.seek(0L);
        this.f8632c.readFully(this.f8636g);
        this.f8631a = m4308a(this.f8636g, 0);
        if (this.f8631a > this.f8632c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f8631a + ", Actual length: " + this.f8632c.length());
        }
        this.f8633d = m4308a(this.f8636g, 4);
        int m4308a = m4308a(this.f8636g, 8);
        int m4308a2 = m4308a(this.f8636g, 12);
        this.f8634e = m4319a(m4308a);
        this.f8635f = m4319a(m4308a2);
    }

    /* renamed from: a */
    private void m4317a(int i, int i2, int i3, int i4) throws IOException {
        m4306a(this.f8636g, i, i2, i3, i4);
        this.f8632c.seek(0L);
        this.f8632c.write(this.f8636g);
    }

    /* renamed from: a */
    private C2684a m4319a(int i) throws IOException {
        if (i == 0) {
            return C2684a.f8640a;
        }
        this.f8632c.seek(i);
        return new C2684a(i, this.f8632c.readInt());
    }

    /* renamed from: a */
    private static void m4311a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile m4302b = m4302b(file2);
        try {
            m4302b.setLength(4096L);
            m4302b.seek(0L);
            byte[] bArr = new byte[16];
            m4306a(bArr, 4096, 0, 0, 0);
            m4302b.write(bArr);
            m4302b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            m4302b.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static RandomAccessFile m4302b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m4304b(int i) {
        int i2 = this.f8631a;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: a */
    private void m4316a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int m4304b = m4304b(i);
        int i4 = m4304b + i3;
        int i5 = this.f8631a;
        if (i4 <= i5) {
            this.f8632c.seek(m4304b);
            this.f8632c.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m4304b;
        this.f8632c.seek(m4304b);
        this.f8632c.write(bArr, i2, i6);
        this.f8632c.seek(16L);
        this.f8632c.write(bArr, i2 + i6, i3 - i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4303b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int m4304b = m4304b(i);
        int i4 = m4304b + i3;
        int i5 = this.f8631a;
        if (i4 <= i5) {
            this.f8632c.seek(m4304b);
            this.f8632c.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m4304b;
        this.f8632c.seek(m4304b);
        this.f8632c.readFully(bArr, i2, i6);
        this.f8632c.seek(16L);
        this.f8632c.readFully(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: a */
    public void m4309a(byte[] bArr) throws IOException {
        m4307a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void m4307a(byte[] bArr, int i, int i2) throws IOException {
        m4301b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m4298c(i2);
        boolean m4305b = m4305b();
        C2684a c2684a = new C2684a(m4305b ? 16 : m4304b(this.f8635f.f8641b + 4 + this.f8635f.f8642c), i2);
        m4300b(this.f8636g, 0, i2);
        m4316a(c2684a.f8641b, this.f8636g, 0, 4);
        m4316a(c2684a.f8641b + 4, bArr, i, i2);
        m4317a(this.f8631a, this.f8633d + 1, m4305b ? c2684a.f8641b : this.f8634e.f8641b, c2684a.f8641b);
        this.f8635f = c2684a;
        this.f8633d++;
        if (m4305b) {
            this.f8634e = this.f8635f;
        }
    }

    /* renamed from: a */
    public int m4320a() {
        if (this.f8633d == 0) {
            return 16;
        }
        if (this.f8635f.f8641b >= this.f8634e.f8641b) {
            return (this.f8635f.f8641b - this.f8634e.f8641b) + 4 + this.f8635f.f8642c + 16;
        }
        return (((this.f8635f.f8641b + 4) + this.f8635f.f8642c) + this.f8631a) - this.f8634e.f8641b;
    }

    /* renamed from: d */
    private int m4297d() {
        return this.f8631a - m4320a();
    }

    /* renamed from: b */
    public synchronized boolean m4305b() {
        return this.f8633d == 0;
    }

    /* renamed from: c */
    private void m4298c(int i) throws IOException {
        int i2 = i + 4;
        int m4297d = m4297d();
        if (m4297d >= i2) {
            return;
        }
        int i3 = this.f8631a;
        do {
            m4297d += i3;
            i3 <<= 1;
        } while (m4297d < i2);
        m4296d(i3);
        int m4304b = m4304b(this.f8635f.f8641b + 4 + this.f8635f.f8642c);
        if (m4304b < this.f8634e.f8641b) {
            FileChannel channel = this.f8632c.getChannel();
            channel.position(this.f8631a);
            long j = m4304b - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        if (this.f8635f.f8641b < this.f8634e.f8641b) {
            int i4 = (this.f8631a + this.f8635f.f8641b) - 16;
            m4317a(i3, this.f8633d, this.f8634e.f8641b, i4);
            this.f8635f = new C2684a(i4, this.f8635f.f8642c);
        } else {
            m4317a(i3, this.f8633d, this.f8634e.f8641b, this.f8635f.f8641b);
        }
        this.f8631a = i3;
    }

    /* renamed from: d */
    private void m4296d(int i) throws IOException {
        this.f8632c.setLength(i);
        this.f8632c.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized void m4315a(InterfaceC2686c interfaceC2686c) throws IOException {
        int i = this.f8634e.f8641b;
        for (int i2 = 0; i2 < this.f8633d; i2++) {
            C2684a m4319a = m4319a(i);
            interfaceC2686c.mo4295a(new C2685b(m4319a), m4319a.f8642c);
            i = m4304b(m4319a.f8641b + 4 + m4319a.f8642c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m4301b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QueueFile.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$b */
    /* loaded from: classes2.dex */
    public final class C2685b extends InputStream {

        /* renamed from: b */
        private int f8644b;

        /* renamed from: c */
        private int f8645c;

        private C2685b(C2684a c2684a) {
            this.f8644b = QueueFile.this.m4304b(c2684a.f8641b + 4);
            this.f8645c = c2684a.f8642c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            QueueFile.m4301b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f8645c;
            if (i3 > 0) {
                if (i2 > i3) {
                    i2 = i3;
                }
                QueueFile.this.m4303b(this.f8644b, bArr, i, i2);
                this.f8644b = QueueFile.this.m4304b(this.f8644b + i2);
                this.f8645c -= i2;
                return i2;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f8645c == 0) {
                return -1;
            }
            QueueFile.this.f8632c.seek(this.f8644b);
            int read = QueueFile.this.f8632c.read();
            this.f8644b = QueueFile.this.m4304b(this.f8644b + 1);
            this.f8645c--;
            return read;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f8632c.close();
    }

    /* renamed from: a */
    public boolean m4318a(int i, int i2) {
        return (m4320a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(IniEditor.Section.HEADER_START);
        sb.append("fileLength=");
        sb.append(this.f8631a);
        sb.append(", size=");
        sb.append(this.f8633d);
        sb.append(", first=");
        sb.append(this.f8634e);
        sb.append(", last=");
        sb.append(this.f8635f);
        sb.append(", element lengths=[");
        try {
            m4315a(new InterfaceC2686c() { // from class: com.twitter.sdk.android.core.internal.scribe.o.1

                /* renamed from: a */
                boolean f8637a = true;

                @Override // com.twitter.sdk.android.core.internal.scribe.QueueFile.InterfaceC2686c
                /* renamed from: a */
                public void mo4295a(InputStream inputStream, int i) throws IOException {
                    if (this.f8637a) {
                        this.f8637a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f8630b.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueueFile.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$a */
    /* loaded from: classes2.dex */
    public static class C2684a {

        /* renamed from: a */
        static final C2684a f8640a = new C2684a(0, 0);

        /* renamed from: b */
        final int f8641b;

        /* renamed from: c */
        final int f8642c;

        C2684a(int i, int i2) {
            this.f8641b = i;
            this.f8642c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f8641b + ", length = " + this.f8642c + "]";
        }
    }
}
