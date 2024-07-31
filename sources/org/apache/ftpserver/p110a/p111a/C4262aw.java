package org.apache.ftpserver.p110a.p111a;

import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.aw */
/* loaded from: classes2.dex */
public class STOU extends AbstractCommand {

    /* renamed from: a */
    private final InterfaceC3153b f10892a = C3154c.m262a(STOU.class);

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[Catch: all -> 0x018c, TRY_LEAVE, TryCatch #6 {all -> 0x018c, Exception -> 0x0169, blocks: (B:3:0x0004, B:5:0x000c, B:7:0x0014, B:10:0x0028, B:17:0x0054, B:19:0x005e, B:28:0x0073, B:31:0x008e, B:33:0x0098, B:36:0x00b3, B:38:0x00cf, B:46:0x00fd, B:61:0x014a, B:65:0x0165, B:66:0x0168, B:53:0x0124, B:68:0x016a, B:26:0x0069, B:14:0x0035, B:16:0x0043), top: B:80:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e A[Catch: all -> 0x018c, TRY_ENTER, TryCatch #6 {all -> 0x018c, Exception -> 0x0169, blocks: (B:3:0x0004, B:5:0x000c, B:7:0x0014, B:10:0x0028, B:17:0x0054, B:19:0x005e, B:28:0x0073, B:31:0x008e, B:33:0x0098, B:36:0x00b3, B:38:0x00cf, B:46:0x00fd, B:61:0x014a, B:65:0x0165, B:66:0x0168, B:53:0x0124, B:68:0x016a, B:26:0x0069, B:14:0x0035, B:16:0x0043), top: B:80:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1971a(org.apache.ftpserver.p118d.FtpIoSession r17, org.apache.ftpserver.p118d.FtpServerContext r18, org.apache.ftpserver.ftplet.FtpRequest r19) throws java.io.IOException, org.apache.ftpserver.ftplet.FtpException {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.ftpserver.p110a.p111a.STOU.mo1971a(org.apache.ftpserver.d.k, org.apache.ftpserver.d.m, org.apache.ftpserver.ftplet.m):void");
    }

    /* renamed from: a */
    protected FtpFile m1976a(FtpIoSession ftpIoSession, FtpFile ftpFile) throws FtpException {
        FileSystemView m1877t = ftpIoSession.m1877t();
        String mo1771a = ftpFile.mo1771a();
        while (ftpFile.mo1762f()) {
            ftpFile = m1877t.mo1774a(mo1771a + '.' + System.currentTimeMillis());
            if (ftpFile == null) {
                break;
            }
        }
        return ftpFile;
    }
}
