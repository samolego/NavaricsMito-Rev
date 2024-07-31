package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: okhttp3.p */
/* loaded from: classes2.dex */
public abstract class EventListener {

    /* renamed from: a */
    public static final EventListener f10530a = new EventListener() { // from class: okhttp3.p.1
    };

    /* compiled from: EventListener.java */
    /* renamed from: okhttp3.p$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2982a {
        /* renamed from: a */
        EventListener mo2514a(Call call);
    }

    /* renamed from: a */
    public void m2535a(Call call) {
    }

    /* renamed from: a */
    public void m2534a(Call call, long j) {
    }

    /* renamed from: a */
    public void m2533a(Call call, IOException iOException) {
    }

    /* renamed from: a */
    public void m2532a(Call call, String str) {
    }

    /* renamed from: a */
    public void m2531a(Call call, String str, List<InetAddress> list) {
    }

    /* renamed from: a */
    public void m2530a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    /* renamed from: a */
    public void m2529a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
    }

    /* renamed from: a */
    public void m2528a(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
    }

    /* renamed from: a */
    public void m2527a(Call call, Response response) {
    }

    /* renamed from: a */
    public void m2526a(Call call, Connection connection) {
    }

    /* renamed from: a */
    public void m2525a(Call call, @Nullable Handshake handshake) {
    }

    /* renamed from: a */
    public void m2524a(Call call, C2993z c2993z) {
    }

    /* renamed from: b */
    public void m2522b(Call call) {
    }

    /* renamed from: b */
    public void m2521b(Call call, long j) {
    }

    /* renamed from: b */
    public void m2520b(Call call, Connection connection) {
    }

    /* renamed from: c */
    public void m2519c(Call call) {
    }

    /* renamed from: d */
    public void m2518d(Call call) {
    }

    /* renamed from: e */
    public void m2517e(Call call) {
    }

    /* renamed from: f */
    public void m2516f(Call call) {
    }

    /* renamed from: g */
    public void m2515g(Call call) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static InterfaceC2982a m2523a(EventListener eventListener) {
        return new InterfaceC2982a() { // from class: okhttp3.p.2
            @Override // okhttp3.EventListener.InterfaceC2982a
            /* renamed from: a */
            public EventListener mo2514a(Call call) {
                return EventListener.this;
            }
        };
    }
}
