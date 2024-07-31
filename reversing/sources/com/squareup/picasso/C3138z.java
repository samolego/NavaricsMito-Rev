package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.squareup.picasso.Downloader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Priority;

/* renamed from: com.squareup.picasso.z */
/* loaded from: classes2.dex */
public class UrlConnectionDownloader implements Downloader {

    /* renamed from: a */
    static volatile Object f7059a;

    /* renamed from: b */
    private static final Object f7060b = new Object();

    /* renamed from: c */
    private static final ThreadLocal<StringBuilder> f7061c = new ThreadLocal<StringBuilder>() { // from class: com.squareup.picasso.z.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    /* renamed from: d */
    private final Context f7062d;

    public UrlConnectionDownloader(Context context) {
        this.f7062d = context.getApplicationContext();
    }

    /* renamed from: a */
    protected HttpURLConnection m5614a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(Priority.INFO_INT);
        return httpURLConnection;
    }

    @Override // com.squareup.picasso.Downloader
    /* renamed from: a */
    public Downloader.C2335a mo5613a(Uri uri, int i) throws IOException {
        String sb;
        if (Build.VERSION.SDK_INT >= 14) {
            m5615a(this.f7062d);
        }
        HttpURLConnection m5614a = m5614a(uri);
        m5614a.setUseCaches(true);
        if (i != 0) {
            if (NetworkPolicy.isOfflineOnly(i)) {
                sb = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb2 = f7061c.get();
                sb2.setLength(0);
                if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                    sb2.append("no-cache");
                }
                if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                    if (sb2.length() > 0) {
                        sb2.append(',');
                    }
                    sb2.append("no-store");
                }
                sb = sb2.toString();
            }
            m5614a.setRequestProperty("Cache-Control", sb);
        }
        int responseCode = m5614a.getResponseCode();
        if (responseCode >= 300) {
            m5614a.disconnect();
            throw new Downloader.ResponseException(responseCode + " " + m5614a.getResponseMessage(), i, responseCode);
        }
        return new Downloader.C2335a(m5614a.getInputStream(), C2344aa.m5756a(m5614a.getHeaderField("X-Android-Response-Source")), m5614a.getHeaderFieldInt("Content-Length", -1));
    }

    /* renamed from: a */
    private static void m5615a(Context context) {
        if (f7059a == null) {
            try {
                synchronized (f7060b) {
                    if (f7059a == null) {
                        f7059a = C2374a.m5611a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UrlConnectionDownloader.java */
    /* renamed from: com.squareup.picasso.z$a */
    /* loaded from: classes2.dex */
    public static class C2374a {
        /* renamed from: a */
        static Object m5611a(Context context) throws IOException {
            File m5752b = C2344aa.m5752b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(m5752b, C2344aa.m5759a(m5752b)) : installed;
        }
    }
}
