package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* renamed from: okhttp3.u */
/* loaded from: classes2.dex */
public interface Interceptor {

    /* compiled from: Interceptor.java */
    /* renamed from: okhttp3.u$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2987a {
        /* renamed from: a */
        Response mo2427a(C2993z c2993z) throws IOException;

        /* renamed from: a */
        C2993z mo2428a();

        @Nullable
        /* renamed from: b */
        Connection mo2426b();

        /* renamed from: c */
        int mo2425c();

        /* renamed from: d */
        int mo2424d();

        /* renamed from: e */
        int mo2423e();
    }

    /* renamed from: a */
    Response mo2429a(InterfaceC2987a interfaceC2987a) throws IOException;
}
