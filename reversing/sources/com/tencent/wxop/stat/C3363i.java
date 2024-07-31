package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.p070a.p071a.p072a.p073a.C2400g;
import com.tencent.p070a.p071a.p072a.p073a.C2401h;
import com.tencent.wxop.stat.common.C2562e;
import com.tencent.wxop.stat.common.C2563f;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.AbstractC2582e;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Priority;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.i */
/* loaded from: classes2.dex */
public class C2592i {

    /* renamed from: d */
    private static StatLogger f8141d = C2569l.m4837b();

    /* renamed from: e */
    private static C2592i f8142e = null;

    /* renamed from: f */
    private static Context f8143f = null;

    /* renamed from: a */
    DefaultHttpClient f8144a;

    /* renamed from: b */
    C2562e f8145b;

    /* renamed from: c */
    StringBuilder f8146c = new StringBuilder(4096);

    /* renamed from: g */
    private long f8147g;

    private C2592i(Context context) {
        this.f8144a = null;
        this.f8145b = null;
        this.f8147g = 0L;
        try {
            f8143f = context.getApplicationContext();
            this.f8147g = System.currentTimeMillis() / 1000;
            this.f8145b = new C2562e();
            if (StatConfig.isDebugEnable()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable unused) {
                }
            }
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, Priority.DEBUG_INT);
            HttpConnectionParams.setSoTimeout(basicHttpParams, Priority.DEBUG_INT);
            this.f8144a = new DefaultHttpClient(basicHttpParams);
            this.f8144a.setKeepAliveStrategy(new C2593j(this));
        } catch (Throwable th) {
            f8141d.m4878e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Context m4756a() {
        return f8143f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4755a(Context context) {
        f8143f = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m4752a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("mid");
            if (C2401h.m5556b(optString)) {
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = f8141d;
                    statLogger.m4877i("update mid:" + optString);
                }
                C2400g.m5565a(f8143f).m5564a(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                StatConfig.m4983a(f8143f, jSONObject.getJSONObject("cfg"));
            }
            if (jSONObject.isNull("ncts")) {
                return;
            }
            int i = jSONObject.getInt("ncts");
            int currentTimeMillis = (int) (i - (System.currentTimeMillis() / 1000));
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger2 = f8141d;
                statLogger2.m4877i("server time:" + i + ", diff time:" + currentTimeMillis);
            }
            C2569l.m4806x(f8143f);
            C2569l.m4844a(f8143f, currentTimeMillis);
        } catch (Throwable th) {
            f8141d.m4875w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static C2592i m4751b(Context context) {
        if (f8142e == null) {
            synchronized (C2592i.class) {
                if (f8142e == null) {
                    f8142e = new C2592i(context);
                }
            }
        }
        return f8142e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4754a(AbstractC2582e abstractC2582e, InterfaceC2591h interfaceC2591h) {
        m4750b(Arrays.asList(abstractC2582e.m4766g()), interfaceC2591h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4753a(List<?> list, InterfaceC2591h interfaceC2591h) {
        ByteArrayOutputStream byteArrayOutputStream;
        HttpResponse execute;
        HttpEntity entity;
        int statusCode;
        int i;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        list.get(0);
        try {
            this.f8146c.delete(0, this.f8146c.length());
            this.f8146c.append("[");
            for (int i2 = 0; i2 < size; i2++) {
                this.f8146c.append(list.get(i2).toString());
                if (i2 != size - 1) {
                    this.f8146c.append(",");
                }
            }
            this.f8146c.append("]");
            String sb = this.f8146c.toString();
            int length = sb.length();
            String str = StatConfig.getStatReportUrl() + "/?index=" + this.f8147g;
            this.f8147g++;
            if (StatConfig.isDebugEnable()) {
                f8141d.m4877i("[" + str + "]Send request(" + length + "bytes), content:" + sb);
            }
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader("Accept-Encoding", "gzip");
            httpPost.setHeader("Connection", "Keep-Alive");
            httpPost.removeHeaders("Cache-Control");
            HttpHost m4945a = C2525a.m4944a(f8143f).m4945a();
            httpPost.addHeader("Content-Encoding", "rc4");
            if (m4945a == null) {
                this.f8144a.getParams().removeParameter("http.route.default-proxy");
            } else {
                if (StatConfig.isDebugEnable()) {
                    f8141d.m4880d("proxy:" + m4945a.toHostString());
                }
                httpPost.addHeader("X-Content-Encoding", "rc4");
                this.f8144a.getParams().setParameter("http.route.default-proxy", m4945a);
                httpPost.addHeader("X-Online-Host", StatConfig.f7868k);
                httpPost.addHeader("Accept", "*/*");
                httpPost.addHeader("Content-Type", "json");
            }
            byteArrayOutputStream = new ByteArrayOutputStream(length);
            byte[] bytes = sb.getBytes("UTF-8");
            int length2 = bytes.length;
            if (length > StatConfig.f7872o) {
                httpPost.removeHeaders("Content-Encoding");
                String str2 = "rc4,gzip";
                httpPost.addHeader("Content-Encoding", str2);
                if (m4945a != null) {
                    httpPost.removeHeaders("X-Content-Encoding");
                    httpPost.addHeader("X-Content-Encoding", str2);
                }
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length2);
                if (StatConfig.isDebugEnable()) {
                    f8141d.m4880d("before Gzip:" + length2 + " bytes, after Gzip:" + bytes.length + " bytes");
                }
            }
            httpPost.setEntity(new ByteArrayEntity(C2563f.m4863a(bytes)));
            execute = this.f8144a.execute(httpPost);
            entity = execute.getEntity();
            statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            if (StatConfig.isDebugEnable()) {
                f8141d.m4877i("http recv response status code:" + statusCode + ", content length:" + contentLength);
            }
            i = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
        } catch (Throwable th) {
            th = th;
        }
        if (i <= 0) {
            f8141d.m4879e("Server response no data.");
            if (interfaceC2591h != null) {
                interfaceC2591h.mo4748b();
            }
            EntityUtils.toString(entity);
            return;
        }
        if (i > 0) {
            InputStream content = entity.getContent();
            DataInputStream dataInputStream = new DataInputStream(content);
            byte[] bArr = new byte[(int) entity.getContentLength()];
            dataInputStream.readFully(bArr);
            content.close();
            dataInputStream.close();
            Header firstHeader = execute.getFirstHeader("Content-Encoding");
            if (firstHeader != null) {
                if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                    bArr = C2563f.m4861b(C2569l.m4838a(bArr));
                } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                    bArr = C2569l.m4838a(C2563f.m4861b(bArr));
                } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                    bArr = C2569l.m4838a(bArr);
                } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                    bArr = C2563f.m4861b(bArr);
                }
            }
            String str3 = new String(bArr, "UTF-8");
            if (StatConfig.isDebugEnable()) {
                f8141d.m4877i("http get response data:" + str3);
            }
            JSONObject jSONObject = new JSONObject(str3);
            if (statusCode == 200) {
                m4752a(jSONObject);
                if (interfaceC2591h != null) {
                    if (jSONObject.optInt("ret") == 0) {
                        interfaceC2591h.mo4749a();
                    } else {
                        f8141d.error("response error data.");
                        interfaceC2591h.mo4748b();
                    }
                }
                content.close();
            } else {
                f8141d.error("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                if (interfaceC2591h != null) {
                    interfaceC2591h.mo4748b();
                }
                content.close();
            }
        } else {
            EntityUtils.toString(entity);
        }
        byteArrayOutputStream.close();
        th = null;
        if (th != null) {
            f8141d.error(th);
            if (interfaceC2591h != null) {
                try {
                    interfaceC2591h.mo4748b();
                } catch (Throwable th2) {
                    f8141d.m4878e(th2);
                }
            }
            if (th instanceof OutOfMemoryError) {
                System.gc();
                this.f8146c = null;
                this.f8146c = new StringBuilder(2048);
            }
            C2525a.m4944a(f8143f).m4938d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m4750b(List<?> list, InterfaceC2591h interfaceC2591h) {
        C2562e c2562e = this.f8145b;
        if (c2562e != null) {
            c2562e.m4865a(new RunnableC2594k(this, list, interfaceC2591h));
        }
    }
}
