package org.apache.ftpserver.p110a.p111a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ftpserver.ftplet.DataType;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.aj */
/* loaded from: classes2.dex */
public class RETR extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10881a = C3154c.m262a(RETR.class);

    /* JADX WARN: Removed duplicated region for block: B:67:0x018d A[Catch: all -> 0x01d6, TRY_LEAVE, TryCatch #4 {all -> 0x01d6, blocks: (B:3:0x0004, B:5:0x000e, B:9:0x002d, B:14:0x0042, B:17:0x005f, B:19:0x0069, B:22:0x0087, B:24:0x008d, B:27:0x00ab, B:29:0x00b1, B:32:0x00cf, B:34:0x00d7, B:36:0x00df, B:40:0x00f8, B:42:0x0109, B:50:0x0137, B:67:0x018d, B:65:0x0187, B:71:0x01ac, B:72:0x01af, B:74:0x01b1, B:12:0x0038), top: B:84:0x0004, inners: #0, #5 }] */
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1971a(org.apache.ftpserver.p118d.FtpIoSession r19, org.apache.ftpserver.p118d.FtpServerContext r20, org.apache.ftpserver.ftplet.FtpRequest r21) throws java.io.IOException, org.apache.ftpserver.ftplet.FtpException {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.ftpserver.p110a.p111a.RETR.mo1971a(org.apache.ftpserver.d.k, org.apache.ftpserver.d.m, org.apache.ftpserver.ftplet.m):void");
    }

    /* renamed from: a */
    public InputStream m1977a(FtpIoSession ftpIoSession, FtpFile ftpFile, long j) throws IOException {
        if (ftpIoSession.m1897I() == DataType.ASCII) {
            long j2 = 0;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(ftpFile.mo1765c(0L));
            while (true) {
                long j3 = j2 + 1;
                if (j2 >= j) {
                    return bufferedInputStream;
                }
                int read = bufferedInputStream.read();
                if (read == -1) {
                    throw new IOException("Cannot skip");
                }
                j2 = read == 10 ? j3 + 1 : j3;
            }
        } else {
            return ftpFile.mo1765c(j);
        }
    }
}
