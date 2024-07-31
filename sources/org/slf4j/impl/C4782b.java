package org.slf4j.impl;

import org.apache.log4j.MDC;
import org.apache.log4j.MDCFriend;
import org.slf4j.p152a.MDCAdapter;

/* renamed from: org.slf4j.impl.b */
/* loaded from: classes2.dex */
public class Log4jMDCAdapter implements MDCAdapter {
    static {
        if (VersionUtil.m173a() >= 9) {
            MDCFriend.m1550a();
        }
    }

    @Override // org.slf4j.p152a.MDCAdapter
    /* renamed from: a */
    public void mo179a(String str, String str2) {
        MDC.m1558a(str, str2);
    }

    @Override // org.slf4j.p152a.MDCAdapter
    /* renamed from: a */
    public void mo180a(String str) {
        MDC.m1556b(str);
    }
}
