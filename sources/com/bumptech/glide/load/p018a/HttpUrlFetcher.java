package com.bumptech.glide.load.p018a;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.p018a.DataFetcher;
import com.bumptech.glide.load.p020b.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.a.j */
/* loaded from: classes.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting

    /* renamed from: a */
    static final InterfaceC0620b f580a = new C0619a();

    /* renamed from: b */
    private final GlideUrl f581b;

    /* renamed from: c */
    private final int f582c;

    /* renamed from: d */
    private final InterfaceC0620b f583d;

    /* renamed from: e */
    private HttpURLConnection f584e;

    /* renamed from: f */
    private InputStream f585f;

    /* renamed from: g */
    private volatile boolean f586g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: com.bumptech.glide.load.a.j$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0620b {
        /* renamed from: a */
        HttpURLConnection mo12396a(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, f580a);
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl, int i, InterfaceC0620b interfaceC0620b) {
        this.f581b = glideUrl;
        this.f582c = i;
        this.f583d = interfaceC0620b;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: a */
    public void mo7365a(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC0615a<? super InputStream> interfaceC0615a) {
        String str;
        StringBuilder sb;
        long m11595a = LogTime.m11595a();
        try {
            try {
                interfaceC0615a.mo12019a((DataFetcher.InterfaceC0615a<? super InputStream>) m12398a(this.f581b.m12343a(), 0, null, this.f581b.m12341c()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                interfaceC0615a.mo12020a((Exception) e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                str = "HttpUrlFetcher";
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                str = "HttpUrlFetcher";
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.m11594a(m11595a));
                Log.v(str, sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.m11594a(m11595a));
            }
            throw th;
        }
    }

    /* renamed from: a */
    private InputStream m12398a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f584e = this.f583d.mo12396a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f584e.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f584e.setConnectTimeout(this.f582c);
        this.f584e.setReadTimeout(this.f582c);
        this.f584e.setUseCaches(false);
        this.f584e.setDoInput(true);
        this.f584e.setInstanceFollowRedirects(false);
        this.f584e.connect();
        this.f585f = this.f584e.getInputStream();
        if (this.f586g) {
            return null;
        }
        int responseCode = this.f584e.getResponseCode();
        if (m12400a(responseCode)) {
            return m12399a(this.f584e);
        }
        if (!m12397b(responseCode)) {
            if (responseCode == -1) {
                throw new HttpException(responseCode);
            }
            throw new HttpException(this.f584e.getResponseMessage(), responseCode);
        }
        String headerField = this.f584e.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpException("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        mo7364b();
        return m12398a(url3, i + 1, url, map);
    }

    /* renamed from: a */
    private static boolean m12400a(int i) {
        return i / 100 == 2;
    }

    /* renamed from: b */
    private static boolean m12397b(int i) {
        return i / 100 == 3;
    }

    /* renamed from: a */
    private InputStream m12399a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f585f = ContentLengthInputStream.m11600a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f585f = httpURLConnection.getInputStream();
        }
        return this.f585f;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: b */
    public void mo7364b() {
        InputStream inputStream = this.f585f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f584e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f584e = null;
    }

    @Override // com.bumptech.glide.load.p018a.DataFetcher
    /* renamed from: c */
    public void mo7363c() {
        this.f586g = true;
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

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: com.bumptech.glide.load.a.j$a */
    /* loaded from: classes.dex */
    private static class C0619a implements InterfaceC0620b {
        C0619a() {
        }

        @Override // com.bumptech.glide.load.p018a.HttpUrlFetcher.InterfaceC0620b
        /* renamed from: a */
        public HttpURLConnection mo12396a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }
}
