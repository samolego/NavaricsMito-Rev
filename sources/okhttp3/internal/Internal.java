package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.C2984s;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;

/* renamed from: okhttp3.internal.a */
/* loaded from: classes2.dex */
public abstract class Internal {

    /* renamed from: a */
    public static Internal f10101a;

    /* renamed from: a */
    public abstract int mo2381a(Response.C2912a c2912a);

    /* renamed from: a */
    public abstract Socket mo2379a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    /* renamed from: a */
    public abstract RealConnection mo2378a(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    /* renamed from: a */
    public abstract RouteDatabase mo2380a(ConnectionPool connectionPool);

    /* renamed from: a */
    public abstract void mo2376a(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z);

    /* renamed from: a */
    public abstract void mo2375a(C2984s.C2985a c2985a, String str);

    /* renamed from: a */
    public abstract void mo2374a(C2984s.C2985a c2985a, String str, String str2);

    /* renamed from: a */
    public abstract boolean mo2382a(Address address, Address address2);

    /* renamed from: a */
    public abstract boolean mo2377a(ConnectionPool connectionPool, RealConnection realConnection);

    /* renamed from: b */
    public abstract void mo2373b(ConnectionPool connectionPool, RealConnection realConnection);
}
