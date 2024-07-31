package org.apache.mina.util;

import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.util.c */
/* loaded from: classes2.dex */
public class NamePreservingRunnable implements Runnable {

    /* renamed from: a */
    private static final InterfaceC3153b f11665a = C3154c.m262a(NamePreservingRunnable.class);

    /* renamed from: b */
    private final String f11666b;

    /* renamed from: c */
    private final Runnable f11667c;

    public NamePreservingRunnable(Runnable runnable, String str) {
        this.f11667c = runnable;
        this.f11666b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        String str = this.f11666b;
        if (str != null) {
            m806a(currentThread, str);
        }
        try {
            this.f11667c.run();
        } finally {
            m806a(currentThread, name);
        }
    }

    /* renamed from: a */
    private void m806a(Thread thread, String str) {
        try {
            thread.setName(str);
        } catch (SecurityException e) {
            if (f11665a.isWarnEnabled()) {
                f11665a.warn("Failed to set the thread name.", (Throwable) e);
            }
        }
    }
}
