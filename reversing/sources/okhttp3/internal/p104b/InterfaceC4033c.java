package okhttp3.internal.p104b;

import java.io.IOException;
import okhttp3.C2993z;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Sink;

/* renamed from: okhttp3.internal.b.c */
/* loaded from: classes2.dex */
public interface HttpCodec {
    /* renamed from: a */
    Response.C2912a mo2714a(boolean z) throws IOException;

    /* renamed from: a */
    ResponseBody mo2717a(Response response) throws IOException;

    /* renamed from: a */
    Sink mo2715a(C2993z c2993z, long j);

    /* renamed from: a */
    void mo2719a() throws IOException;

    /* renamed from: a */
    void mo2716a(C2993z c2993z) throws IOException;

    /* renamed from: b */
    void mo2713b() throws IOException;

    /* renamed from: c */
    void mo2711c();
}
