package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: org.apache.commons.pool2.impl.p */
/* loaded from: classes2.dex */
public class SecurityManagerCallStack implements CallStack {

    /* renamed from: a */
    private final String f10858a;

    /* renamed from: b */
    private final DateFormat f10859b;

    /* renamed from: c */
    private final C3022a f10860c;

    /* renamed from: d */
    private volatile C3023b f10861d;

    public SecurityManagerCallStack(String str, boolean z) {
        this.f10858a = str;
        this.f10859b = z ? new SimpleDateFormat(str) : null;
        this.f10860c = (C3022a) AccessController.doPrivileged(new PrivilegedAction<C3022a>() { // from class: org.apache.commons.pool2.impl.p.1
            @Override // java.security.PrivilegedAction
            /* renamed from: a */
            public C3022a run() {
                return new C3022a();
            }
        });
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: a */
    public boolean mo2004a(PrintWriter printWriter) {
        String format;
        String str;
        C3023b c3023b = this.f10861d;
        if (c3023b == null) {
            return false;
        }
        DateFormat dateFormat = this.f10859b;
        if (dateFormat == null) {
            str = this.f10858a;
        } else {
            synchronized (dateFormat) {
                format = this.f10859b.format(Long.valueOf(c3023b.f10863a));
            }
            str = format;
        }
        printWriter.println(str);
        for (WeakReference weakReference : c3023b.f10864b) {
            printWriter.println(weakReference.get());
        }
        return true;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: a */
    public void mo2005a() {
        this.f10861d = new C3023b(this.f10860c.m2001a());
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: b */
    public void mo2003b() {
        this.f10861d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecurityManagerCallStack.java */
    /* renamed from: org.apache.commons.pool2.impl.p$a */
    /* loaded from: classes2.dex */
    public static class C3022a extends SecurityManager {
        private C3022a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public List<WeakReference<Class<?>>> m2001a() {
            Class[] classContext = getClassContext();
            ArrayList arrayList = new ArrayList(classContext.length);
            for (Class cls : classContext) {
                arrayList.add(new WeakReference(cls));
            }
            return arrayList;
        }
    }

    /* compiled from: SecurityManagerCallStack.java */
    /* renamed from: org.apache.commons.pool2.impl.p$b */
    /* loaded from: classes2.dex */
    private static class C3023b {

        /* renamed from: a */
        private final long f10863a;

        /* renamed from: b */
        private final List<WeakReference<Class<?>>> f10864b;

        private C3023b(List<WeakReference<Class<?>>> list) {
            this.f10863a = System.currentTimeMillis();
            this.f10864b = list;
        }
    }
}
