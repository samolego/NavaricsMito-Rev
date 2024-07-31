package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ViewModelStore.java */
/* renamed from: android.arch.lifecycle.n, reason: use source file name */
/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a */
    private final HashMap<String, AbstractC0022l> f73a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m108a(String str, AbstractC0022l abstractC0022l) {
        AbstractC0022l put = this.f73a.put(str, abstractC0022l);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final AbstractC0022l m106a(String str) {
        return this.f73a.get(str);
    }

    /* renamed from: a */
    public final void m107a() {
        Iterator<AbstractC0022l> it = this.f73a.values().iterator();
        while (it.hasNext()) {
            it.next().onCleared();
        }
        this.f73a.clear();
    }
}