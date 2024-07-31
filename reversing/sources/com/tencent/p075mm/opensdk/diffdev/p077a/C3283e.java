package com.tencent.p075mm.opensdk.diffdev.p077a;

import com.tencent.p075mm.opensdk.utils.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.e */
/* loaded from: classes2.dex */
public final class C2512e {
    /* renamed from: h */
    public static byte[] m5008h(String str) {
        if (str == null || str.length() == 0) {
            Log.m5000e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return null;
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(str);
        try {
            HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), 60000);
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            if (execute.getStatusLine().getStatusCode() != 200) {
                Log.m5000e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
                return null;
            }
            return EntityUtils.toByteArray(execute.getEntity());
        } catch (Exception e) {
            Log.m5000e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
            return null;
        } catch (IncompatibleClassChangeError e2) {
            Log.m5000e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
            return null;
        } catch (Throwable th) {
            Log.m5000e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
            return null;
        }
    }
}
