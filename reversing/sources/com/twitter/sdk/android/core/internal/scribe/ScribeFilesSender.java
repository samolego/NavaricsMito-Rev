package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.text.TextUtils;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.IdManager;
import com.twitter.sdk.android.core.internal.p078a.GuestAuthInterceptor;
import com.twitter.sdk.android.core.internal.p078a.OAuth1aInterceptor;
import com.twitter.sdk.android.core.internal.p078a.OkHttpClientHelper;
import com.twitter.sdk.android.core.internal.scribe.QueueFile;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.C2993z;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.C3204l;
import retrofit2.InterfaceC3169b;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ScribeFilesSender implements FilesSender {

    /* renamed from: a */
    private static final byte[] f8568a = {91};

    /* renamed from: b */
    private static final byte[] f8569b = {44};

    /* renamed from: c */
    private static final byte[] f8570c = {93};

    /* renamed from: d */
    private final Context f8571d;

    /* renamed from: e */
    private final ScribeConfig f8572e;

    /* renamed from: f */
    private final long f8573f;

    /* renamed from: g */
    private final TwitterAuthConfig f8574g;

    /* renamed from: h */
    private final SessionManager<? extends Session<TwitterAuthToken>> f8575h;

    /* renamed from: i */
    private final GuestSessionProvider f8576i;

    /* renamed from: j */
    private final AtomicReference<ScribeService> f8577j = new AtomicReference<>();

    /* renamed from: k */
    private final ExecutorService f8578k;

    /* renamed from: l */
    private final IdManager f8579l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ScribeService {
        @FormUrlEncoded
        @Headers(m116a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @POST(m113a = "/{version}/jot/{type}")
        InterfaceC3169b<ResponseBody> upload(@Path(m108a = "version") String str, @Path(m108a = "type") String str2, @Field(m125a = "log[]") String str3);

        @FormUrlEncoded
        @Headers(m116a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @POST(m113a = "/scribe/{sequence}")
        InterfaceC3169b<ResponseBody> uploadSequence(@Path(m108a = "sequence") String str, @Field(m125a = "log[]") String str2);
    }

    public ScribeFilesSender(Context context, ScribeConfig scribeConfig, long j, TwitterAuthConfig twitterAuthConfig, SessionManager<? extends Session<TwitterAuthToken>> sessionManager, GuestSessionProvider guestSessionProvider, ExecutorService executorService, IdManager idManager) {
        this.f8571d = context;
        this.f8572e = scribeConfig;
        this.f8573f = j;
        this.f8574g = twitterAuthConfig;
        this.f8575h = sessionManager;
        this.f8576i = guestSessionProvider;
        this.f8578k = executorService;
        this.f8579l = idManager;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.FilesSender
    /* renamed from: a */
    public boolean mo4321a(List<File> list) {
        if (m4370c()) {
            try {
                String m4371b = m4371b(list);
                CommonUtils.m4454a(this.f8571d, m4371b);
                C3204l<ResponseBody> m4373a = m4373a(m4371b);
                if (m4373a.m73a() == 200) {
                    return true;
                }
                CommonUtils.m4452a(this.f8571d, "Failed sending files", (Throwable) null);
                if (m4373a.m73a() != 500) {
                    if (m4373a.m73a() != 400) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                CommonUtils.m4452a(this.f8571d, "Failed sending files", e);
                return false;
            }
        }
        CommonUtils.m4454a(this.f8571d, "Cannot attempt upload at this time");
        return false;
    }

    /* renamed from: b */
    String m4371b(List<File> list) throws IOException {
        QueueFile queueFile;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        final boolean[] zArr = new boolean[1];
        byteArrayOutputStream.write(f8568a);
        for (File file : list) {
            try {
                queueFile = new QueueFile(file);
            } catch (Throwable th) {
                th = th;
                queueFile = null;
            }
            try {
                queueFile.m4315a(new QueueFile.InterfaceC2686c() { // from class: com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender.1
                    @Override // com.twitter.sdk.android.core.internal.scribe.QueueFile.InterfaceC2686c
                    /* renamed from: a */
                    public void mo4295a(InputStream inputStream, int i) throws IOException {
                        byte[] bArr = new byte[i];
                        inputStream.read(bArr);
                        boolean[] zArr2 = zArr;
                        if (zArr2[0]) {
                            byteArrayOutputStream.write(ScribeFilesSender.f8569b);
                        } else {
                            zArr2[0] = true;
                        }
                        byteArrayOutputStream.write(bArr);
                    }
                });
                CommonUtils.m4450a(queueFile);
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m4450a(queueFile);
                throw th;
            }
        }
        byteArrayOutputStream.write(f8570c);
        return byteArrayOutputStream.toString("UTF-8");
    }

    /* renamed from: c */
    private boolean m4370c() {
        return m4376a() != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    synchronized ScribeService m4376a() {
        OkHttpClient m2372a;
        if (this.f8577j.get() == null) {
            Session m4375a = m4375a(this.f8573f);
            if (m4374a(m4375a)) {
                m2372a = new OkHttpClient.C2991a().m2367a(OkHttpClientHelper.m4493a()).m2366a(new C2675a(this.f8572e, this.f8579l)).m2366a(new OAuth1aInterceptor(m4375a, this.f8574g)).m2372a();
            } else {
                m2372a = new OkHttpClient.C2991a().m2367a(OkHttpClientHelper.m4493a()).m2366a(new C2675a(this.f8572e, this.f8579l)).m2366a(new GuestAuthInterceptor(this.f8576i)).m2372a();
            }
            this.f8577j.compareAndSet(null, new Retrofit.C3206a().m52a(this.f8572e.f8662b).m48a(m2372a).m53a().m64a(ScribeService.class));
        }
        return this.f8577j.get();
    }

    /* renamed from: a */
    private Session m4375a(long j) {
        return this.f8575h.mo4268a(j);
    }

    /* renamed from: a */
    private boolean m4374a(Session session) {
        return (session == null || session.m4270a() == null) ? false : true;
    }

    /* renamed from: a */
    C3204l<ResponseBody> m4373a(String str) throws IOException {
        ScribeService m4376a = m4376a();
        if (!TextUtils.isEmpty(this.f8572e.f8665e)) {
            return m4376a.uploadSequence(this.f8572e.f8665e, str).mo142a();
        }
        return m4376a.upload(this.f8572e.f8663c, this.f8572e.f8664d, str).mo142a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender$a */
    /* loaded from: classes2.dex */
    public static class C2675a implements Interceptor {

        /* renamed from: a */
        private final ScribeConfig f8583a;

        /* renamed from: b */
        private final IdManager f8584b;

        C2675a(ScribeConfig scribeConfig, IdManager idManager) {
            this.f8583a = scribeConfig;
            this.f8584b = idManager;
        }

        @Override // okhttp3.Interceptor
        /* renamed from: a */
        public Response mo2429a(Interceptor.InterfaceC2987a interfaceC2987a) throws IOException {
            C2993z.C2994a m2345e = interfaceC2987a.mo2428a().m2345e();
            if (!TextUtils.isEmpty(this.f8583a.f8666f)) {
                m2345e.m2340a("User-Agent", this.f8583a.f8666f);
            }
            if (!TextUtils.isEmpty(this.f8584b.m4439a())) {
                m2345e.m2340a("X-Client-UUID", this.f8584b.m4439a());
            }
            m2345e.m2340a("X-Twitter-Polling", "true");
            return interfaceC2987a.mo2427a(m2345e.m2342a());
        }
    }
}
