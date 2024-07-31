package com.navatics.app.framework.network.service;

import android.os.Looper;
import com.navatics.app.framework.network.NetworkServiceHandler;
import com.navatics.app.framework.network.p056a.ConnectionUtils;
import java.util.ArrayList;
import org.apache.ftpserver.ConnectionConfigFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.p119e.ListenerFactory;
import org.apache.ftpserver.p123g.p124a.BaseUser;
import org.apache.ftpserver.p123g.p124a.ConcurrentLoginPermission;
import org.apache.ftpserver.p123g.p124a.TransferRatePermission;
import org.apache.ftpserver.p123g.p124a.WritePermission;

/* loaded from: classes.dex */
public class ConnectionsService extends NetworkServerService {

    /* renamed from: a */
    private FtpServer f4735a;

    @Override // com.navatics.app.framework.network.service.NetworkServerService
    /* renamed from: a */
    protected NetworkServiceHandler mo7969a(Looper looper, NetworkServerService networkServerService) {
        return new NetworkServiceHandler(looper, networkServerService);
    }

    @Override // com.navatics.app.framework.network.service.NetworkServerService
    /* renamed from: a */
    public Object mo7970a() {
        return this.f4735a;
    }

    @Override // com.navatics.app.framework.network.service.NetworkServerService
    /* renamed from: b */
    public boolean mo7967b() {
        ListenerFactory listenerFactory = new ListenerFactory();
        listenerFactory.m1793a(ConnectionUtils.m7985a());
        FtpServerFactory ftpServerFactory = new FtpServerFactory();
        ftpServerFactory.m1791a("default", listenerFactory.m1794a());
        ConnectionConfigFactory connectionConfigFactory = new ConnectionConfigFactory();
        connectionConfigFactory.m1966a(m7965d().m7987c());
        connectionConfigFactory.m1967a(5);
        connectionConfigFactory.m1965b(2000);
        ftpServerFactory.m1790a(connectionConfigFactory.m1968a());
        BaseUser baseUser = new BaseUser();
        baseUser.m1715a(m7965d().m7991a());
        baseUser.m1710b(m7965d().m7988b());
        baseUser.m1708c(m7965d().m7986d());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WritePermission());
        arrayList.add(new TransferRatePermission(0, 0));
        arrayList.add(new ConcurrentLoginPermission(10, 10));
        baseUser.m1714a(arrayList);
        try {
            ftpServerFactory.m1789b().mo1695a(baseUser);
        } catch (FtpException unused) {
        }
        try {
            this.f4735a = ftpServerFactory.m1792a();
            this.f4735a.mo1809a();
            return true;
        } catch (Exception e) {
            this.f4735a = null;
            m7968a(e);
            return false;
        }
    }

    @Override // com.navatics.app.framework.network.service.NetworkServerService
    /* renamed from: c */
    public void mo7966c() {
        this.f4735a.mo1808b();
        this.f4735a = null;
    }
}
