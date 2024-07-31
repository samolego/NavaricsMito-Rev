package org.apache.commons.pool2;

/* renamed from: org.apache.commons.pool2.g */
/* loaded from: classes2.dex */
public final class PoolUtils {
    /* renamed from: a */
    public static void m2185a(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }
}
