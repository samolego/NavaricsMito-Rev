package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;

/* renamed from: org.apache.ftpserver.a.a.y */
/* loaded from: classes2.dex */
public class OPTS_MLST extends AbstractCommand {

    /* renamed from: a */
    private static final String[] f10921a = {"Size", "Modify", "Type", "Perm"};

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        String str;
        String[] strArr;
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        int indexOf = mo1748c.indexOf(32);
        if (indexOf == -1) {
            strArr = new String[0];
            str = "";
        } else {
            String substring = mo1748c.substring(indexOf + 1);
            StringTokenizer stringTokenizer = new StringTokenizer(substring, ";");
            String[] strArr2 = new String[stringTokenizer.countTokens()];
            for (int i = 0; i < strArr2.length; i++) {
                strArr2[i] = stringTokenizer.nextToken();
            }
            str = substring;
            strArr = strArr2;
        }
        String[] m1972a = m1972a(strArr);
        if (m1972a != null) {
            ftpIoSession.mo1008b("MLST.types", m1972a);
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 200, "OPTS.MLST", str));
            return;
        }
        ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "OPTS.MLST", str));
    }

    /* renamed from: a */
    private String[] m1972a(String[] strArr) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int i = 0;
            while (true) {
                String[] strArr2 = f10921a;
                if (i >= strArr2.length) {
                    break;
                } else if (strArr2[i].equalsIgnoreCase(str)) {
                    arrayList.add(f10921a[i]);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
