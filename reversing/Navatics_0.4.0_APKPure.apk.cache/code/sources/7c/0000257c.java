package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SecurityManagerCallStack.java */
/* renamed from: org.apache.commons.pool2.impl.p, reason: use source file name */
/* loaded from: classes2.dex */
public class SecurityManagerCallStack implements InterfaceC3027d {

    /* renamed from: a */
    private final String f10899a;

    /* renamed from: b */
    private final DateFormat f10900b;

    /* renamed from: c */
    private final a f10901c;

    /* renamed from: d */
    private volatile b f10902d;

    public SecurityManagerCallStack(String str, boolean z) {
        this.f10899a = str;
        this.f10900b = z ? new SimpleDateFormat(str) : null;
        this.f10901c = (a) AccessController.doPrivileged(new PrivilegedAction<a>() { // from class: org.apache.commons.pool2.impl.p.1
            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a run() {
                return new a();
            }
        });
    }

    @Override // org.apache.commons.pool2.impl.InterfaceC3027d
    /* renamed from: a */
    public boolean mo10680a(PrintWriter printWriter) {
        String format;
        String str;
        b bVar = this.f10902d;
        if (bVar == null) {
            return false;
        }
        DateFormat dateFormat = this.f10900b;
        if (dateFormat == null) {
            str = this.f10899a;
        } else {
            synchronized (dateFormat) {
                format = this.f10900b.format(Long.valueOf(bVar.f10904a));
            }
            str = format;
        }
        printWriter.println(str);
        Iterator it = bVar.f10905b.iterator();
        while (it.hasNext()) {
            printWriter.println(((WeakReference) it.next()).get());
        }
        return true;
    }

    @Override // org.apache.commons.pool2.impl.InterfaceC3027d
    /* renamed from: a */
    public void mo10679a() {
        this.f10902d = new b(this.f10901c.m10828a());
    }

    @Override // org.apache.commons.pool2.impl.InterfaceC3027d
    /* renamed from: b */
    public void mo10681b() {
        this.f10902d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecurityManagerCallStack.java */
    /* renamed from: org.apache.commons.pool2.impl.p$a */
    /* loaded from: classes2.dex */
    public static class a extends SecurityManager {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public List<WeakReference<Class<?>>> m10828a() {
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
    private static class b {

        /* renamed from: a */
        private final long f10904a;

        /* renamed from: b */
        private final List<WeakReference<Class<?>>> f10905b;

        private b(List<WeakReference<Class<?>>> list) {
            this.f10904a = System.currentTimeMillis();
            this.f10905b = list;
        }
    }
}