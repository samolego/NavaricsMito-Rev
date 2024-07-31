package com.navatics.app.utils;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.C2993z;
import okhttp3.Call;
import okhttp3.InterfaceC2919f;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: com.navatics.app.utils.n */
/* loaded from: classes.dex */
public class OkHttpStreamFetcher implements DataFetcher<InputStream>, InterfaceC2919f {

    /* renamed from: a */
    private final Call.InterfaceC2918a f5134a;

    /* renamed from: b */
    private final GlideUrl f5135b;

    /* renamed from: c */
    private InputStream f5136c;

    /* renamed from: d */
    private ResponseBody f5137d;

    /* renamed from: e */
    private DataFetcher.InterfaceC0615a<? super InputStream> f5138e;

    /* renamed from: f */
    private volatile Call f5139f;

    public OkHttpStreamFetcher(Call.InterfaceC2918a interfaceC2918a, GlideUrl glideUrl) {
        this.f5134a = interfaceC2918a;
        this.f5135b = glideUrl;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: a */
    public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super InputStream> interfaceC0615a) {
        C2993z.C2994a m2341a = new C2993z.C2994a().m2341a(this.f5135b.m12342b());
        for (Map.Entry<String, String> entry : this.f5135b.m12341c().entrySet()) {
            m2341a.m2335b(entry.getKey(), entry.getValue());
        }
        C2993z m2342a = m2341a.m2342a();
        this.f5138e = interfaceC0615a;
        this.f5139f = this.f5134a.mo2407a(m2342a);
        this.f5139f.mo2363a(this);
    }

    @Override // okhttp3.InterfaceC2919f
    /* renamed from: a */
    public void mo133a(@NonNull Call call, @NonNull IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f5138e.mo12020a((Exception) iOException);
    }

    @Override // okhttp3.InterfaceC2919f
    /* renamed from: a */
    public void mo132a(@NonNull Call call, @NonNull Response response) {
        this.f5137d = response.m3026g();
        if (response.m3030c()) {
            this.f5136c = ContentLengthInputStream.m11600a(this.f5137d.m3002c(), ((ResponseBody) Preconditions.m11580a(this.f5137d)).mo128b());
            this.f5138e.mo12019a((DataFetcher.InterfaceC0615a<? super InputStream>) this.f5136c);
            return;
        }
        this.f5138e.mo12020a((Exception) new HttpException(response.m3029d(), response.m3031b()));
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: b */
    public void mo7364b() {
        try {
            if (this.f5136c != null) {
                this.f5136c.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f5137d;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f5138e = null;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: c */
    public void mo7363c() {
        Call call = this.f5139f;
        if (call != null) {
            call.mo2360b();
        }
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo7366a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    @NonNull
    /* renamed from: d */
    public DataSource mo7362d() {
        return DataSource.REMOTE;
    }
}
