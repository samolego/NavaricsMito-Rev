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

/* compiled from: QueueFile.java */
/* renamed from: com.twitter.sdk.android.core.internal.scribe.o, reason: use source file name */
/* loaded from: classes2.dex */
public class QueueFile implements Closeable {

    /* renamed from: b */
    private static final Logger f8670b = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: a */
    int f8671a;

    /* renamed from: c */
    private final RandomAccessFile f8672c;

    /* renamed from: d */
    private int f8673d;

    /* renamed from: e */
    private a f8674e;

    /* renamed from: f */
    private a f8675f;

    /* renamed from: g */
    private final byte[] f8676g = new byte[16];

    /* compiled from: QueueFile.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$c */
    /* loaded from: classes2.dex */
    public interface c {
        /* renamed from: a */
        void mo8493a(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            m8560a(file);
        }
        this.f8672c = m8563b(file);
        m8567c();
    }

    /* renamed from: b */
    private static void m8566b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static void m8561a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            m8566b(bArr, i, i2);
            i += 4;
        }
    }

    /* renamed from: a */
    private static int m8553a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: c */
    private void m8567c() throws IOException {
        this.f8672c.seek(0L);
        this.f8672c.readFully(this.f8676g);
        this.f8671a = m8553a(this.f8676g, 0);
        if (this.f8671a > this.f8672c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f8671a + ", Actual length: " + this.f8672c.length());
        }
        this.f8673d = m8553a(this.f8676g, 4);
        int m8553a = m8553a(this.f8676g, 8);
        int m8553a2 = m8553a(this.f8676g, 12);
        this.f8674e = m8554a(m8553a);
        this.f8675f = m8554a(m8553a2);
    }

    /* renamed from: a */
    private void m8557a(int i, int i2, int i3, int i4) throws IOException {
        m8561a(this.f8676g, i, i2, i3, i4);
        this.f8672c.seek(0L);
        this.f8672c.write(this.f8676g);
    }

    /* renamed from: a */
    private a m8554a(int i) throws IOException {
        if (i == 0) {
            return a.f8680a;
        }
        this.f8672c.seek(i);
        return new a(i, this.f8672c.readInt());
    }

    /* renamed from: a */
    private static void m8560a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile m8563b = m8563b(file2);
        try {
            m8563b.setLength(4096L);
            m8563b.seek(0L);
            byte[] bArr = new byte[16];
            m8561a(bArr, 4096, 0, 0, 0);
            m8563b.write(bArr);
            m8563b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            m8563b.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static RandomAccessFile m8563b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m8562b(int i) {
        int i2 = this.f8671a;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: a */
    private void m8558a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int m8562b = m8562b(i);
        int i4 = m8562b + i3;
        int i5 = this.f8671a;
        if (i4 <= i5) {
            this.f8672c.seek(m8562b);
            this.f8672c.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m8562b;
        this.f8672c.seek(m8562b);
        this.f8672c.write(bArr, i2, i6);
        this.f8672c.seek(16L);
        this.f8672c.write(bArr, i2 + i6, i3 - i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8565b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int m8562b = m8562b(i);
        int i4 = m8562b + i3;
        int i5 = this.f8671a;
        if (i4 <= i5) {
            this.f8672c.seek(m8562b);
            this.f8672c.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m8562b;
        this.f8672c.seek(m8562b);
        this.f8672c.readFully(bArr, i2, i6);
        this.f8672c.seek(16L);
        this.f8672c.readFully(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: a */
    public void m8573a(byte[] bArr) throws IOException {
        m8574a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void m8574a(byte[] bArr, int i, int i2) throws IOException {
        m8564b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m8568c(i2);
        boolean m8576b = m8576b();
        a aVar = new a(m8576b ? 16 : m8562b(this.f8675f.f8681b + 4 + this.f8675f.f8682c), i2);
        m8566b(this.f8676g, 0, i2);
        m8558a(aVar.f8681b, this.f8676g, 0, 4);
        m8558a(aVar.f8681b + 4, bArr, i, i2);
        m8557a(this.f8671a, this.f8673d + 1, m8576b ? aVar.f8681b : this.f8674e.f8681b, aVar.f8681b);
        this.f8675f = aVar;
        this.f8673d++;
        if (m8576b) {
            this.f8674e = this.f8675f;
        }
    }

    /* renamed from: a */
    public int m8571a() {
        if (this.f8673d == 0) {
            return 16;
        }
        if (this.f8675f.f8681b >= this.f8674e.f8681b) {
            return (this.f8675f.f8681b - this.f8674e.f8681b) + 4 + this.f8675f.f8682c + 16;
        }
        return (((this.f8675f.f8681b + 4) + this.f8675f.f8682c) + this.f8671a) - this.f8674e.f8681b;
    }

    /* renamed from: d */
    private int m8569d() {
        return this.f8671a - m8571a();
    }

    /* renamed from: b */
    public synchronized boolean m8576b() {
        return this.f8673d == 0;
    }

    /* renamed from: c */
    private void m8568c(int i) throws IOException {
        int i2 = i + 4;
        int m8569d = m8569d();
        if (m8569d >= i2) {
            return;
        }
        int i3 = this.f8671a;
        do {
            m8569d += i3;
            i3 <<= 1;
        } while (m8569d < i2);
        m8570d(i3);
        int m8562b = m8562b(this.f8675f.f8681b + 4 + this.f8675f.f8682c);
        if (m8562b < this.f8674e.f8681b) {
            FileChannel channel = this.f8672c.getChannel();
            channel.position(this.f8671a);
            long j = m8562b - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        if (this.f8675f.f8681b < this.f8674e.f8681b) {
            int i4 = (this.f8671a + this.f8675f.f8681b) - 16;
            m8557a(i3, this.f8673d, this.f8674e.f8681b, i4);
            this.f8675f = new a(i4, this.f8675f.f8682c);
        } else {
            m8557a(i3, this.f8673d, this.f8674e.f8681b, this.f8675f.f8681b);
        }
        this.f8671a = i3;
    }

    /* renamed from: d */
    private void m8570d(int i) throws IOException {
        this.f8672c.setLength(i);
        this.f8672c.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized void m8572a(c cVar) throws IOException {
        int i = this.f8674e.f8681b;
        for (int i2 = 0; i2 < this.f8673d; i2++) {
            a m8554a = m8554a(i);
            cVar.mo8493a(new b(m8554a), m8554a.f8682c);
            i = m8562b(m8554a.f8681b + 4 + m8554a.f8682c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m8564b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QueueFile.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$b */
    /* loaded from: classes2.dex */
    public final class b extends InputStream {

        /* renamed from: b */
        private int f8684b;

        /* renamed from: c */
        private int f8685c;

        private b(a aVar) {
            this.f8684b = QueueFile.this.m8562b(aVar.f8681b + 4);
            this.f8685c = aVar.f8682c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            QueueFile.m8564b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f8685c;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.m8565b(this.f8684b, bArr, i, i2);
            this.f8684b = QueueFile.this.m8562b(this.f8684b + i2);
            this.f8685c -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f8685c == 0) {
                return -1;
            }
            QueueFile.this.f8672c.seek(this.f8684b);
            int read = QueueFile.this.f8672c.read();
            this.f8684b = QueueFile.this.m8562b(this.f8684b + 1);
            this.f8685c--;
            return read;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f8672c.close();
    }

    /* renamed from: a */
    public boolean m8575a(int i, int i2) {
        return (m8571a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(IniEditor.Section.HEADER_START);
        sb.append("fileLength=");
        sb.append(this.f8671a);
        sb.append(", size=");
        sb.append(this.f8673d);
        sb.append(", first=");
        sb.append(this.f8674e);
        sb.append(", last=");
        sb.append(this.f8675f);
        sb.append(", element lengths=[");
        try {
            m8572a(new c() { // from class: com.twitter.sdk.android.core.internal.scribe.o.1

                /* renamed from: a */
                boolean f8677a = true;

                @Override // com.twitter.sdk.android.core.internal.scribe.QueueFile.c
                /* renamed from: a */
                public void mo8493a(InputStream inputStream, int i) throws IOException {
                    if (this.f8677a) {
                        this.f8677a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f8670b.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueueFile.java */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$a */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        static final a f8680a = new a(0, 0);

        /* renamed from: b */
        final int f8681b;

        /* renamed from: c */
        final int f8682c;

        a(int i, int i2) {
            this.f8681b = i;
            this.f8682c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f8681b + ", length = " + this.f8682c + "]";
        }
    }
}