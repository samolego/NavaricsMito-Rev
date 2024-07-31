package org.apache.ftpserver.p118d;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.apache.ftpserver.ftplet.DataConnection;
import org.apache.ftpserver.ftplet.DataType;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.p123g.p124a.TransferRateRequest;
import org.apache.ftpserver.util.IoUtils;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.d.n */
/* loaded from: classes2.dex */
public class IODataConnection implements DataConnection {

    /* renamed from: b */
    private static final byte[] f11029b = System.getProperty("line.separator").getBytes();

    /* renamed from: a */
    private final InterfaceC3153b f11030a = C3154c.m262a(IODataConnection.class);

    /* renamed from: c */
    private final FtpIoSession f11031c;

    /* renamed from: d */
    private final Socket f11032d;

    /* renamed from: e */
    private final ServerDataConnectionFactory f11033e;

    public IODataConnection(Socket socket, FtpIoSession ftpIoSession, ServerDataConnectionFactory serverDataConnectionFactory) {
        this.f11031c = ftpIoSession;
        this.f11032d = socket;
        this.f11033e = serverDataConnectionFactory;
    }

    /* renamed from: b */
    private InputStream m1849b() throws IOException {
        try {
            Socket socket = this.f11032d;
            if (socket == null) {
                throw new IOException("Cannot open data connection.");
            }
            InputStream inputStream = socket.getInputStream();
            return this.f11033e.mo1830e() ? new InflaterInputStream(inputStream) : inputStream;
        } catch (IOException e) {
            this.f11033e.mo1780b();
            throw e;
        }
    }

    /* renamed from: c */
    private OutputStream m1848c() throws IOException {
        try {
            Socket socket = this.f11032d;
            if (socket == null) {
                throw new IOException("Cannot open data connection.");
            }
            OutputStream outputStream = socket.getOutputStream();
            return this.f11033e.mo1830e() ? new DeflaterOutputStream(outputStream) : outputStream;
        } catch (IOException e) {
            this.f11033e.mo1780b();
            throw e;
        }
    }

    @Override // org.apache.ftpserver.ftplet.DataConnection
    /* renamed from: a */
    public final long mo1783a(FtpSession ftpSession, OutputStream outputStream) throws IOException {
        TransferRateRequest transferRateRequest = (TransferRateRequest) ftpSession.mo1746a().mo1713a(new TransferRateRequest());
        int m1689b = transferRateRequest != null ? transferRateRequest.m1689b() : 0;
        InputStream m1849b = m1849b();
        try {
            return m1850a(ftpSession, false, m1849b, outputStream, m1689b);
        } finally {
            IoUtils.m1662b(m1849b);
        }
    }

    @Override // org.apache.ftpserver.ftplet.DataConnection
    /* renamed from: a */
    public final long mo1784a(FtpSession ftpSession, InputStream inputStream) throws IOException {
        TransferRateRequest transferRateRequest = (TransferRateRequest) ftpSession.mo1746a().mo1713a(new TransferRateRequest());
        int m1691a = transferRateRequest != null ? transferRateRequest.m1691a() : 0;
        OutputStream m1848c = m1848c();
        try {
            return m1850a(ftpSession, true, inputStream, m1848c, m1691a);
        } finally {
            IoUtils.m1661b(m1848c);
        }
    }

    @Override // org.apache.ftpserver.ftplet.DataConnection
    /* renamed from: a */
    public final void mo1782a(FtpSession ftpSession, String str) throws IOException {
        OutputStreamWriter outputStreamWriter;
        try {
            outputStreamWriter = new OutputStreamWriter(m1848c(), "UTF-8");
        } catch (Throwable th) {
            th = th;
            outputStreamWriter = null;
        }
        try {
            outputStreamWriter.write(str);
            if (ftpSession instanceof DefaultFtpSession) {
                ((DefaultFtpSession) ftpSession).m1931a(str.getBytes("UTF-8").length);
            }
            outputStreamWriter.flush();
            IoUtils.m1663a(outputStreamWriter);
        } catch (Throwable th2) {
            th = th2;
            if (outputStreamWriter != null) {
                outputStreamWriter.flush();
            }
            IoUtils.m1663a(outputStreamWriter);
            throw th;
        }
    }

    /* renamed from: a */
    private final long m1850a(FtpSession ftpSession, boolean z, InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        int i2 = i;
        boolean z2 = ftpSession.mo1745b() == DataType.ASCII;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = new byte[4096];
        try {
            try {
                BufferedInputStream m1665a = IoUtils.m1665a(inputStream);
                bufferedOutputStream = IoUtils.m1664a(outputStream);
                try {
                    DefaultFtpSession defaultFtpSession = ftpSession instanceof DefaultFtpSession ? (DefaultFtpSession) ftpSession : null;
                    long j = 0;
                    long j2 = 0;
                    byte b = 0;
                    while (true) {
                        if (i2 > 0) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 == j) {
                                currentTimeMillis2 = 1;
                            }
                            if ((1000 * j2) / currentTimeMillis2 > i2) {
                                try {
                                    Thread.sleep(50L);
                                    j = 0;
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        int read = m1665a.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (defaultFtpSession != null) {
                            if (z) {
                                defaultFtpSession.m1931a(read);
                            } else {
                                defaultFtpSession.m1930b(read);
                            }
                        }
                        if (z2) {
                            byte b2 = b;
                            int i3 = 0;
                            while (i3 < read) {
                                byte b3 = bArr[i3];
                                if (z) {
                                    if (b3 == 10 && b2 != 13) {
                                        bufferedOutputStream.write(13);
                                    }
                                    bufferedOutputStream.write(b3);
                                } else if (b3 == 10) {
                                    if (b2 != 13) {
                                        bufferedOutputStream.write(f11029b);
                                    }
                                } else if (b3 == 13) {
                                    bufferedOutputStream.write(f11029b);
                                } else {
                                    bufferedOutputStream.write(b3);
                                }
                                i3++;
                                b2 = b3;
                            }
                            b = b2;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        j2 += read;
                        m1851a();
                        i2 = i;
                        j = 0;
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.flush();
                    }
                    return j2;
                } catch (IOException e) {
                    e = e;
                    this.f11030a.warn("Exception during data transfer, closing data connection socket", (Throwable) e);
                    this.f11033e.mo1780b();
                    throw e;
                } catch (RuntimeException e2) {
                    e = e2;
                    this.f11030a.warn("Exception during data transfer, closing data connection socket", (Throwable) e);
                    this.f11033e.mo1780b();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.flush();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (RuntimeException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    /* renamed from: a */
    protected void m1851a() {
        this.f11031c.m1893M();
    }
}
