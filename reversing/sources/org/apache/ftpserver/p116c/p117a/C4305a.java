package org.apache.ftpserver.p116c.p117a;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.ftplet.FtpletResult;
import org.apache.ftpserver.p116c.FtpletContainer;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.c.a.a */
/* loaded from: classes2.dex */
public class DefaultFtpletContainer implements FtpletContainer {

    /* renamed from: a */
    private final InterfaceC3153b f10950a;

    /* renamed from: b */
    private final Map<String, Ftplet> f10951b;

    public DefaultFtpletContainer() {
        this(new ConcurrentHashMap());
    }

    public DefaultFtpletContainer(Map<String, Ftplet> map) {
        this.f10950a = C3154c.m262a(DefaultFtpletContainer.class);
        this.f10951b = map;
    }

    @Override // org.apache.ftpserver.ftplet.Ftplet
    /* renamed from: a */
    public synchronized void mo1724a(FtpletContext ftpletContext) throws FtpException {
        for (Map.Entry<String, Ftplet> entry : this.f10951b.entrySet()) {
            entry.getValue().mo1724a(ftpletContext);
        }
    }

    @Override // org.apache.ftpserver.p116c.FtpletContainer
    /* renamed from: b */
    public synchronized Map<String, Ftplet> mo1957b() {
        return this.f10951b;
    }

    @Override // org.apache.ftpserver.ftplet.Ftplet
    /* renamed from: a */
    public void mo1728a() {
        for (Map.Entry<String, Ftplet> entry : this.f10951b.entrySet()) {
            try {
                entry.getValue().mo1728a();
            } catch (Exception e) {
                InterfaceC3153b interfaceC3153b = this.f10950a;
                interfaceC3153b.error(entry.getKey() + " :: FtpletHandler.destroy()", (Throwable) e);
            }
        }
    }

    @Override // org.apache.ftpserver.ftplet.Ftplet
    /* renamed from: a */
    public FtpletResult mo1727a(FtpSession ftpSession) throws FtpException, IOException {
        FtpletResult ftpletResult = FtpletResult.DEFAULT;
        for (Map.Entry<String, Ftplet> entry : this.f10951b.entrySet()) {
            ftpletResult = entry.getValue().mo1727a(ftpSession);
            if (ftpletResult == null) {
                ftpletResult = FtpletResult.DEFAULT;
            }
            if (ftpletResult != FtpletResult.DEFAULT) {
                break;
            }
        }
        return ftpletResult;
    }

    @Override // org.apache.ftpserver.ftplet.Ftplet
    /* renamed from: b */
    public FtpletResult mo1723b(FtpSession ftpSession) throws FtpException, IOException {
        FtpletResult ftpletResult = FtpletResult.DEFAULT;
        for (Map.Entry<String, Ftplet> entry : this.f10951b.entrySet()) {
            ftpletResult = entry.getValue().mo1723b(ftpSession);
            if (ftpletResult == null) {
                ftpletResult = FtpletResult.DEFAULT;
            }
            if (ftpletResult != FtpletResult.DEFAULT) {
                break;
            }
        }
        return ftpletResult;
    }

    @Override // org.apache.ftpserver.ftplet.Ftplet
    /* renamed from: a */
    public FtpletResult mo1725a(FtpSession ftpSession, FtpRequest ftpRequest, FtpReply ftpReply) throws FtpException, IOException {
        FtpletResult ftpletResult = FtpletResult.DEFAULT;
        for (Map.Entry<String, Ftplet> entry : this.f10951b.entrySet()) {
            ftpletResult = entry.getValue().mo1725a(ftpSession, ftpRequest, ftpReply);
            if (ftpletResult == null) {
                ftpletResult = FtpletResult.DEFAULT;
            }
            if (ftpletResult != FtpletResult.DEFAULT) {
                break;
            }
        }
        return ftpletResult;
    }

    @Override // org.apache.ftpserver.ftplet.Ftplet
    /* renamed from: a */
    public FtpletResult mo1726a(FtpSession ftpSession, FtpRequest ftpRequest) throws FtpException, IOException {
        FtpletResult ftpletResult = FtpletResult.DEFAULT;
        for (Map.Entry<String, Ftplet> entry : this.f10951b.entrySet()) {
            ftpletResult = entry.getValue().mo1726a(ftpSession, ftpRequest);
            if (ftpletResult == null) {
                ftpletResult = FtpletResult.DEFAULT;
            }
            if (ftpletResult != FtpletResult.DEFAULT) {
                break;
            }
        }
        return ftpletResult;
    }
}
