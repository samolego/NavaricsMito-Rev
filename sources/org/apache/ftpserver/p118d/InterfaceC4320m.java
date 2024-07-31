package org.apache.ftpserver.p118d;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.ftpserver.ConnectionConfig;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.p110a.CommandFactory;
import org.apache.ftpserver.p116c.FtpletContainer;
import org.apache.ftpserver.p119e.Listener;
import org.apache.ftpserver.p121f.MessageResource;

/* renamed from: org.apache.ftpserver.d.m */
/* loaded from: classes2.dex */
public interface FtpServerContext extends FtpletContext {
    /* renamed from: d */
    MessageResource mo1858d();

    /* renamed from: e */
    FtpletContainer mo1857e();

    /* renamed from: f */
    CommandFactory mo1856f();

    /* renamed from: g */
    void mo1855g();

    /* renamed from: h */
    Map<String, Listener> mo1854h();

    /* renamed from: i */
    ConnectionConfig mo1853i();

    /* renamed from: j */
    ThreadPoolExecutor mo1852j();
}
