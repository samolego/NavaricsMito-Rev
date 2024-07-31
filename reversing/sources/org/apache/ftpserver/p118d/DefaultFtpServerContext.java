package org.apache.ftpserver.p118d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.ftpserver.ConnectionConfig;
import org.apache.ftpserver.ConnectionConfigFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FileSystemFactory;
import org.apache.ftpserver.ftplet.FtpStatistics;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.p110a.CommandFactory;
import org.apache.ftpserver.p110a.CommandFactoryFactory;
import org.apache.ftpserver.p113b.p114a.NativeFileSystemFactory;
import org.apache.ftpserver.p116c.FtpletContainer;
import org.apache.ftpserver.p116c.p117a.DefaultFtpletContainer;
import org.apache.ftpserver.p119e.Listener;
import org.apache.ftpserver.p119e.ListenerFactory;
import org.apache.ftpserver.p121f.MessageResource;
import org.apache.ftpserver.p121f.MessageResourceFactory;
import org.apache.ftpserver.p123g.PropertiesUserManagerFactory;
import org.apache.ftpserver.p123g.p124a.ConcurrentLoginPermission;
import org.apache.ftpserver.p123g.p124a.TransferRatePermission;
import org.apache.ftpserver.p123g.p124a.WritePermission;
import org.apache.mina.filter.p134a.OrderedThreadPoolExecutor;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.d.f */
/* loaded from: classes2.dex */
public class DefaultFtpServerContext implements FtpServerContext {

    /* renamed from: j */
    private static final List<Authority> f10993j = new ArrayList();

    /* renamed from: k */
    private static final List<Authority> f10994k = new ArrayList();

    /* renamed from: a */
    private final InterfaceC3153b f10995a = C3154c.m262a(DefaultFtpServerContext.class);

    /* renamed from: b */
    private MessageResource f10996b = new MessageResourceFactory().m1785a();

    /* renamed from: c */
    private UserManager f10997c = new PropertiesUserManagerFactory().m1680a();

    /* renamed from: d */
    private FileSystemFactory f10998d = new NativeFileSystemFactory();

    /* renamed from: e */
    private FtpletContainer f10999e = new DefaultFtpletContainer();

    /* renamed from: f */
    private FtpStatistics f11000f = new DefaultFtpStatistics();

    /* renamed from: g */
    private CommandFactory f11001g = new CommandFactoryFactory().m1969a();

    /* renamed from: h */
    private ConnectionConfig f11002h = new ConnectionConfigFactory().m1968a();

    /* renamed from: i */
    private Map<String, Listener> f11003i = new HashMap();

    /* renamed from: l */
    private ThreadPoolExecutor f11004l = null;

    static {
        f10993j.add(new WritePermission());
        f10994k.add(new ConcurrentLoginPermission(20, 2));
        f10994k.add(new TransferRatePermission(4800, 4800));
    }

    public DefaultFtpServerContext() {
        this.f11003i.put("default", new ListenerFactory().m1794a());
    }

    @Override // org.apache.ftpserver.ftplet.FtpletContext
    /* renamed from: a */
    public UserManager mo1722a() {
        return this.f10997c;
    }

    @Override // org.apache.ftpserver.ftplet.FtpletContext
    /* renamed from: b */
    public FileSystemFactory mo1721b() {
        return this.f10998d;
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: d */
    public MessageResource mo1858d() {
        return this.f10996b;
    }

    @Override // org.apache.ftpserver.ftplet.FtpletContext
    /* renamed from: c */
    public FtpStatistics mo1720c() {
        return this.f11000f;
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: e */
    public FtpletContainer mo1857e() {
        return this.f10999e;
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: f */
    public CommandFactory mo1856f() {
        return this.f11001g;
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: g */
    public void mo1855g() {
        this.f11003i.clear();
        this.f10999e.mo1957b().clear();
        if (this.f11004l != null) {
            this.f10995a.debug("Shutting down the thread pool executor");
            this.f11004l.shutdown();
            try {
                this.f11004l.awaitTermination(5000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: h */
    public Map<String, Listener> mo1854h() {
        return this.f11003i;
    }

    /* renamed from: a */
    public void m1933a(String str, Listener listener) {
        this.f11003i.put(str, listener);
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: i */
    public ConnectionConfig mo1853i() {
        return this.f11002h;
    }

    /* renamed from: a */
    public void m1932a(ConnectionConfig connectionConfig) {
        this.f11002h = connectionConfig;
    }

    @Override // org.apache.ftpserver.p118d.FtpServerContext
    /* renamed from: j */
    public synchronized ThreadPoolExecutor mo1852j() {
        if (this.f11004l == null) {
            int mo1949f = this.f11002h.mo1949f();
            if (mo1949f < 1 && (mo1949f = this.f11002h.mo1951d()) <= 0) {
                mo1949f = 16;
            }
            this.f10995a.debug("Intializing shared thread pool executor with max threads of {}", Integer.valueOf(mo1949f));
            this.f11004l = new OrderedThreadPoolExecutor(mo1949f);
        }
        return this.f11004l;
    }
}
