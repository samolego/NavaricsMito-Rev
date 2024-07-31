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

/* renamed from: com.bumptech.glide.util.a */
/* loaded from: classes.dex */
public final class ByteBufferUtil {

    /* renamed from: a */
    private static final AtomicReference<byte[]> f1281a = new AtomicReference<>();

    @NonNull
    /* renamed from: a */
    public static ByteBuffer m11625a(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
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
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    /* renamed from: a */
    public static void m11623a(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
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
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @NonNull
    /* renamed from: a */
    public static byte[] m11624a(@NonNull ByteBuffer byteBuffer) {
        C0781b m11621c = m11621c(byteBuffer);
        if (m11621c != null && m11621c.f1284a == 0 && m11621c.f1285b == m11621c.f1286c.length) {
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
    public static InputStream m11622b(@NonNull ByteBuffer byteBuffer) {
        return new C0780a(byteBuffer);
    }

    @Nullable
    /* renamed from: c */
    private static C0781b m11621c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new C0781b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$b */
    /* loaded from: classes.dex */
    public static final class C0781b {

        /* renamed from: a */
        final int f1284a;

        /* renamed from: b */
        final int f1285b;

        /* renamed from: c */
        final byte[] f1286c;

        C0781b(@NonNull byte[] bArr, int i, int i2) {
            this.f1286c = bArr;
            this.f1284a = i;
            this.f1285b = i2;
        }
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.util.a$a */
    /* loaded from: classes.dex */
    private static class C0780a extends InputStream {
        @NonNull

        /* renamed from: a */
        private final ByteBuffer f1282a;

        /* renamed from: b */
        private int f1283b = -1;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        C0780a(@NonNull ByteBuffer byteBuffer) {
            this.f1282a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f1282a.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f1282a.hasRemaining()) {
                return this.f1282a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f1283b = this.f1282a.position();
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            if (this.f1282a.hasRemaining()) {
                int min = Math.min(i2, available());
                this.f1282a.get(bArr, i, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.f1283b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f1282a.position(this.f1283b);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (this.f1282a.hasRemaining()) {
                long min = Math.min(j, available());
                ByteBuffer byteBuffer = this.f1282a;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }
    }
}
