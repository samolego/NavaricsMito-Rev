package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* renamed from: okhttp3.internal.connection.d */
/* loaded from: classes2.dex */
public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f10244a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m2832a(Route route) {
        this.f10244a.add(route);
    }

    /* renamed from: b */
    public synchronized void m2831b(Route route) {
        this.f10244a.remove(route);
    }

    /* renamed from: c */
    public synchronized boolean m2830c(Route route) {
        return this.f10244a.contains(route);
    }
}
