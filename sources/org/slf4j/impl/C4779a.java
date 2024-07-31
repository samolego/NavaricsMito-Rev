package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.log4j.C3044k;
import org.apache.log4j.LogManager;
import org.slf4j.ILoggerFactory;
import org.slf4j.InterfaceC3153b;
import org.slf4j.helpers.C3156g;

/* renamed from: org.slf4j.impl.a */
/* loaded from: classes2.dex */
public class Log4jLoggerFactory implements ILoggerFactory {

    /* renamed from: a */
    ConcurrentMap<String, InterfaceC3153b> f12566a = new ConcurrentHashMap();

    static {
        try {
            Class.forName("org.apache.log4j.Log4jLoggerFactory");
            C3156g.m185c("Detected both log4j-over-slf4j.jar AND bound slf4j-log4j12.jar on the class path, preempting StackOverflowError. ");
            C3156g.m185c("See also http://www.slf4j.org/codes.html#log4jDelegationLoop for more details.");
            throw new IllegalStateException("Detected both log4j-over-slf4j.jar AND bound slf4j-log4j12.jar on the class path, preempting StackOverflowError. See also http://www.slf4j.org/codes.html#log4jDelegationLoop for more details.");
        } catch (ClassNotFoundException unused) {
        }
    }

    public Log4jLoggerFactory() {
        LogManager.m1565b();
    }

    @Override // org.slf4j.ILoggerFactory
    /* renamed from: a */
    public InterfaceC3153b mo181a(String str) {
        C3044k m1566a;
        InterfaceC3153b interfaceC3153b = this.f12566a.get(str);
        if (interfaceC3153b != null) {
            return interfaceC3153b;
        }
        if (str.equalsIgnoreCase("ROOT")) {
            m1566a = LogManager.m1565b();
        } else {
            m1566a = LogManager.m1566a(str);
        }
        Log4jLoggerAdapter log4jLoggerAdapter = new Log4jLoggerAdapter(m1566a);
        InterfaceC3153b putIfAbsent = this.f12566a.putIfAbsent(str, log4jLoggerAdapter);
        return putIfAbsent == null ? log4jLoggerAdapter : putIfAbsent;
    }
}
