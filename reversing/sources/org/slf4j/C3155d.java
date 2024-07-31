package org.slf4j;

import org.slf4j.helpers.C3156g;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.p152a.MDCAdapter;

/* compiled from: MDC.java */
/* renamed from: org.slf4j.d */
/* loaded from: classes2.dex */
public class C3155d {

    /* renamed from: a */
    static MDCAdapter f12536a;

    /* renamed from: a */
    private static MDCAdapter m244a() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.m175a().m174b();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.f12571a.m174b();
        }
    }

    static {
        try {
            f12536a = m244a();
        } catch (Exception e) {
            C3156g.m189a("MDC binding unsuccessful.", e);
        } catch (NoClassDefFoundError e2) {
            f12536a = new NOPMDCAdapter();
            String message = e2.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                C3156g.m185c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                C3156g.m185c("Defaulting to no-operation MDCAdapter implementation.");
                C3156g.m185c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e2;
        }
    }

    /* renamed from: a */
    public static void m242a(String str, String str2) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = f12536a;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.mo179a(str, str2);
    }

    /* renamed from: a */
    public static void m243a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        MDCAdapter mDCAdapter = f12536a;
        if (mDCAdapter == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        mDCAdapter.mo180a(str);
    }
}
