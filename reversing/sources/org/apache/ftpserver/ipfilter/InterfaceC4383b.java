package org.apache.ftpserver.ipfilter;

import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.ftpserver.ipfilter.b */
/* loaded from: classes2.dex */
public interface SessionFilter {
    boolean accept(IoSession ioSession);
}
