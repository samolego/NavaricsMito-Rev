package org.apache.ftpserver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import org.apache.ftpserver.p118d.DefaultDataConnectionConfiguration;
import org.apache.ftpserver.p118d.PassivePorts;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* renamed from: org.apache.ftpserver.d */
/* loaded from: classes2.dex */
public class DataConnectionConfigurationFactory {

    /* renamed from: c */
    private SslConfiguration f10954c;

    /* renamed from: e */
    private String f10956e;

    /* renamed from: h */
    private String f10959h;

    /* renamed from: i */
    private String f10960i;

    /* renamed from: l */
    private boolean f10963l;

    /* renamed from: a */
    private InterfaceC3153b f10952a = C3154c.m262a(DataConnectionConfigurationFactory.class);

    /* renamed from: b */
    private int f10953b = IjkMediaCodecInfo.RANK_SECURE;

    /* renamed from: d */
    private boolean f10955d = true;

    /* renamed from: f */
    private int f10957f = 0;

    /* renamed from: g */
    private boolean f10958g = false;

    /* renamed from: j */
    private PassivePorts f10961j = new PassivePorts(Collections.emptySet(), true);

    /* renamed from: k */
    private boolean f10962k = false;

    /* renamed from: a */
    public DataConnectionConfiguration m1956a() {
        m1955b();
        return new DefaultDataConnectionConfiguration(this.f10953b, this.f10954c, this.f10955d, this.f10958g, this.f10956e, this.f10957f, this.f10959h, this.f10961j, this.f10960i, this.f10962k, this.f10963l);
    }

    /* renamed from: b */
    private void m1955b() {
        try {
            InetAddress.getByName(this.f10959h);
            InetAddress.getByName(this.f10960i);
        } catch (UnknownHostException e) {
            throw new FtpServerConfigurationException("Unknown host", e);
        }
    }
}
