package io.objectbox.p081b;

import java.util.Iterator;
import java.util.List;

/* compiled from: DataSubscriptionList.java */
/* renamed from: io.objectbox.b.f, reason: use source file name */
/* loaded from: classes2.dex */
public class DataSubscriptionList implements InterfaceC2789d {

    /* renamed from: a */
    private final List<InterfaceC2789d> f9515a;

    /* renamed from: b */
    private boolean f9516b;

    /* renamed from: a */
    public synchronized void m9469a(InterfaceC2789d interfaceC2789d) {
        this.f9515a.add(interfaceC2789d);
        this.f9516b = false;
    }

    @Override // io.objectbox.p081b.InterfaceC2789d
    /* renamed from: a */
    public synchronized void mo9467a() {
        this.f9516b = true;
        Iterator<InterfaceC2789d> it = this.f9515a.iterator();
        while (it.hasNext()) {
            it.next().mo9467a();
        }
        this.f9515a.clear();
    }

    @Override // io.objectbox.p081b.InterfaceC2789d
    /* renamed from: b */
    public synchronized boolean mo9468b() {
        return this.f9516b;
    }
}