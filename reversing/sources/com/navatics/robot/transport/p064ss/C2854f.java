package com.navatics.robot.transport.p064ss;

import android.os.Environment;
import android.util.Log;
import com.hwfit.abs.HwAbs;
import com.hwfit.otg.OTGManager;
import com.navatics.robot.transport.NvValue;
import com.navatics.robot.transport.VideoInputStream;
import com.navatics.robot.utils.RingBuf;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.navatics.robot.transport.ss.f */
/* loaded from: classes2.dex */
public class SsVideoInputStream extends VideoInputStream {

    /* renamed from: a */
    private HwAbs f6653a;

    /* renamed from: b */
    private boolean f6654b;

    /* renamed from: d */
    private long f6656d;

    /* renamed from: f */
    private OutputStream f6658f;

    /* renamed from: g */
    private long f6659g;

    /* renamed from: h */
    private long f6660h;

    /* renamed from: j */
    private long f6662j;

    /* renamed from: e */
    private boolean f6657e = false;

    /* renamed from: i */
    private boolean f6661i = false;

    /* renamed from: c */
    private RingBuf f6655c = new RingBuf(1048576);

    public SsVideoInputStream(HwAbs hwAbs) {
        this.f6653a = hwAbs;
        this.f6653a.OtgVideoDataAcceptCb(new OTGManager.IOTG_VideoCB() { // from class: com.navatics.robot.transport.ss.f.1
            @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
            public void video0Data(byte[] bArr, int i, int i2) {
            }

            @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
            public void video0Data(byte[] bArr, int i) {
                if (!SsVideoInputStream.this.f6654b) {
                    if (i > 0) {
                        SsVideoInputStream.this.f6656d = System.currentTimeMillis();
                    }
                    try {
                        if (SsVideoInputStream.this.f6657e) {
                            SsVideoInputStream.this.m6041a(bArr, i);
                        }
                        if (SsVideoInputStream.this.f6661i) {
                            SsVideoInputStream.this.m6040b();
                        }
                        SsVideoInputStream.this.f6655c.m5865b().write(bArr, 0, i);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                Log.e("SsVideoInputStream", "oops! we already closed but still receive video data");
            }

            @Override // com.hwfit.otg.OTGManager.IOTG_VideoCB
            public void video1Data(byte[] bArr, int i) {
                throw new RuntimeException("data from video1");
            }
        });
    }

    /* renamed from: a */
    public boolean m6045a() {
        return System.currentTimeMillis() - this.f6656d > 5000 && this.f6655c.m5862d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6040b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6662j > 1000) {
            int m5863c = this.f6655c.m5863c() / 1024;
            int m5861e = this.f6655c.m5861e() / 1024;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(m5863c);
            objArr[1] = Integer.valueOf(m5861e);
            objArr[2] = Integer.valueOf(m5863c != 0 ? (m5861e * 100) / m5863c : 0);
            Log.d("SsVideoInputStream", String.format("buffer usage : %d KB/%d KB %d%%", objArr));
            this.f6662j = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6041a(byte[] bArr, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f6658f == null) {
                this.f6658f = new BufferedOutputStream(new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "ssvi.data")), 262144);
                this.f6659g = 0L;
                this.f6660h = currentTimeMillis;
            }
            this.f6658f.write(bArr, 0, i);
            this.f6659g += i;
            if (currentTimeMillis - this.f6660h > 1000) {
                Log.d("SsVideoInputStream", "Total size : " + this.f6659g + ", " + NvValue.m5983a((this.f6659g * 1.0d) / 1048576.0d) + " MB");
                this.f6660h = currentTimeMillis;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f6655c.m5868a().read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f6655c.m5868a().read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f6655c.m5868a().read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f6655c.m5868a().skip(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f6655c.m5868a().available();
    }

    @Override // com.navatics.robot.transport.VideoInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f6654b = true;
        this.f6653a.OtgVideoDataAcceptCb(null);
        this.f6655c.m5868a().close();
        OutputStream outputStream = this.f6658f;
        if (outputStream != null) {
            outputStream.close();
            this.f6658f = null;
        }
        Log.w("SsVideoInputStream", getClass().getSimpleName() + " closed.");
        super.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f6655c.m5868a().mark(i);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f6655c.m5868a().reset();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f6655c.m5868a().markSupported();
    }
}
