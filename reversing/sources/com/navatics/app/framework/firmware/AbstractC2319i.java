package com.navatics.app.framework.firmware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.navatics.app.framework.firmware.i */
/* loaded from: classes.dex */
public abstract class NavaticsUpdateFile {
    /* renamed from: a */
    public abstract int mo8168a(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: a */
    public abstract long mo8170a() throws IOException;

    /* renamed from: a */
    public abstract void mo8169a(long j) throws IOException;

    /* renamed from: b */
    public abstract void mo8167b() throws IOException;

    /* renamed from: a */
    public static NavaticsUpdateFile m8171a(File file) throws FileNotFoundException {
        return new C1832a(file);
    }

    /* compiled from: NavaticsUpdateFile.java */
    /* renamed from: com.navatics.app.framework.firmware.i$a */
    /* loaded from: classes.dex */
    static class C1832a extends NavaticsUpdateFile {

        /* renamed from: a */
        RandomAccessFile f4641a;

        C1832a(File file) throws FileNotFoundException {
            this.f4641a = new RandomAccessFile(file, "r");
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: a */
        public int mo8168a(byte[] bArr, int i, int i2) throws IOException {
            return this.f4641a.read(bArr, i, i2);
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: a */
        public long mo8170a() throws IOException {
            return this.f4641a.getFilePointer();
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: a */
        public void mo8169a(long j) throws IOException {
            this.f4641a.seek(j);
        }

        @Override // com.navatics.app.framework.firmware.NavaticsUpdateFile
        /* renamed from: b */
        public void mo8167b() throws IOException {
            this.f4641a.close();
        }
    }
}
