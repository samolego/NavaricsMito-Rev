package com.navatics.app.framework.firmware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: NavaticsUpdateFile.java */
/* renamed from: com.navatics.app.framework.firmware.i, reason: use source file name */
/* loaded from: classes.dex */
public abstract class NavaticsUpdateFile {
    /* renamed from: a */
    public abstract int mo4813a(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: a */
    public abstract long mo4814a() throws IOException;

    /* renamed from: a */
    public abstract void mo4815a(long j) throws IOException;

    /* renamed from: b */
    public abstract void mo4816b() throws IOException;

    /* renamed from: a */
    public static NavaticsUpdateFile m4812a(File file) throws FileNotFoundException {
        return new a(file);
    }

    /* compiled from: NavaticsUpdateFile.java */
    /* renamed from: com.navatics.app.framework.firmware.i$a */
    /* loaded from: classes.dex */
    static class a extends NavaticsUpdateFile {

        /* renamed from: a */
        RandomAccessFile f4663a;

        a(File file) throws FileNotFoundException {
            this.f4663a = new RandomAccessFile(file, "r");
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: a */
        public int mo4813a(byte[] bArr, int i, int i2) throws IOException {
            return this.f4663a.read(bArr, i, i2);
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: a */
        public long mo4814a() throws IOException {
            return this.f4663a.getFilePointer();
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: a */
        public void mo4815a(long j) throws IOException {
            this.f4663a.seek(j);
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: b */
        public void mo4816b() throws IOException {
            this.f4663a.close();
        }
    }
}