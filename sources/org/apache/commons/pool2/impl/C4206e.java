package org.apache.commons.pool2.impl;

import java.security.AccessControlException;

/* renamed from: org.apache.commons.pool2.impl.e */
/* loaded from: classes2.dex */
public final class CallStackUtils {

    /* renamed from: a */
    private static final boolean f10805a = m2099a();

    /* renamed from: a */
    private static boolean m2099a() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            return true;
        }
        try {
            securityManager.checkPermission(new RuntimePermission("createSecurityManager"));
            return true;
        } catch (AccessControlException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static CallStack m2098a(String str, boolean z, boolean z2) {
        return (!f10805a || z2) ? new ThrowableCallStack(str, z) : new SecurityManagerCallStack(str, z);
    }
}
