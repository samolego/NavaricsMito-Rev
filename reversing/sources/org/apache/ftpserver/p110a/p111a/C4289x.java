package org.apache.ftpserver.p110a.p111a;

import java.io.IOException;
import java.util.HashMap;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.p110a.AbstractCommand;
import org.apache.ftpserver.p110a.Command;
import org.apache.ftpserver.p118d.FtpIoSession;
import org.apache.ftpserver.p118d.FtpServerContext;
import org.apache.ftpserver.p118d.LocalizedFtpReply;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.a.a.x */
/* loaded from: classes2.dex */
public class OPTS extends AbstractCommand {

    /* renamed from: b */
    private static final HashMap<String, Command> f10919b = new HashMap<>(16);

    /* renamed from: a */
    private final InterfaceC3153b f10920a = C3154c.m262a(OPTS.class);

    static {
        f10919b.put("OPTS_MLST", new OPTS_MLST());
        f10919b.put("OPTS_UTF8", new OPTS_UTF8());
    }

    @Override // org.apache.ftpserver.p110a.Command
    /* renamed from: a */
    public void mo1971a(FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) throws IOException, FtpException {
        ftpIoSession.m1879r();
        String mo1748c = ftpRequest.mo1748c();
        if (mo1748c == null) {
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 501, "OPTS", null));
            return;
        }
        int indexOf = mo1748c.indexOf(32);
        if (indexOf != -1) {
            mo1748c = mo1748c.substring(0, indexOf);
        }
        String upperCase = mo1748c.toUpperCase();
        Command command = f10919b.get("OPTS_" + upperCase);
        try {
            if (command != null) {
                command.mo1971a(ftpIoSession, ftpServerContext, ftpRequest);
            } else {
                ftpIoSession.m1879r();
                ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 502, "OPTS.not.implemented", upperCase));
            }
        } catch (Exception e) {
            this.f10920a.warn("OPTS.execute()", (Throwable) e);
            ftpIoSession.m1879r();
            ftpIoSession.mo1001e(LocalizedFtpReply.m1839a(ftpIoSession, ftpRequest, ftpServerContext, 500, "OPTS", null));
        }
    }
}
