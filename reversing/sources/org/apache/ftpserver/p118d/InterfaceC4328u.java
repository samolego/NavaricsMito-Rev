package org.apache.ftpserver.p118d;

import java.net.InetSocketAddress;
import org.apache.ftpserver.DataConnectionException;
import org.apache.ftpserver.ftplet.DataConnectionFactory;

/* renamed from: org.apache.ftpserver.d.u */
/* loaded from: classes2.dex */
public interface ServerDataConnectionFactory extends DataConnectionFactory {
    /* renamed from: a */
    void mo1834a(InetSocketAddress inetSocketAddress);

    /* renamed from: a */
    void mo1833a(boolean z);

    /* renamed from: b */
    void mo1832b(boolean z);

    /* renamed from: c */
    InetSocketAddress mo1831c() throws DataConnectionException;

    /* renamed from: e */
    boolean mo1830e();
}
