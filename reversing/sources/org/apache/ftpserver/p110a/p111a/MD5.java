package org.apache.ftpserver.p110a.p111a;

import com.adapt.SPM_Rc;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.apache.ftpserver.util.IoUtils;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.o */
/* loaded from: classes2.dex */
public class MD5 extends AbstractCommand {

    /* renamed from: b */
    private static final char[] f10907b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    private final InterfaceC3153b f10908a = C3154c.m262a(MD5.class);

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException {
        FtpFile ftpFile;
        ftpIoSession.m1879r();
        boolean equals = "MMD5".equals(ftpRequest.mo1749b());
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null || mo1748c.trim().length() == 0) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "MD5.invalid", null));
            return;
        }
        String[] split = equals ? mo1748c.split(",") : new String[]{mo1748c};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            InputStream inputStream = null;
            try {
                ftpFile = ftpIoSession.m1877t().mo1774a(trim);
            } catch (Exception e) {
                InterfaceC3153b interfaceC3153b = this.f10908a;
                interfaceC3153b.debug("Exception getting the file object: " + trim, (Throwable) e);
                ftpFile = null;
            }
            if (ftpFile == null) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "MD5.invalid", trim));
                return;
            } else if (!ftpFile.mo1763e()) {
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 504, "MD5.invalid", trim));
                return;
            } else {
                try {
                    inputStream = ftpFile.mo1765c(0L);
                    String m1974a = m1974a(inputStream);
                    if (i > 0) {
                        sb.append(", ");
                    }
                    boolean z = trim.indexOf(32) >= 0;
                    if (z) {
                        sb.append('\"');
                    }
                    sb.append(trim);
                    if (z) {
                        sb.append('\"');
                    }
                    sb.append(' ');
                    sb.append(m1974a);
                    IoUtils.m1662b(inputStream);
                } catch (NoSuchAlgorithmException e2) {
                    InputStream inputStream2 = inputStream;
                    try {
                        this.f10908a.debug("MD5 algorithm not available", (Throwable) e2);
                        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 502, "MD5.notimplemened", null));
                        IoUtils.m1662b(inputStream2);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        IoUtils.m1662b(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.m1662b(inputStream);
                    throw th;
                }
            }
        }
        if (equals) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 252, "MMD5", sb.toString()));
        } else {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 251, "MD5", sb.toString()));
        }
    }

    /* renamed from: a */
    private String m1974a(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("MD5"));
        byte[] bArr = new byte[1024];
        for (int read = digestInputStream.read(bArr); read > -1; read = digestInputStream.read(bArr)) {
        }
        return new String(m1973a(digestInputStream.getMessageDigest().digest()));
    }

    /* renamed from: a */
    public static char[] m1973a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f10907b;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & SPM_Rc.VIBRATION_MODE.MAX_VOLUME];
        }
        return cArr;
    }
}
