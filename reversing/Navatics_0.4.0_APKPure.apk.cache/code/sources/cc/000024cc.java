package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.C2910ad;

/* compiled from: RouteDatabase.java */
/* renamed from: okhttp3.internal.connection.d, reason: use source file name */
/* loaded from: classes2.dex */
public final class RouteDatabase {

    /* renamed from: a */
    private final Set<C2910ad> f10285a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m10038a(C2910ad c2910ad) {
        this.f10285a.add(c2910ad);
    }

    /* renamed from: b */
    public synchronized void m10039b(C2910ad c2910ad) {
        this.f10285a.remove(c2910ad);
    }

    /* renamed from: c */
    public synchronized boolean m10040c(C2910ad c2910ad) {
        return this.f10285a.contains(c2910ad);
    }
}