package org.apache.ftpserver.p107d;

import java.net.InetSocketAddress;
import org.apache.ftpserver.DataConnectionException;
import org.apache.ftpserver.ftplet.InterfaceC3159e;

/* compiled from: ServerDataConnectionFactory.java */
/* renamed from: org.apache.ftpserver.d.u, reason: use source file name */
/* loaded from: classes2.dex */
public interface ServerDataConnectionFactory extends InterfaceC3159e {
    /* renamed from: a */
    void mo11090a(InetSocketAddress inetSocketAddress);

    /* renamed from: a */
    void mo11091a(boolean z);

    /* renamed from: b */
    void mo11093b(boolean z);

    /* renamed from: c */
    InetSocketAddress mo11094c() throws DataConnectionException;

    /* renamed from: e */
    boolean mo11096e();
}