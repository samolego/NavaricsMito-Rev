package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteBufferUtil.java */
/* renamed from: com.bumptech.glide.util.a */
/* loaded from: classes.dex */
public final class C0770a {

    /* renamed from: a */
    private static final AtomicReference<byte[]> f1285a = new AtomicReference<>();

    @NonNull
    /* renamed from: a */
    public static ByteBuffer m1321a(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th2) {
                fileChannel = channel;
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    /* renamed from: a */
    public static void m1322a(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    @NonNull
    /* renamed from: a */
    public static byte[] m1323a(@NonNull ByteBuffer byteBuffer) {
        b m1325c = m1325c(byteBuffer);
        if (m1325c != null && m1325c.f1292a == 0 && m1325c.f1293b == m1325c.f1294c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    /* renamed from: b */
    public static InputStream m1324b(@NonNull ByteBuffer byteBuffer) {
        return new a(byteBuffer);
    }

    @Nullable
    /* renamed from: c */
    private static b m1325c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        final int f1292a;

        /* renamed from: b */
        final int f1293b;

        /* renamed from: c */
        final byte[] f1294c;

        b(@NonNull byte[] bArr, int i, int i2) {
            this.f1294c = bArr;
            this.f1292a = i;
            this.f1293b = i2;
        }
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$a */
    /* loaded from: classes.dex */
    private static class a extends InputStream {

        /* renamed from: a */
        @NonNull
        private final ByteBuffer f1286a;

        /* renamed from: b */
        private int f1287b = -1;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        a(@NonNull ByteBuffer byteBuffer) {
            this.f1286a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f1286a.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f1286a.hasRemaining()) {
                return this.f1286a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f1287b = this.f1286a.position();
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            if (!this.f1286a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.f1286a.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.f1287b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f1286a.position(this.f1287b);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (!this.f1286a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j, available());
            this.f1286a.position((int) (r0.position() + min));
            return min;
        }
    }
}