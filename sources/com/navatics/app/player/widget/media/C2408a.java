package com.navatics.app.player.widget.media;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* renamed from: com.navatics.app.player.widget.media.a */
/* loaded from: classes.dex */
public class FileMediaDataSource implements IMediaDataSource {

    /* renamed from: a */
    private RandomAccessFile f4985a;

    /* renamed from: b */
    private long f4986b;

    public FileMediaDataSource(File file) throws IOException {
        this.f4985a = new RandomAccessFile(file, "r");
        this.f4986b = this.f4985a.length();
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        if (this.f4985a.getFilePointer() != j) {
            this.f4985a.seek(j);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.f4985a.read(bArr, 0, i2);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() throws IOException {
        return this.f4986b;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() throws IOException {
        this.f4986b = 0L;
        this.f4985a.close();
        this.f4985a = null;
    }
}
