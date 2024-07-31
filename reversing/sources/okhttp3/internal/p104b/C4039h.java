package okhttp3.internal.p104b;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* renamed from: okhttp3.internal.b.h */
/* loaded from: classes2.dex */
public final class RealResponseBody extends ResponseBody {
    @Nullable

    /* renamed from: a */
    private final String f10168a;

    /* renamed from: b */
    private final long f10169b;

    /* renamed from: c */
    private final BufferedSource f10170c;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f10168a = str;
        this.f10169b = j;
        this.f10170c = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: a */
    public MediaType mo129a() {
        String str = this.f10168a;
        if (str != null) {
            return MediaType.m2418b(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: b */
    public long mo128b() {
        return this.f10169b;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: d */
    public BufferedSource mo127d() {
        return this.f10170c;
    }
}
