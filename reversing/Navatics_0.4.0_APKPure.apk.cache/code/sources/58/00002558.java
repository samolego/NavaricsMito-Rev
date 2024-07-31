package org.apache.commons.pool2;

/* compiled from: PoolUtils.java */
/* renamed from: org.apache.commons.pool2.g, reason: use source file name */
/* loaded from: classes2.dex */
public final class PoolUtils {
    /* renamed from: a */
    public static void m10654a(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }
}