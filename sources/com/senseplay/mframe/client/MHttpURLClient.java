package com.senseplay.mframe.client;

import com.senseplay.mframe.tool.MDebug;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes2.dex */
class MHttpURLClient {
    static String Method_Del = "DELETE";
    static String Method_Post = "POST";
    static String Method_Put = "PUT";
    private static final String TAG = "MHttpURLClient";
    private final int type_get = 1;
    private final int type_post = 2;

    MHttpURLClient() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b5, code lost:
        if (r4 == null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String requestGet(java.lang.String r4, java.util.HashMap<java.lang.String, java.lang.String> r5) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r2.<init>()     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r2.append(r4)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r4 = 0
            java.lang.String r4 = getParams(r5, r4)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r2.append(r4)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.lang.String r5 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r2.<init>()     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.lang.String r3 = "Get--->"
            r2.append(r3)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r2.append(r4)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            com.senseplay.mframe.tool.MDebug.m5827d(r5, r2)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.net.URL r5 = new java.net.URL     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r5.<init>(r4)     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.net.URLConnection r4 = r5.openConnection()     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> La5 java.lang.Error -> La8 java.lang.Exception -> Lb0
            r5 = 5000(0x1388, float:7.006E-42)
            r4.setConnectTimeout(r5)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r4.setReadTimeout(r5)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r5 = 1
            r4.setUseCaches(r5)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r5 = "GET"
            r4.setRequestMethod(r5)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r5 = "Content-Type"
            java.lang.String r2 = "application/json"
            r4.setRequestProperty(r5, r2)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r5 = "Connection"
            java.lang.String r2 = "Keep-Alive"
            r4.addRequestProperty(r5, r2)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r4.connect()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            int r5 = r4.getResponseCode()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r2 = 200(0xc8, float:2.8E-43)
            if (r5 != r2) goto L81
            java.io.InputStream r5 = r4.getInputStream()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r0 = com.senseplay.mframe.tool.MUtilTool.streamToString(r5)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r5 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r2.<init>()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r3 = "Get Succ，result--->\n"
            r2.append(r3)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r2.append(r0)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            com.senseplay.mframe.tool.MDebug.m5827d(r5, r2)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            goto L9b
        L81:
            java.lang.String r5 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r2.<init>()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r3 = "Get Error "
            r2.append(r3)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            int r3 = r4.getResponseCode()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            r2.append(r3)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
            com.senseplay.mframe.tool.MDebug.m5825e(r5, r2)     // Catch: java.lang.Error -> La1 java.lang.Exception -> La3 java.lang.Throwable -> Lbb
        L9b:
            if (r4 == 0) goto La0
            r4.disconnect()
        La0:
            return r0
        La1:
            r5 = move-exception
            goto Laa
        La3:
            r5 = move-exception
            goto Lb2
        La5:
            r5 = move-exception
            r4 = r1
            goto Lbc
        La8:
            r5 = move-exception
            r4 = r1
        Laa:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
            if (r4 == 0) goto Lba
            goto Lb7
        Lb0:
            r5 = move-exception
            r4 = r1
        Lb2:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> Lbb
            if (r4 == 0) goto Lba
        Lb7:
            r4.disconnect()
        Lba:
            return r1
        Lbb:
            r5 = move-exception
        Lbc:
            if (r4 == 0) goto Lc1
            r4.disconnect()
        Lc1:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.senseplay.mframe.client.MHttpURLClient.requestGet(java.lang.String, java.util.HashMap):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c5, code lost:
        if (r6 == null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String requestPost(java.lang.String r5, java.lang.String r6, java.util.HashMap<java.lang.String, java.lang.String> r7) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "MHttpURLClient"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            r3.<init>()     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            r3.append(r5)     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            java.lang.String r4 = "--->"
            r3.append(r4)     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            r3.append(r6)     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            com.senseplay.mframe.tool.MDebug.m5827d(r2, r3)     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            r2 = 1
            java.lang.String r7 = getParams(r7, r2)     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            byte[] r7 = r7.getBytes()     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            r3.<init>(r6)     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            java.net.URLConnection r6 = r3.openConnection()     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> Lb5 java.lang.Error -> Lb8 java.lang.Exception -> Lc0
            r3 = 5000(0x1388, float:7.006E-42)
            r6.setConnectTimeout(r3)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r6.setReadTimeout(r3)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r6.setDoOutput(r2)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r6.setDoInput(r2)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r3 = 0
            r6.setUseCaches(r3)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r6.setRequestMethod(r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r6.setInstanceFollowRedirects(r2)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r6.setRequestProperty(r2, r3)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r6.connect()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.io.OutputStream r3 = r6.getOutputStream()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.<init>(r3)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.write(r7)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.flush()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.close()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            int r7 = r6.getResponseCode()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2 = 200(0xc8, float:2.8E-43)
            if (r7 != r2) goto L8e
            java.io.InputStream r7 = r6.getInputStream()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r0 = com.senseplay.mframe.tool.MUtilTool.streamToString(r7)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r7 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.<init>()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.append(r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r5 = " Succ，result--->\n"
            r2.append(r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.append(r0)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            com.senseplay.mframe.tool.MDebug.m5827d(r7, r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            goto Lab
        L8e:
            java.lang.String r7 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.<init>()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.append(r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r5 = " Error "
            r2.append(r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            int r5 = r6.getResponseCode()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            r2.append(r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
            com.senseplay.mframe.tool.MDebug.m5825e(r7, r5)     // Catch: java.lang.Error -> Lb1 java.lang.Exception -> Lb3 java.lang.Throwable -> Lcb
        Lab:
            if (r6 == 0) goto Lb0
            r6.disconnect()
        Lb0:
            return r0
        Lb1:
            r5 = move-exception
            goto Lba
        Lb3:
            r5 = move-exception
            goto Lc2
        Lb5:
            r5 = move-exception
            r6 = r1
            goto Lcc
        Lb8:
            r5 = move-exception
            r6 = r1
        Lba:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> Lcb
            if (r6 == 0) goto Lca
            goto Lc7
        Lc0:
            r5 = move-exception
            r6 = r1
        Lc2:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> Lcb
            if (r6 == 0) goto Lca
        Lc7:
            r6.disconnect()
        Lca:
            return r1
        Lcb:
            r5 = move-exception
        Lcc:
            if (r6 == 0) goto Ld1
            r6.disconnect()
        Ld1:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.senseplay.mframe.client.MHttpURLClient.requestPost(java.lang.String, java.lang.String, java.util.HashMap):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
        if (r5 == null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c7  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String requestPut(java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.String> r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "MHttpURLClient"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            r3.<init>()     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            java.lang.String r4 = "Post--->"
            r3.append(r4)     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            r3.append(r5)     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            com.senseplay.mframe.tool.MDebug.m5827d(r2, r3)     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            r2 = 1
            java.lang.String r6 = getParams(r6, r2)     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            r3.<init>(r5)     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            java.net.URLConnection r5 = r3.openConnection()     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> Lae java.lang.Error -> Lb1 java.lang.Exception -> Lb9
            r3 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r5.setReadTimeout(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r5.setDoOutput(r2)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r5.setDoInput(r2)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r3 = 0
            r5.setUseCaches(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r3 = "PUT"
            r5.setRequestMethod(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r5.setInstanceFollowRedirects(r2)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r5.setRequestProperty(r2, r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r5.connect()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.io.OutputStream r3 = r5.getOutputStream()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.<init>(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.write(r6)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.flush()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.close()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            int r6 = r5.getResponseCode()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L8a
            java.io.InputStream r6 = r5.getInputStream()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r0 = com.senseplay.mframe.tool.MUtilTool.streamToString(r6)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r6 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.<init>()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r3 = "Post Succ，result--->\n"
            r2.append(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.append(r0)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            com.senseplay.mframe.tool.MDebug.m5827d(r6, r2)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            goto La4
        L8a:
            java.lang.String r6 = "MHttpURLClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.<init>()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r3 = "Post Error "
            r2.append(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            int r3 = r5.getResponseCode()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            r2.append(r3)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
            com.senseplay.mframe.tool.MDebug.m5825e(r6, r2)     // Catch: java.lang.Error -> Laa java.lang.Exception -> Lac java.lang.Throwable -> Lc4
        La4:
            if (r5 == 0) goto La9
            r5.disconnect()
        La9:
            return r0
        Laa:
            r6 = move-exception
            goto Lb3
        Lac:
            r6 = move-exception
            goto Lbb
        Lae:
            r6 = move-exception
            r5 = r1
            goto Lc5
        Lb1:
            r6 = move-exception
            r5 = r1
        Lb3:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Lc4
            if (r5 == 0) goto Lc3
            goto Lc0
        Lb9:
            r6 = move-exception
            r5 = r1
        Lbb:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Lc4
            if (r5 == 0) goto Lc3
        Lc0:
            r5.disconnect()
        Lc3:
            return r1
        Lc4:
            r6 = move-exception
        Lc5:
            if (r5 == 0) goto Lca
            r5.disconnect()
        Lca:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.senseplay.mframe.client.MHttpURLClient.requestPut(java.lang.String, java.util.HashMap):java.lang.String");
    }

    private static String getParams(HashMap<String, String> hashMap, int i) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        String str = i == 0 ? LocationInfo.f11272NA : "";
        try {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str2 : hashMap.keySet()) {
                if (i2 > 0) {
                    sb.append("&");
                }
                MDebug.m5827d(TAG, "key :" + str2 + "value : " + hashMap.get(str2));
                sb.append(String.format("%s=%s", str2, URLEncoder.encode(hashMap.get(str2), "utf-8")));
                i2++;
            }
            return str + sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (Error e2) {
            MDebug.m5825e(TAG, e2.toString());
            return "";
        }
    }
}
