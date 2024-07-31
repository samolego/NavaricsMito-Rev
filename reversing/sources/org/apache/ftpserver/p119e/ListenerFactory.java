package org.apache.ftpserver.p119e;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServerConfigurationException;
import org.apache.ftpserver.ipfilter.SessionFilter;
import org.apache.ftpserver.p119e.p120a.NioListener;
import org.apache.ftpserver.ssl.SslConfiguration;
import org.apache.mina.filter.p135b.Subnet;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* renamed from: org.apache.ftpserver.e.b */
/* loaded from: classes2.dex */
public class ListenerFactory {

    /* renamed from: a */
    private String f11080a;

    /* renamed from: c */
    private SslConfiguration f11082c;

    /* renamed from: g */
    private List<InetAddress> f11086g;

    /* renamed from: h */
    private List<Subnet> f11087h;

    /* renamed from: b */
    private int f11081b = 21;

    /* renamed from: d */
    private boolean f11083d = false;

    /* renamed from: e */
    private DataConnectionConfiguration f11084e = new DataConnectionConfigurationFactory().m1956a();

    /* renamed from: f */
    private int f11085f = IjkMediaCodecInfo.RANK_SECURE;

    /* renamed from: i */
    private SessionFilter f11088i = null;

    /* renamed from: a */
    public Listener m1794a() {
        try {
            InetAddress.getByName(this.f11080a);
            if (this.f11088i != null && (this.f11086g != null || this.f11087h != null)) {
                throw new IllegalStateException("Usage of SessionFilter in combination with blockedAddesses/subnets is not supported. ");
            }
            if (this.f11086g != null || this.f11087h != null) {
                return new NioListener(this.f11080a, this.f11081b, this.f11083d, this.f11082c, this.f11084e, this.f11085f, this.f11086g, this.f11087h);
            }
            return new NioListener(this.f11080a, this.f11081b, this.f11083d, this.f11082c, this.f11084e, this.f11085f, this.f11088i);
        } catch (UnknownHostException e) {
            throw new FtpServerConfigurationException("Unknown host", e);
        }
    }

    /* renamed from: a */
    public void m1793a(int i) {
        this.f11081b = i;
    }
}
