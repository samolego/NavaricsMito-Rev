package org.apache.ftpserver.p119e.p120a;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LoggingFilter;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.ftpserver.e.a.c */
/* loaded from: classes2.dex */
public class FtpLoggingFilter extends LoggingFilter {

    /* renamed from: a */
    private boolean f11069a;

    /* renamed from: b */
    private final InterfaceC3153b f11070b;

    public FtpLoggingFilter() {
        this(FtpLoggingFilter.class.getName());
    }

    public FtpLoggingFilter(String str) {
        super(str);
        this.f11069a = true;
        this.f11070b = C3154c.m260a(str);
    }

    @Override // org.apache.mina.filter.logging.LoggingFilter, org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception {
        String str = (String) obj;
        if (this.f11069a && str.trim().toUpperCase().startsWith("PASS ")) {
            str = "PASS *****";
        }
        this.f11070b.info("RECEIVED: {}", str);
        interfaceC3073a.mo1114a(ioSession, obj);
    }
}
