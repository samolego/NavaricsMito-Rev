package com.navatics.app.player.widget.media;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* compiled from: FileMediaDataSource.java */
/* renamed from: com.navatics.app.player.widget.media.a, reason: use source file name */
/* loaded from: classes.dex */
public class FileMediaDataSource implements IMediaDataSource {

    /* renamed from: a */
    private RandomAccessFile f5007a;

    /* renamed from: b */
    private long f5008b;

    public FileMediaDataSource(File file) throws IOException {
        this.f5007a = new RandomAccessFile(file, "r");
        this.f5008b = this.f5007a.length();
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        if (this.f5007a.getFilePointer() != j) {
            this.f5007a.seek(j);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.f5007a.read(bArr, 0, i2);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() throws IOException {
        return this.f5008b;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() throws IOException {
        this.f5008b = 0L;
        this.f5007a.close();
        this.f5007a = null;
    }
}